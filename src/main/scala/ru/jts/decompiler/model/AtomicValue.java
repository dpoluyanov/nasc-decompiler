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
 * Created by dmitrij on 31.05.15.
 */
public class AtomicValue {
    @EventId(8)
    public int value;

    @EventId(352387074)
    public boolean Exchange(int value) {
        return false;
    }

    @EventId(352321539)
    public int GetValue() {
        return 0;
    }

    @EventId(352387073)
    public void Decrement(int value) {
    }

    @EventId(352452612)
    public int CompareExchange(int unk1, int unk2) {
        return 0;
    }

    @EventId(352387072)
    public void Increment(int count) {
    }
}
