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

/**
 * Created by dmitrij on 20.05.15.
 */
public class VariableInitEvent extends StackObject {
    public static final int EXPRESSION_TYPE = 0;
    public static final int INCREMENT_TYPE = 1;
    public static final int DECREMENT_TYPE = 2;
    private final int varType;
    private StackObject left;
    private StackObject right;

    public VariableInitEvent(AiClass aiClass, StackObject left, StackObject right, int varType) {
        super(aiClass);
        this.left = left;
        this.right = right;
        this.varType = varType;

        if (left instanceof EventObject && ((EventObject) left).parameter != null) {
            ((EventObject) left).name = "_" + ((EventObject) left).name;

            aiClass.eventHandler.addVarCall(((EventObject) left).parameter);
        }

        if (left instanceof EventObject && right instanceof VariableInitEvent
                && ((VariableInitEvent) right).getLeft() instanceof EventObject
                && ((EventObject) ((VariableInitEvent) right).getLeft()).getEventId() == ((EventObject) left).getEventId()) {
            this.left = ((VariableInitEvent) right).getLeft();
            this.right = ((VariableInitEvent) right).getRight();
        }
    }

    public StackObject getLeft() {
        return left;
    }

    public StackObject getRight() {
        return right;
    }

    @Override
    public String toString() {
        String str = "";
        if (varType == EXPRESSION_TYPE) str = "\t\t" + left + " = " + right;
        else if (varType == INCREMENT_TYPE) str = left + " += 1";
        else if (varType == DECREMENT_TYPE) str = left + " -= 1";
        else System.err.println("Unknown varType=" + varType);

        return str;
    }
}
