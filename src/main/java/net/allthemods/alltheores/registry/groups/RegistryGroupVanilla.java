package net.allthemods.alltheores.registry.groups;

import net.allthemods.alltheores.infos.Reference;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.List;

import static net.allthemods.alltheores.blocks.BlockList.material;

public class RegistryGroupVanilla {

    public final String name;

    private static final List<RegistryGroupVanilla> instances = new ArrayList<>();

    // Item Tags
    public final TagKey<Item> DUST_TAG;

    public final TagKey<Item> MATERIAL_TAG;

    // Items
    public final DeferredHolder<Item, Item> DUST;

    public final DeferredHolder<Item, Item> ROD;
    public final DeferredHolder<Item, Item> GEAR;
    public final DeferredHolder<Item, Item> PLATE;

    public RegistryGroupVanilla(String name, TagKey<Item> materialTag) {
        this.name = name;

        instances.add(this);

        this.MATERIAL_TAG = materialTag;

        // Item Tags
        DUST_TAG = ItemTags.create(Reference.dust(name));

        // Items
        DUST = material(String.format("%s_dust", name));

        ROD = material(String.format("%s_rod", name));
        GEAR = material(String.format("%s_gear", name));
        PLATE = material(String.format("%s_plate", name));
    }

    public static List<RegistryGroupVanilla> getVanillaInstances() {
        return instances;
    }
}
