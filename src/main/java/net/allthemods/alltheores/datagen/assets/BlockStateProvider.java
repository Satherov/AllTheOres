package net.allthemods.alltheores.datagen.assets;

import net.allthemods.alltheores.blocks.BlockList;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;

public class BlockStateProvider extends net.neoforged.neoforge.client.model.generators.BlockStateProvider {
    public BlockStateProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator.getPackOutput(), Reference.MOD_ID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
    List<DeferredHolder<Block, ? extends Block>> entries = BlockList.BLOCKS.getEntries()
            .stream()
            .toList();

        entries.forEach(block -> {
            if ((block.get() instanceof LiquidBlock)){
                simpleBlockWithItem(block.get(), models().cubeAll(block.getId().getPath(), ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/fluid/molten_metal")));
            } else {
                simpleBlockWithItem(block.get(), cubeAll(block.get()));
            }
        });
    };

}
