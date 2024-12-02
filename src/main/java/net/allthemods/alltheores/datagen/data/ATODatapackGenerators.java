package net.allthemods.alltheores.datagen.data;

import net.allthemods.alltheores.datagen.data.worldgen.*;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ATODatapackGenerators extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ATOBiomeModiferProvider::bootstrap)
            .add(Registries.CONFIGURED_FEATURE, ATOConfiguredFeatureProvider::bootstrap)
            .add(Registries.PLACED_FEATURE, ATOPlacedFeatureProvider::bootstrap);

    public ATODatapackGenerators(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Reference.MOD_ID));
    }
}
