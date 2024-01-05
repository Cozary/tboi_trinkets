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

package com.cozary.tboit;

import com.cozary.tboit.capability.SyncToClient;
import com.cozary.tboit.capability.capabilities.CapabilityModel;
import com.cozary.tboit.entities.BlueFlyEntity;
import com.cozary.tboit.entities.DeadBirdEntity;
import com.cozary.tboit.init.ModEntityTypes;
import com.cozary.tboit.init.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class EventHandler {

    private static final UUID LuckyToe = UUID.randomUUID();
    private static final UUID GoatHoof = UUID.randomUUID();
    private static final UUID CurvedHorn = UUID.randomUUID();
    private static final UUID cancerATSPD = UUID.randomUUID();
    private static final UUID deleteHP = UUID.randomUUID();
    private static final UUID moreDamage = UUID.randomUUID();
    private static final UUID moreSpeed = UUID.randomUUID();
    private static final UUID strengthHP = UUID.randomUUID();
    private static final UUID strengthDamage = UUID.randomUUID();
    private static final UUID strengthDamageMultiplier = UUID.randomUUID();
    private static final UUID strengthSpeed = UUID.randomUUID();
    private static final UUID chariotSpeed = UUID.randomUUID();
    private static final UUID eternalHP = UUID.randomUUID();
    private static final UUID devilDamage = UUID.randomUUID();
    private static final UUID redPatchDamage = UUID.randomUUID();
    double cartridgeCounter = 0;
    float oldBlackHealth = 0;
    private int tickHandler;
    private int oldTickHandler = 0;
    private int strengthTickHandler;
    private int strengthOldTickHandler = 0;
    private int chariotTickHandler;
    private int chariotOldTickHandler = 0;
    private int hangedManTickHandler;
    private int hangedManOldTickHandler = 0;
    private float oldlevel = 0;
    private int devilTickHandler;
    private int devilOldTickHandler = 0;
    private int MisteriousCandyTicks;

    public static boolean isValidTarget(LivingEntity ent) {
        return (ent.getType() != EntityType.PLAYER) && (!ent.isInvulnerable());
    }

    public static boolean isValidTarget1(LivingEntity ent) {
        return (ent.getType() != EntityType.PLAYER) && (!ent.isInvulnerable());
    }

    /*------RED PATCH-------*/
    @SubscribeEvent
    public void RedPatch(LivingHurtEvent event) {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
            Random rand = new Random();
            if (event.getEntityLiving() == player && player != null) {
                ItemStack stack0 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.RED_PATCH.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);
                ModifiableAttributeInstance atinst = player.getAttribute(Attributes.ATTACK_DAMAGE);
                AttributeModifier mod = new AttributeModifier(redPatchDamage, "redPatchDamage", 1.8F, AttributeModifier.Operation.ADDITION);

                TboiTrinkets.LOGGER.debug("redPatchDamage try");

                if (rand.nextInt(100) <= 20 && !stack0.isEmpty()) {
                    if (atinst.getModifier(redPatchDamage) == null) {
                        atinst.applyNonPersistentModifier(mod);
                        TboiTrinkets.LOGGER.debug("redPatchDamage Added");
                    }
                    else if(atinst.getModifier(redPatchDamage) != null){
                        atinst.removeModifier(mod);
                        atinst.applyNonPersistentModifier(mod);
                        TboiTrinkets.LOGGER.debug("redPatchDamage Reset");
                    }
                } else if (atinst.getModifier(redPatchDamage) != null && stack0.isEmpty()) {
                    atinst.removeModifier(mod);
                    TboiTrinkets.LOGGER.debug("redPatchDamage Removed");
                }

            }
        }
    }

    /*------PUSH PIN------*/
    @SubscribeEvent
    public void PushPink(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        Entity src = source.getTrueSource();
        Random rand = new Random();
        if (src != null && src instanceof PlayerEntity && source.isProjectile()) {
            ItemStack stack0 =
                    CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.PUSH_PIN.get(), (LivingEntity) src).map(
                            ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

            if (rand.nextInt(100) <= 10 && !stack0.isEmpty()) {
                AxisAlignedBB targetBox = new AxisAlignedBB(src.getPosition(), src.getPosition()).grow(500);

                List<ProjectileEntity> foundTarget =
                        src.world.getEntitiesWithinAABB(ProjectileEntity.class, targetBox);

                for (int i = 0; i < foundTarget.size(); i++) {
                    if(foundTarget.get(i).getShooter() == src){
                        TboiTrinkets.LOGGER.debug("PushPin Working but without working");
                    }
                }

            }
        }
    }

    /*-----PINKY EYE-----*/
    @SubscribeEvent
    public void PinkyEye(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        Entity src = source.getTrueSource();
        Random rand = new Random();
        if (src != null && src instanceof PlayerEntity) {
            ItemStack stack0 =
                    CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.MYSTERIOUS_CANDY.get(), (LivingEntity) src).map(
                            ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

            if (rand.nextInt(100) <= 10 && !stack0.isEmpty()) {
                EffectInstance effectinstance = new EffectInstance(Effects.POISON, 100, 0);
                LivingEntity potionGo = event.getEntityLiving();
                potionGo.addPotionEffect(effectinstance);
            }
        }
    }

    /*-----MYSTERIOUS CANDY------*/
    @SubscribeEvent
    public void MisteriousCandy(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            PlayerEntity player = event.player;
            Random rand = new Random();
            MisteriousCandyTicks = player.ticksExisted;
            World world = player.world;
            if (player != null) {
                ItemStack stack0 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.MYSTERIOUS_CANDY.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

                if (!stack0.isEmpty() && rand.nextInt(100) <= 50 && (player.ticksExisted - MisteriousCandyTicks) > 200) {
                    AxisAlignedBB targetBox = new AxisAlignedBB(player.getPosition(), player.getPosition()).grow(25);

                    List<LivingEntity> foundTarget =
                            player.world.getEntitiesWithinAABB(LivingEntity.class, targetBox, EventHandler::isValidTarget);

                    for (int i = 0; i < foundTarget.size(); i++) {
                        Vector3d vector3d = new Vector3d(foundTarget.get(i).getPosX() - player.getPosX(), foundTarget.get(i).getPosY() - player.getPosY(), foundTarget.get(i).getPosZ() - player.getPosZ());
                        foundTarget.get(i).move(MoverType.PLAYER, vector3d);
                        foundTarget.get(i).addPotionEffect(new EffectInstance(Effects.POISON, 200, 1));
                        foundTarget.get(i).attackEntityFrom(DamageSource.GENERIC, 6);
                    }
                    world.setBlockState(player.getPosition().south(), Blocks.STONE.getDefaultState());
                }
            }
        }
    }

    /*------MONKEY PAW-------*/
    @SubscribeEvent
    public void MonkeyPaw(LivingHurtEvent event) {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
            World world = player.world;
            Random rand = new Random();
            if (event.getEntityLiving() == player && player != null) {
                ItemStack stack0 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.MONKEY_PAW.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

                if (!stack0.isEmpty() && player.getHealth() < 10 && rand.nextInt(100) < 10) {
                    ItemStack item0 = ModItems.BLACK_HEART.get().getDefaultInstance();

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
                }
            }
        }
    }

    /*-----LUCKY_TOE------*/
    @SubscribeEvent
    public void LuckyToe(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            PlayerEntity player = event.player;
            if (player != null) {
                ItemStack stack0 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.LUCKY_TOE.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

                ModifiableAttributeInstance atinst = player.getAttribute(Attributes.LUCK);
                AttributeModifier mod = new AttributeModifier(LuckyToe, "LuckyToe", 1D, AttributeModifier.Operation.ADDITION);

                if (!stack0.isEmpty() && atinst.getModifier(LuckyToe) == null) {
                    atinst.applyPersistentModifier(mod);
                } else if (stack0.isEmpty() && atinst.getModifier(LuckyToe) != null) {
                    atinst.removeModifier(mod);
                }
            }
        }
    }

    /*-------LUCKY_ROCK------*/
    @SubscribeEvent
    public void LuckyRock(BlockEvent.BreakEvent event){
            PlayerEntity player = event.getPlayer();
            Random rand = new Random();
            if(player != null){

                ItemStack item0 = ModItems.PENNY.get().getDefaultInstance();

                ItemStack stack0 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.LUCKY_ROCK.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);
                TboiTrinkets.LOGGER.debug(event.getState().equals(Blocks.STONE.getDefaultState()));
                if(!stack0.isEmpty() && event.getState().equals(Blocks.STONE.getDefaultState()) && rand.nextInt(100) >= 33){

                    float rx = rand.nextFloat() * 5F - 2.5F;
                    float ry = rand.nextFloat() * 2F + 0.1F;
                    float rz = rand.nextFloat() * 5F - 2.5F;

                    ItemEntity entityItem0 = new ItemEntity(player.world,
                            player.getPosX() + rx, player.getPosY() + ry, player.getPosZ() + rz,
                            item0);

                    float factor = 0.05F;
                    entityItem0.setMotion(
                            rand.nextGaussian() * factor,
                            rand.nextGaussian() * factor + 0.2F,
                            rand.nextGaussian() * factor);
                    player.world.addEntity(entityItem0);
                }

        }
    }

    /*------ISAACS_FORK-------*/
    @SubscribeEvent
    public void IsaacsFork(LivingDeathEvent event) {
        if (event.getSource().getTrueSource() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
            Random rand = new Random();
            if (player != null) {
                ItemStack stack0 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.ISAACS_FORK.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

                if (!stack0.isEmpty() && rand.nextInt(100) <= (10 + player.getLuck())) {
                    player.heal(2);
                }
            }
        }
    }

    /*-----GOAT_HOOF------*/
    @SubscribeEvent
    public void GoatHoof(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            PlayerEntity player = event.player;
            if (player != null) {
                ItemStack stack0 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.GOAT_HOOF.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

                ModifiableAttributeInstance atinst = player.getAttribute(Attributes.MOVEMENT_SPEED);
                AttributeModifier mod = new AttributeModifier(GoatHoof, "GoatHoof", 0.15D, AttributeModifier.Operation.ADDITION);

                if (!stack0.isEmpty() && atinst.getModifier(GoatHoof) == null) {
                    atinst.applyPersistentModifier(mod);
                } else if (stack0.isEmpty() && atinst.getModifier(GoatHoof) != null) {
                    atinst.removeModifier(mod);
                }
            }
        }
    }

    /*------FLAT_WORM----*/
    @SubscribeEvent
    public void FlatWorm(LivingHurtEvent event) {
        DamageSource source = event.getSource();
        Entity src = source.getTrueSource();

        if (src != null && src instanceof PlayerEntity) {

            ItemStack stack0 =
                    CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.FLAT_WORM.get(), (LivingEntity) src).map(
                            ImmutableTriple::getRight).orElse(ItemStack.EMPTY);
            if (!stack0.isEmpty()) {
                for (LivingEntity livingentity : src.world.getEntitiesWithinAABB(LivingEntity.class, event.getEntity().getBoundingBox().grow(5D, 8D, 5D))) {
                    if (livingentity != src && livingentity != event.getEntity() && !src.isOnSameTeam(livingentity) && (!(livingentity instanceof ArmorStandEntity) || !((ArmorStandEntity) livingentity).hasMarker()) && src.getDistanceSq(livingentity) < 9.0D) {
                        livingentity.applyKnockback(2, MathHelper.sin(src.rotationYaw * ((float) Math.PI / 180F)), -MathHelper.cos(src.rotationYaw * ((float) Math.PI / 180F)));
                        livingentity.attackEntityFrom(source, (float) ((PlayerEntity) src).getAttribute(Attributes.ATTACK_DAMAGE).getValue());
                    }
                }
            }
        }
    }

    /*------FISH_HEAD-------*/
    @SubscribeEvent
    public void FishHead(LivingHurtEvent event) {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
            if (event.getEntityLiving() == player && player != null) {
                ItemStack stack0 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.FISH_HEAD.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

                if (!stack0.isEmpty()) {
                    Entity ent = ModEntityTypes.BLUE_FLY.get().spawn((ServerWorld) player.world, null, null, player.getPosition(), SpawnReason.EVENT, false, false);
                    if (ent instanceof BlueFlyEntity) {
                        if (ent.getClass() == BlueFlyEntity.class) {
                            BlueFlyEntity wz = (BlueFlyEntity) ent;
                            //wz.addPotionEffect(new EffectInstance(RegistryObjects.EVANESCENCE_EFFECT, 6000, 0, false, false));
                            UUID uuid = player.getUniqueID();
                            if (uuid != null) {
                                wz.setOwnerId(uuid);
                                wz.setTamed(true);
                            }
                        }
                    }
                }
            }
        }
    }

    /*------EVES_BIRD_FOOT-------*/
    @SubscribeEvent
    public void EvesBirdFoot(LivingDeathEvent event) {
        if (event.getSource().getTrueSource() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
            Random rand = new Random();
            if (player != null) {
                ItemStack stack0 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.EVES_BIRD_FOOT.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

                if (!stack0.isEmpty() && rand.nextInt(100) <= (5 + player.getLuck())) {
                    Entity ent = ModEntityTypes.DEAD_BIRD.get().spawn((ServerWorld) player.world, null, null, player.getPosition(), SpawnReason.EVENT, false, false);
                    if (ent instanceof DeadBirdEntity) {
                        if (ent.getClass() == DeadBirdEntity.class) {
                            DeadBirdEntity wz = (DeadBirdEntity) ent;
                            //wz.addPotionEffect(new EffectInstance(RegistryObjects.EVANESCENCE_EFFECT, 200, 0, false, false));
                            UUID uuid = player.getUniqueID();
                            if (uuid != null) {
                                wz.setOwnerId(uuid);
                                wz.setTamed(true);
                            }
                        }
                    }
                }
            }
        }
    }

    /*-----CURVED_HORN------*/
    @SubscribeEvent
    public void CurvedHorn(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            PlayerEntity player = event.player;
            if (player != null) {
                ItemStack stack0 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.CURVED_HORN.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

                ModifiableAttributeInstance atinst = player.getAttribute(Attributes.ATTACK_DAMAGE);
                AttributeModifier mod = new AttributeModifier(CurvedHorn, "CurvedHorn", 2.0D, AttributeModifier.Operation.ADDITION);

                if (!stack0.isEmpty() && atinst.getModifier(CurvedHorn) == null) {
                    atinst.applyPersistentModifier(mod);
                } else if (stack0.isEmpty() && atinst.getModifier(CurvedHorn) != null) {
                    atinst.removeModifier(mod);
                }
            }
        }
    }

    /*------CURSED_SKULL-------*/
    @SubscribeEvent
    public void CursedSkull(LivingHurtEvent event) {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
            Random rand = new Random();
            if (event.getEntityLiving() == player && player != null) {
                ItemStack stack0 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.CURSED_SKULL.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

                if (!stack0.isEmpty() && player.getHealth() <= 6F) {
                    float rx = rand.nextFloat() * 1000F - 500F;
                    float ry = 65;
                    float rz = rand.nextFloat() * 1000F - 500F;
                    for (int i = 0; i < 6; i++) {
                        player.setPositionAndUpdate(player.getPosX() + rx, player.getPosY() + ry, player.getPosZ() + rz);
                    }
                }
            }
        }
    }
    /*------CARTRIDGE-----*/
    @SubscribeEvent
    public void CartridgeKill(LivingDeathEvent event) {
        if (event.getSource().getTrueSource() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getSource().getTrueSource();
            if (event.getSource() == DamageSource.GENERIC && CapabilityModel.getCartridge() == true && player != null) {
                player.heal(1);
            }
        }
    }

    /*------CARTRIDGE-----*/
    @SubscribeEvent
    public void Cartridge(LivingHurtEvent event) {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
            if (event.getEntityLiving() == player && player != null) {
                if (CapabilityModel.getCartridge() == true) {
                    event.setAmount(0);
                }
                ItemStack stack0 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.CARTRIDGE.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);
                Random rand = new Random();

                if (!stack0.isEmpty() && rand.nextInt(100) <= (10 + player.getLuck()) && CapabilityModel.getCartridge() == false) {
                    CapabilityModel.setCartridge(true);
                    cartridgeCounter = player.ticksExisted;
                }
            }
            SyncToClient.send(player);
        }

    }

    /*------CARTRIDGE-----*/
    @SubscribeEvent
    public void CartridgeCounter(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            PlayerEntity player = event.player;
            World world = player.world;
            if (player != null && !world.isRemote) {

                if ((player.ticksExisted - cartridgeCounter) > 120 && CapabilityModel.getCartridge() == true) {
                    CapabilityModel.setCartridge(false);
                    SyncToClient.send(player);
                }

                if (CapabilityModel.getCartridge() == true) {
                    AxisAlignedBB targetBox = new AxisAlignedBB(player.getPosition(), player.getPosition()).grow(5);

                    List<LivingEntity> foundTarget =
                            player.world.getEntitiesWithinAABB(LivingEntity.class, targetBox, EventHandler::isValidTarget);

                    for (int i = 0; i < foundTarget.size(); i++) {
                        foundTarget.get(i).setVelocity(0, 0, 0);
                        foundTarget.get(i).addPotionEffect(new EffectInstance(Effects.NAUSEA));
                    }
                }

            }
        }
    }

    /*------CANCER----*/
    @SubscribeEvent
    public void Cancer(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            PlayerEntity player = event.player;
            if (player != null) {
                ItemStack stack0 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.CANCER.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

                ModifiableAttributeInstance atinst = player.getAttribute(Attributes.ATTACK_SPEED);
                AttributeModifier mod = new AttributeModifier(cancerATSPD, "cancerATSPD", 1.5D, AttributeModifier.Operation.MULTIPLY_TOTAL);

                if (!stack0.isEmpty() && atinst.getModifier(cancerATSPD) == null) {
                    atinst.applyPersistentModifier(mod);
                } else if (stack0.isEmpty() && atinst.getModifier(cancerATSPD) != null) {
                    atinst.removeModifier(mod);

                }

            }
        }
    }

    /*------CALLUS-------*/
    @SubscribeEvent
    public void Callus(LivingHurtEvent event) {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
            if (event.getEntityLiving() == player && player != null) {
                ItemStack stack0 =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.CALLUS.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);
                if (!stack0.isEmpty()) {
                    if (event.getSource() == DamageSource.CACTUS || event.getSource() == DamageSource.ANVIL || event.getSource() == DamageSource.HOT_FLOOR || event.getSource() == DamageSource.SWEET_BERRY_BUSH) {
                        event.setAmount(0);
                    }
                }
            }
        }
    }

    /*-----BROKEN_ANKH-----*/
    @SubscribeEvent
    public void BrokenAnkh(LivingDeathEvent event) {
        World world = event.getEntity().getEntityWorld();
        Random rand = new Random();
        if (event.getEntity() instanceof PlayerEntity && !world.isRemote) {

            PlayerEntity player = (PlayerEntity) event.getEntity();
            if (player != null) {

                ItemStack stack =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.BROKEN_ANKH.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);


                if (!stack.isEmpty() && rand.nextInt(100) <= (22)) {
                    event.setCanceled(true);
                    player.setHealth(1);
                    CapabilityModel.setSoulHealthAmount(10);
                    CapabilityModel.setisRevived(true);

                } else {
                    CapabilityModel.setisRevived(false);

                }
                SyncToClient.send(player);

            }
        }
    }

    /*-----BROKEN_ANKH-----*/
    @SubscribeEvent
    public void BrokenAnkhHeal(LivingHealEvent event) {
        World world = event.getEntity().getEntityWorld();
        if (event.getEntity() instanceof PlayerEntity && !world.isRemote) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            if (player != null) {
                event.setCanceled(CapabilityModel.getisRevived());
            }
            SyncToClient.send(player);
        }
    }

    /*-----BROKEN_ANKH-----*/
    @SubscribeEvent
    public void BrokenAnkhHealthHandler(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            World world = event.player.getEntityWorld();
            PlayerEntity player = event.player;

            if (!world.isRemote) {

                if (player != null) {

                    float Health = -player.getMaxHealth();
                    ModifiableAttributeInstance atinst = player.getAttribute(Attributes.MAX_HEALTH);
                    AttributeModifier mod = new AttributeModifier(deleteHP, "deleteHP", Health, AttributeModifier.Operation.ADDITION);

                    if (CapabilityModel.getisRevived()) {
                        if (atinst.getModifier(deleteHP) == null) {
                            atinst.applyPersistentModifier(mod);
                        }
                    } else {
                        if (atinst.getModifier(deleteHP) != null) {
                            atinst.removeModifier(mod);
                        }
                    }
                }

        }
        }
    }

    /*-----BLACK_HEART_LOSS-------*/
    @SubscribeEvent
    public void BlackHeartLoss(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            PlayerEntity player = event.player;
        if (player != null) {
            float healthAmount = CapabilityModel.getBlackHealthAmount();

            if (oldBlackHealth < healthAmount) {

                oldBlackHealth = healthAmount;
            } else if (oldBlackHealth > healthAmount) {


                ItemStack stack =
                        CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.A_MISSING_PAGE.get(), player).map(
                                ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

                AxisAlignedBB targetBox = new AxisAlignedBB(player.getPosition(), player.getPosition()).grow(25);

                List<LivingEntity> foundTarget =
                        player.world.getEntitiesWithinAABB(LivingEntity.class, targetBox, EventHandler::isValidTarget);

                if (!foundTarget.isEmpty()) {
                    for (int i = 0; i < foundTarget.size(); i++) {
                        if (stack.isEmpty()) {
                            foundTarget.get(i).attackEntityFrom(DamageSource.GENERIC, 4F * (oldBlackHealth - healthAmount));
                        } else {
                            foundTarget.get(i).attackEntityFrom(DamageSource.GENERIC, 8F * (oldBlackHealth - healthAmount));

                        }
                    }

                }

                oldBlackHealth = healthAmount;


            }

        }

        }
    }

    /*--------ITEM PICKUP------*/
    @SubscribeEvent
    public void ItemPickup(EntityItemPickupEvent event) {
        Random rand = new Random();
        ItemEntity itemEntity = event.getItem();
        PlayerEntity player = event.getPlayer();
        if (player != null) {
            /*--SOUL HEART--*/
            ItemStack itemstack0 = ModItems.SOUL_HEART.get().getDefaultInstance();
            if (itemEntity.getItem().toString().equals(itemstack0.toString()) && CapabilityModel.getSoulHealthAmount() < 20) {
                CapabilityModel.setSoulHealthAmount(CapabilityModel.getSoulHealthAmount() + 2);
                CapabilityModel.setSoulHeartPickupAmount(CapabilityModel.getSoulHeartPickupAmount() + 1);
            }

            /*--RED HEART--*/
            ItemStack itemstack1 = ModItems.RED_HEART.get().getDefaultInstance();
            if (itemEntity.getItem().toString().equals(itemstack1.toString())) {
                if (event.getPlayer().getMaxHealth() > event.getPlayer().getHealth()) {
                    CapabilityModel.setRedHeartPickupAmount(CapabilityModel.getRedHeartPickupAmount() + 1);
                    event.getPlayer().heal(5);
                }
            }

            /*--BLACK HEART--*/
            ItemStack itemstack2 = ModItems.BLACK_HEART.get().getDefaultInstance();
            if (itemEntity.getItem().toString().equals(itemstack2.toString()) && CapabilityModel.getBlackHealthAmount() < 20) {
                CapabilityModel.setBlackHealthAmount(CapabilityModel.getBlackHealthAmount() + 2);
                CapabilityModel.setBlackHeartPickupAmount(CapabilityModel.getBlackHeartPickupAmount() + 1);
            }

            /*---PENNY PICKUP TRINKETS---*/
            int chance = -1;
            ItemStack item0 = null;
            ItemStack stack0 =
                    CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.BLOODY_PENNY.get(), player).map(
                            ImmutableTriple::getRight).orElse(ItemStack.EMPTY);
            ItemStack stack1 =
                    CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.BURN_PENNY.get(), player).map(
                            ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

            ItemStack stack2 =
                    CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.BUTT_PENNY.get(), player).map(
                            ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

            ItemStack stack3 =
                    CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.COUNTERFEIT_PENNY.get(), player).map(
                            ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

            ItemStack stack4 =
                    CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.FLAT_PENNY.get(), player).map(
                            ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

            ItemStack itemstack00 = ModItems.PENNY.get().getDefaultInstance();

            if (!stack0.isEmpty()) {
                item0 = ModItems.RED_HEART.get().getDefaultInstance();
                chance = 25;
            }
            if (!stack1.isEmpty()) {
                item0 = ModItems.BOMB.get().getDefaultInstance();
                chance = 25;
            }
            if (!stack3.isEmpty()) {
                item0 = ModItems.PENNY.get().getDefaultInstance();
                chance = 50;
            }
            if (!stack4.isEmpty()) {
                item0 = ModItems.KEY.get().getDefaultInstance();
                chance = 25;
            }
            //extra Item
            if (itemEntity.getItem().toString().equals(itemstack00.toString()) && item0 != null && rand.nextInt(100) <= chance) {

                int j = player.inventory.findSlotMatchingUnusedItem(itemstack00);
                if (j >= 0) {
                    float rx = rand.nextFloat() * 5F - 2.5F;
                    float ry = rand.nextFloat() * 2F + 0.1F;
                    float rz = rand.nextFloat() * 5F - 2.5F;

                    ItemEntity entityItem0 = new ItemEntity(player.world,
                            player.getPosX() + rx, player.getPosY() + ry, player.getPosZ() + rz,
                            item0);

                    float factor = 0.05F;
                    entityItem0.setMotion(
                            rand.nextGaussian() * factor,
                            rand.nextGaussian() * factor + 0.2F,
                            rand.nextGaussian() * factor);
                    player.world.addEntity(entityItem0);
                }

            }
            //No extra Item
            if (itemEntity.getItem().toString().equals(itemstack00.toString()) && !stack2.isEmpty()) {

                int j = player.inventory.findSlotMatchingUnusedItem(itemstack00);
                if (j >= 0) {
                    AxisAlignedBB targetBox = new AxisAlignedBB(player.getPosition(), player.getPosition()).grow(25);

                    List<LivingEntity> foundTarget =
                            event.getEntity().world.getEntitiesWithinAABB(LivingEntity.class, targetBox, EventHandler::isValidTarget);

                    for (int i = 0; i < foundTarget.size(); i++) {
                        Vector3d vector3d = new Vector3d(foundTarget.get(i).getPosX() - player.getPosX(), foundTarget.get(i).getPosY() - player.getPosY(), foundTarget.get(i).getPosZ() - player.getPosZ());
                        foundTarget.get(i).move(MoverType.PLAYER, vector3d);
                        foundTarget.get(i).addPotionEffect(new EffectInstance(Effects.POISON, 200, 1));
                    }


                }
            }
            SyncToClient.send(player);
        }
    }

    /*-----REMOVE ITEM FROM INV-----*/
    @SubscribeEvent
    public void RemoveItemFromInv(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            PlayerEntity player = event.player;
            /*--SOUL HEART--*/
            ItemStack itemstack0 = ModItems.SOUL_HEART.get().getDefaultInstance();
            if (CapabilityModel.getSoulHeartPickupAmount() > 0) {
                for (int i = 0; CapabilityModel.getSoulHeartPickupAmount() >= i; i++) {
                    int j = player.inventory.findSlotMatchingUnusedItem(itemstack0);
                    if (j >= 0) {
                        player.inventory.decrStackSize(j, 1);
                        CapabilityModel.setSoulHeartPickupAmount(CapabilityModel.getSoulHeartPickupAmount() - 1);
                    }
                }
            }


            /*--RED HEART--*/
            ItemStack itemstack1 = ModItems.RED_HEART.get().getDefaultInstance();
            if (CapabilityModel.getRedHeartPickupAmount() > 0) {
                for (int i = 0; CapabilityModel.getRedHeartPickupAmount() >= i; i++) {
                    int x = player.inventory.findSlotMatchingUnusedItem(itemstack1);
                    if (x >= 0) {
                        player.inventory.decrStackSize(x, 1);
                        CapabilityModel.setRedHeartPickupAmount(CapabilityModel.getRedHeartPickupAmount() - 1);
                    }
                }
            }


            /*--SOUL HEART--*/
            ItemStack itemstack2 = ModItems.BLACK_HEART.get().getDefaultInstance();
            if (CapabilityModel.getBlackHeartPickupAmount() > 0) {
                for (int i = 0; CapabilityModel.getBlackHeartPickupAmount() >= i; i++) {
                    int j = player.inventory.findSlotMatchingUnusedItem(itemstack2);
                    if (j >= 0) {
                        player.inventory.decrStackSize(j, 1);
                        CapabilityModel.setBlackHeartPickupAmount(CapabilityModel.getBlackHeartPickupAmount() - 1);
                    }
                }
            }
        }
    }

    /*-----------A MISSING PAGE-------*/
    @SubscribeEvent
    public void AMissingPage(LivingDamageEvent event) {
        DamageSource source = event.getSource();
        Entity src = source.getTrueSource();
        Random random = new Random();
        if (event.getEntity() instanceof PlayerEntity) {

            PlayerEntity player = (PlayerEntity) event.getEntity();
            ItemStack stack =
                    CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.A_MISSING_PAGE.get(), player).map(
                            ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

            if (!stack.isEmpty() && random.nextInt(100) <= (5 + player.getLuck())) {

                AxisAlignedBB targetBox = new AxisAlignedBB(player.getPosition(), player.getPosition()).grow(25);

                List<LivingEntity> foundTarget =
                        event.getEntity().world.getEntitiesWithinAABB(LivingEntity.class, targetBox, EventHandler::isValidTarget);

                if (src != null && !(src instanceof PlayerEntity) && !foundTarget.isEmpty()) {

                    for (int i = 0; i < foundTarget.size(); i++) {
                        foundTarget.get(i).attackEntityFrom(DamageSource.GENERIC, 4);
                    }
                }
            }
        }
    }
    //VOY POR AQUI TERMINAR ESTO
    /*------------AAA BATTERY---------*/
    @SubscribeEvent
    public void AAABattery(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            PlayerEntity player = event.player;
            int level = event.player.experienceLevel;
            float levelMultiplier = 0.03F;
            ItemStack stack =
                    CuriosApi.getCuriosHelper().findEquippedCurio(ModItems.AAA_BATTERY.get(), event.player).map(
                            ImmutableTriple::getRight).orElse(ItemStack.EMPTY);

            if (!stack.isEmpty()) {
                if (CapabilityModel.getLevelPlayerAmount() > level) {
                    CapabilityModel.setLevelPlayerAmount(level);
                    SyncToClient.send(player);
                } else if (CapabilityModel.getLevelPlayerAmount() < level) {
                    if (level <= 15) {
                        event.player.giveExperiencePoints((int) ((17 * level) * levelMultiplier));
                        CapabilityModel.setLevelPlayerAmount(level);
                        SyncToClient.send(player);
                    } else if (level >= 16 && level <= 30) {
                        int exp = (int) Math.pow(level, 2);
                        event.player.giveExperiencePoints((int) (((1.5 * exp) - (29.5 * level) + 360) * levelMultiplier));
                        CapabilityModel.setLevelPlayerAmount(level);
                        SyncToClient.send(player);
                    } else if (level >= 31) {
                        int exp = (int) Math.pow(level, 2);
                        event.player.giveExperiencePoints((int) (((3.5 * exp) - (151.5 * level) + 2220) * levelMultiplier));
                        CapabilityModel.setLevelPlayerAmount(level);
                        SyncToClient.send(player);
                    }

                }
            }
        }
    }

    /*-------THE_EMPRESS_CARD------*/
    @SubscribeEvent
    public void theEmpressCard(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            PlayerEntity player = event.player;

            if (player != null && player instanceof PlayerEntity) {
                tickHandler = player.ticksExisted;

                ModifiableAttributeInstance atinst = player.getAttribute(Attributes.ATTACK_DAMAGE);
                AttributeModifier mod = new AttributeModifier(moreDamage, "MoreDamage", 1.5F, AttributeModifier.Operation.ADDITION);
                ModifiableAttributeInstance atinst1 = player.getAttribute(Attributes.MOVEMENT_SPEED);
                AttributeModifier mod1 = new AttributeModifier(moreSpeed, "MoreSpeed", 0.3F, AttributeModifier.Operation.ADDITION);

                if (CapabilityModel.getEmpressCarActivate()) {
                    if (atinst.getModifier(moreDamage) == null && atinst1.getModifier(moreSpeed) == null) {
                        atinst.applyNonPersistentModifier(mod);
                        atinst1.applyNonPersistentModifier(mod1);
                        oldTickHandler = tickHandler;
                        CapabilityModel.setEmpressCarActivate(false);
                        SyncToClient.send(player);
                    }
                } else if ((tickHandler - oldTickHandler) > 200 && atinst.getModifier(moreDamage) != null && atinst1.getModifier(moreSpeed) != null) {
                    atinst.removeModifier(mod);
                    atinst1.removeModifier(mod1);
                    oldTickHandler = 0;
                }
            }

        }
    }

    /*------STRENGTH_CARD-----*/
    @SubscribeEvent
    public void StrengthCard(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            PlayerEntity player = event.player;

            if (player != null && player instanceof PlayerEntity) {
                strengthTickHandler = player.ticksExisted;

                ModifiableAttributeInstance atinst = player.getAttribute(Attributes.MAX_HEALTH);
                AttributeModifier mod = new AttributeModifier(strengthHP, "strengthHP", 2.0F, AttributeModifier.Operation.ADDITION);
                ModifiableAttributeInstance atinst1 = player.getAttribute(Attributes.ATTACK_DAMAGE);
                AttributeModifier mod1 = new AttributeModifier(strengthDamage, "strengthDamage", 0.3F, AttributeModifier.Operation.ADDITION);
                ModifiableAttributeInstance atinst2 = player.getAttribute(Attributes.ATTACK_DAMAGE);
                AttributeModifier mod2 = new AttributeModifier(strengthDamageMultiplier, "strengthDamageMultiplier", 1.5F, AttributeModifier.Operation.MULTIPLY_TOTAL);
                ModifiableAttributeInstance atinst3 = player.getAttribute(Attributes.MOVEMENT_SPEED);
                AttributeModifier mod3 = new AttributeModifier(strengthSpeed, "strengthSpeed", 0.3, AttributeModifier.Operation.ADDITION);

                if (CapabilityModel.getStrengthCarActivate()) {
                    if (atinst.getModifier(strengthHP) == null && atinst1.getModifier(strengthDamage) == null && atinst2.getModifier(strengthDamageMultiplier) == null && atinst3.getModifier(strengthSpeed) == null) {
                        atinst.applyNonPersistentModifier(mod);
                        atinst1.applyNonPersistentModifier(mod1);
                        atinst2.applyNonPersistentModifier(mod2);
                        atinst3.applyNonPersistentModifier(mod3);
                        strengthOldTickHandler = strengthTickHandler;
                        CapabilityModel.setStrengthCarActivate(false);
                        SyncToClient.send(player);
                    }
                } else if ((strengthTickHandler - strengthOldTickHandler) > 200 && atinst.getModifier(strengthHP) != null && atinst1.getModifier(strengthDamage) != null && atinst2.getModifier(strengthDamageMultiplier) != null && atinst3.getModifier(strengthSpeed) != null) {
                    atinst.removeModifier(mod);
                    atinst1.removeModifier(mod1);
                    atinst.removeModifier(mod2);
                    atinst1.removeModifier(mod3);
                    strengthOldTickHandler = 0;
                }
            }
        }
    }

    /*--------CHARIOT_CARD------*/
    @SubscribeEvent
    public void ChariotCard(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            PlayerEntity player = event.player;
            chariotTickHandler = player.ticksExisted;

            if (player != null && player instanceof PlayerEntity) {
                ModifiableAttributeInstance atinst1 = player.getAttribute(Attributes.MOVEMENT_SPEED);
                AttributeModifier mod1 = new AttributeModifier(chariotSpeed, "ChariotSpeed", 0.28F, AttributeModifier.Operation.ADDITION);

                if (CapabilityModel.getChariotCarActivate()) {
                    if (atinst1.getModifier(chariotSpeed) == null) {
                        atinst1.applyNonPersistentModifier(mod1);
                        chariotOldTickHandler = chariotTickHandler;
                        CapabilityModel.setChariotCarActivate(false);
                        SyncToClient.send(player);
                    }

                } else if ((chariotTickHandler - chariotOldTickHandler) > 200 && atinst1.getModifier(chariotSpeed) != null) {
                    atinst1.removeModifier(mod1);
                    chariotOldTickHandler = 0;
                    CapabilityModel.setChariotCarActivate0(false);
                    SyncToClient.send(player);
                }
            }

            if (event.player instanceof PlayerEntity) {

                if (CapabilityModel.getChariotCarActivate0()) {

                    AxisAlignedBB targetBox = new AxisAlignedBB(player.getPosition(), player.getPosition()).grow(0.75F);

                    List<LivingEntity> foundTarget =
                            event.player.world.getEntitiesWithinAABB(LivingEntity.class, targetBox, EventHandler::isValidTarget1);

                    if (!foundTarget.isEmpty()) {

                        for (int i = 0; i < foundTarget.size(); i++) {
                            foundTarget.get(i).attackEntityFrom(DamageSource.GENERIC, 4);
                        }
                    }
                }
            }
        }
    }

    /*--------CHARIOT_CARD------*/
    @SubscribeEvent
    public void ChariotCard0(LivingHurtEvent event) {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
            if (event.getEntityLiving() == player) {
                if (CapabilityModel.getChariotCarActivate0()) {
                    event.setAmount(0);
                }
            }
            SyncToClient.send(player);
        }
    }

    /*--------CHARIOT_CARD------*/
    @SubscribeEvent
    public void ChariotCard1(AttackEntityEvent event) {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
            if (event.getEntityLiving() == player) {
                if (CapabilityModel.getChariotCarActivate0()) {
                    event.setCanceled(true);
                }
            }
        }
    }

    /*------HANGED_MAN_CARD------*/
    @SubscribeEvent
    public void HangedManCard(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            PlayerEntity player = event.player;

            if (player != null && player instanceof PlayerEntity) {
                hangedManTickHandler = player.ticksExisted;
                if (CapabilityModel.getHangedManCarActivate()) {
                    hangedManOldTickHandler = hangedManTickHandler;
                    player.abilities.allowFlying = true;
                    player.abilities.isFlying = true;
                    CapabilityModel.setHangedManCarActivate(false);
                    SyncToClient.send(player);
                } else if ((hangedManTickHandler - hangedManOldTickHandler) > 200 && !player.abilities.isCreativeMode) {
                    player.abilities.allowFlying = false;
                    player.abilities.isFlying = false;

                    hangedManOldTickHandler = 0;
                }
            }
        }
    }

    /*------ETERNAL_HEART_HANDLER------*/
    @SubscribeEvent
    public void EternalHearth(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            PlayerEntity player = event.player;
            float level = CapabilityModel.getEternalHeartAmount();

            ModifiableAttributeInstance atinst = player.getAttribute(Attributes.MAX_HEALTH);
            AttributeModifier mod = new AttributeModifier(eternalHP, "eternalHP", CapabilityModel.getEternalHeartAmount(), AttributeModifier.Operation.ADDITION);

            /*
            if(CapabilityModel.getEternalHeartAmount() != 0 && CapabilityModel.getEternalHeartAmountAmount() != 0){
                CapabilityModel.setEternalHeartAmount(CapabilityModel.getEternalHeartAmount() - 668);
                CapabilityModel.setEternalHeartAmountAmount(CapabilityModel.getEternalHeartAmountAmount() - 361);
            }
            */

            if (player != null && player instanceof PlayerEntity) {
                if (atinst.getValue() < (atinst.getBaseValue() + (level * 2.66F))) {
                    if (atinst.getModifier(eternalHP) == null) {
                        atinst.applyPersistentModifier(mod);
                        oldlevel = level;

                    } else if (oldlevel != level) {
                        atinst.removeModifier(mod);
                    }
                } else if (oldlevel > level) {
                    atinst.removeModifier(mod);

                }
            }
        }
    }

    /*-----THE_DEVIL_CARD-----*/
    @SubscribeEvent
    public void theDevilCard(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            PlayerEntity player = event.player;

            if (player != null && player instanceof PlayerEntity) {
                devilTickHandler = player.ticksExisted;

                ModifiableAttributeInstance atinst = player.getAttribute(Attributes.ATTACK_DAMAGE);
                AttributeModifier mod = new AttributeModifier(devilDamage, "devilDamage", 2, AttributeModifier.Operation.ADDITION);

                if (CapabilityModel.getDevilCarActivate()) {
                    if (atinst.getModifier(devilDamage) == null) {
                        atinst.applyNonPersistentModifier(mod);
                        devilOldTickHandler = devilTickHandler;
                        CapabilityModel.setDevilCarActivate(false);
                        SyncToClient.send(player);
                    }
                } else if ((devilTickHandler - devilOldTickHandler) > 200 && atinst.getModifier(devilDamage) != null) {
                    atinst.removeModifier(mod);
                    devilOldTickHandler = 0;
                }
            }
        }
    }
}
