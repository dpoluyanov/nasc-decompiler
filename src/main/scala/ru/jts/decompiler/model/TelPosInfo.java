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

package ru.jts.decompiler.model;

/**
 * Created by dmitrij on 25.05.15.
 */
public class TelPosInfo {
    private final String name;
    private final int x;
    private final int y;
    private final int z;
    private final int unk1;
    private final int unk2;

    public TelPosInfo(String name, int x, int y, int z, int unk1, int unk2) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.unk1 = unk1;
        this.unk2 = unk2;
    }

    @Override
    public String toString() {
        return "new TelPosInfo(\"" + name + "\", " + x + ", " + y + ", " + z + ", " + unk1 + ", " + unk2 + ")";
    }
}
