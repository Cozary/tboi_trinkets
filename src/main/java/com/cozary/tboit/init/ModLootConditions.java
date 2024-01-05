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

package com.cozary.tboit.init;

import com.cozary.tboit.TboiTrinkets;
import com.cozary.tboit.loot.ConfigurableRandomChance;
import net.minecraft.loot.LootConditionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;

public class ModLootConditions {

    public static final LootConditionType CONFIGURABLE_TRINKET_CHANCE = new LootConditionType(new ConfigurableRandomChance.Serializer());

    public static void register(RegistryEvent<GlobalLootModifierSerializer<?>> event) {
        Registry.register(
                Registry.LOOT_CONDITION_TYPE,
                new ResourceLocation(TboiTrinkets.MOD_ID, "configurable_random_chance"),
                ModLootConditions.CONFIGURABLE_TRINKET_CHANCE
        );
    }
}
