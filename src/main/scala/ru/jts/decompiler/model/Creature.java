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
public class Creature {
    @EventId(8)
    public int x;

    @EventId(16)
    public int y;

    @EventId(24)
    public int z;

    @EventId(36)
    public int id;

    @EventId(68)
    public boolean is_pc;

    @EventId(72)
    public boolean alive;

    @EventId(76)
    public int age;

    @EventId(88)
    public int subjob_id;

    @EventId(92)
    public int nobless_type;

    @EventId(96)
    public int hero_type;

    @EventId(104)
    public int subjob0_class;

    @EventId(108)
    public int subjob1_class;

    @EventId(112)
    public int subjob2_class;

    @EventId(116)
    public int subjob3_class;

    @EventId(120)
    public int race;

    @EventId(124)
    public int occupation;

    @EventId(176)
    public int sp;

    @EventId(328)
    public double hp;

    @EventId(344)
    public String name;

    @EventId(400)
    public double mp;

    @EventId(416)
    public int stop_mode;

    @EventId(432)
    public int target_index;

    @EventId(436)
    public int target_id;

    @EventId(448)
    public int pk_count;

    @EventId(456)
    public int karma;

    @EventId(6300)
    public int quest_last_reward_time;

    @EventId(6312)
    public int pledge_id;

    @EventId(6320)
    public int is_pledge_master;

    @EventId(6376)
    public int residence_id;

    @EventId(6528)
    public int death_penalty_level;

    @EventId(6536)
    public int dbid;

    @EventId(6636)
    public int level;

    @EventId(6696)
    public double max_hp;

    @EventId(6704)
    public double max_mp;

    @EventId(6744)
    public double hp_regen;

    @EventId(6808)
    public int equiped_weapon_class_id;

    @EventId(6812)
    public int attack_type;

    @EventId(6936)
    public int builder_level;

    @EventId(6952)
    public int last_blow_weapon_class_id;

    @EventId(7040)
    public boolean in_peacezone;

    @EventId(7108)
    public String ai;

    @EventId(7364)
    public int summon_type;

    @EventId(7372)
    public int summoner_id;

    @EventId(7376)
    public int boss_id;

    @EventId(7380)
    public int npc_class_id;

    @EventId(7384)
    public int weight_point;

    @EventId(7388)
    public int respawn_time;

    @EventId(7432)
    public int p_state;

    @EventId(7448)
    public Creature master;

    @EventId(7456)
    public int action;

    @EventId(7504)
    public int flag;

    @EventId(7508)
    public int yongma_type;
    // на страйдере, виверне, ездовом питомце, итд
    @EventId(7516)
    public int strider_level;

    @EventId(7528)
    public int pet_dbid;

    @EventId(7536)
    public int max_magic_level;

    @EventId(7544)
    public int transformID;

    @EventId(7548)
    public int instant_zone_id;

    @EventId(7552)
    public int instant_zone_type_id;

    @EventId(7556)
    public int instant_zone_type_id_in_use;

    @EventId(8228)
    public int db_value;

    @EventId(8232)
    public int param1;

    @EventId(8236)
    public int param2;

    @EventId(8240)
    public int param3;

    @EventId(8249)
    public int absolute_defence;

    @EventId(8250)
    public int no_attack_damage;

}
