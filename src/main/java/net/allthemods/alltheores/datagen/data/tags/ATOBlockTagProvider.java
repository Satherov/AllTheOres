package net.allthemods.alltheores.datagen.data.tags;

import net.allthemods.alltheores.content.blocks.sets.ATOSetHelper;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.registry.ATOTagRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ATOBlockTagProvider extends BlockTagsProvider {

    public ATOBlockTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, Reference.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        ATOSetHelper.applyToOre(set -> {
            tag(BlockTags.MINEABLE_WITH_PICKAXE)
                    .addTag(set.ORE_BLOCK_TAG)
                    .addTag(set.DROP_BLOCK_TAG);
            tag(Tags.Blocks.ORES).addTag(set.ORE_BLOCK_TAG);
            tag(set.ORE_BLOCK_TAG)
                    .add(set.STONE_ORE_BLOCK.get())
                    .add(set.SLATE_ORE_BLOCK.get())
                    .add(set.NETHER_ORE_BLOCK.get())
                    .add(set.END_ORE_BLOCK.get())
                    .add(set.OTHER_ORE_BLOCK.get());

            switch (set.hardness) {
                case "stone":
                    tag(BlockTags.NEEDS_STONE_TOOL).addTag(set.ORE_BLOCK_TAG);
                    break;
                case "iron":
                    tag(BlockTags.NEEDS_IRON_TOOL).addTag(set.ORE_BLOCK_TAG);
                    break;
                case "diamond":
                    tag(BlockTags.NEEDS_DIAMOND_TOOL).addTag(set.ORE_BLOCK_TAG);
                    break;
            }

            tag(Tags.Blocks.STORAGE_BLOCKS).addTag(set.DROP_BLOCK_TAG);
            tag(set.DROP_BLOCK_TAG).add(set.DROP_BLOCK.get());

            tag(ATOTagRegistry.IN_STONE).add(set.STONE_ORE_BLOCK.get());
            tag(ATOTagRegistry.IN_DEEPSLATE).add(set.SLATE_ORE_BLOCK.get());
            tag(ATOTagRegistry.IN_NETHERRACK).add(set.NETHER_ORE_BLOCK.get());
            tag(ATOTagRegistry.IN_END_STONE).add(set.END_ORE_BLOCK.get());
            tag(ATOTagRegistry.IN_ANCIENT_STONE).add(set.OTHER_ORE_BLOCK.get());
        });

        ATOSetHelper.applyToMaterial(set -> {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).addTag(set.BLOCK_TAG);
            tag(Tags.Blocks.STORAGE_BLOCKS).addTag(set.BLOCK_TAG);
            tag(set.BLOCK_TAG).add(set.BLOCK.get());
        });

        ATOSetHelper.applyToIngot(set -> {
            switch (set.ORES.hardness) {
                case "stone":
                    tag(BlockTags.NEEDS_STONE_TOOL).addTag(set.RAW_BLOCK_TAG);
                    break;
                case "iron":
                    tag(BlockTags.NEEDS_IRON_TOOL).addTag(set.RAW_BLOCK_TAG);
                    break;
                case "diamond":
                    tag(BlockTags.NEEDS_DIAMOND_TOOL).addTag(set.RAW_BLOCK_TAG);
                    break;
            }
        });

        ATOSetHelper.applyToFluid(set -> {
            tag(set.MOLTEN_BLOCK_TAG).add(set.MOLTEN_BLOCK.get());
        });
    }
}
