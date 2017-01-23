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
public class RecordInfo {
    @EventId(60)
    public double hp;

    @EventId(64)
    public double mp;

    @EventId(68)
    public int x;

    @EventId(72)
    public int y;

    @EventId(76)
    public int z;

    @EventId(80)
    public int death_time;

    @EventId(84)
    public boolean is_alive;

    @EventId(88)
    public int db_value;
}
