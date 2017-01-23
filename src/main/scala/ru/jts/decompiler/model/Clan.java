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
 * Created by Дмитрий on 14.05.2015.
 */
public class Clan {
    @EventId(72)
    public String name;

    @EventId(196)
    public int skill_level;

    @EventId(232)
    public int castle_id;

    @EventId(236)
    public int agit_id;

    @EventId(240)
    public int fortress_id;

    @EventId(1904)
    public int prev_server;

    @EventId(1956)
    public int airship_count;
}
