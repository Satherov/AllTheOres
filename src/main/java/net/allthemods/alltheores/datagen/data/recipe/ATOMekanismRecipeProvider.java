package net.allthemods.alltheores.datagen.data.recipe;

import mekanism.api.chemical.ChemicalStack;
import mekanism.api.datagen.recipe.builder.*;
import mekanism.api.providers.IChemicalProvider;
import mekanism.api.recipes.ingredients.creator.IngredientCreatorAccess;
import mekanism.common.registries.MekanismChemicals;
import net.allthemods.alltheores.content.blocks.sets.ATOSetHelper;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.registry.ATORegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;

public class ATOMekanismRecipeProvider extends RecipeProvider {

    public ATOMekanismRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
        super(packOutput, provider);
    }

    // ##### Mekanism Prcoessing #####

    private ResourceLocation dirtySlurryRecipeDir(String typeIn, String name) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "processing/" + name + "/slurry/dirty/from_" + typeIn);
    }

    private ResourceLocation cleanSlurryRecipeDir(String name) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "processing/" + name + "/slurry/from_dirty");
    }

    private ResourceLocation crystalRecipeDir(String typeIn, String name) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "processing/" + name + "/crystal/from_" + typeIn);
    }

    private ResourceLocation shardRecipeDir(String typeIn, String name) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "processing/" + name + "/shard/from_" + typeIn);
    }

    private ResourceLocation clumpRecipeDir(String typeIn, String name) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "processing/" + name + "/clump/from_" + typeIn);
    }

    private ResourceLocation dirtyDustRecipeDir(String typeIn, String name) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "processing/" + name + "/dirty_dust/from_" + typeIn);
    }

    private ResourceLocation dustRecipeDir(String typeIn, String name) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "processing/" + name + "/dust/from_" + typeIn);
    }

    private ResourceLocation enrichingRecipeDir(String typeIn, String name) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "processing/" + name + "/from_" + typeIn);
    }

    private ResourceLocation crushingRecipeDir(String typeOut, String name) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "processing/" + name + "/to_" + typeOut);
    }

    private ResourceLocation chemicalConversionRecipeDir(String typeIn, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "chemical_conversion/" + typeIn + "_to_" + typeOut);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        ATOSetHelper.applyToVanillaIngot( set -> {

            // ##### Dissolution #####

            // Ore -> Dirty Slurry
            ChemicalDissolutionRecipeBuilder.dissolution(IngredientCreatorAccess.item().from(set.ORE_BLOCK_ITEM_TAG, 1), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.SULFURIC_ACID, 1), new ChemicalStack(set.MEK.DIRTY_SLURRY, 1000), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dirtySlurryRecipeDir("ore", set.name));
            // Raw Block -> Dirty Slurry
            ChemicalDissolutionRecipeBuilder.dissolution(IngredientCreatorAccess.item().from(set.RAW_BLOCK_ITEM_TAG, 1), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.SULFURIC_ACID, 2), new ChemicalStack(set.MEK.DIRTY_SLURRY, 6000), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dirtySlurryRecipeDir("raw_block", set.name));
            // Raw -> Dirty Slurry
            ChemicalDissolutionRecipeBuilder.dissolution(IngredientCreatorAccess.item().from(set.RAW_TAG, 3), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.SULFURIC_ACID, 1), new ChemicalStack(set.MEK.DIRTY_SLURRY, 2000), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dirtySlurryRecipeDir("raw", set.name));

            // ##### Injecting #####

            // Ore -> Shard
            ItemStackChemicalToItemStackRecipeBuilder.injecting(IngredientCreatorAccess.item().from(set.ORE_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.HYDROGEN_CHLORIDE, 1), new ItemStack(set.MEK.SHARD.get(), 4), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, shardRecipeDir("ore", set.name));
            // Raw Block -> Shard
            ItemStackChemicalToItemStackRecipeBuilder.injecting(IngredientCreatorAccess.item().from(set.RAW_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.HYDROGEN_CHLORIDE, 2), new ItemStack(set.MEK.SHARD.get(), 24), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, shardRecipeDir("raw_block", set.name));
            // Raw -> Shard
            ItemStackChemicalToItemStackRecipeBuilder.injecting(IngredientCreatorAccess.item().from(set.RAW_TAG, 3), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.HYDROGEN_CHLORIDE, 1), new ItemStack(set.MEK.SHARD.get(), 8), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, shardRecipeDir("raw", set.name));

            // ##### Purifying #####

            // Ore -> Clump
            ItemStackChemicalToItemStackRecipeBuilder.purifying(IngredientCreatorAccess.item().from(set.ORE_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 1), new ItemStack(set.MEK.CLUMP.get(), 3), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, clumpRecipeDir("ore", set.name));
            // Raw Block -> Clump
            ItemStackChemicalToItemStackRecipeBuilder.purifying(IngredientCreatorAccess.item().from(set.RAW_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 2), new ItemStack(set.MEK.CLUMP.get(), 18), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, clumpRecipeDir("raw_block", set.name));
            // Raw -> Clump
            ItemStackChemicalToItemStackRecipeBuilder.purifying(IngredientCreatorAccess.item().from(set.RAW_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 1), new ItemStack(set.MEK.CLUMP.get(), 2), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, clumpRecipeDir("raw", set.name));

            // ##### Crushing #####

            // Ingot -> Dust
            ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(set.INGOT_TAG), new ItemStack(set.DUST.get(), 1))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dustRecipeDir("ingot", set.name));


            // ##### Enriching #####

            // Dirty Dust -> Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.MEK.DIRTY_DUST_TAG), new ItemStack(set.DUST.get()))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dustRecipeDir("dirty_dust", set.name));

            // Ore -> 2x Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.ORE_BLOCK_ITEM_TAG), new ItemStack(set.DUST, 2))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dustRecipeDir("ore", set.name));

            // 3x Raw -> 4x Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.RAW_TAG, 3), new ItemStack(set.DUST, 4))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dustRecipeDir("raw", set.name));

            // Raw Block -> 12x Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.RAW_BLOCK_ITEM_TAG), new ItemStack(set.DUST, 12))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dustRecipeDir("raw_block", set.name));
        });

        ATOSetHelper.applyToVanillaGem( set -> {

            // ##### Crushing #####

            // Gem -> Dust
            ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(set.GEM_TAG), new ItemStack(set.DUST.get(), 1))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dustRecipeDir("ingot", set.name));

            // ##### Enriching #####

            // Ore -> 2x Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.ORE_BLOCK_ITEM_TAG), new ItemStack(set.DUST, 2))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dustRecipeDir("ore", set.name));

            // Dust -> Gem
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.DUST_TAG), new ItemStack(set.GEM))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, enrichingRecipeDir("dust", set.name));
        });

        ATOSetHelper.applyToVanillaDebris( set -> {

            // ##### Crushing #####

            // Ingot -> Dust
            ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(set.INGOT_TAG), new ItemStack(set.DUST.get(), 1))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dustRecipeDir("ingot", set.name));
        });

        ATOSetHelper.applyToAlloy( set -> {

            // ##### Crushing ####

            // Ingot -> Dust
            ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(set.INGOT_TAG), new ItemStack(set.DUST.get()))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dustRecipeDir("ingot", set.name));
        });

        ATOSetHelper.applyToIngot( set -> {

            // ##### Dissolution #####

            // Ore -> Dirty Slurry
            ChemicalDissolutionRecipeBuilder.dissolution(IngredientCreatorAccess.item().from(set.ORES.ORE_BLOCK_ITEM_TAG, 1), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.SULFURIC_ACID, 1), new ChemicalStack(set.MEK.DIRTY_SLURRY, 1000), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dirtySlurryRecipeDir("ore", set.name));
            // Raw Block -> Dirty Slurry
            ChemicalDissolutionRecipeBuilder.dissolution(IngredientCreatorAccess.item().from(set.RAW_BLOCK_ITEM_TAG, 1), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.SULFURIC_ACID, 2), new ChemicalStack(set.MEK.DIRTY_SLURRY, 6000), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dirtySlurryRecipeDir("raw_block", set.name));
            // Raw -> Dirty Slurry
            ChemicalDissolutionRecipeBuilder.dissolution(IngredientCreatorAccess.item().from(set.RAW_TAG, 3), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.SULFURIC_ACID, 1), new ChemicalStack(set.MEK.DIRTY_SLURRY, 2000), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dirtySlurryRecipeDir("raw", set.name));

            // ##### Injecting #####

            // Ore -> Shard
            ItemStackChemicalToItemStackRecipeBuilder.injecting(IngredientCreatorAccess.item().from(set.ORES.ORE_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.HYDROGEN_CHLORIDE, 1), new ItemStack(set.MEK.SHARD.get(), 4), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, shardRecipeDir("ore", set.name));
            // Raw Block -> Shard
            ItemStackChemicalToItemStackRecipeBuilder.injecting(IngredientCreatorAccess.item().from(set.RAW_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.HYDROGEN_CHLORIDE, 2), new ItemStack(set.MEK.SHARD.get(), 24), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, shardRecipeDir("raw_block", set.name));
            // Raw -> Shard
            ItemStackChemicalToItemStackRecipeBuilder.injecting(IngredientCreatorAccess.item().from(set.RAW_TAG, 3), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.HYDROGEN_CHLORIDE, 1), new ItemStack(set.MEK.SHARD.get(), 8), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, shardRecipeDir("raw", set.name));

            // ##### Purifying #####

            // Ore -> Clump
            ItemStackChemicalToItemStackRecipeBuilder.purifying(IngredientCreatorAccess.item().from(set.ORES.ORE_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 1), new ItemStack(set.MEK.CLUMP.get(), 3), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, clumpRecipeDir("ore", set.name));
            // Raw Block -> Clump
            ItemStackChemicalToItemStackRecipeBuilder.purifying(IngredientCreatorAccess.item().from(set.RAW_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 2), new ItemStack(set.MEK.CLUMP.get(), 18), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, clumpRecipeDir("raw_block", set.name));
            // Raw -> Clump
            ItemStackChemicalToItemStackRecipeBuilder.purifying(IngredientCreatorAccess.item().from(set.RAW_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 1), new ItemStack(set.MEK.CLUMP.get(), 2), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, clumpRecipeDir("raw", set.name));

            // ##### Enriching #####

            // Dirty Dust -> Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.MEK.DIRTY_DUST_TAG), new ItemStack(set.DUST.get()))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dustRecipeDir("dirty_dust", set.name));

            // Ore -> 2x Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.ORES.ORE_BLOCK_ITEM_TAG), new ItemStack(set.DUST, 2))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dustRecipeDir("ore", set.name));

            // 3x Raw -> 4x Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.RAW_TAG, 3), new ItemStack(set.DUST, 4))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dustRecipeDir("raw", set.name));

            // Raw Block -> 12x Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.RAW_BLOCK_ITEM_TAG), new ItemStack(set.DUST, 12))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dustRecipeDir("raw_block", set.name));
        });

        ATOSetHelper.applyToGem( set -> {

            // ##### Crushing #####

            // Gem -> Dust
            ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(set.GEM_TAG), new ItemStack(set.DUST.get(), 1))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dustRecipeDir("gem", set.name));

            // ##### Enriching #####

            // Ore -> 2x Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.ORES.ORE_BLOCK_ITEM_TAG), new ItemStack(set.DUST, 2))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dustRecipeDir("ore", set.name));

            // Dust -> Gem
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.DUST_TAG), new ItemStack(set.GEM))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, enrichingRecipeDir("dust", set.name));
        });

        ATOSetHelper.applyToDust( set -> {
            // ##### Enriching #####

            // Ore -> Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.ORES.ORE_BLOCK_ITEM_TAG), new ItemStack(set.DUST, 6))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, enrichingRecipeDir("ore", set.name));
        });

        ATOSetHelper.applyToMekanism( set -> {

            // ##### Washing #####

            // Dirty Slurry -> Clean Slurry
            FluidChemicalToChemicalRecipeBuilder.washing(IngredientCreatorAccess.fluid().from(FluidTags.WATER, 5), IngredientCreatorAccess.chemicalStack().from((IChemicalProvider) set.DIRTY_SLURRY, 1), new ChemicalStack(set.CLEAN_SLURRY, 1))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, cleanSlurryRecipeDir(set.name));


            // ##### Crystallizing #####

            // Clean Slurry -> Crystal
            ChemicalCrystallizerRecipeBuilder.crystallizing(IngredientCreatorAccess.chemicalStack().from((IChemicalProvider) set.CLEAN_SLURRY, 200), new ItemStack(set.CRYSTAL.get()))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, crystalRecipeDir("slurry", set.name));

            // ##### Injecting #####

            // Crystal -> Shard
            ItemStackChemicalToItemStackRecipeBuilder.injecting(IngredientCreatorAccess.item().from(set.CRYSTAL_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.HYDROGEN_CHLORIDE, 1), new ItemStack(set.SHARD.get()), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, shardRecipeDir("crystal", set.name));

            // ##### Purifying #####

            // Shard -> Clump
            ItemStackChemicalToItemStackRecipeBuilder.purifying(IngredientCreatorAccess.item().from(set.SHARD_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 1), new ItemStack(set.CLUMP.get()), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, clumpRecipeDir("shard", set.name));

            // ##### Crushing #####

            // Clumps -> Dirty Dust
            ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(set.CLUMP_TAG), new ItemStack(set.DIRTY_DUST.get()))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(output, dirtyDustRecipeDir("clump", set.name));
        });

        ItemStackToChemicalRecipeBuilder
                .chemicalConversion(IngredientCreatorAccess.item().from(ATORegistry.SULFUR.BLOCK_ITEM.get()), new ChemicalStack(MekanismChemicals.SULFURIC_ACID, 18))
                .addCondition(new ModLoadedCondition("mekanism"))
                .build(output, chemicalConversionRecipeDir("sulfur_block", "sulfuric_acid"));
    }
}
