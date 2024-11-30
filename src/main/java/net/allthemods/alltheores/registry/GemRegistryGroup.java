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

public class GemRegistryGroup{

    public final String name;
    public final OreRegistryGroup ORES;

    //Item Tags
    public final TagKey<Item> DUST_TAG;


    //Items
    public final DeferredHolder<Item, Item> DUST;

    public GemRegistryGroup(String name) {
        this.name = name;
        ORES = new OreRegistryGroup(name, "gem");

        //Item Tags
        DUST_TAG = ItemTags.create(Reference.dust(name));

        //Items
        DUST = material(String.format("%s_dust", name));
    }
}
