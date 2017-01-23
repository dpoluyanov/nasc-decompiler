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

import ru.jts.decompiler.class_model.ClassMethod;
import ru.jts.decompiler.class_model.MethodParameter;
import ru.jts.decompiler.ll.AiClass;

import java.util.Iterator;

/**
 * Created by Дмитрий on 18.05.2015.
 */
public class CallSuperEvent extends StackObject {
    private final ClassMethod method;

    public CallSuperEvent(AiClass aiClass, ClassMethod method) {
        super(aiClass);
        this.method = method;
    }

    @Override
    public String toString() {
        String parameters = "";

        Iterator<MethodParameter> it = method.getSortedParameters().iterator();
        while (it.hasNext()) {
            MethodParameter p = it.next();

            String name = p.eventName;
            if (name.equals("private")) name = "`private`";
            parameters += name;

            if (it.hasNext()) parameters += ", ";
        }

        String str = "\t\tsuper." + method.getName() + "(" + parameters + ")\n";

        return str;
    }
}
