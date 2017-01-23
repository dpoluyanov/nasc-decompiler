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
 * Created by dmitrij on 21.05.15.
 */
public class ForCycleEvent extends SubHandlerBody {
    private final Stack<StackObject> postExpression;
    private final StackObject preExpression;

    public ForCycleEvent(AiClass aiClass, StackObject preExpression, StackObject expression,
                         Stack<StackObject> postExpression) {
        super(aiClass, SubHandlerBody.FOR_TYPE, expression);

        this.preExpression = preExpression;
        this.postExpression = postExpression;
    }

    @Override
    public String toString() {
        String str = "";

        String postStr = "";

        for (int i = 0; i < postExpression.size(); i++) {
            postStr += postExpression.get(i);

            if (i + 1 != postExpression.size()) {
                postStr += ", ";
            }
        }

        postStr = postStr.replaceAll(";", "").trim();

        if (postStr.equals("i1")) postStr = ""; // br_fire_elemental_base#CREATED for cycle bug

        String strExpression = "";
        if (preExpression instanceof VariableInitEvent && getExpression() instanceof ExpressionEvent
                && (((ExpressionEvent) getExpression()).getOperationType() == ExpressionEvent.LESS
                || ((ExpressionEvent) getExpression()).getOperationType() == ExpressionEvent.LESS_EQUAL)) {
            strExpression += ((VariableInitEvent) preExpression).getLeft();
            strExpression += " <- ";
            strExpression += ((VariableInitEvent) preExpression).getRight();

            if (((ExpressionEvent) getExpression()).getOperationType() == ExpressionEvent.LESS)
                strExpression += " until "; // exclusive
            else // LESS_EQUAL
                strExpression += " to "; // inclusive

            strExpression += ((ExpressionEvent) getExpression()).getRightOperand();

            str = "\t\tfor(" + strExpression + ") {\n";
        } else if (preExpression instanceof VariableInitEvent && getExpression() instanceof ExpressionEvent
                && ((ExpressionEvent) getExpression()).getOperationType() == ExpressionEvent.EQUAL) {

            strExpression = getExpression().toString();

            str = "\t\t" + preExpression.toString() + "\n";
            str += "\t\twhile(" + strExpression + ") {\n";
        } else {
            System.err.println("Error");
        }


        for (StackObject object : stack) {
            String objectStr = object.toString();
            str += "\t" + objectStr + "\n";
        }

        str += "\t\t}\n";

        return str;
    }
}
