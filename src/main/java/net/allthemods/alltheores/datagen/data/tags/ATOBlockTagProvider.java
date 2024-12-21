package net.allthemods.alltheores.datagen.data.tags;

import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.registry.ATOTagRegistry;
import net.allthemods.alltheores.registry.GroupHelper;
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

        GroupHelper.applyToOre(group -> {
            tag(Tags.Blocks.STORAGE_BLOCKS).addTag(group.DROP_BLOCK_TAG);
            tag(Tags.Blocks.ORES).addTag(group.ORE_BLOCK_TAG);

            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                    .addTag(group.ORE_BLOCK_TAG)
                    .addTag(group.DROP_BLOCK_TAG);

            switch (group.hardness) {
                case "stone":
                    tag(BlockTags.NEEDS_STONE_TOOL).addTag(group.ORE_BLOCK_TAG);
                    tag(BlockTags.NEEDS_STONE_TOOL).addTag(group.DROP_BLOCK_TAG);
                    break;
                case "iron":
                    tag(BlockTags.NEEDS_IRON_TOOL).addTag(group.ORE_BLOCK_TAG);
                    tag(BlockTags.NEEDS_IRON_TOOL).addTag(group.DROP_BLOCK_TAG);
                    break;
                case "diamond":
                    tag(BlockTags.NEEDS_DIAMOND_TOOL).addTag(group.ORE_BLOCK_TAG);
                    tag(BlockTags.NEEDS_DIAMOND_TOOL).addTag(group.DROP_BLOCK_TAG);
                    break;
            }

            tag(group.ORE_BLOCK_TAG)
                    .add(group.STONE_ORE_BLOCK.get())
                    .add(group.SLATE_ORE_BLOCK.get())
                    .add(group.NETHER_ORE_BLOCK.get())
                    .add(group.END_ORE_BLOCK.get())
                    .add(group.OTHER_ORE_BLOCK.get());

            tag(ATOTagRegistry.IN_STONE).add(group.STONE_ORE_BLOCK.get());
            tag(ATOTagRegistry.IN_DEEPSLATE).add(group.SLATE_ORE_BLOCK.get());
            tag(ATOTagRegistry.IN_NETHERRACK).add(group.NETHER_ORE_BLOCK.get());
            tag(ATOTagRegistry.IN_END_STONE).add(group.END_ORE_BLOCK.get());
            tag(ATOTagRegistry.IN_ANCIENT_STONE).add(group.OTHER_ORE_BLOCK.get());

            tag(group.DROP_BLOCK_TAG).add(group.DROP_BLOCK.get());
        });

        GroupHelper.applyToAlloy(group -> {
            tag(Tags.Blocks.STORAGE_BLOCKS).addTag(group.BLOCK_TAG);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).addTag(group.BLOCK_TAG);

            tag(group.BLOCK_TAG).add(group.BLOCK.get());
        });

    }
}
