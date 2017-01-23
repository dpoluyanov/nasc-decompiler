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

import java.util.List;

/**
 * Created by Дмитрий on 12.05.2015.
 */
public class Npc {
    @EventId(1040)
    public int p_state;


    @EventId(1048)
    public int i_quest0;

    @EventId(1056)
    public int i_quest1;

    @EventId(1064)
    public int i_quest2;

    @EventId(1072)
    public int i_quest3;

    @EventId(1080)
    public int i_quest4;

    @EventId(1088)
    public int i_quest5;

    @EventId(1096)
    public int i_quest6;

    @EventId(1104)
    public int i_quest7;

    @EventId(1112)
    public int i_quest8;

    @EventId(1120)
    public int i_quest9;

    @EventId(1128)
    public int i_ai0;

    @EventId(1136)
    public int i_ai1;

    @EventId(1144)
    public int i_ai2;

    @EventId(1152)
    public int i_ai3;

    @EventId(1160)
    public int i_ai4;

    @EventId(1168)
    public int i_ai5;

    @EventId(1176)
    public int i_ai6;

    @EventId(1184)
    public int i_ai7;

    @EventId(1192)
    public int i_ai8;

    @EventId(1200)
    public int i_ai9;

    @EventId(1208)
    public int attack_tick;

    @EventId(1216)
    public Creature c_quest0;

    @EventId(1224)
    public Creature c_quest1;

    @EventId(1232)
    public Creature c_quest2;

    @EventId(1240)
    public Creature c_quest3;

    @EventId(1248)
    public Creature c_quest4;

    @EventId(1256)
    public Creature c_ai0;

    @EventId(1264)
    public Creature c_ai1;

    @EventId(1272)
    public Creature c_ai2;

    @EventId(1280)
    public Creature c_ai3;

    @EventId(1288)
    public Creature c_ai4;
    @EventId(1464)
    public IntList int_list;
    @EventId(1472)
    public int m_WorldTrapState;
    @EventId(1480)
    public Creature sm;
    @EventId(1488)
    public Creature master;
    @EventId(1496)
    public Creature boss;
    @EventId(1504)
    public Creature top_desire_target;
    @EventId(1524)
    public int start_x;
    @EventId(1528)
    public int start_y;
    @EventId(1532)
    public int start_z;
    @EventId(1620)
    public int sit_on_stop;
    @EventId(1360)
    public AtomicValue av_quest0;


    // FUNCTIONS

    @EventId(235012172)
    public void ShowPage(Creature talker, String page) {
    }

    @EventId(234946563)
    public boolean IsNullParty(Party party) {
        return party == null;
    }

    @EventId(234946601)
    public int GetDirectionToTarget(Creature creature) {
        return 0;
    }

    @EventId(235012672)
    public void Whisper(Creature creature, String msg) {
    }

    @EventId(234946797)
    public int Skill_GetAbnormalType(int skillId) {
        return 0;
    }

    @EventId(235012606)
    public void Dispel(Creature creature, int abnormal_type) {
    }

    @EventId(235012143)
    public void AddTimerEx(int timer_id, int delay) {
    }

    @EventId(235602168)
    public int CreateOnePrivateEx(int npc_id, String ai_type, int i1, int i2, int x, int y, int z, int heading, int i7,
                                  int i8, int i9) {
        return 0;
    }

    @EventId(235143192)
    public void AddEffectActionDesire(Creature creature, int action_id, int i1, double point) {
    }

    @EventId(234881209)
    public int Castle_GetPledgeId() {
        return 0;
    }

    @EventId(235012239)
    public void FHTML_SetFileName(FHTML fhtml, String filename) {
    }

    @EventId(235077776)
    public void FHTML_SetInt(FHTML fhtml, String find, int replacement) {
    }

    @EventId(234881184)
    public String Castle_GetPledgeName() {
        return "";
    }

    @EventId(234881185)
    public String Castle_GetOwnerName() {
        return "";
    }

    @EventId(234881188)
    public int Residence_GetTaxRateCurrent() {
        return 0;
    }

    @EventId(235012243)
    public void ShowFHTML(Creature creature, FHTML fhtml) {
    }

    @EventId(235012190)
    public void ShowMultisell(int multisell_id, Creature talker) {
    }

    @EventId(234947032)
    public void ShowVariationMakeWindow(Creature talker) {
    }

    @EventId(234947033)
    public void ShowVariationCancelWindow(Creature talker) {
    }

    @EventId(235078121)
    public void InstantZone_Enter(Creature talker, int zone_type, int enter_type) {
    }

    @EventId(234947050)
    public void InstantZone_Leave(Creature talker) {
    }

    @EventId(234947051)
    public void InstantZone_Finish(int delay) {
    }

    @EventId(235012216)
    public Creature GetMemberOfParty(Party party, int index) {
        return null;
    }

    @EventId(235012323)
    public boolean IsInCategory(int category_id, int cat) {
        return false;
    }

    @EventId(235012210)
    public int GetOneTimeQuestFlag(Creature creature, int quest) {
        return 0;
    }

    @EventId(234946686)
    public Clan GetPledge(Creature creature) {
        return null;
    }

    @EventId(234946561)
    public boolean IsNullCreature(Creature creature) {
        return false;
    }

    @EventId(234946719)
    public boolean IsMyLord(Creature creature) {
        return false;
    }

    @EventId(234881200)
    public boolean Castle_IsUnderSiege() {
        return false;
    }

    @EventId(234881206)
    public int Castle_GetRawSiegeTime() {
        return 0;
    }

    @EventId(234881207)
    public int Castle_GetRawSystemTime() {
        return 0;
    }

    @EventId(234946679)
    public Creature GetLeaderOfParty(Party party) {
        return null;
    }

    @EventId(235077772)
    public void DeleteItem1(Creature talker, int itemId, long count) {
    }

    @EventId(235077769)
    public void GiveItem1(Creature talker, int itemId, int count) {
    }

    @EventId(235077743)
    public void SetFlagJournal(Creature talker, int quest, int state) {
    }

    @EventId(235012493)
    public void ShowQuestMark(Creature talker, int quest) {
    }

    @EventId(235012350)
    public void SoundEffect(Creature talker, String sound) {
    }

    @EventId(234946925)
    public int GetSSQSealOwner(int seal) {
        return 0;
    }

    @EventId(234881387)
    public int GetSSQStatus() {
        return 0;
    }

    @EventId(235012386)
    public void RideWyvern(Creature talker, int wyvern) {
    }

    @EventId(235012534)
    public void CastBuffForQuestReward(Creature talker, int skill_id) {
    }

    @EventId(234946663)
    public void OpenHennaItemListForEquip(Creature talker) {
    }

