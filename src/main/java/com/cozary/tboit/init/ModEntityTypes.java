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
import com.cozary.tboit.entities.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, TboiTrinkets.MOD_ID);

    public static final RegistryObject<EntityType<BlueBabyEntity>> BLUE_BABY = ENTITY_TYPES.register("blue_baby", () -> EntityType.Builder.create(BlueBabyEntity::new, EntityClassification.MONSTER)
            .size(0.5f, 0.5f)
            .build(new ResourceLocation(TboiTrinkets.MOD_ID, "blue_baby").toString()));

    public static final RegistryObject<EntityType<MomLegEntity>> MOM_LEG = ENTITY_TYPES.register("mom_leg", () -> EntityType.Builder.create(MomLegEntity::new, EntityClassification.MONSTER)
            .size(1.0f, 2.5f)
            .build(new ResourceLocation(TboiTrinkets.MOD_ID, "mom_leg").toString()));

    public static final RegistryObject<EntityType<SlotMachineEntity>> SLOT_MACHINE = ENTITY_TYPES.register("slot_machine", () -> EntityType.Builder.create(SlotMachineEntity::new, EntityClassification.AMBIENT)
            .size(2.5f, 2.0f)
            .build(new ResourceLocation(TboiTrinkets.MOD_ID, "slot_machine").toString()));

    public static final RegistryObject<EntityType<DeadBirdEntity>> DEAD_BIRD = ENTITY_TYPES.register("dead_bird", () -> EntityType.Builder.create(DeadBirdEntity::new, EntityClassification.MONSTER)
            .size(0.5f, 0.5f)
            .build(new ResourceLocation(TboiTrinkets.MOD_ID, "dead_bird").toString()));

    public static final RegistryObject<EntityType<BlueFlyEntity>> BLUE_FLY = ENTITY_TYPES.register("blue_fly", () -> EntityType.Builder.create(BlueFlyEntity::new, EntityClassification.MONSTER)
            .size(0.25f, 0.25f)
            .build(new ResourceLocation(TboiTrinkets.MOD_ID, "blue_fly").toString()));

    public static final RegistryObject<EntityType<IsaacHeadEntity>> ISAAC_HEAD = ENTITY_TYPES.register("isaac_head", () -> EntityType.Builder.create(IsaacHeadEntity::new, EntityClassification.MONSTER)
            .size(0.5f, 0.5f)
            .build(new ResourceLocation(TboiTrinkets.MOD_ID, "isaac_head").toString()));
}

