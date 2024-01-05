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
import com.cozary.tboit.init.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class JusticeCard extends Item {
    Random rand = new Random();

    public JusticeCard() {
        super(new Properties()
                .group(TboiTrinkets.TAB)
        );
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        ItemStack item0 = ModItems.RED_HEART.get().getDefaultInstance();
        ItemStack item1 = ModItems.KEY.get().getDefaultInstance();
        ItemStack item2 = ModItems.BOMB.get().getDefaultInstance();
        ItemStack item3 = ModItems.PENNY.get().getDefaultInstance();

        float rx = rand.nextFloat() * 5F - 2.5F;
        float ry = rand.nextFloat() * 2F + 0.1F;
        float rz = rand.nextFloat() * 5F - 2.5F;

        ItemEntity entityItem0 = new ItemEntity(world,
                player.getPosX() + rx, player.getPosY() + ry, player.getPosZ() + rz,
                item0);

        float factor = 0.05F;
        entityItem0.setMotion(
                rand.nextGaussian() * factor,
                rand.nextGaussian() * factor + 0.2F,
                rand.nextGaussian() * factor);
        world.addEntity(entityItem0);

        ItemEntity entityItem1 = new ItemEntity(world,
                player.getPosX() - rx, player.getPosY() + ry, player.getPosZ() - rz,
                item1);

        entityItem1.setMotion(
                rand.nextGaussian() * factor,
                rand.nextGaussian() * factor + 0.2F,
                rand.nextGaussian() * factor);
        world.addEntity(entityItem1);

        ItemEntity entityItem2 = new ItemEntity(world,
                player.getPosX() - rx, player.getPosY() + ry, player.getPosZ() + rz,
                item2);

        entityItem2.setMotion(
                rand.nextGaussian() * factor,
                rand.nextGaussian() * factor + 0.2F,
                rand.nextGaussian() * factor);
        world.addEntity(entityItem2);

        ItemEntity entityItem3 = new ItemEntity(world,
                player.getPosX() + rx, player.getPosY() + ry, player.getPosZ() - rz,
                item3);

        entityItem3.setMotion(
                rand.nextGaussian() * factor,
                rand.nextGaussian() * factor + 0.2F,
                rand.nextGaussian() * factor);
        world.addEntity(entityItem3);

        if (!player.abilities.isCreativeMode) {
            itemstack.shrink(1);
        }
        return ActionResult.resultConsume(itemstack);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(TextFormatting.DARK_PURPLE + "" + TextFormatting.ITALIC + "May your future become balanced"));
    }
}
