package net.allthemods.alltheores.datagen.data.recipe.immersiveengineering;

import blusunrize.immersiveengineering.api.crafting.IngredientWithSize;
import blusunrize.immersiveengineering.api.crafting.MetalPressRecipe;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import blusunrize.immersiveengineering.common.register.IEItems;
import net.allthemods.alltheores.content.blocks.sets.ATOSetHelper;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;

public class ATOIEMetalPressRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ATOIEMetalPressRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    private ResourceLocation metalPressDir(String type) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "metalpress/" + type);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ATOSetHelper.applyToAlloy(set -> {
            // Ingot -> Rod
            recipeOutput.accept(
                    metalPressDir(String.format("%s/rod", set.name)),
                    metalPressRecipe(
                            new TagOutput(set.ROD.get(), 2),
                            new IngredientWithSize(set.INGOT_TAG),
                            IEItems.Molds.MOLD_ROD.get()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Ingot -> Gear
            recipeOutput.accept(
                    metalPressDir(String.format("%s/gear", set.name)),
                    metalPressRecipe(
                            new TagOutput(set.GEAR.get()),
                            new IngredientWithSize(set.INGOT_TAG, 4),
                            IEItems.Molds.MOLD_GEAR.get()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Ingot -> Plate
            recipeOutput.accept(
                    metalPressDir(String.format("%s/plate", set.name)),
                    metalPressRecipe(
                            new TagOutput(set.PLATE.get()),
                            new IngredientWithSize(set.INGOT_TAG),
                            IEItems.Molds.MOLD_PLATE.get()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );
        });

        ATOSetHelper.applyToVanillaIngot(set -> {
            // Ingot -> Rod
            recipeOutput.accept(
                    metalPressDir(String.format("%s/rod", set.name)),
                    metalPressRecipe(
                            new TagOutput(set.ROD.get(), 2),
                            new IngredientWithSize(set.INGOT_TAG),
                            IEItems.Molds.MOLD_ROD.get()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Ingot -> Gear
            recipeOutput.accept(
                    metalPressDir(String.format("%s/gear", set.name)),
                    metalPressRecipe(
                            new TagOutput(set.GEAR.get()),
                            new IngredientWithSize(set.INGOT_TAG, 4),
                            IEItems.Molds.MOLD_GEAR.get()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Ingot -> Plate
            recipeOutput.accept(
                    metalPressDir(String.format("%s/plate", set.name)),
                    metalPressRecipe(
                            new TagOutput(set.PLATE.get()),
                            new IngredientWithSize(set.INGOT_TAG),
                            IEItems.Molds.MOLD_PLATE.get()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );
        });

        ATOSetHelper.applyToVanillaGem(set -> {
            // Ingot -> Rod
            recipeOutput.accept(
                    metalPressDir(String.format("%s/rod", set.name)),
                    metalPressRecipe(
                            new TagOutput(set.ROD.get(), 2),
                            new IngredientWithSize(set.GEM_TAG),
                            IEItems.Molds.MOLD_ROD.get()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Ingot -> Gear
            recipeOutput.accept(
                    metalPressDir(String.format("%s/gear", set.name)),
                    metalPressRecipe(
                            new TagOutput(set.GEAR.get()),
                            new IngredientWithSize(set.GEM_TAG, 4),
                            IEItems.Molds.MOLD_GEAR.get()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Ingot -> Plate
            recipeOutput.accept(
                    metalPressDir(String.format("%s/plate", set.name)),
                    metalPressRecipe(
                            new TagOutput(set.PLATE.get()),
                            new IngredientWithSize(set.GEM_TAG),
                            IEItems.Molds.MOLD_PLATE.get()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );
        });

        ATOSetHelper.applyToVanillaDebris(set -> {
            // Ingot -> Rod
            recipeOutput.accept(
                    metalPressDir(String.format("%s/rod", set.name)),
                    metalPressRecipe(
                            new TagOutput(set.ROD.get(), 2),
                            new IngredientWithSize(set.INGOT_TAG),
                            IEItems.Molds.MOLD_ROD.get()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Ingot -> Gear
            recipeOutput.accept(
                    metalPressDir(String.format("%s/gear", set.name)),
                    metalPressRecipe(
                            new TagOutput(set.GEAR.get()),
                            new IngredientWithSize(set.INGOT_TAG, 4),
                            IEItems.Molds.MOLD_GEAR.get()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Ingot -> Plate
            recipeOutput.accept(
                    metalPressDir(String.format("%s/plate", set.name)),
                    metalPressRecipe(
                            new TagOutput(set.PLATE.get()),
                            new IngredientWithSize(set.INGOT_TAG),
                            IEItems.Molds.MOLD_PLATE.get()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );
        });
    }

    private MetalPressRecipe metalPressRecipe(TagOutput output, IngredientWithSize input, Item mold) {
        return new MetalPressRecipe(
                output,
                input,
                mold,
                51200
        );
    }
}
