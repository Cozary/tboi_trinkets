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

package com.cozary.tboit.util;

import com.cozary.tboit.TboiTrinkets;
import com.cozary.tboit.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class AddDrops {


    @SubscribeEvent
    public void addDrop(LivingDropsEvent event) {
        if (Minecraft.getInstance().player != null) {
            Entity source = event.getSource().getTrueSource();
            PlayerEntity player = Minecraft.getInstance().player;
            if (source instanceof PlayerEntity) {
                ItemStack stack0 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.ACE_OF_SPADES.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);
                ItemStack stack1 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.BIBLE_TRACK.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);
                ItemStack stack2 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.BLACK_LIPSTICK.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);
                ItemStack stack3 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.CHILDS_HEART.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);
                ItemStack stack4 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.DAEMONS_TAIL.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);
                ItemStack stack5 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.MATCH_STICK.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);
                ItemStack stack6 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.MOMS_PEARL.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

                if (!stack0.isEmpty() && event.getEntity().world.rand.nextInt(100) <= 10) {
                    List<Integer> givenList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22);
                    Random rand = new Random();
                    int get = givenList.get(rand.nextInt(givenList.size()));
                    TboiTrinkets.LOGGER.debug(get);
                    if (!event.getEntity().world.isRemote) {
                        Collection<ItemEntity> drops = event.getDrops();
                        if (get == 1)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.THE_FOOL.get())));
                        if (get == 2)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.THE_MAGICIAN.get())));
                        if (get == 3)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.THE_HIGH_PRIESTESS.get())));
                        if (get == 4)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.THE_EMPRESS.get())));
                        if (get == 5)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.THE_EMPEROR.get())));
                        if (get == 6)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.THE_HIEROPHANT.get())));
                        if (get == 7)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.THE_LOVERS.get())));
                        if (get == 8)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.THE_CHARIOT.get())));
                        if (get == 9)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.THE_JUSTICE.get())));
                        if (get == 10)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.THE_HERMIT.get())));
                        if (get == 11)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.THE_WHEEL_OF_FORTUNE.get())));
                        if (get == 12)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.STRENGTH.get())));
                        if (get == 13)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.THE_HANGED_MAN.get())));
                        if (get == 14)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.DEATH.get())));
                        if (get == 15)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.TEMPERANCE.get())));
                        if (get == 16)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.THE_DEVIL.get())));
                        if (get == 17)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.THE_TOWER.get())));
                        if (get == 18)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.THE_STARS.get())));
                        if (get == 19)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.THE_MOON.get())));
                        if (get == 20)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.THE_SUN.get())));
                        if (get == 21)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.JUDGEMENT.get())));
                        if (get == 22)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.THE_WORLD.get())));
                    }
                }
                if (!stack1.isEmpty() && event.getEntity().world.rand.nextInt(100) <= 10) {
                    if (!event.getEntity().world.isRemote) {
                        Collection<ItemEntity> drops = event.getDrops();
                        drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.ETERNAL_HEART.get())));
                    }
                }
                if (!stack2.isEmpty() && event.getEntity().world.rand.nextInt(100) <= 5) {
                    if (!event.getEntity().world.isRemote) {
                        Collection<ItemEntity> drops = event.getDrops();
                        drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.BLACK_HEART.get())));
                    }
                }
                if (!stack3.isEmpty() && event.getEntity().world.rand.nextInt(100) <= 10) {
                    if (!event.getEntity().world.isRemote) {
                        Collection<ItemEntity> drops = event.getDrops();
                        drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.RED_HEART.get())));
                    }
                }
                if (!stack5.isEmpty() && event.getEntity().world.rand.nextInt(100) <= 10) {
                    if (!event.getEntity().world.isRemote) {
                        Collection<ItemEntity> drops = event.getDrops();
                        drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.BOMB.get())));
                    }
                }
                if (event.getEntity().world.rand.nextInt(100) <= 1 && !event.getEntity().world.isRemote) {
                    Collection<ItemEntity> drops = event.getDrops();
                    //Custom Drops for this trinkets. 80% llaves
                    if (!stack4.isEmpty()) {
                        List<Integer> givenList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                        Random rand = new Random();
                        int get = givenList.get(rand.nextInt(givenList.size()));
                        if (get == 1 || get == 2 || get == 3 || get == 4 || get == 5 || get == 6 || get == 7 || get == 8)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.KEY.get())));
                        if (get == 9 || get == 10)
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.BLACK_HEART.get())));
                    }
                    if (!stack6.isEmpty() && event.getEntity().world.rand.nextInt(100) <= 10) {
                            drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.SOUL_HEART.get())));
                    } else {
                        drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.SOUL_HEART.get())));
                        drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.BLACK_HEART.get())));
                        drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.ETERNAL_HEART.get())));
                        drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.RED_HEART.get())));
                    }

                    drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.KEY.get())));
                    drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.BOMB.get())));
                    drops.add(newEntity(event.getEntity(), new ItemStack(ModItems.PENNY.get())));

                }
            }
        }
    }

    public ItemEntity newEntity(Entity e, ItemStack stack) {
        double x = e.getPosX();
        double y = e.getPosY();
        double z = e.getPosZ();
        return new ItemEntity(e.world, x, y, z, stack);
    }
}

