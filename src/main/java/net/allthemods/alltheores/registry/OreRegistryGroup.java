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
import net.neoforged.neoforge.registries.DeferredHolder;

import static net.allthemods.alltheores.blocks.BlockList.*;

public class OreRegistryGroup {

    public final String name;

    // Tags
    public final TagKey<Block> ORE_TAG;
    public final TagKey<Item> ORE_ITEM_TAG;

    // Blocks
    public final DeferredHolder<Block, Block> ORE;
    public final DeferredHolder<Block, Block> SLATE_ORE;
    public final DeferredHolder<Block, Block> NETHER_ORE;
    public final DeferredHolder<Block, Block> END_ORE;
    public final DeferredHolder<Block, Block> OTHER_ORE;
    public final DeferredHolder<Block, Block> RAW_BLOCK;

    // BlockItems
    public final DeferredHolder<Item, BlockItem> ORE_ITEM;
    public final DeferredHolder<Item, BlockItem> SLATE_ORE_ITEM;
    public final DeferredHolder<Item, BlockItem> NETHER_ORE_ITEM;
    public final DeferredHolder<Item, BlockItem> END_ORE_ITEM;
    public final DeferredHolder<Item, BlockItem> OTHER_ORE_ITEM;
    public final DeferredHolder<Item, BlockItem> RAW_BLOCK_ITEM;


    public OreRegistryGroup(String name) {
        this.name = name;

        ORE_TAG = BlockTags.create(Reference.ore(name));
        ORE_ITEM_TAG = ItemTags.create(Reference.ore(name));

        ORE = BlockList.ORE.register(String.format("%s_ore", name), StoneOreBlock::new);
        SLATE_ORE = BlockList.ORE.register(String.format("%s_deepslate_ore", name), SlateOreBlock::new);
        NETHER_ORE = BlockList.ORE.register(String.format("%s_nether_ore", name), NetherOreBlock::new);
        END_ORE = BlockList.ORE.register(String.format("%s_end_ore", name), EndOreBlock::new);
        OTHER_ORE = BlockList.ORE.register(String.format("%s_other_ore", name), OtherOreBlock::new);
        RAW_BLOCK = BlockList.BLOCKS.register(String.format("raw_%s_block", name), () -> new Block(Blocks.STONE.properties().strength(3.0f, 3.0f)));

        ORE_ITEM = blockItem(ORE);
        SLATE_ORE_ITEM = blockItem(SLATE_ORE);
        NETHER_ORE_ITEM = blockItem(NETHER_ORE);
        END_ORE_ITEM = blockItem(END_ORE);
        OTHER_ORE_ITEM = blockItem(OTHER_ORE);
        RAW_BLOCK_ITEM = blockItem(RAW_BLOCK);
    }
}
