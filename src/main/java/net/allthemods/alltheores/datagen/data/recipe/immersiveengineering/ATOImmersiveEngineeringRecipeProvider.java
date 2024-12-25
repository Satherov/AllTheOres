package net.allthemods.alltheores.datagen.data.recipe.immersiveengineering;

import blusunrize.immersiveengineering.api.crafting.*;
import blusunrize.immersiveengineering.common.register.IEItems;
import net.allthemods.alltheores.content.blocks.sets.ATOSetHelper;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.registry.ATORegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class ATOImmersiveEngineeringRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ATOImmersiveEngineeringRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
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

        List.of(// Invar
                alloyRecipe(
                        ATORegistry.INVAR.INGOT.get(),
                        new IngredientWithSize(ATORegistry.IRON.INGOT_TAG, 2),
                        new IngredientWithSize(ATORegistry.NICKEL.INGOT_TAG)),
                // Electrum
                alloyRecipe(
                        ATORegistry.ELECTRUM.INGOT.get(),
                        new IngredientWithSize(ATORegistry.GOLD.INGOT_TAG),
                        new IngredientWithSize(ATORegistry.SILVER.INGOT_TAG)),
                // Bronze
                alloyRecipe(
                        ATORegistry.BRONZE.INGOT.get(),
                        new IngredientWithSize(ATORegistry.COPPER.INGOT_TAG, 3),
                        new IngredientWithSize(ATORegistry.TIN.INGOT_TAG)),
                // Brass
                alloyRecipe(
                        ATORegistry.BRASS.INGOT.get(),
                        new IngredientWithSize(ATORegistry.COPPER.INGOT_TAG, 3),
                        new IngredientWithSize(ATORegistry.ZINC.INGOT_TAG)),
                // Constantan
                alloyRecipe(
                        ATORegistry.CONSTANTAN.INGOT.get(),
                        new IngredientWithSize(ATORegistry.COPPER.INGOT_TAG),
                        new IngredientWithSize(ATORegistry.NICKEL.INGOT_TAG))
                // Enderium, Lumium and Signalum dont fit in the Alloy Smelter
        ).forEach(recipe -> recipeOutput.accept(
                    alloySmeltingDir(String.format("%s/ingot", BuiltInRegistries.ITEM.getKey(recipe.output.get().getItem()).getPath().replaceAll("_ingot", ""))),
                    recipe,
                    null,
                    new ModLoadedCondition("immersiveengineering"))
        );

        // ##### Arc Furnace #####

        List.of(// Invar
                arcFurnaceRecipe(
                        new TagOutputList(List.of(new TagOutput(ATORegistry.INVAR.INGOT.get()))),
                        List.of(),
                        new IngredientWithSize(ATORegistry.IRON.INGOT_TAG),
                        List.of(new IngredientWithSize(ATORegistry.NICKEL.INGOT_TAG))
                ),
                arcFurnaceRecipe(
                        new TagOutputList(List.of(new TagOutput(ATORegistry.ELECTRUM.INGOT.get()))),
                        List.of(),
                        new IngredientWithSize(ATORegistry.GOLD.INGOT_TAG),
                        List.of(new IngredientWithSize(ATORegistry.SILVER.INGOT_TAG))
                ),
                arcFurnaceRecipe(
                        new TagOutputList(List.of(new TagOutput(ATORegistry.BRONZE.INGOT.get()))),
                        List.of(),
                        new IngredientWithSize(ATORegistry.COPPER.INGOT_TAG, 3),
                        List.of(new IngredientWithSize(ATORegistry.TIN.INGOT_TAG))
                ),
                arcFurnaceRecipe(
                        new TagOutputList(List.of(new TagOutput(ATORegistry.BRASS.INGOT.get()))),
                        List.of(),
                        new IngredientWithSize(ATORegistry.COPPER.INGOT_TAG, 3),
                        List.of(new IngredientWithSize(ATORegistry.ZINC.INGOT_TAG))
                ),
                arcFurnaceRecipe(
                        new TagOutputList(List.of(new TagOutput(ATORegistry.ENDERIUM.INGOT.get()))),
                        List.of(),
                        new IngredientWithSize(ATORegistry.LEAD.INGOT_TAG, 3),
                        List.of(
                                new IngredientWithSize(ATORegistry.PLATINUM.INGOT_TAG),
                                new IngredientWithSize(Tags.Items.ENDER_PEARLS, 2)
                        )
                ),
                arcFurnaceRecipe(
                        new TagOutputList(List.of(new TagOutput(ATORegistry.LUMIUM.INGOT.get()))),
                        List.of(),
                        new IngredientWithSize(Tags.Items.DUSTS_GLOWSTONE, 4),
                        List.of(
                                new IngredientWithSize(ATORegistry.SILVER.INGOT_TAG),
                                new IngredientWithSize(ATORegistry.TIN.INGOT_TAG, 3)
                        )
                ),
                arcFurnaceRecipe(
                        new TagOutputList(List.of(new TagOutput(ATORegistry.SIGNALUM.INGOT.get()))),
                        List.of(),
                        new IngredientWithSize(ATORegistry.COPPER.INGOT_TAG, 3),
                        List.of(
                                new IngredientWithSize(ATORegistry.SILVER.INGOT_TAG),
                                new IngredientWithSize(Tags.Items.DUSTS_REDSTONE, 4)
                        )
                ),
                arcFurnaceRecipe(
                        new TagOutputList(List.of(new TagOutput(ATORegistry.CONSTANTAN.INGOT.get()))),
                        List.of(),
                        new IngredientWithSize(ATORegistry.COPPER.INGOT_TAG),
                        List.of(new IngredientWithSize(ATORegistry.NICKEL.INGOT_TAG))
                )

        ).forEach(recipe -> recipeOutput.accept(
                    arcFurnaceDir(String.format("%s/ingot", BuiltInRegistries.ITEM.getKey(recipe.output.get().getFirst().getItem()).getPath().replaceAll("_ingot", ""))),
                    recipe,
                    null,
                    new ModLoadedCondition("immersiveengineering"))
        );

        ATOSetHelper.applyToAlloy( set -> {

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
                            new TagOutputList(List.of(new TagOutput(set.INGOT.get()))),
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
                            new TagOutputList(List.of(new TagOutput(set.INGOT.get()))),
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

            // ##### Crusher #####

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

            // ##### Metal Press #####

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

        ATOSetHelper.applyToIngot( set -> {

            // ##### Arc Furnace #####

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

            // ##### Crusher #####

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

        ATOSetHelper.applyToGem( set -> {

            // ##### Crusher #####

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

        ATOSetHelper.applyToVanillaIngot( set -> {

            // ##### Arc Furnace #####

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
                            new TagOutputList(List.of(new TagOutput(set.INGOT))),
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
                            new TagOutputList(List.of(new TagOutput(set.INGOT))),
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

            // ##### Crusher #####

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

            // ##### Metal Press #####

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

        ATOSetHelper.applyToVanillaGem( set -> {

            // ##### Crusher #####

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

            // ##### Metal Press #####

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

        ATOSetHelper.applyToVanillaDebris( set -> {

            // ##### Arc Furnace #####

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
                            new TagOutputList(List.of(new TagOutput(set.INGOT))),
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
                            new TagOutputList(List.of(new TagOutput(set.INGOT))),
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

            // ##### Crusher #####

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

            // ##### Metal Press #####

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

    private AlloyRecipe alloyRecipe(ItemLike output, IngredientWithSize input1, IngredientWithSize input2) {
        return new AlloyRecipe(
                new TagOutput(output),
                input1,
                input2,
                200);
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

    private CrusherRecipe crusherRecipe(TagOutput output, Ingredient input, List<StackWithChance> secondaryOutputs) {
        return new CrusherRecipe(
                output,
                input,
                51200,
                secondaryOutputs
        );
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
