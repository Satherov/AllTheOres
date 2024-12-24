package net.allthemods.alltheores.datagen.data;

import net.allthemods.alltheores.content.blocks.sets.ATOSetHelper;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers.AddFeaturesBiomeModifier;

public class ATOBiomeModiferProvider {

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        ATOSetHelper.applyToOre(group -> {
            context.register(group.OVERWORLD_BIOME_MODIFIER, new AddFeaturesBiomeModifier(
                    biomes.getOrThrow(Tags.Biomes.IS_OVERWORLD),
                    HolderSet.direct(placedFeatures.getOrThrow(group.PLACED_ORE_FEATURE)),
                    GenerationStep.Decoration.UNDERGROUND_ORES
            ));
            context.register(group.NETHER_BIOME_MODIFIER, new AddFeaturesBiomeModifier(
                    biomes.getOrThrow(Tags.Biomes.IS_NETHER),
                    HolderSet.direct(placedFeatures.getOrThrow(group.PLACED_ORE_FEATURE)),
                    GenerationStep.Decoration.UNDERGROUND_ORES
            ));
            context.register(group.END_MODIFIER, new AddFeaturesBiomeModifier(
                    biomes.getOrThrow(Tags.Biomes.IS_END),
                    HolderSet.direct(placedFeatures.getOrThrow(group.PLACED_ORE_FEATURE)),
                    GenerationStep.Decoration.UNDERGROUND_ORES
            ));
        });
    }
}
