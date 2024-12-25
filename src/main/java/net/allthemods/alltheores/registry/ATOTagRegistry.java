package net.allthemods.alltheores.registry;


import net.allthemods.alltheores.infos.Reference;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class ATOTagRegistry {

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

    public static final TagKey<Item> ORE_HAMMERS = ItemTags.create(Reference.ato("ore_hammers"));

    public static final TagKey<Item> COPPER_NUGGET = ItemTags.create(Reference.nugget("copper"));

    public static final TagKey<Item> GEARS = ItemTags.create(Reference.forge("gears"));
    public static final TagKey<Item> PLATES = ItemTags.create(Reference.forge("plates"));

    public static final TagKey<Item> CRYSTALS = ItemTags.create(Reference.forge("crystals"));
    public static final TagKey<Item> SHARDS = ItemTags.create(Reference.forge("shards"));
    public static final TagKey<Item> CLUMPS = ItemTags.create(Reference.forge("clumps"));
    public static final TagKey<Item> DIRTY_DUSTS = ItemTags.create(Reference.forge("dirty_dusts"));

    public static final TagKey<Fluid> MOLTEN_FLUID = FluidTags.create(Reference.forge("molten"));
    public static final TagKey<Block> MOLTEN_BLOCK = BlockTags.create(Reference.forge("molten"));
}