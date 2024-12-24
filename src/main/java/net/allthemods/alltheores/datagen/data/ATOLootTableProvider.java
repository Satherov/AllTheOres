package net.allthemods.alltheores.datagen.data;

import net.allthemods.alltheores.content.blocks.ore.OreBlock;
import net.allthemods.alltheores.registry.ATORegistry;
import net.allthemods.alltheores.content.blocks.sets.ATOSetHelper;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class ATOLootTableProvider extends VanillaBlockLoot {
    public ATOLootTableProvider(Provider provider) {
        super(provider);
    }

    @Override
    public void generate() {
        ATOSetHelper.applyToOre(set -> List.of(
                set.STONE_ORE_BLOCK,
                set.SLATE_ORE_BLOCK,
                set.NETHER_ORE_BLOCK,
                set.END_ORE_BLOCK,
                set.OTHER_ORE_BLOCK
        ).forEach(blockHolder -> this.add(blockHolder.get(), block -> createOreDrop(block, set.DROP.get()))));
        getKnownBlocks().forEach(this::dropBlock);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ATORegistry.BLOCKS.getEntries()
                .stream()
                .map(DeferredHolder::get)
                .filter(block -> !(block instanceof LiquidBlock))
                .collect(Collectors.toList());
    }

    //tell me why .filter(block -> !(block instanceof OreBlock)) doesn't work, but this does
    private void dropBlock(Block block) {
        if (block instanceof OreBlock) return;
        dropSelf(block);
    }
}