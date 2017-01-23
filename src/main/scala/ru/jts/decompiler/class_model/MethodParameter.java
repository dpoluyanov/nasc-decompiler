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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitrij on 15.06.15.
 */
public class MethodParameter {
    private final int eventId;
    public String realName;
    public String eventName;
    public Class type;

    public MethodParameter(String realName, Class<?> type) {
        this(-1, realName, realName, type);
    }

    public MethodParameter(int eventId, String eventName, String realName, Class<?> type) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.realName = realName;
        this.type = type;
    }

    public List<ClassInfo> process() {
        List<ClassInfo> classInfos = new ArrayList<>();

        ClassInfo classInfo = new ClassInfo(type);

        classInfos.add(classInfo);
        classInfos.addAll(classInfo.process());

        return classInfos;
    }
}
