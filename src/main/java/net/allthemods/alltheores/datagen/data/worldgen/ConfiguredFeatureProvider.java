package net.allthemods.alltheores.datagen.data.worldgen;

import net.allthemods.alltheores.registry.GroupHelper;
import net.allthemods.alltheores.registry.TagRegistry;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RandomBlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.neoforged.neoforge.registries.NeoForgeRegistries;


import java.util.List;

public class ConfiguredFeatureProvider {

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        GroupHelper.applyToOre( group -> {

            List<OreConfiguration.TargetBlockState> ores = List.of(
                    OreConfiguration.target(
                            new RandomBlockMatchTest(Blocks.STONE, 0.005f),
                            group.DROP_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new RandomBlockMatchTest(Blocks.DEEPSLATE, 0.03f),
                            group.DROP_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new RandomBlockMatchTest(Blocks.NETHERRACK, 0.05f),
                            group.DROP_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new RandomBlockMatchTest(Blocks.END_STONE, 0.1f),
                            group.DROP_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new TagMatchTest(TagRegistry.ANCIENT_STONE),
                            group.DROP_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                            group.STONE_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                            group.SLATE_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new BlockMatchTest(Blocks.NETHERRACK),
                            group.NETHER_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new BlockMatchTest(Blocks.END_STONE),
                            group.END_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new TagMatchTest(TagRegistry.ANCIENT_STONE),
                            group.OTHER_ORE_BLOCK.get().defaultBlockState()
                    ));

            FeatureUtils.register(
                    context,
                    group.CONFIGURED_ORE_FEATURE,
                    Feature.ORE,
                    new OreConfiguration( ores, 24)
            );
        });
    }
}
