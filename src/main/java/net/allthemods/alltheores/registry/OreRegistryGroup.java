package net.allthemods.alltheores.registry;

import net.allthemods.alltheores.blocks.BlockList;
import net.allthemods.alltheores.blocks.ore.*;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredHolder;

import static net.allthemods.alltheores.blocks.BlockList.*;
import static net.allthemods.alltheores.blocks.BlockList.blockItem;

public class OreRegistryGroup {

    public final String name;

    //Item Tags
    public final TagKey<Item> DROP_TAG;

    // Block Tags
    public final TagKey<Block> ORE_BLOCK_TAG;
    public final TagKey<Block> DROP_BLOCK_TAG;

    // BlockItem Tags
    public final TagKey<Item> ORE_BLOCK_ITEM_TAG;
    public final TagKey<Item> DROP_BLOCK_ITEM_TAG;

    // Items
    public final DeferredHolder<Item, Item> DROP;

    // Blocks
    public final DeferredHolder<Block, Block> STONE_ORE_BLOCK;
    public final DeferredHolder<Block, Block> SLATE_ORE_BLOCK;
    public final DeferredHolder<Block, Block> NETHER_ORE_BLOCK;
    public final DeferredHolder<Block, Block> END_ORE_BLOCK;
    public final DeferredHolder<Block, Block> OTHER_ORE_BLOCK;

    public final DeferredHolder<Block, Block> DROP_BLOCK;

    // BlockItems
    public final DeferredHolder<Item, BlockItem> STONE_ORE_BLOCK_ITEM;
    public final DeferredHolder<Item, BlockItem> SLATE_ORE_BLOCK_ITEM;
    public final DeferredHolder<Item, BlockItem> NETHER_ORE_BLOCK_ITEM;
    public final DeferredHolder<Item, BlockItem> END_ORE_BLOCK_ITEM;
    public final DeferredHolder<Item, BlockItem> OTHER_ORE_BLOCK_ITEM;

    public final DeferredHolder<Item, BlockItem> DROP_BLOCK_ITEM;

    public OreRegistryGroup(String name, String type) {

        this.name = name;

        //Block Tags
        ORE_BLOCK_TAG = BlockTags.create(Reference.ore(name));

        //BlockItem Tags
        ORE_BLOCK_ITEM_TAG = ItemTags.create(Reference.ore(name));

        // Blocks
        STONE_ORE_BLOCK = BLOCKS.register(String.format("%s_ore", name), StoneOreBlock::new);
        SLATE_ORE_BLOCK = BLOCKS.register(String.format("%s_deepslate_ore", name), SlateOreBlock::new);
        NETHER_ORE_BLOCK = BLOCKS.register(String.format("%s_nether_ore", name), NetherOreBlock::new);
        END_ORE_BLOCK = BLOCKS.register(String.format("%s_end_ore", name), EndOreBlock::new);
        OTHER_ORE_BLOCK = BLOCKS.register(String.format("%s_other_ore", name), OtherOreBlock::new);

        // BlockItems
        STONE_ORE_BLOCK_ITEM = blockItem(STONE_ORE_BLOCK);
        SLATE_ORE_BLOCK_ITEM = blockItem(SLATE_ORE_BLOCK);
        NETHER_ORE_BLOCK_ITEM = blockItem(NETHER_ORE_BLOCK);
        END_ORE_BLOCK_ITEM = blockItem(END_ORE_BLOCK);
        OTHER_ORE_BLOCK_ITEM = blockItem(OTHER_ORE_BLOCK);

        // Item Tags
        DROP_TAG = ItemTags.create(Reference.raw_materials(name));

        //Block Tags
        DROP_BLOCK_TAG = BlockTags.create(Reference.block(name));

        //BlockItem Tags
        DROP_BLOCK_ITEM_TAG = ItemTags.create(Reference.block( name));

        switch (type) {
            case "ore" -> {

                // Items
                DROP = material(String.format("raw_%s", name));

                // Block
                DROP_BLOCK = BlockList.BLOCKS.register(String.format("raw_%s_block", name), () -> new Block(Blocks.STONE.properties().strength(3.0f, 3.0f)));

                // BlockItem
                DROP_BLOCK_ITEM = blockItem(DROP_BLOCK);
            }
            case "dust", "gem" -> {

                // Items
                DROP = material(name);

                // Block
                DROP_BLOCK = BlockList.BLOCKS.register(String.format("%s_block", name), () -> new Block(Blocks.AMETHYST_BLOCK.properties().strength(3.0f, 3.0f)));

                // BlockItem
                DROP_BLOCK_ITEM = blockItem(DROP_BLOCK);
            }
            case null, default -> throw new IllegalArgumentException("Invalid type: " + type);
        }
    }
}
