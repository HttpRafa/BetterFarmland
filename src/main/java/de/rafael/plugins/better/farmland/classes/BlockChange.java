/*
 * Copyright (c) 2022. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *     * Redistributions of source code must retain the above copyright notice,
 *         this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *         notice, this list of conditions and the following disclaimer in the
 *         documentation and/or other materials provided with the distribution.
 *     * Neither the name of the developer nor the names of its contributors
 *         may be used to endorse or promote products derived from this software
 *         without specific prior written permission.
 *     * Redistributions in source or binary form must keep the original package
 *         and class name.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package de.rafael.plugins.better.farmland.classes;

//------------------------------
//
// This class was developed by Rafael K.
// On 07/16/2022 at 2:55 PM
// In the project BetterFarmland
//
//------------------------------

import org.bukkit.Material;
import org.bukkit.Sound;

public record BlockChange(ChangeSound sound, Material from, Material to, ChangeDrop drop, int newAge) {

    @Override
    public String toString() {
        return "BlockChange{" +
                "sound=" + sound +
                ", from=" + from +
                ", to=" + to +
                ", drop=" + drop +
                ", newAge=" + newAge +
                '}';
    }

    public record ChangeSound(Sound sound, float soundVolume, float soundPitch) {

        @Override
        public String toString() {
            return "ChangeSound{" +
                    "sound=" + sound +
                    ", soundVolume=" + soundVolume +
                    ", soundPitch=" + soundPitch +
                    '}';
        }

    }

    public record ChangeDrop(Material item, int amount) {

        @Override
        public String toString() {
            return "ChangeDrop{" +
                    "item=" + item +
                    ", amount=" + amount +
                    '}';
        }

    }

}
