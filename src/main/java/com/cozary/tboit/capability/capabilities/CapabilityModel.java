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

package com.cozary.tboit.capability.capabilities;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public class CapabilityModel implements INBTSerializable<CompoundNBT> {

    public static boolean cartridge = false;
    public static boolean isRevived = false;
    public static float soulHeartAmount = 0;
    public static float blackHeartAmount = 0;
    public static int blackHeartPickup = 0;
    public static float levelPlayerAmount = 0;
    public static boolean magicianCardActivate = false;
    public static boolean empressCardActivate = false;
    public static int soulHeartPickup = 0;
    public static int redHeartPickup = 0;
    public static boolean chariotCardActivate = false;
    public static boolean chariotCardActivate0 = false;
    public static boolean strengthCardActivate = false;
    public static boolean hangedManCardActivate = false;
    public static float eternalHeartAmount = 0;
    public static float eternalHeartAmountAmount = 0;
    public static boolean devilCardActivate = false;

    public static boolean getCartridge() {
        return cartridge;
    }

    public static void setCartridge(boolean amount) {
        cartridge = amount;
    }

    public static boolean getisRevived() {
        return isRevived;
    }

    public static void setisRevived(boolean amount) {
        isRevived = amount;
    }


    public static float getBlackHealthAmount() {
        return blackHeartAmount;
    }

    public static void setBlackHealthAmount(float amount) {
        if (amount < 0.0F) {
            amount = 0.0F;
        }
        blackHeartAmount = amount;
    }

    public static int getBlackHeartPickupAmount() {
        return blackHeartPickup;
    }

    public static void setBlackHeartPickupAmount(int amount) {
        if (amount < 0) {
            amount = 0;
        }
        blackHeartPickup = amount;
    }

    public static boolean getDevilCarActivate() {
        return devilCardActivate;
    }

    public static void setDevilCarActivate(boolean amount) {
        devilCardActivate = amount;
    }


    public static float getEternalHeartAmountAmount() {
        return eternalHeartAmountAmount;
    }

    public static void setEternalHeartAmountAmount(float amount) {
        if (amount < 0.0F) {
            amount = 0.0F;
        }
        eternalHeartAmountAmount = amount;
    }

    public static float getEternalHeartAmount() {
        return eternalHeartAmount;
    }

    public static void setEternalHeartAmount(float amount) {
        if (amount < 0.0F) {
            amount = 0.0F;
        }
        eternalHeartAmount = amount;
    }

    public static boolean getHangedManCarActivate() {
        return hangedManCardActivate;
    }

    public static void setHangedManCarActivate(boolean amount) {
        hangedManCardActivate = amount;
    }

    public static boolean getStrengthCarActivate() {
        return strengthCardActivate;
    }

    public static void setStrengthCarActivate(boolean amount) {
        strengthCardActivate = amount;
    }

    public static boolean getChariotCarActivate() {
        return chariotCardActivate;
    }

    public static void setChariotCarActivate(boolean amount) {
        chariotCardActivate = amount;
    }

    public static boolean getChariotCarActivate0() {
        return chariotCardActivate0;
    }

    public static void setChariotCarActivate0(boolean amount) {
        chariotCardActivate0 = amount;
    }

    public static int getRedHeartPickupAmount() {
        return redHeartPickup;
    }

    public static void setRedHeartPickupAmount(int amount) {
        if (amount < 0) {
            amount = 0;
        }
        redHeartPickup = amount;
    }

    public static int getSoulHeartPickupAmount() {
        return soulHeartPickup;
    }

    public static void setSoulHeartPickupAmount(int amount) {
        if (amount < 0) {
            amount = 0;
        }
        soulHeartPickup = amount;
    }

    public static float getSoulHealthAmount() {
        return soulHeartAmount;
    }

    public static void setSoulHealthAmount(float amount) {
        if (amount < 0.0F) {
            amount = 0.0F;
        }
        soulHeartAmount = amount;
    }

    public static float getLevelPlayerAmount() {
        return levelPlayerAmount;
    }

    public static void setLevelPlayerAmount(float amount) {
        if (amount < 0.0F) {
            amount = 0.0F;
        }
        levelPlayerAmount = amount;
    }

    public static boolean getMagicianCarActivate() {
        return magicianCardActivate;
    }

    public static void setMagicianCarActivate(boolean bool) {
        magicianCardActivate = bool;
    }

    public static boolean getEmpressCarActivate() {
        return empressCardActivate;
    }

    public static void setEmpressCarActivate(boolean bool) {
        empressCardActivate = bool;
    }


    public static CapabilityModel get(PlayerEntity player) {
        return player.getCapability(Capability.INSTANCE).orElseThrow(() ->
                new IllegalArgumentException("Player " + player.getName().getString() + " does not have a Health Model!")
        );
    }

    public static CapabilityModel get() {
        return Minecraft.getInstance().player.getCapability(Capability.INSTANCE).orElseThrow(() ->
                new IllegalArgumentException("Player does not have a Health Model!")
        );
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compound = new CompoundNBT();
        compound.putFloat("soulHealthAmount", soulHeartAmount);
        compound.putFloat("levelPlayerAmount", levelPlayerAmount);
        compound.putBoolean("empressCardActivate", empressCardActivate);
        compound.putInt("redHeartPickup", redHeartPickup);
        compound.putInt("soulHeartPickup", soulHeartPickup);
        compound.putInt("blackHeartPickup", blackHeartPickup);
        compound.putBoolean("chariotCardActivate", chariotCardActivate);
        compound.putBoolean("chariotCardActivate0", chariotCardActivate0);
        compound.putBoolean("strengthCardActivate", strengthCardActivate);
        compound.putBoolean("hangedManCardActivate", hangedManCardActivate);
        compound.putFloat("eternalHeartAmount", eternalHeartAmount);
        compound.putFloat("eternalHeartAmountAmount", eternalHeartAmountAmount);
        compound.putBoolean("devilCardActivate", devilCardActivate);
        compound.putFloat("blackHeartAmount", blackHeartAmount);
        compound.putBoolean("isRevived", isRevived);
        compound.putBoolean("cartridge", cartridge);

        return compound;

    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        soulHeartAmount = nbt.getFloat("soulHealthAmount");
        levelPlayerAmount = nbt.getFloat("levelPlayerAmount");
        empressCardActivate = nbt.getBoolean("empressCardActivate");
        redHeartPickup = nbt.getInt("redHeartPickup");
        soulHeartPickup = nbt.getInt("soulHeartPickup");
        blackHeartPickup = nbt.getInt("blackHeartPickup");
        chariotCardActivate = nbt.getBoolean("chariotCardActivate");
        chariotCardActivate0 = nbt.getBoolean("chariotCardActivate0");
        strengthCardActivate = nbt.getBoolean("strengthCardActivate");
        hangedManCardActivate = nbt.getBoolean("hangedManCardActivate");
        eternalHeartAmount = nbt.getFloat("eternalHeartAmount");
        eternalHeartAmountAmount = nbt.getFloat("eternalHeartAmountAmount");
        devilCardActivate = nbt.getBoolean("devilCardActivate");
        blackHeartAmount = nbt.getFloat("blackHeartAmount");
        isRevived = nbt.getBoolean("isRevived");
        cartridge = nbt.getBoolean("cartridge");

    }
}