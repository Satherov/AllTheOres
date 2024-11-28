package net.allthemods.alltheores.datagen.server;

import net.allthemods.alltheores.blocks.BlockList;
import net.allthemods.alltheores.blocks.mek_reg.MekRegistry;
import net.allthemods.alltheores.infos.ItemTagRegistry;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ItemTags extends ItemTagsProvider {
    public ItemTags(PackOutput packOutPut, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> tagLookup, ExistingFileHelper existingFileHelper) {
        super(packOutPut, lookupProvider, tagLookup, Reference.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ItemTagRegistry.COPPER_NUGGET).add(BlockList.COPPER_NUGGET.get());

        GroupHelper.applyToOre(group -> {
            tag(group.ORE_ITEM_TAG)
                    .add(group.ORE_ITEM.get())
                    .add(group.SLATE_ORE_ITEM.get())
                    .add(group.NETHER_ORE_ITEM.get())
                    .add(group.END_ORE_ITEM.get())
                    .add(group.OTHER_ORE_ITEM.get());
        });

        GroupHelper.applyToAlloy(group -> {
            tag(group.INGOT_TAG).add(group.INGOT.get());
            tag(group.NUGGET_TAG).add(group.NUGGET.get());
            tag(group.BLOCK_ITEM_TAG).add(group.BLOCK_ITEM.get());

            tag(group.DUST_TAG).add(group.DUST.get());
            tag(group.ROD_TAG).add(group.ROD.get());
            tag(group.GEAR_TAG).add(group.GEAR.get());
            tag(group.PLATE_TAG).add(group.PLATE.get());
        });

        GroupHelper.applyToMaterial(group -> {
            tag(group.CRYSTAL_TAG).add(group.CRYSTAL.get());
            tag(group.SHARD_TAG).add(group.SHARD.get());
            tag(group.CLUMP_TAG).add(group.CLUMP.get());
            tag(group.DIRTY_DUST_TAG).add(group.DIRTY_DUST.get());
        });

        GroupHelper.applyToDust(group -> {
            tag(group.DUST_TAG).add(group.DUST.get());
            tag(group.BLOCK_ITEM_TAG).add(group.BLOCK_ITEM.get());
        });

        GroupHelper.applyToGem(group -> {
            tag(group.GEM_TAG).add(group.GEM.get());
            tag(group.DUST_TAG).add(group.DUST.get());
            tag(group.BLOCK_ITEM_TAG).add(group.BLOCK_ITEM.get());
        });
    }
}
