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

package ru.jts.decompiler.class_model;

import ru.jts.decompiler.annotation.EventId;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * Created by dmitrij on 15.06.15.
 */
public class ClassMethod {
    public Method method;
    public Map<Integer, MethodParameter> parameters = new HashMap<>();
    public List<MethodParameter> sortedParameters = new ArrayList<>();

    public ClassMethod(Method method) {
        this.method = method;
    }

    public Map<Integer, MethodParameter> getParameters() {
        return parameters;
    }

    public String getName() {
        return method.getName();
    }

    public List<ClassInfo> process() {
        List<ClassInfo> classInfos = new ArrayList<>();
        for (Parameter parameter : method.getParameters()) {
            EventId eventId = parameter.getAnnotation(EventId.class);

            MethodParameter methodParameter;
            if (eventId != null) {
                methodParameter = new MethodParameter(eventId.value(), eventId.name(), parameter.getName(), parameter.getType());
                parameters.put(eventId.value(), methodParameter);
            } else {
                methodParameter = new MethodParameter(parameter.getName(), parameter.getType());
                parameters.put(-1 - parameters.size(), methodParameter);
            }
            sortedParameters.add(methodParameter);
            classInfos.addAll(methodParameter.process());
        }

        return classInfos;
    }

    public Class getReturnType() {
        return method.getReturnType();
    }

    public MethodParameter findParameter(int eventId) {
        if (parameters.containsKey(eventId))
            return parameters.get(eventId);
        return null;
    }

    public Collection<MethodParameter> getSortedParameters() {
        return sortedParameters;
    }
}
