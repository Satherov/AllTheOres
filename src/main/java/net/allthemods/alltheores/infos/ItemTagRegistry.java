package net.allthemods.alltheores.infos;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ItemTagRegistry {
    //ATM Compat
    //public static final TagKey<Block> ANCIENT_STONE = BlockTags.create(Reference.location("allthemodium:ancient_stone"));
    //

    // ###################### MEKANISM

    public static final TagKey<Item> MUFFLING_CENTER = ItemTags.create(Reference.mek("muffling_center"));

    // ###################### FORGE

    public static final TagKey<Block> ORES_BLOCK = BlockTags.create(Reference.forge("ores"));
    public static final TagKey<Item> ORES_ITEM = ItemTags.create(Reference.forge("ores"));
    public static final TagKey<Item> GEMS = ItemTags.create(Reference.forge("gems"));

    public static final TagKey<Item> RAW_ORES = ItemTags.create(Reference.forge("raw_materials"));

    public static final TagKey<Item> NUGGETS = ItemTags.create(Reference.forge("nuggets"));
    public static final TagKey<Item> INGOTS = ItemTags.create(Reference.forge("ingots"));
    public static final TagKey<Item> STORAGE_BLOCKS = ItemTags.create(Reference.forge("storage_blocks"));

    public static final TagKey<Item> DUSTS = ItemTags.create(Reference.forge("dusts"));
    public static final TagKey<Item> GEARS = ItemTags.create(Reference.forge("gears"));
    public static final TagKey<Item> PLATES = ItemTags.create(Reference.forge("plates"));
    public static final TagKey<Item> RODS = ItemTags.create(Reference.forge("rods"));
    public static final TagKey<Item> RODS_METAL = ItemTags.create(Reference.forge("rods/metal"));

    public static final TagKey<Item> DYES = ItemTags.create(Reference.forge("dyes"));
    public static final TagKey<Item> YELLOW_DYE = ItemTags.create(Reference.forge("dyes/yellow"));

    // ORE BLOCK BASE
    public static final TagKey<Block> IN_STONE = BlockTags.create(Reference.ores_in_ground("stone"));
    public static final TagKey<Block> IN_DEEPSLATE = BlockTags.create(Reference.ores_in_ground("deepslate"));
    public static final TagKey<Block> IN_NETHERRACK = BlockTags.create(Reference.ores_in_ground("netherrack"));
    public static final TagKey<Block> IN_END_STONE = BlockTags.create(Reference.ores_in_ground("end_stone"));
    public static final TagKey<Block> IN_ANCIENT_STONE = BlockTags.create(Reference.ores_in_ground("ancient_stone"));
    public static final TagKey<Item> IN_STONE_ITEM = ItemTags.create(Reference.ores_in_ground("stone"));
    public static final TagKey<Item> IN_DEEPSLATE_ITEM = ItemTags.create(Reference.ores_in_ground("deepslate"));
    public static final TagKey<Item> IN_NETHERRACK_ITEM = ItemTags.create(Reference.ores_in_ground("netherrack"));
    public static final TagKey<Item> IN_END_STONE_ITEM = ItemTags.create(Reference.ores_in_ground("end_stone"));
    public static final TagKey<Item> IN_ANCIENT_STONE_ITEM = ItemTags.create(Reference.ores_in_ground("ancient_stone"));

    // ###################### ALL THE ORES

    public static final TagKey<Item> ORE_HAMMERS = ItemTags.create(Reference.ato("ore_hammers"));

    // ********************** ALUMINIUM

    public static final TagKey<Item> ALUMINUM_ORE_ITEM = ItemTags.create(Reference.ore("aluminum"));
    public static final TagKey<Block> ALUMINUM_ORE_BLOCK = BlockTags.create(Reference.ore("aluminum"));

    public static final TagKey<Item> ALUMINUM_RAW_BLOCK_ITEM = ItemTags.create(Reference.block("raw_aluminum"));
    public static final TagKey<Block> ALUMINUM_RAW_BLOCK_BLOCK = BlockTags.create(Reference.block("raw_aluminum"));

    public static final TagKey<Item> ALUMINUM_BLOCK_ITEM = ItemTags.create(Reference.block("aluminum"));
    public static final TagKey<Block> ALUMINUM_BLOCK_BLOCK = BlockTags.create(Reference.block("aluminum"));

    public static final TagKey<Item> ALUMINUM_RAW = ItemTags.create(Reference.raw_materials("aluminum"));
    public static final TagKey<Item> ALUMINUM_NUGGET = ItemTags.create(Reference.nugget("aluminum"));
    public static final TagKey<Item> ALUMINUM_INGOT = ItemTags.create(Reference.ingot("aluminum"));
    public static final TagKey<Item> ALUMINUM_DUST = ItemTags.create(Reference.dust("aluminum"));
    public static final TagKey<Item> ALUMINUM_GEAR = ItemTags.create(Reference.gear("aluminum"));
    public static final TagKey<Item> ALUMINUM_PLATE = ItemTags.create(Reference.plate("aluminum"));
    public static final TagKey<Item> ALUMINUM_ROD = ItemTags.create(Reference.rod("aluminum"));


    // ********************** LEAD

    public static final TagKey<Item> LEAD_ORE_ITEM = ItemTags.create(Reference.ore("lead"));
    public static final TagKey<Block> LEAD_ORE_BLOCK = BlockTags.create(Reference.ore("lead"));

    public static final TagKey<Item> LEAD_RAW_BLOCK_ITEM = ItemTags.create(Reference.block("raw_lead"));
    public static final TagKey<Block> LEAD_RAW_BLOCK_BLOCK = BlockTags.create(Reference.block("raw_lead"));

    public static final TagKey<Item> LEAD_BLOCK_ITEM = ItemTags.create(Reference.block("lead"));
    public static final TagKey<Block> LEAD_BLOCK_BLOCK = BlockTags.create(Reference.block("lead"));

    public static final TagKey<Item> LEAD_RAW = ItemTags.create(Reference.raw_materials("lead"));
    public static final TagKey<Item> LEAD_NUGGET = ItemTags.create(Reference.nugget("lead"));
    public static final TagKey<Item> LEAD_INGOT = ItemTags.create(Reference.ingot("lead"));
    public static final TagKey<Item> LEAD_DUST = ItemTags.create(Reference.dust("lead"));
    public static final TagKey<Item> LEAD_GEAR = ItemTags.create(Reference.gear("lead"));
    public static final TagKey<Item> LEAD_PLATE = ItemTags.create(Reference.plate("lead"));
    public static final TagKey<Item> LEAD_ROD = ItemTags.create(Reference.rod("lead"));


    // ********************** NICKEl

    public static final TagKey<Item> NICKEL_ORE_ITEM = ItemTags.create(Reference.ore("nickel"));
    public static final TagKey<Block> NICKEL_ORE_BLOCK = BlockTags.create(Reference.ore("nickel"));

    public static final TagKey<Item> NICKEL_RAW_BLOCK_ITEM = ItemTags.create(Reference.block("raw_nickel"));
    public static final TagKey<Block> NICKEL_RAW_BLOCK_BLOCK = BlockTags.create(Reference.block("raw_nickel"));

    public static final TagKey<Item> NICKEL_BLOCK_ITEM = ItemTags.create(Reference.block("nickel"));
    public static final TagKey<Block> NICKEL_BLOCK_BLOCK = BlockTags.create(Reference.block("nickel"));

    public static final TagKey<Item> NICKEL_RAW = ItemTags.create(Reference.raw_materials("nickel"));
    public static final TagKey<Item> NICKEL_NUGGET = ItemTags.create(Reference.nugget("nickel"));
    public static final TagKey<Item> NICKEL_INGOT = ItemTags.create(Reference.ingot("nickel"));
    public static final TagKey<Item> NICKEL_DUST = ItemTags.create(Reference.dust("nickel"));
    public static final TagKey<Item> NICKEL_GEAR = ItemTags.create(Reference.gear("nickel"));
    public static final TagKey<Item> NICKEL_PLATE = ItemTags.create(Reference.plate("nickel"));
    public static final TagKey<Item> NICKEL_ROD = ItemTags.create(Reference.rod("nickel"));

    // ********************** OSMIUM

    public static final TagKey<Item> OSMIUM_ORE_ITEM = ItemTags.create(Reference.ore("osmium"));
    public static final TagKey<Block> OSMIUM_ORE_BLOCK = BlockTags.create(Reference.ore("osmium"));

    public static final TagKey<Item> OSMIUM_RAW_BLOCK_ITEM = ItemTags.create(Reference.block("raw_osmium"));
    public static final TagKey<Block> OSMIUM_RAW_BLOCK_BLOCK = BlockTags.create(Reference.block("raw_osmium"));

    public static final TagKey<Item> OSMIUM_BLOCK_ITEM = ItemTags.create(Reference.block("osmium"));
    public static final TagKey<Block> OSMIUM_BLOCK_BLOCK = BlockTags.create(Reference.block("osmium"));

    public static final TagKey<Item> OSMIUM_RAW = ItemTags.create(Reference.raw_materials("osmium"));
    public static final TagKey<Item> OSMIUM_NUGGET = ItemTags.create(Reference.nugget("osmium"));
    public static final TagKey<Item> OSMIUM_INGOT = ItemTags.create(Reference.ingot("osmium"));
    public static final TagKey<Item> OSMIUM_DUST = ItemTags.create(Reference.dust("osmium"));
    public static final TagKey<Item> OSMIUM_GEAR = ItemTags.create(Reference.gear("osmium"));
    public static final TagKey<Item> OSMIUM_PLATE = ItemTags.create(Reference.plate("osmium"));
    public static final TagKey<Item> OSMIUM_ROD = ItemTags.create(Reference.rod("osmium"));

    // ********************** PLATINUM

    public static final TagKey<Item> PLATINUM_ORE_ITEM = ItemTags.create(Reference.ore("platinum"));
    public static final TagKey<Block> PLATINUM_ORE_BLOCK = BlockTags.create(Reference.ore("platinum"));

    public static final TagKey<Item> PLATINUM_RAW_BLOCK_ITEM = ItemTags.create(Reference.block("raw_platinum"));
    public static final TagKey<Block> PLATINUM_RAW_BLOCK_BLOCK = BlockTags.create(Reference.block("raw_platinum"));

    public static final TagKey<Item> PLATINUM_BLOCK_ITEM = ItemTags.create(Reference.block("platinum"));
    public static final TagKey<Block> PLATINUM_BLOCK_BLOCK = BlockTags.create(Reference.block("platinum"));

    public static final TagKey<Item> PLATINUM_RAW = ItemTags.create(Reference.raw_materials("platinum"));
    public static final TagKey<Item> PLATINUM_NUGGET = ItemTags.create(Reference.nugget("platinum"));

    public static final TagKey<Item> PLATINUM_INGOT = ItemTags.create(Reference.ingot("platinum"));
    public static final TagKey<Item> PLATINUM_DUST = ItemTags.create(Reference.dust("platinum"));
    public static final TagKey<Item> PLATINUM_GEAR = ItemTags.create(Reference.gear("platinum"));
    public static final TagKey<Item> PLATINUM_PLATE = ItemTags.create(Reference.plate("platinum"));
    public static final TagKey<Item> PLATINUM_ROD = ItemTags.create(Reference.rod("platinum"));


    // ********************** SILVER

    public static final TagKey<Item> SILVER_ORE_ITEM = ItemTags.create(Reference.ore("silver"));
    public static final TagKey<Block> SILVER_ORE_BLOCK = BlockTags.create(Reference.ore("silver"));

    public static final TagKey<Item> SILVER_RAW_BLOCK_ITEM = ItemTags.create(Reference.block("raw_silver"));
    public static final TagKey<Block> SILVER_RAW_BLOCK_BLOCK = BlockTags.create(Reference.block("raw_silver"));

    public static final TagKey<Item> SILVER_BLOCK_ITEM = ItemTags.create(Reference.block("silver"));
    public static final TagKey<Block> SILVER_BLOCK_BLOCK = BlockTags.create(Reference.block("silver"));

    public static final TagKey<Item> SILVER_RAW = ItemTags.create(Reference.raw_materials("silver"));
    public static final TagKey<Item> SILVER_NUGGET = ItemTags.create(Reference.nugget("silver"));
    public static final TagKey<Item> SILVER_INGOT = ItemTags.create(Reference.ingot("silver"));
    public static final TagKey<Item> SILVER_DUST = ItemTags.create(Reference.dust("silver"));
    public static final TagKey<Item> SILVER_GEAR = ItemTags.create(Reference.gear("silver"));
    public static final TagKey<Item> SILVER_PLATE = ItemTags.create(Reference.plate("silver"));
    public static final TagKey<Item> SILVER_ROD = ItemTags.create(Reference.rod("silver"));

    // ********************** TIN

    public static final TagKey<Item> TIN_ORE_ITEM = ItemTags.create(Reference.ore("tin"));
    public static final TagKey<Block> TIN_ORE_BLOCK = BlockTags.create(Reference.ore("tin"));

    public static final TagKey<Item> TIN_RAW_BLOCK_ITEM = ItemTags.create(Reference.block("raw_tin"));
    public static final TagKey<Block> TIN_RAW_BLOCK_BLOCK = BlockTags.create(Reference.block("raw_tin"));

    public static final TagKey<Item> TIN_BLOCK_ITEM = ItemTags.create(Reference.block("tin"));
    public static final TagKey<Block> TIN_BLOCK_BLOCK = BlockTags.create(Reference.block("tin"));

    public static final TagKey<Item> TIN_RAW = ItemTags.create(Reference.raw_materials("tin"));
    public static final TagKey<Item> TIN_NUGGET = ItemTags.create(Reference.nugget("tin"));
    public static final TagKey<Item> TIN_INGOT = ItemTags.create(Reference.ingot("tin"));
    public static final TagKey<Item> TIN_DUST = ItemTags.create(Reference.dust("tin"));
    public static final TagKey<Item> TIN_GEAR = ItemTags.create(Reference.gear("tin"));
    public static final TagKey<Item> TIN_PLATE = ItemTags.create(Reference.plate("tin"));
    public static final TagKey<Item> TIN_ROD = ItemTags.create(Reference.rod("tin"));

    // **************** URANIUM

    public static final TagKey<Item> URANIUM_ORE_ITEM = ItemTags.create(Reference.ore("uranium"));
    public static final TagKey<Block> URANIUM_ORE_BLOCK = BlockTags.create(Reference.ore("uranium"));

    public static final TagKey<Item> URANIUM_RAW_BLOCK_ITEM = ItemTags.create(Reference.block("raw_uranium"));
    public static final TagKey<Block> URANIUM_RAW_BLOCK_BLOCK = BlockTags.create(Reference.block("raw_uranium"));

    public static final TagKey<Item> URANIUM_BLOCK_ITEM = ItemTags.create(Reference.block("uranium"));
    public static final TagKey<Block> URANIUM_BLOCK_BLOCK = BlockTags.create(Reference.block("uranium"));

    public static final TagKey<Item> URANIUM_RAW = ItemTags.create(Reference.raw_materials("uranium"));
    public static final TagKey<Item> URANIUM_NUGGET = ItemTags.create(Reference.nugget("uranium"));
    public static final TagKey<Item> URANIUM_INGOT = ItemTags.create(Reference.ingot("uranium"));
    public static final TagKey<Item> URANIUM_DUST = ItemTags.create(Reference.dust("uranium"));
    public static final TagKey<Item> URANIUM_GEAR = ItemTags.create(Reference.gear("uranium"));
    public static final TagKey<Item> URANIUM_PLATE = ItemTags.create(Reference.plate("uranium"));
    public static final TagKey<Item> URANIUM_ROD = ItemTags.create(Reference.rod("uranium"));

    // **************** ZINC

    public static final TagKey<Item> ZINC_ORE_ITEM = ItemTags.create(Reference.ore("zinc"));
    public static final TagKey<Block> ZINC_ORE_BLOCK = BlockTags.create(Reference.ore("zinc"));

    public static final TagKey<Item> ZINC_RAW_BLOCK_ITEM = ItemTags.create(Reference.block("raw_zinc"));
    public static final TagKey<Block> ZINC_RAW_BLOCK_BLOCK = BlockTags.create(Reference.block("raw_zinc"));

    public static final TagKey<Item> ZINC_BLOCK_ITEM = ItemTags.create(Reference.block("zinc"));
    public static final TagKey<Block> ZINC_BLOCK_BLOCK = BlockTags.create(Reference.block("zinc"));

    public static final TagKey<Item> ZINC_RAW = ItemTags.create(Reference.raw_materials("zinc"));
    public static final TagKey<Item> ZINC_NUGGET = ItemTags.create(Reference.nugget("zinc"));
    public static final TagKey<Item> ZINC_INGOT = ItemTags.create(Reference.ingot("zinc"));
    public static final TagKey<Item> ZINC_DUST = ItemTags.create(Reference.dust("zinc"));
    public static final TagKey<Item> ZINC_GEAR = ItemTags.create(Reference.gear("zinc"));
    public static final TagKey<Item> ZINC_PLATE = ItemTags.create(Reference.plate("zinc"));
    public static final TagKey<Item> ZINC_ROD = ItemTags.create(Reference.rod("zinc"));

    // **************** IRIDIUM

    public static final TagKey<Item> IRIDIUM_ORE_ITEM = ItemTags.create(Reference.ore("iridium"));
    public static final TagKey<Block> IRIDIUM_ORE_BLOCK = BlockTags.create(Reference.ore("iridium"));

    public static final TagKey<Item> IRIDIUM_RAW_BLOCK_ITEM = ItemTags.create(Reference.block("raw_iridium"));
    public static final TagKey<Block> IRIDIUM_RAW_BLOCK_BLOCK = BlockTags.create(Reference.block("raw_iridium"));

    public static final TagKey<Item> IRIDIUM_BLOCK_ITEM = ItemTags.create(Reference.block("iridium"));
    public static final TagKey<Block> IRIDIUM_BLOCK_BLOCK = BlockTags.create(Reference.block("iridium"));

    public static final TagKey<Item> IRIDIUM_RAW = ItemTags.create(Reference.raw_materials("iridium"));
    public static final TagKey<Item> IRIDIUM_NUGGET = ItemTags.create(Reference.nugget("iridium"));
    public static final TagKey<Item> IRIDIUM_INGOT = ItemTags.create(Reference.ingot("iridium"));
    public static final TagKey<Item> IRIDIUM_DUST = ItemTags.create(Reference.dust("iridium"));
    public static final TagKey<Item> IRIDIUM_GEAR = ItemTags.create(Reference.gear("iridium"));
    public static final TagKey<Item> IRIDIUM_PLATE = ItemTags.create(Reference.plate("iridium"));
    public static final TagKey<Item> IRIDIUM_ROD = ItemTags.create(Reference.rod("iridium"));

    // ###################### ALLOYS

    // **************** BRONZE

    public static final TagKey<Item> BRONZE_BLOCK_ITEM = ItemTags.create(Reference.block("bronze"));
    public static final TagKey<Block> BRONZE_BLOCK_BLOCK = BlockTags.create(Reference.block("bronze"));

    public static final TagKey<Item> BRONZE_NUGGET = ItemTags.create(Reference.nugget("bronze"));
    public static final TagKey<Item> BRONZE_INGOT = ItemTags.create(Reference.ingot("bronze"));
    public static final TagKey<Item> BRONZE_DUST = ItemTags.create(Reference.dust("bronze"));
    public static final TagKey<Item> BRONZE_GEAR = ItemTags.create(Reference.gear("bronze"));
    public static final TagKey<Item> BRONZE_PLATE = ItemTags.create(Reference.plate("bronze"));
    public static final TagKey<Item> BRONZE_ROD = ItemTags.create(Reference.rod("bronze"));

    // **************** BRASS

    public static final TagKey<Item> BRASS_BLOCK_ITEM = ItemTags.create(Reference.block("brass"));
    public static final TagKey<Block> BRASS_BLOCK_BLOCK = BlockTags.create(Reference.block("brass"));

    public static final TagKey<Item> BRASS_NUGGET = ItemTags.create(Reference.nugget("brass"));
    public static final TagKey<Item> BRASS_INGOT = ItemTags.create(Reference.ingot("brass"));
    public static final TagKey<Item> BRASS_DUST = ItemTags.create(Reference.dust("brass"));
    public static final TagKey<Item> BRASS_GEAR = ItemTags.create(Reference.gear("brass"));
    public static final TagKey<Item> BRASS_PLATE = ItemTags.create(Reference.plate("brass"));
    public static final TagKey<Item> BRASS_ROD = ItemTags.create(Reference.rod("brass"));

    // **************** STEEL

    public static final TagKey<Item> STEEL_BLOCK_ITEM = ItemTags.create(Reference.block("steel"));
    public static final TagKey<Block> STEEL_BLOCK_BLOCK = BlockTags.create(Reference.block("steel"));

    public static final TagKey<Item> STEEL_NUGGET = ItemTags.create(Reference.nugget("steel"));
    public static final TagKey<Item> STEEL_INGOT = ItemTags.create(Reference.ingot("steel"));
    public static final TagKey<Item> STEEL_DUST = ItemTags.create(Reference.dust("steel"));
    public static final TagKey<Item> STEEL_GEAR = ItemTags.create(Reference.gear("steel"));
    public static final TagKey<Item> STEEL_PLATE = ItemTags.create(Reference.plate("steel"));
    public static final TagKey<Item> STEEL_ROD = ItemTags.create(Reference.rod("steel"));

    // **************** INVAR

    public static final TagKey<Item> INVAR_BLOCK_ITEM = ItemTags.create(Reference.block("invar"));
    public static final TagKey<Block> INVAR_BLOCK_BLOCK = BlockTags.create(Reference.block("invar"));

    public static final TagKey<Item> INVAR_NUGGET = ItemTags.create(Reference.nugget("invar"));
    public static final TagKey<Item> INVAR_INGOT = ItemTags.create(Reference.ingot("invar"));
    public static final TagKey<Item> INVAR_DUST = ItemTags.create(Reference.dust("invar"));
    public static final TagKey<Item> INVAR_GEAR = ItemTags.create(Reference.gear("invar"));
    public static final TagKey<Item> INVAR_PLATE = ItemTags.create(Reference.plate("invar"));
    public static final TagKey<Item> INVAR_ROD = ItemTags.create(Reference.rod("invar"));

    // **************** CONSTANTAN

    public static final TagKey<Item> CONSTANTAN_BLOCK_ITEM = ItemTags.create(Reference.block("constantan"));
    public static final TagKey<Block> CONSTANTAN_BLOCK_BLOCK = BlockTags.create(Reference.block("constantan"));

    public static final TagKey<Item> CONSTANTAN_NUGGET = ItemTags.create(Reference.nugget("constantan"));
    public static final TagKey<Item> CONSTANTAN_INGOT = ItemTags.create(Reference.ingot("constantan"));
    public static final TagKey<Item> CONSTANTAN_DUST = ItemTags.create(Reference.dust("constantan"));
    public static final TagKey<Item> CONSTANTAN_GEAR = ItemTags.create(Reference.gear("constantan"));
    public static final TagKey<Item> CONSTANTAN_PLATE = ItemTags.create(Reference.plate("constantan"));
    public static final TagKey<Item> CONSTANTAN_ROD = ItemTags.create(Reference.rod("constantan"));

    // **************** ELECTRUM

    public static final TagKey<Item> ELECTRUM_BLOCK_ITEM = ItemTags.create(Reference.block("electrum"));
    public static final TagKey<Block> ELECTRUM_BLOCK_BLOCK = BlockTags.create(Reference.block("electrum"));

    public static final TagKey<Item> ELECTRUM_NUGGET = ItemTags.create(Reference.nugget("electrum"));
    public static final TagKey<Item> ELECTRUM_INGOT = ItemTags.create(Reference.ingot("electrum"));
    public static final TagKey<Item> ELECTRUM_DUST = ItemTags.create(Reference.dust("electrum"));
    public static final TagKey<Item> ELECTRUM_GEAR = ItemTags.create(Reference.gear("electrum"));
    public static final TagKey<Item> ELECTRUM_PLATE = ItemTags.create(Reference.plate("electrum"));
    public static final TagKey<Item> ELECTRUM_ROD = ItemTags.create(Reference.rod("electrum"));

    // **************** ENDERIUM

    public static final TagKey<Item> ENDERIUM_BLOCK_ITEM = ItemTags.create(Reference.block("enderium"));
    public static final TagKey<Block> ENDERIUM_BLOCK_BLOCK = BlockTags.create(Reference.block("enderium"));

    public static final TagKey<Item> ENDERIUM_NUGGET = ItemTags.create(Reference.nugget("enderium"));
    public static final TagKey<Item> ENDERIUM_INGOT = ItemTags.create(Reference.ingot("enderium"));
    public static final TagKey<Item> ENDERIUM_DUST = ItemTags.create(Reference.dust("enderium"));
    public static final TagKey<Item> ENDERIUM_GEAR = ItemTags.create(Reference.gear("enderium"));
    public static final TagKey<Item> ENDERIUM_PLATE = ItemTags.create(Reference.plate("enderium"));
    public static final TagKey<Item> ENDERIUM_ROD = ItemTags.create(Reference.rod("enderium"));

    // **************** LUMIUM

    public static final TagKey<Item> LUMIUM_BLOCK_ITEM = ItemTags.create(Reference.block("lumium"));
    public static final TagKey<Block> LUMIUM_BLOCK_BLOCK = BlockTags.create(Reference.block("lumium"));

    public static final TagKey<Item> LUMIUM_NUGGET = ItemTags.create(Reference.nugget("lumium"));
    public static final TagKey<Item> LUMIUM_INGOT = ItemTags.create(Reference.ingot("lumium"));
    public static final TagKey<Item> LUMIUM_DUST = ItemTags.create(Reference.dust("lumium"));
    public static final TagKey<Item> LUMIUM_GEAR = ItemTags.create(Reference.gear("lumium"));
    public static final TagKey<Item> LUMIUM_PLATE = ItemTags.create(Reference.plate("lumium"));
    public static final TagKey<Item> LUMIUM_ROD = ItemTags.create(Reference.rod("lumium"));

    // **************** SIGNALUM

    public static final TagKey<Item> SIGNALUM_BLOCK_ITEM = ItemTags.create(Reference.block("signalum"));
    public static final TagKey<Block> SIGNALUM_BLOCK_BLOCK = BlockTags.create(Reference.block("signalum"));

    public static final TagKey<Item> SIGNALUM_NUGGET = ItemTags.create(Reference.nugget("signalum"));
    public static final TagKey<Item> SIGNALUM_INGOT = ItemTags.create(Reference.ingot("signalum"));
    public static final TagKey<Item> SIGNALUM_DUST = ItemTags.create(Reference.dust("signalum"));
    public static final TagKey<Item> SIGNALUM_GEAR = ItemTags.create(Reference.gear("signalum"));
    public static final TagKey<Item> SIGNALUM_PLATE = ItemTags.create(Reference.plate("signalum"));

    // ###################### ALL THE GEMS

    // **************** RUBY

    public static final TagKey<Block> RUBY_ORE_BLOCK = BlockTags.create(Reference.ore("ruby"));
    public static final TagKey<Block> RUBY_BLOCK_BLOCK = BlockTags.create(Reference.block("ruby"));

    public static final TagKey<Item> RUBY_ORE = ItemTags.create(Reference.ore("ruby"));
    public static final TagKey<Item> RUBY = ItemTags.create(Reference.gem("ruby"));
    public static final TagKey<Item> RUBY_BLOCK = ItemTags.create(Reference.block("ruby"));
    public static final TagKey<Item> RUBY_DUST = ItemTags.create(Reference.dust("ruby"));

    // **************** PERIDOT

    public static final TagKey<Item> PERIDOT_ORE_ITEM = ItemTags.create(Reference.ore("peridot"));
    public static final TagKey<Block> PERIDOT_ORE_BLOCK = BlockTags.create(Reference.ore("peridot"));

    public static final TagKey<Item> PERIDOT_BLOCK_ITEM = ItemTags.create(Reference.block("peridot"));
    public static final TagKey<Block> PERIDOT_BLOCK_BLOCK = BlockTags.create(Reference.block("peridot"));

    public static final TagKey<Item> PERIDOT = ItemTags.create(Reference.gem("peridot"));
    public static final TagKey<Item> PERIDOT_DUST = ItemTags.create(Reference.dust("peridot"));

    // **************** SAPPHIRE

    public static final TagKey<Item> SAPPHIRE_ORE_ITEM = ItemTags.create(Reference.ore("sapphire"));
    public static final TagKey<Block> SAPPHIRE_ORE_BLOCK = BlockTags.create(Reference.ore("sapphire"));

    public static final TagKey<Item> SAPPHIRE_BLOCK_ITEM = ItemTags.create(Reference.block("sapphire"));
    public static final TagKey<Block> SAPPHIRE_BLOCK_BLOCK = BlockTags.create(Reference.block("sapphire"));

    public static final TagKey<Item> SAPPHIRE = ItemTags.create(Reference.gem("sapphire"));
    public static final TagKey<Item> SAPPHIRE_DUST = ItemTags.create(Reference.dust("sapphire"));

    // **************** CINNABAR

    public static final TagKey<Item> CINNABAR_ORE_ITEM = ItemTags.create(Reference.ore("cinnabar"));
    public static final TagKey<Block> CINNABAR_ORE_BLOCK = BlockTags.create(Reference.ore("cinnabar"));

    public static final TagKey<Item> CINNABAR_BLOCK_ITEM = ItemTags.create(Reference.block("cinnabar"));
    public static final TagKey<Block> CINNABAR_BLOCK_BLOCK = BlockTags.create(Reference.block("cinnabar"));

    public static final TagKey<Item> CINNABAR = ItemTags.create(Reference.gem("cinnabar"));
    public static final TagKey<Item> CINNABAR_DUST = ItemTags.create(Reference.dust("cinnabar"));

    // **************** FLUORITE

    public static final TagKey<Item> FLUORITE_ORE_ITEM = ItemTags.create(Reference.ore("fluorite"));
    public static final TagKey<Block> FLUORITE_ORE_BLOCK = BlockTags.create(Reference.ore("fluorite"));

    public static final TagKey<Item> FLUORITE_BLOCK_ITEM = ItemTags.create(Reference.block("fluorite"));
    public static final TagKey<Block> FLUORITE_BLOCK_BLOCK = BlockTags.create(Reference.block("fluorite"));

    public static final TagKey<Item> FLUORITE = ItemTags.create(Reference.gem("fluorite"));
    public static final TagKey<Item> FLUORITE_DUST = ItemTags.create(Reference.dust("fluorite"));

    // ###################### ALL THE DUSTS

    // **************** SALT

    public static final TagKey<Item> SALT_ORE_ITEM = ItemTags.create(Reference.ore("salt"));
    public static final TagKey<Block> SALT_ORE_BLOCK = BlockTags.create(Reference.ore("salt"));

    public static final TagKey<Item> SALT_BLOCK_ITEM = ItemTags.create(Reference.block("salt"));
    public static final TagKey<Block> SALT_BLOCK_BLOCK = BlockTags.create(Reference.block("salt"));

    public static final TagKey<Item> SALT = ItemTags.create(Reference.dust("salt"));

    // **************** SULFUR

    public static final TagKey<Item> SULFUR_ORE_ITEM = ItemTags.create(Reference.ore("sulfur"));
    public static final TagKey<Block> SULFUR_ORE_BLOCK = BlockTags.create(Reference.ore("sulfur"));

    public static final TagKey<Item> SULFUR_BLOCK_ITEM = ItemTags.create(Reference.block("sulfur"));
    public static final TagKey<Block> SULFUR_BLOCK_BLOCK = BlockTags.create(Reference.block("sulfur"));

    public static final TagKey<Item> SULFUR = ItemTags.create(Reference.dust("sulfur"));

    // ###################### VANILLA MATERIALS

    // **************** COAL

    public static final TagKey<Item> COAL_ORE_ITEM = ItemTags.create(Reference.ore("coal"));
    public static final TagKey<Block> COAL_ORE_BLOCK = BlockTags.create(Reference.ore("coal"));

    // **************** LAPIS

    public static final TagKey<Item> LAPIS_ORE_ITEM = ItemTags.create(Reference.ore("lapis"));
    public static final TagKey<Block> LAPIS_ORE_BLOCK = BlockTags.create(Reference.ore("lapis"));

    // **************** REDSTONE

    public static final TagKey<Item> REDSTONE_ORE_ITEM = ItemTags.create(Reference.ore("redstone"));
    public static final TagKey<Block> REDSTONE_ORE_BLOCK = BlockTags.create(Reference.ore("redstone"));

    // **************** EMERALD

    public static final TagKey<Item> EMERALD_ORE_ITEM = ItemTags.create(Reference.ore("emerald"));
    public static final TagKey<Block> EMERALD_ORE_BLOCK = BlockTags.create(Reference.ore("emerald"));

    // **************** QUARTZ

    public static final TagKey<Item> QUARTZ_ORE_ITEM = ItemTags.create(Reference.ore("quartz"));
    public static final TagKey<Block> QUARTZ_ORE_BLOCK = BlockTags.create(Reference.ore("quartz"));

    // **************** IRON

    public static final TagKey<Item> IRON_ORE_ITEM = ItemTags.create(Reference.ore("iron"));
    public static final TagKey<Block> IRON_ORE_BLOCK = BlockTags.create(Reference.ore("iron"));

    public static final TagKey<Item> IRON_DUST = ItemTags.create(Reference.dust("iron"));
    public static final TagKey<Item> IRON_ROD = ItemTags.create(Reference.rod("iron"));
    public static final TagKey<Item> IRON_GEAR = ItemTags.create(Reference.gear("iron"));
    public static final TagKey<Item> IRON_PLATE = ItemTags.create(Reference.plate("iron"));

    // **************** COPPER

    public static final TagKey<Item> COPPER_ORE_ITEM = ItemTags.create(Reference.ore("copper"));
    public static final TagKey<Block> COPPER_ORE_BLOCK = BlockTags.create(Reference.ore("copper"));

    public static final TagKey<Item> COPPER_NUGGET = ItemTags.create(Reference.nugget("copper"));

    public static final TagKey<Item> COPPER_DUST = ItemTags.create(Reference.dust("copper"));
    public static final TagKey<Item> COPPER_ROD = ItemTags.create(Reference.rod("copper"));
    public static final TagKey<Item> COPPER_GEAR = ItemTags.create(Reference.gear("copper"));
    public static final TagKey<Item> COPPER_PLATE = ItemTags.create(Reference.plate("copper"));

    // **************** GOLD

    public static final TagKey<Item> GOLD_ORE_ITEM = ItemTags.create(Reference.ore("gold"));
    public static final TagKey<Block> GOLD_ORE_BLOCK = BlockTags.create(Reference.ore("gold"));

    public static final TagKey<Item> GOLD_DUST = ItemTags.create(Reference.dust("gold"));
    public static final TagKey<Item> GOLD_ROD = ItemTags.create(Reference.rod("gold"));
    public static final TagKey<Item> GOLD_GEAR = ItemTags.create(Reference.gear("gold"));
    public static final TagKey<Item> GOLD_PLATE = ItemTags.create(Reference.plate("gold"));

    // **************** DIAMOND

    public static final TagKey<Item> DIAMOND_ORE_ITEM = ItemTags.create(Reference.ore("diamond"));
    public static final TagKey<Block> DIAMOND_ORE_BLOCK = BlockTags.create(Reference.ore("diamond"));

    public static final TagKey<Item> DIAMOND_DUST = ItemTags.create(Reference.dust("diamond"));
    public static final TagKey<Item> DIAMOND_ROD = ItemTags.create(Reference.rod("diamond"));
    public static final TagKey<Item> DIAMOND_GEAR = ItemTags.create(Reference.gear("diamond"));
    public static final TagKey<Item> DIAMOND_PLATE = ItemTags.create(Reference.plate("diamond"));

    // ###################### MEK COMPAT

    public static final TagKey<Item> CRYSTAL = ItemTags.create(Reference.forge("crystals"));
    public static final TagKey<Item> SHARD = ItemTags.create(Reference.forge("shards"));
    public static final TagKey<Item> CLUMP = ItemTags.create(Reference.forge("clumps"));
    public static final TagKey<Item> DIRTY_DUST = ItemTags.create(Reference.forge("dirty_dusts"));

    // **************** ALUMINIUM

    public static final TagKey<Item> ALUMIUM_CRYSTAL = ItemTags.create(Reference.crystal("aluminum"));
    public static final TagKey<Item> ALUMIUM_SHARD = ItemTags.create(Reference.shard("aluminum"));
    public static final TagKey<Item> ALUMIUM_CLUMP = ItemTags.create(Reference.clump("aluminum"));
    public static final TagKey<Item> ALUMIUM_DIRTY_DUST = ItemTags.create(Reference.dirty_dust("aluminum"));

    // **************** LEAD

    public static final TagKey<Item> LEAD_CRYSTAL = ItemTags.create(Reference.crystal("lead"));
    public static final TagKey<Item> LEAD_SHARD = ItemTags.create(Reference.shard("lead"));
    public static final TagKey<Item> LEAD_CLUMP = ItemTags.create(Reference.clump("lead"));
    public static final TagKey<Item> LEAD_DIRTY_DUST = ItemTags.create(Reference.dirty_dust("lead"));

    // **************** NICKEL

    public static final TagKey<Item> NICKEL_CRYSTAL = ItemTags.create(Reference.crystal("nickel"));
    public static final TagKey<Item> NICKEL_SHARD = ItemTags.create(Reference.shard("nickel"));
    public static final TagKey<Item> NICKEL_CLUMP = ItemTags.create(Reference.clump("nickel"));
    public static final TagKey<Item> NICKEL_DIRTY_DUST = ItemTags.create(Reference.dirty_dust("nickel"));

    // **************** OSMIUM

    public static final TagKey<Item> OSMIUM_CRYSTAL = ItemTags.create(Reference.crystal("osmium"));
    public static final TagKey<Item> OSMIUM_SHARD = ItemTags.create(Reference.shard("osmium"));
    public static final TagKey<Item> OSMIUM_CLUMP = ItemTags.create(Reference.clump("osmium"));
    public static final TagKey<Item> OSMIUM_DIRTY_DUST = ItemTags.create(Reference.dirty_dust("osmium"));

    // **************** PLATINUM

    public static final TagKey<Item> PLATINUM_CRYSTAL = ItemTags.create(Reference.crystal("platinum"));
    public static final TagKey<Item> PLATINUM_SHARD = ItemTags.create(Reference.shard("platinum"));
    public static final TagKey<Item> PLATINUM_CLUMP = ItemTags.create(Reference.clump("platinum"));
    public static final TagKey<Item> PLATINUM_DIRTY_DUST = ItemTags.create(Reference.dirty_dust("platinum"));

    // **************** SILVER

    public static final TagKey<Item> SILVER_CRYSTAL = ItemTags.create(Reference.crystal("silver"));
    public static final TagKey<Item> SILVER_SHARD = ItemTags.create(Reference.shard("silver"));
    public static final TagKey<Item> SILVER_CLUMP = ItemTags.create(Reference.clump("silver"));
    public static final TagKey<Item> SILVER_DIRTY_DUST = ItemTags.create(Reference.dirty_dust("silver"));

    // **************** TIN

    public static final TagKey<Item> TIN_CRYSTAL = ItemTags.create(Reference.crystal("tin"));
    public static final TagKey<Item> TIN_SHARD = ItemTags.create(Reference.shard("tin"));
    public static final TagKey<Item> TIN_CLUMP = ItemTags.create(Reference.clump("tin"));
    public static final TagKey<Item> TIN_DIRTY_DUST = ItemTags.create(Reference.dirty_dust("tin"));

    // **************** URANIUM

    public static final TagKey<Item> URANIUM_CRYSTAL = ItemTags.create(Reference.crystal("uranium"));
    public static final TagKey<Item> URANIUM_SHARD = ItemTags.create(Reference.shard("uranium"));
    public static final TagKey<Item> URANIUM_CLUMP = ItemTags.create(Reference.clump("uranium"));
    public static final TagKey<Item> URANIUM_DIRTY_DUST = ItemTags.create(Reference.dirty_dust("uranium"));

    // **************** ZINC

    public static final TagKey<Item> ZINC_CRYSTAL = ItemTags.create(Reference.crystal("zinc"));
    public static final TagKey<Item> ZINC_SHARD = ItemTags.create(Reference.shard("zinc"));
    public static final TagKey<Item> ZINC_CLUMP = ItemTags.create(Reference.clump("zinc"));
    public static final TagKey<Item> ZINC_DIRTY_DUST = ItemTags.create(Reference.dirty_dust("zinc"));

    // **************** IRIDIUM

    public static final TagKey<Item> IRIDIUM_CRYSTAL = ItemTags.create(Reference.crystal("iridium"));
    public static final TagKey<Item> IRIDIUM_SHARD = ItemTags.create(Reference.shard("iridium"));
    public static final TagKey<Item> IRIDIUM_CLUMP = ItemTags.create(Reference.clump("iridium"));
    public static final TagKey<Item> IRIDIUM_DIRTY_DUST = ItemTags.create(Reference.dirty_dust("iridium"));

    private ItemTagRegistry() {

    }

    private static TagKey<Item> forge(String name) {
        return net.minecraft.tags.ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
    }
}