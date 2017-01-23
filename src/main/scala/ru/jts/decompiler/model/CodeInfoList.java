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

import ru.jts.decompiler.annotation.EventId;

/**
 * Created by dmitrij on 03.06.15.
 */
public class CodeInfoList {
    @EventId(318898176)
    public void SetInfo(int unk, Creature target) {
    }

    @EventId(318767105)
    public CodeInfo Next() {
        return null;
    }

    @EventId(318767106)
    public CodeInfo RandomSelectOne() {
        return null;
    }
}
