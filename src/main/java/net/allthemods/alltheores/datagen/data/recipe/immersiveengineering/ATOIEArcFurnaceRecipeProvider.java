package net.allthemods.alltheores.datagen.data.recipe.immersiveengineering;

import blusunrize.immersiveengineering.api.crafting.*;
import net.allthemods.alltheores.content.blocks.sets.ATOSetHelper;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.registry.ATORegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ATOIEArcFurnaceRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ATOIEArcFurnaceRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    private ResourceLocation arcFurnaceDir(String type) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "arcfurnace/" + type);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List.of(// Steel
                arcFurnaceRecipe(
                        new TagOutputList(List.of(new TagOutput(ATORegistry.STEEL.INGOT.get(), 5))),
                        List.of(),
                        new IngredientWithSize(ATORegistry.IRON.INGOT_TAG, 2),
                        List.of(new IngredientWithSize(ATORegistry.NICKEL.INGOT_TAG, 2))
                ),
                // Invar
                arcFurnaceRecipe(
                        new TagOutputList(List.of(new TagOutput(ATORegistry.INVAR.INGOT.get(), 8))),
                        List.of(),
                        new IngredientWithSize(ATORegistry.IRON.INGOT_TAG, 4),
                        List.of(new IngredientWithSize(ATORegistry.NICKEL.INGOT_TAG, 2))
                ),
                // Electrum
                arcFurnaceRecipe(
                        new TagOutputList(List.of(new TagOutput(ATORegistry.ELECTRUM.INGOT.get(), 10))),
                        List.of(),
                        new IngredientWithSize(ATORegistry.GOLD.INGOT_TAG, 2),
                        List.of(new IngredientWithSize(ATORegistry.SILVER.INGOT_TAG, 2))
                ),
                // Bronze
                arcFurnaceRecipe(
                        new TagOutputList(List.of(new TagOutput(ATORegistry.BRONZE.INGOT.get(), 10))),
                        List.of(),
                        new IngredientWithSize(ATORegistry.COPPER.INGOT_TAG, 6),
                        List.of(new IngredientWithSize(ATORegistry.TIN.INGOT_TAG, 2))
                ),
                // Brass
                arcFurnaceRecipe(
                        new TagOutputList(List.of(new TagOutput(ATORegistry.BRASS.INGOT.get(), 10))),
                        List.of(),
                        new IngredientWithSize(ATORegistry.COPPER.INGOT_TAG, 6),
                        List.of(new IngredientWithSize(ATORegistry.ZINC.INGOT_TAG, 2))
                ),
                // Enderium
                arcFurnaceRecipe(
                        new TagOutputList(List.of(new TagOutput(ATORegistry.ENDERIUM.INGOT.get(), 10))),
                        List.of(),
                        new IngredientWithSize(ATORegistry.LEAD.INGOT_TAG, 6),
                        List.of(
                                new IngredientWithSize(ATORegistry.PLATINUM.INGOT_TAG, 2),
                                new IngredientWithSize(Tags.Items.ENDER_PEARLS, 3)
                        )
                ),
                // Lumium
                arcFurnaceRecipe(
                        new TagOutputList(List.of(new TagOutput(ATORegistry.LUMIUM.INGOT.get(), 10))),
                        List.of(),
                        new IngredientWithSize(Tags.Items.DUSTS_GLOWSTONE, 8),
                        List.of(
                                new IngredientWithSize(ATORegistry.SILVER.INGOT_TAG, 2),
                                new IngredientWithSize(ATORegistry.TIN.INGOT_TAG, 6)
                        )
                ),
                // Signalum
                arcFurnaceRecipe(
                        new TagOutputList(List.of(new TagOutput(ATORegistry.SIGNALUM.INGOT.get(), 10))),
                        List.of(),
                        new IngredientWithSize(ATORegistry.COPPER.INGOT_TAG, 6),
                        List.of(
                                new IngredientWithSize(ATORegistry.SILVER.INGOT_TAG, 2),
                                new IngredientWithSize(Tags.Items.DUSTS_REDSTONE, 8)
                        )
                ),
                // Constantan
                arcFurnaceRecipe(
                        new TagOutputList(List.of(new TagOutput(ATORegistry.CONSTANTAN.INGOT.get(), 5))),
                        List.of(),
                        new IngredientWithSize(ATORegistry.COPPER.INGOT_TAG, 2),
                        List.of(new IngredientWithSize(ATORegistry.NICKEL.INGOT_TAG, 2))
                )

        ).forEach(recipe -> recipeOutput.accept(
                arcFurnaceDir(String.format("%s/ingot", BuiltInRegistries.ITEM.getKey(recipe.output.get().getFirst().getItem()).getPath().replaceAll("_ingot", ""))),
                recipe,
                null,
                new ModLoadedCondition("immersiveengineering"))
        );

        ATOSetHelper.applyToAlloy(set -> {

            // ##### Arc Furnace #####

            // Dust -> Ingot
            recipeOutput.accept(
                    arcFurnaceDir(String.format("%s/from_dust", set.name)),
                    arcFurnaceRecipe(
                            new TagOutputList(List.of(new TagOutput(set.INGOT.get()))),
                            List.of(),
                            new IngredientWithSize(set.DUST_TAG),
                            List.of()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Rod -> Ingot
            recipeOutput.accept(
                    arcFurnaceDir(String.format("%s/from_rod", set.name)),
                    arcFurnaceRecipe(
                            new TagOutputList(List.of(new TagOutput(set.NUGGET_TAG, 2))),
                            List.of(),
                            new IngredientWithSize(set.ROD_TAG),
                            List.of()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Gear -> Ingot
            recipeOutput.accept(
                    arcFurnaceDir(String.format("%s/from_gear", set.name)),
                    arcFurnaceRecipe(
                            new TagOutputList(List.of(new TagOutput(set.INGOT.get(), 2))),
                            List.of(),
                            new IngredientWithSize(set.GEAR_TAG),
                            List.of()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Plate -> Ingot
            recipeOutput.accept(
                    arcFurnaceDir(String.format("%s/from_plate", set.name)),
                    arcFurnaceRecipe(
                            new TagOutputList(List.of(new TagOutput(set.INGOT.get()))),
                            List.of(),
                            new IngredientWithSize(set.PLATE_TAG),
                            List.of(new IngredientWithSize(Ingredient.EMPTY))
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );
        });

        ATOSetHelper.applyToIngot(set -> {
            // Raw -> 2x Ingot
            recipeOutput.accept(
                    arcFurnaceDir(String.format("%s/from_raw", set.name)),
                    arcFurnaceRecipe(
                            new TagOutputList(List.of(new TagOutput(set.INGOT.get(), 2))),
                            List.of(new StackWithChance(new TagOutput(set.INGOT_TAG), 0.5f)),
                            new IngredientWithSize(set.RAW_TAG),
                            List.of()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Raw Block -> 13x Ingot
            recipeOutput.accept(
                    arcFurnaceDir(String.format("%s/from_raw_block", set.name)),
                    arcFurnaceRecipe(
                            new TagOutputList(List.of(new TagOutput(set.INGOT.get(), 13))),
                            List.of(new StackWithChance(new TagOutput(set.INGOT_TAG), 0.5f)),
                            new IngredientWithSize(set.RAW_BLOCK_ITEM_TAG),
                            List.of()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );
        });

        ATOSetHelper.applyToVanillaIngot(set -> {
            // Dust -> Ingot
            recipeOutput.accept(
                    arcFurnaceDir(String.format("%s/from_dust", set.name)),
                    arcFurnaceRecipe(
                            new TagOutputList(List.of(new TagOutput(set.INGOT))),
                            List.of(),
                            new IngredientWithSize(set.DUST_TAG, 1),
                            List.of()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Rod -> Ingot
            recipeOutput.accept(
                    arcFurnaceDir(String.format("%s/from_rod", set.name)),
                    arcFurnaceRecipe(
                            new TagOutputList(List.of(new TagOutput(set.NUGGET_TAG, 2))),
                            List.of(),
                            new IngredientWithSize(set.ROD_TAG, 1),
                            List.of()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Gear -> Ingot
            recipeOutput.accept(
                    arcFurnaceDir(String.format("%s/from_gear", set.name)),
                    arcFurnaceRecipe(
                            new TagOutputList(List.of(new TagOutput(set.INGOT, 2))),
                            List.of(),
                            new IngredientWithSize(set.GEAR_TAG, 1),
                            List.of()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Plate -> Ingot
            recipeOutput.accept(
                    arcFurnaceDir(String.format("%s/from_plate", set.name)),
                    arcFurnaceRecipe(
                            new TagOutputList(List.of(new TagOutput(set.INGOT))),
                            List.of(),
                            new IngredientWithSize(set.PLATE_TAG, 1),
                            List.of()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );
        });

        ATOSetHelper.applyToVanillaDebris(set -> {
            // Dust -> Ingot
            recipeOutput.accept(
                    arcFurnaceDir(String.format("%s/from_dust", set.name)),
                    arcFurnaceRecipe(
                            new TagOutputList(List.of(new TagOutput(set.INGOT))),
                            List.of(),
                            new IngredientWithSize(set.DUST_TAG, 1),
                            List.of()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Rod -> Ingot
            recipeOutput.accept(
                    arcFurnaceDir(String.format("%s/from_rod", set.name)),
                    arcFurnaceRecipe(
                            new TagOutputList(List.of(new TagOutput(set.SCRAP, 2))),
                            List.of(),
                            new IngredientWithSize(set.ROD_TAG, 1),
                            List.of()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Gear -> Ingot
            recipeOutput.accept(
                    arcFurnaceDir(String.format("%s/from_gear", set.name)),
                    arcFurnaceRecipe(
                            new TagOutputList(List.of(new TagOutput(set.SCRAP, 8))),
                            List.of(),
                            new IngredientWithSize(set.GEAR_TAG, 1),
                            List.of()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );

            // Plate -> Ingot
            recipeOutput.accept(
                    arcFurnaceDir(String.format("%s/from_plate", set.name)),
                    arcFurnaceRecipe(
                            new TagOutputList(List.of(new TagOutput(set.SCRAP, 2))),
                            List.of(),
                            new IngredientWithSize(set.PLATE_TAG, 1),
                            List.of()
                    ),
                    null,
                    new ModLoadedCondition("immersiveengineering")
            );
        });
    }

    private ArcFurnaceRecipe arcFurnaceRecipe(TagOutputList tagOutputList, List<StackWithChance> secondariesList, IngredientWithSize input, List<IngredientWithSize> addativesList) {

        final List<TagOutput> outputs = new ArrayList<>(tagOutputList.getLazyList());
        final List<StackWithChance> secondaries = new ArrayList<>(secondariesList);
        final List<IngredientWithSize> additives = new ArrayList<>(addativesList);

        return new ArcFurnaceRecipe(
                new TagOutputList(outputs),
                TagOutput.EMPTY,
                secondaries,
                100,
                51200,
                input,
                additives
        );
    }
}
