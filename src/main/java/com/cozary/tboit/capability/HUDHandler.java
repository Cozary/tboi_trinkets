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
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber({Dist.CLIENT})
public final class HUDHandler {

    static Random rand = new Random();

    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGameOverlayEvent.Post event) {

        Minecraft minecraft = Minecraft.getInstance();
        MainWindow resolution = event.getWindow();
        int width = resolution.getScaledWidth();
        int height = resolution.getScaledHeight();
        if (!minecraft.player.isCreative() && !minecraft.player.isSpectator()) {
            if (event.getType() == ElementType.HEALTH) {
                RenderSystem.enableBlend();

                float soulHealthLevel = CapabilityModel.getSoulHealthAmount();
                float blackHealthLevel = CapabilityModel.getBlackHealthAmount();

                if (minecraft.playerController.gameIsSurvivalOrAdventure()) {

                    minecraft.getTextureManager().bindTexture(new ResourceLocation(TboiTrinkets.MOD_ID, "textures/gui/soul_health.png"));
                    drawSoulHealth(width, height, soulHealthLevel);
                    minecraft.getTextureManager().bindTexture(new ResourceLocation(TboiTrinkets.MOD_ID, "textures/gui/black_health.png"));
                    drawBlackHealth(width, height, blackHealthLevel);
                    minecraft.getTextureManager().bindTexture(AbstractGui.GUI_ICONS_LOCATION);
                }

            }
        }
    }

    private static void drawSoulHealth(int width, int height, float soulHeartLevel) {
        PlayerEntity player = (PlayerEntity) Minecraft.getInstance().getRenderViewEntity();
        Minecraft minecraft = Minecraft.getInstance();
        MatrixStack matrixStack = new MatrixStack();

        ModifiableAttributeInstance attrMaxHealth = player.getAttribute(Attributes.MAX_HEALTH);
        float healthMax = (float) attrMaxHealth.getValue();
        float absorbHeart = player.getAbsorptionAmount();
        float soulHeart = MathHelper.ceil(soulHeartLevel);
        int healthRows = MathHelper.ceil((healthMax + soulHeart) / 2.0F / 10.0F);
        int rowHeight = Math.max(10 - (healthRows - 2), 3);
        int left_height = ForgeIngameGui.right_height;
        int left = width / 2 - 91;
        int top = height - left_height;
        left_height += (healthRows * rowHeight);
        if (rowHeight != 10) left_height += 10 - rowHeight;
        float absorbRemaining = soulHeart;

        for (int i = MathHelper.ceil((healthMax + absorbHeart + soulHeart) / 2.0F) - 1; i >= 0; --i) {

            int row = MathHelper.ceil((float) (i + 1) / 10.0F) - 1;
            int x = left + i % 10 * 8;
            int y = top - row * rowHeight;


            if (absorbRemaining > 0.0F) {

                if (absorbRemaining == soulHeart && soulHeart % 2.0F == 1.0F) {

                    AbstractGui.blit(matrixStack, x, y, 9, 9, 9, 9, 18, 9); //17
                    absorbRemaining -= 1.0F;
                } else {

                    AbstractGui.blit(matrixStack, x, y, 0, 9, 9, 9, 18, 9); //16
                    absorbRemaining -= 2.0F;
                }
            }
        }
    }

    private static void drawBlackHealth(int width, int height, float blackHeartLevel) {
        PlayerEntity player = (PlayerEntity) Minecraft.getInstance().getRenderViewEntity();
        Minecraft minecraft = Minecraft.getInstance();
        MatrixStack matrixStack = new MatrixStack();

        ModifiableAttributeInstance attrMaxHealth = player.getAttribute(Attributes.MAX_HEALTH);
        float healthMax = (float) attrMaxHealth.getValue();
        float absorbHeart = player.getAbsorptionAmount();
        float soulHeart = CapabilityModel.getSoulHealthAmount();
        float blackHeart = MathHelper.ceil(blackHeartLevel);
        int healthRows = MathHelper.ceil((healthMax + blackHeart) / 2.0F / 10.0F);
        int rowHeight = Math.max(10 - (healthRows - 2), 3);
        int left_height = ForgeIngameGui.right_height;
        int left = width / 2 - 91;
        int top = height - left_height;
        left_height += (healthRows * rowHeight);
        if (rowHeight != 10) left_height += 10 - rowHeight;
        float absorbRemaining = blackHeart;

        for (int i = MathHelper.ceil((healthMax + absorbHeart + soulHeart + blackHeart) / 2.0F) - 1; i >= 0; --i) {

            int row = MathHelper.ceil((float) (i + 1) / 10.0F) - 1;
            int x = left + i % 10 * 8;
            int y = top - row * rowHeight;


            if (absorbRemaining > 0.0F) {

                if (absorbRemaining == blackHeart && blackHeart % 2.0F == 1.0F) {

                    AbstractGui.blit(matrixStack, x, y, 9, 9, 9, 9, 18, 9); //17
                    absorbRemaining -= 1.0F;
                } else {

                    AbstractGui.blit(matrixStack, x, y, 0, 9, 9, 9, 18, 9); //16
                    absorbRemaining -= 2.0F;
                }
            }
        }
    }

}
