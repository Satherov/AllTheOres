package net.allthemods.alltheores.datagen.server;

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
            tag(group.ORE_TAG).add(group.ORE.get());
            tag(group.ORE_TAG).add(group.SLATE_ORE.get());
            tag(group.ORE_TAG).add(group.NETHER_ORE.get());
            tag(group.ORE_TAG).add(group.END_ORE.get());
            tag(group.ORE_TAG).add(group.OTHER_ORE.get());

            tag(group.RAW_BLOCK_TAG).add(group.RAW_BLOCK.get());
            tag(group.BLOCK_TAG).add(group.BLOCK.get());
        });

        GroupHelper.applyToAlloy(group -> {
            tag(group.BLOCK_TAG).add(group.BLOCK.get());
        });
    }
}