    @EventId(234946664)
    public void OpenHennaListForUnquip(Creature talker) {
    }

    @EventId(235077640)
    public void AddAttackDesire(Creature talker, int desire_id, double point) {
    }

    @EventId(235143191)
    public void AddMoveToDesire(int x, int y, int z, double point) {
    }

    @EventId(235012103)
    public void AddDoNothingDesire(int unk, double point) {
    }

    @EventId(235012101)
    public void AddMoveAroundDesire(int unk, double point) {
    }

    @EventId(235208724)
    public void AddUseSkillDesire(Creature talker, int skill_id, int unk1, int unk2, double point) {
    }

    @EventId(234946821)
    public boolean InMyTerritory(Creature creature) {
        return false;
    }

    @EventId(235143256)
    public void InstantTeleport(Creature creature, int x, int y, int z) {
    }

    @EventId(234881114)
    public void InstantRandomTeleportInMyTerritory() {
    }

    @EventId(235143187)
    public void AddMoveToWayPointDesire(WayPointsType wayPointsType, WayPointDelaysType wayPointDelaysType, int index,
                                        double point) {
    }

    @EventId(235012197)
    public int GetWayPointDelay(WayPointDelaysType wayPointDelays, int way_point_index) {
        return 0;
    }

    @EventId(234947026)
    public int GetPledgeMemberCount(Creature talekr) {
        return 0;
    }

    @EventId(234947132)
    public int IsLordOfCastle(Creature talker) {
        return 0;
    }

    @EventId(235077884)
    public void IncrementParam(Creature talker, int param, int value) {
    }

    @EventId(235012369)
    public void PledgeLevelUp(Creature talker, int level) {
    }

    @EventId(234946795)
    public int Skill_GetConsumeMP(int skill_id) {
        return 0;
    }

    @EventId(234946794)
    public int Skill_GetConsumeHP(int skill_id) {
        return 0;
    }

    @EventId(234946799)
    public int Skill_InReuseDelay(int skill_id) {
        return 0;
    }

    @EventId(234947019)
    public int OwnPledgeNameValue(Creature talker) {
        return 0;
    }

    @EventId(235012554)
    public void UpdatePledgeNameValue(Creature talker, int value) {
    }

    @EventId(234947101)
    public boolean IsDominionOfLord(int dominion_id) {
        return false;
    }

    @EventId(234947023)
    public boolean HasAcademy(Creature talker) {
        return false;
    }

    @EventId(235012214)
    public boolean HavePledgePower(Creature talker, int unk) {
        return false;
    }

    @EventId(235012556)
    public void CreateAcademy(Creature talker, String name) {
    }

    @EventId(235012558)
    public boolean HasSubPledge(Creature talker, int unk) {
        return false;
    }

    @EventId(235143629)
    public void CreateSubPledge(Creature talker, int unk1, int unk2, String name) {
    }

    @EventId(235143394)
    public void ShowGrowEtcSkillMessage(Creature talker, int skill_name_id, int unk1, String unk2) {
    }

    @EventId(235077857)
    public void ShowEtcSkillList(Creature talker, int unk1, String unk2) {
    }

    @EventId(234947055)
    public void ShowChangePledgeNameUI(Creature talker) {
    }

    @EventId(234946564)
    public boolean IsNullString(String str) {
        return false;
    }

    @EventId(234946710)
    public int GetPledgeSkillLevel(Creature talker) {
        return 0;
    }

    @EventId(235012174)
    public void ShowSystemMessage(Creature talker, int msg_id) {
    }

    @EventId(235077747)
    public void SetOneTimeQuestFlag(Creature talker, int quest_num, int flag) {
    }

    @EventId(235012212)
    public int GetInventoryInfo(Creature talker, int param) {
        return 0;
    }

    @EventId(235012324)
    public void ClassChange(Creature talker, int class_lv) {
    }

    @EventId(234947013)
    public boolean IsAcademyMember(Creature talker) {
        return false;
    }

    @EventId(234946616)
    public Creature GetSummon(Creature talker) {
        return null;
    }

    @EventId(235077931)
    public void GetSubJobList(Creature talker, int unk1, int state) {
    }

    @EventId(235012397)
    public void ChangeSubJob(Creature talker, int subjob) {
    }

    @EventId(235012396)
    public void CreateSubJob(Creature talker, int subjob) {
    }

    @EventId(235077934)
    public void RenewSubJob(Creature talker, int unk, int subjob) {
    }

    @EventId(235012316)
    public void ShowSkillList(Creature talker, String str) {
    }

    @EventId(235077854)
    public void ShowGrowSkillMessage(Creature talker, int skill_name_id, String unk) {
    }

    @EventId(235012317)
    public void ShowEnchantSkillList(Creature talker, int action_id) {
    }

    @EventId(234946626)
    public void Say(String str) {
    }

    @EventId(235078117)
    public void ShowEnchantSkillListDrawer(Creature talker, int skill_name_id, int action_id) {
    }

    @EventId(235077856)
    public void ShowEnchantSkillMessage(Creature talker, int skill_name_id, int action_id) {
    }

    @EventId(235012607)
    public void DeleteAcquireSkills(Creature talker, int unk) {
    }

    @EventId(235143646)
    public void AddLogByNpc(int unk, Creature talker, int unk1, int unk2) {
    }

    @EventId(234947057)
    public int GetPledgeCastleSiegeDefenceCount(Creature talker) {
        return 0;
    }

    @EventId(235209202)
    public void GiveItemByCastleSiegeDefence(Creature talker, int unk1, int unk2, int unk3, int unk4) {
    }

    @EventId(235143261)
    public void ShowBuySell(Creature talker, BuySellItemInfo[] Buylist, BuySellItemInfo[] SellList, int unk) {
    }

    @EventId(235274332)
    public void SellPreview(Creature talker, BuySellItemInfo[] SellList, String shopName, String html, String unk1,
                            String unk2) {
    }

    @EventId(235012237)
    public ItemData GetItemData(Creature talker, int item_id) {
        return null;
    }

    @EventId(235143454)
    public void CreatePet(Creature talker, int item_id, int unk1, int unk2) {
    }

    @EventId(235012175)
    public void ShowSystemMessageStr(Creature target, String fString) {
    }

    @EventId(234946656)
    public int DistFromMe(Creature creature) {
        return 0;
    }

    @EventId(235012385)
    public void EvolvePetWithSameExp(Creature creature, int unk1) {
    }

    @EventId(235274527)
    public void EvolvePet(Creature talker, int item_dbid, int class_id_baby_pet, int item_grown_pet,
                          int class_id_grown_pet,
                          int item_pet_level) {
    }

    @EventId(234946734)
    public void Castle_GateOpenClose(int value) {
    }

    @EventId(234881282)
    public void Despawn() {
    }

