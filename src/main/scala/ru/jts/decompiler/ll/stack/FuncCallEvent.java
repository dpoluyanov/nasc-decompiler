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
import ru.jts.decompiler.ll.AiClass;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Дмитрий on 16.05.2015.
 */
public class FuncCallEvent extends EventObject {
    private final ClassMethod method;
    private final List<StackObject> params;

    public FuncCallEvent(AiClass aiClass, int eventId, EventObject parent, ClassMethod method, List<StackObject> params) {
        super(aiClass, eventId, parent);
        this.method = method;
        this.params = params;

        this.eventType = method.getReturnType();
    }

    @Override
    public String toString() {
        String str = parent.toString() + ".";

        String methodParams = "";

        for (int i = 0; i < params.size(); i++) {
            methodParams += params.get(i).toString();

            if (i + 1 != params.size()) methodParams += ", ";
        }

        str += this.method.getName() + "(" + methodParams + ")";

        return str;
    }
}
