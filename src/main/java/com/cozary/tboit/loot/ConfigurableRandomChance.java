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

package com.cozary.tboit.loot;

import com.cozary.tboit.init.ModLootConditions;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.loot.ILootSerializer;
import net.minecraft.loot.LootConditionType;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;

public class ConfigurableRandomChance implements ILootCondition {

    private final float defaultProbability;

    private ConfigurableRandomChance(float defaultProbability) {
        this.defaultProbability = defaultProbability;
    }

    public static IBuilder configurableRandomChance(float probability) {
        return () -> new ConfigurableRandomChance(probability);
    }

    @Override
    public LootConditionType getConditionType() {
        return ModLootConditions.CONFIGURABLE_TRINKET_CHANCE;
    }

    public boolean test(LootContext context) {
        float c = (float) (double) 1;
        float p = defaultProbability;
        return context.getRandom().nextFloat() < p / (p + c - c * p);
    }

    public static class Serializer implements ILootSerializer<ConfigurableRandomChance> {

        public void serialize(JsonObject object, ConfigurableRandomChance condition, JsonSerializationContext context) {
            object.addProperty("default", condition.defaultProbability);
        }

        public ConfigurableRandomChance deserialize(JsonObject object, JsonDeserializationContext context) {
            return new ConfigurableRandomChance(JSONUtils.getFloat(object, "default_probability"));
        }
    }
}
