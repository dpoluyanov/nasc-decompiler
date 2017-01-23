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
 * Created by dmitrij on 31.05.15.
 */
public class BitOperation extends StackObject {
    private static final int AND = 0;
    private static final int OR = 1;

    private StackObject owner;

    private int operationType;
    private StackObject rightOperand;
    private boolean not;

    private boolean braces;

    public BitOperation(StackObject owner) {
        super(owner.aiClass);
        this.owner = owner;
    }

    public static BitOperation or(StackObject left, StackObject right) {
        BitOperation event = new BitOperation(left);

        event.operationType = OR;
        event.rightOperand = right;

        return event;
    }

    public static BitOperation and(StackObject left, StackObject right) {
        BitOperation event = new BitOperation(left);

        event.operationType = AND;
        event.rightOperand = right;

        return event;
    }

    @Override
    public String toString() {
        String operator = "";
        switch (operationType) {
            case AND:
                operator = "&";
                break;
            case OR:
                operator = "|";
                break;
        }

        String str = owner + " " + operator + " " + rightOperand;

        if (not)
            str = "~" + "(" + str + ")";

        if (braces)
            str = "(" + str + ")";

        return str;
    }

    public StackObject not() {
        this.not = !this.not;
        return this;
    }

    public void setBraces(boolean braces) {
        this.braces = braces;
    }
}
