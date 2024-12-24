package net.allthemods.alltheores.datagen.data.worldgen;

import net.allthemods.alltheores.content.blocks.sets.ATOSetHelper;
import net.allthemods.alltheores.content.blocks.sets.ESetTypes;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RandomBlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;
import java.util.Objects;

public class ATOConfiguredFeatureProvider {

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        // Ore generation
        ATOSetHelper.applyToOre(set -> {

            List<OreConfiguration.TargetBlockState> ores = new java.util.ArrayList<>(List.of(
                    OreConfiguration.target(
                            new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                            set.STONE_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                            set.SLATE_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new BlockMatchTest(Blocks.NETHERRACK),
                            set.NETHER_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new BlockMatchTest(Blocks.END_STONE),
                            set.END_ORE_BLOCK.get().defaultBlockState()
                    ),
                    OreConfiguration.target(
                            new TagMatchTest(BlockTags.create(ResourceLocation.fromNamespaceAndPath("allthemodium", "ancient_stone"))),
                            set.OTHER_ORE_BLOCK.get().defaultBlockState()
                    )
            ));

            if (Objects.equals(set.type, ESetTypes.INGOT)) {
                ores.add(OreConfiguration.target(
                        new RandomBlockMatchTest(Blocks.STONE, 0.005f),
                        set.DROP_BLOCK.get().defaultBlockState()
                ));
                ores.add(OreConfiguration.target(
                        new RandomBlockMatchTest(Blocks.DEEPSLATE, 0.03f),
                        set.DROP_BLOCK.get().defaultBlockState()
                ));
                ores.add(OreConfiguration.target(
                        new RandomBlockMatchTest(Blocks.NETHERRACK, 0.01f),
                        set.DROP_BLOCK.get().defaultBlockState()
                ));
                ores.add(OreConfiguration.target(
                        new RandomBlockMatchTest(Blocks.END_STONE, 0.01f),
                        set.DROP_BLOCK.get().defaultBlockState()
                ));
                ores.add(OreConfiguration.target(
                        new TagMatchTest(BlockTags.create(ResourceLocation.fromNamespaceAndPath("allthemodium", "ancient_stone"))),
                        set.DROP_BLOCK.get().defaultBlockState()
                ));
            }

            FeatureUtils.register(
                    context,
                    set.CONFIGURED_ORE_FEATURE,
                    Feature.ORE,
                    new OreConfiguration(ores, set.veinSize)
            );
        });
    }
}
