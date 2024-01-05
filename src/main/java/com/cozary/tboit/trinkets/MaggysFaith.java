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

import com.cozary.tboit.init.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class MaggysFaith extends CurioItemBase {

    private double tick = 2000;

    @Override
    public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack) {
        Random rand = new Random();
        ItemStack item0 = ModItems.ETERNAL_HEART.get().getDefaultInstance();
        if(--tick == 0){
            float rx = rand.nextFloat() * 5F - 2.5F;
            float ry = rand.nextFloat() * 2F + 0.1F;
            float rz = rand.nextFloat() * 5F - 2.5F;

            ItemEntity entityItem0 = new ItemEntity(livingEntity.world,
                    livingEntity.getPosX() + rx, livingEntity.getPosY() + ry, livingEntity.getPosZ() + rz,
                    item0);

            float factor = 0.05F;
            entityItem0.setMotion(
                    rand.nextGaussian() * factor,
                    rand.nextGaussian() * factor + 0.2F,
                    rand.nextGaussian() * factor);
            livingEntity.world.addEntity(entityItem0);
            tick = 2000;
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(TextFormatting.DARK_AQUA + "" + TextFormatting.ITALIC + "Faith's reward"));
    }
}