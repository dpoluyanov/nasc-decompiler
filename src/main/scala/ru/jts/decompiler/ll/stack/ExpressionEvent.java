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
public class ExpressionEvent extends StackObject {
    public static final int EQUAL = 0;
    public static final int LESS = 2;
    public static final int LESS_EQUAL = 3;
    private static final int NOT_EQUAL = 1;
    private static final int GREATER = 4;
    private static final int GREATER_EQUAL = 5;

    private StackObject owner;
    private int operationType;
    private StackObject rightOperand;
    private boolean braces;

    public ExpressionEvent(StackObject owner) {
        super(owner.aiClass);
        this.owner = owner;
    }

    public static ExpressionEvent equal(StackObject left, StackObject right) {
        appendBraces(left, right);

        if ((left instanceof ExpressionEvent || left instanceof LogicalExpression) && right instanceof IntObject && ((IntObject) right).getValue() == 0) {
            right = new BooleanObject(right.aiClass, false);
        }

        ExpressionEvent event = new ExpressionEvent(left);

        event.operationType = EQUAL;
        event.rightOperand = right;

        return event;
    }

    private static void appendBraces(StackObject left, StackObject right) {
        if (left instanceof LogicalExpression) {
            ((LogicalExpression) left).setBraces(true);
        } else if (left instanceof ExpressionEvent) {
            ((ExpressionEvent) left).setBraces(true);
        } else if (left instanceof BitOperation) {
            ((BitOperation) left).setBraces(true);
        }

        if (right instanceof LogicalExpression) {
            ((LogicalExpression) right).setBraces(true);
        } else if (right instanceof ExpressionEvent) {
            ((ExpressionEvent) right).setBraces(true);
        } else if (right instanceof BitOperation) {
            ((BitOperation) right).setBraces(true);
        }
    }

    public void setBraces(boolean braces) {
        this.braces = braces;
    }

    public static ExpressionEvent not_equal(StackObject left, StackObject right) {
        appendBraces(left, right);

        if ((left instanceof ExpressionEvent || left instanceof LogicalExpression) && right instanceof IntObject && ((IntObject) right).getValue() == 0) {
            right = new BooleanObject(right.aiClass, false);
        }

        ExpressionEvent event = new ExpressionEvent(left);

        event.operationType = NOT_EQUAL;
        event.rightOperand = right;

        return event;
    }

    public static ExpressionEvent less(StackObject left, StackObject right) {
        ExpressionEvent event = new ExpressionEvent(left);

        event.operationType = LESS;
        event.rightOperand = right;

        return event;
    }

    public static ExpressionEvent less_equal(StackObject left, StackObject right) {
        ExpressionEvent event = new ExpressionEvent(left);

        event.operationType = LESS_EQUAL;
        event.rightOperand = right;

        return event;
    }

    public static ExpressionEvent greater(StackObject left, StackObject right) {
        appendBraces(left, right);
        ExpressionEvent event = new ExpressionEvent(left);

        if ((left instanceof ExpressionEvent || left instanceof LogicalExpression) && right instanceof IntObject && ((IntObject) right).getValue() >= 0) {
            right = new BooleanObject(right.aiClass, true);
            event.operationType = EQUAL;
        } else {
            event.operationType = GREATER;
        }

        event.rightOperand = right;

        return event;
    }

    public static ExpressionEvent greater_equal(StackObject left, StackObject right) {
        // blueprint_seller_daeger talker >= 39 fix
        if (left.aiClass.getClassName().equals("blueprint_seller_daeger")
                && left.aiClass.eventHandler.getMethod().getName().equals("QUEST_ACCEPTED")
                && left instanceof EventObject && ((EventObject) left).name.equals("talker")
                && right instanceof IntObject && ((IntObject) right).getValue() == 39) {
            left = ((EventObject) left).addSubEvent(6636); // level
        }
        ExpressionEvent event = new ExpressionEvent(left);

        event.operationType = GREATER_EQUAL;
        event.rightOperand = right;

        return event;
    }

    public int getOperationType() {
        return operationType;
    }

    @Override
    public String toString() {
        String str = "";

        if (owner instanceof EventObject || owner instanceof ParameterObject || owner instanceof MathEvent
                || owner instanceof IntObject || owner instanceof ExpressionEvent || owner instanceof BitOperation
                || owner instanceof LogicalExpression) {
            if (owner instanceof FuncCallEvent && ((FuncCallEvent) owner).getEventType() == boolean.class) {
                if (rightOperand instanceof BooleanObject && rightOperand.toString().equals("false")) {
                    str = "!" + owner.toString();
                } else if (rightOperand instanceof BooleanObject && rightOperand.toString().equals("true")) {
                    str = owner.toString();
                }
                return str;
            }

            str = owner.toString() + " " + operationToString() + " " + rightOperand.toString();
        } else {
            System.err.println("ExpressionEvent: Unknown owner type: " + owner.getClass());
        }

        if (braces) str = "(" + str + ")";

        return str;
    }

    private String operationToString() {
        String str = "";
        switch (operationType) {
            case EQUAL:
                return "==";
            case NOT_EQUAL:
                return "!=";
            case LESS:
                return "<";
            case LESS_EQUAL:
                return "<=";
            case GREATER:
                return ">";
            case GREATER_EQUAL:
                return ">=";
        }

        return str;
    }

    public StackObject getLeftOperand() {
        return owner;
    }

    public StackObject getRightOperand() {
        return rightOperand;
    }
}
