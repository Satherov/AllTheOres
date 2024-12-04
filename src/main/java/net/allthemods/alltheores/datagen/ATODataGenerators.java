package net.allthemods.alltheores.datagen;

import net.allthemods.alltheores.datagen.assets.ATOBlockStateProvider;
import net.allthemods.alltheores.datagen.assets.ATOItemModelProvider;
import net.allthemods.alltheores.datagen.assets.ATOLanguageProvider;
import net.allthemods.alltheores.datagen.assets.lang.EN_USProvider;
import net.allthemods.alltheores.datagen.data.ATODatapackGenerators;
import net.allthemods.alltheores.datagen.data.ATOLootTableProvider;
import net.allthemods.alltheores.datagen.data.ATORecipeProvider;
import net.allthemods.alltheores.datagen.data.tags.ATOBlockTagProvider;
import net.allthemods.alltheores.datagen.data.tags.ATOItemTagProvider;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
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
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new ATOBlockStateProvider(generator, fileHelper));
        generator.addProvider(event.includeClient(), new ATOItemModelProvider(generator, fileHelper));
        generator.addProvider(event.includeClient(), new EN_USProvider(packOutput));

        ATOBlockTagProvider blockTags = new ATOBlockTagProvider(packOutput, event.getLookupProvider(), fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new ATOItemTagProvider(packOutput, event.getLookupProvider(), blockTags.contentsGetter(), fileHelper));

        generator.addProvider(event.includeServer(), new ATORecipeProvider(packOutput, event.getLookupProvider()));
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(ATOLootTableProvider::new, LootContextParamSets.BLOCK)), event.getLookupProvider()));
        generator.addProvider(event.includeServer(), new ATODatapackGenerators(packOutput, lookupProvider));

    }
}
