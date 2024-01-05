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

package com.cozary.tboit.capability;

import com.cozary.tboit.capability.capabilities.CapabilityModel;
import com.cozary.tboit.capability.capabilities.CapabilityProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.stats.Stats;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SpecialHeartHandler {

    @SubscribeEvent
    public void SpecialHeartHandler(LivingDamageEvent event) {
        DamageSource source = event.getSource();
        if (event.getEntity() instanceof PlayerEntity) {
            float damageAmount = event.getAmount();
            PlayerEntity player = (PlayerEntity) event.getEntity();
            if (damageAmount <= 0) return;
            if (CapabilityModel.getBlackHealthAmount() > 0) {
                float f2 = Math.max(damageAmount - CapabilityModel.getBlackHealthAmount(), 0.0F);
                CapabilityModel.setBlackHealthAmount(CapabilityModel.getBlackHealthAmount() - (damageAmount - f2));
                float f = damageAmount - f2;
                if (f > 0.0F && f < 3.4028235E37F && source.getTrueSource() instanceof ServerPlayerEntity) {
                    ((ServerPlayerEntity) source.getTrueSource()).addStat(Stats.DAMAGE_DEALT_ABSORBED, Math.round(f * 10.0F));
                }
                if (f2 == 0.0F) {
                    event.setAmount(0);
                }
            } else {
                float f2 = Math.max(damageAmount - CapabilityModel.getSoulHealthAmount(), 0.0F);
                CapabilityModel.setSoulHealthAmount(CapabilityModel.getSoulHealthAmount() - (damageAmount - f2));
                float f = damageAmount - f2;
                if (f > 0.0F && f < 3.4028235E37F && source.getTrueSource() instanceof ServerPlayerEntity) {
                    ((ServerPlayerEntity) source.getTrueSource()).addStat(Stats.DAMAGE_DEALT_ABSORBED, Math.round(f * 10.0F));
                }
                if (f2 == 0.0F) {
                    event.setAmount(0);
                }
            }
            SyncToClient.send(player);

        }
    }

    @SubscribeEvent
    public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity) {
            CapabilityModel skillModel = new CapabilityModel();

            CapabilityProvider provider = new CapabilityProvider(skillModel);

            event.addCapability(new ResourceLocation("tboit", "cap_health"), provider);

            event.addListener(provider::invalidate);
        }
    }

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent e) {
        SyncToClient.send(e.getPlayer());

    }

    @SubscribeEvent
    public void onChangeDimension(PlayerEvent.PlayerChangedDimensionEvent e) {
        SyncToClient.send(e.getPlayer());

    }
}
