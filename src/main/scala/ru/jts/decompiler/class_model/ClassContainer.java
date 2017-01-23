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

import ru.jts.decompiler.gameserver.ScalaMakerEventHandler;
import ru.jts.decompiler.gameserver.ScalaNpcEventHandler;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dmitrij on 15.06.15.
 */
public class ClassContainer {
    public static Set<Class> visitedClass = new HashSet<>();
    private static ClassContainer instance = new ClassContainer();
    private Set<ClassInfo> classInfoList = new HashSet<>();

    public ClassContainer() {
        processClass(ScalaNpcEventHandler.class);
        processClass(ScalaMakerEventHandler.class);
    }

    private void processClass(Class clazz) {
        ClassInfo classInfo = new ClassInfo(clazz);
        classInfoList.addAll(classInfo.process());

        classInfoList.add(classInfo);
    }

    public static ClassContainer getInstance() {
        return instance;
    }

    public ClassMethod findMethod(int eventId, Class clazz) {
        ClassMethod classMethod = null;
        for (ClassInfo classInfo : classInfoList) {
            if (classInfo.getClazz() == clazz) {
                return classInfo.findMethod(eventId);
            }
        }

        return classMethod;
    }

    public ClassField findField(int eventId, Class clazz) {
        ClassField classField = null;
        for (ClassInfo classInfo : classInfoList) {
            if (classInfo.getClazz() == clazz) {
                return classInfo.findField(eventId);
            }
        }

        return classField;
    }
}
