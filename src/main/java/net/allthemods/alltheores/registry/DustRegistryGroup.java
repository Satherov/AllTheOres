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
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.registries.DeferredHolder;

import static net.allthemods.alltheores.blocks.BlockList.blockItem;
import static net.allthemods.alltheores.blocks.BlockList.material;

public class DustRegistryGroup extends RegistryGroup{

    public final String name;

    // Item Tags
    public final TagKey<Item> DUST_TAG;

    // Block Tags
    public final TagKey<Block> ORE_TAG;
    public final TagKey<Block> BLOCK_TAG;

    //BlockItem Tags
    public final TagKey<Item> ORE_ITEM_TAG;
    public final TagKey<Item> BLOCK_ITEM_TAG;

    // Items
    public final DeferredHolder<Item, Item> DUST;

    // Blocks
    public final DeferredHolder<Block, Block> ORE;
    public final DeferredHolder<Block, Block> SLATE_ORE;
    public final DeferredHolder<Block, Block> NETHER_ORE;
    public final DeferredHolder<Block, Block> END_ORE;
    public final DeferredHolder<Block, Block> OTHER_ORE;

    public final DeferredHolder<Block, Block> BLOCK;

    // BlockItems
    public final DeferredHolder<Item, BlockItem> ORE_ITEM;
    public final DeferredHolder<Item, BlockItem> SLATE_ORE_ITEM;
    public final DeferredHolder<Item, BlockItem> NETHER_ORE_ITEM;
    public final DeferredHolder<Item, BlockItem> END_ORE_ITEM;
    public final DeferredHolder<Item, BlockItem> OTHER_ORE_ITEM;

    public final DeferredHolder<Item, BlockItem> BLOCK_ITEM;

    public DustRegistryGroup(String name) {
        this.name = name;

        //Item Tags
        DUST_TAG = ItemTags.create(Reference.dust(name));

        //Block Tags
        ORE_TAG = BlockTags.create(Reference.ore(name));
        BLOCK_TAG = BlockTags.create(Reference.block(name));

        //BlockItem Tags
        ORE_ITEM_TAG = ItemTags.create(Reference.ore(name));
        BLOCK_ITEM_TAG = ItemTags.create(Reference.block(name));


        //Items
        DUST = material(name);

        // Blocks
        ORE = BlockList.ORE.register(String.format("%s_ore", name), StoneOreBlock::new);
        SLATE_ORE = BlockList.ORE.register(String.format("%s_deepslate_ore", name), SlateOreBlock::new);
        NETHER_ORE = BlockList.ORE.register(String.format("%s_nether_ore", name), NetherOreBlock::new);
        END_ORE = BlockList.ORE.register(String.format("%s_end_ore", name), EndOreBlock::new);
        OTHER_ORE = BlockList.ORE.register(String.format("%s_other_ore", name), OtherOreBlock::new);

        BLOCK = BlockList.BLOCKS.register(String.format("%s_block", name),
                () -> new Block(Block.Properties.of()
                        .strength(3.0f, 3.0f)
                        .sound(SoundType.AMETHYST)));

        //Block Items
        ORE_ITEM = blockItem(ORE);
        SLATE_ORE_ITEM = blockItem(SLATE_ORE);
        NETHER_ORE_ITEM = blockItem(NETHER_ORE);
        END_ORE_ITEM = blockItem(END_ORE);
        OTHER_ORE_ITEM = blockItem(OTHER_ORE);

        BLOCK_ITEM = blockItem(BLOCK);
    }
}
