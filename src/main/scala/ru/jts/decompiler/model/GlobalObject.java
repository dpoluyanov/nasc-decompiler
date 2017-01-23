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
public class GlobalObject {
    @EventId(268566563)
    public int GetAbnormalLevel(Creature creature, int abnormal_type) {
        return 0;
    }

    @EventId(268500999)
    public int Rand(int max) {
        return 0;
    }

    @EventId(268566578)
    public int OwnItemCount(Creature creature, int itemId) {
        return 0;
    }

    @EventId(268501023)
    public int FloatToInt(double value) {
        return (int) Math.round(value);
    }

    @EventId(268828716)
    public String MakeFString(int fstring, String s0, String s1, String s2, String s3, String s4) {
        return "";
    }

    @EventId(268501058)
    public void SetAsNull(Creature c) {
    }

    @EventId(268501018)
    public Party GetParty(Creature c0) {
        return null;
    }

    @EventId(268566580)
    public int HaveMemo(Creature creature, int quest) {
        return 0;
    }

    @EventId(268501047)
    public Creature Party_GetLeader(Creature talker) {
        return null;
    }

    @EventId(268501037)
    public int Party_GetCount(Creature talker) {
        return 0;
    }

    @EventId(268566582)
    public Creature Party_GetCreature(Creature creature, int index) {
        return null;
    }

    @EventId(268501073)
    public int Fortress_GetContractStatus(int fortress_id) {
        return 0;
    }

    @EventId(268501022)
    public int Castle_GetDomainFortressContractStatus(int fortress_id) {
        return 0;
    }

    @EventId(268566550)
    public boolean IsSameString(String str1, String str2) {
        return str1.equals(str2);
    }

    @EventId(268566581)
    public int GetMemoState(Creature talker, int quest) {
        return 0;
    }

    @EventId(268501011)
    public boolean IsNull(Object obj) {
        return obj == null;
    }

    @EventId(268501034)
    public String IntToStr(int value) {
        return String.valueOf(value);
    }

    @EventId(268566592)
    public String GetSubpledgeMasterName(Creature talker, int reply) {
        return "";
    }

    @EventId(268435523)
    public Creature GetNullCreature() {
        return null;
    }

    @EventId(268501110)
    public void SetSkillAll(Creature talker) {
    }

    @EventId(268697624)
    public void AddLogEx(int unk1, Creature talker, int unk2, int unk3) {
    }

    @EventId(268566627)
    public boolean GetDailyQuestFlag(Creature talker, int quest_id) {
        return false;
    }

    @EventId(268566628)
    public void SetDailyQuestFlag(Creature talker, int quest_id) {
    }

    @EventId(268632115)
    public int GetMemoStateEx(Creature talker, int quest_id, int unk) {
        return 0;
    }

    @EventId(268501087)
    public boolean IsCreateDate(Creature talker) {
        return false;
    }

    @EventId(268501088)
    public boolean CanGetBirthdayGift(Creature talker) {
        return false;
    }

    @EventId(268566618)
    public int GetNRMemoState(Creature talker, int mission) {
        return 0;
    }

    @EventId(269090819)
    public void ShowOnScreenMsgStr(Creature talker, int unk1, int unk2, int unk3, int unk4, int unk5, int unk6,
                                   int unk7,
                                   int unk8, String str) {
    }

    @EventId(268501113)
    public int GetDominionWarState(int dominion_id) {
        return 0;
    }

    @EventId(268566617)
    public boolean HaveNRMemo(Creature talker, int unk) {
        return false;
    }

    @EventId(235012622)
    public void SetNRMemo(Creature talker, int unk1) {
    }

    @EventId(235078159)
    public void SetNRMemoState(Creature talker, int quest_id, int state) {
    }

    @EventId(268501039)
    public int GetSSQPart(Creature talker) {
        return 0;
    }

    @EventId(268566546)
    public int GetDateTime(int value, int dtf) {
        return 0;
    }

    @EventId(268566556)
    public void Castle_GateOpenClose2(String door_name, int close) {
    }

    @EventId(268632110)
    public void AddLog(int unk1, Creature talker, int unk2) {
    }

    @EventId(268501029)
    public Creature GetCreatureFromID(int objId) {
        return null;
    }

    @EventId(268501031)
    public int GetIndexFromCreature(Creature creature) {
        return 0;
    }

