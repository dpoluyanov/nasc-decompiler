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
public class SpawnDefine {
    @EventId(90)
    public String name;

    @EventId(140)
    public int total;

    @EventId(144)
    public int npc_count;

    @EventId(148)
    public int respawn_time;

    @EventId(152)
    public int respawn_rand;

    @EventId(208)
    public boolean has_dbname;

    @EventId(285409286)
    public void SendScriptEvent(int event_id, int script_event_arg1, int script_event_arg2) {
    }

    @EventId(285278213)
    public void LoadDBNpcInfo(int unk) {
    }

    @EventId(285278215)
    public void SetDBLoaded(int value) {
    }

    @EventId(285409282)
    public void Spawn2(int count, int respawn, int repsawn_rand) {
    }

    @EventId(285802497)
    public void SpawnEx(int unk1, int unk2, int x, int y, int z, int angle, double hp, double mp, int db_value) {
    }

    @EventId(285212676)
    public void Despawn() {
    }

    @EventId(285278216)
    public void RegToRespawnTimer(int respawn_times) {
    }

    @EventId(285343744)
    public void Spawn(int total, int unk) {
    }
}