    @EventId(234947075)
    public int GetPVPPoint(Creature talker) {
        return 0;
    }

    @EventId(235012609)
    public void UpdatePVPPoint(Creature talker, int diff) {
    }

    @EventId(234946980)
    public void SetNobless(Creature talker) {
    }

    @EventId(234946955)
    public boolean IsNewbie(Creature talker) {
        return false;
    }

    @EventId(234881473)
    public int GetFishingEventRewardRemainTime() {
        return 0;
    }

    @EventId(234947012)
    public void GiveFishingEventPrize(Creature talker) {
    }

    @EventId(234947011)
    public void ShowHtmlFishingEventRanking(Creature talker) {
    }

    @EventId(234947010)
    public int GetFishingEventRanking(Creature talker) {
        return 0;
    }

    @EventId(235012450)
    public void ShowSellSeedList(Creature talker, int manor_id) {
    }

    @EventId(235012451)
    public void ShowProcureCropList(Creature talker, int manor_id) {
    }

    @EventId(235012432)
    public int GetCurrentSeedSellCountSet(int state, int index) {
        return 0;
    }

    @EventId(235012434)
    public int GetCurrentSeedPrice(int state, int index) {
        return 0;
    }

    @EventId(235012433)
    public int GetCurrentSeedRemainCount(int state, int index) {
        return 0;
    }

    @EventId(235012443)
    public int GetRemainProcureCropCount(int manor_id, int index) {
        return 0;
    }

    @EventId(235012441)
    public int GetProcurementCount(int manor_id, int index) {
        return 0;
    }

    @EventId(235012440)
    public int GetProcurementRate(int manor_id, int index) {
        return 0;
    }

    @EventId(235012442)
    public int GetProcurementType(int manor_id, int index) {
        return 0;
    }

    @EventId(235012445)
    public int GetNextProcurementCount(int state, int index) {
        return 0;
    }

    @EventId(235012444)
    public int GetNextProcurementRate(int state, int index) {
        return 0;
    }

    @EventId(235012446)
    public int GetNextProcurementType(int state, int index) {
        return 0;
    }

    @EventId(234881256)
    public boolean IsManorSettingTime() {
        return false;
    }

    @EventId(235012435)
    public int GetNextSeedSellCountSet(int state, int index) {
        return 0;
    }

    @EventId(235012436)
    public int GetNextSeedPrice(int state, int index) {
        return 0;
    }

    @EventId(235077988)
    public void ShowSeedInfo(Creature talker, int id, int time) {
    }

    @EventId(235077989)
    public void ShowCropInfo(Creature talker, int id, int time) {
    }

    @EventId(234946918)
    public void ShowManorDefaultInfo(Creature talker) {
    }

    @EventId(235012457)
    public void ShowProcureCropDetail(Creature talker, int state) {
    }

    @EventId(235012608)
    public void RegisterTeleporterType(int type, int unk) {
    }

    @EventId(234881461)
    public int GetPCCafePointEventState() {
        return 0;
    }

    @EventId(234946994)
    public int GetPCCafePoint(Creature talker) {
        return 0;
    }

    @EventId(234881492)
    public int GetPCCafeCouponEventState() {
        return 0;
    }

    @EventId(234947027)
    public boolean IsPCCafeUser(Creature talker) {
        return false;
    }

    @EventId(234946956)
    public void ShowQuestInfoList(Creature talker) {
    }

    @EventId(235012180)
    public void ShowTelPosListPage(Creature talker, TelPosInfo[] telPosInfos) {
    }

    @EventId(235012531)
    public boolean UpdatePCCafePoint(Creature talker, int diff) {
        return false;
    }

    @EventId(235209140)
    public void GiveItemByPCCafePoint(Creature talker, int unk1, int unk2, int unk3, int unk4) {
    }

    @EventId(235012597)
    public void UpdatePCCafePoint2(Creature talker, int count) {
    }

    @EventId(234947035)
    public boolean IsInCombatMode(Creature creature) {
        return false;
    }

    @EventId(235143459)
    public void RideForEvent(Creature talker, int pet_id, int unk1, int unk2) {
    }

    @EventId(235405397)
    public void Teleport(Creature talker, TelPosInfo[] posInfos, String str1, String str2, String str3, String str4,
                         int unk, String msg) {
    }

    @EventId(234881418)
    public boolean CanLotto() {
        return false;
    }

    @EventId(235143276)
    public void SetMemoStateEx(Creature talker, int quest_id, int state, int unk) {
    }

    @EventId(234947008)
    public void CheckCursedUser(Creature talker) {
    }

    @EventId(234881451)
    public NpcMaker GetMyMaker() {
        return null;
    }

    @EventId(234946735)
    public int Castle_GetPledgeState(Creature talker) {
        return 0;
    }

    @EventId(234881210)
    public int Castle_GetLifeControlLevel() {
        return 0;
    }

    @EventId(235143431)
    public void InstantTeleportInMyTerritory(int x, int y, int z, int unk) {
    }

    @EventId(234946632)
    public void Shout(String str) {
    }

    @EventId(235078159)
    public void SetNRMemoState(Creature talker, int mission, int value) {
    }

    @EventId(234881187)
    public int Residence_GetTaxRate() {
        return 0;
    }

    @EventId(234881253)
    public int Residence_GetTaxIncome() {
        return 0;
    }

    @EventId(234881254)
    public int Residence_GetTaxIncomeReserved() {
        return 0;
    }

    @EventId(234881255)
    public int Manor_GetSeedIncome() {
        return 0;
    }

    @EventId(234946866)
    public void OpenSiegeInfo(Creature talker) {
    }

    @EventId(234946935)
    public int GetTicketBuyCount(Creature talker) {
        return 0;
    }

    @EventId(235012635)
    public void RegisterDominion(int dominion_id, Creature talker) {
    }

    @EventId(234946754)
    public int Agit_GetDecoLevel(int param) {
        return 0;
    }

    @EventId(235012295)
    public int Agit_GetDecoFee(int param, int deco_level) {
        return 0;
    }

    @EventId(235012294)
    public int Agit_GetDecoDay(int param, int deco_level) {
        return 0;
    }

    @EventId(234946755)
    public int Agit_GetDecoExpire(int param) {
        return 0;
    }

    @EventId(234946747)
    public void Castle_GetRelatedFortressList(Creature talker) {
    }

    @EventId(234946725)
    public void Residence_SetTaxRate(int value) {
    }

    @EventId(235077675)
    public void SetCookie(Creature talker, String param, int value) {
    }

    @EventId(235012140)
    public int GetCookie(Creature talker, String cookie) {
        return 0;
    }

    @EventId(235012404)
    public void GetDoorHpLevel(Creature talker, String door_name) {
    }

