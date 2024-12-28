package net.allthemods.alltheores.datagen.data.recipe.immersiveengineering;

import blusunrize.immersiveengineering.api.crafting.AlloyRecipe;
import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.registry.ATORegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ATOIEAlloyRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ATOIEAlloyRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    private ResourceLocation alloySmeltingDir(String type) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "alloysmelter/" + type);
    }

    private ResourceLocation arcFurnaceDir(String type) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "arcfurnace/" + type);
    }

    private ResourceLocation crusherDir(String type) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "crusher/" + type);
    }

    private ResourceLocation metalPressDir(String type) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "metalpress/" + type);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        // ##### Alloy Smelter #####

        List.of(// Steel
                alloyRecipe(
                        new TagOutput(ATORegistry.STEEL.INGOT.get(), 2),
                        new IngredientWithSize(ATORegistry.IRON.INGOT_TAG, 1),
                        new IngredientWithSize(ItemTags.COALS, 1)),
                // Invar
                alloyRecipe(
                        new TagOutput(ATORegistry.INVAR.INGOT.get(), 6),
                        new IngredientWithSize(ATORegistry.IRON.INGOT_TAG, 2),
                        new IngredientWithSize(ATORegistry.NICKEL.INGOT_TAG, 1)),
                // Electrum
                alloyRecipe(
                        new TagOutput(ATORegistry.ELECTRUM.INGOT.get(), 4),
                        new IngredientWithSize(ATORegistry.GOLD.INGOT_TAG, 1),
                        new IngredientWithSize(ATORegistry.SILVER.INGOT_TAG, 1)),
                // Bronze
                alloyRecipe(
                        new TagOutput(ATORegistry.BRONZE.INGOT.get(), 8),
                        new IngredientWithSize(ATORegistry.COPPER.INGOT_TAG, 3),
                        new IngredientWithSize(ATORegistry.TIN.INGOT_TAG, 1)),
                // Brass
                alloyRecipe(
                        new TagOutput(ATORegistry.BRASS.INGOT.get(), 8),
                        new IngredientWithSize(ATORegistry.COPPER.INGOT_TAG, 3),
                        new IngredientWithSize(ATORegistry.ZINC.INGOT_TAG, 1)),
                // Constantan
                alloyRecipe(
                        new TagOutput(ATORegistry.CONSTANTAN.INGOT.get(), 4),
                        new IngredientWithSize(ATORegistry.COPPER.INGOT_TAG, 1),
                        new IngredientWithSize(ATORegistry.NICKEL.INGOT_TAG, 1))
                // Enderium, Lumium and Signalum dont fit in the Alloy Smelter
        ).forEach(recipe -> recipeOutput.accept(
                alloySmeltingDir(String.format("%s/ingot", BuiltInRegistries.ITEM.getKey(recipe.output.get().getItem()).getPath().replaceAll("_ingot", ""))),
                recipe,
                null,
                new ModLoadedCondition("immersiveengineering"))
        );
    }

    private AlloyRecipe alloyRecipe(TagOutput output, IngredientWithSize input1, IngredientWithSize input2) {
        return new AlloyRecipe(
                output,
                input1,
                input2,
                200);
    }
}
