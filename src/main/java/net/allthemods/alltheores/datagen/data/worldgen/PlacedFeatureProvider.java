package net.allthemods.alltheores.datagen.data.worldgen;

import net.allthemods.alltheores.registry.GroupHelper;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class PlacedFeatureProvider {

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);

        GroupHelper.applyToOre( group -> {
            PlacementUtils.register(
                    context,
                    group.PLACED_ORE_FEATURE,
                    features.getOrThrow(
                            group.CONFIGURED_ORE_FEATURE),
                    List.of(CountPlacement.of(4),
                            InSquarePlacement.spread(),
                            HeightRangePlacement.triangle(
                                    VerticalAnchor.absolute(-64),
                                    VerticalAnchor.absolute(320)
                    ),
                    BiomeFilter.biome()
            ));
        });
    }
}
