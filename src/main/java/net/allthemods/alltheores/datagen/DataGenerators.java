package net.allthemods.alltheores.datagen;

import net.allthemods.alltheores.datagen.assets.BlockStateProvider;
import net.allthemods.alltheores.datagen.assets.ItemModelProvider;
import net.allthemods.alltheores.datagen.data.DatapackGenerators;
import net.allthemods.alltheores.datagen.data.tags.BlockTagProvider;
import net.allthemods.alltheores.datagen.data.recipe.VanillaRecipeProvider;
import net.allthemods.alltheores.datagen.data.tags.ItemTagProvider;
import net.allthemods.alltheores.datagen.data.LootTableProvider;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Reference.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) throws IOException {

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        if (event.includeServer()) {
            BlockTagProvider blockTags = new BlockTagProvider(packOutput, event.getLookupProvider(), fileHelper);
            generator.addProvider(true, blockTags);
            generator.addProvider(true, new ItemTagProvider(packOutput, event.getLookupProvider(), blockTags.contentsGetter(), fileHelper));
            generator.addProvider(true, new VanillaRecipeProvider(packOutput, event.getLookupProvider()));
            generator.addProvider(true, new net.minecraft.data.loot.LootTableProvider(packOutput, Collections.emptySet(),
                    List.of(new net.minecraft.data.loot.LootTableProvider.SubProviderEntry(LootTableProvider::new, LootContextParamSets.BLOCK)), event.getLookupProvider()));
            generator.addProvider(true, new DatapackGenerators(packOutput, lookupProvider));
        }
        if (event.includeClient()) {
            generator.addProvider(true, new BlockStateProvider(generator, fileHelper));
            generator.addProvider(true, new ItemModelProvider(generator, fileHelper));
        }
    }
}
