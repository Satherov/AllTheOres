package net.allthemods.alltheores.datagen.server;

import net.allthemods.alltheores.blocks.BlockList;
import net.allthemods.alltheores.infos.ItemTagRegistry;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class BlockTags extends BlockTagsProvider {

    public BlockTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, Reference.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        // ###################### ALL THE ORES

        // **************** ALUMINUM

        tag(ItemTagRegistry.ALUMINUM_ORE_BLOCK).add(BlockList.ALUMINUM_ORE.get());
        tag(ItemTagRegistry.ALUMINUM_ORE_BLOCK).add(BlockList.ALUMINUM_SLATE_ORE.get());
        tag(ItemTagRegistry.ALUMINUM_ORE_BLOCK).add(BlockList.ALUMINUM_NETHER_ORE.get());
        tag(ItemTagRegistry.ALUMINUM_ORE_BLOCK).add(BlockList.ALUMINUM_END_ORE.get());
        tag(ItemTagRegistry.ALUMINUM_ORE_BLOCK).add(BlockList.ALUMINUM_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.ALUMINUM_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.ALUMINUM_SLATE_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.ALUMINUM_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.ALUMINUM_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.ALUMINUM_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_STONE).add(BlockList.ALUMINUM_ORE.get());
        tag(ItemTagRegistry.IN_DEEPSLATE).add(BlockList.ALUMINUM_SLATE_ORE.get());
        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.ALUMINUM_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.ALUMINUM_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.ALUMINUM_OTHER_ORE.get());

        tag(ItemTagRegistry.ALUMINUM_RAW_BLOCK_BLOCK).add(BlockList.ALUMINUM_RAW_BLOCK.get());
        tag(ItemTagRegistry.ALUMINUM_BLOCK_BLOCK).add(BlockList.ALUMINUM_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.ALUMINUM_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.ALUMINUM_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.ALUMINUM_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.ALUMINUM_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.ALUMINUM_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.ALUMINUM_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.ALUMINUM_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.ALUMINUM_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.ALUMINUM_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.ALUMINUM_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.ALUMINUM_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.ALUMINUM_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.ALUMINUM_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.ALUMINUM_BLOCK.get());

        // **************** LEAD

        tag(ItemTagRegistry.LEAD_ORE_BLOCK).add(BlockList.LEAD_ORE.get());
        tag(ItemTagRegistry.LEAD_ORE_BLOCK).add(BlockList.LEAD_SLATE_ORE.get());
        tag(ItemTagRegistry.LEAD_ORE_BLOCK).add(BlockList.LEAD_NETHER_ORE.get());
        tag(ItemTagRegistry.LEAD_ORE_BLOCK).add(BlockList.LEAD_END_ORE.get());
        tag(ItemTagRegistry.LEAD_ORE_BLOCK).add(BlockList.LEAD_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.LEAD_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.LEAD_SLATE_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.LEAD_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.LEAD_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.LEAD_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_STONE).add(BlockList.LEAD_ORE.get());
        tag(ItemTagRegistry.IN_DEEPSLATE).add(BlockList.LEAD_SLATE_ORE.get());
        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.LEAD_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.LEAD_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.LEAD_OTHER_ORE.get());

        tag(ItemTagRegistry.LEAD_RAW_BLOCK_BLOCK).add(BlockList.LEAD_RAW_BLOCK.get());
        tag(ItemTagRegistry.LEAD_BLOCK_BLOCK).add(BlockList.LEAD_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.LEAD_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.LEAD_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.LEAD_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.LEAD_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.LEAD_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.LEAD_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.LEAD_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.LEAD_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.LEAD_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.LEAD_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.LEAD_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.LEAD_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.LEAD_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.LEAD_BLOCK.get());

        // **************** NICKEL

        tag(ItemTagRegistry.NICKEL_ORE_BLOCK).add(BlockList.NICKEL_ORE.get());
        tag(ItemTagRegistry.NICKEL_ORE_BLOCK).add(BlockList.NICKEL_SLATE_ORE.get());
        tag(ItemTagRegistry.NICKEL_ORE_BLOCK).add(BlockList.NICKEL_NETHER_ORE.get());
        tag(ItemTagRegistry.NICKEL_ORE_BLOCK).add(BlockList.NICKEL_END_ORE.get());
        tag(ItemTagRegistry.NICKEL_ORE_BLOCK).add(BlockList.NICKEL_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.NICKEL_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.NICKEL_SLATE_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.NICKEL_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.NICKEL_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.NICKEL_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_STONE).add(BlockList.NICKEL_ORE.get());
        tag(ItemTagRegistry.IN_DEEPSLATE).add(BlockList.NICKEL_SLATE_ORE.get());
        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.NICKEL_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.NICKEL_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.NICKEL_OTHER_ORE.get());

        tag(ItemTagRegistry.NICKEL_RAW_BLOCK_BLOCK).add(BlockList.NICKEL_RAW_BLOCK.get());
        tag(ItemTagRegistry.NICKEL_BLOCK_BLOCK).add(BlockList.NICKEL_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.NICKEL_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.NICKEL_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.NICKEL_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.NICKEL_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.NICKEL_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.NICKEL_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.NICKEL_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.NICKEL_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.NICKEL_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.NICKEL_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.NICKEL_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.NICKEL_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.NICKEL_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.NICKEL_BLOCK.get());

        // **************** OSMIUM

        tag(ItemTagRegistry.OSMIUM_ORE_BLOCK).add(BlockList.OSMIUM_ORE.get());
        tag(ItemTagRegistry.OSMIUM_ORE_BLOCK).add(BlockList.OSMIUM_SLATE_ORE.get());
        tag(ItemTagRegistry.OSMIUM_ORE_BLOCK).add(BlockList.OSMIUM_NETHER_ORE.get());
        tag(ItemTagRegistry.OSMIUM_ORE_BLOCK).add(BlockList.OSMIUM_END_ORE.get());
        tag(ItemTagRegistry.OSMIUM_ORE_BLOCK).add(BlockList.OSMIUM_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.OSMIUM_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.OSMIUM_SLATE_ORE.get());

        tag(ItemTagRegistry.IN_STONE).add(BlockList.OSMIUM_ORE.get());
        tag(ItemTagRegistry.IN_DEEPSLATE).add(BlockList.OSMIUM_SLATE_ORE.get());
        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.OSMIUM_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.OSMIUM_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.OSMIUM_OTHER_ORE.get());

        tag(ItemTagRegistry.OSMIUM_RAW_BLOCK_BLOCK).add(BlockList.OSMIUM_RAW_BLOCK.get());
        tag(ItemTagRegistry.OSMIUM_BLOCK_BLOCK).add(BlockList.OSMIUM_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.OSMIUM_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.OSMIUM_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.OSMIUM_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.OSMIUM_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.OSMIUM_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.OSMIUM_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.OSMIUM_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.OSMIUM_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.OSMIUM_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.OSMIUM_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.OSMIUM_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.OSMIUM_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.OSMIUM_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.OSMIUM_BLOCK.get());

        // **************** PLATINUM

        tag(ItemTagRegistry.PLATINUM_ORE_BLOCK).add(BlockList.PLATINUM_ORE.get());
        tag(ItemTagRegistry.PLATINUM_ORE_BLOCK).add(BlockList.PLATINUM_SLATE_ORE.get());
        tag(ItemTagRegistry.PLATINUM_ORE_BLOCK).add(BlockList.PLATINUM_NETHER_ORE.get());
        tag(ItemTagRegistry.PLATINUM_ORE_BLOCK).add(BlockList.PLATINUM_END_ORE.get());
        tag(ItemTagRegistry.PLATINUM_ORE_BLOCK).add(BlockList.PLATINUM_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.PLATINUM_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.PLATINUM_SLATE_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.PLATINUM_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.PLATINUM_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.PLATINUM_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_STONE).add(BlockList.PLATINUM_ORE.get());
        tag(ItemTagRegistry.IN_DEEPSLATE).add(BlockList.PLATINUM_SLATE_ORE.get());
        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.PLATINUM_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.PLATINUM_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.PLATINUM_OTHER_ORE.get());

        tag(ItemTagRegistry.PLATINUM_RAW_BLOCK_BLOCK).add(BlockList.PLATINUM_RAW_BLOCK.get());
        tag(ItemTagRegistry.PLATINUM_BLOCK_BLOCK).add(BlockList.PLATINUM_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.PLATINUM_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.PLATINUM_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.PLATINUM_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.PLATINUM_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.PLATINUM_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.PLATINUM_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.PLATINUM_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.PLATINUM_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.PLATINUM_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.PLATINUM_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.PLATINUM_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.PLATINUM_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.PLATINUM_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.PLATINUM_BLOCK.get());

        // **************** SILVER

        tag(ItemTagRegistry.SILVER_ORE_BLOCK).add(BlockList.SILVER_ORE.get());
        tag(ItemTagRegistry.SILVER_ORE_BLOCK).add(BlockList.SILVER_SLATE_ORE.get());
        tag(ItemTagRegistry.SILVER_ORE_BLOCK).add(BlockList.SILVER_NETHER_ORE.get());
        tag(ItemTagRegistry.SILVER_ORE_BLOCK).add(BlockList.SILVER_END_ORE.get());
        tag(ItemTagRegistry.SILVER_ORE_BLOCK).add(BlockList.SILVER_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SILVER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SILVER_SLATE_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SILVER_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SILVER_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SILVER_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_STONE).add(BlockList.SILVER_ORE.get());
        tag(ItemTagRegistry.IN_DEEPSLATE).add(BlockList.SILVER_SLATE_ORE.get());
        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.SILVER_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.SILVER_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.SILVER_OTHER_ORE.get());

        tag(ItemTagRegistry.SILVER_RAW_BLOCK_BLOCK).add(BlockList.SILVER_RAW_BLOCK.get());
        tag(ItemTagRegistry.SILVER_BLOCK_BLOCK).add(BlockList.SILVER_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SILVER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SILVER_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SILVER_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SILVER_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SILVER_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SILVER_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SILVER_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SILVER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SILVER_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SILVER_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SILVER_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SILVER_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SILVER_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SILVER_BLOCK.get());

        // **************** TIN

        tag(ItemTagRegistry.TIN_ORE_BLOCK).add(BlockList.TIN_ORE.get());
        tag(ItemTagRegistry.TIN_ORE_BLOCK).add(BlockList.TIN_SLATE_ORE.get());
        tag(ItemTagRegistry.TIN_ORE_BLOCK).add(BlockList.TIN_NETHER_ORE.get());
        tag(ItemTagRegistry.TIN_ORE_BLOCK).add(BlockList.TIN_END_ORE.get());
        tag(ItemTagRegistry.TIN_ORE_BLOCK).add(BlockList.TIN_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.TIN_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.TIN_SLATE_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.TIN_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.TIN_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.TIN_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_STONE).add(BlockList.TIN_ORE.get());
        tag(ItemTagRegistry.IN_DEEPSLATE).add(BlockList.TIN_SLATE_ORE.get());
        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.TIN_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.TIN_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.TIN_OTHER_ORE.get());

        tag(ItemTagRegistry.TIN_RAW_BLOCK_BLOCK).add(BlockList.TIN_RAW_BLOCK.get());
        tag(ItemTagRegistry.TIN_BLOCK_BLOCK).add(BlockList.TIN_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.TIN_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.TIN_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.TIN_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.TIN_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.TIN_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.TIN_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.TIN_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.TIN_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.TIN_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.TIN_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.TIN_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.TIN_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.TIN_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.TIN_BLOCK.get());

        // **************** URANIUM

        tag(ItemTagRegistry.URANIUM_ORE_BLOCK).add(BlockList.URANIUM_ORE.get());
        tag(ItemTagRegistry.URANIUM_ORE_BLOCK).add(BlockList.URANIUM_SLATE_ORE.get());
        tag(ItemTagRegistry.URANIUM_ORE_BLOCK).add(BlockList.URANIUM_NETHER_ORE.get());
        tag(ItemTagRegistry.URANIUM_ORE_BLOCK).add(BlockList.URANIUM_END_ORE.get());
        tag(ItemTagRegistry.URANIUM_ORE_BLOCK).add(BlockList.URANIUM_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.URANIUM_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.URANIUM_SLATE_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.URANIUM_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.URANIUM_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.URANIUM_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_STONE).add(BlockList.URANIUM_ORE.get());
        tag(ItemTagRegistry.IN_DEEPSLATE).add(BlockList.URANIUM_SLATE_ORE.get());
        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.URANIUM_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.URANIUM_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.URANIUM_OTHER_ORE.get());

        tag(ItemTagRegistry.URANIUM_RAW_BLOCK_BLOCK).add(BlockList.URANIUM_RAW_BLOCK.get());
        tag(ItemTagRegistry.URANIUM_BLOCK_BLOCK).add(BlockList.URANIUM_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.URANIUM_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.URANIUM_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.URANIUM_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.URANIUM_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.URANIUM_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.URANIUM_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.URANIUM_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.URANIUM_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.URANIUM_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.URANIUM_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.URANIUM_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.URANIUM_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.URANIUM_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.URANIUM_BLOCK.get());

        // **************** ZINC

        tag(ItemTagRegistry.ZINC_ORE_BLOCK).add(BlockList.ZINC_ORE.get());
        tag(ItemTagRegistry.ZINC_ORE_BLOCK).add(BlockList.ZINC_SLATE_ORE.get());
        tag(ItemTagRegistry.ZINC_ORE_BLOCK).add(BlockList.ZINC_NETHER_ORE.get());
        tag(ItemTagRegistry.ZINC_ORE_BLOCK).add(BlockList.ZINC_END_ORE.get());
        tag(ItemTagRegistry.ZINC_ORE_BLOCK).add(BlockList.ZINC_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.ZINC_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.ZINC_SLATE_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.ZINC_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.ZINC_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.ZINC_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_STONE).add(BlockList.ZINC_ORE.get());
        tag(ItemTagRegistry.IN_DEEPSLATE).add(BlockList.ZINC_SLATE_ORE.get());
        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.ZINC_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.ZINC_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.ZINC_OTHER_ORE.get());

        tag(ItemTagRegistry.ZINC_RAW_BLOCK_BLOCK).add(BlockList.ZINC_RAW_BLOCK.get());
        tag(ItemTagRegistry.ZINC_BLOCK_BLOCK).add(BlockList.ZINC_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.ZINC_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.ZINC_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.ZINC_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.ZINC_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.ZINC_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.ZINC_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.ZINC_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.ZINC_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.ZINC_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.ZINC_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.ZINC_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.ZINC_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.ZINC_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.ZINC_BLOCK.get());

        // **************** IRIDIUM

        tag(ItemTagRegistry.IRIDIUM_ORE_BLOCK).add(BlockList.IRIDIUM_ORE.get());
        tag(ItemTagRegistry.IRIDIUM_ORE_BLOCK).add(BlockList.IRIDIUM_SLATE_ORE.get());
        tag(ItemTagRegistry.IRIDIUM_ORE_BLOCK).add(BlockList.IRIDIUM_NETHER_ORE.get());
        tag(ItemTagRegistry.IRIDIUM_ORE_BLOCK).add(BlockList.IRIDIUM_END_ORE.get());
        tag(ItemTagRegistry.IRIDIUM_ORE_BLOCK).add(BlockList.IRIDIUM_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.IRIDIUM_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.IRIDIUM_SLATE_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.IRIDIUM_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.IRIDIUM_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.IRIDIUM_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_STONE).add(BlockList.IRIDIUM_ORE.get());
        tag(ItemTagRegistry.IN_DEEPSLATE).add(BlockList.IRIDIUM_SLATE_ORE.get());
        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.IRIDIUM_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.IRIDIUM_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.IRIDIUM_OTHER_ORE.get());

        tag(ItemTagRegistry.IRIDIUM_RAW_BLOCK_BLOCK).add(BlockList.IRIDIUM_RAW_BLOCK.get());
        tag(ItemTagRegistry.IRIDIUM_BLOCK_BLOCK).add(BlockList.IRIDIUM_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.IRIDIUM_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.IRIDIUM_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.IRIDIUM_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.IRIDIUM_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.IRIDIUM_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.IRIDIUM_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.IRIDIUM_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.IRIDIUM_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.IRIDIUM_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.IRIDIUM_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.IRIDIUM_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.IRIDIUM_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.IRIDIUM_RAW_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.IRIDIUM_BLOCK.get());

        // ###################### ALLOYS

        // **************** BRONZE

        tag(ItemTagRegistry.BRONZE_BLOCK_BLOCK).add(BlockList.BRONZE_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.BRONZE_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.BRONZE_BLOCK.get());

        // **************** BRASS

        tag(ItemTagRegistry.BRASS_BLOCK_BLOCK).add(BlockList.BRASS_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.BRASS_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.BRASS_BLOCK.get());

        // **************** STEEL

        tag(ItemTagRegistry.STEEL_BLOCK_BLOCK).add(BlockList.STEEL_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.STEEL_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.STEEL_BLOCK.get());

        // **************** INVAR

        tag(ItemTagRegistry.INVAR_BLOCK_BLOCK).add(BlockList.INVAR_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.INVAR_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.INVAR_BLOCK.get());

        // **************** CONSTANTAN

        tag(ItemTagRegistry.CONSTANTAN_BLOCK_BLOCK).add(BlockList.CONSTANTAN_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.CONSTANTAN_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.CONSTANTAN_BLOCK.get());

        // **************** ELECTRUM

        tag(ItemTagRegistry.ELECTRUM_BLOCK_BLOCK).add(BlockList.ELECTRUM_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.ELECTRUM_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.ELECTRUM_BLOCK.get());

        // **************** ENDERIUM

        tag(ItemTagRegistry.ENDERIUM_BLOCK_BLOCK).add(BlockList.ENDERIUM_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.ENDERIUM_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.ENDERIUM_BLOCK.get());

        // **************** LUMIUM

        tag(ItemTagRegistry.LUMIUM_BLOCK_BLOCK).add(BlockList.LUMIUM_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.LUMIUM_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.LUMIUM_BLOCK.get());

        // **************** SIGNALUM

        tag(ItemTagRegistry.SIGNALUM_BLOCK_BLOCK).add(BlockList.SIGNALUM_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SIGNALUM_BLOCK.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.SIGNALUM_BLOCK.get());

        // ###################### GEMS

        // **************** RUBY

        tag(ItemTagRegistry.RUBY_ORE_BLOCK).add(BlockList.RUBY_ORE.get());
        tag(ItemTagRegistry.RUBY_ORE_BLOCK).add(BlockList.RUBY_SLATE_ORE.get());
        tag(ItemTagRegistry.RUBY_ORE_BLOCK).add(BlockList.RUBY_NETHER_ORE.get());
        tag(ItemTagRegistry.RUBY_ORE_BLOCK).add(BlockList.RUBY_END_ORE.get());
        tag(ItemTagRegistry.RUBY_ORE_BLOCK).add(BlockList.RUBY_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.RUBY_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.RUBY_SLATE_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.RUBY_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.RUBY_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.RUBY_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_STONE).add(BlockList.RUBY_ORE.get());
        tag(ItemTagRegistry.IN_DEEPSLATE).add(BlockList.RUBY_SLATE_ORE.get());
        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.RUBY_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.RUBY_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.RUBY_OTHER_ORE.get());

        tag(ItemTagRegistry.RUBY_BLOCK_BLOCK).add(BlockList.RUBY_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.RUBY_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.RUBY_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.RUBY_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.RUBY_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.RUBY_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.RUBY_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.RUBY_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.RUBY_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.RUBY_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.RUBY_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.RUBY_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.RUBY_BLOCK.get());

        // **************** PERIDOT

        tag(ItemTagRegistry.PERIDOT_ORE_BLOCK).add(BlockList.PERIDOT_ORE.get());
        tag(ItemTagRegistry.PERIDOT_ORE_BLOCK).add(BlockList.PERIDOT_SLATE_ORE.get());
        tag(ItemTagRegistry.PERIDOT_ORE_BLOCK).add(BlockList.PERIDOT_NETHER_ORE.get());
        tag(ItemTagRegistry.PERIDOT_ORE_BLOCK).add(BlockList.PERIDOT_END_ORE.get());
        tag(ItemTagRegistry.PERIDOT_ORE_BLOCK).add(BlockList.PERIDOT_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.PERIDOT_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.PERIDOT_SLATE_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.PERIDOT_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.PERIDOT_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.PERIDOT_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_STONE).add(BlockList.PERIDOT_ORE.get());
        tag(ItemTagRegistry.IN_DEEPSLATE).add(BlockList.PERIDOT_SLATE_ORE.get());
        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.PERIDOT_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.PERIDOT_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.PERIDOT_OTHER_ORE.get());

        tag(ItemTagRegistry.PERIDOT_BLOCK_BLOCK).add(BlockList.PERIDOT_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.PERIDOT_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.PERIDOT_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.PERIDOT_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.PERIDOT_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.PERIDOT_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.PERIDOT_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.PERIDOT_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.PERIDOT_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.PERIDOT_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.PERIDOT_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.PERIDOT_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.PERIDOT_BLOCK.get());

        // **************** SAPPHIRE

        tag(ItemTagRegistry.SAPPHIRE_ORE_BLOCK).add(BlockList.SAPPHIRE_ORE.get());
        tag(ItemTagRegistry.SAPPHIRE_ORE_BLOCK).add(BlockList.SAPPHIRE_SLATE_ORE.get());
        tag(ItemTagRegistry.SAPPHIRE_ORE_BLOCK).add(BlockList.SAPPHIRE_NETHER_ORE.get());
        tag(ItemTagRegistry.SAPPHIRE_ORE_BLOCK).add(BlockList.SAPPHIRE_END_ORE.get());
        tag(ItemTagRegistry.SAPPHIRE_ORE_BLOCK).add(BlockList.SAPPHIRE_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SAPPHIRE_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SAPPHIRE_SLATE_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SAPPHIRE_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SAPPHIRE_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SAPPHIRE_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_STONE).add(BlockList.SAPPHIRE_ORE.get());
        tag(ItemTagRegistry.IN_DEEPSLATE).add(BlockList.SAPPHIRE_SLATE_ORE.get());
        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.SAPPHIRE_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.SAPPHIRE_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.SAPPHIRE_OTHER_ORE.get());

        tag(ItemTagRegistry.SAPPHIRE_BLOCK_BLOCK).add(BlockList.SAPPHIRE_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SAPPHIRE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SAPPHIRE_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SAPPHIRE_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SAPPHIRE_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SAPPHIRE_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SAPPHIRE_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SAPPHIRE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SAPPHIRE_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SAPPHIRE_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SAPPHIRE_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SAPPHIRE_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SAPPHIRE_BLOCK.get());

        // **************** CINNABAR

        tag(ItemTagRegistry.CINNABAR_ORE_BLOCK).add(BlockList.CINNABAR_ORE.get());
        tag(ItemTagRegistry.CINNABAR_ORE_BLOCK).add(BlockList.CINNABAR_SLATE_ORE.get());
        tag(ItemTagRegistry.CINNABAR_ORE_BLOCK).add(BlockList.CINNABAR_NETHER_ORE.get());
        tag(ItemTagRegistry.CINNABAR_ORE_BLOCK).add(BlockList.CINNABAR_END_ORE.get());
        tag(ItemTagRegistry.CINNABAR_ORE_BLOCK).add(BlockList.CINNABAR_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.CINNABAR_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.CINNABAR_SLATE_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.CINNABAR_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.CINNABAR_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.CINNABAR_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_STONE).add(BlockList.CINNABAR_ORE.get());
        tag(ItemTagRegistry.IN_DEEPSLATE).add(BlockList.CINNABAR_SLATE_ORE.get());
        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.CINNABAR_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.CINNABAR_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.CINNABAR_OTHER_ORE.get());

        tag(ItemTagRegistry.CINNABAR_BLOCK_BLOCK).add(BlockList.CINNABAR_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.CINNABAR_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.CINNABAR_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.CINNABAR_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.CINNABAR_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.CINNABAR_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.CINNABAR_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.CINNABAR_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.CINNABAR_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.CINNABAR_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.CINNABAR_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.CINNABAR_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.CINNABAR_BLOCK.get());

        // **************** FLUORITE

        tag(ItemTagRegistry.FLUORITE_ORE_BLOCK).add(BlockList.FLUORITE_ORE.get());
        tag(ItemTagRegistry.FLUORITE_ORE_BLOCK).add(BlockList.FLUORITE_SLATE_ORE.get());
        tag(ItemTagRegistry.FLUORITE_ORE_BLOCK).add(BlockList.FLUORITE_NETHER_ORE.get());
        tag(ItemTagRegistry.FLUORITE_ORE_BLOCK).add(BlockList.FLUORITE_END_ORE.get());
        tag(ItemTagRegistry.FLUORITE_ORE_BLOCK).add(BlockList.FLUORITE_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.FLUORITE_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.FLUORITE_SLATE_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.FLUORITE_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.FLUORITE_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.FLUORITE_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_STONE).add(BlockList.FLUORITE_ORE.get());
        tag(ItemTagRegistry.IN_DEEPSLATE).add(BlockList.FLUORITE_SLATE_ORE.get());
        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.FLUORITE_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.FLUORITE_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.FLUORITE_OTHER_ORE.get());

        tag(ItemTagRegistry.FLUORITE_BLOCK_BLOCK).add(BlockList.FLUORITE_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.FLUORITE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.FLUORITE_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.FLUORITE_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.FLUORITE_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.FLUORITE_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.FLUORITE_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.FLUORITE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.FLUORITE_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.FLUORITE_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.FLUORITE_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.FLUORITE_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.FLUORITE_BLOCK.get());

        // **************** SALT

        tag(ItemTagRegistry.SALT_ORE_BLOCK).add(BlockList.SALT_ORE.get());
        tag(ItemTagRegistry.SALT_ORE_BLOCK).add(BlockList.SALT_SLATE_ORE.get());
        tag(ItemTagRegistry.SALT_ORE_BLOCK).add(BlockList.SALT_NETHER_ORE.get());
        tag(ItemTagRegistry.SALT_ORE_BLOCK).add(BlockList.SALT_END_ORE.get());
        tag(ItemTagRegistry.SALT_ORE_BLOCK).add(BlockList.SALT_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SALT_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SALT_SLATE_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SALT_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SALT_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SALT_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_STONE).add(BlockList.SALT_ORE.get());
        tag(ItemTagRegistry.IN_DEEPSLATE).add(BlockList.SALT_SLATE_ORE.get());
        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.SALT_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.SALT_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.SALT_OTHER_ORE.get());

        tag(ItemTagRegistry.SALT_BLOCK_BLOCK).add(BlockList.SALT_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SALT_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SALT_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SALT_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SALT_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SALT_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SALT_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SALT_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SALT_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SALT_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SALT_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SALT_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SALT_BLOCK.get());

        // **************** SULFUR

        tag(ItemTagRegistry.SULFUR_ORE_BLOCK).add(BlockList.SULFUR_ORE.get());
        tag(ItemTagRegistry.SULFUR_ORE_BLOCK).add(BlockList.SULFUR_SLATE_ORE.get());
        tag(ItemTagRegistry.SULFUR_ORE_BLOCK).add(BlockList.SULFUR_NETHER_ORE.get());
        tag(ItemTagRegistry.SULFUR_ORE_BLOCK).add(BlockList.SULFUR_END_ORE.get());
        tag(ItemTagRegistry.SULFUR_ORE_BLOCK).add(BlockList.SULFUR_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SULFUR_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SULFUR_SLATE_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SULFUR_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SULFUR_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.SULFUR_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_STONE).add(BlockList.SULFUR_ORE.get());
        tag(ItemTagRegistry.IN_DEEPSLATE).add(BlockList.SULFUR_SLATE_ORE.get());
        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.SULFUR_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.SULFUR_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.SULFUR_OTHER_ORE.get());

        tag(ItemTagRegistry.SULFUR_BLOCK_BLOCK).add(BlockList.SULFUR_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SULFUR_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SULFUR_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SULFUR_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SULFUR_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SULFUR_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.SULFUR_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SULFUR_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SULFUR_SLATE_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SULFUR_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SULFUR_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SULFUR_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.SULFUR_BLOCK.get());

        // ###################### VANILLA

        // **************** COAL

        tag(ItemTagRegistry.COAL_ORE_BLOCK).add(BlockList.COAL_NETHER_ORE.get());
        tag(ItemTagRegistry.COAL_ORE_BLOCK).add(BlockList.COAL_END_ORE.get());
        tag(ItemTagRegistry.COAL_ORE_BLOCK).add(BlockList.COAL_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.COAL_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.COAL_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.COAL_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.COAL_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.COAL_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.COAL_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.COAL_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.COAL_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.COAL_OTHER_ORE.get());

        // **************** LAPIS

        tag(ItemTagRegistry.LAPIS_ORE_BLOCK).add(BlockList.LAPIS_NETHER_ORE.get());
        tag(ItemTagRegistry.LAPIS_ORE_BLOCK).add(BlockList.LAPIS_END_ORE.get());
        tag(ItemTagRegistry.LAPIS_ORE_BLOCK).add(BlockList.LAPIS_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.LAPIS_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.LAPIS_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.LAPIS_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.LAPIS_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.LAPIS_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.LAPIS_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.LAPIS_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.LAPIS_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.LAPIS_OTHER_ORE.get());

        // **************** REDSTONE

        tag(ItemTagRegistry.REDSTONE_ORE_BLOCK).add(BlockList.REDSTONE_NETHER_ORE.get());
        tag(ItemTagRegistry.REDSTONE_ORE_BLOCK).add(BlockList.REDSTONE_END_ORE.get());
        tag(ItemTagRegistry.REDSTONE_ORE_BLOCK).add(BlockList.REDSTONE_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.REDSTONE_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.REDSTONE_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.REDSTONE_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.REDSTONE_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.REDSTONE_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.REDSTONE_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.REDSTONE_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.REDSTONE_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.REDSTONE_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.REDSTONE_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.REDSTONE_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.REDSTONE_OTHER_ORE.get());

        // **************** EMERALD

        tag(ItemTagRegistry.EMERALD_ORE_BLOCK).add(BlockList.EMERALD_NETHER_ORE.get());
        tag(ItemTagRegistry.EMERALD_ORE_BLOCK).add(BlockList.EMERALD_END_ORE.get());
        tag(ItemTagRegistry.EMERALD_ORE_BLOCK).add(BlockList.EMERALD_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.EMERALD_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.EMERALD_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.EMERALD_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.EMERALD_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.EMERALD_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.EMERALD_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.EMERALD_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.EMERALD_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.EMERALD_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.EMERALD_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.EMERALD_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.EMERALD_OTHER_ORE.get());

        // **************** QUARTZ

        tag(ItemTagRegistry.QUARTZ_ORE_BLOCK).add(BlockList.QUARTZ_END_ORE.get());
        tag(ItemTagRegistry.QUARTZ_ORE_BLOCK).add(BlockList.QUARTZ_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.QUARTZ_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.QUARTZ_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.QUARTZ_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.QUARTZ_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.QUARTZ_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.QUARTZ_OTHER_ORE.get());

        // **************** IRON

        tag(ItemTagRegistry.IRON_ORE_BLOCK).add(BlockList.IRON_NETHER_ORE.get());
        tag(ItemTagRegistry.IRON_ORE_BLOCK).add(BlockList.IRON_END_ORE.get());
        tag(ItemTagRegistry.IRON_ORE_BLOCK).add(BlockList.IRON_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.IRON_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.IRON_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.IRON_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.IRON_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.IRON_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.IRON_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.IRON_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.IRON_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.IRON_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.IRON_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.IRON_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.IRON_OTHER_ORE.get());

        // **************** COPPER

        tag(ItemTagRegistry.COPPER_ORE_BLOCK).add(BlockList.COPPER_NETHER_ORE.get());
        tag(ItemTagRegistry.COPPER_ORE_BLOCK).add(BlockList.COPPER_END_ORE.get());
        tag(ItemTagRegistry.COPPER_ORE_BLOCK).add(BlockList.COPPER_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.COPPER_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.COPPER_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.COPPER_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.COPPER_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.COPPER_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.COPPER_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.COPPER_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.COPPER_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.COPPER_OTHER_ORE.get());

        // **************** GOLD

        tag(ItemTagRegistry.GOLD_ORE_BLOCK).add(BlockList.GOLD_END_ORE.get());
        tag(ItemTagRegistry.GOLD_ORE_BLOCK).add(BlockList.GOLD_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.GOLD_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.GOLD_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.GOLD_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.GOLD_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.GOLD_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.GOLD_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.GOLD_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.GOLD_OTHER_ORE.get());

        // **************** DIAMOND

        tag(ItemTagRegistry.DIAMOND_ORE_BLOCK).add(BlockList.DIAMOND_NETHER_ORE.get());
        tag(ItemTagRegistry.DIAMOND_ORE_BLOCK).add(BlockList.DIAMOND_END_ORE.get());
        tag(ItemTagRegistry.DIAMOND_ORE_BLOCK).add(BlockList.DIAMOND_OTHER_ORE.get());

        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.DIAMOND_NETHER_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.DIAMOND_END_ORE.get());
        tag(ItemTagRegistry.ORES_BLOCK).add(BlockList.DIAMOND_OTHER_ORE.get());

        tag(ItemTagRegistry.IN_NETHERRACK).add(BlockList.DIAMOND_NETHER_ORE.get());
        tag(ItemTagRegistry.IN_END_STONE).add(BlockList.DIAMOND_END_ORE.get());
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(BlockList.DIAMOND_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.DIAMOND_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.DIAMOND_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(BlockList.DIAMOND_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.DIAMOND_NETHER_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.DIAMOND_END_ORE.get());
        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL).add(BlockList.DIAMOND_OTHER_ORE.get());

    }

}
