/*
 * Copyright 2015-2017 JTS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.jts.decompiler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import ru.jts.decompiler.class_model.ClassMethod;
import ru.jts.decompiler.gameserver.ScalaMakerEventHandler;
import ru.jts.decompiler.gameserver.ScalaNpcEventHandler;
import ru.jts.decompiler.ll.AiClass;
import ru.jts.decompiler.ll.EventHandler;
import ru.jts.decompiler.ll.ParameterDefine;
import ru.jts.decompiler.ll.PropertyDefine;
import ru.jts.decompiler.ll.stack.*;
import ru.jts.decompiler.ll.stack.EventObject;
import ru.jts.decompiler.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

/**
 * Created by Дмитрий on 15.05.2015.
 */
@Service
public class LLParser {

    private static final Logger log = LoggerFactory.getLogger(LLParser.class);
    private final Map<String, StringObject> strings = new ConcurrentHashMap<>();

    @Autowired
    private DBClassRepository repository;

    @Async
    public Future<AiClass> processClass(int type, String className, String parent, String buf) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY - 1);
        log.info("Process class: " + className);
        AiClass ai_class = new AiClass(type, className, parent);

        try (BufferedReader classReader = new BufferedReader(new StringReader(buf))) {
            parseClass(ai_class, classReader);

            ai_class.restoreImports();
            ai_class.writeToFile();

            DBClassInfo classInfo = new DBClassInfo();
            classInfo.setName(ai_class.getClassName());
            classInfo.setParent(ai_class.getParent());

            for (PropertyDefine pd : ai_class.propertyDefines) {
                classInfo.getParameters().add(pd.getPropertyName());
            }

            for (ParameterDefine pd : ai_class.parameterDefines) {
                classInfo.getParameters().add(pd.getName());
            }

            repository.save(classInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new AsyncResult<>(ai_class);
    }

    private void parseClass(AiClass aiClass, BufferedReader br) throws IOException {
        String line;

        while ((line = br.readLine()) != null) {
            if (line.startsWith("parameter_define_begin")) {
                Set<ParameterDefine> parameterDefineList = readParameterDefines(line, br, aiClass);

                aiClass.setParameterDefines(parameterDefineList);
            } else if (line.startsWith("property_define_begin")) {
                List<PropertyDefine> propertyDefineList = readPropertyDefines(line, br, aiClass);
                aiClass.setPropertyDefines(propertyDefineList);
            } else if (line.startsWith("handler")) {
                EventHandler eventHandler = readEventHandler(line, br, aiClass);

                aiClass.addEventHandler(eventHandler);
            } else {
                log.error("Unknown line in LLParser.readClass(line):");
                log.error("Line: " + line);
            }
        }
    }

    private List<PropertyDefine> readPropertyDefines(String line, BufferedReader br, AiClass aiClass) throws IOException {
        List<PropertyDefine> properties = new ArrayList<>();
        while (!(line = br.readLine()).equals("property_define_end")) {
            PropertyDefine propertyDefine = null;
            if (line.startsWith("buyselllist_begin")) {
                String name = line.split(" ")[1];
                List<Object> list = new ArrayList<>();
                while (!(line = br.readLine()).equals("buyselllist_end")) {
                    line = line.substring(1, line.length() - 1);
                    String parts[] = line.split(";");

                    if (parts.length == 2) {
                        list.add(new BuySellItemInfo(Integer.parseInt(parts[0].trim()), Integer.parseInt(parts[1].trim())));
                    } else if (parts.length == 4) {
                        list.add(new BuySellItemInfo(Integer.parseInt(parts[0].trim()), Integer.parseInt(parts[1].trim()),
                                Double.parseDouble(parts[2].trim()), Integer.parseInt(parts[3].trim())));
                    } else {
                        log.error("LLParser.readPropertyDefines unknown buyselllist parameters count: " + parts.length);
                    }
                }

                propertyDefine = new PropertyDefine(name, list, BuySellItemInfo.class);
            } else if (line.startsWith("telposlist_begin")) {
                String name = line.split(" ")[1];
                List<Object> list = new ArrayList<>();
                while (!(line = br.readLine()).equals("telposlist_end")) {
                    line = line.substring(1, line.length() - 1);
                    String parts[] = line.split(";");
                    for (int i = 0; i < parts.length; i++) {
                        parts[i] = parts[i].trim();
                    }
                    if (parts.length == 6) {
                        list.add(new TelPosInfo(parts[0].substring(1, parts[0].length() - 1), Integer.parseInt(parts[1]),
                                Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[4])));
                    } else {
                        log.error("LLParser.readPropertyDefines unknown telposlist parameters count: " + parts.length);
                    }
                }

                propertyDefine = new PropertyDefine(name, list, TelPosInfo.class);
            } else {
                log.error("LLParser.readPropertyDefines unknown property: " + line);
            }

            String className = aiClass.getParent();
            boolean found = false;
            while (!(className.equals(ScalaMakerEventHandler.class.getSimpleName())
                    || className.equals(ScalaNpcEventHandler.class.getSimpleName()))) {
                while (!repository.exists(className)) {
                    try {
                        Thread.currentThread().sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                DBClassInfo classInfo = repository.findOne(className);
                if (classInfo.getParameters().contains(propertyDefine.getPropertyName())) {
                    found = true;
                }

                className = classInfo.getParent();

                if (found) break;
            }

            if (found)
                propertyDefine.override();

            properties.add(propertyDefine);
        }

        return properties;
    }

    private EventHandler readEventHandler(String line, BufferedReader br, AiClass aiClass) throws IOException {
        // handler 4 13	//  TALK_SELECTED
        String parts[] = line.split(" ");

        int handler = Integer.parseInt(parts[1]);

        int linesPointer = 0;
        String[] lines = new String[Integer.parseInt(parts[2])];

        aiClass.eventHandler = new EventHandler(aiClass.type, handler, aiClass);
        aiClass.handler = handler;

        while (!(line = br.readLine()).equals("handler_end")) {
            if (line.startsWith("variable_begin")) {
                while (!(line = br.readLine()).equals("variable_end")) {
                    String var = line.substring(1, line.length() - 1);

                    aiClass.eventHandler.addVariable(var);
                }
            } else {
                lines[linesPointer++] = line;
            }
        }

        parseHandlerBody(aiClass.eventHandler.stack, 0, lines, aiClass);

        return aiClass.eventHandler;
    }

    private void parseHandlerBody(Stack<StackObject> stack, int init, String[] lines, AiClass aiClass) {
        for (int i = init; i < lines.length; i++) {
            String line = lines[i];

            if (line.startsWith("S") && line.contains(".")) {
                String intVal = line.substring(1, line.indexOf("."));

                String key = "S" + Integer.parseInt(intVal);
                line = line.substring(key.length() + 2, line.length());

                StringObject so = new StringObject(aiClass, line);
                strings.put(key, so);
                continue;
            }

            String parts[] = line.split(" ");

            switch (parts[0]) {
                case "push_event":
                    i = push_event(stack, i, lines, aiClass);
                    break;
                case "push_string":
                    i = push_string(stack, i, lines);
                    break;
                case "func_call":
                    i = func_call(stack, i, lines, aiClass);
                    break;
                case "push_const":
                    i = push_const(stack, i, lines, aiClass);
                    break;
                case "push_parameter":
                    i = push_parameter(stack, i, lines, aiClass);
                    break;
                case "push_property":
                    i = push_property(stack, i, lines, aiClass);
                    break;
                case "assign":
                case "assign4":
                    i = assign(stack, i, lines, aiClass);
                    break;
                case "add":
                    i = add(stack, i, lines);
                    break;
                case "sub":
                    i = sub(stack, i, lines);
                    break;
                case "mul":
                    i = mul(stack, i, lines);
                    break;
                case "mod":
                    i = mod(stack, i, lines);
                    break;
                case "div":
                    i = div(stack, i, lines);
                    break;
                case "add_string":
                    i = add_string(stack, i, lines);
                    break;
                case "equal":
                    i = equal(stack, i, lines, aiClass);
                    break;
                case "not":
                    i = not(stack, i, lines);
                    break;
                case "not_equal":
                    i = not_equal(stack, i, lines, aiClass);
                    break;
                case "less":
                    i = less(stack, i, lines, aiClass);
                    break;
                case "less_equal":
                    i = less_equal(stack, i, lines, aiClass);
                    break;
                case "greater":
                    i = greater(stack, i, lines, aiClass);
                    break;
                case "greater_equal":
                    i = greater_equal(stack, i, lines, aiClass);
                    break;
                case "and":
                    i = and(stack, i, lines, aiClass);
                    break;
                case "or":
                    i = or(stack, i, lines, aiClass);
                    break;
                case "negate":
                    i = negate(stack, i, lines);
                    break;
                case "bit_or":
                    i = bit_or(stack, i, lines);
                    break;
                case "bit_and":
                    i = bit_and(stack, i, lines, aiClass);
                    break;
                case "exit_handler":
                    i = exit_handler(stack, i, lines, aiClass);
                    break;
                case "call_super":
                    i = call_super(stack, i, lines, aiClass);
                    break;
                case "push_reg_sp":
                    i = trySwitchCase(stack, i, lines, aiClass);
                    break;
                default:
                    log.debug("Unknown line in LLParser.parseHandlerBody(line):");
                    log.debug("Token: " + parts[0]);
                    log.debug("Line: " + line);
                    break;
            }
        }
    }

    private int not(Stack<StackObject> stack, int i, String[] lines) {
        StackObject value = stack.pop();

        if (value instanceof BitOperation) {
            value = ((BitOperation) value).not();
        } else if (value instanceof IntObject) {
            value = ((IntObject) value).not();
        } else {
            log.error("LLParser.not: except bit operation, found: " + value.getClass().getSimpleName());
        }

        stack.push(value);

        return i;
    }

    private int bit_or(Stack<StackObject> stack, int i, String[] lines) {
        StackObject a1 = stack.pop();
        StackObject a2 = stack.pop();

        BitOperation event = BitOperation.or(a2, a1);
        stack.push(event);

        return i;
    }

    private int bit_and(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        StackObject a1 = stack.pop();
        StackObject a2 = stack.pop();

        BitOperation event = BitOperation.and(a2, a1);
        stack.push(event);

        i = tryBranch(stack, i, lines, aiClass);

        return i;
    }

    private int push_property(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        String line = lines[i];
        String parts[] = line.split(" ");

        ParameterObject event = new ParameterObject(aiClass, parts[1]);
        stack.push(event);

        return i;
    }

    private int trySwitchCase(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        if (lines.length > i + 4) {
            String fetch_i = lines[i + 1];
            String push_const = lines[i + 2];
            String equal = lines[i + 3];
            String branch_false = lines[i + 4];

            //switch case
            if (fetch_i.equals("fetch_i") && push_const.startsWith("push_const") && equal.equals("equal")
                    && branch_false.startsWith("branch_false")) {
                SubHandlerBody switchHandler;
                if (stack.peek() instanceof SubHandlerBody && ((SubHandlerBody) stack.peek()).getType() == SubHandlerBody.SWITCH_TYPE) {
                    switchHandler = (SubHandlerBody) stack.peek();
                } else {
                    switchHandler = new SubHandlerBody(aiClass, SubHandlerBody.SWITCH_TYPE, stack.pop());
                    stack.push(switchHandler);
                }

                Stack<StackObject> tempStack = new Stack<>();

                push_const(tempStack, i + 2, lines, aiClass);

                StackObject caseExpression = null;
                if (tempStack.size() == 1) {
                    caseExpression = tempStack.pop();
                } else {
                    log.error("LLParser.invalid const in trySwitchCase. found: " + push_const + " except: push_const");
                }

                String branchLabel = branch_false.split(" ")[1];

                int j = i + 5;
                int jumps = 0;
                boolean hasBreak = false;
                for (; j < lines.length; j++) {
                    if (lines[j].startsWith("jump")) {
                        jumps++;
                    } else if (!lines[j].startsWith("L")) {
                        jumps = 0;
                    }
                    if (lines[j].equals(branchLabel)) {
                        if (jumps == 2) hasBreak = true;
                        break;
                    }
                }

                String branchBody[] = new String[j - (i + 5)];
                System.arraycopy(lines, i + 6, branchBody, 0, branchBody.length);

                i = j;

                SubHandlerBody caseHandler = new SubHandlerBody(aiClass, SubHandlerBody.CASE_TYPE, caseExpression);

                parseHandlerBody(caseHandler.stack, 0, branchBody, aiClass);

                //if (hasBreak)
                //	caseHandler.stack.push(new BreakEvent(aiClass));

                switchHandler.stack.push(caseHandler);

                int k = i + 1;

                // predict other case block's
                while (k + 4 < lines.length) {
                    String str1 = lines[k];
                    String str2 = lines[k + 1];
                    String str3 = lines[k + 2];
                    String str4 = lines[k + 3];
                    String str5 = lines[k + 4];

                    if (str1.equals("push_reg_sp") && str2.equals("fetch_i") && str3.startsWith("push_const")
                            && str4.equals("equal") && str5.startsWith("branch_false")) {
                        k = trySwitchCase(stack, k, lines, aiClass);

                        i = k;

                        k++;
                    } else {
                        break;
                    }
                }
            }
        }
        return i;
    }

    private int mod(Stack<StackObject> stack, int i, String[] lines) {
        StackObject a1 = stack.pop();
        StackObject a2 = stack.pop();

        MathEvent event = MathEvent.mod(a2, a1);
        stack.push(event);

        return i;
    }

    private int assign(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        StackObject a1 = stack.pop();
        StackObject a2 = stack.pop();

        VariableInitEvent event = new VariableInitEvent(aiClass, a2, a1, VariableInitEvent.EXPRESSION_TYPE);
        stack.push(event);
        return i;
    }

    private int call_super(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        CallSuperEvent callSuperEvent = new CallSuperEvent(aiClass, aiClass.eventHandler.getMethod());

        stack.push(callSuperEvent);

        return i;
    }

    private int exit_handler(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        ReturnEvent event = new ReturnEvent(aiClass);
        stack.push(event);

        return i;
    }

    private int negate(Stack<StackObject> stack, int i, String[] lines) {
        StackObject object = stack.pop();

        if (object instanceof IntObject) {
            object = ((IntObject) object).negate();
        } else if (object instanceof FloatObject) {
            object = ((FloatObject) object).negate();
        } else if (object instanceof EventObject) {
            object = ((EventObject) object).negate();
        } else {
            log.error("LLParser.negate: unknown object type=" + object.getClass());
        }

        stack.push(object);

        return i;
    }

    private int or(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        StackObject a1 = stack.pop();
        StackObject a2 = stack.pop();

        LogicalExpression event = LogicalExpression.or(a2, a1);
        stack.push(event);

        // predict push_reg_sp fetch_i branch_true L..
        i = tryAndOrList(stack, i, lines);

        // predict
        if (lines.length > i + 1) {
            String label = lines[i + 1];
            if (label.startsWith("L")) {
                i += 1;

                i = tryBranch(stack, i, lines, aiClass);
            }
        }

        return i;
    }

    private int and(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        StackObject a1 = stack.pop();
        StackObject a2 = stack.pop();

        LogicalExpression event = LogicalExpression.and(a2, a1);
        stack.push(event);

        // predict push_reg_sp fetch_i branch_true L..
        i = tryAndOrList(stack, i, lines);

        // predict
        if (lines.length > i + 1) {
            String label = lines[i + 1];
            if (label.startsWith("L")) {
                i += 1;

                i = tryBranch(stack, i, lines, aiClass);
            }
        }

        return i;
    }

    private int greater_equal(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        StackObject a1 = stack.pop();
        StackObject a2 = stack.pop();

        ExpressionEvent event = ExpressionEvent.greater_equal(a2, a1);
        stack.push(event);

        // predict push_reg_sp fetch_i branch_true L..
        i = tryAndOrList(stack, i, lines);

        // predict
        i = tryBranch(stack, i, lines, aiClass);

        return i;
    }

    private int greater(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        StackObject a1 = stack.pop();
        StackObject a2 = stack.pop();

        if (a2 instanceof EventObject && a1 instanceof IntObject) {
            EventObject eventObject = (EventObject) a2;
            IntObject intObject = (IntObject) a1;
            if (eventObject.getEventType() == boolean.class && intObject.getValue() == 0) {
                a1 = new BooleanObject(aiClass, true);
            }
            ExpressionEvent event = ExpressionEvent.equal(a2, a1);
            stack.push(event);
        } else {
            ExpressionEvent event = ExpressionEvent.greater(a2, a1);
            stack.push(event);
        }

        // predict push_reg_sp fetch_i branch_true L..
        i = tryAndOrList(stack, i, lines);

        // predict
        i = tryBranch(stack, i, lines, aiClass);

        return i;
    }

    private int less_equal(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        StackObject a1 = stack.pop();
        StackObject a2 = stack.pop();

        ExpressionEvent event = ExpressionEvent.less_equal(a2, a1);
        stack.push(event);

        // predict push_reg_sp fetch_i branch_true L..
        i = tryAndOrList(stack, i, lines);

        // predict
        i = tryBranch(stack, i, lines, aiClass);

        return i;
    }

    private int less(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        StackObject a1 = stack.pop();
        StackObject a2 = stack.pop();

        ExpressionEvent event = ExpressionEvent.less(a2, a1);
        stack.push(event);

        // predict push_reg_sp fetch_i branch_true L..
        i = tryAndOrList(stack, i, lines);

        // predict
        i = tryBranch(stack, i, lines, aiClass);

        return i;
    }

    private int not_equal(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        StackObject a1 = stack.pop();
        StackObject a2 = stack.pop();

        // fix ai_kuram bug with myself.Skill_GetAbnormalType() != -1
        if (aiClass.getClassName().equals("ai_kuram") && a2 instanceof FuncCallEvent && ((FuncCallEvent) a2).getEventId() == 234946797
                && a1 instanceof IntObject && ((IntObject) a1).getValue() == -1) {
            stack.push(a2);
            return i;
        }

        if (a2 instanceof EventObject && a1 instanceof IntObject) {
            EventObject funcCallEvent = (EventObject) a2;
            IntObject intObject = (IntObject) a1;
            if (funcCallEvent.getEventType() == boolean.class
                    && (intObject.getValue() == 0 || intObject.getValue() == 1)) {
                if (intObject.getValue() == 0) {
                    a1 = new BooleanObject(aiClass, false);
                } else {
                    a1 = new BooleanObject(aiClass, true);
                }
            }
        }

        ExpressionEvent event = ExpressionEvent.not_equal(a2, a1);
        stack.push(event);

        // predict push_reg_sp fetch_i branch_true L..
        i = tryAndOrList(stack, i, lines);

        // predict
        i = tryBranch(stack, i, lines, aiClass);

        return i;
    }

    private int equal(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        StackObject a1 = stack.pop();
        StackObject a2 = stack.pop();

        if (a2 instanceof EventObject && a1 instanceof IntObject) {
            EventObject funcCallEvent = (EventObject) a2;
            IntObject intObject = (IntObject) a1;
            if (funcCallEvent.getEventType() == boolean.class
                    && (intObject.getValue() == 0 || intObject.getValue() == 1)) {
                if (intObject.getValue() == 0) {
                    a1 = new BooleanObject(aiClass, false);
                } else {
                    a1 = new BooleanObject(aiClass, true);
                }
            }
        }

        ExpressionEvent event = ExpressionEvent.equal(a2, a1);

        stack.push(event);

        // predict push_reg_sp fetch_i branch_true L..
        i = tryAndOrList(stack, i, lines);

        // predict
        i = tryBranch(stack, i, lines, aiClass);

        return i;
    }

    private int tryAndOrList(Stack<StackObject> stack, int i, String[] lines) {
        if (lines.length > i + 3) {
            String push_reg_sp = lines[i + 1];
            String fetch_i = lines[i + 2];
            String branch = lines[i + 3];
            if (push_reg_sp.equals("push_reg_sp") && fetch_i.equals("fetch_i") && branch.startsWith("branch")) {
                i = i + 3;
            }
        }
        return i;
    }

    private int tryBranch(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        if (lines.length > i + 2) {
            String branch_false = lines[i + 1];
            if (branch_false.startsWith("branch_false")) {
                String branchLabel = branch_false.split(" ")[1];

                if (lines[i + 2].startsWith("L")) {
                    i = i + 3;

                    int j = i;
                    for (; j < lines.length; j++) {
                        String line = lines[j];

                        if (line.equals(branchLabel)) break;
                    }

                    if (stack.peek() instanceof EventObject) {
                        EventObject eventObject = (EventObject) stack.pop();
                        StackObject object = eventObject;
                        if (eventObject.getEventType() == Creature.class) {
                            object = ExpressionEvent.not_equal(eventObject, new NullEvent(aiClass));
                        }

                        stack.push(object);
                    }

                    String branchBody[] = new String[j - i];
                    System.arraycopy(lines, i, branchBody, 0, branchBody.length);

                    StackObject object = stack.pop();

                    if (object instanceof EventObject && ((EventObject) object).getEventType() == int.class
                            || object instanceof ParameterObject) {
                        object = ExpressionEvent.greater(object, new IntObject(aiClass, 0));
                    } else if (object instanceof BitOperation) {
                        object = ExpressionEvent.greater(object, new IntObject(aiClass, 0));
                    } else if (object instanceof IntObject && ((IntObject) object).getValue() == 1) {
                        object = new BooleanObject(aiClass, true);
                    } else if (object instanceof FuncCallEvent && ((FuncCallEvent) object).getEventType() == boolean.class) {
                        // do nothing
                    } else if (object instanceof EventObject && ((EventObject) object).getEventType() == boolean.class) {
                        // do nothing
                    } else if (object instanceof EventObject) {
                        object = ExpressionEvent.not_equal(object, new NullEvent(aiClass));
                    }

                    SubHandlerBody subHandlerBody = new SubHandlerBody(aiClass, SubHandlerBody.IF_TYPE, object);

                    parseHandlerBody(subHandlerBody.stack, 0, branchBody, aiClass);

                    stack.push(subHandlerBody);

                    i = j;

                    if (lines[i - 1].startsWith("jump")) {
                        // else - if; else types
                        String jumpLabel = lines[i - 1].split(" ")[1];

                        for (j = i; j < lines.length; j++) {
                            if (lines[j].equals(jumpLabel)) {

                                String jumpBody[] = new String[j - i];
                                System.arraycopy(lines, i, jumpBody, 0, jumpBody.length);

                                Stack<StackObject> tempStack = new Stack<>();

                                parseHandlerBody(tempStack, 0, jumpBody, aiClass);

                                if (tempStack.size() == 0) {
                                    // do nothing
                                } else if (tempStack.get(0) instanceof SubHandlerBody && ((SubHandlerBody) tempStack.get(0)).getType() == SubHandlerBody.IF_TYPE) // else - if
                                {
                                    ((SubHandlerBody) tempStack.get(0)).setType(SubHandlerBody.ELSE_IF_TYPE);

                                    stack.addAll(tempStack);
                                } else // else
                                {
                                    SubHandlerBody elseHandlerBody = new SubHandlerBody(aiClass, SubHandlerBody.ELSE_TYPE, null);

                                    elseHandlerBody.stack.addAll(tempStack);

                                    stack.push(elseHandlerBody);
                                }

                                break;
                            }
                        }

                        i = j;
                    }
                } else if (lines[i + 2].startsWith("jump")) // for() loop
                {
                    String jumpToLabel = lines[i + 2].split(" ")[1];

                    if (lines[i + 3].startsWith("L")) {
                        i += 4;
                        int j = i;
                        for (; j < lines.length; j++) {
                            if (lines[j].equals(jumpToLabel)) break;
                        }
                        String postLines[] = new String[j - i];
                        System.arraycopy(lines, i, postLines, 0, postLines.length);

                        Stack<StackObject> postStack = new Stack<>();

                        parseHandlerBody(postStack, 0, postLines, aiClass);

                        i = j;

                        j = i + 1;
                        for (; j < lines.length; j++) {
                            String line = lines[j];

                            if (line.equals(branchLabel)) break;
                        }

                        StackObject expression = stack.pop();
                        StackObject pre = stack.pop();

                        ForCycleEvent forCycleEvent = new ForCycleEvent(aiClass, pre, expression, postStack);

                        String cycleBody[] = new String[j - i];
                        System.arraycopy(lines, i, cycleBody, 0, cycleBody.length);

                        parseHandlerBody(forCycleEvent.stack, 0, cycleBody, aiClass);

                        stack.push(forCycleEvent);

                        i = j;
                    }
                } else // try while cycle
                {
                    int j = i + 2;
                    boolean found = false;
                    for (; j < lines.length; j++) {
                        if (lines[j].equals(branchLabel) && lines[j - 1].startsWith("jump")) {
                            String jumpLabel = lines[j - 1].split(" ")[1];
                            for (int k = i; k >= 0; k--) {
                                if (lines[k].equals(jumpLabel)) // found backward jump
                                {
                                    found = true;
                                    break;
                                }
                            }
                        }
                        if (found) break;
                    }

                    if (found) {
                        i = i + 1;

                        StackObject expression = stack.pop();
                        String cycleBody[] = new String[j - i];

                        SubHandlerBody whileCycleEvent = new SubHandlerBody(aiClass, SubHandlerBody.WHILE_TYPE, expression);

                        System.arraycopy(lines, i, cycleBody, 0, cycleBody.length);

                        parseHandlerBody(whileCycleEvent.stack, 0, cycleBody, aiClass);

                        stack.push(whileCycleEvent);

                        i = j;
                    }
                }
            }
        }
        return i;
    }

    private int add_string(Stack<StackObject> stack, int i, String[] lines) {
        String line = lines[i];
        String[] parts = line.split(" ");

        StackObject a1 = stack.pop();
        StackObject a2 = stack.pop();

        MathEvent event = MathEvent.add_string(a2, a1);
        stack.push(event);

        return i;
    }

    private int mul(Stack<StackObject> stack, int i, String[] lines) {
        StackObject a1 = stack.pop();
        StackObject a2 = stack.pop();

        MathEvent event = MathEvent.mul(a2, a1);
        stack.push(event);

        return i;
    }

    private int add(Stack<StackObject> stack, int i, String[] lines) {
        StackObject a1 = stack.pop();
        StackObject a2 = stack.pop();

        StackObject event = MathEvent.add(a2, a1);
        stack.push(event);

        return i;
    }

    private int sub(Stack<StackObject> stack, int i, String[] lines) {
        StackObject a1 = stack.pop();
        StackObject a2 = stack.pop();

        MathEvent event = MathEvent.sub(a2, a1);
        stack.push(event);

        return i;
    }

    private int div(Stack<StackObject> stack, int i, String[] lines) {
        StackObject a1 = stack.pop();
        StackObject a2 = stack.pop();

        MathEvent event = MathEvent.div(a2, a1);
        stack.push(event);

        return i;
    }

    private int push_parameter(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        String line = lines[i];
        String parts[] = line.split(" ");

        ParameterObject event = new ParameterObject(aiClass, parts[1]);
        stack.push(event);

        i = tryBranch(stack, i, lines, aiClass);

        return i;
    }

    private int push_const(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        String line = lines[i];
        String parts[] = line.split(" ");

        StackObject object;
        try {
            long value = Long.parseLong(parts[1]);
            object = new IntObject(aiClass, value);
        } catch (NumberFormatException e) {
            double value = Double.parseDouble(parts[1]);
            object = new FloatObject(aiClass, value);
        }

        stack.push(object);

        i = tryBranch(stack, i, lines, aiClass);

        return i;
    }

    private int func_call(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        String line = lines[i];
        String parts[] = line.split(" ");

        int eventId = Integer.parseInt(parts[1]);

        boolean found = false;
        boolean isVoid = false;
        boolean isBool = false;
        boolean isNumber = false;
        int parametersCount = 0;

        for (int j = stack.size() - 1; j >= 0; j--) {
            if (stack.get(j) instanceof EventObject) {
                EventObject event = (EventObject) stack.get(j);

                ClassMethod method = event.getFunc(eventId);
                if (method != null && stack.size() - 1 - method.getParameters().size() - j >= 0) {
                    List<StackObject> params = new ArrayList<>(method.getParameters().size());

                    for (int k = 0; k < method.getParameters().size(); k++) {
                        params.add(stack.get(j + 1));
                        stack.remove(j + 1);
                    }

                    event = event.addFuncWith(eventId, method, params);
                    stack.set(j, event);

                    parametersCount = method.getParameters().size();
                    isVoid = method.getReturnType() == void.class;
                    isBool = method.getReturnType() == boolean.class;
                    isNumber = method.getReturnType() == int.class || method.getReturnType() == long.class;

                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            log.error("LLParser.func_call not found func with eventId=" + eventId);
        }

        // predict
        if (lines.length > i + 1 && parametersCount > 0) {
            line = lines[i + 1];
            parts = line.split(" ");
            if (parts[0].equals("shift_sp")) {
                if (!parts[1].equals("-" + parametersCount)) {
                    log.error("LLParser.func_call error: " + eventId + " wrong function parametersCount. Declared " + parametersCount + ", found: " + (-Integer.parseInt(parts[1])));
                } else {
                    i = i + 1;
                }
            } else {
                log.error("LLParser.func_call error: except shift_sp " + "-" + parametersCount + ", found: " + line);
            }
        }

        if (lines.length > i + 1) {
            line = lines[i + 1];
            if (isVoid) {
                if (line.equals("shift_sp -1")) {
                    i = i + 1;
                }
            } else if (isBool || isNumber) {
                if (line.startsWith("branch_false")) {
                    i = tryBranch(stack, i, lines, aiClass);
                }
            }
        }

        return i;
    }

    private int push_string(Stack<StackObject> stack, int i, String[] lines) {
        String parts[] = lines[i].split(" ");

        String key = parts[1];
        StringObject value = strings.get(key);
        if (value == null) {
            log.error("Not found string with name=" + key);
        }

        stack.push(value);
        return i;
    }

    private int push_event(Stack<StackObject> stack, int i, String[] lines, AiClass aiClass) {
        String parts[] = lines[++i].split(" "); // push_const INTEGER
        int eventId = Integer.parseInt(parts[1]);

        EventObject event = new EventObject(aiClass, eventId, null);

        StackObject object = event;

        String add = lines[++i]; // add
        if (!add.equals("add")) {
            log.error("Unknown line in LLParser.push_event found:" + add + " except: add");
        }

        String next = lines[++i]; // fetch_i
        if (!(next.equals("fetch_i") || next.equals("fetch_f") || next.equals("fetch_i4") || next.equals("push_reg_sp"))) {
            log.error("Unknown line in LLParser.push_event found:" + next + " except: fetch_i, fetch_f, fetch_i4 or push_reg_sp");
        }

        // predict
        while (lines.length > i + 2) {
            String str1 = lines[i + 1];
            String str2 = lines[i + 2];

            if (event.getEventType() == int.class || event.getEventType() == double.class
                    || event.getEventType() == long.class || event.getEventType() == boolean.class) {
                break;
            }

            if (str1.startsWith("push_const") && str2.equals("add")) {
                String subParts[] = str1.split(" ");
                int subEventId = Integer.parseInt(subParts[1]);

                event = event.addSubEvent(subEventId);
                object = event;
                i += 2;
            } else break;

            if (lines.length > i + 1) {
                String str3 = lines[i + 1];
                if (str3.equals("fetch_i") || str3.equals("fetch_d") || str3.equals("fetch_i4")
                        || str3.equals("push_reg_sp")) {
                    i += 1;
                } else break;
            }

			/*
            if (event.getEventType() != Clan.class && event.getEventType() != Creature.class
					&& event.getEventType() != FHTML.class && event.getEventType() != GlobalObject.class
					&& event.getEventType() != Npc.class && event.getEventType() != NpcMaker.class
					&& event.getEventType() != Party.class && event.getEventType() != ItemData.class)
			{
				break;
			}*/
        }

        if (lines.length > i) {
            next = lines[i];

            if (next.equals("push_reg_sp") && lines.length > i + 8) {
                String str1 = lines[i + 1]; // fetch_i
                String str2 = lines[i + 2]; // push_reg_sp
                String str3 = lines[i + 3]; // fetch_i
                String str4 = lines[i + 4]; // fetch_i
                String str5 = lines[i + 5]; // push_const 1
                String operation = lines[i + 6]; // add
                String str7 = lines[i + 7]; // assign
                String str8 = lines[i + 8]; // fetch_i

                if (str1.equals("fetch_i") && str2.equals("push_reg_sp")
                        && str3.equals("fetch_i") && str4.equals("fetch_i") && str5.equals("push_const 1")
                        && (operation.equals("add") || operation.equals("sub")) && str7.equals("assign")
                        && str8.equals("fetch_i")) {
                    int type = VariableInitEvent.INCREMENT_TYPE;
                    if (operation.equals("sub"))
                        type = VariableInitEvent.DECREMENT_TYPE;

                    object = new VariableInitEvent(aiClass, event, null, type);
                    i = i + 9;
                }
            }
        }

        stack.push(object);

        if (lines.length > i + 1 && lines[i + 1].startsWith("branch_false")) {
            i = tryBranch(stack, i, lines, aiClass);
        }

        return i;
    }

    private Set<ParameterDefine> readParameterDefines(String line, BufferedReader br,
                                                      AiClass aiClass) throws IOException {
        Set<ParameterDefine> parameterDefines = new HashSet<>();

        while (!(line = br.readLine()).equals("parameter_define_end")) {
            // int DesirePqSize 50
            String parts[] = line.split(" ");

            ParameterDefine parameterDefine;

            if (line.startsWith("int")) {
                long value = Long.parseLong(parts[2]);
                if (value > Integer.MAX_VALUE) {
                    parameterDefine = new ParameterDefine(long.class, parts[1], parts[2] + "L");
                } else {
                    parameterDefine = new ParameterDefine(int.class, parts[1], parts[2]);
                }
            } else if (line.startsWith("float")) {
                parameterDefine = new ParameterDefine(double.class, parts[1], parts[2]);
            } else if (line.startsWith("string")) {
                String str = line;

                if (!line.endsWith("\"")) {
                    while (!(line = br.readLine()).endsWith("\"")) {
                        str += line;
                    }
                    str += line;
                }

                str = str.substring(str.indexOf("\""));

                parameterDefine = new ParameterDefine(String.class, parts[1], str);
            } else if (line.startsWith("waypointstype")) {
                parameterDefine = new ParameterDefine(WayPointsType.class, parts[1], "null");
            } else if (line.startsWith("waypointdelaystype")) {
                parameterDefine = new ParameterDefine(WayPointDelaysType.class, parts[1], "null");
            } else {
                log.error("Unknown line in LLParser.readParameterDefines(line):");
                log.error("Line: " + line);
                continue;
            }

            String className = aiClass.getParent();
            boolean found = false;
            while (!(className.equals(ScalaMakerEventHandler.class.getSimpleName())
                    || className.equals(ScalaNpcEventHandler.class.getSimpleName()))) {
                while (!repository.exists(className)) {
                    try {
                        Thread.currentThread().sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                DBClassInfo classInfo = repository.findOne(className);
                if (classInfo.getParameters().contains(parameterDefine.getName())) {
                    found = true;
                }

                className = classInfo.getParent();

                if (found) break;
            }

            if (!found)
                parameterDefines.add(parameterDefine);
        }

        return parameterDefines;
    }
}
