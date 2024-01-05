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
import com.cozary.tboit.potions.WorldUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.List;

public class HighPriestessCard extends Item {
    private Entity newTarget;

    public HighPriestessCard() {
        super(new Properties()
                .group(TboiTrinkets.TAB)
        );
    }

    public static boolean isValidTarget1(LivingEntity ent) {
        return (ent.getType() != EntityType.PLAYER) && (!ent.isInvulnerable());
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        AxisAlignedBB targetBox = new AxisAlignedBB(player.getPosition(), player.getPosition()).grow(25);
        BlockPos pos;
        List<LivingEntity> foundTarget =
                player.world.getEntitiesWithinAABB(LivingEntity.class, targetBox, HighPriestessCard::isValidTarget1);
        if (!world.isRemote) {
            if (!foundTarget.isEmpty()) {
                List<LivingEntity> newfoundTarget =
                        player.world.getEntitiesWithinAABB(LivingEntity.class, targetBox, EventHandler::isValidTarget);

                if (newfoundTarget.size() == 1) {
                    for (int i = 1; i < newfoundTarget.size(); i++) {
                        newfoundTarget.get(i - 1).getHealth();

                        if (newfoundTarget.get(i - 1).getHealth() < newfoundTarget.get(i).getHealth()) {
                            newTarget = newfoundTarget.get(i);
                        }
                    }
                }
                newTarget = newfoundTarget.get(0);
                pos = newTarget.getPosition();
                WorldUtil.spawnMomLeg(((ServerWorld) world).getWorldServer(), pos);

            } else {
                pos = player.getPosition();

                WorldUtil.spawnMomLeg(((ServerWorld) world).getWorldServer(), pos);

            }
        }
        if (!player.abilities.isCreativeMode) {
            itemstack.shrink(1);
        }
        return ActionResult.resultConsume(itemstack);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(TextFormatting.DARK_PURPLE + "" + TextFormatting.ITALIC + "Mother is watching you"));
    }
}
