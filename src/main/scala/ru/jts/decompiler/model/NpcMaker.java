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
 * Created by dmitrij on 25.05.15.
 */
public class NpcMaker {

    @EventId(1026)
    public String name;

    @EventId(1124)
    public int def_count;

    @EventId(1128)
    public int npc_count;

    @EventId(1132)
    public int maximum_npc;

    @EventId(1136)
    public int i_quest0;

    @EventId(1144)
    public int i_quest1;

    @EventId(1152)
    public int i_quest2;

    @EventId(1160)
    public int i_quest3;

    @EventId(1168)
    public int i_quest4;

    @EventId(1176)
    public int i_quest5;

    @EventId(1184)
    public int i_quest6;

    @EventId(1192)
    public int i_quest7;

    @EventId(1200)
    public int i_quest8;

    @EventId(1208)
    public int i_quest9;

    @EventId(1216)
    public int i_ai0;

    @EventId(1220)
    public int i_ai1;

    @EventId(1224)
    public int i_ai2;

    @EventId(1228)
    public int i_ai3;

    @EventId(1232)
    public int i_ai4;

    @EventId(1236)
    public int i_ai5;

    @EventId(1240)
    public int i_ai6;

    @EventId(1244)
    public int i_ai7;

    @EventId(1248)
    public int i_ai8;

    @EventId(1252)
    public int i_ai9;

    @EventId(1256)
    public Creature c_ai0;

    @EventId(1376)
    public int enabled;

    @EventId(218169344)
    public SpawnDefine GetSpawnDefine(int index) {
        return null;
    }

    @EventId(218300426)
    public boolean AtomicIncreaseTotal(SpawnDefine define, int count, int unk) {
        return false;
    }

    @EventId(218234882)
    public void AddTimerEx(int timer_id, int delay) {
    }

    @EventId(218169349)
    public void RegisterSiegeEventEx(int dominion_id) {
    }

    @EventId(218169355)
    public void RegisterFieldCycleEventEx(int field_cycle) {
    }

    @EventId(218300428)
    public void RegisterFortressEventEx(int fortress_id, int event_id, int reply) {
    }

    @EventId(218169347)
    public void RegisterNpcPosEvent(String event_name) {
    }

    @EventId(218169345)
    public SpawnDefine GetSpawnDefineByNick(String nick) {
        return null;
    }

    @EventId(218103816)
    public void DoRespawn() {
    }

    @EventId(218103817)
    public void ResetRespawn() {
    }

    @EventId(218234884)
    public void RegisterDoorEvent(String door_name, int inzone_type_param) {
    }

    @EventId(218365965)
    public void RegisterInstantZoneEventEx(int inzone_type_param, int inzone_cluster_id, int reply, int unk) {
    }

    @EventId(218103823)
    public int GetInZoneID() {
        return 0;
    }

    @EventId(218103822)
    public void RegisterOlympiadFieldEventEx() {
    }

    @EventId(218300423)
    public void RegisterRespawn(int respawn_time, int unk, SpawnDefine spawnDefine) {
    }

    @EventId(218169350)
    public void RegisterAgitSiegeEventEx(int castle_id) {
    }
}
