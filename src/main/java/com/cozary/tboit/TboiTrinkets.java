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

package com.cozary.tboit;

import com.cozary.tboit.capability.SpecialHeartHandler;
import com.cozary.tboit.capability.SyncToClient;
import com.cozary.tboit.capability.capabilities.CapabilityModel;
import com.cozary.tboit.capability.capabilities.CapabilityStorage;
import com.cozary.tboit.entities.*;
import com.cozary.tboit.init.ModEntityTypes;
import com.cozary.tboit.init.ModItems;
import com.cozary.tboit.init.ModLootConditions;
import com.cozary.tboit.init.ModRendererManager;
import com.cozary.tboit.potions.CommonModEvents;
import com.cozary.tboit.potions.Registrator;
import com.cozary.tboit.util.AddDrops;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypeMessage;

import java.util.Optional;
import java.util.function.Consumer;

@Mod("tboit")
@Mod.EventBusSubscriber(modid = TboiTrinkets.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TboiTrinkets {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "tboit";
    public static final ItemGroup TAB = new ItemGroup("tboitTab") {
        public ItemStack createIcon() {
            return new ItemStack(ModItems.A_MISSING_PAGE.get());
        }
    };
    public static SimpleChannel NETWORK;

    public TboiTrinkets() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(EventPriority.LOWEST, this::setup);
        eventBus.addListener(this::doClientStuff);
        eventBus.addListener(this::enqueueIMC);

        eventBus.addGenericListener(Effect.class, getRegistrator(CommonModEvents::onRegisterEffects));

        ModItems.ITEMS.register(eventBus);
        ModEntityTypes.ENTITY_TYPES.register(eventBus);

        MinecraftForge.EVENT_BUS.register(new EventHandler());
        MinecraftForge.EVENT_BUS.register(new SpecialHeartHandler());
        DeferredWorkQueue.runLater(() -> {
            MinecraftForge.EVENT_BUS.register(new AddDrops());
        });
        eventBus.addGenericListener(GlobalLootModifierSerializer.class, ModLootConditions::register);

    }

    public static <T extends IForgeRegistryEntry<T>> Consumer<RegistryEvent.Register<T>> getRegistrator(Consumer<Registrator<T>> consumer) {
        return event -> consumer.accept(new Registrator<>(event.getRegistry()));
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ModRendererManager.init();
    }

    private void setup(final FMLCommonSetupEvent event) {

        CapabilityManager.INSTANCE.register(CapabilityModel.class, new CapabilityStorage(), () -> {
            throw new UnsupportedOperationException("No Implementation!");
        });

        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.BLUE_BABY.get(), BlueBabyEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.MOM_LEG.get(), MomLegEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.SLOT_MACHINE.get(), SlotMachineEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.DEAD_BIRD.get(), DeadBirdEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.BLUE_FLY.get(), BlueFlyEntity.setCustomAttributes().create());
            GlobalEntityTypeAttributes.put(ModEntityTypes.ISAAC_HEAD.get(), IsaacHeadEntity.setCustomAttributes().create());

        });
        NETWORK = NetworkRegistry.newSimpleChannel(new ResourceLocation("tboit", "main_channel"), () -> "1.0", s -> true, s -> true);
        NETWORK.registerMessage(1, SyncToClient.class, SyncToClient::encode, SyncToClient::new, SyncToClient::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));

    }

    public void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("trinkets").icon(PlayerContainer.EMPTY_ARMOR_SLOT_SHIELD).build());
    }
}
