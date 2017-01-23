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
public class MathEvent extends StackObject {
    private static final int ADD = 0;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 3;
    private static final int MOD = 4;

    private StackObject owner;

    private int operationType;
    private StackObject rightOperand;
    private boolean braces;

    public MathEvent(StackObject owner) {
        super(owner.aiClass);
        this.owner = owner;
    }

    public static StackObject add(StackObject left, StackObject right) {
        if (left instanceof BitOperation) {
            ((BitOperation) left).setBraces(true);
        }
        if (right instanceof BitOperation) {
            ((BitOperation) right).setBraces(true);
        }

        MathEvent event = new MathEvent(left);

        event.operationType = ADD;
        event.rightOperand = right;

        return event;
    }


    public static MathEvent mul(StackObject left, StackObject right) {
        if (right instanceof MathEvent && (((MathEvent) right).operationType == ADD || ((MathEvent) right).operationType == SUB)) {
            ((MathEvent) right).setBraces(true);
        }
        MathEvent event = new MathEvent(left);

        event.operationType = MUL;
        event.rightOperand = right;

        return event;
    }

    public void setBraces(boolean braces) {
        this.braces = braces;
    }

    public static MathEvent sub(StackObject left, StackObject right) {
        MathEvent event = new MathEvent(left);

        event.operationType = SUB;
        event.rightOperand = right;

        return event;
    }

    public static MathEvent div(StackObject left, StackObject right) {
        if (right instanceof MathEvent && (((MathEvent) right).operationType == ADD || ((MathEvent) right).operationType == SUB)) {
            ((MathEvent) right).setBraces(true);
        }
        MathEvent event = new MathEvent(left);

        event.operationType = DIV;
        event.rightOperand = right;

        return event;
    }

    public static MathEvent add_string(StackObject left, StackObject right) {
        if (right instanceof MathEvent && ((MathEvent) right).owner instanceof EventObject &&
                ((EventObject) ((MathEvent) right).owner).getEventType() != String.class) {
            ((MathEvent) right).setBraces(true);
        }

        MathEvent event = new MathEvent(left);

        event.operationType = ADD;
        event.rightOperand = right;

        return event;
    }

    public static MathEvent mod(StackObject left, StackObject right) {
        MathEvent event = new MathEvent(left);

        event.operationType = MOD;
        event.rightOperand = right;

        return event;
    }

    @Override
    public String toString() {
        String str = "";

        if (owner instanceof EventObject || owner instanceof MathEvent || owner instanceof StringObject || owner instanceof IntObject || owner instanceof ParameterObject
                || owner instanceof FloatObject || owner instanceof BitOperation) {
            str = owner.toString() + " " + operationToString() + " " + rightOperand.toString();
            if (braces)
                str = "(" + str + ")";
        } else {
            System.err.println("MathEvent: Unknown owner type: " + owner.getClass());
        }

        return str;
    }

    private String operationToString() {
        String str = "";
        switch (operationType) {
            case ADD:
                return "+";
            case MUL:
                return "*";
            case SUB:
                return "-";
            case DIV:
                return "/";
            case MOD:
                return "%";
        }

        return str;
    }
}