    @EventId(235012406)
    public void GetControlTowerLevel(Creature talker, String unk) {
    }

    @EventId(234881203)
    public void Castle_BanishOthers() {
    }

    @EventId(235012266)
    public void Residence_VaultTakeOutMoney(Creature talker, int reply) {
    }

    @EventId(235012267)
    public void Residence_VaultSaveMoney(Creature talker, int reply) {
    }

    @EventId(235012431)
    public int GetMaxSellableCount(int unk1, int unk2) {
        return 0;
    }

    @EventId(235012439)
    public int GetSeedDefaultPrice(int unk1, int unk2) {
        return 0;
    }

    @EventId(235012449)
    public int GetCropClassidByOrderNum(int unk, int reply) {
        return 0;
    }

    @EventId(235012472)
    public void SetTicketBuyCount(Creature talker, int unk) {
    }

    @EventId(235012289)
    public void Agit_ResetDeco(Creature talker, int i0) {
    }

    @EventId(235077824)
    public void Agit_SetDeco(Creature talker, int unk1, int unk2) {
    }

    @EventId(235012535)
    public void CastBuffForAgitManager(Creature talker, int reply) {
    }

    @EventId(235012403)
    public void SetDoorHpLevel(String door_name, int hp) {
    }

    @EventId(235012405)
    public void SetControlTowerLevel(String towerName, int level) {
    }

    @EventId(235012455)
    public void ShowSeedSetting(Creature talker, int state) {
    }

    @EventId(235012456)
    public void ShowCropSetting(Creature talker, int state) {
    }

    @EventId(234946772)
    public int Fortress_IsInBoundary(int param) {
        return 0;
    }

    @EventId(234946685)
    public Creature Pledge_GetLeader(Creature talker) {
        return null;
    }

    @EventId(235012187)
    public void TeleportToUser(Creature talker, Creature user) {
    }

    @EventId(234881186)
    public String Castle_GetSiegeTime() {
        return null;
    }

    @EventId(235012392)
    public void TB_GetPledgeRegisterStatus(Creature talker, int status) {
    }

    @EventId(234946853)
    public void TB_RegisterMember(Creature talker) {
    }

    @EventId(234946854)
    public void TB_GetNpcType(Creature talker) {
    }

    @EventId(235012391)
    public void TB_SetNpcType(Creature talker, int type) {
    }

    @EventId(234946857)
    public void TB_GetBattleRoyalPledgeList(Creature talker) {
    }

    @EventId(235012205)
    public void RemoveMemo(Creature talker, int memo) {
    }

    @EventId(234946852)
    public void TB_RegisterPledge(Creature talker) {
    }

    @EventId(234946687)
    public Clan GetPledgeByIndex(int index) {
        return null;
    }

    @EventId(234881214)
    public int Agit_GetCostFailDay() {
        return 0;
    }

    @EventId(234946760)
    public void AuctionAgit_GetAgitCostInfo(Creature talker) {
    }

    @EventId(234881348)
    public int Lotto_GetState() {
        return 0;
    }

    @EventId(234881061)
    public int GetLifeTime() {
        return 0;
    }

    @EventId(234881350)
    public int Lotto_GetRoundNumber() {
        return 0;
    }

    @EventId(234881358)
    public String Lotto_GetChosenNumber() {
        return null;
    }

    @EventId(234881353)
    public int Lotto_GetAccumulatedReward() {
        return 0;
    }

    @EventId(234946890)
    public void Lotto_MakeFinalRewardFHTML(FHTML fhtml) {
    }

    @EventId(235012427)
    public void Lotto_ShowPrevRewardPage(Creature talker, int reply) {
    }

    @EventId(235012428)
    public void Lotto_GiveReward(Creature talker, int reply) {
    }

    @EventId(235077959)
    public void Lotto_ShowBuyingPage(Creature talker, int reply, FHTML fhtml) {
    }

    @EventId(235077960)
    public void Lotto_BuyTicket(Creature talker, int reply, int unk1) {
    }

    @EventId(235012429)
    public void Lotto_ShowCurRewardPage(Creature talker, int reply) {
    }

    @EventId(234946619)
    public void LookNeighbor(int radius) {
    }

    @EventId(234946592)
    public void RemoveAttackDesire(int creature_objid) {
    }

    @EventId(234946803)
    public void UseSoulShot(int unk) {
    }

    @EventId(235077876)
    public void UseSpiritShot(int unk1, int spiritshot_speed_bonus, int spiritshot_heal_bonus) {
    }

    @EventId(234881055)
    public void RemoveAllAttackDesire() {
    }

    @EventId(235077692)
    public void BroadcastScriptEvent(int event, int event_arg, int radius) {
    }

    @EventId(234946600)
    public int GetDirection(Creature creature) {
        return 0;
    }

    @EventId(234881081)
    public int GetTimeHour() {
        return 0;
    }

    @EventId(234946945)
    public int GetAngleFromTarget(Creature target) {
        return 0;
    }

    @EventId(234946796)
    public int Skill_GetEffectPoint(int skill_name_id) {
        return 0;
    }

    @EventId(234881086)
    public int GetPathfindFailCount() {
        return 0;
    }

    @EventId(234881283)
    public void Suicide() {
    }

    @EventId(234946624)
    public boolean CanAttack(Creature target) {
        return false;
    }

    @EventId(235077667)
    public void MakeAttackEvent(Creature speller, double point, int unk1) {
    }

    @EventId(235209016)
    public void AddHateInfo(Creature target, int point, int unk1, int unk2, int unk3) {
    }

    @EventId(234946878)
    public HateInfo GetMaxHateInfo(int unk) {
        return null;
    }

    @EventId(234946562)
    public boolean IsNullHateInfo(HateInfo hateInfo) {
        return false;
    }

    @EventId(235012418)
    public void RemoveAllHateInfoIF(int unk1, int unk2) {
    }

    @EventId(234881338)
    public int GetHateInfoCount() {
        return 0;
    }

    @EventId(234881523)
    public boolean IsMyBossAlive() {
        return false;
    }

    @EventId(235012111)
    public void AddFollowDesire(Creature creater, double point) {
    }

    @EventId(235077660)
    public void AddMoveSuperPointDesire(String pointName, int pointMethod, double point) {
    }

    @EventId(235077661)
    public void AddMoveFreewayDesire(int freeway_id, int freewayMethod, double point) {
    }

    @EventId(234946806)
    public void CreatePrivates(String privates) {
    }

    @EventId(235012109)
    public void AddFleeDesire(Creature attacker, double point) {
    }

    @EventId(235143415)
    public void CreateOnePrivate(int npc_id, String npc_ai, int unk1, int unk2) {
    }

    @EventId(234881166)
    public Creature GetLastAttacker() {
        return null;
    }

