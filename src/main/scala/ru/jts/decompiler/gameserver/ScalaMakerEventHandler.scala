package ru.jts.decompiler.gameserver

import ru.jts.decompiler.annotation.EventId
import ru.jts.decompiler.model._

/**
 * Created by dmitrij on 09.06.15.
 */
class ScalaMakerEventHandler {
  @EventId(728)
  protected var myself: NpcMaker = null
  @EventId(704)
  protected var gg: GlobalObject = null

  @EventId(0) protected def ON_START(@EventId(name = "def0", value = 736) def0: SpawnDefine, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int) {
  }

  @EventId(1) protected def ON_NPC_DELETED(@EventId(name = "reply", value = 272) reply: Int, @EventId(name = "def0", value = 736) def0: SpawnDefine, @EventId(name = "deleted_def", value = 744) deleted_def: SpawnDefine, @EventId(name = "deleted_npc", value = 768) deleted_npc: Npc, @EventId(name = "died", value = 796) died: Int, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "maker1", value = 632) maker1: NpcMaker, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int) {
  }

  @EventId(2) protected def ON_ALL_NPC_DELETED(@EventId(name = "def0", value = 736) def0: SpawnDefine, @EventId(name = "deleted_def", value = 744) deleted_def: SpawnDefine, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int) {
  }

  @EventId(3) protected def ON_SCRIPT_EVENT(@EventId(name = "script_event_arg1", value = 248) script_event_arg1: Int, @EventId(name = "script_event_arg2", value = 252) script_event_arg2: Int, @EventId(name = "script_event_arg3", value = 256) script_event_arg3: Int, @EventId(name = "def0", value = 736) def0: SpawnDefine, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "c0", value = 416) c0: Creature, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "s1", value = 584) s1: String, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int) {
  }

  @EventId(4) protected def ON_DB_NPC_INFO(@EventId(name = "loaded_def", value = 752) loaded_def: SpawnDefine, @EventId(name = "record0", value = 784) record0: RecordInfo, @EventId(name = "def0", value = 736) def0: SpawnDefine, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int) {
  }

  @EventId(5) protected def ON_TIMER(@EventId(name = "timer_id", value = 244) timer_id: Int, @EventId(name = "def0", value = 736) def0: SpawnDefine, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int, @EventId(name = "i10", value = 360) i10: Int, @EventId(name = "i11", value = 368) i11: Int) {
  }

  @EventId(6) protected def ON_NPC_CREATED(@EventId(name = "created_def", value = 760) created_def: SpawnDefine, @EventId(name = "created_npc", value = 776) created_npc: Npc, @EventId(name = "def0", value = 736) def0: SpawnDefine, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "maker1", value = 632) maker1: NpcMaker, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int) {
  }

  @EventId(7) protected def ON_NPCPOS_EVENT(@EventId(name = "enabled", value = 792) enabled: Int, @EventId(name = "def0", value = 736) def0: SpawnDefine, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(8) protected def ON_DOOR_EVENT(@EventId(name = "enabled", value = 792) enabled: Int, @EventId(name = "def0", value = 736) def0: SpawnDefine, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int) {
  }

  @EventId(9) protected def ON_START_SIEGE_EVENT(@EventId(name = "def0", value = 736) def0: SpawnDefine, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(10) protected def ON_END_SIEGE_EVENT(@EventId(name = "def0", value = 736) def0: SpawnDefine, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(11) protected def ON_PROCLAIM_SIEGE_EVENT(@EventId(name = "def0", value = 736) def0: SpawnDefine) {
  }

  @EventId(12) protected def ON_DESTRUCT_CTRL_TOWER_EVENT(@EventId(name = "def0", value = 736) def0: SpawnDefine) {
  }

  @EventId(13) protected def ON_CANCEL_SIEGE_EVENT(@EventId(name = "def0", value = 736) def0: SpawnDefine) {
  }

  @EventId(14) protected def ON_START_TEAMBATTLEAGIT_FINAL_EVENT(@EventId(name = "def0", value = 736) def0: SpawnDefine, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(15) protected def ON_FIELD_CYCLE_CHANGED_EVENT(@EventId(name = "event_id", value = 236) event_id: Int, @EventId(name = "state", value = 148) state: Int, @EventId(name = "def0", value = 736) def0: SpawnDefine, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int) {
  }

  @EventId(16) protected def ON_FORTRESS_EVENT(@EventId(name = "residence_id", value = 224) residence_id: Int, @EventId(name = "event_id", value = 236) event_id: Int, @EventId(name = "reply", value = 272) reply: Int, @EventId(name = "def0", value = 736) def0: SpawnDefine, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "s0", value = 576) s0: String, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int) {
  }

  @EventId(17) protected def ON_INSTANT_ZONE_EVENT(@EventId(name = "reply", value = 272) reply: Int, @EventId(name = "event_id", value = 236) event_id: Int, @EventId(name = "def0", value = 736) def0: SpawnDefine, @EventId(name = "maker0", value = 624) maker0: NpcMaker, @EventId(name = "maker1", value = 632) maker1: NpcMaker, @EventId(name = "i0", value = 280) i0: Int, @EventId(name = "i1", value = 288) i1: Int, @EventId(name = "i2", value = 296) i2: Int, @EventId(name = "i3", value = 304) i3: Int, @EventId(name = "i4", value = 312) i4: Int, @EventId(name = "i5", value = 320) i5: Int, @EventId(name = "i6", value = 328) i6: Int, @EventId(name = "i7", value = 336) i7: Int, @EventId(name = "i8", value = 344) i8: Int, @EventId(name = "i9", value = 352) i9: Int) {
  }

  @EventId(18) protected def ON_OLYMPIAD_FIELD_STEP_CHANGED_EVENT(@EventId(name = "event_id", value = 236) event_id: Int, @EventId(name = "state", value = 148) state: Int, @EventId(name = "def0", value = 736) def0: SpawnDefine, @EventId(name = "maker0", value = 624) maker0: NpcMaker) {
  }

  @EventId(21) protected def ON_DECLARE_DOMINION_EVENT(@EventId(name = "def0", value = 736) def0: SpawnDefine, @EventId(name = "i0", value = 280) i0: Int) {
  }

  @EventId(22) protected def ON_DEBUG_MAKER_EVENT(@EventId(name = "reply", value = 272) reply: Int, @EventId(name = "creature", value = 112) creature: Creature) {
  }
}
