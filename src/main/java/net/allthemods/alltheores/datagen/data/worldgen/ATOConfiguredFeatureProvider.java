package net.allthemods.alltheores.datagen.data.worldgen;

import com.thevortex.allthemodium.registry.ModRegistry;
import net.allthemods.alltheores.registry.GroupHelper;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RandomBlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ATOConfiguredFeatureProvider {

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        GroupHelper.applyToMaterial( group -> {

            List<OreConfiguration.TargetBlockState> ores = List.of(
                    OreConfiguration.target(
                            new RandomBlockMatchTest(Blocks.STONE, 0.005f),
                            group.ORES.DROP_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new RandomBlockMatchTest(Blocks.DEEPSLATE, 0.03f),
                            group.ORES.DROP_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new RandomBlockMatchTest(Blocks.NETHERRACK, 0.05f),
                            group.ORES.DROP_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new RandomBlockMatchTest(Blocks.END_STONE, 0.1f),
                            group.ORES.DROP_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new RandomBlockMatchTest(ModRegistry.ANCIENT_STONE.get(), 0.1f),
                            group.ORES.DROP_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                            group.ORES.STONE_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                            group.ORES.SLATE_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new BlockMatchTest(Blocks.NETHERRACK),
                            group.ORES.NETHER_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new BlockMatchTest(Blocks.END_STONE),
                            group.ORES.END_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new TagMatchTest(com.thevortex.allthemodium.registry.TagRegistry.ANCIENT_STONE),
                            group.ORES.OTHER_ORE_BLOCK.get().defaultBlockState()
                    ));

            FeatureUtils.register(
                    context,
                    group.ORES.CONFIGURED_ORE_FEATURE,
                    Feature.ORE,
                    new OreConfiguration( ores, group.ORES.veinSize)
            );
        });

        GroupHelper.applyToGem( group -> {

            List<OreConfiguration.TargetBlockState> ores = List.of(
                    OreConfiguration.target(
                            new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                            group.ORES.STONE_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                            group.ORES.SLATE_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new BlockMatchTest(Blocks.NETHERRACK),
                            group.ORES.NETHER_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new BlockMatchTest(Blocks.END_STONE),
                            group.ORES.END_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new TagMatchTest(com.thevortex.allthemodium.registry.TagRegistry.ANCIENT_STONE),
                            group.ORES.OTHER_ORE_BLOCK.get().defaultBlockState()
                    ));

            FeatureUtils.register(
                    context,
                    group.ORES.CONFIGURED_ORE_FEATURE,
                    Feature.ORE,
                    new OreConfiguration( ores, group.ORES.veinSize)
            );
        });

        GroupHelper.applyToDust( group -> {

            List<OreConfiguration.TargetBlockState> ores = List.of(
                    OreConfiguration.target(
                            new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                            group.ORES.STONE_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                            group.ORES.SLATE_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new BlockMatchTest(Blocks.NETHERRACK),
                            group.ORES.NETHER_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new BlockMatchTest(Blocks.END_STONE),
                            group.ORES.END_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new TagMatchTest(com.thevortex.allthemodium.registry.TagRegistry.ANCIENT_STONE),
                            group.ORES.OTHER_ORE_BLOCK.get().defaultBlockState()
                    )
            );

            FeatureUtils.register(
                    context,
                    group.ORES.CONFIGURED_ORE_FEATURE,
                    Feature.ORE,
                    new OreConfiguration( ores, group.ORES.veinSize)
            );
        });
    }
}
