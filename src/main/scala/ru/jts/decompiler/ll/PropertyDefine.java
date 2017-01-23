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

package ru.jts.decompiler.ll;

import java.util.List;

/**
 * Created by dmitrij on 24.05.15.
 */
public class PropertyDefine {
    private final String propertyName;
    private final List<Object> objects;
    private final Class clazz;
    private boolean override;

    public PropertyDefine(String propertyName, List<Object> objects, Class clazz) {
        this.propertyName = propertyName;
        this.objects = objects;
        this.clazz = clazz;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Class getClazz() {
        return clazz;
    }

    @Override
    public String toString() {
        String str = "\t";
        if (override)
            str += "override ";

        str += "def " + propertyName + ":Array[" + clazz.getSimpleName() + "] = new Array[" + clazz.getSimpleName() + "](" + (objects.size()) + ")\n";

        if (objects.size() > 0) {
            for (int i = 0; i < objects.size(); i++) {
                str += "\t" + propertyName + "(" + i + ") = " + objects.get(i).toString() + "\n";
            }
        }

        str += "\n";

        return str;
    }

    public void override() {
        this.override = true;
    }
}
