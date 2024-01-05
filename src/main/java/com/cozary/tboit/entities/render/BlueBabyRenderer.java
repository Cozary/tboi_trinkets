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
import com.cozary.tboit.entities.BlueBabyEntity;
import com.cozary.tboit.entities.model.BlueBabyModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BlueBabyRenderer extends MobRenderer<BlueBabyEntity, BlueBabyModel<BlueBabyEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(TboiTrinkets.MOD_ID, "textures/entity/blue_baby.png");

    public BlueBabyRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BlueBabyModel<>(), 0.3F);
    }

    @Override
    public ResourceLocation getEntityTexture(BlueBabyEntity entity) {
        return TEXTURE;
    }

}