    @EventId(234881516)
    public void InstantZone_MarkRestriction() {
    }

    @EventId(235143229)
    public void BroadcastScriptEventEx(int event_id, int script_event_arg1, int stript_event_arg2, int radius) {
    }

    @EventId(235012154)
    public void Summon_SetOption(int unk1, int unk2) {
    }

    @EventId(234946586)
    public void AddPetDefaultDesire_Follow(double unk1) {
    }

    @EventId(235339797)
    public void AddUseSkillDesireEx(int id, int skill, int unk1, int reply, int ask, double point, int unk2) {
    }

    @EventId(235143195)
    public void AddMoveToTargetDesire(int target_id, int unk1, int unk2, double point) {
    }

    @EventId(234881070)
    public void StopMove() {
    }

    @EventId(235012198)
    public void ChangeStopType(int type, int unk) // time ?
    {
    }

    @EventId(234946609)
    public boolean IsStaticObjectID(int objecti_id) {
        return false;
    }

    @EventId(234946612)
    public StaticObject GetStaticObjectFromID(int object_id) {
        return null;
    }

    @EventId(234946658)
    public int StaticObjectDistFromMe(StaticObject staticObject) {
        return 0;
    }

    @EventId(235143177)
    public void AddAttackDesireEx(int target_id, int unk1, int unk2, double point) {
    }

    @EventId(234881058)
    public void RandomizeAttackDesire() {
    }

    @EventId(235077888)
    public void EffectMusic(Creature object, int unk, String music) // unk is radius?
    {
    }

    @EventId(234881063)
    public int GetCurrentTick() {
        return 0;
    }

    @EventId(235077765)
    public void MPCC_SetMasterPartyRouting(int id, Creature creature, int unk) {
    }

    @EventId(234946692)
    public int MPCC_GetMPCCId(Creature talker) {
        return 0;
    }

    @EventId(234946688)
    public Creature MPCC_GetMaster(int mpcc_id) {
        return null;
    }

    @EventId(234946691)
    public int MPCC_GetMemberCount(int master_id) {
        return 0;
    }

    @EventId(235012334)
    public boolean Skill_HaveAttribute(int skill_name_id, int unk) {
        return false;
    }

    @EventId(235077677)
    public void SetTeleportPosOnLost(int x, int y, int z) {
    }

    @EventId(234881454)
    public void RemoveAllDesire() {
    }

    @EventId(235536863)
    public void AddLogByNpc2(int unk0, Creature creature, String title, String msg, int unk1, int unk2, int unk3,
                             int unk4,
                             int unk5, int unk6) {
    }

    @EventId(234946615)
    public int GetGlobalMap(int map_id) {
        return 0;
    }

    @EventId(235012149)
    public void RegisterGlobalMap(int map_id, int unk) {
    }

    @EventId(234946614)
    public void UnregisterGlobalMap(int map_id) {
    }

    @EventId(235012213)
    public void SetDBValue(Creature npc, int db_value) {
    }

    @EventId(234946939)
    public void RegisterToEventListener(int unk) {
    }

    @EventId(234881388)
    public int GetSSQWinner() {
        return 0;
    }

    @EventId(234946938)
    public boolean IsJoinableToDawn(Creature talker) {
        return false;
    }

    @EventId(235340042)
    public void EarthQuakeByNPC(Creature npc, int unk1, int unk2, int unk3, int unk4, int unk5, int unk6) {
    }

    @EventId(235077887)
    public void VoiceEffect(Creature talker, String voice, int unk) // duration?
    {
    }

    @EventId(235012372)
    public void ShowTutorialHTML(Creature talker, String html) {
    }

    @EventId(235012169)
    public void ShoutEx(String msg, int unk) // radius ?
    {
    }

    @EventId(235078003)
    public int GetDepositedSSQItemCount(Creature talker, int ssq_type, int item_type) {
        return 0;
    }

    @EventId(235143542)
    public void DeleteDepositedSSQItem(Creature talker, int ssq_type, int item_type, int unk) {
    }

    @EventId(234881489)
    public int GetSSQPrevWinner() {
        return 0;
    }

    @EventId(235274609)
    public boolean AddSSQMember(Creature talker, int unk1, int unk2, int unk3, int unk4, int unk5) {
        return false;
    }

    @EventId(234946984)
    public Creature FindNeighborHero(int radius) {
        return null;
    }

    @EventId(234946596)
    public int GetTopDesireValue(int unk) {
        return 0;
    }

    @EventId(235012377)
    public void EnableTutorialEvent(Creature talker, int mask) {
    }

    @EventId(234946840)
    public void CloseTutorialHTML(Creature talker) {
    }

    @EventId(235012374)
    public void ShowQuestionMark(Creature talker, int unk) {
    }

    @EventId(235143445)
    public void ShowTutorialHTML2(Creature talker, String html, int unk, String sound_effect) {
    }

    @EventId(235208986)
    public void ShowRadar(Creature talker, int x, int y, int z, int unk) {
    }

    @EventId(235077739)
    public void SetMemoState(Creature talker, int quest_id, int state) {
    }

    @EventId(235012622)
    public void SetNRMemo(Creature talker, int quest_id) {
    }

    @EventId(235143696)
    public void SetNRMemoStateEx(Creature talker, int quest_id, int unk1, int unk2) {
    }

    @EventId(235078163)
    public void SetNRFlagJournal(Creature talker, int quest_id, int flag) {
    }

    @EventId(234946805)
    public void SetPrivateID(int unk) {
    }

    @EventId(235339859)
    public void ShowSysMsgToParty2(Party party, int unk1, int unk2, int unk3, int unk4, int unk5, int unk6) {
    }

    @EventId(234946881)
    public void RemoveHateInfoByCreature(Creature creature) {
    }

    @EventId(235012625)
    public void RemoveNRMemo(Creature talker, int quest_id) {
    }

    @EventId(234947102)
    public int GetDominionSiegeID(Creature talker) {
        return 0;
    }

    @EventId(235274624)
    public void TeleportParty(int party_id, int x, int y, int z, int unk1, int unk2) {
    }

    @EventId(234946942)
    public int GetTimeAttackFee(int value) {
        return 0;
    }

    @EventId(234946631)
    public void EquipItem(int weapon) {
    }

    @EventId(235274613)
    public void DepositSSQItemEx(Creature talker, int ssq_type, int blue, int green, int red, int unk) {
    }

    @EventId(235012336)
    public void UseSkill(Creature target, int skill) {
    }

    @EventId(234881386)
    public int GetSSQRoundNumber() {
        return 0;
    }

    @EventId(235077768)
    public int OwnItemCountEx(Creature talker, int item_id, int unk) // count ?
    {
        return 0;
    }

