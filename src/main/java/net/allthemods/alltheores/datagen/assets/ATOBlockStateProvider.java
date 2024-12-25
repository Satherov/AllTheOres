package net.allthemods.alltheores.datagen.assets;

import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.registry.ATORegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ATOBlockStateProvider extends net.neoforged.neoforge.client.model.generators.BlockStateProvider {
    public ATOBlockStateProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator.getPackOutput(), Reference.MOD_ID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ATORegistry.BLOCKS.getEntries().stream().toList().forEach(block -> simpleBlockWithItem(block.get(), cubeAll(block.get())));
        ATORegistry.FLUID_BLOCKS.getEntries().stream().toList().forEach( block -> simpleBlockWithItem(block.get(), models().cubeAll(block.getId().getPath(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/fluid/molten_metal"))));
    }
}
