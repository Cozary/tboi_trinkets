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

package com.cozary.tboit.trinkets;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BrokenMagnet extends CurioItemBase {

    @Override
    public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack) {
        if (livingEntity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) livingEntity;
            World world = player.world;
            double range = 25;
            List<ItemEntity> items = world.getEntitiesWithinAABB(ItemEntity.class, player.getBoundingBox().grow(range));
            for (ItemEntity item : items) {
                if (!item.isAlive())
                    continue;

                if (item.getThrowerId() != null && item.getThrowerId().equals(player.getUniqueID()) && item.cannotPickup())
                    continue;

                if (!world.isRemote() && item.getItem().toString().contains("penny")) {
                    item.setNoPickupDelay();
                    item.setPosition(player.getPosX(), player.getPosY(), player.getPosZ());
                }
            }

            List<ExperienceOrbEntity> xporbs = world.getEntitiesWithinAABB(ExperienceOrbEntity.class, player.getBoundingBox().grow(range));
            for (ExperienceOrbEntity orb : xporbs) {
                if (!world.isRemote()) {
                    orb.setPosition(player.getPosX(), player.getPosY(), player.getPosZ());
                }

            }
        }
    }


    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(TextFormatting.DARK_AQUA + "" + TextFormatting.ITALIC + "It kinda works!"));
    }
}