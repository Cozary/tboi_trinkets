/*
 *
 *  * Copyright (c) 2024 Cozary
 *  *
 *  * This file is part of TBOI Trinkets, a mod made for Minecraft.
 *  *
 *  * TBOI Trinkets is free software: you can redistribute it and/or modify it
 *  * under the terms of the GNU General Public License as published
 *  * by the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  *
 *  * TBOI Trinkets is distributed in the hope that it will be useful, but
 *  * WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU General Public License
 *  * License along with TBOI Trinkets.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package com.cozary.tboit.potions;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class CommonModEvents {

    public static void onRegisterEffects(Registrator<Effect> reg) {
        reg.register(ResourceLocations.EVANESCENCE, new EvanescenceEffect(EffectType.HARMFUL, 0));
    }

}
