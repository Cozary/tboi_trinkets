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

import com.cozary.tboit.EventHandler;
import com.cozary.tboit.TboiTrinkets;
import com.cozary.tboit.init.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;

import javax.annotation.Nullable;
import java.util.List;

public class DeathCard extends Item {
    public DeathCard() {
        super(new Properties()
                .group(TboiTrinkets.TAB)
        );
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        ItemStack stack =
                CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.A_MISSING_PAGE.get(), playerIn).map(
                        ImmutableTriple::getRight).orElse(ItemStack.EMPTY);


        AxisAlignedBB targetBox = new AxisAlignedBB(playerIn.getPosition(), playerIn.getPosition()).grow(25);

        List<LivingEntity> foundTarget =
                playerIn.world.getEntitiesWithinAABB(LivingEntity.class, targetBox, EventHandler::isValidTarget);

        if (!foundTarget.isEmpty()) {

            for (int i = 0; i < foundTarget.size(); i++) {
                if (stack.isEmpty()) {
                    foundTarget.get(i).attackEntityFrom(DamageSource.GENERIC, 4);
                } else {
                    foundTarget.get(i).attackEntityFrom(DamageSource.GENERIC, 40);
                }
            }
        }


        if (!playerIn.abilities.isCreativeMode) {
            itemstack.shrink(1);
        }
        return ActionResult.resultConsume(itemstack);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(TextFormatting.DARK_PURPLE + "" + TextFormatting.ITALIC + "Lay waste to all that oppose you"));
    }
}
