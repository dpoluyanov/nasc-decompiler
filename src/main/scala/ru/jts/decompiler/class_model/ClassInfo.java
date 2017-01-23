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

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dmitrij on 15.06.15.
 */
public class ClassInfo {
    private Class clazz;
    private Map<Integer, ClassField> classFieldMap = new HashMap<>();
    private Map<Integer, ClassMethod> classMethodMap = new HashMap<>();

    public ClassInfo(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }

    public List<ClassInfo> process() {
        List<ClassInfo> classInfos = new ArrayList<>();

        if (!ClassContainer.visitedClass.contains(clazz)) {
            ClassContainer.visitedClass.add(clazz);

            classInfos.addAll(processFields());
            classInfos.addAll(processMethods());
        }

        return classInfos;

    }

    private List<ClassInfo> processFields() {
        List<ClassInfo> classInfos = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            EventId eventId = field.getAnnotation(EventId.class);
            if (eventId != null) {
                classFieldMap.put(eventId.value(), new ClassField(field.getName(), field.getType()));

                ClassInfo classInfo = new ClassInfo(field.getType());

                classInfos.add(classInfo);
                classInfos.addAll(classInfo.process());
            }
        }

        return classInfos;
    }

    private List<ClassInfo> processMethods() {
        List<ClassInfo> classInfos = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            EventId eventId = method.getAnnotation(EventId.class);
            if (eventId != null) {
                ClassMethod classMethod = new ClassMethod(method);
                classMethodMap.put(eventId.value(), classMethod);

                classInfos.addAll(classMethod.process());
            }
        }
        return classInfos;
    }

    @Override
    public int hashCode() {
        return clazz.hashCode();
    }


    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof ClassInfo)
            return ((ClassInfo) o).clazz.equals(clazz);

        return false;
    }

    public ClassMethod findMethod(int eventId) {
        if (classMethodMap.containsKey(eventId))
            return classMethodMap.get(eventId);
        return null;
    }

    public ClassField findField(int eventId) {
        if (classFieldMap.containsKey(eventId))
            return classFieldMap.get(eventId);

        return null;
    }
}
