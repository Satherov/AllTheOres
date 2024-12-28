package net.allthemods.alltheores.datagen.data.tags;

import net.allthemods.alltheores.content.blocks.sets.ATOSetHelper;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.registry.ATORegistry;
import net.allthemods.alltheores.registry.ATOTagRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ATOItemTagProvider extends ItemTagsProvider {
    public ATOItemTagProvider(PackOutput packOutPut, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> tagLookup, ExistingFileHelper existingFileHelper) {
        super(packOutPut, lookupProvider, tagLookup, Reference.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        tag(Tags.Items.NUGGETS).addTag(ATOTagRegistry.COPPER_NUGGET);

        tag(ATOTagRegistry.COPPER_NUGGET).add(ATORegistry.COPPER_NUGGET.get());

        tag(ATOTagRegistry.ORE_HAMMERS)
                .add(ATORegistry.COPPER_ORE_HAMMER.get())
                .add(ATORegistry.IRON_ORE_HAMMER.get())
                .add(ATORegistry.BRONZE_ORE_HAMMER.get())
                .add(ATORegistry.INVAR_ORE_HAMMER.get())
                .add(ATORegistry.PLATINUM_ORE_HAMMER.get());

        ATOSetHelper.applyToOre(set -> {
            tag(Tags.Items.ORES).addTag(set.ORE_BLOCK_ITEM_TAG);
            tag(set.ORE_BLOCK_ITEM_TAG)
                    .add(set.STONE_ORE_BLOCK_ITEM.get())
                    .add(set.SLATE_ORE_BLOCK_ITEM.get())
                    .add(set.NETHER_ORE_BLOCK_ITEM.get())
                    .add(set.END_ORE_BLOCK_ITEM.get())
                    .add(set.OTHER_ORE_BLOCK_ITEM.get());

            tag(Tags.Items.STORAGE_BLOCKS).addTag(set.DROP_BLOCK_ITEM_TAG);
            tag(set.DROP_BLOCK_ITEM_TAG).add(set.DROP_BLOCK_ITEM.get());
            tag(Tags.Items.RAW_MATERIALS).addTag(set.DROP_ITEM_TAG);
            tag(set.DROP_ITEM_TAG).add(set.DROP.get());

            tag(ATOTagRegistry.IN_STONE_ITEM).add(set.STONE_ORE_BLOCK_ITEM.get());
            tag(ATOTagRegistry.IN_DEEPSLATE_ITEM).add(set.SLATE_ORE_BLOCK_ITEM.get());
            tag(ATOTagRegistry.IN_NETHERRACK_ITEM).add(set.NETHER_ORE_BLOCK_ITEM.get());
            tag(ATOTagRegistry.IN_END_STONE_ITEM).add(set.END_ORE_BLOCK_ITEM.get());
            tag(ATOTagRegistry.IN_ANCIENT_STONE_ITEM).add(set.OTHER_ORE_BLOCK_ITEM.get());
        });

        ATOSetHelper.applyToMaterial(set -> {
            tag(Tags.Items.DUSTS).addTag(set.DUST_TAG);
            tag(set.DUST_TAG).add(set.DUST.get());

            tag(Tags.Items.STORAGE_BLOCKS).addTag(set.BLOCK_ITEM_TAG);
            tag(set.BLOCK_ITEM_TAG).add(set.BLOCK_ITEM.get());
        });

        ATOSetHelper.applyToAlloy(set -> {
            tag(Tags.Items.NUGGETS).addTag(set.NUGGET_TAG);
            tag(set.NUGGET_TAG).add(set.NUGGET.get());
            tag(Tags.Items.INGOTS).addTag(set.INGOT_TAG);
            tag(set.INGOT_TAG).add(set.INGOT.get());
            tag(Tags.Items.STORAGE_BLOCKS).addTag(set.BLOCK_ITEM_TAG);
            tag(set.BLOCK_ITEM_TAG).add(set.BLOCK_ITEM.get());

            tag(Tags.Items.RODS).addTag(set.ROD_TAG);
            tag(set.ROD_TAG).add(set.ROD.get());
            tag(ATOTagRegistry.GEARS).addTag(set.GEAR_TAG);
            tag(set.GEAR_TAG).add(set.GEAR.get());
            tag(ATOTagRegistry.PLATES).addTag(set.PLATE_TAG);
            tag(set.PLATE_TAG).add(set.PLATE.get());
        });

        ATOSetHelper.applyToGem(set -> {
            tag(Tags.Items.GEMS).addTag(set.GEM_TAG);
            tag(set.GEM_TAG).add(set.GEM.get());
        });

        ATOSetHelper.applyToVanilla(set -> {
            tag(Tags.Items.DUSTS).addTag(set.DUST_TAG);
            tag(set.DUST_TAG).add(set.DUST.get());
            tag(Tags.Items.RODS).addTag(set.ROD_TAG);
            tag(set.ROD_TAG).add(set.ROD.get());
            tag(ATOTagRegistry.GEARS).addTag(set.GEAR_TAG);
            tag(set.GEAR_TAG).add(set.GEAR.get());
            tag(ATOTagRegistry.PLATES).addTag(set.PLATE_TAG);
            tag(set.PLATE_TAG).add(set.PLATE.get());
        });

        ATOSetHelper.applyToMekanism(group -> {
            tag(ATOTagRegistry.CRYSTALS).addOptionalTag(group.CRYSTAL_TAG);
            tag(group.CRYSTAL_TAG).addOptional(group.CRYSTAL.getId());
            tag(ATOTagRegistry.SHARDS).addOptionalTag(group.SHARD_TAG);
            tag(group.SHARD_TAG).addOptional(group.SHARD.getId());
            tag(ATOTagRegistry.CLUMPS).addOptionalTag(group.CLUMP_TAG);
            tag(group.CLUMP_TAG).addOptional(group.CLUMP.getId());
            tag(ATOTagRegistry.DIRTY_DUSTS).addOptionalTag(group.DIRTY_DUST_TAG);
            tag(group.DIRTY_DUST_TAG).addOptional(group.DIRTY_DUST.getId());
        });
    }
}
