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

/**
 * Created by Дмитрий on 15.05.2015.
 */
public class ParameterDefine {
    private final Class typeClass;
    private final String name;
    private final String value;

    public ParameterDefine(Class typeClass, String name, String value) {
        this.typeClass = typeClass;
        this.value = value;

        if (name.equals("type"))
            this.name = "`type`";
        else
            this.name = name;
    }

    @Override
    public int hashCode() {
        int result = typeClass.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ParameterDefine && typeClass == ((ParameterDefine) obj).typeClass
                && name.equals(((ParameterDefine) obj).name);
    }

    public Class getTypeClass() {
        return typeClass;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
