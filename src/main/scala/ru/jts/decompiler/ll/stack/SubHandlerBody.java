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

package ru.jts.decompiler.ll.stack;

import ru.jts.decompiler.ll.AiClass;

import java.util.Stack;

/**
 * Created by Дмитрий on 17.05.2015.
 */
public class SubHandlerBody extends StackObject {
    public static final int IF_TYPE = 0;
    public static final int ELSE_IF_TYPE = 1;
    public static final int ELSE_TYPE = 2;
    public static final int SWITCH_TYPE = 3;
    public static final int CASE_TYPE = 4;
    public static final int FOR_TYPE = 5;
    public static final int WHILE_TYPE = 6;

    public final Stack<StackObject> stack;
    private final StackObject expression;
    private int handlerType;

    public SubHandlerBody(AiClass aiClass, int handlerType, StackObject expression) {
        super(aiClass);

        this.expression = expression;
        this.stack = new Stack<>();
        this.handlerType = handlerType;
    }

    @Override
    public String toString() {
        String str = "";
        switch (handlerType) {
            case IF_TYPE:
                str = "\t\tif (" + expression.toString() + ") {\n";
                break;
            case ELSE_IF_TYPE:
                str = "\t\telse if (" + expression.toString() + ") {\n";
                break;
            case ELSE_TYPE:
                str = "\t\telse {\n";
                break;
            case SWITCH_TYPE:
                str = "\t\t" + expression.toString() + " match {\n";
                break;
            case CASE_TYPE:
                str = "\t\t\tcase " + expression.toString() + " => {\n";
                break;
            case WHILE_TYPE:
                str = "\t\twhile(" + expression.toString() + ") {\n";
                break;
        }

        boolean buggedTumor = false;
        if ((handlerType == IF_TYPE || handlerType == ELSE_IF_TYPE) && aiClass.getClassName().equals("ai_immo_tumor")
                && expression instanceof ExpressionEvent && ((ExpressionEvent) expression).getLeftOperand() instanceof ParameterObject
                && ((ExpressionEvent) expression).getLeftOperand().toString().equals("room")
                && ((ExpressionEvent) expression).getRightOperand() instanceof IntObject) {

            buggedTumor = true;
        }

        if (buggedTumor) {
            str += "\t\t\tdef zone_manipulation() {\n";
        }
        for (StackObject object : stack) {
            // bug with
            // myself.i_ai1 == 0;
            if (object instanceof ExpressionEvent && ((ExpressionEvent) object).getOperationType() == ExpressionEvent.EQUAL) {
                object = new VariableInitEvent(object.aiClass, ((ExpressionEvent) object).getLeftOperand(), ((ExpressionEvent) object).getRightOperand(),
                        VariableInitEvent.EXPRESSION_TYPE);
            }


            String objectStr = object.toString();
            String comment = "";
            if (object instanceof EventObject
                    && ((EventObject) object).getEventId() == 52 && ((EventObject) object).parent.getEventId() == 768) // code_info.code
                comment = "//";

            str += "\t\t\t" + comment + objectStr + "\n";

            //if (object instanceof VariableInitEvent || comment.length() > 0
            //		|| (object instanceof FuncCallEvent && !objectStr.endsWith(";\n")))
            //	str += ";\n";
        }

        if (buggedTumor) {
            str += "\t\t\t}\n";
            str += "\t\t\tzone_manipulation()\n";
        }

        str += "\t\t}";
        return str;
    }

    public StackObject getExpression() {
        return expression;
    }

    public int getType() {
        return handlerType;
    }

    public void setType(int handlerType) {
        this.handlerType = handlerType;
    }
}
