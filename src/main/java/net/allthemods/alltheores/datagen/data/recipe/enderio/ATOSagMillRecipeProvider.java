package net.allthemods.alltheores.datagen.data.recipe.enderio;

import com.enderio.machines.common.recipe.SagMillingRecipe;
import com.enderio.machines.data.recipes.SagMillRecipeProvider;
import com.ibm.icu.impl.Pair;
import net.allthemods.alltheores.content.blocks.sets.ATOSetHelper;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.registry.ATORegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class ATOSagMillRecipeProvider extends SagMillRecipeProvider implements IConditionBuilder {

    private static final int SAG_MILL_ENERGY = 2400;

    public ATOSagMillRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    private ResourceLocation sagMillDir(String type) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "sag_milling/" + type);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        ATOSetHelper.applyToAlloy( set ->
                sagMillDirect(String.format("/%s/ingot", set.name),
                    Ingredient.of(set.INGOT_TAG),
                    set.DUST.get(),
                    output)
        );

        ATOSetHelper.applyToIngot( set -> {

            Map<ItemLike, Pair<ItemLike, Float>> byproducts = Map.of(
                    ATORegistry.ALUMINUM.RAW.get(), Pair.of(ATORegistry.ZINC.DUST.get(), 0.05f),
                    ATORegistry.LEAD.RAW.get(), Pair.of(ATORegistry.SILVER.DUST.get(), 0.45f),
                    ATORegistry.NICKEL.RAW.get(), Pair.of(ATORegistry.PLATINUM.DUST.get(), 0.25f),
                    ATORegistry.OSMIUM.RAW.get(), Pair.of(ATORegistry.IRIDIUM.DUST.get(), 0.3f),
                    ATORegistry.PLATINUM.RAW.get(), Pair.of(ATORegistry.GOLD.DUST.get(), 0.1f),
                    ATORegistry.SILVER.RAW.get(), Pair.of(ATORegistry.LEAD.DUST.get(), 0.45f),
                    ATORegistry.TIN.RAW.get(), Pair.of(ATORegistry.IRON.DUST.get(), 0.2f),
                    ATORegistry.URANIUM.RAW.get(), Pair.of(ATORegistry.LEAD.DUST.get(), 0.5f),
                    ATORegistry.ZINC.RAW.get(), Pair.of(ATORegistry.ALUMINUM.DUST.get(), 0.05f),
                    ATORegistry.IRIDIUM.RAW.get(), Pair.of(ATORegistry.OSMIUM.DUST.get(), 0.3f)
            );

            sagMillMultiply(
                    String.format("/%s/raw", set.name),
                    Ingredient.of(set.RAW_TAG),
                    Stream.of(
                            output(set.DUST.get(), 0.25f),
                            // This exists so it won't crash
                            // You should still define a byproduct in the map
                            byproducts.containsKey(set.RAW.get())
                                    ? output(byproducts.get(set.RAW.get()).first, byproducts.get(set.RAW.get()).second)
                                    : null
                    ).filter(Objects::nonNull).toList(),
                    output
            );


            sagMillOre(String.format("/%s/ore", set.name),
                    Ingredient.of(set.ORES.ORE_BLOCK_ITEM_TAG),
                    set.RAW.get(),
                    output);
        });

        ATOSetHelper.applyToGem( set -> {

            sagMillOre(String.format("/%s/ore", set.name),
                    Ingredient.of(set.ORES.ORE_BLOCK_ITEM_TAG),
                    set.GEM.get(),
                    output);

            sagMillDirect(String.format("/%s/gem", set.name),
                    Ingredient.of(set.GEM_TAG),
                    set.DUST.get(),
                    output);
        });

        ATOSetHelper.applyToDust( set ->
                sagMillDirect(String.format("/%s/ore", set.name),
                    Ingredient.of(set.ORES.ORE_BLOCK_ITEM_TAG),
                    set.DUST.get(),
                    output)
        );
    }

    private void sagMillOre(String name, Ingredient input, Item output, RecipeOutput recipeOutput) {
        sagMillMultiply(name, input, List.of(output(output), output(output, 0.33f), output(Items.COBBLESTONE, 0.15f)), recipeOutput);
    }

    private void sagMillMultiply(String name, Ingredient input, List<SagMillingRecipe.OutputItem> outputs, RecipeOutput recipeOutput) {
        sagMill(name, input, outputs, SagMillingRecipe.BonusType.MULTIPLY_OUTPUT, recipeOutput);
    }

    private void sagMillDirect(String name, Ingredient input, ItemLike output, RecipeOutput recipeOutput) {
        sagMill(name, input, List.of(output(output)), SagMillingRecipe.BonusType.NONE, recipeOutput);
    }

    private void sagMill(String name, Ingredient input, List<SagMillingRecipe.OutputItem> outputs, SagMillingRecipe.BonusType bonusType, RecipeOutput recipeOutput) {
        recipeOutput.withConditions(new ModLoadedCondition("enderio_machines")).accept(sagMillDir(name), new SagMillingRecipe(input, outputs, SAG_MILL_ENERGY, bonusType), null);
    }
}
