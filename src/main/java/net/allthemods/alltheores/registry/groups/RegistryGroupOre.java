package net.allthemods.alltheores.registry.groups;

import net.allthemods.alltheores.blocks.BlockList;
import net.allthemods.alltheores.blocks.ore.*;
import net.allthemods.alltheores.datagen.data.BiomeModiferProvider;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.ArrayList;
import java.util.List;

import static net.allthemods.alltheores.blocks.BlockList.*;
import static net.allthemods.alltheores.blocks.BlockList.blockItem;

public class RegistryGroupOre {

    public final String name;

    private static final List<RegistryGroupOre> instances = new ArrayList<>();

    public final int veinSize;
    public final int minY;
    public final int maxY;
    public final int count;

    //Feature
    public final DeferredHolder<Feature<?>, Feature<?>> ORE_FEATURE;
    public final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_ORE_FEATURE;
    public final ResourceKey<PlacedFeature> PLACED_ORE_FEATURE;

    // Biome Modifier
    public final ResourceKey<BiomeModifier> OVERWORLD_BIOME_MODIFIER;
    public final ResourceKey<BiomeModifier> NETHER_BIOME_MODIFIER;
    public final ResourceKey<BiomeModifier> END_MODIFIER;
    public final ResourceKey<BiomeModifier> OTHER_MODIFIER;

    //Item Tags
    public final TagKey<Item> DROP_TAG;

    // Block Tags
    public final TagKey<Block> ORE_BLOCK_TAG;
    public final TagKey<Block> DROP_BLOCK_TAG;

    // BlockItem Tags
    public final TagKey<Item> ORE_BLOCK_ITEM_TAG;
    public final TagKey<Item> DROP_BLOCK_ITEM_TAG;

    // Items
    public final DeferredHolder<Item, Item> DROP;

    // Blocks
    public final DeferredHolder<Block, Block> STONE_ORE_BLOCK;
    public final DeferredHolder<Block, Block> SLATE_ORE_BLOCK;
    public final DeferredHolder<Block, Block> NETHER_ORE_BLOCK;
    public final DeferredHolder<Block, Block> END_ORE_BLOCK;
    public final DeferredHolder<Block, Block> OTHER_ORE_BLOCK;

    public final DeferredHolder<Block, Block> DROP_BLOCK;

    // BlockItems
    public final DeferredHolder<Item, BlockItem> STONE_ORE_BLOCK_ITEM;
    public final DeferredHolder<Item, BlockItem> SLATE_ORE_BLOCK_ITEM;
    public final DeferredHolder<Item, BlockItem> NETHER_ORE_BLOCK_ITEM;
    public final DeferredHolder<Item, BlockItem> END_ORE_BLOCK_ITEM;
    public final DeferredHolder<Item, BlockItem> OTHER_ORE_BLOCK_ITEM;

    public final DeferredHolder<Item, BlockItem> DROP_BLOCK_ITEM;

    public RegistryGroupOre(String name, String type, int veinSize, int minY, int maxY, int count) {

        this.name = name;

        instances.add(this);

        this.veinSize = veinSize;
        this.minY = minY;
        this.maxY = maxY;
        this.count = count;

        // Feature
        ORE_FEATURE = FEATURES.register(String.format("ore_%s", name), () -> new OreFeature(OreConfiguration.CODEC));
        CONFIGURED_ORE_FEATURE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, String.format("ore_%s", name)));
        PLACED_ORE_FEATURE = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, String.format("ore_%s_placed", name)));

        // Biome Modifier
        OVERWORLD_BIOME_MODIFIER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, name));
        NETHER_BIOME_MODIFIER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, String.format("%s_nether", name)));
        END_MODIFIER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, String.format("%s_end", name)));
        OTHER_MODIFIER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, String.format("%s_other", name)));

        //Block Tags
        ORE_BLOCK_TAG = BlockTags.create(Reference.ore(name));

        //BlockItem Tags
        ORE_BLOCK_ITEM_TAG = ItemTags.create(Reference.ore(name));

        // Blocks
        STONE_ORE_BLOCK = BLOCKS.register(String.format("%s_ore", name), OreBlockStone::new);
        SLATE_ORE_BLOCK = BLOCKS.register(String.format("%s_deepslate_ore", name), OreBlockSlate::new);
        NETHER_ORE_BLOCK = BLOCKS.register(String.format("%s_nether_ore", name), OreBlockNether::new);
        END_ORE_BLOCK = BLOCKS.register(String.format("%s_end_ore", name), OreBlockEnd::new);
        OTHER_ORE_BLOCK = BLOCKS.register(String.format("%s_other_ore", name), OreBlockOther::new);

        // BlockItems
        STONE_ORE_BLOCK_ITEM = blockItem(STONE_ORE_BLOCK);
        SLATE_ORE_BLOCK_ITEM = blockItem(SLATE_ORE_BLOCK);
        NETHER_ORE_BLOCK_ITEM = blockItem(NETHER_ORE_BLOCK);
        END_ORE_BLOCK_ITEM = blockItem(END_ORE_BLOCK);
        OTHER_ORE_BLOCK_ITEM = blockItem(OTHER_ORE_BLOCK);

        // Item Tags
        DROP_TAG = ItemTags.create(Reference.raw_materials(name));

        //Block Tags
        DROP_BLOCK_TAG = BlockTags.create(Reference.block(name));

        //BlockItem Tags
        DROP_BLOCK_ITEM_TAG = ItemTags.create(Reference.block( name));

        switch (type) {
            case "ore" -> {

                // Items
                DROP = material(String.format("raw_%s", name));

                // Block
                DROP_BLOCK = BlockList.BLOCKS.register(String.format("raw_%s_block", name), () -> new Block(Blocks.STONE.properties().strength(3.0f, 3.0f)));

                // BlockItem
                DROP_BLOCK_ITEM = blockItem(DROP_BLOCK);
            }
            case "dust", "gem" -> {

                // Items
                DROP = material(name);

                // Block
                DROP_BLOCK = BlockList.BLOCKS.register(String.format("%s_block", name), () -> new Block(Blocks.AMETHYST_BLOCK.properties().strength(3.0f, 3.0f)));

                // BlockItem
                DROP_BLOCK_ITEM = blockItem(DROP_BLOCK);
            }
            case null, default -> throw new IllegalArgumentException("Invalid type: " + type);
        }
    }

    public static List<RegistryGroupOre> getOreInstances() {
        return instances;
    }
}