    @EventId(234946988)
    public void SetEnchantOfWeapon(int value) {
    }

    @EventId(234946930)
    public int GetTimeOfSSQ(int unk) {
        return 0;
    }

    @EventId(235077713)
    public void BroadcastSystemMessage(Creature creature, int unk, int msg_id) {
    }

    @EventId(235077646)
    public void AddFleeDesireEx(Creature victim, int distance, double point) {
    }

    @EventId(234881449)
    public void RegisterAsOlympiadOperator() {
    }

    @EventId(234946968)
    public int GetOlympiadPoint(Creature talker) {
        return 0;
    }

    @EventId(234946969)
    public boolean IsMainClass(Creature talker) {
        return false;
    }

    @EventId(234881429)
    public int GetOlympiadWaitingCount() {
        return 0;
    }

    @EventId(234881431)
    public int GetTeamOlympiadWaitingCount() {
        return 0;
    }

    @EventId(234881430)
    public int GetClassFreeOlympiadWaitingCount() {
        return 0;
    }

    @EventId(234946963)
    public void AddClassFreeOlympiad(Creature talker) {
    }

    @EventId(234946981)
    public void SetHero(Creature talker) {
    }

    @EventId(234946964)
    public void AddTeamOlympiad(Creature talker) {
    }

    @EventId(234946962)
    public void AddOlympiad(Creature talker) {
    }

    @EventId(234946975)
    public int GetStatusForOlympiadField(int unk) // class ?
    {
        return 0;
    }

    @EventId(234946977)
    public String GetPlayer1ForOlympiadField(int unk) // class ?
    {
        return null;
    }

    @EventId(234946978)
    public String GetPlayer2ForOlympiadField(int unk) // class ?
    {
        return null;
    }

    @EventId(234947029)
    public int GetOlympiadTradePoint(Creature talker) {
        return 0;
    }

    @EventId(234947000)
    public boolean IsWeaponEquippedInHand(Creature creature) {
        return false;
    }

    @EventId(234946982)
    public int GetPreviousOlympiadPoint(Creature talker) {
        return 0;
    }

    @EventId(235012566)
    public void DeleteOlympiadTradePoint(Creature talker, int count) {
    }

    @EventId(235012508)
    public int GetRankByOlympiadRankOrder(int reply, int unk) {
        return 0;
    }

    @EventId(235012515)
    public void ObserveOlympiad(Creature talker, int value) {
    }

    @EventId(234946970)
    public void RemoveOlympiad(Creature talker) {
    }

    @EventId(235667724)
    public void SpecialCamera(Creature creature, int unk1, int unk2, int unk3, int unk4, int unk5, int unk6, int unk7,
                              int unk8, int unk9, int unk10, int unk11) {
    }

    @EventId(235667726)
    public void SpecialCamera3(Creature creature, int unk1, int unk2, int unk3, int duration, int unk4, int unk5,
                               int unk6,
                               int unk7, int unk8, int unk9, int unk10) {
    }

    @EventId(234947007)
    public void MG_GetUnreturnedPoint(Creature talker) {
    }

    @EventId(235012394)
    public void TB_CheckMemberRegisterStatus(int agit_id, Creature talker) {
    }

    @EventId(235012538)
    public void MG_RegisterPledge(Creature talker, int agit_war_cretificates_count) {
    }

    @EventId(234947003)
    public void MG_UnregisterPledge(Creature talker) {
    }

    @EventId(234947005)
    public void MG_JoinGame(Creature talker) {
    }

    @EventId(235077770)
    public void DropItem1(Creature creature, int item_id, int count) {
    }

    @EventId(234946991)
    public void ChangeMoveType(int new_type) {
    }

    @EventId(234881501)
    public void UnequipWeapon() {
    }

    @EventId(235078032)
    public void LookItem(int radius, int unk, int item_id) {
    }

    @EventId(235012572)
    public void PlayAnimation(int animation, int range) {
    }

    @EventId(234946689)
    public int MPCC_GetPartyCount(int mpcc_id) {
        return 0;
    }

    @EventId(235471328)
    public void GiveEventItem(Creature talker, int consume_item, int consume_count, int item_id, int count, int unk1,
                              int limit_time, int unk2, int unk3) {
    }

    @EventId(235143307)
    public void DropItem2(Creature creature, int item_id, int count, int attacker_id) {
    }

    @EventId(234881524)
    public boolean IsEventDropTime() {
        return false;
    }

    @EventId(234947093)
    public void ShowPremiumItemList(Creature talker) {
    }

    @EventId(235078198)
    public int RegisterAsAirportManager(int airport_id, int platform_id, int less_than_100) {
        return 0;
    }

    @EventId(234947130)
    public boolean IsOccupiedPlatform(int id) {
        return false;
    }

    @EventId(234947129)
    public void GetOnAirShip(Creature talker) {
    }

    @EventId(235078199)
    public void SummonAirShip(Creature talker, int airport_id, int platform_id) {
    }

    @EventId(235012107)
    public void AddGetItemDesireEx(int item_index, double point) {
    }

    @EventId(235143435)
    public void EarthQuakeToParty(int party_id, int unk1, int unk2, int unk3) {
    }

    @EventId(234946768)
    public int Fortress_GetState(int fortress_id) {
        return 0;
    }

    @EventId(235077848)
    public void Fortress_SetFacility(Creature talker, int unk1, int unk2) {
    }

    @EventId(235077833)
    public void Fortress_PledgeRegister(int creature_id, int talker_id, int fortress_id) {
    }

    @EventId(235077834)
    public void Fortress_PledgeUnregister(int creature_id, int talker_id, int fortress_id) {
    }

    @EventId(234947006)
    public void MG_SetWinner(Creature creature) {
    }

    @EventId(235012664)
    public void BuyAirShip(Creature talker, int unk) {
    }

    @EventId(234947044)
    public void SetVisible(int value) {
    }

    @EventId(235012577)
    public void SetWorldTrapVisibleByClassId(int class_id, int value) {
    }

    @EventId(235012578)
    public void ActivateWorldTrapByClassId(int creature_id, int class_id) {
    }

    @EventId(235012579)
    public void DefuseWorldTrapByClassId(int creature_id, int class_id) {
    }

    @EventId(234881510)
    public int InstantZone_GetId() {
        return 0;
    }

    @EventId(235143664)
    public void SetStaticMeshStatus(Creature creature, String mesh_name, int targetable, int mesh_index) {
    }

    @EventId(235012226)
    public int MPCC_GetPartyID(int mppc_id, int party_index) {
        return 0;
    }

    @EventId(235471113)
    public void InstantTeleportMPCC(Creature talker, int x, int y, int z, int unk1, int unk2, int unk3, int unk4,
                                    int unk5) {
    }

