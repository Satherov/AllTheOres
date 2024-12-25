package net.allthemods.alltheores.datagen;

import net.allthemods.alltheores.datagen.assets.ATOBlockStateProvider;
import net.allthemods.alltheores.datagen.assets.ATOItemModelProvider;
import net.allthemods.alltheores.datagen.assets.lang.EN_USProvider;
import net.allthemods.alltheores.datagen.data.ATODatapackGenerators;
import net.allthemods.alltheores.datagen.data.ATOLootTableProvider;
import net.allthemods.alltheores.datagen.data.recipe.enderio.ATOAlloySmelterRecipeProvider;
import net.allthemods.alltheores.datagen.data.recipe.enderio.ATOSagMillRecipeProvider;
import net.allthemods.alltheores.datagen.data.recipe.immersiveengineering.ATOImmersiveEngineeringRecipeProvider;
import net.allthemods.alltheores.datagen.data.recipe.mekanism.ATOMekanismRecipeProvider;
import net.allthemods.alltheores.datagen.data.recipe.ATORecipeProvider;
import net.allthemods.alltheores.datagen.data.tags.ATOBlockTagProvider;
import net.allthemods.alltheores.datagen.data.tags.ATOItemTagProvider;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.Util;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Reference.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class ATODataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = CompletableFuture.supplyAsync(VanillaRegistries::createLookup, Util.backgroundExecutor());

        ATODataProvider provider = new ATODataProvider();

        // Assets
        provider.addSubProvider(event.includeClient(), new ATOBlockStateProvider(generator, fileHelper));
        provider.addSubProvider(event.includeClient(), new ATOItemModelProvider(generator, fileHelper));
        // Languages
        provider.addSubProvider(event.includeClient(), new EN_USProvider(packOutput));

        // Tags
        ATOBlockTagProvider blockTags = new ATOBlockTagProvider(packOutput, lookupProvider, fileHelper);
        provider.addSubProvider(event.includeServer(), blockTags);
        provider.addSubProvider(event.includeServer(), new ATOItemTagProvider(packOutput, lookupProvider, blockTags.contentsGetter(), fileHelper));

        // Recipes
        provider.addSubProvider(event.includeServer(), new ATORecipeProvider(packOutput, lookupProvider));
        provider.addSubProvider(event.includeServer(), new ATOMekanismRecipeProvider(packOutput, lookupProvider));
        provider.addSubProvider(event.includeServer(), new ATOSagMillRecipeProvider(packOutput, lookupProvider));
        provider.addSubProvider(event.includeServer(), new ATOAlloySmelterRecipeProvider(packOutput, lookupProvider));
        provider.addSubProvider(event.includeServer(), new ATOImmersiveEngineeringRecipeProvider(packOutput, lookupProvider));

        // Loot Tables
        provider.addSubProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(ATOLootTableProvider::new, LootContextParamSets.BLOCK)), event.getLookupProvider()));
        // Datapack Generators
        provider.addSubProvider(event.includeServer(), new ATODatapackGenerators(packOutput, lookupProvider));

        generator.addProvider(true, provider);
    }
}
