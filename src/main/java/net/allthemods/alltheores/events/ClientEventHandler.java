package net.allthemods.alltheores.events;

import net.allthemods.alltheores.blocks.BlockList;
import net.allthemods.alltheores.datagen.server.GroupHelper;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.model.DynamicFluidContainerModel;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

@EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientEventHandler {
    @SubscribeEvent
    public static void creativeTab(BuildCreativeModeTabContentsEvent event){
        if (event.getTabKey().equals(Reference.CREATIVE_TAB.getKey())){
            for (DeferredHolder<Item, ? extends Item> item: BlockList.ITEMS.getEntries()){
                event.accept(item.get());
            }
        }
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterClientExtensionsEvent event) {
        GroupHelper.applyToMaterial(group -> {
            event.registerFluidType(new IClientFluidTypeExtensions() {
                @Override
                public ResourceLocation getStillTexture() {
                    return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/fluid/molten_metal");
                }

                @Override
                public ResourceLocation getFlowingTexture() {
                    return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/fluid/molten_metal_flow");
                }

                @Override
                public int getTintColor() {
                    return group.fluidColor;
                }
            }, group.MOLTEN_TYPE.get());
        });
    }

    @SubscribeEvent
    public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event) {
        GroupHelper.applyToMaterial(group -> {
            event.register(new DynamicFluidContainerModel.Colors(), group.MOLTEN_BUCKET.get());
        });
    }
}
