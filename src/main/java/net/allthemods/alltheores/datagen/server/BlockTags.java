package net.allthemods.alltheores.datagen.server;

import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.registry.OreRegistryGroup;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class BlockTags extends BlockTagsProvider {

    public BlockTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput,lookupProvider, Reference.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        GroupHelper.applyToAlloy(group -> {
            tag(group.BLOCK_TAG).add(group.BLOCK.get());
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).addTag(group.BLOCK_TAG);
        });

        GroupHelper.applyToOre(group -> {
            tag(group.ORE_TAG)
                    .add(group.ORE.get())
                    .add(group.SLATE_ORE.get())
                    .add(group.NETHER_ORE.get())
                    .add(group.END_ORE.get())
                    .add(group.OTHER_ORE.get());
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).addTag(group.ORE_TAG);
        });

        GroupHelper.applyToGem(group -> {
            tag(group.BLOCK_TAG).add(group.BLOCK.get());
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).addTag(group.BLOCK_TAG);
        });

        GroupHelper.applyToDust(group -> {
            tag(group.BLOCK_TAG).add(group.BLOCK.get());
            tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).addTag(group.BLOCK_TAG);
        });
    }
}
