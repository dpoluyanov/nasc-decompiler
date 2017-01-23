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

/**
 * Created by dmitrij on 24.05.15.
 */
public class BuySellItemInfo {
    private final int item_id;
    private final int unk1;
    private double unk2;
    private int unk3;

    private int constructor = 0;

    public BuySellItemInfo(int item_id, int unk1) {
        this.item_id = item_id;
        this.unk1 = unk1;

        constructor = 1;
    }

    public BuySellItemInfo(int item_id, int unk1, double unk2, int unk3) {
        this.item_id = item_id;
        this.unk1 = unk1;
        this.unk2 = unk2;
        this.unk3 = unk3;

        constructor = 2;
    }

    @Override
    public String toString() {
        switch (constructor) {
            case 1:
                return "new BuySellItemInfo(" + item_id + ", " + unk1 + ")";
            case 2:
                return "new BuySellItemInfo(" + item_id + ", " + unk1 + ", " + unk2 + ", " + unk3 + ")";
        }

        return super.toString();
    }
}
