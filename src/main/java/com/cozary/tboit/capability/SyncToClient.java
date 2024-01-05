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

import com.cozary.tboit.TboiTrinkets;
import com.cozary.tboit.capability.capabilities.CapabilityModel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.PacketDistributor;

import java.util.function.Supplier;

public class SyncToClient {

    private final CompoundNBT skillModel;

    public SyncToClient(CompoundNBT skillModel) {
        this.skillModel = skillModel;
    }

    public SyncToClient(PacketBuffer buffer) {
        skillModel = buffer.readCompoundTag();
    }

    public static void send(PlayerEntity player) {
        TboiTrinkets.NETWORK.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) player), new SyncToClient(CapabilityModel.get(player).serializeNBT()));
    }

    public void encode(PacketBuffer buffer) {
        buffer.writeCompoundTag(skillModel);
    }

    // Send Packet

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> CapabilityModel.get().deserializeNBT(skillModel));
        context.get().setPacketHandled(true);
    }
}