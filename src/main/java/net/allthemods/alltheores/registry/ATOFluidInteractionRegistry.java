package net.allthemods.alltheores.registry;

import net.allthemods.alltheores.infos.Reference;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.FluidInteractionRegistry;

@EventBusSubscriber(modid = Reference.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ATOFluidInteractionRegistry {
    @SubscribeEvent
    public static void register(FMLCommonSetupEvent event) {
        if (Reference.enableFluids) {
            event.enqueueWork(() -> GroupHelper.applyToMaterial(group -> {
                FluidInteractionRegistry.addInteraction(group.MOLTEN_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(NeoForgeMod.WATER_TYPE.value(), fluidState -> fluidState.isSource() ? group.BLOCK.get().defaultBlockState() : Blocks.COBBLESTONE.defaultBlockState()));
                FluidInteractionRegistry.addInteraction(NeoForgeMod.LAVA_TYPE.value(), new FluidInteractionRegistry.InteractionInformation(group.MOLTEN_TYPE.get(), fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : group.ORES.DROP_BLOCK.get().defaultBlockState()));
            }));
        }
    }
}
