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

package com.cozary.tboit.entities.render;


import com.cozary.tboit.TboiTrinkets;
import com.cozary.tboit.entities.SlotMachineEntity;
import com.cozary.tboit.entities.model.SlotMachineModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class SlotMachineRenderer extends MobRenderer<SlotMachineEntity, SlotMachineModel<SlotMachineEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(TboiTrinkets.MOD_ID, "textures/entity/slot_machine.png");

    public SlotMachineRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SlotMachineModel<>(), 0.5F);
    }

    @Override
    protected void applyRotations(SlotMachineEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F - rotationYaw));
        float f = (float) (entityLiving.world.getGameTime() - (entityLiving.world.getGameTime() - 200)) + partialTicks;
        if (f < 5.0F) {
            matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.sin(f / 1.5F * (float) Math.PI) * 3.0F));
        }
    }

    @Override
    public ResourceLocation getEntityTexture(SlotMachineEntity entity) {
        return TEXTURE;
    }

}
