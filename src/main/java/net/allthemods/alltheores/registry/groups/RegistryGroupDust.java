package net.allthemods.alltheores.registry.groups;

import net.allthemods.alltheores.infos.Reference;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

public class RegistryGroupDust {

    public final String name;

    private static final List<RegistryGroupDust> instances = new ArrayList<>();

    public final RegistryGroupOre ORES;

    // Item Tags
    public final TagKey<Item> DUST_TAG;


    public RegistryGroupDust(String name, int veinSize, int minY, int maxY, int count) {
        this.name = name;

        instances.add(this);

        ORES = new RegistryGroupOre(name, "dust", veinSize, minY, maxY, count);

        //Item Tags
        DUST_TAG = ItemTags.create(Reference.dust(name));
    }

    public static List<RegistryGroupDust> getDustInstances() {
        return instances;
    }
}
