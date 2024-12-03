package net.allthemods.alltheores.datagen.data.tags;

import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.registry.ATORegistry;
import net.allthemods.alltheores.registry.ATOTagRegistry;
import net.allthemods.alltheores.registry.GroupHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ATOItemTagProvider extends ItemTagsProvider {
    public ATOItemTagProvider(PackOutput packOutPut, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> tagLookup, ExistingFileHelper existingFileHelper) {
        super(packOutPut, lookupProvider, tagLookup, Reference.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        tag(ATOTagRegistry.COPPER_NUGGET).add(ATORegistry.COPPER_NUGGET.get());

        tag(ATOTagRegistry.ORE_HAMMERS)
                .add(ATORegistry.COPPER_ORE_HAMMER.get())
                .add(ATORegistry.IRON_ORE_HAMMER.get())
                .add(ATORegistry.BRONZE_ORE_HAMMER.get())
                .add(ATORegistry.INVAR_ORE_HAMMER.get())
                .add(ATORegistry.PLATINUM_ORE_HAMMER.get());

        GroupHelper.applyToOre(group -> {
            tag(group.ORE_BLOCK_ITEM_TAG)
                    .add(group.STONE_ORE_BLOCK_ITEM.get())
                    .add(group.SLATE_ORE_BLOCK_ITEM.get())
                    .add(group.NETHER_ORE_BLOCK_ITEM.get())
                    .add(group.END_ORE_BLOCK_ITEM.get())
                    .add(group.OTHER_ORE_BLOCK_ITEM.get());

            tag(group.DROP_TAG).add(group.DROP.get());
            tag(group.DROP_BLOCK_ITEM_TAG).add(group.DROP_BLOCK_ITEM.get());

            tag(group.MATERIAL_TAG).add(group.MATERIAL.get());
            tag(group.DUST_TAG).add(group.DUST.get());
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

        GroupHelper.applyToMekanism(group -> {
            tag(group.CRYSTAL_TAG).add(group.CRYSTAL.get());
            tag(group.SHARD_TAG).add(group.SHARD.get());
            tag(group.CLUMP_TAG).add(group.CLUMP.get());
            tag(group.DIRTY_DUST_TAG).add(group.DIRTY_DUST.get());
        });
    }
}