    @EventId(234881062)
    public int GetTick() {
        return 0;
    }

    @EventId(234947034)
    public void ShowBaseAttributeCancelWindow(Creature talker) {
    }

    @EventId(235143373)
    public void Fortress_ContractCastle(int creature_id, int talker_id, int fortress_id, int castle_id) {
    }

    @EventId(235077714)
    public void BroadcastSystemMessageStr(Creature creature, int radius, String msg) {
    }

    @EventId(234946777)
    public void Fortress_ResetFacility(Creature talker) {
    }

    @EventId(234946770)
    public int Fortress_GetOwnerRewardCycleCount(int fortress_id) {
        return 0;
    }

    @EventId(235208910)
    public void Fortress_GetOwnerRewardCycleCount(int creature_id, int talker_id, int fortress_id, int item_medal,
                                                  int count) {
    }

    @EventId(234946771)
    public int Fortress_GetCastleTreasureLevel(int fortress_id) {
        return 0;
    }

    @EventId(235077839)
    public void Fortress_CastleTreasureTaken(int creature_id, int talker_id, int fortress_id) {
    }

    @EventId(234946775)
    public int Fortress_GetPledgeSiegeState(Creature creature) {
        return 0;
    }

    @EventId(235012300)
    public void Fortress_ProtectedNpcDied(int creature_id, int fortress_id) {
    }

    @EventId(235077835)
    public void Fortress_BarrackCaptured(int creature_id, int fortress_id, int barrack_id) {
    }

    @EventId(235274504)
    public void InstantTeleportInMyTerritoryWithCondition(int x, int y, int z, int unk1, int unk2, int unk3) {
    }

    @EventId(235012605)
    public void RegisterResurrectionTower(int unk1, int unk2) {
    }

    @EventId(234947062)
    public void CreatePVPMatch(int n_type) {
    }

    @EventId(235012604)
    public void CheckRegisterParty2(Party party1, Party party2) {
    }

    @EventId(235208729)
    public void AddEffectActionDesire2(Creature creature, int effect_action, int unk1, int unk2, int unk3) {
    }

    @EventId(234946871)
    public void SetMaxHateListSize(int max_size) {
    }

    @EventId(234946875)
    public HateInfo GetHateInfoByIndex(int index) {
        return null;
    }

    @EventId(234947095)
    public boolean IsStackableItemEx(int item_index) {
        return false;
    }

    @EventId(234947077)
    public void RegisterUserResurrectionTower(int creature_id) {
    }

    @EventId(234947079)
    public void IsUserPVPMatching(Creature creature) {
    }

    @EventId(235012618)
    public void AddKillPointUserPVPMatch(Creature c0, int point) {
    }

    @EventId(234947078)
    public void CheckRegisterUserPVPMatch(Creature talker) {
    }

    @EventId(234947081)
    public void UnregisterUserPVPMatch(Creature talker) {
    }

    @EventId(234947080)
    public void RegisterUserPVPMatch(Creature talker) {
    }

    @EventId(235405342)
    public void AddMoveFormationDesire(String unk, int unk1, int group_id, int group_id_, int fromation_id, int unk2,
                                       int unk3, double point) {
    }

    @EventId(234947108)
    public void BlockUpsetManagerEnter(int group_id) {
    }

    @EventId(235012646)
    public void BlockUpsetUserEnter(int group_id, Creature talker) {
    }

    @EventId(235012648)
    public void BlockUpsetChangeAmount(int group_id, int amount) {
    }

    @EventId(234947111)
    public void BlockUpsetRegisterMe(int group_id) {
    }

    @EventId(235012649)
    public void BlockUpsetChangeColor(int ground_id, int color_id) {
    }

    @EventId(234881582)
    public int GetEvolutionId() {
        return 0;
    }

    @EventId(235143717)
    public void BlockUpset(int ground_id, int unk, Creature creature, int block_upset_point) {
    }

    @EventId(235078193)
    public void SetDieEvent(Creature target, int unk1, int unk2) {
    }

    @EventId(235077778)
    public void FHTML_SetStr(FHTML fhtml, String find, String replacement) {
    }

    @EventId(234881274)
    public int Maker_GetNpcCount() {
        return 0;
    }

    @EventId(234947084)
    public int GetOverhitBonus(Creature creature) {
        return 0;
    }

    @EventId(234947083)
    public void GetRankUserPVPMatch(Creature creature) {
    }

    @EventId(235209269)
    public void StartScenePlayerAround(Creature creature, int scene, int radius, int min_z, int max_z) {
    }

    @EventId(235012679)
    public void TeleportTo(Creature from, Creature to) {
    }

    @EventId(235078192)
    public void RenewSpawnedPos(int x, int y, int z) {
    }

    @EventId(234947098)
    public void ChangeStatus(int status) {
    }

    @EventId(235012600)
    public void UnregisterPVPMatch(Party party, Creature creature) {
    }

    @EventId(235012601)
    public void StartPVPMatch(Party party1, Party party2) {
    }

    @EventId(235012599)
    public void RegisterPVPMatch(Party party, Creature talker) {
    }

    @EventId(234946876)
    public HateInfo GetHateInfoByCreature(Creature creature) {
        return null;
    }

    @EventId(234881578)
    public void CleftManagerEnter() {
    }

    @EventId(234881579)
    public int GetCleftState() {
        return 0;
    }

    @EventId(234947116)
    public void CleftUserEnter(Creature talker) {
    }

    @EventId(235012612)
    public void IsToggleSkillOnOff(Creature creature, int skill_id) {
    }

    @EventId(235078189)
    public void CleftCenterDestroyed(int zone_type, Creature creature, int destroy_point) {
    }


    @EventId(235274329)
    public void InstantTeleportWithItem(Creature creature, int x, int y, int z, int item, int item_count) {
    }

    @EventId(234881597)
    public void EventManagerEnter() {
    }

    @EventId(235143302)
    public void GiveItemEx(Creature talker, int item_id, int count, int unk) {
    }

    @EventId(235208720)
    public void AddFollowDesire2(Creature creature, int unk1, int unk2, int unk3, int unk4) {
    }

    @EventId(234947135)
    public void SetAbilityItemDrop(int ability) {
    }

    @EventId(235077638)
    public void AddMoveAroundLimitedDesire(int unk1, int unk2, double point) {
    }

    @EventId(235012659)
    public void StartScenePlayer(Creature talker, int scene) {
    }

    @EventId(234947131)
    public boolean IsCleftUser(Creature talker) {
        return false;
    }

    @EventId(235012673)
    public void ObserveEventMatch(Creature talker, int unk) {
    }

    @EventId(234947053)
    public void InstantZone_AddExtraDuration(int duration) {
    }

