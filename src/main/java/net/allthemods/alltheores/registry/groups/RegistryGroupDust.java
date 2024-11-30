package net.allthemods.alltheores.registry.groups;

import net.allthemods.alltheores.infos.Reference;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class RegistryGroupDust {

    public final String name;
    public final RegistryGroupOre ORES;

    // Item Tags
    public final TagKey<Item> DUST_TAG;


    public RegistryGroupDust(String name) {
        this.name = name;
        ORES = new RegistryGroupOre(name, "dust");

        //Item Tags
        DUST_TAG = ItemTags.create(Reference.dust(name));
    }
}
