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

package com.cozary.tboit.init;

import com.cozary.tboit.entities.render.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class ModRendererManager {
    public static void init() {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BLUE_BABY.get(), manager -> new BlueBabyRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MOM_LEG.get(), manager -> new MomLegRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SLOT_MACHINE.get(), manager -> new SlotMachineRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DEAD_BIRD.get(), manager -> new DeadBirdRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BLUE_FLY.get(), manager -> new BlueFlyRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ISAAC_HEAD.get(), manager -> new IsaacHeadRenderer(manager));

    }

}
