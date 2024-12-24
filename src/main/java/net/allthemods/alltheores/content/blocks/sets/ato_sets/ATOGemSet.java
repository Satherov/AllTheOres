package net.allthemods.alltheores.content.blocks.sets.ato_sets;

import net.allthemods.alltheores.content.blocks.sets.ESetTypes;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.List;

import static net.allthemods.alltheores.registry.ATORegistry.item;

public class ATOGemSet extends ATOMaterialSet {

    private static final List<ATOGemSet> instances = new ArrayList<>();
    public static List<ATOGemSet> getGemSets() {
        return instances;
    }

    public final ATOOreSet ORES;

    // Item Tags
    public final TagKey<Item> GEM_TAG;

    // Items
    public final DeferredHolder<Item, Item> GEM;

    public ATOGemSet(String name, String hardness, int veinSize, int minY, int maxY, int count) {
        super(name, ESetTypes.GEM);
        instances.add(this);

        // Item Tags
        GEM_TAG = ItemTags.create(Reference.gem(name));

        // Items
        GEM = item(name);

        ORES = new ATOOreSet(name, ESetTypes.GEM, hardness, GEM, BLOCK, veinSize, minY, maxY, count);
    }
}
