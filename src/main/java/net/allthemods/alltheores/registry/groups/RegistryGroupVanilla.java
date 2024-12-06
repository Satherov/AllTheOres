package net.allthemods.alltheores.registry.groups;

import net.allthemods.alltheores.infos.Reference;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.List;

import static net.allthemods.alltheores.registry.ATORegistry.material;

public class RegistryGroupVanilla {

    public final String name;
    public final String type;

    private static final List<RegistryGroupVanilla> instances = new ArrayList<>();

    // Item Tags
    public final TagKey<Item> MATERIAL_TAG;

    public final TagKey<Item> DUST_TAG;
    public final TagKey<Item> ROD_TAG;
    public final TagKey<Item> GEAR_TAG;
    public final TagKey<Item> PLATE_TAG;

    // Items
    public final Item MATERIAL;

    public final DeferredHolder<Item, Item> DUST;
    public final DeferredHolder<Item, Item> ROD;
    public final DeferredHolder<Item, Item> GEAR;
    public final DeferredHolder<Item, Item> PLATE;
    public final TagKey<Item> DROP_TAG;

    public RegistryGroupVanilla(String name, String type, TagKey<Item> materialTag, Item material) {
        this.name = name;
        this.type = type;

        instances.add(this);

        // Item Tags
        this.MATERIAL_TAG = materialTag;

        DUST_TAG = ItemTags.create(Reference.dust(name));
        ROD_TAG = ItemTags.create(Reference.rod(name));
        GEAR_TAG = ItemTags.create(Reference.gear(name));
        PLATE_TAG = ItemTags.create(Reference.plate(name));

        switch (type) {
            case "ingot" :
                DROP_TAG = ItemTags.create(Reference.raw_materials(name));
                break;
            case "gem" :
                DROP_TAG = ItemTags.create(Reference.gem(name));
                break;
            case "netherite" :
                DROP_TAG = ItemTags.create(Reference.ore(String.format("%s_scrap", name)));
                break;
            default:
                throw new IllegalArgumentException("Invalid Type: " + name);
        }

        // Items
        this.MATERIAL = material;

        DUST = material(String.format("%s_dust", name));
        ROD = material(String.format("%s_rod", name));
        GEAR = material(String.format("%s_gear", name));
        PLATE = material(String.format("%s_plate", name));
    }

    public static List<RegistryGroupVanilla> getVanillaInstances() {
        return instances;
    }
}
