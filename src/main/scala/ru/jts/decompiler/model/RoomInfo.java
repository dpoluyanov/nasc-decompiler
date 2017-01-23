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
public class RoomInfo {

    @EventId(12)
    public int member_count;

    @EventId(52)
    public int time;

    @EventId(56)
    public int party_id;

    @EventId(80)
    public AtomicValue status;

    @EventId(369164289)
    public void SetParty(int party_id) {
    }

    @EventId(369164288)
    public int GetMemberID(int index) {
        return 0;
    }

    @EventId(369098754)
    public void Clear() {
    }

    @EventId(369098756)
    public boolean PartyChanged() {
        return false;
    }
}