    @EventId(268501030)
    public Creature GetCreatureFromIndex(int index) {
        return null;
    }

    @EventId(268501061)
    public int GetStep_FieldCycle(int field_cycle) {
        return 0;
    }

    @EventId(268501062)
    public int GetPoint_FieldCycle(int field_cycle) {
        return 0;
    }

    @EventId(268697671)
    public void AddPoint_FieldCycle(int field_cycle, int field_cycle_quantity, int unk, Creature creature) {
    }

    @EventId(268697673)
    public void SetStep_FieldCycle(int field_cycle, int unk1, int unk2, Creature creature) {
    }

    @EventId(268632138)
    public void SetStepWithoutActor_FieldCycle(int field_cycle, int unk1, int unk2) {
    }

    @EventId(268501025)
    public int Skill_IsMagic(int skill_id) {
        return 0;
    }

    @EventId(269156357)
    public void BroadcastOnScreenMsgStr(Creature creature, int radius, int type, int unk1, int unk2, int unk3, int unk4,
                                        int unk5, int time, int unk7, String msg) {
    }

    @EventId(268632084)
    public void SendScriptEvent(Creature target, int event, int script_event_arg1) {
    }

    @EventId(268763159)
    public void InstantTeleportEx(Creature creature, int x, int y, int z, int unk) // direction?
    {
    }

    @EventId(268566643)
    public void LoadDBSavingMap(Creature creature, int map_id) {
    }

    @EventId(268632122)
    public void ClearEventRoom(int room_index, int party_type, int flag) {
    }

    @EventId(268697614)
    public void SendMakerScriptEvent(NpcMaker maker, int event, int script_event_arg1, int script_event_arg2) {
    }

    @EventId(268501002)
    public NpcMaker GetNpcMaker(String maker_name) {
        return null;
    }

    @EventId(268566640)
    public void RegisterDBSavingMap(int map_id, int unk) {
    }

    @EventId(268566568)
    public Party GetPartyFromEventRoom(int room_index, int ssq_part) {
        return null;
    }

    @EventId(268632152)
    public int GetNRMemoStateEx(Creature talker, int quest_id, int unk) {
        return 0;
    }

    @EventId(268501106)
    public int GetDBSavingMap(int map_id) {
        return 0;
    }

    @EventId(268697643)
    public String GetTimeAttackRecordInfo(int unk1, int unk2, int unk3, int unk4) {
        return null; // int compatiable string
    }

    @EventId(268501048)
    public int StrToInt(String str) {
        return Integer.parseInt(str);
    }

    @EventId(268435465)
    public int GetTimeOfDay() {
        return 0;
    }

    @EventId(268566555)
    public void Area_SetOnOff(String area_name, int value) // 0 = off, 1 = on
    {
    }

    @EventId(268501005)
    public Npc GetNPCFromID(int npc_id) {
        return null;
    }

    @EventId(268566543)
    public int CreateRoomInfoList(String level_name, int unk) {
        return 0;
    }

    @EventId(268632124)
    public void SetNpcParam(Creature npc, int param, Object value) {
    }

    @EventId(268501008)
    public RoomInfoList GetRoomInfoList(String level_name) {
        return null;
    }

    @EventId(268632175)
    public void SendDominionScriptEvent(int creature_index, int dominion_id, int event) {
    }

    @EventId(268501009)
    public void Announce(String msg) {
    }

    @EventId(268501033)
    public Party GetPartyFromID(int id) {
        return null;
    }

    @EventId(268566621)
    public int OwnItemEnchantCount(Creature talker, int item_id) {
        return 0;
    }

    @EventId(268501090)
    public int GetBirthdayGiftCount(Creature talker) {
        return 0;
    }

    @EventId(268501089)
    public void SaveGetBirthdayGiftTime(Creature talker) {
    }

    @EventId(268501093)
    public boolean CanGet5YearGift(Creature talker) {
        return false;
    }

    @EventId(268501095)
    public void SaveGet5YearGiftTimeCount(Creature talker) {
    }

    @EventId(268501000)
    public int GetL2Time(int unk) {
        return 0;
    }

    @EventId(268501070)
    public int Fortress_GetOwnerPledgeId(int fortress_id) {
        return 0;
    }

    @EventId(268566608)
    public int Fortress_GetFacilityLevel(int fortress_id, int unk1) {
        return 0;
    }

