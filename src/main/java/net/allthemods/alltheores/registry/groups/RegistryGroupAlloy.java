package net.allthemods.alltheores.registry.groups;

import net.allthemods.alltheores.blocks.BlockList;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.registries.DeferredHolder;

import static net.allthemods.alltheores.blocks.BlockList.*;


public class RegistryGroupAlloy {

    public final String name;

    // Item Tags
    public final TagKey<Item> INGOT_TAG;
    public final TagKey<Item> NUGGET_TAG;
    public final TagKey<Item> DUST_TAG;
    public final TagKey<Item> ROD_TAG;
    public final TagKey<Item> GEAR_TAG;
    public final TagKey<Item> PLATE_TAG;

    // Block Tags
    public final TagKey<Block> BLOCK_TAG;

    // BlockItem Tags
    public final TagKey<Item> BLOCK_ITEM_TAG;


    // Items
    public final DeferredHolder<Item, Item> DUST;
    public final DeferredHolder<Item, Item> INGOT;
    public final DeferredHolder<Item, Item> NUGGET;

    public final DeferredHolder<Item, Item> ROD;
    public final DeferredHolder<Item, Item> GEAR;
    public final DeferredHolder<Item, Item> PLATE;

    // Blocks
    public final DeferredHolder<Block, Block> BLOCK;

    // BlockItems
    public final DeferredHolder<Item, BlockItem> BLOCK_ITEM;

    public RegistryGroupAlloy(String name) {
        this.name = name;

        // Item Tags
        INGOT_TAG = ItemTags.create(Reference.ingot(name));
        NUGGET_TAG = ItemTags.create(Reference.nugget(name));
        DUST_TAG = ItemTags.create(Reference.dust(name));
        ROD_TAG = ItemTags.create(Reference.rod(name));
        GEAR_TAG = ItemTags.create(Reference.gear(name));
        PLATE_TAG = ItemTags.create(Reference.plate(name));

        // Block Tags
        BLOCK_TAG = BlockTags.create(Reference.block(name));

        // BlockItem Tags
        BLOCK_ITEM_TAG = ItemTags.create(Reference.block(name));


        // Items
        INGOT = material(String.format("%s_ingot", name));
        NUGGET = material(String.format("%s_nugget", name));
        DUST = material(String.format("%s_dust", name));

        ROD = material(String.format("%s_rod", name));
        GEAR = material(String.format("%s_gear", name));
        PLATE = material(String.format("%s_plate", name));

        // Blocks
        BLOCK = BlockList.BLOCKS.register(String.format("%s_block", name),
                () -> new Block(Block.Properties.of()
                        .strength(3.0f, 3.0f)
                        .sound(SoundType.METAL)));

        // BlockItems
        BLOCK_ITEM = blockItem(BLOCK);
    }
}