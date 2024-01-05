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
import net.minecraft.loot.LootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;
import java.util.List;

public class ModLootTables {

    @SuppressWarnings("unused")
    @Mod.EventBusSubscriber(modid = TboiTrinkets.MOD_ID)
    public static class LootTableEvents {

        public static final List<String> LOOT_TABLE_LOCATIONS = Arrays.asList(
                "chests/village/village_armorer",
                "chests/village/village_butcher",
                "chests/village/village_tannery",
                "chests/village/village_temple",
                "chests/village/village_toolsmith",
                "chests/village/village_weaponsmith",
                "chests/village/village_desert_house",
                "chests/village/village_plains_house",
                "chests/village/village_savanna_house",
                "chests/village/village_snowy_house",
                "chests/village/village_taiga_house",
                "chests/abandoned_mineshaft",
                "chests/bastion_hoglin_stable",
                "chests/bastion_treasure",
                "chests/buried_treasure",
                "chests/desert_pyramid",
                "chests/end_city_treasure",
                "chests/jungle_temple",
                "chests/nether_bridge",
                "chests/pillager_outpost",
                "chests/ruined_portal",
                "chests/shipwreck_treasure",
                "chests/spawn_bonus_chest",
                "chests/stronghold_corridor",
                "chests/underwater_ruin_big",
                "chests/woodland_mansion",
                "chests/simple_dungeon"
        );

        @SubscribeEvent
        @SuppressWarnings("unused")
        public static void onLootTableLoad(LootTableLoadEvent event) {
            String prefix = "minecraft:";
            String name = event.getName().toString();

            if (name.startsWith(prefix)) {
                String location = name.substring(name.indexOf(prefix) + prefix.length());
                if (LOOT_TABLE_LOCATIONS.contains(location)) {
                    TboiTrinkets.LOGGER.debug("Adding loot to " + name);
                    event.getTable().addPool(getInjectPool(location));
                }
            }
        }

        public static LootPool getInjectPool(String entryName) {
            return LootPool.builder()
                    .addEntry(getInjectEntry(entryName))
                    .name("trinkets_inject")
                    .build();
        }

        private static LootEntry.Builder<?> getInjectEntry(String name) {
            ResourceLocation table = new ResourceLocation(TboiTrinkets.MOD_ID, "inject/" + name);
            return TableLootEntry.builder(table).weight(1);
        }
    }
}
