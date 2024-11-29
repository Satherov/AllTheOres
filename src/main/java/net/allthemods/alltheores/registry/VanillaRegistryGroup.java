package net.allthemods.alltheores.registry;

import net.allthemods.alltheores.infos.Reference;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;

import static net.allthemods.alltheores.blocks.BlockList.material;

public class VanillaRegistryGroup extends RegistryGroup{
    public final String name;

    // Item Tags
    public final TagKey<Item> DUST_TAG;

    public final TagKey<Item> MATERIAL_TAG;

    // Items
    public final DeferredHolder<Item, Item> DUST;

    public final DeferredHolder<Item, Item> ROD;
    public final DeferredHolder<Item, Item> GEAR;
    public final DeferredHolder<Item, Item> PLATE;

    public VanillaRegistryGroup(String name, TagKey<Item> materialTag) {
        this.name = name;
        this.MATERIAL_TAG = materialTag;

        // Item Tags
        DUST_TAG = ItemTags.create(Reference.dust(name));

        // Items
        DUST = material(String.format("%s_dust", name));

        ROD = material(String.format("%s_rod", name));
        GEAR = material(String.format("%s_gear", name));
        PLATE = material(String.format("%s_plate", name));
    }
}
