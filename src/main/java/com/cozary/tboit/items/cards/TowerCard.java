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

package com.cozary.tboit.items.cards;

import com.cozary.tboit.TboiTrinkets;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class TowerCard extends Item {
    Random rand = new Random();

    public TowerCard() {
        super(new Properties()
                .group(TboiTrinkets.TAB)
        );
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        BlockPos pos;
        if (!worldIn.isRemote) {
            for (int i = 0; i < 6; i++) {
                float rx = rand.nextFloat() * 5F - 2.5F;
                float ry = rand.nextFloat() * 2F - 0.1F;
                float rz = rand.nextFloat() * 5F - 2.5F;

                TNTEntity entity = new TNTEntity(worldIn,
                        playerIn.getPosX() + rx, playerIn.getPosY() + ry, playerIn.getPosZ() + rz, null);

                float factor = 0.05F;
                entity.setMotion(
                        rand.nextGaussian() * factor,
                        rand.nextGaussian() * factor + 0.5F,
                        rand.nextGaussian() * factor);
                worldIn.addEntity(entity);
            }
            if (!playerIn.abilities.isCreativeMode) {
                itemstack.shrink(1);
            }
        }
        return ActionResult.resultConsume(itemstack);

    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(TextFormatting.DARK_PURPLE + "" + TextFormatting.ITALIC + "Destruction brings creation"));
    }
}
