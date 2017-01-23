package ru.jts.decompiler.gameserver

import ru.jts.decompiler.annotation.EventId
import ru.jts.decompiler.model._
import scala.language.implicitConversions

/**
 * Created by dmitrij on 09.06.15.
 */
class ScalaNpcEventHandler {
  implicit def bool2int(b:Boolean) = if (b) 1 else 0
  implicit def int2bool(i:Int) = if (i > 0) true else false

  @EventId(784)
  protected var myself: Npc = null
  @EventId(704)
  protected var gg: GlobalObject = null

  @EventId(0)
  protected def NO_DESIRE(@EventId(name = "damage", value = 144) damage: Int, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "h0", value = 512) h0: HateInfo, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "c2", value = 432) c2: Creature, @EventId(name = "c3", value = 440) c3: Creature, @EventId(name = "c4", value = 448) c4: Creature, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int) {
  }

  @EventId(1)
  protected def ATTACKED(@EventId(name = "attacker", value = 48) attacker: Creature, @EventId(name = "victim", value = 56) victim: Creature, @EventId(name = "target", value = 96) target: Creature, @EventId(name = "skill_id", value = 164) skill_id: Int, @EventId(name = "skill_name_id", value = 176) skill_name_id: Int, @EventId(name = "damage", value = 144) damage: Int, @EventId(name = "private", value = 64) _private: Creature, @EventId(name = "rlist0", value = 656) rlist0: RoomInfoList, @EventId(name = "room0", value = 640) room0: RoomInfo, @EventId(name = "npc0", value = 552) npc0: Npc, @EventId(name = "pos0", value = 672) pos0: Point, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "maker1", value = 632) maker1: NpcMaker, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "party1", value = 480) party1: Party, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "c2", value = 432) c2: Creature, @EventId(name = "c3", value = 440) c3: Creature, @EventId(name = "c4", value = 448) c4: Creature, @EventId(name = "c5", value = 456) c5: Creature, @EventId(name = "h0", value = 512) h0: HateInfo, @EventId(name = "h1", value = 520) h1: HateInfo, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "f0", value = 376) f0: Double, @EventId(name = "f1", value = 380) f1: Double, @EventId(name = "f2", value = 384) f2: Double, @EventId(name = "f3", value = 388) f3: Double, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int, @EventId(name = "i10", value = 360) i10: Int, @EventId(name = "i11", value = 368) i11: Int) {
  }

  @EventId(2)
  protected def SPELLED(@EventId(name = "attacker", value = 48) attacker: Creature, @EventId(name = "speller", value = 88) speller: Creature, @EventId(name = "skill_id", value = 164) skill_id: Int, @EventId(name = "skill_name_id", value = 176) skill_name_id: Int, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "party1", value = 480) party1: Party, @EventId(name = "h0", value = 512) h0: HateInfo, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "c2", value = 432) c2: Creature, @EventId(name = "c3", value = 440) c3: Creature, @EventId(name = "c4", value = 448) c4: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int) {
  }

  @EventId(3)
  protected def TALKED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "ask", value = 160) ask: Int, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "_from_choice", value = 616) _from_choice: Int, @EventId(name = "_choiceN", value = 612) _choiceN: Int, @EventId(name = "_code", value = 608) _code: Int, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "fhtml0", value = 592) fhtml0: FHTML, @EventId(name = "npc0", value = 552) npc0: Npc, @EventId(name = "pledge0", value = 456) pledge0: Clan, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int) {
  }

  @EventId(4) protected def TALK_SELECTED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "ask", value = 160) ask: Int, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "_from_choice", value = 616) _from_choice: Int, @EventId(name = "_choiceN", value = 612) _choiceN: Int, @EventId(name = "_code", value = 608) _code: Int, @EventId(name = "fhtml0", value = 592) fhtml0: FHTML, @EventId(name = "fhtml1", value = 600) fhtml1: FHTML, @EventId(name = "item0", value = 488) item0: ItemData, @EventId(name = "npc0", value = 552) npc0: Npc, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "pledge0", value = 456) pledge0: Clan, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "c2", value = 432) c2: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int) {
  }

  @EventId(5) protected def SEE_CREATURE(@EventId(name = "creature", value = 112) creature: Creature, @EventId(name = "private", value = 64) _private: Creature, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "maker1", value = 632) maker1: NpcMaker, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "c2", value = 432) c2: Creature, @EventId(name = "h0", value = 512) h0: HateInfo, @EventId(name = "h1", value = 520) h1: HateInfo, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "f0", value = 376) f0: Double, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int) {
  }

  @EventId(7) protected def SEE_ITEM(@EventId(name = "item_index_list", value = 776) item_index_list: ItemIndexList, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int) {
  }

  @EventId(9) protected def MY_DYING(@EventId(name = "last_attacker", value = 728) last_attacker: Creature, @EventId(name = "attacker", value = 48) attacker: Creature, @EventId(name = "target", value = 96) target: Creature, @EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "creature", value = 112) creature: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "skill_name_id", value = 176) skill_name_id: Int, @EventId(name = "private", value = 64) _private: Creature, @EventId(name = "code_info", value = 768) code_info: CodeInfo, @EventId(name = "random1_list", value = 752) random1_list: CodeInfoList, @EventId(name = "always_list", value = 760) always_list: CodeInfoList, @EventId(name = "npc0", value = 552) npc0: Npc, @EventId(name = "pos0", value = 672) pos0: Point, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "maker1", value = 632) maker1: NpcMaker, @EventId(name = "lparty", value = 744) lparty: Party, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "pledge0", value = 456) pledge0: Clan, @EventId(name = "h0", value = 512) h0: HateInfo, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "c2", value = 432) c2: Creature, @EventId(name = "c3", value = 440) c3: Creature, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "s1", value = 584) s1: String, @EventId(name = "f0", value = 376) f0: Double, @EventId(name = "f1", value = 380) f1: Double, @EventId(name = "f2", value = 384) f2: Double, @EventId(name = "f3", value = 388) f3: Double, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i9", value = 352) i9: Int) {
  }

  @EventId(11) protected def TIMER_FIRED_EX(@EventId(name = "timer_id", value = 244) timer_id: Int, @EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "private", value = 64) _private: Creature, @EventId(name = "rlist0", value = 656) rlist0: RoomInfoList, @EventId(name = "pos0", value = 672) pos0: Point, @EventId(name = "room0", value = 640) room0: RoomInfo, @EventId(name = "room1", value = 648) room1: RoomInfo, @EventId(name = "item0", value = 488) item0: ItemData, @EventId(name = "npc0", value = 552) npc0: Npc, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "maker1", value = 632) maker1: NpcMaker, @EventId(name = "h0", value = 512) h0: HateInfo, @EventId(name = "h1", value = 520) h1: HateInfo, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "party1", value = 480) party1: Party, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "c2", value = 432) c2: Creature, @EventId(name = "c3", value = 440) c3: Creature, @EventId(name = "c4", value = 448) c4: Creature, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "s1", value = 584) s1: String, @EventId(name = "f0", value = 376) f0: Double, @EventId(name = "f1", value = 380) f1: Double, @EventId(name = "f2", value = 384) f2: Double, @EventId(name = "f3", value = 388) f3: Double, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int, @EventId(name = "i10", value = 360) i10: Int, @EventId(name = "i11", value = 368) i11: Int) {
  }

  @EventId(12) protected def CREATED(@EventId(name = "ask", value = 160) ask: Int, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "creature", value = 112) creature: Creature, @EventId(name = "rlist0", value = 656) rlist0: RoomInfoList, @EventId(name = "room0", value = 640) room0: RoomInfo, @EventId(name = "pledge0", value = 456) pledge0: Clan, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "npc0", value = 552) npc0: Npc, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "maker1", value = 632) maker1: NpcMaker, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "c2", value = 432) c2: Creature, @EventId(name = "c3", value = 440) c3: Creature, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "s1", value = 584) s1: String, @EventId(name = "f0", value = 376) f0: Double, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int, @EventId(name = "i10", value = 360) i10: Int) {
  }

  @EventId(15) protected def SEE_SPELL(@EventId(name = "speller", value = 88) speller: Creature, @EventId(name = "target", value = 96) target: Creature, @EventId(name = "skill_id", value = 164) skill_id: Int, @EventId(name = "skill_name_id", value = 176) skill_name_id: Int, @EventId(name = "x", value = 204) x: Int, @EventId(name = "y", value = 208) y: Int, @EventId(name = "z", value = 212) z: Int, @EventId(name = "h0", value = 512) h0: HateInfo, @EventId(name = "npc0", value = 552) npc0: Npc, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "party1", value = 480) party1: Party, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "f0", value = 376) f0: Double, @EventId(name = "f1", value = 380) f1: Double, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int) {
  }

  @EventId(16) protected def OUT_OF_TERRITORY(@EventId(name = "i6", value = 328) i6: Int) {
  }

  @EventId(17) protected def DESIRE_MANIPULATION(@EventId(name = "speller", value = 88) speller: Creature, @EventId(name = "skill_name_id", value = 176) skill_name_id: Int, @EventId(name = "desire", value = 220) desire: Int) {
  }

  @EventId(18) protected def PARTY_ATTACKED(@EventId(name = "attacker", value = 48) attacker: Creature, @EventId(name = "damage", value = 144) damage: Int, @EventId(name = "skill_name_id", value = 176) skill_name_id: Int, @EventId(name = "private", value = 64) _private: Creature, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "h1", value = 520) h1: HateInfo, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "h0", value = 512) h0: HateInfo, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "f0", value = 376) f0: Double, @EventId(name = "f1", value = 380) f1: Double, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i10", value = 360) i10: Int) {
  }

  @EventId(20) protected def PARTY_DIED(@EventId(name = "private", value = 64) _private: Creature, @EventId(name = "attacker", value = 48) attacker: Creature, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "f0", value = 376) f0: Double, @EventId(name = "f1", value = 380) f1: Double, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "s1", value = 584) s1: String, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int) {
  }

  @EventId(22) protected def CLAN_ATTACKED(@EventId(name = "attacker", value = 48) attacker: Creature, @EventId(name = "damage", value = 144) damage: Int, @EventId(name = "skill_name_id", value = 176) skill_name_id: Int, @EventId(name = "victim", value = 56) victim: Creature, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "party1", value = 480) party1: Party, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "h0", value = 512) h0: HateInfo, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "f0", value = 376) f0: Double, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i10", value = 360) i10: Int) {
  }

  @EventId(24) protected def STATIC_OBJECT_CLAN_ATTACKED(@EventId(name = "attacker", value = 48) attacker: Creature, @EventId(name = "damage", value = 144) damage: Int, @EventId(name = "skill_name_id", value = 176) skill_name_id: Int, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(27) protected def TELEPORT_REQUESTED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "c2", value = 432) c2: Creature, @EventId(name = "c3", value = 440) c3: Creature, @EventId(name = "c4", value = 448) c4: Creature, @EventId(name = "c5", value = 456) c5: Creature, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int) {
  }

  @EventId(30) protected def QUEST_ACCEPTED(@EventId(name = "quest_id", value = 156) quest_id: Int, @EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "pledge0", value = 456) pledge0: Clan, @EventId(name = "fhtml0", value = 592) fhtml0: FHTML, @EventId(name = "item0", value = 488) item0: ItemData, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "c2", value = 432) c2: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int) {
  }

  @EventId(31) protected def MENU_SELECTED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "ask", value = 160) ask: Int, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "state", value = 148) state: Int, @EventId(name = "quest_id", value = 156) quest_id: Int, @EventId(name = "action_id", value = 264) action_id: Int, @EventId(name = "rlist0", value = 656) rlist0: RoomInfoList, @EventId(name = "room0", value = 640) room0: RoomInfo, @EventId(name = "room1", value = 648) room1: RoomInfo, @EventId(name = "so0", value = 504) so0: StaticObject, @EventId(name = "pos0", value = 672) pos0: Point, @EventId(name = "npc0", value = 552) npc0: Npc, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "maker1", value = 632) maker1: NpcMaker, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "s1", value = 584) s1: String, @EventId(name = "fhtml0", value = 592) fhtml0: FHTML, @EventId(name = "fhtml1", value = 600) fhtml1: FHTML, @EventId(name = "item0", value = 488) item0: ItemData, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "c2", value = 432) c2: Creature, @EventId(name = "c3", value = 440) c3: Creature, @EventId(name = "c4", value = 448) c4: Creature, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "party1", value = 480) party1: Party, @EventId(name = "pledge0", value = 456) pledge0: Clan, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int, @EventId(name = "i10", value = 360) i10: Int, @EventId(name = "i11", value = 368) i11: Int) {
  }

  @EventId(32) protected def LEARN_SKILL_REQUESTED(@EventId(name = "talker", value = 40) talker: Creature) {
  }

  @EventId(33) protected def ENCHANT_SKILL_REQUESTED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "action_id", value = 264) action_id: Int) {
  }

  @EventId(34) protected def ONE_SKILL_SELECTED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "skill_name_id", value = 176) skill_name_id: Int, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(35) protected def ONE_ENCHANT_SKILL_SELECTED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "skill_name_id", value = 176) skill_name_id: Int, @EventId(name = "action_id", value = 264) action_id: Int) {
  }

  @EventId(37) protected def CLASS_CHANGE_REQUESTED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "occupation_name_id", value = 180) occupation_name_id: Int) {
  }

  @EventId(38) protected def MANOR_MENU_SELECTED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "ask", value = 160) ask: Int, @EventId(name = "state", value = 148) state: Int, @EventId(name = "time", value = 192) time: Int) {
  }

  @EventId(44) protected def CREATE_PLEDGE(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(45) protected def DISMISS_PLEDGE(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(46) protected def REVIVE_PLEDGE(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(47) protected def LEVEL_UP_PLEDGE(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int) {
  }

  @EventId(50) protected def CREATE_ALLIANCE(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(51) protected def SCRIPT_EVENT(@EventId(name = "script_event_arg1", value = 248) script_event_arg1: Int, @EventId(name = "script_event_arg2", value = 252) script_event_arg2: Int, @EventId(name = "script_event_arg3", value = 256) script_event_arg3: Int, @EventId(name = "private", value = 64) _private: Creature, @EventId(name = "attacker", value = 48) attacker: Creature, @EventId(name = "pos0", value = 672) pos0: Point, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "party1", value = 480) party1: Party, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "maker1", value = 632) maker1: NpcMaker, @EventId(name = "h0", value = 512) h0: HateInfo, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "c2", value = 432) c2: Creature, @EventId(name = "c3", value = 440) c3: Creature, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "s1", value = 584) s1: String, @EventId(name = "f0", value = 376) f0: Double, @EventId(name = "f1", value = 380) f1: Double, @EventId(name = "f2", value = 384) f2: Double, @EventId(name = "f3", value = 388) f3: Double, @EventId(name = "f4", value = 392) f4: Double, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int, @EventId(name = "i10", value = 360) i10: Int) {
  }

  @EventId(52) protected def TUTORIAL_EVENT(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "event_id", value = 236) event_id: Int, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int) {
  }

  @EventId(53) protected def QUESTION_MARK_CLICKED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "question_id", value = 240) question_id: Int, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(54) protected def USER_CONNECTED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int) {
  }

  @EventId(57) protected def ATTACK_FINISHED(@EventId(name = "target", value = 96) target: Creature, @EventId(name = "h0", value = 512) h0: HateInfo, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(60) protected def GET_ITEM_FINISHED(@EventId(name = "item", value = 128) item: ItemData, @EventId(name = "success", value = 200) success: Int, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(63) protected def MOVE_TO_WAY_POINT_FINISHED(@EventId(name = "way_point_index", value = 184) way_point_index: Int, @EventId(name = "next_way_point_index", value = 188) next_way_point_index: Int) {
  }

  @EventId(64) protected def USE_SKILL_FINISHED(@EventId(name = "attacker", value = 48) attacker: Creature, @EventId(name = "target", value = 96) target: Creature, @EventId(name = "skill_id", value = 164) skill_id: Int, @EventId(name = "skill_name_id", value = 176) skill_name_id: Int, @EventId(name = "success", value = 200) success: Int, @EventId(name = "ask", value = 160) ask: Int, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "pos0", value = 672) pos0: Point, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "h0", value = 512) h0: HateInfo, @EventId(name = "h1", value = 520) h1: HateInfo, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "c2", value = 432) c2: Creature, @EventId(name = "c3", value = 440) c3: Creature, @EventId(name = "c4", value = 448) c4: Creature, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "f0", value = 376) f0: Double, @EventId(name = "f4", value = 392) f4: Double, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i10", value = 360) i10: Int, @EventId(name = "i11", value = 368) i11: Int) {
  }

  @EventId(65) protected def MOVE_TO_FINISHED(@EventId(name = "x", value = 204) x: Int, @EventId(name = "y", value = 208) y: Int, @EventId(name = "z", value = 212) z: Int, @EventId(name = "attacker", value = 48) attacker: Creature, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "h0", value = 512) h0: HateInfo, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "c2", value = 432) c2: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int) {
  }

  @EventId(77) protected def DOOR_HP_LEVEL_INFORMED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "level", value = 260) level: Int, @EventId(name = "fhtml0", value = 592) fhtml0: FHTML, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int) {
  }

  @EventId(78) protected def CONTROLTOWER_LEVEL_INFORMED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "level", value = 260) level: Int, @EventId(name = "fhtml0", value = 592) fhtml0: FHTML, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int) {
  }

  @EventId(79) protected def TB_REGISTER_PLEDGE_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(80) protected def TB_REGISTER_MEMBER_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(81) protected def TB_GET_NPC_TYPE_INFORMED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(82) protected def TB_SET_NPC_TYPE_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(83) protected def TB_GET_PLEDGE_REGISTER_STATUS_INFORMED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "pledge0", value = 456) pledge0: Clan, @EventId(name = "fhtml0", value = 592) fhtml0: FHTML) {
  }

  @EventId(84) protected def TB_GET_BATTLE_ROYAL_PLEDGE_LIST_INFORMED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "fhtml0", value = 592) fhtml0: FHTML, @EventId(name = "pledge0", value = 456) pledge0: Clan, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int) {
  }

  @EventId(85) protected def SUBJOB_LIST_INFORMED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "ask", value = 160) ask: Int, @EventId(name = "fhtml0", value = 592) fhtml0: FHTML, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int, @EventId(name = "i10", value = 360) i10: Int) {
  }

  @EventId(86) protected def SUBJOB_CREATED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(87) protected def SUBJOB_CHANGED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "level", value = 260) level: Int) {
  }

  @EventId(88) protected def SUBJOB_RENEWED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(89) protected def ON_SSQ_SYSTEM_EVENT(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "ask", value = 160) ask: Int, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(90) protected def SET_AGIT_DECO_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(91) protected def RESET_AGIT_DECO_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(92) protected def AUCTION_AGIT_GET_COST_INFO_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "fhtml0", value = 592) fhtml0: FHTML, @EventId(name = "s0", value = 576) s0: String) {
  }

  @EventId(93) protected def CLAN_DIED(@EventId(name = "victim", value = 56) victim: Creature, @EventId(name = "attacker", value = 48) attacker: Creature, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(95) protected def SET_HERO_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(97) protected def DELETE_OLYMPIAD_TRADE_POINT_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "ask", value = 160) ask: Int, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int) {
  }

  @EventId(98) protected def MG_REGISTER_PLEDGE_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(99) protected def MG_UNREGISTER_PLEDGE_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(101) protected def MG_JOIN_GAME_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(102) protected def MG_GET_UNRETURNED_POINT_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(103) protected def CREATE_ACADEMY(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "pledge0", value = 456) pledge0: Clan, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "s1", value = 584) s1: String, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int) {
  }

  @EventId(104) protected def CREATE_SUBPLEDGE(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "pledge0", value = 456) pledge0: Clan, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "s1", value = 584) s1: String, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int) {
  }

  @EventId(105) protected def CHECK_CURSED_USER_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(106) protected def UPDATE_SUBPLEDGE_MASTER(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(107) protected def UPGRADE_SUBPLEDGE_MEMBER_COUNT(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(108) protected def MPCC_TELEPORTED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "c2", value = 432) c2: Creature, @EventId(name = "c3", value = 440) c3: Creature, @EventId(name = "c4", value = 448) c4: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int) {
  }

  @EventId(109) protected def PLEDGE_MASTER_TRANSFER(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "s0", value = 576) s0: String) {
  }

  @EventId(110) protected def PLEDGE_MASTER_TRANSFER_CANCEL(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(111) protected def TB_CHECK_MEMBER_REGISTER_STATUS(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "pledge0", value = 456) pledge0: Clan) {
  }

  @EventId(112) protected def RENAME_SUBPLEDGE(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(113) protected def ABNORMAL_STATUS_CHANGED(@EventId(value = 88, name = "speller") speller: Creature, @EventId(name = "skill_id", value = 164) skill_id: Int, @EventId(name = "skill_level", value = 168) skill_level: Int, @EventId(name = "skill_name_id", value = 176) skill_name_id: Int, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int) {
  }

  @EventId(114) protected def TELEPORT_TO_USER_RES(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "success", value = 200) success: Int, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(115) protected def NODE_ARRIVED(@EventId(name = "script_event_arg1", value = 248) script_event_arg1: Int, @EventId(name = "script_event_arg2", value = 252) script_event_arg2: Int, @EventId(name = "script_event_arg3", value = 256) script_event_arg3: Int, @EventId(name = "state", value = 148) state: Int, @EventId(name = "success", value = 200) success: Int, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(116) protected def TRAP_STEP_IN(@EventId(name = "party0", value = 472) party0: Party, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int) {
  }

  @EventId(117) protected def TRAP_STEP_OUT(@EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int) {
  }

  @EventId(118) protected def TRAP_ACTIVATED(@EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(119) protected def TRAP_DEFUSED(@EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(120) protected def TRAP_DETECTED(@EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int) {
  }

  @EventId(121) protected def SHOW_ENCHANT_SKILL_DRAWER(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "skill_name_id", value = 176) skill_name_id: Int, @EventId(name = "action_id", value = 264) action_id: Int) {
  }

  @EventId(123) protected def INSTANT_ZONE_ENTER_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "state", value = 148) state: Int, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int) {
  }

  @EventId(125) protected def FORTRESS_SIEGE_REGISTER_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(126) protected def FORTRESS_SIEGE_UNREGISTER_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(127) protected def FORTRESS_CONTRACT_CASTLE_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(128) protected def FORTRESS_UPGRADE_FACILITY_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int) {
  }

  @EventId(129) protected def ON_OLYMPIAD_GAME_PREPARED(@EventId(name = "event_id", value = 236) event_id: Int, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(130) protected def PLEDGE_CASTLE_SIEGE_DEFENCE_COUNT_DECREASE_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(131) protected def REGISTER_PVP_MATCH_RESULT(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "party1", value = 480) party1: Party, @EventId(name = "fhtml0", value = 592) fhtml0: FHTML, @EventId(name = "fhtml1", value = 600) fhtml1: FHTML, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int) {
  }

  @EventId(132) protected def UNREGISTER_PVP_MATCH_RESULT(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "party1", value = 480) party1: Party, @EventId(name = "fhtml0", value = 592) fhtml0: FHTML, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "c2", value = 432) c2: Creature, @EventId(name = "c3", value = 440) c3: Creature, @EventId(name = "c4", value = 448) c4: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int) {
  }

  @EventId(133) protected def START_PVP_MATCH_RESULT(@EventId(name = "reply", value = 272) reply: Int, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "party1", value = 480) party1: Party, @EventId(name = "h0", value = 512) h0: HateInfo, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int) {
  }

  @EventId(134) protected def END_PVP_MATCH_RESULT(@EventId(name = "party0", value = 472) party0: Party, @EventId(name = "party1", value = 480) party1: Party, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int) {
  }

  @EventId(136) protected def CHECK_REGISTER_PARTY_RESULT2(@EventId(name = "reply", value = 272) reply: Int, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "party1", value = 480) party1: Party, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "c2", value = 432) c2: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int) {
  }

  @EventId(137) protected def REGISTER_RESURRECTION_TOWER_RESULT(@EventId(name = "reply", value = 272) reply: Int, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(138) protected def CHECK_REGISTER_USER_RESULT(@EventId(name = "reply", value = 272) reply: Int, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "c0", value = 416) c0: Creature) {
  }

  @EventId(139) protected def IS_USER_PVPMATCHING_RESULT(@EventId(name = "reply", value = 272) reply: Int, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(140) protected def REGISTER_USER_PVP_MATCH_RESULT(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(141) protected def UNREGISTER_USER_PVP_MATCH_RESULT(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(142) protected def REGISTER_USER_RESURRECTION_TOWER_RESULT(@EventId(name = "reply", value = 272) reply: Int, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(143) protected def KILLED_USER_PVP_MATCH_RESULT(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "attacker", value = 48) attacker: Creature, @EventId(name = "h0", value = 512) h0: HateInfo, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(144) protected def GET_RANK_USER_PVP_MATCH_RESULT(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "h0", value = 512) h0: HateInfo, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int) {
  }

  @EventId(145) protected def LET_IN_USER_PVP_MATCH(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "party0", value = 472) party0: Party, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(146) protected def START_USER_PVP_MATCH_RESULT(@EventId(name = "reply", value = 272) reply: Int, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int) {
  }

  @EventId(147) protected def WITHDRAW_USER_PVP_MATCH_RESULT(@EventId(name = "reply", value = 272) reply: Int, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int) {
  }

  @EventId(148) protected def END_USER_PVP_MATCH_RESULT(@EventId(name = "reply", value = 272) reply: Int, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int) {
  }

  @EventId(149) protected def GET_RELATED_FORTRESS_LIST_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "fhtml0", value = 592) fhtml0: FHTML, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int) {
  }

  @EventId(154) protected def DOMINION_SIEGE_START(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int) {
  }

  @EventId(155) protected def DOMINION_SIEGE_END(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int) {
  }

  @EventId(156) protected def DOMINION_SIEGE_PC_KILLED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "attacker", value = 48) attacker: Creature, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int) {
  }

  @EventId(157) protected def CLEFT_STATE_CHANGED(@EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int) {
  }

  @EventId(158) protected def BLOCK_UPSET_STARTED() {
  }

  @EventId(159) protected def BLOCK_UPSET_FINISHED() {
  }

  @EventId(160) protected def LEVEL_UP(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int) {
  }

  @EventId(161) protected def LOAD_DBSAVING_MAP_RETURNED(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int) {
  }

  @EventId(162) protected def DOMINION_SCRIPT_EVENT(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "script_event_arg1", value = 248) script_event_arg1: Int, @EventId(name = "script_event_arg2", value = 252) script_event_arg2: Int, @EventId(name = "script_event_arg3", value = 256) script_event_arg3: Int, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "c2", value = 432) c2: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int) {
  }

  @EventId(163) protected def DIE_SET(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "maker0", value = 624) maker0: NpcMaker) {
  }

  @EventId(165) protected def SOCIAL_ACTION_EVENT(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "action_id", value = 264) action_id: Int) {
  }

  @EventId(166) protected def PET_DIED(@EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int) {
  }

  @EventId(167) protected def WAS_COLLECTED(@EventId(name = "attacker", value = 48) attacker: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int) {
  }

  @EventId(168) protected def ON_AIRSHIP_EVENT(@EventId(name = "state", value = 148) state: Int, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int) {
  }

  @EventId(169) protected def DOMINION_SUPPLY_DESTRUCTED(@EventId(name = "attacker", value = 48) attacker: Creature, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "c1", value = 424) c1: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int) {
  }

  @EventId(170) protected def CREATE_NPC_TO_WINNER(@EventId(name = "target", value = 96) target: Creature, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(172) protected def DEBUG_AI(@EventId(name = "creature", value = 112) creature: Creature, @EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "pos0", value = 672) pos0: Point, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int) {
  }

  @EventId(173) protected def IS_TOGGLE_SKILL_ONOFF(@EventId(name = "target", value = 96) target: Creature, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(174) protected def FIELD_CYCLE_STEP_EXPIRED(@EventId(name = "event_id", value = 236) event_id: Int, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i10", value = 360) i10: Int) {
  }

  @EventId(175) protected def SPELL_SUCCESSED(@EventId(name = "target", value = 96) target: Creature, @EventId(name = "skill_name_id", value = 176) skill_name_id: Int) {
  }

  @EventId(176) protected def GET_EVENT_RANKER_INFO(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int) {
  }

  @EventId(177) protected def GET_PLAYING_USER_COUNT(@EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(178) protected def FIND_RANDOM_USER(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(179) protected def GIVE_EVENT_DATA(@EventId(name = "talker", value = 40) talker: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int) {
  }
}
