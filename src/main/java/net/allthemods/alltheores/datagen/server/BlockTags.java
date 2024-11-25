package net.allthemods.alltheores.datagen.server;

import mekanism.common.registration.impl.BlockRegistryObject;
import net.allthemods.alltheores.blocks.BlockList;
import net.allthemods.alltheores.blocks.ore.*;
import net.allthemods.alltheores.infos.ItemTagRegistry;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BlockTags extends BlockTagsProvider {

    public BlockTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, Reference.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        // ###################### ALL THE ORES

        List<Block> blockList = new ArrayList<>();
        List<Block> oreList = new ArrayList<>();
        List<Block> stoneOreList = new ArrayList<>();
        List<Block> slateOreList = new ArrayList<>();
        List<Block> netherOreList = new ArrayList<>();
        List<Block> endOreList = new ArrayList<>();
        List<Block> otherOreList = new ArrayList<>();

        BlockList.BLOCKS.getEntries().forEach(blocks -> {
            Block block = blocks.get();
            blockList.add(block);
            if (block instanceof OreBlock) oreList.add(block);
            if (block instanceof StoneOreBlock) stoneOreList.add(block);
            if (block instanceof SlateOreBlock) slateOreList.add(block);
            if (block instanceof NetherOreBlock) netherOreList.add(block);
            if (block instanceof EndOreBlock) endOreList.add(block);
            if (block instanceof OtherOreBlock) otherOreList.add(block);
        });

        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE).add(blockList.toArray(new Block[0]));
        tag(ItemTagRegistry.ORES_BLOCK).add(oreList.toArray(new Block[0]));
        tag(ItemTagRegistry.IN_STONE).add(stoneOreList.toArray(new Block[0]));
        tag(ItemTagRegistry.IN_DEEPSLATE).add(slateOreList.toArray(new Block[0]));
        tag(ItemTagRegistry.IN_NETHERRACK).add(netherOreList.toArray(new Block[0]));
        tag(ItemTagRegistry.IN_END_STONE).add(endOreList.toArray(new Block[0]));
        tag(ItemTagRegistry.IN_ANCIENT_STONE).add(otherOreList.toArray(new Block[0]));

        // **************** ALUMINUM

        tag(ItemTagRegistry.ALUMINUM_ORE_BLOCK)
                .add(BlockList.ALUMINUM_ORE.get())
                .add(BlockList.ALUMINUM_SLATE_ORE.get())
                .add(BlockList.ALUMINUM_NETHER_ORE.get())
                .add(BlockList.ALUMINUM_END_ORE.get())
                .add(BlockList.ALUMINUM_OTHER_ORE.get());

        tag(ItemTagRegistry.ALUMINUM_RAW_BLOCK_BLOCK).add(BlockList.ALUMINUM_RAW_BLOCK.get());
        tag(ItemTagRegistry.ALUMINUM_BLOCK_BLOCK).add(BlockList.ALUMINUM_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL)
                .add(BlockList.ALUMINUM_ORE.get())
                .add(BlockList.ALUMINUM_SLATE_ORE.get())
                .add(BlockList.ALUMINUM_NETHER_ORE.get())
                .add(BlockList.ALUMINUM_END_ORE.get())
                .add(BlockList.ALUMINUM_OTHER_ORE.get())
                .add(BlockList.ALUMINUM_RAW_BLOCK.get());

        // **************** LEAD

        tag(ItemTagRegistry.LEAD_ORE_BLOCK)
                .add(BlockList.LEAD_ORE.get())
                .add(BlockList.LEAD_SLATE_ORE.get())
                .add(BlockList.LEAD_NETHER_ORE.get())
                .add(BlockList.LEAD_END_ORE.get())
                .add(BlockList.LEAD_OTHER_ORE.get());

        tag(ItemTagRegistry.LEAD_RAW_BLOCK_BLOCK).add(BlockList.LEAD_RAW_BLOCK.get());
        tag(ItemTagRegistry.LEAD_BLOCK_BLOCK).add(BlockList.LEAD_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL)
                .add(BlockList.LEAD_SLATE_ORE.get())
                .add(BlockList.LEAD_NETHER_ORE.get())
                .add(BlockList.LEAD_END_ORE.get())
                .add(BlockList.LEAD_OTHER_ORE.get())
                .add(BlockList.LEAD_RAW_BLOCK.get());

        // **************** NICKEL

        tag(ItemTagRegistry.NICKEL_ORE_BLOCK)
                .add(BlockList.NICKEL_ORE.get())
                .add(BlockList.NICKEL_SLATE_ORE.get())
                .add(BlockList.NICKEL_NETHER_ORE.get())
                .add(BlockList.NICKEL_END_ORE.get())
                .add(BlockList.NICKEL_OTHER_ORE.get());

        tag(ItemTagRegistry.NICKEL_RAW_BLOCK_BLOCK).add(BlockList.NICKEL_RAW_BLOCK.get());
        tag(ItemTagRegistry.NICKEL_BLOCK_BLOCK).add(BlockList.NICKEL_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL)
                .add(BlockList.NICKEL_ORE.get())
                .add(BlockList.NICKEL_SLATE_ORE.get())
                .add(BlockList.NICKEL_NETHER_ORE.get())
                .add(BlockList.NICKEL_END_ORE.get())
                .add(BlockList.NICKEL_OTHER_ORE.get())
                .add(BlockList.NICKEL_RAW_BLOCK.get());

        // **************** OSMIUM

        tag(ItemTagRegistry.OSMIUM_ORE_BLOCK)
                .add(BlockList.OSMIUM_ORE.get())
                .add(BlockList.OSMIUM_SLATE_ORE.get())
                .add(BlockList.OSMIUM_NETHER_ORE.get())
                .add(BlockList.OSMIUM_END_ORE.get())
                .add(BlockList.OSMIUM_OTHER_ORE.get());

        tag(ItemTagRegistry.OSMIUM_RAW_BLOCK_BLOCK).add(BlockList.OSMIUM_RAW_BLOCK.get());
        tag(ItemTagRegistry.OSMIUM_BLOCK_BLOCK).add(BlockList.OSMIUM_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL)
                .add(BlockList.OSMIUM_ORE.get())
                .add(BlockList.OSMIUM_SLATE_ORE.get())
                .add(BlockList.OSMIUM_NETHER_ORE.get())
                .add(BlockList.OSMIUM_END_ORE.get())
                .add(BlockList.OSMIUM_OTHER_ORE.get())
                .add(BlockList.OSMIUM_RAW_BLOCK.get());

        // **************** PLATINUM

        tag(ItemTagRegistry.PLATINUM_ORE_BLOCK)
                .add(BlockList.PLATINUM_ORE.get())
                .add(BlockList.PLATINUM_SLATE_ORE.get())
                .add(BlockList.PLATINUM_NETHER_ORE.get())
                .add(BlockList.PLATINUM_END_ORE.get())
                .add(BlockList.PLATINUM_OTHER_ORE.get());

        tag(ItemTagRegistry.PLATINUM_RAW_BLOCK_BLOCK).add(BlockList.PLATINUM_RAW_BLOCK.get());
        tag(ItemTagRegistry.PLATINUM_BLOCK_BLOCK).add(BlockList.PLATINUM_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL)
                .add(BlockList.PLATINUM_ORE.get())
                .add(BlockList.PLATINUM_SLATE_ORE.get())
                .add(BlockList.PLATINUM_NETHER_ORE.get())
                .add(BlockList.PLATINUM_END_ORE.get())
                .add(BlockList.PLATINUM_OTHER_ORE.get());

        // **************** SILVER

        tag(ItemTagRegistry.SILVER_ORE_BLOCK).add(BlockList.SILVER_ORE.get())
                .add(BlockList.SILVER_SLATE_ORE.get())
                .add(BlockList.SILVER_NETHER_ORE.get())
                .add(BlockList.SILVER_END_ORE.get())
                .add(BlockList.SILVER_OTHER_ORE.get());

        tag(ItemTagRegistry.SILVER_RAW_BLOCK_BLOCK).add(BlockList.SILVER_RAW_BLOCK.get());
        tag(ItemTagRegistry.SILVER_BLOCK_BLOCK).add(BlockList.SILVER_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL)
                .add(BlockList.SILVER_ORE.get())
                .add(BlockList.SILVER_SLATE_ORE.get())
                .add(BlockList.SILVER_NETHER_ORE.get())
                .add(BlockList.SILVER_END_ORE.get())
                .add(BlockList.SILVER_OTHER_ORE.get())
                .add(BlockList.SILVER_RAW_BLOCK.get());

        // **************** TIN

        tag(ItemTagRegistry.TIN_ORE_BLOCK)
                .add(BlockList.TIN_ORE.get())
                .add(BlockList.TIN_SLATE_ORE.get())
                .add(BlockList.TIN_NETHER_ORE.get())
                .add(BlockList.TIN_END_ORE.get())
                .add(BlockList.TIN_OTHER_ORE.get());

        tag(ItemTagRegistry.TIN_RAW_BLOCK_BLOCK).add(BlockList.TIN_RAW_BLOCK.get());
        tag(ItemTagRegistry.TIN_BLOCK_BLOCK).add(BlockList.TIN_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL)
                .add(BlockList.TIN_ORE.get())
                .add(BlockList.TIN_SLATE_ORE.get())
                .add(BlockList.TIN_NETHER_ORE.get())
                .add(BlockList.TIN_END_ORE.get())
                .add(BlockList.TIN_OTHER_ORE.get())
                .add(BlockList.TIN_RAW_BLOCK.get());

        // **************** URANIUM

        tag(ItemTagRegistry.URANIUM_ORE_BLOCK)
                .add(BlockList.URANIUM_ORE.get())
                .add(BlockList.URANIUM_SLATE_ORE.get())
                .add(BlockList.URANIUM_NETHER_ORE.get())
                .add(BlockList.URANIUM_END_ORE.get())
                .add(BlockList.URANIUM_OTHER_ORE.get());

        tag(ItemTagRegistry.URANIUM_RAW_BLOCK_BLOCK).add(BlockList.URANIUM_RAW_BLOCK.get());
        tag(ItemTagRegistry.URANIUM_BLOCK_BLOCK).add(BlockList.URANIUM_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL).add(BlockList.URANIUM_ORE.get())
                .add(BlockList.URANIUM_SLATE_ORE.get())
                .add(BlockList.URANIUM_NETHER_ORE.get())
                .add(BlockList.URANIUM_END_ORE.get())
                .add(BlockList.URANIUM_OTHER_ORE.get())
                .add(BlockList.URANIUM_RAW_BLOCK.get());

        // **************** ZINC

        tag(ItemTagRegistry.ZINC_ORE_BLOCK)
                .add(BlockList.ZINC_ORE.get())
                .add(BlockList.ZINC_SLATE_ORE.get())
                .add(BlockList.ZINC_NETHER_ORE.get())
                .add(BlockList.ZINC_END_ORE.get())
                .add(BlockList.ZINC_OTHER_ORE.get());

        tag(ItemTagRegistry.ZINC_RAW_BLOCK_BLOCK).add(BlockList.ZINC_RAW_BLOCK.get());
        tag(ItemTagRegistry.ZINC_BLOCK_BLOCK).add(BlockList.ZINC_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL)
                .add(BlockList.ZINC_ORE.get())
                .add(BlockList.ZINC_SLATE_ORE.get())
                .add(BlockList.ZINC_NETHER_ORE.get())
                .add(BlockList.ZINC_END_ORE.get())
                .add(BlockList.ZINC_OTHER_ORE.get())
                .add(BlockList.ZINC_RAW_BLOCK.get());

        // **************** IRIDIUM

        tag(ItemTagRegistry.IRIDIUM_ORE_BLOCK)
                .add(BlockList.IRIDIUM_ORE.get())
                .add(BlockList.IRIDIUM_SLATE_ORE.get())
                .add(BlockList.IRIDIUM_NETHER_ORE.get())
                .add(BlockList.IRIDIUM_END_ORE.get())
                .add(BlockList.IRIDIUM_OTHER_ORE.get());

        tag(ItemTagRegistry.IRIDIUM_RAW_BLOCK_BLOCK).add(BlockList.IRIDIUM_RAW_BLOCK.get());
        tag(ItemTagRegistry.IRIDIUM_BLOCK_BLOCK).add(BlockList.IRIDIUM_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL)
                .add(BlockList.IRIDIUM_ORE.get())
                .add(BlockList.IRIDIUM_SLATE_ORE.get())
                .add(BlockList.IRIDIUM_NETHER_ORE.get())
                .add(BlockList.IRIDIUM_END_ORE.get())
                .add(BlockList.IRIDIUM_OTHER_ORE.get())
                .add(BlockList.IRIDIUM_RAW_BLOCK.get());

        // ###################### ALLOYS

        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL)
                .add(BlockList.BRONZE_BLOCK.get())
                .add(BlockList.BRASS_BLOCK.get())
                .add(BlockList.STEEL_BLOCK.get())
                .add(BlockList.INVAR_BLOCK.get())
                .add(BlockList.CONSTANTAN_BLOCK.get())
                .add(BlockList.ELECTRUM_BLOCK.get())
                .add(BlockList.ENDERIUM_BLOCK.get())
                .add(BlockList.LUMIUM_BLOCK.get())
                .add(BlockList.SIGNALUM_BLOCK.get());

        // **************** BRONZE

        tag(ItemTagRegistry.BRONZE_BLOCK_BLOCK).add(BlockList.BRONZE_BLOCK.get());

        // **************** BRASS

        tag(ItemTagRegistry.BRASS_BLOCK_BLOCK).add(BlockList.BRASS_BLOCK.get());

        // **************** STEEL

        tag(ItemTagRegistry.STEEL_BLOCK_BLOCK).add(BlockList.STEEL_BLOCK.get());

        // **************** INVAR

        tag(ItemTagRegistry.INVAR_BLOCK_BLOCK).add(BlockList.INVAR_BLOCK.get());

        // **************** CONSTANTAN

        tag(ItemTagRegistry.CONSTANTAN_BLOCK_BLOCK).add(BlockList.CONSTANTAN_BLOCK.get());

        // **************** ELECTRUM

        tag(ItemTagRegistry.ELECTRUM_BLOCK_BLOCK).add(BlockList.ELECTRUM_BLOCK.get());

        // **************** ENDERIUM

        tag(ItemTagRegistry.ENDERIUM_BLOCK_BLOCK).add(BlockList.ENDERIUM_BLOCK.get());

        // **************** LUMIUM

        tag(ItemTagRegistry.LUMIUM_BLOCK_BLOCK).add(BlockList.LUMIUM_BLOCK.get());

        // **************** SIGNALUM

        tag(ItemTagRegistry.SIGNALUM_BLOCK_BLOCK).add(BlockList.SIGNALUM_BLOCK.get());

        // ###################### GEMS

        // **************** RUBY

        tag(ItemTagRegistry.RUBY_ORE_BLOCK)
                .add(BlockList.RUBY_ORE.get())
                .add(BlockList.RUBY_SLATE_ORE.get())
                .add(BlockList.RUBY_NETHER_ORE.get())
                .add(BlockList.RUBY_END_ORE.get())
                .add(BlockList.RUBY_OTHER_ORE.get());

        tag(ItemTagRegistry.RUBY_BLOCK_BLOCK).add(BlockList.RUBY_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL)
                .add(BlockList.RUBY_ORE.get())
                .add(BlockList.RUBY_SLATE_ORE.get())
                .add(BlockList.RUBY_NETHER_ORE.get())
                .add(BlockList.RUBY_END_ORE.get())
                .add(BlockList.RUBY_OTHER_ORE.get())
                .add(BlockList.RUBY_BLOCK.get());

        // **************** PERIDOT

        tag(ItemTagRegistry.PERIDOT_ORE_BLOCK)
                .add(BlockList.PERIDOT_ORE.get())
                .add(BlockList.PERIDOT_SLATE_ORE.get())
                .add(BlockList.PERIDOT_NETHER_ORE.get())
                .add(BlockList.PERIDOT_END_ORE.get())
                .add(BlockList.PERIDOT_OTHER_ORE.get());

        tag(ItemTagRegistry.PERIDOT_BLOCK_BLOCK).add(BlockList.PERIDOT_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL)
                .add(BlockList.PERIDOT_ORE.get())
                .add(BlockList.PERIDOT_SLATE_ORE.get())
                .add(BlockList.PERIDOT_NETHER_ORE.get())
                .add(BlockList.PERIDOT_END_ORE.get())
                .add(BlockList.PERIDOT_OTHER_ORE.get());

        // **************** SAPPHIRE

        tag(ItemTagRegistry.SAPPHIRE_ORE_BLOCK)
                .add(BlockList.SAPPHIRE_ORE.get())
                .add(BlockList.SAPPHIRE_SLATE_ORE.get())
                .add(BlockList.SAPPHIRE_NETHER_ORE.get())
                .add(BlockList.SAPPHIRE_END_ORE.get())
                .add(BlockList.SAPPHIRE_OTHER_ORE.get());

        tag(ItemTagRegistry.SAPPHIRE_BLOCK_BLOCK).add(BlockList.SAPPHIRE_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL)
                .add(BlockList.SAPPHIRE_ORE.get())
                .add(BlockList.SAPPHIRE_SLATE_ORE.get())
                .add(BlockList.SAPPHIRE_NETHER_ORE.get())
                .add(BlockList.SAPPHIRE_END_ORE.get())
                .add(BlockList.SAPPHIRE_OTHER_ORE.get());


        // **************** CINNABAR

        tag(ItemTagRegistry.CINNABAR_ORE_BLOCK)
                .add(BlockList.CINNABAR_ORE.get())
                .add(BlockList.CINNABAR_SLATE_ORE.get())
                .add(BlockList.CINNABAR_NETHER_ORE.get())
                .add(BlockList.CINNABAR_END_ORE.get())
                .add(BlockList.CINNABAR_OTHER_ORE.get());

        tag(ItemTagRegistry.CINNABAR_BLOCK_BLOCK).add(BlockList.CINNABAR_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL)
                .add(BlockList.CINNABAR_ORE.get())
                .add(BlockList.CINNABAR_SLATE_ORE.get())
                .add(BlockList.CINNABAR_NETHER_ORE.get())
                .add(BlockList.CINNABAR_END_ORE.get())
                .add(BlockList.CINNABAR_OTHER_ORE.get());

        // **************** FLUORITE

        tag(ItemTagRegistry.FLUORITE_ORE_BLOCK)
                .add(BlockList.FLUORITE_ORE.get())
                .add(BlockList.FLUORITE_SLATE_ORE.get())
                .add(BlockList.FLUORITE_NETHER_ORE.get())
                .add(BlockList.FLUORITE_END_ORE.get())
                .add(BlockList.FLUORITE_OTHER_ORE.get());

        tag(ItemTagRegistry.FLUORITE_BLOCK_BLOCK).add(BlockList.FLUORITE_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL)
                .add(BlockList.FLUORITE_ORE.get())
                .add(BlockList.FLUORITE_SLATE_ORE.get())
                .add(BlockList.FLUORITE_NETHER_ORE.get())
                .add(BlockList.FLUORITE_END_ORE.get())
                .add(BlockList.FLUORITE_OTHER_ORE.get());


        // **************** SALT

        tag(ItemTagRegistry.SALT_ORE_BLOCK)
                .add(BlockList.SALT_ORE.get())
                .add(BlockList.SALT_SLATE_ORE.get())
                .add(BlockList.SALT_NETHER_ORE.get())
                .add(BlockList.SALT_END_ORE.get())
                .add(BlockList.SALT_OTHER_ORE.get());

        tag(ItemTagRegistry.SALT_BLOCK_BLOCK).add(BlockList.SALT_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL)
                .add(BlockList.SALT_ORE.get())
                .add(BlockList.SALT_SLATE_ORE.get())
                .add(BlockList.SALT_NETHER_ORE.get())
                .add(BlockList.SALT_END_ORE.get())
                .add(BlockList.SALT_OTHER_ORE.get());

        // **************** SULFUR

        tag(ItemTagRegistry.SULFUR_ORE_BLOCK)
                .add(BlockList.SULFUR_ORE.get())
                .add(BlockList.SULFUR_SLATE_ORE.get())
                .add(BlockList.SULFUR_NETHER_ORE.get())
                .add(BlockList.SULFUR_END_ORE.get())
                .add(BlockList.SULFUR_OTHER_ORE.get());

        tag(ItemTagRegistry.SULFUR_BLOCK_BLOCK).add(BlockList.SULFUR_BLOCK.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_STONE_TOOL)
                .add(BlockList.SULFUR_ORE.get())
                .add(BlockList.SULFUR_SLATE_ORE.get())
                .add(BlockList.SULFUR_NETHER_ORE.get())
                .add(BlockList.SULFUR_END_ORE.get())
                .add(BlockList.SULFUR_OTHER_ORE.get());

        // ###################### VANILLA

        // **************** COAL

        tag(ItemTagRegistry.COAL_ORE_BLOCK)
                .add(BlockList.COAL_NETHER_ORE.get())
                .add(BlockList.COAL_END_ORE.get())
                .add(BlockList.COAL_OTHER_ORE.get());

        // **************** LAPIS

        tag(ItemTagRegistry.LAPIS_ORE_BLOCK)
                .add(BlockList.LAPIS_NETHER_ORE.get())
                .add(BlockList.LAPIS_END_ORE.get())
                .add(BlockList.LAPIS_OTHER_ORE.get());

        // **************** REDSTONE

        tag(ItemTagRegistry.REDSTONE_ORE_BLOCK)
                .add(BlockList.REDSTONE_NETHER_ORE.get())
                .add(BlockList.REDSTONE_END_ORE.get())
                .add(BlockList.REDSTONE_OTHER_ORE.get());

        // **************** EMERALD

        tag(ItemTagRegistry.EMERALD_ORE_BLOCK)
                .add(BlockList.EMERALD_NETHER_ORE.get())
                .add(BlockList.EMERALD_END_ORE.get())
                .add(BlockList.EMERALD_OTHER_ORE.get());

        // **************** QUARTZ

        tag(ItemTagRegistry.QUARTZ_ORE_BLOCK)
                .add(BlockList.QUARTZ_END_ORE.get())
                .add(BlockList.QUARTZ_OTHER_ORE.get());

        // **************** IRON

        tag(ItemTagRegistry.IRON_ORE_BLOCK)
                .add(BlockList.IRON_NETHER_ORE.get())
                .add(BlockList.IRON_END_ORE.get())
                .add(BlockList.IRON_OTHER_ORE.get());

        // **************** COPPER

        tag(ItemTagRegistry.COPPER_ORE_BLOCK)
                .add(BlockList.COPPER_NETHER_ORE.get())
                .add(BlockList.COPPER_END_ORE.get())
                .add(BlockList.COPPER_OTHER_ORE.get());

        // **************** GOLD

        tag(ItemTagRegistry.GOLD_ORE_BLOCK)
                .add(BlockList.GOLD_END_ORE.get())
                .add(BlockList.GOLD_OTHER_ORE.get());

        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL)
                .add(BlockList.GOLD_END_ORE.get())
                .add(BlockList.GOLD_OTHER_ORE.get());

        // **************** DIAMOND

        tag(ItemTagRegistry.DIAMOND_ORE_BLOCK)
                .add(BlockList.DIAMOND_NETHER_ORE.get())
                .add(BlockList.DIAMOND_END_ORE.get())
                .add(BlockList.DIAMOND_OTHER_ORE.get());;

        tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL)
                .add(BlockList.DIAMOND_NETHER_ORE.get())
                .add(BlockList.DIAMOND_END_ORE.get())
                .add(BlockList.DIAMOND_OTHER_ORE.get());

    }

}
