package net.allthemods.alltheores.registry;


import net.allthemods.alltheores.infos.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagRegistry {

    // ###################### ALL THE MODIUM

    public static final TagKey<Block> ANCIENT_STONE = BlockTags.create(ResourceLocation.fromNamespaceAndPath("allthemods", "ancient_stone"));

    // ###################### MEKANISM

    public static final TagKey<Item> MUFFLING_CENTER = ItemTags.create(Reference.mek("muffling_center"));

    // ###################### FORGE


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

    public static final TagKey<Item> COPPER_NUGGET = ItemTags.create(Reference.ato("copper_nugget"));

}