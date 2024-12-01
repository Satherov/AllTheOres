package net.allthemods.alltheores.registry.groups;

import net.allthemods.alltheores.infos.Reference;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.List;

import static net.allthemods.alltheores.blocks.BlockList.material;

public class RegistryGroupGem {

    public final String name;

    private static final List<RegistryGroupGem> instances = new ArrayList<>();

    public final RegistryGroupOre ORES;

    //Item Tags
    public final TagKey<Item> DUST_TAG;


    //Items
    public final DeferredHolder<Item, Item> DUST;

    public RegistryGroupGem(String name, int veinSize, int minY, int maxY, int count) {
        this.name = name;

        instances.add(this);

        ORES = new RegistryGroupOre(name, "gem", veinSize, minY, maxY, count);

        //Item Tags
        DUST_TAG = ItemTags.create(Reference.dust(name));

        //Items
        DUST = material(String.format("%s_dust", name));
    }

    public static List<RegistryGroupGem> getGemInstances() {
        return instances;
    }
}
