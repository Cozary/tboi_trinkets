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

package com.cozary.tboit.items;

import com.cozary.tboit.TboiTrinkets;
import com.cozary.tboit.capability.capabilities.CapabilityModel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class BlackHeartItem extends Item {

    public BlackHeartItem() {
        super(new Properties()
                .group(TboiTrinkets.TAB)
                .maxStackSize(1)
        );
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (!world.isRemote && CapabilityModel.getBlackHealthAmount() < 20) {
            CapabilityModel.setBlackHealthAmount(CapabilityModel.getBlackHealthAmount() + 2);

            if (!player.abilities.isCreativeMode) {
                itemstack.shrink(1);
            }
            return ActionResult.resultConsume(itemstack);

        } else

            return ActionResult.resultFail(itemstack);
    }
}
