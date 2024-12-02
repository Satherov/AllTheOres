package net.allthemods.alltheores.datagen.data.recipe;

import mekanism.api.datagen.recipe.builder.ItemStackToItemStackRecipeBuilder;
import mekanism.api.recipes.ingredients.creator.IngredientCreatorAccess;
import net.allthemods.alltheores.blocks.BlockList;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.registry.GroupHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.concurrent.CompletableFuture;

public class ATOMekanismRecipeProvider extends RecipeProvider {

    public ATOMekanismRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    private ResourceLocation dissolutionRecipeDir(String typeIn, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "dissolution/" + typeIn + "_from_" + typeOut);
    }

    private ResourceLocation washingRecipeDir(String typeIn, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "washing/" + typeIn + "_from_" + typeOut);
    }

    private ResourceLocation crystallizingRecipeDir(String typeIn, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "crystallizing/" + typeIn + "_from_" + typeOut);
    }

    private ResourceLocation injectingRecipeDir(String typeIn, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "injecting/" + typeIn + "_from_" + typeOut);
    }

    private ResourceLocation purifyingRecipeDir(String typeIn, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "purifying/" + typeIn + "_from_" + typeOut);
    }

    private ResourceLocation crushingRecipeDir(String typeIn, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "crushing/" + typeIn + "_from_" + typeOut);
    }

    private ResourceLocation enrichingRecipeDir(String typeIn, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "enriching/" + typeIn + "_from_" + typeOut);
    }

    private ResourceLocation combiningRecipeDir(String typeIn, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "combining/" + typeIn + "_from_" + typeOut);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {
        GroupHelper.applyToMaterial(group -> {
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(group.DIRTY_DUST_TAG), new ItemStack(group.DUST.get()))
                    .build(consumer, Mekanism.rl(basePath + "dust/from_dirty_dust"));
        });
    }
}
