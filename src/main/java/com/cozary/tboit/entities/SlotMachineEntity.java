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

package com.cozary.tboit.entities;

import com.cozary.tboit.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class SlotMachineEntity extends MobEntity {

    public SlotMachineEntity(EntityType<? extends SlotMachineEntity> type, World worldIn) {
        super(type, worldIn);

    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 10.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.0D);
    }

    @Override
    protected boolean isMovementBlocked() {
        return true;
    }

    @Override
    public void applyEntityCollision(Entity entityIn) {
        this.movedDistance = 0;
        if (entityIn instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityIn;
            ItemStack itemstack = ModItems.PENNY.get().getDefaultInstance();
            int j = player.inventory.findSlotMatchingUnusedItem(itemstack);
            if (j >= 0) {
                player.inventory.decrStackSize(j, 1);
                List<Integer> givenList = Arrays.asList(1, 2, 3);
                Random rand = new Random();
                int randomElement = givenList.get(rand.nextInt(givenList.size()));
                if (randomElement == 1) {
                    this.entityDropItem(ModItems.PENNY.get());
                } else if (randomElement == 2) {
                    this.entityDropItem(ModItems.BOMB.get());
                } else if (randomElement == 3) {
                    this.entityDropItem(ModItems.KEY.get());
                }
            }
        }
    }

}

