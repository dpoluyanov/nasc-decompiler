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

/**
 * Created by Дмитрий on 16.05.2015.
 */
public class LogicalExpression extends StackObject {
    private static final int AND = 0;
    private static final int OR = 1;


    private final StackObject owner;
    private int operationType;
    private StackObject rightOperand;
    private boolean braces;

    public LogicalExpression(StackObject owner) {
        super(owner.aiClass);

        this.owner = owner;
    }

    public static LogicalExpression and(StackObject left, StackObject right) {
        right = fixBooleanCheck(right);
        left = fixBooleanCheck(left);

        if (right instanceof LogicalExpression) {
            ((LogicalExpression) right).setBraces(true);
            if (left instanceof LogicalExpression) {
                ((LogicalExpression) left).setBraces(true);

                if (((LogicalExpression) left).operationType == AND && ((LogicalExpression) right).operationType == AND
                        || ((LogicalExpression) left).operationType == OR && ((LogicalExpression) right).operationType == OR) {
                    ((LogicalExpression) right).setBraces(false);
                    ((LogicalExpression) left).setBraces(false);
                }
            }
        }

        LogicalExpression event = new LogicalExpression(left);

        event.operationType = AND;
        event.rightOperand = right;

        return event;
    }

    public static StackObject fixBooleanCheck(StackObject obj) {

        if (obj instanceof EventObject && (((EventObject) obj).getEventType() == int.class || ((EventObject) obj).getEventType() == long.class)
                || obj instanceof ParameterObject) {
            obj = ExpressionEvent.greater(obj, new IntObject(obj.aiClass, 0));
        }

        return obj;
    }

    public void setBraces(boolean braces) {
        this.braces = braces;
    }

    public static LogicalExpression or(StackObject left, StackObject right) {
        right = fixBooleanCheck(right);
        left = fixBooleanCheck(left);

        if (right instanceof LogicalExpression) {
            ((LogicalExpression) right).setBraces(true);
        }

        LogicalExpression event = new LogicalExpression(left);

        event.operationType = OR;
        event.rightOperand = right;

        return event;
    }

    @Override
    public String toString() {
        String str = owner.toString() + " " + operationToString() + " " + rightOperand.toString();

        if (braces)
            str = "(" + str + ")";

        return str;
    }

    private String operationToString() {
        String str = "";
        switch (operationType) {
            case AND:
                return "&&";
            case OR:
                return "||";
        }

        return str;
    }
}
