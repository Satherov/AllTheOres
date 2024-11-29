package net.allthemods.alltheores.datagen.server;

import net.allthemods.alltheores.blocks.BlockList;
import net.allthemods.alltheores.blocks.ore.OreBlock;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.stream.Collectors;

public class LootTables extends VanillaBlockLoot {
    public LootTables(Provider provider) {
        super(provider);
    }

    @Override
    public void generate() {
        GroupHelper.applyToOre(group -> {
            this.add(group.ORE.get(), (block) -> {
                return createOreDrop(block, group.RAW.get());
            });
        });
        getKnownBlocks().forEach(this::dropSelf);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockList.BLOCKS.getEntries()
                .stream().map(DeferredHolder::get)
                .filter(block -> !(block instanceof LiquidBlock || block instanceof OreBlock))
                .collect(Collectors.toList());

    }
}



