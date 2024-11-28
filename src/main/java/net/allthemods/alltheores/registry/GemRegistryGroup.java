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
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.registries.DeferredHolder;

import static net.allthemods.alltheores.blocks.BlockList.blockItem;
import static net.allthemods.alltheores.blocks.BlockList.material;

public class GemRegistryGroup {

    public final OreRegistryGroup ORE_REGISTRY_GROUP;

    public final String name;

    // Tags
    public final TagKey<Block> BLOCK_TAG;
    public final TagKey<Item> BLOCK_ITEM_TAG;

    public final TagKey<Item> GEM_TAG;
    public final TagKey<Item> DUST_TAG;

    // Blocks
    public final DeferredHolder<Block, Block> BLOCK;

    // BlockItems
    public final DeferredHolder<Item, BlockItem> BLOCK_ITEM;

    // Items
    public final DeferredHolder<Item, Item> GEM;
    public final DeferredHolder<Item, Item> DUST;

    public GemRegistryGroup(String name) {
        this.name = name;

        ORE_REGISTRY_GROUP = new OreRegistryGroup(name);

        BLOCK_TAG = BlockTags.create(Reference.block(name));
        BLOCK_ITEM_TAG = ItemTags.create(Reference.block(name));

        BLOCK = BlockList.BLOCKS.register(String.format("%s_block", name),
                () -> new Block(Block.Properties.of()
                        .strength(3.0f, 3.0f)
                        .sound(SoundType.AMETHYST)));

        BLOCK_ITEM = blockItem(BLOCK);

        GEM_TAG = ItemTags.create(Reference.gem(name));
        DUST_TAG = ItemTags.create(Reference.dust(name));

        GEM = material(name);
        DUST = material(name);
    }
}
