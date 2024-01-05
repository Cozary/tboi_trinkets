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

import com.cozary.tboit.entities.SlotMachineEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class SlotMachineModel<T extends SlotMachineEntity> extends AgeableModel<T> {
    private final ModelRenderer bone;
    private final ModelRenderer bone0;


    public SlotMachineModel() {
        textureWidth = 256;
        textureHeight = 256;

        bone0 = new ModelRenderer(this);
        bone0.setRotationPoint(0.0F, 24.0F, 0.0F);
        bone0.setTextureOffset(0, 50).addBox(-8.0F, -32.0F, 8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 24.0F, 0.0F);
        bone.setTextureOffset(48, 18).addBox(-6.0F, -43.0F, -1.0F, 12.0F, 11.0F, 4.0F, 0.0F, false);
        bone.setTextureOffset(40, 98).addBox(-20.0F, -16.0F, -8.0F, 12.0F, 16.0F, 16.0F, 0.0F, false);
        bone.setTextureOffset(88, 82).addBox(-20.0F, -16.0F, 8.0F, 12.0F, 16.0F, 16.0F, 0.0F, false);
        bone.setTextureOffset(48, 66).addBox(-20.0F, -32.0F, 8.0F, 12.0F, 16.0F, 16.0F, 0.0F, false);
        bone.setTextureOffset(48, 34).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        bone.setTextureOffset(0, 18).addBox(-8.0F, -16.0F, 8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);
        bone.setTextureOffset(96, 50).addBox(8.0F, -16.0F, -8.0F, 12.0F, 16.0F, 16.0F, 0.0F, false);
        bone.setTextureOffset(92, 2).addBox(8.0F, -16.0F, 8.0F, 12.0F, 16.0F, 16.0F, 0.0F, false);
        bone.setTextureOffset(0, 82).addBox(8.0F, -32.0F, 8.0F, 12.0F, 16.0F, 16.0F, 0.0F, false);
        bone.setTextureOffset(0, 50).addBox(18.0F, -28.0F, 5.0F, 2.0F, 12.0F, 3.0F, 0.0F, false);
        bone.setTextureOffset(0, 18).addBox(-20.0F, -28.0F, 5.0F, 2.0F, 12.0F, 3.0F, 0.0F, false);
        bone.setTextureOffset(0, 0).addBox(-20.0F, -32.0F, -6.0F, 40.0F, 4.0F, 14.0F, 0.0F, false);
        bone.setTextureOffset(96, 34).addBox(-6.0F, -1.0F, -10.0F, 12.0F, 1.0F, 2.0F, 0.0F, false);
        bone.setTextureOffset(0, 0).addBox(20.0F, -12.0F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
        bone.setTextureOffset(6, 0).addBox(21.0F, -11.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        bone.setTextureOffset(80, 18).addBox(23.0F, -22.0F, -1.0F, 2.0F, 13.0F, 2.0F, 0.0F, false);
        bone.setTextureOffset(0, 82).addBox(22.0F, -26.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    protected Iterable<ModelRenderer> getHeadParts() {
        return ImmutableList.of(this.bone);
    }

    @Override
    protected Iterable<ModelRenderer> getBodyParts() {
        return ImmutableList.of(this.bone0);
    }


}
