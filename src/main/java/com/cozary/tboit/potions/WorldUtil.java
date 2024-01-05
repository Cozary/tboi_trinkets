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

import com.cozary.tboit.entities.BlueBabyEntity;
import com.cozary.tboit.entities.IsaacHeadEntity;
import com.cozary.tboit.entities.MomLegEntity;
import com.cozary.tboit.init.ModEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class WorldUtil {
    public static int ticksToExist = 200;

    public static void spawnBlueBaby(ServerWorld world, BlockPos vec) {

        BlockPos spawnPos = new BlockPos(vec.getX(), vec.getY(), vec.getZ());
        Entity ent = ModEntityTypes.BLUE_BABY.get().spawn(world, null, null, spawnPos, SpawnReason.EVENT, false, false);
        if (ent instanceof BlueBabyEntity) {
            BlueBabyEntity bee = (BlueBabyEntity) ent;
            bee.setPosition(vec.getX(), vec.getY(), vec.getZ());
            bee.addPotionEffect(new EffectInstance(RegistryObjects.EVANESCENCE_EFFECT, 40, 0, false, false));
        }
    }

    public static void spawnIsaacHead(ServerWorld world, BlockPos vec) {

        BlockPos spawnPos = new BlockPos(vec.getX(), vec.getY(), vec.getZ());
        Entity ent = ModEntityTypes.ISAAC_HEAD.get().spawn(world, null, null, spawnPos, SpawnReason.EVENT, false, false);
        if (ent instanceof IsaacHeadEntity) {
            IsaacHeadEntity bee = (IsaacHeadEntity) ent;
            bee.setPosition(vec.getX(), vec.getY(), vec.getZ());
            bee.addPotionEffect(new EffectInstance(RegistryObjects.EVANESCENCE_EFFECT, 200, 0, false, false));
        }
    }

    public static void spawnMomLeg(ServerWorld world, BlockPos vec) {

        BlockPos spawnPos = new BlockPos(vec.getX(), vec.getY() + 6, vec.getZ());
        Entity ent = ModEntityTypes.MOM_LEG.get().spawn(world, null, null, spawnPos, SpawnReason.EVENT, false, false);
        ent.setVelocity(0, -10, 0);
        ent.velocityChanged = true;
        if (ent instanceof MomLegEntity) {
            MomLegEntity bee = (MomLegEntity) ent;
            bee.setPosition(vec.getX(), vec.getY(), vec.getZ());
            bee.addPotionEffect(new EffectInstance(RegistryObjects.EVANESCENCE_EFFECT, 40, 0, false, false));
        }
    }

}
