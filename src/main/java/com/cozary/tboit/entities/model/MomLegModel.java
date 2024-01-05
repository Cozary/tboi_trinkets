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

import com.cozary.tboit.entities.MomLegEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class MomLegModel<T extends MomLegEntity> extends SegmentedModel<T> {
    private final ModelRenderer bb_main;
    private final ModelRenderer cube_r1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;
    private final ModelRenderer cube_r10;
    private final ModelRenderer cube_r11;
    private final ModelRenderer cube_r12;
    private final ModelRenderer cube_r13;
    private final ModelRenderer cube_r14;
    private final ModelRenderer cube_r15;
    private final ModelRenderer cube_r16;
    private final ModelRenderer cube_r17;
    private final ModelRenderer cube_r18;
    private final ModelRenderer cube_r19;
    private final ModelRenderer cube_r20;

    public MomLegModel() {
        textureWidth = 128;
        textureHeight = 128;

        bb_main = new ModelRenderer(this);
        bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
        bb_main.setTextureOffset(1, 60).addBox(-4.0F, -5.0F, -17.375F, 8.0F, 5.0F, 5.0F, 0.0F, false);
        bb_main.setTextureOffset(28, 0).addBox(-4.7811F, -49.2674F, 3.3885F, 9.0F, 33.0F, 10.0F, 0.0F, true);
        bb_main.setTextureOffset(88, 27).addBox(-6.2811F, -63.2674F, 6.3885F, 5.0F, 15.0F, 6.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(0.0F, -25.1736F, 3.5785F);
        bb_main.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.4265F, -0.0403F, 0.4784F);
        cube_r1.setTextureOffset(31, 35).addBox(-8.0F, -23.0156F, 6.0F, 13.0F, 1.0F, 13.0F, 0.0F, false);
        cube_r1.setTextureOffset(0, 0).addBox(-8.0F, -22.0F, 6.0F, 13.0F, 13.0F, 13.0F, 0.0F, false);
        cube_r1.setTextureOffset(0, 0).addBox(3.0F, -1.0F, -7.5F, 8.0F, 8.0F, 13.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(-5.1257F, -42.739F, 6.3952F);
        bb_main.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.2145F, -0.2475F, -0.1279F);
        cube_r2.setTextureOffset(0, 35).addBox(-9.0F, -9.9805F, -12.5F, 22.0F, 1.0F, 22.0F, 0.0F, false);
        cube_r2.setTextureOffset(0, 0).addBox(-9.0F, -9.0F, -12.5F, 22.0F, 13.0F, 22.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(7.5F, -5.0F, -3.0F);
        bb_main.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.6545F, 0.0F, 0.0F);
        cube_r3.setTextureOffset(0, 61).addBox(-12.5165F, 0.0F, -3.0F, 10.0F, 2.0F, 21.0F, 0.0F, false);
        cube_r3.setTextureOffset(0, 0).addBox(-14.5F, -9.5F, -4.0F, 14.0F, 5.0F, 20.0F, 0.0F, false);
        cube_r3.setTextureOffset(0, 59).addBox(-17.25F, -5.0F, -3.0F, 6.0F, 5.0F, 16.0F, 0.0F, false);
        cube_r3.setTextureOffset(0, 59).addBox(-3.75F, -5.0F, -3.0F, 6.0F, 5.0F, 16.0F, 0.0F, true);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(0.0F, -20.3035F, -2.7683F);
        bb_main.addChild(cube_r4);
        setRotationAngle(cube_r4, 1.4846F, 0.0718F, -0.1814F);
        cube_r4.setTextureOffset(0, 0).addBox(-1.3288F, 6.5F, -3.5F, 8.0F, 10.0F, 13.0F, 0.0F, false);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(-5.1257F, -42.739F, 6.3952F);
        bb_main.addChild(cube_r5);
        setRotationAngle(cube_r5, -0.1748F, 0.1059F, -0.0197F);
        cube_r5.setTextureOffset(68, 0).addBox(-4.0F, -9.0F, 3.5F, 17.0F, 13.0F, 13.0F, 0.0F, false);

        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(1.3432F, -28.9502F, 17.1407F);
        bb_main.addChild(cube_r6);
        setRotationAngle(cube_r6, -0.2716F, 0.6961F, -0.6158F);
        cube_r6.setTextureOffset(0, 0).addBox(0.5F, -12.0F, -7.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);

        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(-16.496F, -32.4754F, 20.9926F);
        bb_main.addChild(cube_r7);
        setRotationAngle(cube_r7, 1.7484F, 0.7585F, -0.0083F);
        cube_r7.setTextureOffset(0, 0).addBox(10.5F, -5.0F, -7.5F, 10.0F, 10.0F, 17.0F, 0.0F, false);

        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(0.0F, -20.3035F, -2.7683F);
        bb_main.addChild(cube_r8);
        setRotationAngle(cube_r8, 1.4835F, 0.0F, 0.0F);
        cube_r8.setTextureOffset(0, 0).addBox(-8.3288F, -1.0F, 8.5F, 16.0F, 15.0F, 20.0F, 0.0F, false);
        cube_r8.setTextureOffset(0, 0).addBox(-4.8288F, -0.5F, -4.5F, 9.0F, 8.0F, 33.0F, 0.0F, false);

        cube_r9 = new ModelRenderer(this);
        cube_r9.setRotationPoint(-2.1264F, -32.0165F, -8.9874F);
        bb_main.addChild(cube_r9);
        setRotationAngle(cube_r9, -1.8023F, 0.7746F, 2.8437F);
        cube_r9.setTextureOffset(0, 0).addBox(-8.0F, -11.0F, -13.5F, 9.0F, 12.0F, 11.0F, 0.0F, false);

        cube_r10 = new ModelRenderer(this);
        cube_r10.setRotationPoint(-3.992F, -21.1174F, 3.9443F);
        bb_main.addChild(cube_r10);
        setRotationAngle(cube_r10, 1.7458F, 0.79F, 0.7374F);
        cube_r10.setTextureOffset(0, 0).addBox(-2.5F, -5.0F, 6.0F, 10.0F, 10.0F, 11.0F, 0.0F, false);
        cube_r10.setTextureOffset(0, 0).addBox(-8.0F, -5.0F, -5.5F, 10.0F, 10.0F, 11.0F, 0.0F, false);

        cube_r11 = new ModelRenderer(this);
        cube_r11.setRotationPoint(3.7189F, -58.2674F, 5.8885F);
        bb_main.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.0F, 0.0F, 0.0873F);
        cube_r11.setTextureOffset(88, 28).addBox(-3.0F, -1.5F, -2.0F, 3.0F, 15.0F, 4.0F, 0.0F, false);

        cube_r12 = new ModelRenderer(this);
        cube_r12.setRotationPoint(2.5F, -14.8246F, -9.9085F);
        bb_main.addChild(cube_r12);
        setRotationAngle(cube_r12, -2.2837F, 0.4133F, 0.8922F);
        cube_r12.setTextureOffset(12, 14).addBox(-8.0F, -6.5F, -8.0F, 9.0F, 8.0F, 9.0F, 0.0F, false);

        cube_r13 = new ModelRenderer(this);
        cube_r13.setRotationPoint(-3.5F, -15.7378F, -8.7184F);
        bb_main.addChild(cube_r13);
        setRotationAngle(cube_r13, -1.9802F, 0.4079F, 0.338F);
        cube_r13.setTextureOffset(0, 0).addBox(-8.0F, -7.0F, -12.0F, 7.0F, 5.0F, 12.0F, 0.0F, false);

        cube_r14 = new ModelRenderer(this);
        cube_r14.setRotationPoint(0.0F, -7.5F, -12.875F);
        bb_main.addChild(cube_r14);
        setRotationAngle(cube_r14, -0.5672F, 0.0F, 0.0F);
        cube_r14.setTextureOffset(0, 59).addBox(-5.0F, -2.5F, -1.0F, 10.0F, 6.0F, 5.0F, 0.0F, false);

        cube_r15 = new ModelRenderer(this);
        cube_r15.setRotationPoint(-6.75F, -19.7674F, 12.1385F);
        bb_main.addChild(cube_r15);
        setRotationAngle(cube_r15, 0.1745F, 0.0F, 0.0F);
        cube_r15.setTextureOffset(24, 59).addBox(5.7909F, 1.5F, -8.25F, 2.0F, 5.0F, 11.0F, 0.0F, false);
        cube_r15.setTextureOffset(19, 59).addBox(7.5409F, 1.5F, -8.25F, 9.0F, 5.0F, 11.0F, 0.0F, false);
        cube_r15.setTextureOffset(19, 59).addBox(-3.0311F, 1.5F, -8.25F, 9.0F, 5.0F, 11.0F, 0.0F, true);

        cube_r16 = new ModelRenderer(this);
        cube_r16.setRotationPoint(0.0F, -0.7405F, -13.6671F);
        bb_main.addChild(cube_r16);
        setRotationAngle(cube_r16, 0.0873F, 0.0F, 0.0F);
        cube_r16.setTextureOffset(12, 58).addBox(-5.0F, -4.5472F, -0.25F, 10.0F, 5.0F, 10.0F, 0.0F, false);

        cube_r17 = new ModelRenderer(this);
        cube_r17.setRotationPoint(-6.0F, -5.0F, -6.875F);
        bb_main.addChild(cube_r17);
        setRotationAngle(cube_r17, 0.2618F, 0.0F, 0.0F);
        cube_r17.setTextureOffset(0, 46).addBox(-3.875F, -2.5F, -2.0F, 8.0F, 5.0F, 5.0F, 0.0F, true);
        cube_r17.setTextureOffset(0, 46).addBox(7.875F, -2.5F, -2.0F, 8.0F, 5.0F, 5.0F, 0.0F, false);

        cube_r18 = new ModelRenderer(this);
        cube_r18.setRotationPoint(0.0F, -8.5F, 13.125F);
        bb_main.addChild(cube_r18);
        setRotationAngle(cube_r18, 0.0F, 0.7854F, 0.0F);
        cube_r18.setTextureOffset(25, 58).addBox(-1.5F, -8.5F, -3.5F, 5.0F, 17.0F, 5.0F, 0.0F, false);

        cube_r19 = new ModelRenderer(this);
        cube_r19.setRotationPoint(0.0F, -2.5F, -10.5F);
        bb_main.addChild(cube_r19);
        setRotationAngle(cube_r19, 0.4626F, -0.9521F, -0.3859F);
        cube_r19.setTextureOffset(1, 58).addBox(-3.0F, -4.0F, -6.5F, 11.0F, 5.0F, 7.0F, 0.0F, false);

        cube_r20 = new ModelRenderer(this);
        cube_r20.setRotationPoint(0.0F, -2.5F, -10.5F);
        bb_main.addChild(cube_r20);
        setRotationAngle(cube_r20, 0.4626F, 0.9521F, 0.3859F);
        cube_r20.setTextureOffset(1, 58).addBox(-8.0F, -4.0F, -6.5F, 11.0F, 5.0F, 7.0F, 0.0F, true);
    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(this.bb_main);
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
