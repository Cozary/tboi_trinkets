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
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EmperorCard extends Item {
    public EmperorCard() {
        super(new Properties()
                .group(TboiTrinkets.TAB)
        );
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        double requiredX, requiredY, requiredZ;
        requiredX = player.getPosX();
        requiredY = player.getPosY();
        requiredZ = player.getPosZ();
        BlockPos spawnPos = new BlockPos(requiredX, requiredY, requiredZ);
        List<Integer> givenList = Arrays.asList(1, 2, 3);
        Random rand = new Random();
        int randomElement = givenList.get(rand.nextInt(givenList.size()));

        if (randomElement == 1) {
            if (world instanceof ServerWorld && !player.isPassenger() && !player.isBeingRidden() && player.canChangeDimension()) {
                RegistryKey<World> registrykey = world.getDimensionKey() == World.THE_END ? World.OVERWORLD : World.THE_END;
                ServerWorld serverworld = ((ServerWorld) world).getServer().getWorld(registrykey);
                if (serverworld == null) {
                    return null;
                }
                player.changeDimension(serverworld);
            }
        } else if (randomElement == 2 && world instanceof ServerWorld && !player.isPassenger() && !player.isBeingRidden()) {
            EntityType.WITHER.spawn((ServerWorld) world, null, null, spawnPos, SpawnReason.EVENT, false, false);
        } else if (randomElement == 3 && world instanceof ServerWorld && !player.isPassenger() && !player.isBeingRidden()) {
            BlockPos blockpos = ((ServerWorld) world).getChunkProvider().getChunkGenerator().func_235956_a_((ServerWorld) world, Structure.MONUMENT, player.getPosition(), 100, false);
            if (blockpos != null) {
                player.setPositionAndUpdate(blockpos.getX(), blockpos.getY() + 60, blockpos.getZ());
            }
        }
        if (!player.abilities.isCreativeMode) {
            itemstack.shrink(1);
        }
        return ActionResult.resultConsume(itemstack);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(TextFormatting.DARK_PURPLE + "" + TextFormatting.ITALIC + "Challenge me!"));
    }
}
