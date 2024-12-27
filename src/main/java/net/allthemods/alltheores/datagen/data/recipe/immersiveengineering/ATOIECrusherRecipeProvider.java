package net.allthemods.alltheores.datagen.data.recipe.immersiveengineering;

import blusunrize.immersiveengineering.api.crafting.CrusherRecipe;
import blusunrize.immersiveengineering.api.crafting.StackWithChance;
import blusunrize.immersiveengineering.api.crafting.TagOutput;
import net.allthemods.alltheores.content.blocks.sets.ATOSetHelper;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.registry.ATORegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class ATOIECrusherRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ATOIECrusherRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    private ResourceLocation crusherDir(String type) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "crusher/" + type);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ATOSetHelper.applyToAlloy(set -> {
            // Ingot -> Dust
            recipeOutput.accept(
                    crusherDir(String.format("%s/from_ingot", set.name)),
                    crusherRecipe(
                            new TagOutput(set.DUST.get()),
                            Ingredient.of(set.INGOT_TAG),
                            List.of()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );
        });

        ATOSetHelper.applyToIngot(set -> {
            // Ore -> 2x Dust
            recipeOutput.accept(
                    crusherDir(String.format("%s/from_ore", set.name)),
                    crusherRecipe(
                            new TagOutput(set.DUST.get(), 2),
                            Ingredient.of(set.ORES.ORE_BLOCK_ITEM_TAG),
                            Stream.of(ATORegistry.getByproducts().containsKey(set.RAW.get())
                                    ? new StackWithChance(new TagOutput(ATORegistry.getByproducts().get(set.RAW.get()).first), ATORegistry.getByproducts().get(set.RAW.get()).second)
                                    : null
                            ).filter(Objects::nonNull).toList()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Raw -> Dust
            recipeOutput.accept(
                    crusherDir(String.format("%s/from_raw", set.name)),
                    crusherRecipe(
                            new TagOutput(set.DUST.get()),
                            Ingredient.of(set.RAW_TAG),
                            Stream.of(ATORegistry.getByproducts().containsKey(set.RAW.get())
                                    ? new StackWithChance(new TagOutput(ATORegistry.getByproducts().get(set.RAW.get()).first), ATORegistry.getByproducts().get(set.RAW.get()).second)
                                    : null
                            ).filter(Objects::nonNull).toList()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Raw Block -> 12x Dust
            recipeOutput.accept(
                    crusherDir(String.format("%s/from_raw_block", set.name)),
                    crusherRecipe(
                            new TagOutput(set.DUST.get(), 12),
                            Ingredient.of(set.RAW_BLOCK_ITEM_TAG),
                            Stream.of(ATORegistry.getByproducts().containsKey(set.RAW.get())
                                    ? new StackWithChance(new TagOutput(ATORegistry.getByproducts().get(set.RAW.get()).first), ATORegistry.getByproducts().get(set.RAW.get()).second)
                                    : null
                            ).filter(Objects::nonNull).toList()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );
        });

        ATOSetHelper.applyToGem(set -> {
            // Ore -> 2x Dust
            recipeOutput.accept(
                    crusherDir(String.format("%s/from_ore", set.name)),
                    crusherRecipe(
                            new TagOutput(set.GEM.get(), 6),
                            Ingredient.of(set.ORES.ORE_BLOCK_ITEM_TAG),
                            List.of()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Gem -> Dust
            recipeOutput.accept(
                    crusherDir(String.format("%s/from_gem", set.name)),
                    crusherRecipe(
                            new TagOutput(set.DUST.get()),
                            Ingredient.of(set.GEM_TAG),
                            List.of(new StackWithChance(new TagOutput(set.DUST.get()), 0.3333f))
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );
        });

        ATOSetHelper.applyToDust(set -> {
            // Ore -> Dust
            recipeOutput.accept(
                    crusherDir(String.format("%s/from_ore", set.name)),
                    crusherRecipe(
                            new TagOutput(set.DUST.get(), 2),
                            Ingredient.of(set.ORES.ORE_BLOCK_ITEM_TAG),
                            List.of()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );
        });

        ATOSetHelper.applyToVanillaIngot(set -> {
            // Ingot -> Dust
            recipeOutput.accept(
                    crusherDir(String.format("%s/from_ingot", set.name)),
                    crusherRecipe(
                            new TagOutput(set.DUST.get()),
                            Ingredient.of(set.INGOT_TAG),
                            List.of()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );
        });

        ATOSetHelper.applyToVanillaGem(set -> {
            // Gem -> Dust
            recipeOutput.accept(
                    crusherDir(String.format("%s/from_raw", set.name)),
                    crusherRecipe(
                            new TagOutput(set.DUST.get()),
                            Ingredient.of(set.GEM_TAG),
                            List.of(new StackWithChance(new TagOutput(set.DUST.get()), 0.3333f))
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );
        });

        ATOSetHelper.applyToVanillaDebris(set -> {
            // Ingot -> Dust
            recipeOutput.accept(
                    crusherDir(String.format("%s/from_ingot", set.name)),
                    crusherRecipe(
                            new TagOutput(set.DUST.get()),
                            Ingredient.of(set.INGOT_TAG),
                            List.of()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );
        });
    }

    private CrusherRecipe crusherRecipe(TagOutput output, Ingredient input, List<StackWithChance> secondaryOutputs) {
        return new CrusherRecipe(
                output,
                input,
                51200,
                secondaryOutputs
        );
    }
}
