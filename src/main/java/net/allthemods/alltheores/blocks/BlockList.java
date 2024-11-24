package net.allthemods.alltheores.blocks;

import net.allthemods.alltheores.blocks.ore.*;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.infos.TranslationKey;
import net.allthemods.alltheores.items.OreHammer;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockList {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Reference.MOD_ID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reference.MOD_ID);

    public static final ResourceLocation MOLTEN_STILL = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/fluid/molten_metal");
    public static final ResourceLocation MOLTEN_FLOW = ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "block/fluid/molten_metal_flow");

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = CREATIVE_TABS.register("creative_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable(TranslationKey.tab()))
            .icon(() -> BlockList.ALUMINUM_NETHER_ORE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> ITEMS.getEntries().stream()
                    .map(DeferredHolder::get)
                    .map(Item::getDefaultInstance)
                    .forEach(output::accept))
            .build()
    );

    // ###################### ALL THE ORES

    // ********************** ALUMINUM
    public static final DeferredBlock<Block> ALUMINUM_ORE = BLOCKS.register("aluminum_ore", StoneOreBlock::new);
    public static final DeferredItem<Item> ALUMINUM_ORE_ITEM = ITEMS.register("aluminum_ore", () -> basicToolTipBlockItem(ALUMINUM_ORE.get()));
    public static final DeferredBlock<Block> ALUMINUM_SLATE_ORE = BLOCKS.register("deepslate_aluminum_ore", SlateOreBlock::new);
    public static final DeferredItem<Item> ALUMINUM_SLATE_ORE_ITEM = ITEMS.register("deepslate_aluminum_ore", () -> basicToolTipBlockItem(ALUMINUM_SLATE_ORE.get()));
    public static final DeferredBlock<Block> OTHER_ALUMINUM_ORE = BLOCKS.register("other_aluminum_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_ALUMINUM_ORE_ITEM = ITEMS.register("other_aluminum_ore", () -> basicToolTipBlockItem(OTHER_ALUMINUM_ORE.get()));
    public static final DeferredBlock<Block> ALUMINUM_NETHER_ORE = BLOCKS.register("nether_aluminum_ore", NetherOreBlock::new);
    public static final DeferredItem<Item> ALUMINUM_NETHER_ORE_ITEM = ITEMS.register("nether_aluminum_ore", () -> basicToolTipBlockItem(ALUMINUM_NETHER_ORE.get()));
    public static final DeferredBlock<Block> ALUMINUM_END_ORE = BLOCKS.register("end_aluminum_ore", EndOreBlock::new);
    public static final DeferredItem<Item> ALUMINUM_END_ORE_ITEM = ITEMS.register("end_aluminum_ore", () -> basicToolTipBlockItem(ALUMINUM_END_ORE.get()));

    public static final DeferredBlock<Block> RAW_ALUMINUM_BLOCK = BLOCKS.register("raw_aluminum_block", BlockList::rawBlock);
    public static final DeferredItem<Item> RAW_ALUMINUM_BLOCK_ITEM = ITEMS.register("raw_aluminum_block", () -> basicBlockItem(RAW_ALUMINUM_BLOCK.get()));

    public static final DeferredItem<Item> ALUMINUM_NUGGET = ITEMS.register("aluminum_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", BlockList::basicItem);

    public static final DeferredBlock<Block> ALUMINUM_BLOCK = BLOCKS.register("aluminum_block", BlockList::metalBlock);
    public static final DeferredItem<Item> ALUMINUM_BLOCK_ITEM = ITEMS.register("aluminum_block", () -> basicBlockItem(ALUMINUM_BLOCK.get()));

    public static final DeferredItem<Item> ALUMINUM_RAW = ITEMS.register("raw_aluminum", BlockList::basicItem);
    public static final DeferredItem<Item> ALUMINUM_DUST = ITEMS.register("aluminum_dust", BlockList::basicItem);
    public static final DeferredItem<Item> ALUMINUM_ROD = ITEMS.register("aluminum_rod", BlockList::basicItem);
    public static final DeferredItem<Item> ALUMINUM_GEAR = ITEMS.register("aluminum_gear", BlockList::basicItem);
    public static final DeferredItem<Item> ALUMINUM_PLATE = ITEMS.register("aluminum_plate", BlockList::basicItem);

    // ********************** LEAD

    public static final DeferredBlock<Block> LEAD_ORE = BLOCKS.register("lead_ore", StoneOreBlock::new);
    public static final DeferredItem<Item> LEAD_ORE_ITEM = ITEMS.register("lead_ore", () -> basicToolTipBlockItem(LEAD_ORE.get()));
    public static final DeferredBlock<Block> LEAD_SLATE_ORE = BLOCKS.register("deepslate_lead_ore", SlateOreBlock::new);
    public static final DeferredItem<Item> LEAD_SLATE_ORE_ITEM = ITEMS.register("deepslate_lead_ore", () -> basicToolTipBlockItem(LEAD_SLATE_ORE.get()));
    public static final DeferredBlock<Block> OTHER_LEAD_ORE = BLOCKS.register("other_lead_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_LEAD_ORE_ITEM = ITEMS.register("other_lead_ore", () -> basicToolTipBlockItem(OTHER_LEAD_ORE.get()));
    public static final DeferredBlock<Block> LEAD_NETHER_ORE = BLOCKS.register("nether_lead_ore", NetherOreBlock::new);
    public static final DeferredItem<Item> LEAD_NETHER_ORE_ITEM = ITEMS.register("nether_lead_ore", () -> basicToolTipBlockItem(LEAD_NETHER_ORE.get()));
    public static final DeferredBlock<Block> LEAD_END_ORE = BLOCKS.register("end_lead_ore", EndOreBlock::new);
    public static final DeferredItem<Item> LEAD_END_ORE_ITEM = ITEMS.register("end_lead_ore", () -> basicToolTipBlockItem(LEAD_END_ORE.get()));

    public static final DeferredBlock<Block> RAW_LEAD_BLOCK = BLOCKS.register("raw_lead_block", BlockList::rawBlock);
    public static final DeferredItem<Item> RAW_LEAD_BLOCK_ITEM = ITEMS.register("raw_lead_block", () -> basicBlockItem(RAW_LEAD_BLOCK.get()));

    public static final DeferredItem<Item> LEAD_NUGGET = ITEMS.register("lead_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> LEAD_INGOT = ITEMS.register("lead_ingot", BlockList::basicItem);

    public static final DeferredBlock<Block> LEAD_BLOCK = BLOCKS.register("lead_block", BlockList::metalBlock);
    public static final DeferredItem<Item> LEAD_BLOCK_ITEM = ITEMS.register("lead_block", () -> basicBlockItem(LEAD_BLOCK.get()));

    public static final DeferredItem<Item> LEAD_RAW = ITEMS.register("raw_lead", BlockList::basicItem);
    public static final DeferredItem<Item> LEAD_DUST = ITEMS.register("lead_dust", BlockList::basicItem);
    public static final DeferredItem<Item> LEAD_ROD = ITEMS.register("lead_rod", BlockList::basicItem);
    public static final DeferredItem<Item> LEAD_GEAR = ITEMS.register("lead_gear", BlockList::basicItem);
    public static final DeferredItem<Item> LEAD_PLATE = ITEMS.register("lead_plate", BlockList::basicItem);

    // ********************** NICKEL

    public static final DeferredBlock<Block> NICKEL_ORE = BLOCKS.register("nickel_ore", StoneOreBlock::new);
    public static final DeferredItem<Item> NICKEL_ORE_ITEM = ITEMS.register("nickel_ore", () -> basicToolTipBlockItem(NICKEL_ORE.get()));
    public static final DeferredBlock<Block> NICKEL_SLATE_ORE = BLOCKS.register("deepslate_nickel_ore", SlateOreBlock::new);
    public static final DeferredItem<Item> NICKEL_SLATE_ORE_ITEM = ITEMS.register("deepslate_nickel_ore", () -> basicToolTipBlockItem(NICKEL_SLATE_ORE.get()));
    public static final DeferredBlock<Block> OTHER_NICKEL_ORE = BLOCKS.register("other_nickel_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_NICKEL_ORE_ITEM = ITEMS.register("other_nickel_ore", () -> basicToolTipBlockItem(OTHER_NICKEL_ORE.get()));
    public static final DeferredBlock<Block> NICKEL_NETHER_ORE = BLOCKS.register("nether_nickel_ore", NetherOreBlock::new);
    public static final DeferredItem<Item> NICKEL_NETHER_ORE_ITEM = ITEMS.register("nether_nickel_ore", () -> basicToolTipBlockItem(NICKEL_NETHER_ORE.get()));
    public static final DeferredBlock<Block> NICKEL_END_ORE = BLOCKS.register("end_nickel_ore", EndOreBlock::new);
    public static final DeferredItem<Item> NICKEL_END_ORE_ITEM = ITEMS.register("end_nickel_ore", () -> basicToolTipBlockItem(NICKEL_END_ORE.get()));

    public static final DeferredBlock<Block> RAW_NICKEL_BLOCK = BLOCKS.register("raw_nickel_block", BlockList::rawBlock);
    public static final DeferredItem<Item> RAW_NICKEL_BLOCK_ITEM = ITEMS.register("raw_nickel_block", () -> basicBlockItem(RAW_NICKEL_BLOCK.get()));

    public static final DeferredItem<Item> NICKEL_NUGGET = ITEMS.register("nickel_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot", BlockList::basicItem);

    public static final DeferredBlock<Block> NICKEL_BLOCK = BLOCKS.register("nickel_block", BlockList::metalBlock);
    public static final DeferredItem<Item> NICKEL_BLOCK_ITEM = ITEMS.register("nickel_block", () -> basicBlockItem(NICKEL_BLOCK.get()));

    public static final DeferredItem<Item> NICKEL_RAW = ITEMS.register("raw_nickel", BlockList::basicItem);
    public static final DeferredItem<Item> NICKEL_DUST = ITEMS.register("nickel_dust", BlockList::basicItem);
    public static final DeferredItem<Item> NICKEL_ROD = ITEMS.register("nickel_rod", BlockList::basicItem);
    public static final DeferredItem<Item> NICKEL_GEAR = ITEMS.register("nickel_gear", BlockList::basicItem);
    public static final DeferredItem<Item> NICKEL_PLATE = ITEMS.register("nickel_plate", BlockList::basicItem);

    // ********************** OSMIUM

    public static final DeferredBlock<Block> OSMIUM_ORE = BLOCKS.register("osmium_ore", StoneOreBlock::new);
    public static final DeferredItem<Item> OSMIUM_ORE_ITEM = ITEMS.register("osmium_ore", () -> basicToolTipBlockItem(OSMIUM_ORE.get()));
    public static final DeferredBlock<Block> OSMIUM_SLATE_ORE = BLOCKS.register("deepslate_osmium_ore", SlateOreBlock::new);
    public static final DeferredItem<Item> OSMIUM_SLATE_ORE_ITEM = ITEMS.register("deepslate_osmium_ore", () -> basicToolTipBlockItem(OSMIUM_SLATE_ORE.get()));
    public static final DeferredBlock<Block> OTHER_OSMIUM_ORE = BLOCKS.register("other_osmium_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_OSMIUM_ORE_ITEM = ITEMS.register("other_osmium_ore", () -> basicToolTipBlockItem(OTHER_OSMIUM_ORE.get()));
    public static final DeferredBlock<Block> OSMIUM_NETHER_ORE = BLOCKS.register("nether_osmium_ore", NetherOreBlock::new);
    public static final DeferredItem<Item> OSMIUM_NETHER_ORE_ITEM = ITEMS.register("nether_osmium_ore", () -> basicToolTipBlockItem(OSMIUM_NETHER_ORE.get()));
    public static final DeferredBlock<Block> OSMIUM_END_ORE = BLOCKS.register("end_osmium_ore", EndOreBlock::new);
    public static final DeferredItem<Item> OSMIUM_END_ORE_ITEM = ITEMS.register("end_osmium_ore", () -> basicToolTipBlockItem(OSMIUM_END_ORE.get()));

    public static final DeferredBlock<Block> RAW_OSMIUM_BLOCK = BLOCKS.register("raw_osmium_block", BlockList::rawBlock);
    public static final DeferredItem<Item> RAW_OSMIUM_BLOCK_ITEM = ITEMS.register("raw_osmium_block", () -> basicBlockItem(RAW_OSMIUM_BLOCK.get()));

    public static final DeferredItem<Item> OSMIUM_NUGGET = ITEMS.register("osmium_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot", BlockList::basicItem);

    public static final DeferredBlock<Block> OSMIUM_BLOCK = BLOCKS.register("osmium_block", BlockList::metalBlock);
    public static final DeferredItem<Item> OSMIUM_BLOCK_ITEM = ITEMS.register("osmium_block", () -> basicBlockItem(OSMIUM_BLOCK.get()));

    public static final DeferredItem<Item> OSMIUM_RAW = ITEMS.register("raw_osmium", BlockList::basicItem);
    public static final DeferredItem<Item> OSMIUM_DUST = ITEMS.register("osmium_dust", BlockList::basicItem);
    public static final DeferredItem<Item> OSMIUM_ROD = ITEMS.register("osmium_rod", BlockList::basicItem);
    public static final DeferredItem<Item> OSMIUM_GEAR = ITEMS.register("osmium_gear", BlockList::basicItem);
    public static final DeferredItem<Item> OSMIUM_PLATE = ITEMS.register("osmium_plate", BlockList::basicItem);

    // ********************** PLATINUM

    public static final DeferredBlock<Block> PLATINUM_ORE = BLOCKS.register("platinum_ore", StoneOreBlock::new);
    public static final DeferredItem<Item> PLATINUM_ORE_ITEM = ITEMS.register("platinum_ore", () -> basicToolTipBlockItem(PLATINUM_ORE.get()));
    public static final DeferredBlock<Block> PLATINUM_SLATE_ORE = BLOCKS.register("deepslate_platinum_ore", SlateOreBlock::new);
    public static final DeferredItem<Item> PLATINUM_SLATE_ORE_ITEM = ITEMS.register("deepslate_platinum_ore", () -> basicToolTipBlockItem(PLATINUM_SLATE_ORE.get()));
    public static final DeferredBlock<Block> OTHER_PLATINUM_ORE = BLOCKS.register("other_platinum_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_PLATINUM_ORE_ITEM = ITEMS.register("other_platinum_ore", () -> basicToolTipBlockItem(OTHER_PLATINUM_ORE.get()));
    public static final DeferredBlock<Block> PLATINUM_NETHER_ORE = BLOCKS.register("nether_platinum_ore", NetherOreBlock::new);
    public static final DeferredItem<Item> PLATINUM_NETHER_ORE_ITEM = ITEMS.register("nether_platinum_ore", () -> basicToolTipBlockItem(PLATINUM_NETHER_ORE.get()));
    public static final DeferredBlock<Block> PLATINUM_END_ORE = BLOCKS.register("end_platinum_ore", EndOreBlock::new);
    public static final DeferredItem<Item> PLATINUM_END_ORE_ITEM = ITEMS.register("end_platinum_ore", () -> basicToolTipBlockItem(PLATINUM_END_ORE.get()));

    public static final DeferredBlock<Block> RAW_PLATINUM_BLOCK = BLOCKS.register("raw_platinum_block", BlockList::rawBlock);
    public static final DeferredItem<Item> RAW_PLATINUM_BLOCK_ITEM = ITEMS.register("raw_platinum_block", () -> basicBlockItem(RAW_PLATINUM_BLOCK.get()));

    public static final DeferredItem<Item> PLATINUM_NUGGET = ITEMS.register("platinum_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", BlockList::basicItem);

    public static final DeferredBlock<Block> PLATINUM_BLOCK = BLOCKS.register("platinum_block", BlockList::metalBlock);
    public static final DeferredItem<Item> PLATINUM_BLOCK_ITEM = ITEMS.register("platinum_block", () -> basicBlockItem(PLATINUM_BLOCK.get()));

    public static final DeferredItem<Item> PLATINUM_RAW = ITEMS.register("raw_platinum", BlockList::basicItem);
    public static final DeferredItem<Item> PLATINUM_DUST = ITEMS.register("platinum_dust", BlockList::basicItem);
    public static final DeferredItem<Item> PLATINUM_ROD = ITEMS.register("platinum_rod", BlockList::basicItem);
    public static final DeferredItem<Item> PLATINUM_GEAR = ITEMS.register("platinum_gear", BlockList::basicItem);
    public static final DeferredItem<Item> PLATINUM_PLATE = ITEMS.register("platinum_plate", BlockList::basicItem);

    // ********************** SILVER

    public static final DeferredBlock<Block> SILVER_ORE = BLOCKS.register("silver_ore", StoneOreBlock::new);
    public static final DeferredItem<Item> SILVER_ORE_ITEM = ITEMS.register("silver_ore", () -> basicToolTipBlockItem(SILVER_ORE.get()));
    public static final DeferredBlock<Block> SILVER_SLATE_ORE = BLOCKS.register("deepslate_silver_ore", SlateOreBlock::new);
    public static final DeferredItem<Item> SILVER_SLATE_ORE_ITEM = ITEMS.register("deepslate_silver_ore", () -> basicToolTipBlockItem(SILVER_SLATE_ORE.get()));
    public static final DeferredBlock<Block> OTHER_SILVER_ORE = BLOCKS.register("other_silver_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_SILVER_ORE_ITEM = ITEMS.register("other_silver_ore", () -> basicToolTipBlockItem(OTHER_SILVER_ORE.get()));
    public static final DeferredBlock<Block> SILVER_NETHER_ORE = BLOCKS.register("nether_silver_ore", NetherOreBlock::new);
    public static final DeferredItem<Item> SILVER_NETHER_ORE_ITEM = ITEMS.register("nether_silver_ore", () -> basicToolTipBlockItem(SILVER_NETHER_ORE.get()));
    public static final DeferredBlock<Block> SILVER_END_ORE = BLOCKS.register("end_silver_ore", EndOreBlock::new);
    public static final DeferredItem<Item> SILVER_END_ORE_ITEM = ITEMS.register("end_silver_ore", () -> basicToolTipBlockItem(SILVER_END_ORE.get()));

    public static final DeferredBlock<Block> RAW_SILVER_BLOCK = BLOCKS.register("raw_silver_block", BlockList::rawBlock);
    public static final DeferredItem<Item> RAW_SILVER_BLOCK_ITEM = ITEMS.register("raw_silver_block", () -> basicBlockItem(RAW_SILVER_BLOCK.get()));

    public static final DeferredItem<Item> SILVER_NUGGET = ITEMS.register("silver_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> SILVER_INGOT = ITEMS.register("silver_ingot", BlockList::basicItem);

    public static final DeferredBlock<Block> SILVER_BLOCK = BLOCKS.register("silver_block", BlockList::metalBlock);
    public static final DeferredItem<Item> SILVER_BLOCK_ITEM = ITEMS.register("silver_block", () -> basicBlockItem(SILVER_BLOCK.get()));

    public static final DeferredItem<Item> SILVER_RAW = ITEMS.register("raw_silver", BlockList::basicItem);
    public static final DeferredItem<Item> SILVER_DUST = ITEMS.register("silver_dust", BlockList::basicItem);
    public static final DeferredItem<Item> SILVER_ROD = ITEMS.register("silver_rod", BlockList::basicItem);
    public static final DeferredItem<Item> SILVER_GEAR = ITEMS.register("silver_gear", BlockList::basicItem);
    public static final DeferredItem<Item> SILVER_PLATE = ITEMS.register("tin_plate", BlockList::basicItem);

    // ********************** TIN

    public static final DeferredBlock<Block> TIN_ORE = BLOCKS.register("tin_ore", StoneOreBlock::new);
    public static final DeferredItem<Item> TIN_ORE_ITEM = ITEMS.register("tin_ore", () -> basicToolTipBlockItem(TIN_ORE.get()));
    public static final DeferredBlock<Block> TIN_SLATE_ORE = BLOCKS.register("deepslate_tin_ore", SlateOreBlock::new);
    public static final DeferredItem<Item> TIN_SLATE_ORE_ITEM = ITEMS.register("deepslate_tin_ore", () -> basicToolTipBlockItem(TIN_SLATE_ORE.get()));
    public static final DeferredBlock<Block> OTHER_TIN_ORE = BLOCKS.register("other_tin_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_TIN_ORE_ITEM = ITEMS.register("other_tin_ore", () -> basicToolTipBlockItem(OTHER_TIN_ORE.get()));
    public static final DeferredBlock<Block> TIN_NETHER_ORE = BLOCKS.register("nether_tin_ore", NetherOreBlock::new);
    public static final DeferredItem<Item> TIN_NETHER_ORE_ITEM = ITEMS.register("nether_tin_ore", () -> basicToolTipBlockItem(TIN_NETHER_ORE.get()));
    public static final DeferredBlock<Block> TIN_END_ORE = BLOCKS.register("end_tin_ore", EndOreBlock::new);
    public static final DeferredItem<Item> TIN_END_ORE_ITEM = ITEMS.register("end_tin_ore", () -> basicToolTipBlockItem(TIN_END_ORE.get()));

    public static final DeferredBlock<Block> RAW_TIN_BLOCK = BLOCKS.register("raw_tin_block", BlockList::rawBlock);
    public static final DeferredItem<Item> RAW_TIN_BLOCK_ITEM = ITEMS.register("raw_tin_block", () -> basicBlockItem(RAW_TIN_BLOCK.get()));

    public static final DeferredItem<Item> TIN_NUGGET = ITEMS.register("tin_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> TIN_INGOT = ITEMS.register("tin_ingot", BlockList::basicItem);

    public static final DeferredBlock<Block> TIN_BLOCK = BLOCKS.register("tin_block", BlockList::metalBlock);
    public static final DeferredItem<Item> TIN_BLOCK_ITEM = ITEMS.register("tin_block", () -> basicBlockItem(TIN_BLOCK.get()));

    public static final DeferredItem<Item> TIN_RAW = ITEMS.register("raw_tin", BlockList::basicItem);
    public static final DeferredItem<Item> TIN_DUST = ITEMS.register("tin_dust", BlockList::basicItem);
    public static final DeferredItem<Item> TIN_ROD = ITEMS.register("tin_rod", BlockList::basicItem);
    public static final DeferredItem<Item> TIN_GEAR = ITEMS.register("tin_gear", BlockList::basicItem);
    public static final DeferredItem<Item> TIN_PLATE = ITEMS.register("tin_plate", BlockList::basicItem);

    // ********************** URANIUM

    public static final DeferredBlock<Block> URANIUM_ORE = BLOCKS.register("uranium_ore", StoneOreBlock::new);
    public static final DeferredItem<Item> URANIUM_ORE_ITEM = ITEMS.register("uranium_ore", () -> basicToolTipBlockItem(URANIUM_ORE.get()));
    public static final DeferredBlock<Block> URANIUM_SLATE_ORE = BLOCKS.register("deepslate_uranium_ore", SlateOreBlock::new);
    public static final DeferredItem<Item> URANIUM_SLATE_ORE_ITEM = ITEMS.register("deepslate_uranium_ore", () -> basicToolTipBlockItem(URANIUM_SLATE_ORE.get()));
    public static final DeferredBlock<Block> OTHER_URANIUM_ORE = BLOCKS.register("other_uranium_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_URANIUM_ORE_ITEM = ITEMS.register("other_uranium_ore", () -> basicToolTipBlockItem(OTHER_URANIUM_ORE.get()));
    public static final DeferredBlock<Block> URANIUM_NETHER_ORE = BLOCKS.register("nether_uranium_ore", NetherOreBlock::new);
    public static final DeferredItem<Item> URANIUM_NETHER_ORE_ITEM = ITEMS.register("nether_uranium_ore", () -> basicToolTipBlockItem(URANIUM_NETHER_ORE.get()));
    public static final DeferredBlock<Block> URANIUM_END_ORE = BLOCKS.register("end_uranium_ore", EndOreBlock::new);
    public static final DeferredItem<Item> URANIUM_END_ORE_ITEM = ITEMS.register("end_uranium_ore", () -> basicToolTipBlockItem(URANIUM_END_ORE.get()));

    public static final DeferredBlock<Block> RAW_URANIUM_BLOCK = BLOCKS.register("raw_uranium_block", BlockList::rawBlock);
    public static final DeferredItem<Item> RAW_URANIUM_BLOCK_ITEM = ITEMS.register("raw_uranium_block", () -> basicBlockItem(RAW_URANIUM_BLOCK.get()));

    public static final DeferredItem<Item> URANIUM_NUGGET = ITEMS.register("uranium_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", BlockList::basicItem);

    public static final DeferredBlock<Block> URANIUM_BLOCK = BLOCKS.register("uranium_block", BlockList::metalBlock);
    public static final DeferredItem<Item> URANIUM_BLOCK_ITEM = ITEMS.register("uranium_block", () -> basicBlockItem(URANIUM_BLOCK.get()));

    public static final DeferredItem<Item> URANIUM_RAW = ITEMS.register("raw_uranium", BlockList::basicItem);
    public static final DeferredItem<Item> URANIUM_DUST = ITEMS.register("uranium_dust", BlockList::basicItem);
    public static final DeferredItem<Item> URANIUM_ROD = ITEMS.register("uranium_rod", BlockList::basicItem);
    public static final DeferredItem<Item> URANIUM_GEAR = ITEMS.register("uranium_gear", BlockList::basicItem);
    public static final DeferredItem<Item> URANIUM_PLATE = ITEMS.register("uranium_plate", BlockList::basicItem);

    // ********************** ZINC

    public static final DeferredBlock<Block> ZINC_ORE = BLOCKS.register("zinc_ore", StoneOreBlock::new);
    public static final DeferredItem<Item> ZINC_ORE_ITEM = ITEMS.register("zinc_ore", () -> basicToolTipBlockItem(ZINC_ORE.get()));
    public static final DeferredBlock<Block> ZINC_SLATE_ORE = BLOCKS.register("deepslate_zinc_ore", SlateOreBlock::new);
    public static final DeferredItem<Item> ZINC_SLATE_ORE_ITEM = ITEMS.register("deepslate_zinc_ore", () -> basicToolTipBlockItem(ZINC_SLATE_ORE.get()));
    public static final DeferredBlock<Block> OTHER_ZINC_ORE = BLOCKS.register("other_zinc_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_ZINC_ORE_ITEM = ITEMS.register("other_zinc_ore", () -> basicToolTipBlockItem(OTHER_ZINC_ORE.get()));
    public static final DeferredBlock<Block> ZINC_NETHER_ORE = BLOCKS.register("nether_zinc_ore", NetherOreBlock::new);
    public static final DeferredItem<Item> ZINC_NETHER_ORE_ITEM = ITEMS.register("nether_zinc_ore", () -> basicToolTipBlockItem(ZINC_NETHER_ORE.get()));
    public static final DeferredBlock<Block> ZINC_END_ORE = BLOCKS.register("end_zinc_ore", EndOreBlock::new);
    public static final DeferredItem<Item> ZINC_END_ORE_ITEM = ITEMS.register("end_zinc_ore", () -> basicToolTipBlockItem(ZINC_END_ORE.get()));

    public static final DeferredBlock<Block> RAW_ZINC_BLOCK = BLOCKS.register("raw_zinc_block", BlockList::rawBlock);
    public static final DeferredItem<Item> RAW_ZINC_BLOCK_ITEM = ITEMS.register("raw_zinc_block", () -> basicBlockItem(RAW_ZINC_BLOCK.get()));

    public static final DeferredItem<Item> ZINC_NUGGET = ITEMS.register("zinc_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> ZINC_INGOT = ITEMS.register("zinc_ingot", BlockList::basicItem);

    public static final DeferredBlock<Block> ZINC_BLOCK = BLOCKS.register("zinc_block", BlockList::metalBlock);
    public static final DeferredItem<Item> ZINC_BLOCK_ITEM = ITEMS.register("zinc_block", () -> basicBlockItem(ZINC_BLOCK.get()));

    public static final DeferredItem<Item> ZINC_RAW = ITEMS.register("raw_zinc", BlockList::basicItem);
    public static final DeferredItem<Item> ZINC_DUST = ITEMS.register("zinc_dust", BlockList::basicItem);
    public static final DeferredItem<Item> ZINC_ROD = ITEMS.register("zinc_rod", BlockList::basicItem);
    public static final DeferredItem<Item> ZINC_GEAR = ITEMS.register("zinc_gear", BlockList::basicItem);
    public static final DeferredItem<Item> ZINC_PLATE = ITEMS.register("zinc_plate", BlockList::basicItem);

    // ********************** IRIDIUM

    public static final DeferredBlock<Block> IRIDIUM_ORE = BLOCKS.register("iridium_ore", StoneOreBlock::new);
    public static final DeferredItem<Item> IRIDIUM_ORE_ITEM = ITEMS.register("iridium_ore", () -> basicToolTipBlockItem(IRIDIUM_ORE.get()));
    public static final DeferredBlock<Block> IRIDIUM_SLATE_ORE = BLOCKS.register("deepslate_iridium_ore", SlateOreBlock::new);
    public static final DeferredItem<Item> IRIDIUM_SLATE_ORE_ITEM = ITEMS.register("deepslate_iridium_ore", () -> basicToolTipBlockItem(IRIDIUM_SLATE_ORE.get()));
    public static final DeferredBlock<Block> OTHER_IRIDIUM_ORE = BLOCKS.register("other_iridium_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_IRIDIUM_ORE_ITEM = ITEMS.register("other_iridium_ore", () -> basicToolTipBlockItem(OTHER_IRIDIUM_ORE.get()));
    public static final DeferredBlock<Block> IRIDIUM_NETHER_ORE = BLOCKS.register("nether_iridium_ore", NetherOreBlock::new);
    public static final DeferredItem<Item> IRIDIUM_NETHER_ORE_ITEM = ITEMS.register("nether_iridium_ore", () -> basicToolTipBlockItem(IRIDIUM_NETHER_ORE.get()));
    public static final DeferredBlock<Block> IRIDIUM_END_ORE = BLOCKS.register("end_iridium_ore", EndOreBlock::new);
    public static final DeferredItem<Item> IRIDIUM_END_ORE_ITEM = ITEMS.register("end_iridium_ore", () -> basicToolTipBlockItem(IRIDIUM_END_ORE.get()));

    public static final DeferredBlock<Block> RAW_IRIDIUM_BLOCK = BLOCKS.register("raw_iridium_block", BlockList::rawBlock);
    public static final DeferredItem<Item> RAW_IRIDIUM_BLOCK_ITEM = ITEMS.register("raw_iridium_block", () -> basicBlockItem(RAW_IRIDIUM_BLOCK.get()));

    public static final DeferredItem<Item> IRIDIUM_NUGGET = ITEMS.register("iridium_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> IRIDIUM_INGOT = ITEMS.register("iridium_ingot", BlockList::basicItem);

    public static final DeferredBlock<Block> IRIDIUM_BLOCK = BLOCKS.register("iridium_block", BlockList::metalBlock);
    public static final DeferredItem<Item> IRIDIUM_BLOCK_ITEM = ITEMS.register("iridium_block", () -> basicBlockItem(IRIDIUM_BLOCK.get()));

    public static final DeferredItem<Item> IRIDIUM_RAW = ITEMS.register("raw_iridium", BlockList::basicItem);
    public static final DeferredItem<Item> IRIDIUM_DUST = ITEMS.register("iridium_dust", BlockList::basicItem);
    public static final DeferredItem<Item> IRIDIUM_ROD = ITEMS.register("iridium_rod", BlockList::basicItem);
    public static final DeferredItem<Item> IRIDIUM_GEAR = ITEMS.register("iridium_gear", BlockList::basicItem);
    public static final DeferredItem<Item> IRIDIUM_PLATE = ITEMS.register("iridium_plate", BlockList::basicItem);


    // ###################### ALLOYS

    // *********************** BRONZE

    public static final DeferredItem<Item> BRONZE_NUGGET = ITEMS.register("bronze_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot", BlockList::basicItem);
    public static final DeferredBlock<Block> BRONZE_BLOCK = BLOCKS.register("bronze_block", BlockList::metalBlock);
    public static final DeferredItem<Item> BRONZE_BLOCK_ITEM = ITEMS.register("bronze_block", () -> basicBlockItem(BRONZE_BLOCK.get()));

    public static final DeferredItem<Item> BRONZE_DUST = ITEMS.register("bronze_dust", BlockList::basicItem);
    public static final DeferredItem<Item> BRONZE_ROD = ITEMS.register("bronze_rod", BlockList::basicItem);
    public static final DeferredItem<Item> BRONZE_GEAR = ITEMS.register("bronze_gear", BlockList::basicItem);
    public static final DeferredItem<Item> BRONZE_PLATE = ITEMS.register("bronze_plate", BlockList::basicItem);

    // *********************** BRASS

    public static final DeferredItem<Item> BRASS_NUGGET = ITEMS.register("brass_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> BRASS_INGOT = ITEMS.register("brass_ingot", BlockList::basicItem);
    public static final DeferredBlock<Block> BRASS_BLOCK = BLOCKS.register("brass_block", BlockList::metalBlock);
    public static final DeferredItem<Item> BRASS_BLOCK_ITEM = ITEMS.register("brass_block", () -> basicBlockItem(BRASS_BLOCK.get()));

    public static final DeferredItem<Item> BRASS_DUST = ITEMS.register("brass_dust", BlockList::basicItem);
    public static final DeferredItem<Item> BRASS_ROD = ITEMS.register("brass_rod", BlockList::basicItem);
    public static final DeferredItem<Item> BRASS_GEAR = ITEMS.register("brass_gear", BlockList::basicItem);
    public static final DeferredItem<Item> BRASS_PLATE = ITEMS.register("brass_plate", BlockList::basicItem);

    // *********************** STEEL

    public static final DeferredItem<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.register("steel_ingot", BlockList::basicItem);
    public static final DeferredBlock<Block> STEEL_BLOCK = BLOCKS.register("steel_block", BlockList::metalBlock);
    public static final DeferredItem<Item> STEEL_BLOCK_ITEM = ITEMS.register("steel_block", () -> basicBlockItem(STEEL_BLOCK.get()));

    public static final DeferredItem<Item> STEEL_DUST = ITEMS.register("steel_dust", BlockList::basicItem);
    public static final DeferredItem<Item> STEEL_ROD = ITEMS.register("steel_rod", BlockList::basicItem);
    public static final DeferredItem<Item> STEEL_GEAR = ITEMS.register("steel_gear", BlockList::basicItem);
    public static final DeferredItem<Item> STEEL_PLATE = ITEMS.register("steel_plate", BlockList::basicItem);

    // *********************** INVAR

    public static final DeferredItem<Item> INVAR_NUGGET = ITEMS.register("invar_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> INVAR_INGOT = ITEMS.register("invar_ingot", BlockList::basicItem);
    public static final DeferredBlock<Block> INVAR_BLOCK = BLOCKS.register("invar_block", BlockList::metalBlock);
    public static final DeferredItem<Item> INVAR_BLOCK_ITEM = ITEMS.register("invar_block", () -> basicBlockItem(INVAR_BLOCK.get()));

    public static final DeferredItem<Item> INVAR_DUST = ITEMS.register("invar_dust", BlockList::basicItem);
    public static final DeferredItem<Item> INVAR_ROD = ITEMS.register("invar_rod", BlockList::basicItem);
    public static final DeferredItem<Item> INVAR_GEAR = ITEMS.register("invar_gear", BlockList::basicItem);
    public static final DeferredItem<Item> INVAR_PLATE = ITEMS.register("invar_plate", BlockList::basicItem);

    // *********************** CONSTANTAN

    public static final DeferredItem<Item> CONSTANTAN_NUGGET = ITEMS.register("constantan_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> CONSTANTAN_INGOT = ITEMS.register("constantan_ingot", BlockList::basicItem);
    public static final DeferredBlock<Block> CONSTANTAN_BLOCK = BLOCKS.register("constantan_block", BlockList::metalBlock);
    public static final DeferredItem<Item> CONSTANTAN_BLOCK_ITEM = ITEMS.register("constantan_block", () -> basicBlockItem(CONSTANTAN_BLOCK.get()));

    public static final DeferredItem<Item> CONSTANTAN_DUST = ITEMS.register("constantan_dust", BlockList::basicItem);
    public static final DeferredItem<Item> CONSTANTAN_ROD = ITEMS.register("constantan_rod", BlockList::basicItem);
    public static final DeferredItem<Item> CONSTANTAN_GEAR = ITEMS.register("constantan_gear", BlockList::basicItem);
    public static final DeferredItem<Item> CONSTANTAN_PLATE = ITEMS.register("constantan_plate", BlockList::basicItem);

    // *********************** ELECTRUM

    public static final DeferredItem<Item> ELECTRUM_NUGGET = ITEMS.register("electrum_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> ELECTRUM_INGOT = ITEMS.register("electrum_ingot", BlockList::basicItem);
    public static final DeferredBlock<Block> ELECTRUM_BLOCK = BLOCKS.register("electrum_block", BlockList::metalBlock);
    public static final DeferredItem<Item> ELECTRUM_BLOCK_ITEM = ITEMS.register("electrum_block", () -> basicBlockItem(ELECTRUM_BLOCK.get()));

    public static final DeferredItem<Item> ELECTRUM_DUST = ITEMS.register("electrum_dust", BlockList::basicItem);
    public static final DeferredItem<Item> ELECTRUM_ROD = ITEMS.register("electrum_rod", BlockList::basicItem);
    public static final DeferredItem<Item> ELECTRUM_GEAR = ITEMS.register("electrum_gear", BlockList::basicItem);
    public static final DeferredItem<Item> ELECTRUM_PLATE = ITEMS.register("electrum_plate", BlockList::basicItem);

    // *********************** ENDERIUM

    public static final DeferredItem<Item> ENDERIUM_NUGGET = ITEMS.register("enderium_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> ENDERIUM_INGOT = ITEMS.register("enderium_ingot", BlockList::basicItem);
    public static final DeferredBlock<Block> ENDERIUM_BLOCK = BLOCKS.register("enderium_block", BlockList::metalBlock);
    public static final DeferredItem<Item> ENDERIUM_BLOCK_ITEM = ITEMS.register("enderium_block", () -> basicBlockItem(ENDERIUM_BLOCK.get()));

    public static final DeferredItem<Item> ENDERIUM_DUST = ITEMS.register("enderium_dust", BlockList::basicItem);
    public static final DeferredItem<Item> ENDERIUM_ROD = ITEMS.register("enderium_rod", BlockList::basicItem);
    public static final DeferredItem<Item> ENDERIUM_GEAR = ITEMS.register("enderium_gear", BlockList::basicItem);
    public static final DeferredItem<Item> ENDERIUM_PLATE = ITEMS.register("enderium_plate", BlockList::basicItem);

    // *********************** LUMIUM

    public static final DeferredItem<Item> LUMIUM_NUGGET = ITEMS.register("lumium_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> LUMIUM_INGOT = ITEMS.register("lumium_ingot", BlockList::basicItem);
    public static final DeferredBlock<Block> LUMIUM_BLOCK = BLOCKS.register("lumium_block", BlockList::metalBlock);
    public static final DeferredItem<Item> LUMIUM_BLOCK_ITEM = ITEMS.register("lumium_block", () -> basicBlockItem(LUMIUM_BLOCK.get()));

    public static final DeferredItem<Item> LUMIUM_DUST = ITEMS.register("lumium_dust", BlockList::basicItem);
    public static final DeferredItem<Item> LUMIUM_ROD = ITEMS.register("lumium_rod", BlockList::basicItem);
    public static final DeferredItem<Item> LUMIUM_GEAR = ITEMS.register("lumium_gear", BlockList::basicItem);
    public static final DeferredItem<Item> LUMIUM_PLATE = ITEMS.register("lumium_plate", BlockList::basicItem);

    // *********************** SIGNALUM

    public static final DeferredItem<Item> SIGNALUM_NUGGET = ITEMS.register("signalum_nugget", BlockList::basicItem);
    public static final DeferredItem<Item> SIGNALUM_INGOT = ITEMS.register("signalum_ingot", BlockList::basicItem);
    public static final DeferredBlock<Block> SIGNALUM_BLOCK = BLOCKS.register("signalum_block", BlockList::metalBlock);
    public static final DeferredItem<Item> SIGNALUM_BLOCK_ITEM = ITEMS.register("signalum_block", () -> basicBlockItem(SIGNALUM_BLOCK.get()));

    public static final DeferredItem<Item> SIGNALUM_DUST = ITEMS.register("signalum_dust", BlockList::basicItem);
    public static final DeferredItem<Item> SIGNALUM_ROD = ITEMS.register("signalum_rod", BlockList::basicItem);
    public static final DeferredItem<Item> SIGNALUM_GEAR = ITEMS.register("signalum_gear", BlockList::basicItem);
    public static final DeferredItem<Item> SIGNALUM_PLATE = ITEMS.register("signalum_plate", BlockList::basicItem);

    // ###################### GEMS

    // ********************* RUBY

    public static final DeferredBlock<Block> RUBY_ORE = BLOCKS.register("ruby_ore", StoneOreBlock::new);
    public static final DeferredItem<Item> RUBY_ORE_ITEM = ITEMS.register("ruby_ore", () -> basicToolTipBlockItem(RUBY_ORE.get()));
    public static final DeferredBlock<Block> RUBY_SLATE_ORE = BLOCKS.register("deepslate_ruby_ore", SlateOreBlock::new);
    public static final DeferredItem<Item> RUBY_SLATE_ORE_ITEM = ITEMS.register("deepslate_ruby_ore", () -> basicToolTipBlockItem(RUBY_SLATE_ORE.get()));
    public static final DeferredBlock<Block> RUBY_NETHER_ORE = BLOCKS.register("nether_ruby_ore", NetherOreBlock::new);
    public static final DeferredItem<Item> RUBY_NETHER_ORE_ITEM = ITEMS.register("nether_ruby_ore", () -> basicToolTipBlockItem(RUBY_NETHER_ORE.get()));
    public static final DeferredBlock<Block> RUBY_END_ORE = BLOCKS.register("end_ruby_ore", EndOreBlock::new);
    public static final DeferredItem<Item> RUBY_END_ORE_ITEM = ITEMS.register("end_ruby_ore", () -> basicToolTipBlockItem(RUBY_END_ORE.get()));

    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby", BlockList::basicItem);

    public static final DeferredBlock<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", BlockList::crystalBlock);
    public static final DeferredItem<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", () -> basicBlockItem(RUBY_BLOCK.get()));

    public static final DeferredItem<Item> RUBY_DUST = ITEMS.register("ruby_dust", BlockList::basicItem);

    // **************** PERIDOT

    public static final DeferredBlock<Block> PERIDOT_ORE = BLOCKS.register("peridot_ore", StoneOreBlock::new);
    public static final DeferredItem<Item> PERIDOT_ORE_ITEM = ITEMS.register("peridot_ore", () -> basicToolTipBlockItem(PERIDOT_ORE.get()));
    public static final DeferredBlock<Block> PERIDOT_SLATE_ORE = BLOCKS.register("deepslate_peridot_ore", SlateOreBlock::new);
    public static final DeferredItem<Item> PERIDOT_SLATE_ORE_ITEM = ITEMS.register("deepslate_peridot_ore", () -> basicToolTipBlockItem(PERIDOT_SLATE_ORE.get()));
    public static final DeferredBlock<Block> PERIDOT_NETHER_ORE = BLOCKS.register("nether_peridot_ore", NetherOreBlock::new);
    public static final DeferredItem<Item> PERIDOT_NETHER_ORE_ITEM = ITEMS.register("nether_peridot_ore", () -> basicToolTipBlockItem(PERIDOT_NETHER_ORE.get()));
    public static final DeferredBlock<Block> PERIDOT_END_ORE = BLOCKS.register("end_peridot_ore", EndOreBlock::new);
    public static final DeferredItem<Item> PERIDOT_END_ORE_ITEM = ITEMS.register("end_peridot_ore", () -> basicToolTipBlockItem(PERIDOT_END_ORE.get()));

    public static final DeferredItem<Item> PERIDOT = ITEMS.register("peridot", BlockList::basicItem);

    public static final DeferredBlock<Block> PERIDOT_BLOCK = BLOCKS.register("peridot_block", BlockList::crystalBlock);
    public static final DeferredItem<Item> PERIDOT_BLOCK_ITEM = ITEMS.register("peridot_block", () -> basicBlockItem(PERIDOT_BLOCK.get()));

    public static final DeferredItem<Item> PERIDOT_DUST = ITEMS.register("peridot_dust", BlockList::basicItem);

    // **************** SAPPHIRE

    public static final DeferredBlock<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", StoneOreBlock::new);
    public static final DeferredItem<Item> SAPPHIRE_ORE_ITEM = ITEMS.register("sapphire_ore", () -> basicToolTipBlockItem(SAPPHIRE_ORE.get()));
    public static final DeferredBlock<Block> SAPPHIRE_SLATE_ORE = BLOCKS.register("deepslate_sapphire_ore", SlateOreBlock::new);
    public static final DeferredItem<Item> SAPPHIRE_SLATE_ORE_ITEM = ITEMS.register("deepslate_sapphire_ore", () -> basicToolTipBlockItem(SAPPHIRE_SLATE_ORE.get()));
    public static final DeferredBlock<Block> SAPPHIRE_NETHER_ORE = BLOCKS.register("nether_sapphire_ore", NetherOreBlock::new);
    public static final DeferredItem<Item> SAPPHIRE_NETHER_ORE_ITEM = ITEMS.register("nether_sapphire_ore", () -> basicToolTipBlockItem(SAPPHIRE_NETHER_ORE.get()));
    public static final DeferredBlock<Block> SAPPHIRE_END_ORE = BLOCKS.register("end_sapphire_ore", EndOreBlock::new);
    public static final DeferredItem<Item> SAPPHIRE_END_ORE_ITEM = ITEMS.register("end_sapphire_ore", () -> basicToolTipBlockItem(SAPPHIRE_END_ORE.get()));

    public static final DeferredItem<Item> SAPPHIRE = ITEMS.register("sapphire", BlockList::basicItem);

    public static final DeferredBlock<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", BlockList::crystalBlock);
    public static final DeferredItem<Item> SAPPHIRE_BLOCK_ITEM = ITEMS.register("sapphire_block", () -> basicBlockItem(SAPPHIRE_BLOCK.get()));

    public static final DeferredItem<Item> SAPPHIRE_DUST = ITEMS.register("sapphire_dust", BlockList::basicItem);

    // **************** CINNABAR

    public static final DeferredBlock<Block> CINNABAR_ORE = BLOCKS.register("cinnabar_ore", StoneOreBlock::new);
    public static final DeferredItem<Item> CINNABAR_ORE_ITEM = ITEMS.register("cinnabar_ore", () -> basicToolTipBlockItem(CINNABAR_ORE.get()));
    public static final DeferredBlock<Block> CINNABAR_SLATE_ORE = BLOCKS.register("deepslate_cinnabar_ore", SlateOreBlock::new);
    public static final DeferredItem<Item> CINNABAR_SLATE_ORE_ITEM = ITEMS.register("deepslate_cinnabar_ore", () -> basicToolTipBlockItem(CINNABAR_SLATE_ORE.get()));
    public static final DeferredBlock<Block> CINNABAR_NETHER_ORE = BLOCKS.register("nether_cinnabar_ore", NetherOreBlock::new);
    public static final DeferredItem<Item> CINNABAR_NETHER_ORE_ITEM = ITEMS.register("nether_cinnabar_ore", () -> basicToolTipBlockItem(CINNABAR_NETHER_ORE.get()));
    public static final DeferredBlock<Block> CINNABAR_END_ORE = BLOCKS.register("end_cinnabar_ore", EndOreBlock::new);
    public static final DeferredItem<Item> CINNABAR_END_ORE_ITEM = ITEMS.register("end_cinnabar_ore", () -> basicToolTipBlockItem(CINNABAR_END_ORE.get()));

    public static final DeferredItem<Item> CINNABAR = ITEMS.register("cinnabar", BlockList::basicItem);

    public static final DeferredBlock<Block> CINNABAR_BLOCK = BLOCKS.register("cinnabar_block", BlockList::crystalBlock);
    public static final DeferredItem<Item> CINNABAR_BLOCK_ITEM = ITEMS.register("cinnabar_block", () -> basicBlockItem(CINNABAR_BLOCK.get()));

    public static final DeferredItem<Item> CINNABAR_DUST = ITEMS.register("cinnabar_dust", BlockList::basicItem);

    // **************** FLUORITE

    public static final DeferredBlock<Block> FLUORITE_ORE = BLOCKS.register("fluorite_ore", StoneOreBlock::new);
    public static final DeferredItem<Item> FLUORITE_ORE_ITEM = ITEMS.register("fluorite_ore", () -> basicToolTipBlockItem(FLUORITE_ORE.get()));
    public static final DeferredBlock<Block> FLUORITE_SLATE_ORE = BLOCKS.register("deepslate_fluorite_ore", SlateOreBlock::new);
    public static final DeferredItem<Item> FLUORITE_SLATE_ORE_ITEM = ITEMS.register("deepslate_fluorite_ore", () -> basicToolTipBlockItem(FLUORITE_SLATE_ORE.get()));
    public static final DeferredBlock<Block> FLUORITE_NETHER_ORE = BLOCKS.register("nether_fluorite_ore", NetherOreBlock::new);
    public static final DeferredItem<Item> FLUORITE_NETHER_ORE_ITEM = ITEMS.register("nether_fluorite_ore", () -> basicToolTipBlockItem(FLUORITE_NETHER_ORE.get()));
    public static final DeferredBlock<Block> FLUORITE_END_ORE = BLOCKS.register("end_fluorite_ore", EndOreBlock::new);
    public static final DeferredItem<Item> FLUORITE_END_ORE_ITEM = ITEMS.register("end_fluorite_ore", () -> basicToolTipBlockItem(FLUORITE_END_ORE.get()));

    public static final DeferredItem<Item> FLUORITE = ITEMS.register("fluorite", BlockList::basicItem);

    public static final DeferredBlock<Block> FLUORITE_BLOCK = BLOCKS.register("fluorite_block", BlockList::crystalBlock);
    public static final DeferredItem<Item> FLUORITE_BLOCK_ITEM = ITEMS.register("fluorite_block", () -> basicBlockItem(FLUORITE_BLOCK.get()));

    public static final DeferredItem<Item> FLUORITE_DUST = ITEMS.register("fluorite_dust", BlockList::basicItem);

    // **************** SALT

    public static final DeferredBlock<Block> SALT_ORE = BLOCKS.register("salt_ore", StoneOreBlock::new);
    public static final DeferredItem<Item> SALT_ORE_ITEM = ITEMS.register("salt_ore", () -> basicToolTipBlockItem(SALT_ORE.get()));
    public static final DeferredBlock<Block> SALT_SLATE_ORE = BLOCKS.register("deepslate_salt_ore", SlateOreBlock::new);
    public static final DeferredItem<Item> SALT_SLATE_ORE_ITEM = ITEMS.register("deepslate_salt_ore", () -> basicToolTipBlockItem(SALT_SLATE_ORE.get()));
    public static final DeferredBlock<Block> SALT_NETHER_ORE = BLOCKS.register("nether_salt_ore", NetherOreBlock::new);
    public static final DeferredItem<Item> SALT_NETHER_ORE_ITEM = ITEMS.register("nether_salt_ore", () -> basicToolTipBlockItem(SALT_NETHER_ORE.get()));
    public static final DeferredBlock<Block> SALT_END_ORE = BLOCKS.register("end_salt_ore", EndOreBlock::new);
    public static final DeferredItem<Item> SALT_END_ORE_ITEM = ITEMS.register("end_salt_ore", () -> basicToolTipBlockItem(SALT_END_ORE.get()));

    public static final DeferredItem<Item> SALT = ITEMS.register("salt", BlockList::basicItem);

    public static final DeferredBlock<Block> SALT_BLOCK = BLOCKS.register("salt_block", BlockList::crystalBlock);
    public static final DeferredItem<Item> SALT_BLOCK_ITEM = ITEMS.register("salt_block", () -> basicBlockItem(SALT_BLOCK.get()));

    // **************** SULFUR

    public static final DeferredBlock<Block> SULFUR_ORE = BLOCKS.register("sulfur_ore", StoneOreBlock::new);
    public static final DeferredItem<Item> SULFUR_ORE_ITEM = ITEMS.register("sulfur_ore", () -> basicToolTipBlockItem(SULFUR_ORE.get()));
    public static final DeferredBlock<Block> SULFUR_SLATE_ORE = BLOCKS.register("deepslate_sulfur_ore", SlateOreBlock::new);
    public static final DeferredItem<Item> SULFUR_SLATE_ORE_ITEM = ITEMS.register("deepslate_sulfur_ore", () -> basicToolTipBlockItem(SULFUR_SLATE_ORE.get()));
    public static final DeferredBlock<Block> SULFUR_NETHER_ORE = BLOCKS.register("nether_sulfur_ore", NetherOreBlock::new);
    public static final DeferredItem<Item> SULFUR_NETHER_ORE_ITEM = ITEMS.register("nether_sulfur_ore", () -> basicToolTipBlockItem(SULFUR_NETHER_ORE.get()));
    public static final DeferredBlock<Block> SULFUR_END_ORE = BLOCKS.register("end_sulfur_ore", EndOreBlock::new);
    public static final DeferredItem<Item> SULFUR_END_ORE_ITEM = ITEMS.register("end_sulfur_ore", () -> basicToolTipBlockItem(SULFUR_END_ORE.get()));

    public static final DeferredItem<Item> SULFUR = ITEMS.register("sulfur", BlockList::basicItem);

    public static final DeferredBlock<Block> SULFUR_BLOCK = BLOCKS.register("sulfur_block", BlockList::crystalBlock);
    public static final DeferredItem<Item> SULFUR_BLOCK_ITEM = ITEMS.register("sulfur_block", () -> basicBlockItem(SULFUR_BLOCK.get()));

    // ###################### HAMMERS

    public static final DeferredItem<Item> COPPER_ORE_HAMMER = ITEMS.register("copper_ore_hammer", () -> new OreHammer(new Item.Properties(), 64));
    public static final DeferredItem<Item> IRON_ORE_HAMMER = ITEMS.register("iron_ore_hammer", () -> new OreHammer(new Item.Properties(), 96));
    public static final DeferredItem<Item> BRONZE_ORE_HAMMER = ITEMS.register("bronze_ore_hammer", () -> new OreHammer(new Item.Properties(), 128));
    public static final DeferredItem<Item> INVAR_ORE_HAMMER = ITEMS.register("invar_ore_hammer", () -> new OreHammer(new Item.Properties(), 192));
    public static final DeferredItem<Item> PLATINUM_ORE_HAMMER = ITEMS.register("platinum_ore_hammer", () -> new OreHammer(new Item.Properties(), 256));

    // ###################### VANILLA

    // *********************** COAL

    public static final DeferredBlock<Block> OTHER_COAL_ORE = BLOCKS.register("other_coal_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_COAL_ORE_ITEM = ITEMS.register("other_coal_ore", () -> basicToolTipBlockItem(OTHER_COAL_ORE.get()));

    // *********************** LAPIS

    public static final DeferredBlock<Block> OTHER_LAPIS_ORE = BLOCKS.register("other_lapis_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_LAPIS_ORE_ITEM = ITEMS.register("other_lapis_ore", () -> basicToolTipBlockItem(OTHER_LAPIS_ORE.get()));

    // *********************** REDSTONE

    public static final DeferredBlock<Block> OTHER_REDSTONE_ORE = BLOCKS.register("other_redstone_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_REDSTONE_ORE_ITEM = ITEMS.register("other_redstone_ore", () -> basicToolTipBlockItem(OTHER_REDSTONE_ORE.get()));

    // *********************** EMERALD

    public static final DeferredBlock<Block> OTHER_EMERALD_ORE = BLOCKS.register("other_emerald_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_EMERALD_ORE_ITEM = ITEMS.register("other_emerald_ore", () -> basicToolTipBlockItem(OTHER_EMERALD_ORE.get()));

    // *********************** QUARTZ

    public static final DeferredBlock<Block> OTHER_QUARTZ_ORE = BLOCKS.register("other_quartz_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_QUARTZ_ORE_ITEM = ITEMS.register("other_quartz_ore", () -> basicBlockItem(OTHER_QUARTZ_ORE.get()));

    // *********************** IRON

    public static final DeferredBlock<Block> OTHER_IRON_ORE = BLOCKS.register("other_iron_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_IRON_ORE_ITEM = ITEMS.register("other_iron_ore", () -> basicToolTipBlockItem(OTHER_IRON_ORE.get()));

    public static final DeferredItem<Item> IRON_DUST = ITEMS.register("iron_dust", BlockList::basicItem);
    public static final DeferredItem<Item> IRON_ROD = ITEMS.register("iron_rod", BlockList::basicItem);
    public static final DeferredItem<Item> IRON_GEAR = ITEMS.register("iron_gear", BlockList::basicItem);
    public static final DeferredItem<Item> IRON_PLATE = ITEMS.register("iron_plate", BlockList::basicItem);

    // *********************** COPPER

    public static final DeferredBlock<Block> OTHER_COPPER_ORE = BLOCKS.register("other_copper_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_COPPER_ORE_ITEM = ITEMS.register("other_copper_ore", () -> basicToolTipBlockItem(OTHER_COPPER_ORE.get()));

    public static final DeferredItem<Item> COPPER_NUGGET = ITEMS.register("copper_nugget", BlockList::basicItem);

    public static final DeferredItem<Item> COPPER_DUST = ITEMS.register("copper_dust", BlockList::basicItem);
    public static final DeferredItem<Item> COPPER_ROD = ITEMS.register("copper_rod", BlockList::basicItem);
    public static final DeferredItem<Item> COPPER_GEAR = ITEMS.register("copper_gear", BlockList::basicItem);
    public static final DeferredItem<Item> COPPER_PLATE = ITEMS.register("copper_plate", BlockList::basicItem);

    // *********************** GOLD

    public static final DeferredBlock<Block> OTHER_GOLD_ORE = BLOCKS.register("other_gold_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_GOLD_ORE_ITEM = ITEMS.register("other_gold_ore", () -> basicToolTipBlockItem(OTHER_GOLD_ORE.get()));

    public static final DeferredItem<Item> GOLD_DUST = ITEMS.register("gold_dust", BlockList::basicItem);
    public static final DeferredItem<Item> GOLD_ROD = ITEMS.register("gold_rod", BlockList::basicItem);
    public static final DeferredItem<Item> GOLD_GEAR = ITEMS.register("gold_gear", BlockList::basicItem);
    public static final DeferredItem<Item> GOLD_PLATE = ITEMS.register("gold_plate", BlockList::basicItem);

    // *********************** DIAMOND

    public static final DeferredBlock<Block> OTHER_DIAMOND_ORE = BLOCKS.register("other_diamond_ore", OtherOreBlock::new);
    public static final DeferredItem<Item> OTHER_DIAMOND_ORE_ITEM = ITEMS.register("other_diamond_ore", () -> basicToolTipBlockItem(OTHER_DIAMOND_ORE.get()));

    public static final DeferredItem<Item> DIAMOND_DUST = ITEMS.register("diamond_dust", BlockList::basicItem);
    public static final DeferredItem<Item> DIAMOND_ROD = ITEMS.register("diamond_rod", BlockList::basicItem);
    public static final DeferredItem<Item> DIAMOND_GEAR = ITEMS.register("diamond_gear", BlockList::basicItem);
    public static final DeferredItem<Item> DIAMOND_PLATE = ITEMS.register("diamond_plate", BlockList::basicItem);

    // *********************** NETHERITE

    public static final DeferredItem<Item> NETHERITE_DUST = ITEMS.register("netherite_dust", BlockList::basicItem);
    public static final DeferredItem<Item> NETHERITE_ROD = ITEMS.register("netherite_rod", BlockList::basicItem);
    public static final DeferredItem<Item> NETHERITE_GEAR = ITEMS.register("netherite_gear", BlockList::basicItem);
    public static final DeferredItem<Item> NETHERITE_PLATE = ITEMS.register("netherite_plate", BlockList::basicItem);



    // ###################### HELPER METHODS

    private static Item basicItem() {
        return new Item(new Item.Properties());
    }

    private static BlockItem basicBlockItem(Block block) {
        return new BlockItem(block, new Item.Properties());
    }

    private static ToolTipBlockItem basicToolTipBlockItem(Block block) {
        return new ToolTipBlockItem(block, new Item.Properties());
    }

    private static Block rawBlock() {
        return new Block(Block.Properties.of().requiresCorrectToolForDrops().strength(3.0f, 3.0f));
    }

    private static Block crystalBlock() {
        return new Block(Block.Properties.of().strength(3.0f, 3.0f).sound(SoundType.AMETHYST));
    }

    private static Block metalBlock() {
        return new Block(Block.Properties.of().strength(3.0f, 3.0f).sound(SoundType.METAL));
    }

}


