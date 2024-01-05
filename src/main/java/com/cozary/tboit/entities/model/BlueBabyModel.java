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

import com.cozary.tboit.entities.BlueBabyEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class BlueBabyModel<T extends BlueBabyEntity> extends AgeableModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer head;

    public BlueBabyModel() {
        textureWidth = 32;
        textureHeight = 32;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 24.0F, 0.0F);
        head.setTextureOffset(0, 10).addBox(-1.0F, -8.0F, -2.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.setTextureOffset(9, 10).addBox(-2.0F, -8.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(0, 3).addBox(0.0F, -5.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(0, 0).addBox(2.0F, -8.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(0, 0).addBox(-2.0F, -13.0F, -3.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    protected Iterable<ModelRenderer> getHeadParts() {
        return ImmutableList.of(this.head);
    }

    @Override
    protected Iterable<ModelRenderer> getBodyParts() {
        return ImmutableList.of(this.body);
    }


}
