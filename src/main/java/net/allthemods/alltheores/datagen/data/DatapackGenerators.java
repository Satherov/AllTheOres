package net.allthemods.alltheores.datagen.data;

import net.allthemods.alltheores.datagen.data.worldgen.ConfiguredFeatureProvider;
import net.allthemods.alltheores.datagen.data.worldgen.PlacedFeatureProvider;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DatapackGenerators extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ConfiguredFeatureProvider::bootstrap)
            .add(Registries.PLACED_FEATURE, PlacedFeatureProvider::bootstrap);

    public DatapackGenerators(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Reference.MOD_ID));
    }
}
