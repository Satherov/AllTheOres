package net.allthemods.alltheores.registry.groups;

import mekanism.api.chemical.Chemical;
import mekanism.api.chemical.ChemicalBuilder;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.items.mekanism.Clump;
import net.allthemods.alltheores.items.mekanism.Crystal;
import net.allthemods.alltheores.items.mekanism.DirtyDust;
import net.allthemods.alltheores.items.mekanism.Shard;
import net.allthemods.alltheores.registry.ATOMekanismRegistry;
import net.allthemods.alltheores.registry.ATORegistry;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.List;

public class RegistryGroupMekanism {

    public final String name;

    private static final List<RegistryGroupMekanism> instances = new ArrayList<>();

    //Item Tags
    public final TagKey<Item> CRYSTAL_TAG;
    public final TagKey<Item> SHARD_TAG;
    public final TagKey<Item> CLUMP_TAG;
    public final TagKey<Item> DIRTY_DUST_TAG;

    // Chemicals
    public final DeferredHolder<Chemical, Chemical> DIRTY_SLURRY;
    public final DeferredHolder<Chemical, Chemical> CLEAN_SLURRY;

    // Items
    public final DeferredHolder<Item, Item> CRYSTAL;
    public final DeferredHolder<Item, Item> SHARD;
    public final DeferredHolder<Item, Item> CLUMP;
    public final DeferredHolder<Item, Item> DIRTY_DUST;

    public RegistryGroupMekanism(String name, int fluidColor, DeferredHolder<Block, Block> block) {

        this.name = name;

        instances.add(this);

        //Item Tags
        CRYSTAL_TAG = ItemTags.create(Reference.crystal(name));
        SHARD_TAG = ItemTags.create(Reference.shard(name));
        CLUMP_TAG = ItemTags.create(Reference.clump(name));
        DIRTY_DUST_TAG = ItemTags.create(Reference.dirty_dust(name));

        // Chemicals
        DIRTY_SLURRY = ATOMekanismRegistry.SLURRYS.register(String.format("dirty_%s", name), () -> new Chemical(ChemicalBuilder.builder().tint(fluidColor).ore(block.getId())));
        CLEAN_SLURRY = ATOMekanismRegistry.SLURRYS.register(String.format("clean_%s_", name), () -> new Chemical(ChemicalBuilder.builder().tint(fluidColor).ore(block.getId())));

        // Items
        CRYSTAL = ATORegistry.ITEMS.register(String.format("%s_crystal", name), () -> new Crystal(new Item.Properties()));
        SHARD = ATORegistry.ITEMS.register(String.format("%s_shard", name), () -> new Shard(new Item.Properties()));
        CLUMP = ATORegistry.ITEMS.register(String.format("%s_clump", name), () -> new Clump(new Item.Properties()));
        DIRTY_DUST = ATORegistry.ITEMS.register(String.format("dirty_%s_dust", name), () -> new DirtyDust(new Item.Properties()));
    }

    public static List<RegistryGroupMekanism> getMekanismInstances() {
        return instances;
    }
}
