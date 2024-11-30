package net.allthemods.alltheores.datagen.server;

import net.allthemods.alltheores.infos.ItemTagRegistry;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class BlockTags extends BlockTagsProvider {

    public BlockTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput,lookupProvider, Reference.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        GroupHelper.applyToOre(group -> {
            tag(group.ORE_BLOCK_TAG)
                    .add(group.STONE_ORE_BLOCK.get())
                    .add(group.SLATE_ORE_BLOCK.get())
                    .add(group.NETHER_ORE_BLOCK.get())
                    .add(group.END_ORE_BLOCK.get())
                    .add(group.OTHER_ORE_BLOCK.get());

            tag(ItemTagRegistry.IN_STONE).add(group.STONE_ORE_BLOCK.get());
            tag(ItemTagRegistry.IN_DEEPSLATE).add(group.SLATE_ORE_BLOCK.get());
            tag(ItemTagRegistry.IN_NETHERRACK).add(group.NETHER_ORE_BLOCK.get());
            tag(ItemTagRegistry.IN_END_STONE).add(group.END_ORE_BLOCK.get());
            tag(ItemTagRegistry.IN_ANCIENT_STONE).add(group.OTHER_ORE_BLOCK.get());

            tag(group.DROP_BLOCK_TAG).add(group.DROP_BLOCK.get());

            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                    .addTag(group.ORE_BLOCK_TAG)
                    .addTag(group.DROP_BLOCK_TAG);
        });

        GroupHelper.applyToAlloy(group -> {
            tag(group.BLOCK_TAG).add(group.BLOCK.get());
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).addTag(group.BLOCK_TAG);
        });

    }
}
