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

/**
 * Created by dmitrij on 15.06.15.
 */
public class ClassField {
    private final String eventName;
    private final Class type;

    public ClassField(String eventName, Class type) {
        this.eventName = eventName;
        this.type = type;
    }

    public String getEventName() {
        return eventName;
    }

    public Class getType() {
        return type;
    }
}
