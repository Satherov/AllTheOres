package net.allthemods.alltheores.content.blocks.sets.vanilla_sets;

import net.allthemods.alltheores.content.blocks.sets.BlockSet;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.List;

import static net.allthemods.alltheores.registry.ATORegistry.item;

public class VanillaSet extends BlockSet {

    private static final List<VanillaSet> instances = new ArrayList<>();

    public static List<VanillaSet> getVanillaSets() {
        return instances;
    }

    // Item Tags
    public final TagKey<Item> DUST_TAG;
    public final TagKey<Item> ROD_TAG;
    public final TagKey<Item> GEAR_TAG;
    public final TagKey<Item> PLATE_TAG;

    // Items
    public final DeferredHolder<Item, Item> DUST;
    public final DeferredHolder<Item, Item> ROD;
    public final DeferredHolder<Item, Item> GEAR;
    public final DeferredHolder<Item, Item> PLATE;

    public VanillaSet(String name) {
        super(name);
        instances.add(this);

        // Item Tags
        DUST_TAG = ItemTags.create(Reference.dust(name));
        ROD_TAG = ItemTags.create(Reference.rod(name));
        GEAR_TAG = ItemTags.create(Reference.gear(name));
        PLATE_TAG = ItemTags.create(Reference.plate(name));

        // Items
        DUST = item(String.format("%s_dust", name));
        ROD = item(String.format("%s_rod", name));
        GEAR = item(String.format("%s_gear", name));
        PLATE = item(String.format("%s_plate", name));
    }
}