    @EventId(268632093)
    public void Castle_GateOpenCloseEx(String door_name, int value, int instant_zone_id) {
    }

    @EventId(268632149)
    public void Area_SetOnOffEx(String area_name, int value, int instant_zone_id) {
    }

    @EventId(268697621)
    public void SendScriptEventEx(Creature creature, int event_id, int script_event_arg1, int script_event_arg2) {
    }

    @EventId(268566539)
    public NpcMaker InstantZone_GetNpcMaker(int instant_zone_id, String maker_name) {
        return null;
    }

    @EventId(268697686)
    public void Area_SetBannedTerritoryOnOff(String area_name, int value, int unk, int instant_zone_id) {
    }

    @EventId(268501071)
    public int Fortress_GetParentCastleId(int fortress_id) {
        return 0;
    }

    @EventId(268501075)
    public int Fortress_GetRentCost(int fortress_id) {
        return 0;
    }

    @EventId(268501076)
    public int Fortress_GetNextRewardRemainTime(int fortress_id) {
        return 0;
    }

    @EventId(268501074)
    public int Fortress_GetAvailableOwnMinutes(int fortress_id) {
        return 0;
    }

    @EventId(268566620)
    public String GetRank_RimKamaroka(int unk1, int unk2) {
        return "";
    }

    @EventId(268632155)
    public void SetPoint_RimKamaroka(Creature talker, int point, int instance_zone_id) {
    }

    @EventId(268632089)
    public void AddLogExWithoutCreature(int unk1, int unk2, int unk3) {
    }

    @EventId(268566564)
    public int GetAbnormalMagicLevel(Creature creature, int abnormal_type) {
        return 0;
    }

    @EventId(268566636)
    public void InzoneDoorBreakable(String door_name, int instance_zone_id) {
    }

    @EventId(269090910)
    public void SendUIEvent(Creature creature, int unk1, int unk2, int unk3, String unk4, String unk5, String unk6,
                            String unk7, String unk8, String unk9) {
    }

    @EventId(268566647)
    public void SetXMasEventState(int skill, int unk) {
    }

    @EventId(268632186)
    public void ShowMsgInTerritory(int unk, String my_trr, int msg) {
    }

    @EventId(268632187)
    public void ShowMsgInTerritory2(int unk, String terr_id, String str) {
    }

    @EventId(268632189)
    public Point GetRandomPosInCreature(Creature creature, int min_distance, int max_distance) {
        return null;
    }

    @EventId(268566652)
    public Point GetRandomPosInTerritory(String area_name, int unk) {
        return null;
    }

    @EventId(268501124)
    public void LoadJackpotTime(int time) {
    }

    @EventId(268501125)
    public boolean IsJackpotTime(int date) {
        return false;
    }

    @EventId(268435590)
    public int GetPlayingUserAverage() {
        return 0;
    }

    @EventId(268435593)
    public int GetEventElapsedTime() {
        return 0;
    }

    @EventId(268566668)
    public void SetEventValue(int key, int value) {
    }

    @EventId(268566666)
    public void SetEventDebugInfo(int unk1, int unk2) {
    }

    @EventId(268501131)
    public int GetEventValue(int key) {
        return 0;
    }

    @EventId(268697735)
    public void StartBuffEvent(int unk1, int unk2, int unk3, int unk4) {
    }

    @EventId(269025416)
    public void SetEventState(int date, int unk1, int unk2, int unk3, int unk4, int unk5, int unk6, String str1,
                              String str2) {
    }

    @EventId(268632136)
    public void AddPointWithoutActor_FieldCycle(int field_cycle, int state, int point) {
    }

    @EventId(268566615)
    public void AddScriptLog(int log, String str) {
    }

    @EventId(268501109)
    public int GetDominionState(int dominion_id) {
        return 0;
    }

    @EventId(268435468)
    public CodeInfoList AllocCodeInfoList() {
        return null;
    }

    @EventId(268566593)
    public void AddPCSocial(int creature_index, int unk) {
    }

    @EventId(268632121)
    public void AddPartyToEventRoom(int event_room, int SSQ_type, int party_id) {
    }

    @EventId(268566577)
    public boolean GetTimeAttackRewardFlag(Creature talker, int unk) {
        return false;
    }

    @EventId(268566576)
    public boolean IsWinnerOfTimeAttackEvent(Creature talker, int unk) {
        return false;
    }
}
