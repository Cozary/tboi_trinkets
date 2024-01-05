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

package com.cozary.tboit.entities.model;

import com.cozary.tboit.entities.DeadBirdEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class DeadBirdModel<T extends DeadBirdEntity> extends SegmentedModel<T> {
    private final ModelRenderer bone;
    private final ModelRenderer cube_r1;

    public DeadBirdModel() {
        textureWidth = 16;
        textureHeight = 16;

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 24.0F, 0.0F);
        bone.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.setTextureOffset(0, 0).addBox(-3.0F, -5.0F, -3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        bone.setTextureOffset(0, 0).addBox(-2.5F, -4.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.3927F, 0.0F, 0.0F);
        cube_r1.setTextureOffset(0, 0).addBox(-5.0F, -3.0F, -2.0F, 2.0F, 0.0F, 3.0F, 0.0F, false);
        cube_r1.setTextureOffset(0, 0).addBox(-1.0F, -3.0F, -2.0F, 2.0F, 0.0F, 3.0F, 0.0F, false);
        cube_r1.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -2.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(this.bone);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
