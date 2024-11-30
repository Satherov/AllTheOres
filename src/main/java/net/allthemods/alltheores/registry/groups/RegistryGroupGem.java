package net.allthemods.alltheores.registry.groups;

import net.allthemods.alltheores.infos.Reference;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;

import static net.allthemods.alltheores.blocks.BlockList.material;

public class RegistryGroupGem {

    public final String name;
    public final RegistryGroupOre ORES;

    //Item Tags
    public final TagKey<Item> DUST_TAG;


    //Items
    public final DeferredHolder<Item, Item> DUST;

    public RegistryGroupGem(String name) {
        this.name = name;
        ORES = new RegistryGroupOre(name, "gem");

        //Item Tags
        DUST_TAG = ItemTags.create(Reference.dust(name));

        //Items
        DUST = material(String.format("%s_dust", name));
    }
}