    @EventId(234946883)
    public void SetHateInfoListIndex(int index) {
    }

    @EventId(235078222)
    public void ChangeDir(Creature creature, int creature_id,
                          int direction) // direction to creature_id, or to direction
    {
    }

    @EventId(235012680)
    public void ChangeNPCState(Creature creature, int state) {
    }

    @EventId(234881606)
    public void RegisterAsFieldCycleManager() {
    }

    @EventId(235012685)
    public void SetAttackable(Creature creature, int value) {
    }

    @EventId(234947148)
    public boolean IsAttackable(Creature creature) {
        return false;
    }

    @EventId(234947138)
    public void BlockTimer(int timer_id) {
    }

    @EventId(234947139)
    public void UnblockTimer(int timer_id) {
    }

    @EventId(235667705)
    public void CreateOnePrivateInzoneEx(int npc_class_id, String ai, int weight_point, int unk1, int x, int y, int z,
                                         int angle, int master_id, int unk2, int unk3, int instance_zone_id) {
    }

    @EventId(234946822)
    public boolean IsInThisTerritory(String area_name) {
        return false;
    }

    @EventId(234946989)
    public void RemoveDesire(int unk) {
    }

    @EventId(235012682)
    public void ChangeNickName(Creature sm, String nickname) {
    }

    @EventId(235012683)
    public void ChangeMasterName(Creature sm, String mastername) {
    }

    @EventId(234947141)
    public void FixMoveType(int type) {
    }

    @EventId(235012528)
    public void ChangeMoveType2(int unk1, int unk2) {
    }

    @EventId(234947155)
    public void ChangeUserTalkTarget(Creature creature) {
    }

    @EventId(234881057)
    public void RemoveAbsoluteDesire() {
    }

    @EventId(235078228)
    public void VoiceNPCEffect(Creature creature, String voice, int unk) {
    }

    @EventId(235209296)
    public void IncreaseNPCLogByID(Creature target, int unk1, int unk2, int npc_class_id, int value) {
    }

    @EventId(235143762)
    public int GetNPCLogByID(Creature target, int unk1, int unk2, int npc_class_id) {
        return 0;
    }

    @EventId(235077952)
    public HateInfo GetNthHateInfo(int unk1, int hate_index, int unk2) {
        return null;
    }

    @EventId(235078217)
    public void ChangeZoneInfo(Creature creature, int unk1, int unk2) {
    }

    @EventId(235143766)
    public void FindRandomUser(int unk1, int unk2, int unk3, int unk4) {
    }

    @EventId(235340375)
    public void CreateOnePrivateNearUser(Creature talker, int unk1, String ai, int weight_point, int unk2, int unk3,
                                         int unk4) {
    }

    @EventId(234881621)
    public void GetPlayingUserCount() {
    }

    @EventId(234881624)
    public Creature GetMasterUser() {
        return null;
    }

    @EventId(234946628)
    public void SayInt(int value) {
    }

    @EventId(235078234)
    public void GetEventRankerInfo(int event_id, Creature talker, int unk) {
    }

    @EventId(235078235)
    public void DecreaseEventTopRankerReward(int event_id, int unk, Creature talker) {
    }

    @EventId(235078233)
    public void InsertEventRanking(int eventData, Creature creature, int unk) {
    }

    @EventId(235012700)
    public void CanGiveEventData(Creature talker, int eventData) {
    }

    @EventId(235077920)
    public void DestroyPet(Creature talker, int dbid, int petlevel) {
    }

    @EventId(218169350)
    public void RegisterAgitSiegeEventEx(int castle_id) {
    }

    @EventId(234946673)
    public void SetCurrentQuestID(int quest_id) {
    }

    @EventId(235077742)
    public void SetJournal(Creature target, int quest, int unk) {
    }

    @EventId(234881089)
    public boolean IsSpoiled() {
        return false;
    }

    @EventId(234947014)
    public boolean HasAcademyMaster(Creature target) {
        return false;
    }

    @EventId(234947016)
    public Creature GetAcademyMaster(Creature target) {
        return null;
    }

    @EventId(234946811)
    public Creature Maker_FindNpcByKey(int key) {
        return null;
    }

    @EventId(235208987)
    public void DeleteRadar(Creature talker, int x, int y, int z, int unk) {
    }

    @EventId(235012314)
    public void AddChoice(int choise, String name) {
    }

    @EventId(235012315)
    public void ShowChoicePage(Creature talker, int unk) {
    }

    @EventId(234947015)
    public boolean HasAcademyMember(Creature talker) {
        return false;
    }

    @EventId(234947017)
    public Creature GetAcademyMember(Creature talker) {
        return null;
    }

    @EventId(235078031)
    public int GetHTMLCookie(Creature talker, int quest_id, int unk) {
        return 0;
    }

    @EventId(235077709)
    public void ShowQuestPage(Creature talker, String html, int quest_id) {
    }

    @EventId(235012380)
    public void DeleteAllRadar(Creature talker, int unk) {
    }

    @EventId(234946665)
    public int GetMemoCount(Creature talker) {
        return 0;
    }

    @EventId(235077780)
    public void ShowQuestFHTML(Creature talker, FHTML fhtml, int quest_id) {
    }

    @EventId(234947107)
    public boolean IsHostileInDominionSiege(Creature creature) {
        return false;
    }

    @EventId(235012202)
    public void SetMemo(Creature talker, int quest_id) {
    }

    @EventId(235078030)
    public void SetHTMLCookie(Creature talker, int quest_id, int coockie) {
    }

    @EventId(234946953)
    public void ClearBingoBoard(Creature talker) {
    }

    @EventId(235012482)
    public void CreateBingoBoard(Creature talker, int unk) {
    }

    @EventId(235012485)
    public void SelectBingoNumber(Creature talker, int number) {
    }

    @EventId(235012484)
    public int GetNumberFromBingoBoard(Creature talker, int unk) {
        return 0;
    }

    @EventId(235012487)
    public boolean IsSelectedBingoNumber(Creature talker, int number) {
        return false;
    }

    @EventId(234946950)
    public int GetBingoSelectCount(Creature talker) {
        return 0;
    }

    @EventId(234946952)
    public int GetMatchedBingoLineCount(Creature talker) {
        return 0;
    }

    @EventId(235078013)
    public void AddTimeAttackFee(int unk1, int unk2, int party_id) {
    }

    @EventId(235274620)
    public void AddTimeAttackRecord(int unk1, int SSQ_type, int party_id, int item_count, int time_of_day,
                                    int memo_state) {
    }

    @EventId(235143551)
    public void GiveTimeAttackReward(Creature talker, int unk1, int tem_id, int unk2) {
    }

    @EventId(235012636)
    public void DeclareLord(int dominion, Creature talker) {
    }
}