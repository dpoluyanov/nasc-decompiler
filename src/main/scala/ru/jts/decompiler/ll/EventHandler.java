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

package ru.jts.decompiler.ll;

import ru.jts.decompiler.class_model.ClassContainer;
import ru.jts.decompiler.class_model.ClassMethod;
import ru.jts.decompiler.class_model.MethodParameter;
import ru.jts.decompiler.gameserver.ScalaMakerEventHandler;
import ru.jts.decompiler.gameserver.ScalaNpcEventHandler;
import ru.jts.decompiler.ll.stack.ExpressionEvent;
import ru.jts.decompiler.ll.stack.StackObject;
import ru.jts.decompiler.ll.stack.VariableInitEvent;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

/**
 * Created by dmitrij on 15.05.2015.
 */
public class EventHandler {
    private final int type;
    private final int eventId;
    private final AiClass aiClass;

    public Stack<StackObject> stack;
    private Set<MethodParameter> usedParameters = new HashSet<>();

    private ClassMethod method;

    public EventHandler(int type, int eventId, AiClass aiClass) {
        this.type = type;
        this.eventId = eventId;
        this.aiClass = aiClass;
        this.stack = new Stack<>();

        appendName();
    }

    private void appendName() {
        Class clazz = ScalaNpcEventHandler.class;
        if (type == 1) clazz = ScalaMakerEventHandler.class;

        ClassContainer classContainer = ClassContainer.getInstance();

        method = classContainer.findMethod(eventId, clazz);

        if (method == null) {
            System.err.println("EventHandler: Not found method for eventId=" + eventId + " in class=" + clazz.getSimpleName());
        }
    }

    public void writeToFile(BufferedWriter bufferedWriter) throws IOException {
        String parameters = "";

        Iterator<MethodParameter> it = method.getSortedParameters().iterator();
        while (it.hasNext()) {
            MethodParameter p = it.next();

            String name = p.eventName;

            if (name.equals("private")) name = "`private`";

            parameters += name + ": " + toScalaParameterName(p.type) + " = " + getScalaDefaultValue(p.type);

            if (it.hasNext()) parameters += ", ";
        }

        bufferedWriter.write("\toverride def " + method.getName() + "(" + parameters + ") {\n");

        String stackStr = "";
        for (StackObject object : stack) {
            // bug with
            // myself.i_ai1 == 0;
            if (object instanceof ExpressionEvent && ((ExpressionEvent) object).getOperationType() == ExpressionEvent.EQUAL) {
                object = new VariableInitEvent(aiClass, ((ExpressionEvent) object).getLeftOperand(), ((ExpressionEvent) object).getRightOperand(),
                        VariableInitEvent.EXPRESSION_TYPE);
            }

            String str = object.toString();
            stackStr += str + "\n";
        }

        for (MethodParameter p : usedParameters) {
            String name = p.eventName;
            if (name.equals("private")) name = "`private`";
            bufferedWriter.write("\t\tvar _" + name + " = " + name + "\n");
        }
        if (usedParameters.size() > 0)
            bufferedWriter.write("\n");

        bufferedWriter.write(stackStr);

        bufferedWriter.write("\t}\n");
    }

    private String toScalaParameterName(Class clazz) {
        if (clazz == int.class) {
            return "Int";
        } else if (clazz == double.class) {
            return "Double";
        }

        return clazz.getSimpleName();
    }

    private String getScalaDefaultValue(Class clazz) {
        if (clazz == int.class) {
            return "0";
        } else if (clazz == double.class) {
            return "0.0";
        }

        return null;
    }

    public void addVariable(String var) {
        if (var.equals("myself") ||
                !(method.getName().equals("TALKED") || method.getName().equals("TALK_SELECTED")) &&
                        (var.equals("_choiceN") || var.equals("_code") || var.equals("_from_choice")))
            return;

        for (MethodParameter parameter : method.getParameters().values()) {
            if (parameter.realName.equals(var) || parameter.eventName.equals(var))
                return;
        }

        // NASC BUG and not using variables
        if (method.getName().equals("SUBJOB_LIST_INFORMED") && (var.equals("i_ai0") || var.equals("state")))
            return;
        if (method.getName().equals("ONE_SKILL_SELECTED") && var.equals("need_quest"))
            return;
        if (method.getName().equals("CREATED") && (var.equals("talker") || var.equals("i_quest0") || var.equals("timer_id")))
            return;
        if (method.getName().equals("MENU_SELECTED") && (var.equals("LevelNumber") || var.equals("i_quest1") || var.equals("i_quest2")
                || var.equals("c5") || var.equals("c6")))
            return;
        if ((method.getName().equals("ATTACKED") || method.getName().equals("PARTY_ATTACKED")) && var.equals("damege"))
            return;
        if ((method.getName().equals("ATTACKED") || method.getName().equals("MY_DYING")) && (var.equals("plist0")
                || var.equals("weapon_class_id")))
            return;
        if (method.getName().equals("SEE_CREATURE") && (var.equals("damage") || var.equals("i12")))
            return;
        if (method.getName().equals("SPELLED") && (var.equals("c5") || var.equals("c6") || var.equals("c7") || var.equals("c8")
                || var.equals("c9")))
            return;
        if (method.getName().equals("SCRIPT_EVENT") && (var.equals("timer_id") || var.equals("script_event3")))
            return;
        if (method.getName().equals("TELEPORT_REQUESTED") && var.equals("c6"))
            return;
        if (method.getName().equals("MY_DYING") && (var.equals("member") || var.equals("i_quest4") || var.equals("i_quest0") || var.equals("av_quest0")))
            return;
        if (method.getName().equals("ATTACKED") && (var.equals("i_quest0") || var.equals("i_quest1") || var.equals("i_quest2")
                || var.equals("i_quest3")))
            return;
        if ((method.getName().equals("TALKED") || method.getName().equals("TALK_SELECTED")) && var.equals("quest_id"))
            return;
        if (method.getName().equals("TALK_SELECTED") && var.equals("pledge1"))
            return;

        // maker
        if (method.getName().equals("ON_ALL_NPC_DELETED") && var.equals("reply"))
            return;
        if (method.getName().equals("ON_INSTANT_ZONE_EVENT") && (var.equals("inzone_type_id") || var.equals("inzone_id")))
            return;

        System.err.println("EventHandler: can't find class for var=" + var);
    }

    public ClassMethod getMethod() {
        return method;
    }

    public void addVarCall(MethodParameter parameter) {
        usedParameters.add(parameter);
    }

    public String getEventName(MethodParameter parameter) {
        if (usedParameters.contains(parameter)) {
            return "_" + parameter.eventName;
        }
        return null;
    }
}
