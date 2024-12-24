package net.allthemods.alltheores.datagen.data;

import mekanism.api.chemical.ChemicalStack;
import mekanism.api.datagen.recipe.builder.*;
import mekanism.api.providers.IChemicalProvider;
import mekanism.api.recipes.ingredients.creator.IngredientCreatorAccess;
import mekanism.common.registries.MekanismChemicals;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.registry.ATORegistry;
import net.allthemods.alltheores.registry.ATOTagRegistry;
import net.allthemods.alltheores.content.blocks.sets.ATOSetHelper;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;

public class ATORecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ATORecipeProvider(PackOutput packOutput, CompletableFuture<Provider> provider) {
        super(packOutput, provider);
    }

    // AllTheOres
    private ResourceLocation smeltingRecipeDir(String type, String name) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "smelting/" + name + "/" +  type + "_smelting");
    }

    private ResourceLocation blastingRecipeDir(String type, String name) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "smelting/" + name + "/" +  type + "_blasting");
    }

    private ResourceLocation shapelessIORecipeDir(String typeIn, String name, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "crafting/" + name + "/" +  typeOut + "_from_" + typeIn);
    }

    private ResourceLocation shapelessRecipeDir(String name, String type) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "crafting/" + name + "/" +  type);
    }

    private ResourceLocation hammerRecipeDir(String typeIn, String name, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "crafting/hammer/" + name + "/" + typeOut + "_from_" + typeIn);
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

    private ShapedRecipeBuilder compress(TagKey<Item> tag, Item output) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output)
                .pattern("aaa")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', tag);
    }

    private ShapelessRecipeBuilder uncompress(TagKey<Item> tag, Item output) {
        return ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, output, 9)
                .requires(tag);
    }

    private ShapedRecipeBuilder gear(TagKey<Item> tag, Item output) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output)
                .pattern(" a ")
                .pattern("ana")
                .pattern(" a ")
                .define('a', tag)
                .define('n', Tags.Items.NUGGETS_IRON);
    }

    private ShapedRecipeBuilder rod(TagKey<Item> tag, Item output) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output)
                .pattern("   ")
                .pattern("  a")
                .pattern("ha ")
                .define('a', tag)
                .define('h', ATOTagRegistry.ORE_HAMMERS);
    }

    private ShapedRecipeBuilder plate(TagKey<Item> tag, Item output) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output)
                .pattern("   ")
                .pattern("ha ")
                .pattern("a  ")
                .define('a', tag)
                .define('h', ATOTagRegistry.ORE_HAMMERS);
    }

    private ShapelessRecipeBuilder hammer(TagKey<Item> tag, int amount, Item output) {
        return ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, amount)
                .requires(ATOTagRegistry.ORE_HAMMERS)
                .requires(tag)
                .unlockedBy("has_hammer", has(ATOTagRegistry.ORE_HAMMERS));
    }

    private ShapedRecipeBuilder hammerBuilder(TagKey<Item> tag, Item output) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output)
                .pattern(" as")
                .pattern(" sa")
                .pattern("s  ")
                .define('a', tag)
                .define('s', Tags.Items.RODS_WOODEN);
    }

    private SimpleCookingRecipeBuilder blasting(TagKey<Item> tag, Item output) {
        return SimpleCookingRecipeBuilder.blasting(Ingredient.of(tag), RecipeCategory.MISC, output, 0.7f, 100);
    }

    private SimpleCookingRecipeBuilder smelting(TagKey<Item> tag, Item output) {
        return SimpleCookingRecipeBuilder.smelting(Ingredient.of(tag), RecipeCategory.MISC, output, 0.7f, 200);
    }


    @Override
    protected void buildRecipes(RecipeOutput consumer) {
        
        ATOSetHelper.applyToVanillaIngot( set -> {

            // ##### Hammer #####

            // Hammer + Ore -> 2x Dust
            hammer(set.ORE_BLOCK_ITEM_TAG, 2, set.DUST.get()).save(consumer, hammerRecipeDir("ore", set.name, "dust"));
            // Hammer + Raw -> 2x Dust
            hammer(set.RAW_TAG, 2, set.DUST.get()).save(consumer, hammerRecipeDir("raw", set.name, "dust"));
            // Hammer + Ingot -> Dust
            hammer(set.INGOT_TAG, 1, set.DUST.get()).save(consumer, hammerRecipeDir("ingot", set.name, "dust"));

            // ##### Smelting #####

            // Dust -> Ingot
            smelting(set.DUST_TAG, set.INGOT)
                    .unlockedBy(String.format("has_%s_dust", set.name), has(set.DUST_TAG))
                    .save(consumer, smeltingRecipeDir("dust", set.name));
            blasting(set.DUST_TAG, set.INGOT)
                    .unlockedBy(String.format("has_%s_dust", set.name), has(set.DUST_TAG))
                    .save(consumer, blastingRecipeDir("dust", set.name));

            // ##### Crafting #####

            // Gear
            gear(set.INGOT_TAG, set.GEAR.get())
                    .unlockedBy(String.format("has_%s_ingot", set.name), has(set.INGOT_TAG))
                    .save(consumer, shapelessRecipeDir(set.name, "gear"));
            // Rod
            rod(set.INGOT_TAG, set.ROD.get())
                    .unlockedBy(String.format("has_%s_ingot", set.name), has(set.INGOT_TAG))
                    .save(consumer, shapelessRecipeDir(set.name, "rod"));
            // Plate
            plate(set.INGOT_TAG, set.PLATE.get())
                    .unlockedBy(String.format("has_%s_ingot", set.name), has(set.INGOT_TAG))
                    .save(consumer, shapelessRecipeDir(set.name, "plate"));

            // ##### Dissolution #####

            // Ore -> Dirty Slurry
            ChemicalDissolutionRecipeBuilder.dissolution(IngredientCreatorAccess.item().from(set.ORE_BLOCK_ITEM_TAG, 1), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.SULFURIC_ACID, 1), new ChemicalStack(set.MEK.DIRTY_SLURRY, 1000), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dirtySlurryRecipeDir("ore", set.name));
            // Raw Block -> Dirty Slurry
            ChemicalDissolutionRecipeBuilder.dissolution(IngredientCreatorAccess.item().from(set.RAW_BLOCK_ITEM_TAG, 1), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.SULFURIC_ACID, 2), new ChemicalStack(set.MEK.DIRTY_SLURRY, 6000), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dirtySlurryRecipeDir("raw_block", set.name));
            // Raw -> Dirty Slurry
            ChemicalDissolutionRecipeBuilder.dissolution(IngredientCreatorAccess.item().from(set.RAW_TAG, 3), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.SULFURIC_ACID, 1), new ChemicalStack(set.MEK.DIRTY_SLURRY, 2000), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dirtySlurryRecipeDir("raw", set.name));

            // ##### Injecting #####

            // Ore -> Shard
            ItemStackChemicalToItemStackRecipeBuilder.injecting(IngredientCreatorAccess.item().from(set.ORE_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.HYDROGEN_CHLORIDE, 1), new ItemStack(set.MEK.SHARD.get(), 4), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, shardRecipeDir("ore", set.name));
            // Raw Block -> Shard
            ItemStackChemicalToItemStackRecipeBuilder.injecting(IngredientCreatorAccess.item().from(set.RAW_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.HYDROGEN_CHLORIDE, 2), new ItemStack(set.MEK.SHARD.get(), 24), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, shardRecipeDir("raw_block", set.name));
            // Raw -> Shard
            ItemStackChemicalToItemStackRecipeBuilder.injecting(IngredientCreatorAccess.item().from(set.RAW_TAG, 3), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.HYDROGEN_CHLORIDE, 1), new ItemStack(set.MEK.SHARD.get(), 8), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, shardRecipeDir("raw", set.name));

            // ##### Purifying #####

            // Ore -> Clump
            ItemStackChemicalToItemStackRecipeBuilder.purifying(IngredientCreatorAccess.item().from(set.ORE_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 1), new ItemStack(set.MEK.CLUMP.get(), 3), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, clumpRecipeDir("ore", set.name));
            // Raw Block -> Clump
            ItemStackChemicalToItemStackRecipeBuilder.purifying(IngredientCreatorAccess.item().from(set.RAW_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 2), new ItemStack(set.MEK.CLUMP.get(), 18), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, clumpRecipeDir("raw_block", set.name));
            // Raw -> Clump
            ItemStackChemicalToItemStackRecipeBuilder.purifying(IngredientCreatorAccess.item().from(set.RAW_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 1), new ItemStack(set.MEK.CLUMP.get(), 2), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, clumpRecipeDir("raw", set.name));

            // ##### Crushing #####

            // Ingot -> Dust
            ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(set.INGOT_TAG), new ItemStack(set.DUST.get(), 1))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dustRecipeDir("ingot", set.name));


            // ##### Enriching #####

            // Dirty Dust -> Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.MEK.DIRTY_DUST_TAG), new ItemStack(set.DUST.get()))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dustRecipeDir("dirty_dust", set.name));

            // Ore -> 2x Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.ORE_BLOCK_ITEM_TAG), new ItemStack(set.DUST, 2))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dustRecipeDir("ore", set.name));

            // 3x Raw -> 4x Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.RAW_TAG, 3), new ItemStack(set.DUST, 4))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dustRecipeDir("raw", set.name));

            // Raw Block -> 12x Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.RAW_BLOCK_ITEM_TAG), new ItemStack(set.DUST, 12))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dustRecipeDir("raw_block", set.name));
        });

        ATOSetHelper.applyToVanillaGem( set -> {

            // ##### Hammer #####

            // Hammer + Ore -> 2x Dust
            hammer(set.ORE_BLOCK_ITEM_TAG, 2, set.DUST.get()).save(consumer, hammerRecipeDir("ore", set.name, "dust"));
            // Hammer + Gem -> Dust
            hammer(set.GEM_TAG, 1, set.DUST.get()).save(consumer, hammerRecipeDir("gem", set.name, "dust"));

            // ##### Crafting #####

            // Gear
            gear(set.GEM_TAG, set.GEAR.get())
                    .unlockedBy(String.format("has_%s_gem", set.name), has(set.GEM_TAG))
                    .save(consumer, shapelessRecipeDir(set.name, "gear"));
            // Rod
            rod(set.GEM_TAG, set.ROD.get())
                    .unlockedBy(String.format("has_%s_gem", set.name), has(set.GEM_TAG))
                    .save(consumer, shapelessRecipeDir(set.name, "rod"));
            // Plate
            plate(set.GEM_TAG, set.PLATE.get())
                    .unlockedBy(String.format("has_%s_gem", set.name), has(set.GEM_TAG))
                    .save(consumer, shapelessRecipeDir(set.name, "plate"));

            // ##### Crushing #####

            // Gem -> Dust
            ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(set.GEM_TAG), new ItemStack(set.DUST.get(), 1))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dustRecipeDir("ingot", set.name));

            // ##### Enriching #####

            // Ore -> 2x Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.ORE_BLOCK_ITEM_TAG), new ItemStack(set.DUST, 2))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dustRecipeDir("ore", set.name));

            // Dust -> Gem
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.DUST_TAG), new ItemStack(set.GEM))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, enrichingRecipeDir("dust", set.name));
        });

        ATOSetHelper.applyToVanillaDebris( set -> {

            // ##### Hammer #####

            // Hammer + Debris -> 2x Scrap
            hammer(set.DEBRIS_ITEM_TAG, 2, set.SCRAP).save(consumer, hammerRecipeDir("debris", set.name, "scrap"));
            // Hammer + Ingot -> Dust
            hammer(set.INGOT_TAG, 1, set.DUST.get()).save(consumer, hammerRecipeDir("ingot", set.name, "dust"));

            // ##### Smelting #####

            // Dust -> Ingot
            smelting(set.DUST_TAG, set.INGOT)
                    .unlockedBy(String.format("has_%s_dust", set.name), has(set.DUST_TAG))
                    .save(consumer, smeltingRecipeDir("dust", set.name));
            blasting(set.DUST_TAG, set.INGOT)
                    .unlockedBy(String.format("has_%s_dust", set.name), has(set.DUST_TAG))
                    .save(consumer, blastingRecipeDir("dust", set.name));

            // ##### Crafting #####

            // Gear
            gear(set.INGOT_TAG, set.GEAR.get())
                    .unlockedBy(String.format("has_%s_ingot", set.name), has(set.INGOT_TAG))
                    .save(consumer, shapelessRecipeDir(set.name, "gear"));
            // Rod
            rod(set.INGOT_TAG, set.ROD.get())
                    .unlockedBy(String.format("has_%s_ingot", set.name), has(set.INGOT_TAG))
                    .save(consumer, shapelessRecipeDir(set.name, "rod"));
            // Plate
            plate(set.INGOT_TAG, set.PLATE.get())
                    .unlockedBy(String.format("has_%s_ingot", set.name), has(set.INGOT_TAG))
                    .save(consumer, shapelessRecipeDir(set.name, "plate"));

            // ##### Crushing #####

            // Ingot -> Dust
            ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(set.INGOT_TAG), new ItemStack(set.DUST.get(), 1))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dustRecipeDir("ingot", set.name));
        });

        ATOSetHelper.applyToAlloy(set -> {

            // ##### Compressing #####

            // Ingot -> 9x Nugget
            uncompress(set.INGOT_TAG, set.NUGGET.get())
                    .unlockedBy(String.format("has_%s_ingot", set.name), has(set.INGOT_TAG))
                    .save(consumer, shapelessIORecipeDir("ingot", set.name, "nugget"));
            // 9x Nugget -> Ingot
            compress(set.NUGGET_TAG, set.INGOT.get())
                    .unlockedBy(String.format("has_%s_nugget", set.name), has(set.NUGGET_TAG))
                    .save(consumer, shapelessIORecipeDir("nugget", set.name, "ingot"));

            // Block -> 9x Ingot
            uncompress(set.BLOCK_ITEM_TAG, set.INGOT.get())
                    .unlockedBy(String.format("has_%s_block", set.name), has(set.BLOCK_ITEM_TAG))
                    .save(consumer, shapelessIORecipeDir("block", set.name, "ingot"));
            // 9x Ingot -> Block
            compress(set.INGOT_TAG, set.BLOCK_ITEM.get())
                    .unlockedBy(String.format("has_%s_ingot", set.name), has(set.INGOT_TAG))
                    .save(consumer, shapelessIORecipeDir("ingot", set.name, "block"));

            // ##### Hammer #####

            // Hammer + Ingot -> Dust
            hammer(set.INGOT_TAG, 1, set.DUST.get()).save(consumer, hammerRecipeDir("ingot", set.name, "dust"));

            // ##### Crafting #####

            // Gear
            gear(set.INGOT_TAG, set.GEAR.get())
                    .unlockedBy(String.format("has_%s_ingot", set.name), has(set.INGOT_TAG))
                    .save(consumer, shapelessRecipeDir(set.name, "gear"));
            // Rod
            rod(set.INGOT_TAG, set.ROD.get())
                    .unlockedBy(String.format("has_%s_ingot", set.name), has(set.INGOT_TAG))
                    .save(consumer, shapelessRecipeDir(set.name, "rod"));
            // Plate
            plate(set.INGOT_TAG, set.PLATE.get())
                    .unlockedBy(String.format("has_%s_ingot", set.name), has(set.INGOT_TAG))
                    .save(consumer, shapelessRecipeDir(set.name, "plate"));

            // ##### Smelting #####

            // Dust -> Ingot
            blasting(set.DUST_TAG, set.INGOT.get())
                    .unlockedBy(String.format("has_%s_dust", set.name), has(set.DUST_TAG))
                    .save(consumer, blastingRecipeDir("dust", set.name));
            smelting(set.DUST_TAG, set.INGOT.get())
                    .unlockedBy(String.format("has_%s_dust", set.name), has(set.DUST_TAG))
                    .save(consumer, smeltingRecipeDir("dust", set.name));

            // ##### Crushing ####

            // Ingot -> Dust
            ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(set.INGOT_TAG), new ItemStack(set.DUST.get()))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dustRecipeDir("ingot", set.name));
        });

        ATOSetHelper.applyToIngot( set -> {

            // ##### Compressing #####

            // Raw Block -> 9x Raw
            uncompress(set.RAW_BLOCK_ITEM_TAG, set.RAW.get())
                    .unlockedBy(String.format("has_%s_raw_block", set.name), has(set.RAW_BLOCK_ITEM_TAG))
                    .save(consumer, shapelessIORecipeDir("raw", set.name, "raw_block"));
            // 9x Raw -> Raw Block
            compress(set.RAW_TAG, set.RAW_BLOCK_ITEM.get())
                    .unlockedBy(String.format("has_raw_%st", set.name), has(set.RAW_TAG))
                    .save(consumer, shapelessIORecipeDir("raw_block", set.name, "raw"));

            // ##### Hammer #####

            // Hammer + Ore -> 2x Dust
            hammer(set.ORES.ORE_BLOCK_ITEM_TAG, 2, set.DUST.get()).save(consumer, hammerRecipeDir("ore", set.name, "dust"));
            // Hammer + Raw -> 2x Dust
            hammer(set.RAW_TAG, 2, set.DUST.get()).save(consumer, hammerRecipeDir("raw", set.name, "dust"));

            // ##### Smelting #####

            // Raw -> Ingot
            blasting(set.RAW_TAG, set.INGOT.get())
                    .unlockedBy(String.format("has_raw_%s", set.name), has(set.RAW_TAG))
                    .save(consumer, blastingRecipeDir("raw", set.name));
            smelting(set.RAW_TAG, set.INGOT.get())
                    .unlockedBy(String.format("has_raw_%s", set.name), has(set.RAW_TAG))
                    .save(consumer, smeltingRecipeDir("raw", set.name));

            // Raw Block -> Block
            blasting(set.RAW_BLOCK_ITEM_TAG, set.BLOCK_ITEM.get())
                    .unlockedBy(String.format("has_raw_%s_block", set.name), has(set.RAW_BLOCK_ITEM_TAG))
                    .save(consumer, blastingRecipeDir("raw_block", set.name));
            smelting(set.RAW_BLOCK_ITEM_TAG, set.BLOCK_ITEM.get())
                    .unlockedBy(String.format("has_raw_%s_block", set.name), has(set.RAW_BLOCK_ITEM_TAG))
                    .save(consumer, smeltingRecipeDir("raw_block", set.name));

            // Ore -> Ingot
            blasting(set.ORES.ORE_BLOCK_ITEM_TAG, set.INGOT.get())
                    .unlockedBy(String.format("has_%s_ore", set.name), has(set.ORES.ORE_BLOCK_ITEM_TAG))
                    .save(consumer, blastingRecipeDir("ore", set.name));
            smelting(set.ORES.ORE_BLOCK_ITEM_TAG, set.INGOT.get())
                    .unlockedBy(String.format("has_%s_ore", set.name), has(set.ORES.ORE_BLOCK_ITEM_TAG))
                    .save(consumer, smeltingRecipeDir("ore", set.name));

            // ##### Dissolution #####

            // Ore -> Dirty Slurry
            ChemicalDissolutionRecipeBuilder.dissolution(IngredientCreatorAccess.item().from(set.ORES.ORE_BLOCK_ITEM_TAG, 1), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.SULFURIC_ACID, 1), new ChemicalStack(set.MEK.DIRTY_SLURRY, 1000), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dirtySlurryRecipeDir("ore", set.name));
            // Raw Block -> Dirty Slurry
            ChemicalDissolutionRecipeBuilder.dissolution(IngredientCreatorAccess.item().from(set.RAW_BLOCK_ITEM_TAG, 1), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.SULFURIC_ACID, 2), new ChemicalStack(set.MEK.DIRTY_SLURRY, 6000), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dirtySlurryRecipeDir("raw_block", set.name));
            // Raw -> Dirty Slurry
            ChemicalDissolutionRecipeBuilder.dissolution(IngredientCreatorAccess.item().from(set.RAW_TAG, 3), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.SULFURIC_ACID, 1), new ChemicalStack(set.MEK.DIRTY_SLURRY, 2000), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dirtySlurryRecipeDir("raw", set.name));

            // ##### Injecting #####

            // Ore -> Shard
            ItemStackChemicalToItemStackRecipeBuilder.injecting(IngredientCreatorAccess.item().from(set.ORES.ORE_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.HYDROGEN_CHLORIDE, 1), new ItemStack(set.MEK.SHARD.get(), 4), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, shardRecipeDir("ore", set.name));
            // Raw Block -> Shard
            ItemStackChemicalToItemStackRecipeBuilder.injecting(IngredientCreatorAccess.item().from(set.RAW_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.HYDROGEN_CHLORIDE, 2), new ItemStack(set.MEK.SHARD.get(), 24), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, shardRecipeDir("raw_block", set.name));
            // Raw -> Shard
            ItemStackChemicalToItemStackRecipeBuilder.injecting(IngredientCreatorAccess.item().from(set.RAW_TAG, 3), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.HYDROGEN_CHLORIDE, 1), new ItemStack(set.MEK.SHARD.get(), 8), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, shardRecipeDir("raw", set.name));

            // ##### Purifying #####

            // Ore -> Clump
            ItemStackChemicalToItemStackRecipeBuilder.purifying(IngredientCreatorAccess.item().from(set.ORES.ORE_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 1), new ItemStack(set.MEK.CLUMP.get(), 3), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, clumpRecipeDir("ore", set.name));
            // Raw Block -> Clump
            ItemStackChemicalToItemStackRecipeBuilder.purifying(IngredientCreatorAccess.item().from(set.RAW_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 2), new ItemStack(set.MEK.CLUMP.get(), 18), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, clumpRecipeDir("raw_block", set.name));
            // Raw -> Clump
            ItemStackChemicalToItemStackRecipeBuilder.purifying(IngredientCreatorAccess.item().from(set.RAW_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 1), new ItemStack(set.MEK.CLUMP.get(), 2), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, clumpRecipeDir("raw", set.name));

            // ##### Enriching #####

            // Dirty Dust -> Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.MEK.DIRTY_DUST_TAG), new ItemStack(set.DUST.get()))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dustRecipeDir("dirty_dust", set.name));

            // Ore -> 2x Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.ORES.ORE_BLOCK_ITEM_TAG), new ItemStack(set.DUST, 2))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dustRecipeDir("ore", set.name));

            // 3x Raw -> 4x Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.RAW_TAG, 3), new ItemStack(set.DUST, 4))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dustRecipeDir("raw", set.name));

            // Raw Block -> 12x Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.RAW_BLOCK_ITEM_TAG), new ItemStack(set.DUST, 12))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dustRecipeDir("raw_block", set.name));
        });

        ATOSetHelper.applyToGem( set -> {

            // ##### Compressing #####

            // Block -> 9x Gem
            uncompress(set.BLOCK_ITEM_TAG, set.GEM.get())
                    .unlockedBy(String.format("has_%s_block", set.name), has(set.BLOCK_ITEM_TAG))
                    .save(consumer, shapelessIORecipeDir("block", set.name, "gem"));
            // 9x Gem -> Block
            compress(set.GEM_TAG, set.BLOCK_ITEM.get())
                    .unlockedBy(String.format("has_%s", set.name), has(set.GEM_TAG))
                    .save(consumer, shapelessIORecipeDir("gem", set.name, "block"));

            // ##### Hammer #####

            // Hammer + Ore -> 2x Gem
            hammer(set.ORES.ORE_BLOCK_ITEM_TAG, 2, set.GEM.get()).save(consumer, hammerRecipeDir("ore", set.name, "gem"));
            // Hammer + Gem -> Dust
            hammer(set.GEM_TAG, 1, set.DUST.get()).save(consumer, hammerRecipeDir("gem", set.name, "dust"));

            // ##### Crushing #####

            // Gem -> Dust
            ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(set.GEM_TAG), new ItemStack(set.DUST.get(), 1))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dustRecipeDir("gem", set.name));

            // ##### Enriching #####

            // Ore -> 2x Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.ORES.ORE_BLOCK_ITEM_TAG), new ItemStack(set.DUST, 2))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dustRecipeDir("ore", set.name));

            // Dust -> Gem
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.DUST_TAG), new ItemStack(set.GEM))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, enrichingRecipeDir("dust", set.name));
        });

        ATOSetHelper.applyToDust( set -> {

            // ##### Compressing #####

            // Block -> 9x Dust
            uncompress(set.BLOCK_ITEM_TAG, set.DUST.get())
                    .unlockedBy(String.format("has_%s_block", set.name), has(set.BLOCK_ITEM_TAG))
                    .save(consumer, shapelessIORecipeDir("block", set.name, "dust"));
            // 9x Dust -> Block
            compress(set.DUST_TAG, set.BLOCK_ITEM.get())
                    .unlockedBy(String.format("has_%s", set.name), has(set.DUST_TAG))
                    .save(consumer, shapelessIORecipeDir("dust", set.name, "block"));

            // ##### Hammer #####

            // Hammer + Ore -> 2x Scrap
            hammer(set.ORES.ORE_BLOCK_ITEM_TAG, 2, set.DUST.get()).save(consumer, hammerRecipeDir("ore", set.name, "dust"));

            // ##### Smelting #####

            // Ore -> Dust
            blasting(set.ORES.ORE_BLOCK_ITEM_TAG, set.DUST.get())
                    .unlockedBy(String.format("has_%s_ore", set.name), has(set.ORES.ORE_BLOCK_ITEM_TAG))
                    .save(consumer, blastingRecipeDir("ore", set.name));
            smelting(set.ORES.ORE_BLOCK_ITEM_TAG, set.DUST.get())
                    .unlockedBy(String.format("has_%s_ore", set.name), has(set.ORES.ORE_BLOCK_ITEM_TAG))
                    .save(consumer, smeltingRecipeDir("ore", set.name));


            // ##### Enriching #####

            // Ore -> Dust
            ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(set.ORES.ORE_BLOCK_ITEM_TAG), new ItemStack(set.DUST, 6))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, enrichingRecipeDir("ore", set.name));
        });

        ATOSetHelper.applyToMekanism( set -> {

            // ##### Washing #####

            // Dirty Slurry -> Clean Slurry
            FluidChemicalToChemicalRecipeBuilder.washing(IngredientCreatorAccess.fluid().from(FluidTags.WATER, 5), IngredientCreatorAccess.chemicalStack().from((IChemicalProvider) set.DIRTY_SLURRY, 1), new ChemicalStack(set.CLEAN_SLURRY, 1))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, cleanSlurryRecipeDir(set.name));


            // ##### Crystallizing #####

            // Clean Slurry -> Crystal
            ChemicalCrystallizerRecipeBuilder.crystallizing(IngredientCreatorAccess.chemicalStack().from((IChemicalProvider) set.CLEAN_SLURRY, 200), new ItemStack(set.CRYSTAL.get()))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, crystalRecipeDir("slurry", set.name));

            // ##### Injecting #####

            // Crystal -> Shard
            ItemStackChemicalToItemStackRecipeBuilder.injecting(IngredientCreatorAccess.item().from(set.CRYSTAL_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.HYDROGEN_CHLORIDE, 1), new ItemStack(set.SHARD.get()), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, shardRecipeDir("crystal", set.name));

            // ##### Purifying #####

            // Shard -> Clump
            ItemStackChemicalToItemStackRecipeBuilder.purifying(IngredientCreatorAccess.item().from(set.SHARD_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 1), new ItemStack(set.CLUMP.get()), true)
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, clumpRecipeDir("shard", set.name));

            // ##### Crushing #####

            // Clumps -> Dirty Dust
            ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(set.CLUMP_TAG), new ItemStack(set.DIRTY_DUST.get()))
                    .addCondition(new ModLoadedCondition("mekanism"))
                    .build(consumer, dirtyDustRecipeDir("clump", set.name));
        });

        // ############# AllTheOres ###############

        // ##### Copper #####

        // 9x Nugget -> Ingot
        compress(ATOTagRegistry.COPPER_NUGGET, Items.COPPER_INGOT)
                .unlockedBy("has_copper_nugget", has(ATOTagRegistry.COPPER_NUGGET))
                .save(consumer, shapelessIORecipeDir("nugget", "copper", "ingot"));
        // Ingot -> 9x Nugget
        uncompress(Tags.Items.INGOTS_COPPER, ATORegistry.COPPER_NUGGET.get())
                .unlockedBy("has_copper_ingot", has(Tags.Items.INGOTS_COPPER))
                .save(consumer, shapelessIORecipeDir("ingot", "copper", "nugget"));

        // ##### Hammer #####

        // Copper Ore Hammer
        hammerBuilder(Tags.Items.STORAGE_BLOCKS_COPPER, ATORegistry.COPPER_ORE_HAMMER.get())
                .unlockedBy("has_copper_ingot", has(Tags.Items.INGOTS_COPPER))
                .save(consumer);
        // Iron Ore Hammer
        hammerBuilder(Tags.Items.STORAGE_BLOCKS_IRON, ATORegistry.IRON_ORE_HAMMER.get())
                .unlockedBy("has_iron", has(Tags.Items.INGOTS_IRON))
                .save(consumer);
        // Bronze Ore Hammer
        hammerBuilder(ATORegistry.BRONZE.BLOCK_ITEM_TAG, ATORegistry.BRONZE_ORE_HAMMER.get())
                .unlockedBy("has_bronze_ingot", has(ATORegistry.INVAR.INGOT_TAG))
                .save(consumer);
        // Invar Ore Hammer
        hammerBuilder(ATORegistry.INVAR.BLOCK_ITEM_TAG, ATORegistry.INVAR_ORE_HAMMER.get())
                .unlockedBy("has_invar_ingot", has(ATORegistry.INVAR.INGOT_TAG))
                .save(consumer);
        // Platinum Ore Hammer
        hammerBuilder(ATORegistry.PLATINUM.BLOCK_ITEM_TAG, ATORegistry.PLATINUM_ORE_HAMMER.get())
                .unlockedBy("has_platinum_ingot", has(ATORegistry.INVAR.INGOT_TAG))
                .save(consumer);

        // ##### Alloy Blending #####

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ATORegistry.INVAR.DUST.get(), 3)
                .requires(ATORegistry.IRON.DUST.get(), 2)
                .requires(ATORegistry.NICKEL.DUST_TAG)
                .unlockedBy("has_hammer", has(ATOTagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessIORecipeDir("dust", "invar", "alloy_blending"));


        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ATORegistry.STEEL.DUST.get(), 1)
                .requires(ATORegistry.IRON.DUST.get(), 1)
                .requires(Items.COAL, 4)
                .requires(ATOTagRegistry.ORE_HAMMERS)
                .unlockedBy("has_hammer", has(ATOTagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessIORecipeDir("dust", "steel", "alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ATORegistry.ELECTRUM.DUST.get(), 2)
                .requires(ATORegistry.GOLD.DUST.get())
                .requires(ATORegistry.SILVER.DUST_TAG)
                .unlockedBy("has_hammer", has(ATOTagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessIORecipeDir("dust", "electrum", "alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ATORegistry.BRONZE.DUST.get(), 4)
                .requires(ATORegistry.COPPER.DUST.get(), 3)
                .requires(ATORegistry.TIN.DUST_TAG)
                .unlockedBy("has_hammer", has(ATOTagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessIORecipeDir("dust", "bronze", "alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ATORegistry.BRASS.DUST.get(), 4)
                .requires(ATORegistry.COPPER.DUST.get(), 3)
                .requires(ATORegistry.ZINC.DUST_TAG)
                .unlockedBy("has_hammer", has(ATOTagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessIORecipeDir("dust", "brass", "alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ATORegistry.LUMIUM.DUST.get(), 4)
                .requires(Items.GLOWSTONE_DUST, 4)
                .requires(ATORegistry.SILVER.DUST_TAG)
                .requires(ATORegistry.TIN.DUST.get(), 3)
                .unlockedBy("has_hammer", has(ATOTagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessIORecipeDir("dust", "lumium", "alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ATORegistry.CONSTANTAN.DUST.get(), 2)
                .requires(ATORegistry.COPPER.DUST.get())
                .requires(ATORegistry.NICKEL.DUST_TAG)
                .unlockedBy("has_hammer", has(ATOTagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessIORecipeDir("dust", "constantan", "alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ATORegistry.SIGNALUM.DUST.get(), 4)
                .requires(ATORegistry.COPPER.DUST.get(), 3)
                .requires(ATORegistry.SILVER.DUST_TAG)
                .requires(Items.REDSTONE, 4)
                .unlockedBy("has_hammer", has(ATOTagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessIORecipeDir("dust", "signalum", "alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ATORegistry.ENDERIUM.DUST.get(), 4)
                .requires(ATORegistry.LEAD.DUST.get(), 3)
                .requires(ATORegistry.PLATINUM.DUST_TAG)
                .requires(Items.ENDER_PEARL, 2)
                .requires(ATOTagRegistry.ORE_HAMMERS)
                .unlockedBy("has_hammer", has(ATOTagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessIORecipeDir("dust", "enderium", "alloy_blending"));

        // ############# Mekanism ###############

        ItemStackToChemicalRecipeBuilder
                .chemicalConversion(IngredientCreatorAccess.item().from(ATORegistry.SULFUR.BLOCK_ITEM.get()), new ChemicalStack(MekanismChemicals.SULFURIC_ACID, 18))
                .addCondition(new ModLoadedCondition("mekanism"))
                .build(consumer, chemicalConversionRecipeDir("sulfur_block", "sulfuric_acid"));
    }
}
