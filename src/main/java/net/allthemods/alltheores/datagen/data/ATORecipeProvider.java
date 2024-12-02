package net.allthemods.alltheores.datagen.data;

import mekanism.api.chemical.ChemicalStack;
import mekanism.api.datagen.recipe.builder.*;
import mekanism.api.providers.IChemicalProvider;
import mekanism.api.recipes.ingredients.creator.IngredientCreatorAccess;
import mekanism.common.registries.MekanismChemicals;
import net.allthemods.alltheores.registry.ATORegistry;
import net.allthemods.alltheores.registry.GroupHelper;
import net.allthemods.alltheores.registry.TagRegistry;
import net.allthemods.alltheores.infos.Reference;
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
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class ATORecipeProvider extends RecipeProvider {

    public ATORecipeProvider(PackOutput packOutput, CompletableFuture<Provider> provider) {
        super(packOutput, provider);
    }

    // AllTheOres
    private ResourceLocation smeltingRecipeDir(String type, String name) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, name + "/smelting/" + type + "_smelting");
    }
    private ResourceLocation blastingRecipeDir(String type, String name) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, name + "/smelting/" + type + "_blasting");
    }

    private ResourceLocation shapelessIORecipeDir(String typeIn, String name, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, name + "/crafting/" + typeOut + "_from_" + typeIn);
    }

    private ResourceLocation shapelessRecipeDir(String name, String type) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, name + "/crafting/" + type);
    }

    private ResourceLocation hammerRecipeDir(String typeIn, String name, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, name + "/crafting/hammer/" + typeOut + "_from_" + typeIn);
    }

    // Mekanism
    private ResourceLocation dissolutionRecipeDir(String typeIn, String name, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, name + "/dissolution/" + typeOut + "_from_" + typeIn);
    }

    private ResourceLocation washingRecipeDir(String typeIn, String name, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, name + "/washing/" + typeOut + "_from_" + typeIn);
    }

    private ResourceLocation crystallizingRecipeDir(String typeIn, String name, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, name + "/crystallizing/" + typeOut + "_from_" + typeIn);
    }

    private ResourceLocation injectingRecipeDir(String typeIn, String name, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, name + "/injecting/" + typeOut + "_from_" + typeIn);
    }

    private ResourceLocation purifyingRecipeDir(String typeIn, String name, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, name + "/purifying/" + typeOut + "_from_" + typeIn);
    }

    private ResourceLocation crushingRecipeDir(String typeIn, String name, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, name + "/crushing/" + typeOut + "_from_" + typeIn);
    }

    private ResourceLocation enrichingRecipeDir(String typeIn, String name, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, name + "/enriching/" + typeOut + "_from_" + typeIn);
    }

    private ResourceLocation combiningRecipeDir(String typeIn, String name, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, name + "/combining/" + typeOut + "_from_" + typeIn);
    }


    private ShapedRecipeBuilder compress(Item output, TagKey<Item> tag) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output)
                .pattern("aaa")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', tag);
    }
    private ShapelessRecipeBuilder uncompress(Item output, TagKey<Item> tag) {
        return ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, output, 9)
                .requires(tag);
    }

    private ShapedRecipeBuilder gear(Item output, TagKey<Item> tag) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output)
                .pattern("aaa")
                .pattern("ana")
                .pattern("aaa")
                .define('a', tag)
                .define('n', Tags.Items.NUGGETS_IRON);
    }
    private ShapedRecipeBuilder rod(Item output, TagKey<Item> tag) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output)
                .pattern("   ")
                .pattern("  a")
                .pattern("ha ")
                .define('a', tag)
                .define('h', TagRegistry.ORE_HAMMERS);
    }
    private ShapedRecipeBuilder plate(Item output, TagKey<Item> tag) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output)
                .pattern("   ")
                .pattern("ha ")
                .pattern("a  ")
                .define('a', tag)
                .define('h', TagRegistry.ORE_HAMMERS);
    }
    private ShapelessRecipeBuilder hammer(Item output, int amount, TagKey<Item> tag) {
        return ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, amount)
                .requires(TagRegistry.ORE_HAMMERS)
                .requires(tag)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS));
    }

    private SimpleCookingRecipeBuilder blasting(Item output, TagKey<Item> tag) {
        return SimpleCookingRecipeBuilder.blasting(Ingredient.of(tag), RecipeCategory.MISC, output, 0.7f, 100);
    }
    private SimpleCookingRecipeBuilder smelting(Item output, TagKey<Item> tag) {
        return SimpleCookingRecipeBuilder.smelting(Ingredient.of(tag), RecipeCategory.MISC, output, 0.7f, 200);
    }


    @Override
    protected void buildRecipes(RecipeOutput consumer) {

        GroupHelper.applyToOre(group -> {

            // ##### AllTheOres #####

            // Raw Block -> 9x Raw
            uncompress(group.DROP.get(), group.DROP_BLOCK_ITEM_TAG)
                    .unlockedBy(String.format("has_raw_%s", group.name), has(group.DROP_BLOCK_ITEM_TAG))
                    .save(consumer, shapelessIORecipeDir("raw_block", group.name, "raw"));
            // 9x Raw -> Raw Block
            compress(group.DROP_BLOCK_ITEM.get(), group.DROP_TAG)
                    .unlockedBy(String.format("has_raw_%s", group.name), has(group.DROP_TAG))
                    .save(consumer, shapelessIORecipeDir("raw", group.name, "raw_block"));

            // Hammer + Ore Block -> Raw
            hammer(group.DUST.get(), 2, group.ORE_BLOCK_ITEM_TAG)
                    .save(consumer, hammerRecipeDir("ore", group.name, "raw"));
            if (!group.type.equals("dust")) {
                // Hammer + Material -> Dust
                hammer(group.DUST.get(), 1, group.MATERIAL_TAG)
                        .save(consumer, hammerRecipeDir("material", group.name, "dust"));
            }
            if (group.type.equals("ingot")) {
                // Hammer + Raw -> Dust
                hammer(group.DUST.get(), 2, group.DROP_TAG)
                        .save(consumer, hammerRecipeDir("raw", group.name, "dust"));
            }

            // Ore -> Material
            smelting(group.MATERIAL.get(), group.ORE_BLOCK_ITEM_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.ORE_BLOCK_ITEM_TAG))
                    .save(consumer, smeltingRecipeDir("ore", group.name));
            blasting(group.MATERIAL.get(), group.ORE_BLOCK_ITEM_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.ORE_BLOCK_ITEM_TAG))
                    .save(consumer, blastingRecipeDir("ore", group.name));
            if (!group.type.equals("dust")) {
                // Dust -> Material
                smelting(group.MATERIAL.get(), group.DUST_TAG)
                        .unlockedBy(String.format("has_%s_dust", group.name), has(group.DUST_TAG))
                        .save(consumer, smeltingRecipeDir("dust", group.name));
                blasting(group.MATERIAL.get(), group.DUST_TAG)
                        .unlockedBy(String.format("has_%s_dust", group.name), has(group.DUST_TAG))
                        .save(consumer, blastingRecipeDir("dust", group.name));
            }
            if (group.type.equals("ingot")) {
                // Raw -> Material
                smelting(group.MATERIAL.get(), group.DROP_TAG)
                        .unlockedBy(String.format("has_raw_%s", group.name), has(group.DROP_TAG))
                        .save(consumer, smeltingRecipeDir("raw", group.name));
                blasting(group.MATERIAL.get(), group.DROP_TAG)
                        .unlockedBy(String.format("has_raw_%s", group.name), has(group.DROP_TAG))
                        .save(consumer, blastingRecipeDir("raw", group.name));
            }

            // ##### Mekanism #####

           if(ModList.get().isLoaded("mekanism")) {
               // Raw -> Stone Ore
               CombinerRecipeBuilder.combining(IngredientCreatorAccess.item().from(group.DROP_TAG, 8), IngredientCreatorAccess.item().from(Tags.Items.COBBLESTONES_NORMAL), new ItemStack(group.STONE_ORE_BLOCK_ITEM))
                       .build(consumer, combiningRecipeDir("raw", group.name, "stone_ore"));
               // Raw -> Deepslate Ore
               CombinerRecipeBuilder.combining(IngredientCreatorAccess.item().from(group.DROP_TAG, 8), IngredientCreatorAccess.item().from(Tags.Items.COBBLESTONES_DEEPSLATE), new ItemStack(group.SLATE_ORE_BLOCK_ITEM))
                       .build(consumer, combiningRecipeDir("raw", group.name, "deepslate_ore"));
               // Raw -> Nether Ore
               CombinerRecipeBuilder.combining(IngredientCreatorAccess.item().from(group.DROP_TAG, 8), IngredientCreatorAccess.item().from(Tags.Items.NETHERRACKS), new ItemStack(group.NETHER_ORE_BLOCK_ITEM))
                       .build(consumer, combiningRecipeDir("raw", group.name, "nether_ore"));
               // Raw -> End Ore
               CombinerRecipeBuilder.combining(IngredientCreatorAccess.item().from(group.DROP_TAG, 8), IngredientCreatorAccess.item().from(Tags.Items.END_STONES), new ItemStack(group.END_ORE_BLOCK_ITEM))
                       .build(consumer, combiningRecipeDir("raw", group.name, "end_ore"));
               // Raw -> Other Ore
               CombinerRecipeBuilder.combining(IngredientCreatorAccess.item().from(group.DROP_TAG, 8), IngredientCreatorAccess.item().from(com.thevortex.allthemodium.registry.TagRegistry.ANCIENT_STONE_ITEM), new ItemStack(group.OTHER_ORE_BLOCK_ITEM.get()))
                       .build(consumer, combiningRecipeDir("raw", group.name, "other_ore"));

               // Ingot -> Dust
               ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(group.MATERIAL_TAG), new ItemStack(group.DUST.get()))
                       .build(consumer, crushingRecipeDir("material", group.name, "dust"));
               // Ore -> Dust
               ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(group.ORE_BLOCK_ITEM_TAG), new ItemStack(group.DUST.get(), 2))
                       .build(consumer, crushingRecipeDir("ore", group.name, "dust"));
               // Raw Block -> Dust
               ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(group.DROP_BLOCK_ITEM_TAG), new ItemStack(group.DUST.get(), 12))
                       .build(consumer, crushingRecipeDir("raw_block", group.name, "dust"));
               // Raw -> Dust
               ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(group.DROP_TAG, 3), new ItemStack(group.DUST.get(), 4))
                       .build(consumer, crushingRecipeDir("raw", group.name, "dust"));
           }

        });

        GroupHelper.applyToAlloy(group -> {
            // Ingot -> 9x Nugget
            uncompress(group.NUGGET.get(), group.INGOT_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.INGOT_TAG))
                    .save(consumer, shapelessIORecipeDir("ingot", group.name, "nugget"));
            // 9x Nugget -> Ingot
            compress(group.INGOT.get(), group.NUGGET_TAG)
                    .unlockedBy(String.format("has_%s_nugget", group.name), has(group.NUGGET_TAG))
                    .save(consumer, shapelessIORecipeDir("nugget", group.name, "ingot"));

            // Block -> 9x Ingot
            uncompress(group.INGOT.get(), group.BLOCK_ITEM_TAG)
                    .unlockedBy(String.format("has_%s_block", group.name), has(group.BLOCK_ITEM_TAG))
                    .save(consumer, shapelessIORecipeDir("block", group.name, "ingot"));
            // 9x Ingot -> Block
            compress(group.BLOCK_ITEM.get(), group.INGOT_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.INGOT_TAG))
                    .save(consumer, shapelessIORecipeDir("ingot", group.name, "block"));

            // Gear
            gear(group.GEAR.get(), group.INGOT_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.INGOT_TAG))
                    .save(consumer, shapelessRecipeDir(group.name, "gear"));
            // Rod
            rod(group.ROD.get(), group.INGOT_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.INGOT_TAG))
                    .save(consumer, shapelessRecipeDir(group.name, "rod"));
            // Plate
            plate(group.PLATE.get(), group.INGOT_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.INGOT_TAG))
                    .save(consumer, shapelessRecipeDir(group.name, "plate"));
        });

        GroupHelper.applyToMaterial( group -> {
            if (ModList.get().isLoaded("mekanism")) {
                // Ore -> Dirty Slurry
                ChemicalDissolutionRecipeBuilder.dissolution(IngredientCreatorAccess.item().from(group.ORES.ORE_BLOCK_ITEM_TAG, 1), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.SULFURIC_ACID, 1), new ChemicalStack(group.DIRTY_SLURRY, 1000), true)
                        .build(consumer, dissolutionRecipeDir("ore", group.name, "material"));
                // Raw Block -> Dirty Slurry
                ChemicalDissolutionRecipeBuilder.dissolution(IngredientCreatorAccess.item().from(group.ORES.DROP_BLOCK_ITEM_TAG, 1), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.SULFURIC_ACID, 2), new ChemicalStack(group.DIRTY_SLURRY, 6000), true)
                        .build(consumer, dissolutionRecipeDir("raw_block", group.name, "material"));
                // Raw -> Dirty Slurry
                ChemicalDissolutionRecipeBuilder.dissolution(IngredientCreatorAccess.item().from(group.ORES.DROP_TAG, 3), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.SULFURIC_ACID, 1), new ChemicalStack(group.DIRTY_SLURRY, 2000), true)
                        .build(consumer, dissolutionRecipeDir("raw", group.name, "material"));

                // Dirty Dust -> Clean Slurry
                FluidChemicalToChemicalRecipeBuilder.washing(IngredientCreatorAccess.fluid().from(FluidTags.WATER, 5), IngredientCreatorAccess.chemicalStack().from((IChemicalProvider) group.DIRTY_SLURRY, 1), new ChemicalStack(group.CLEAN_SLURRY, 1))
                        .build(consumer, washingRecipeDir("dirty_dust", group.name, "clean_slurry"));

                // Clean Slurry -> Crystal
                ChemicalCrystallizerRecipeBuilder.crystallizing(IngredientCreatorAccess.chemicalStack().from((IChemicalProvider) group.CLEAN_SLURRY, 200), new ItemStack(group.CRYSTAL.get()))
                        .build(consumer, crystallizingRecipeDir("clean_slurry", group.name, "crystal"));

                // Ore -> Shard
                ItemStackChemicalToItemStackRecipeBuilder.injecting(IngredientCreatorAccess.item().from(group.ORES.ORE_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 1), new ItemStack(group.SHARD.get(), 4), true)
                        .build(consumer, injectingRecipeDir("ore", group.name, "shard"));
                // Raw Block -> Shard
                ItemStackChemicalToItemStackRecipeBuilder.injecting(IngredientCreatorAccess.item().from(group.ORES.DROP_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 2), new ItemStack(group.SHARD.get(), 24), true)
                        .build(consumer, injectingRecipeDir("raw_block", group.name, "shard"));
                // Raw -> Shard
                ItemStackChemicalToItemStackRecipeBuilder.injecting(IngredientCreatorAccess.item().from(group.ORES.DROP_TAG, 3), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 1), new ItemStack(group.SHARD.get(), 8), true)
                        .build(consumer, injectingRecipeDir("raw", group.name, "shard"));
                // Crystal -> Shard
                ItemStackChemicalToItemStackRecipeBuilder.injecting(IngredientCreatorAccess.item().from(group.CRYSTAL_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 1), new ItemStack(group.SHARD.get()), true)
                        .build(consumer, injectingRecipeDir("crystal", group.name, "shard"));

                // Ore -> Clump
                ItemStackChemicalToItemStackRecipeBuilder.purifying(IngredientCreatorAccess.item().from(group.ORES.ORE_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 1), new ItemStack(group.CLUMP.get(), 3), true)
                        .build(consumer, purifyingRecipeDir("ore", group.name, "clump"));
                // Raw Block -> Clump
                ItemStackChemicalToItemStackRecipeBuilder.purifying(IngredientCreatorAccess.item().from(group.ORES.DROP_BLOCK_ITEM_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 2), new ItemStack(group.CLUMP.get(), 18), true)
                        .build(consumer, purifyingRecipeDir("raw_block", group.name, "clump"));
                // Raw -> Clump
                ItemStackChemicalToItemStackRecipeBuilder.purifying(IngredientCreatorAccess.item().from(group.ORES.DROP_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 1), new ItemStack(group.CLUMP.get(), 2), true)
                        .build(consumer, purifyingRecipeDir("raw", group.name, "clump"));
                // Shard -> Clump
                ItemStackChemicalToItemStackRecipeBuilder.purifying(IngredientCreatorAccess.item().from(group.SHARD_TAG), IngredientCreatorAccess.chemicalStack().from(MekanismChemicals.OXYGEN, 1), new ItemStack(group.CLUMP.get()), true)
                        .build(consumer, purifyingRecipeDir("shard", group.name, "clump"));

                // Clumps -> Dirty Dust
                ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(group.CLUMP_TAG), new ItemStack(group.DIRTY_DUST.get()))
                        .build(consumer, crushingRecipeDir("clump", group.name, "dirty_dust"));
                // Dirty Dust -> Dust
                ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(group.DIRTY_DUST_TAG), new ItemStack(group.DUST.get()))
                        .build(consumer, enrichingRecipeDir("dirty_dust", group.name, "dust"));
            }
        });

        GroupHelper.applyToVanilla( group -> {

            // Dust -> Ingot
            if (group.type.equals("ingot")) {
                blasting(group.MATERIAL, group.DUST_TAG)
                        .unlockedBy(String.format("has_%s_dust", group.name), has(group.DUST_TAG))
                        .save(consumer, blastingRecipeDir("dust", group.name));
                smelting(group.MATERIAL, group.DUST_TAG)
                        .unlockedBy(String.format("has_%s_dust", group.name), has(group.DUST_TAG))
                        .save(consumer, smeltingRecipeDir("dust", group.name));
            }

            // Gear
            gear(group.GEAR.get(), group.MATERIAL_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.MATERIAL_TAG))
                    .save(consumer, shapelessRecipeDir(group.name, "gear"));
            // Rod
            rod(group.ROD.get(), group.MATERIAL_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.MATERIAL_TAG))
                    .save(consumer, shapelessRecipeDir(group.name, "rod"));
            // Plate
            plate(group.PLATE.get(), group.MATERIAL_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.MATERIAL_TAG))
                    .save(consumer, shapelessRecipeDir(group.name, "plate"));
        });

        // ALLOY BLENDING

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ATORegistry.INVAR.DUST.get(),3)
                .requires(ATORegistry.IRON.DUST.get(),2)
                .requires(ATORegistry.NICKEL.DUST_TAG)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessIORecipeDir("dust", "invar","alloy_blending"));


        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ATORegistry.STEEL.DUST.get(),1)
                .requires(ATORegistry.IRON.DUST.get(),1)
                .requires(Items.COAL,4)
                .requires(TagRegistry.ORE_HAMMERS)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessIORecipeDir("dust", "steel","alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ATORegistry.ELECTRUM.DUST.get(),2)
                .requires(ATORegistry.GOLD.DUST.get())
                .requires(ATORegistry.SILVER.DUST_TAG)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessIORecipeDir("dust", "electrum", "alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ATORegistry.BRONZE.DUST.get(),4)
                .requires(ATORegistry.COPPER.DUST.get(),3)
                .requires(ATORegistry.TIN.DUST_TAG)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessIORecipeDir("dust", "bronze", "alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ATORegistry.BRASS.DUST.get(),4)
                .requires(ATORegistry.COPPER.DUST.get(),3)
                .requires(ATORegistry.ZINC.DUST_TAG)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessIORecipeDir("dust", "brass", "alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ATORegistry.LUMIUM.DUST.get(),4)
                .requires(Items.GLOWSTONE_DUST,4)
                .requires(ATORegistry.SILVER.DUST_TAG)
                .requires(ATORegistry.TIN.DUST.get(),3)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessIORecipeDir("dust", "lumium", "alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ATORegistry.CONSTANTAN.DUST.get(),2)
                .requires(ATORegistry.COPPER.DUST.get())
                .requires(ATORegistry.NICKEL.DUST_TAG)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessIORecipeDir("dust", "constantan", "alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ATORegistry.SIGNALUM.DUST.get(),4)
                .requires(ATORegistry.COPPER.DUST.get(),3)
                .requires(ATORegistry.SILVER.DUST_TAG)
                .requires(Items.REDSTONE,4)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessIORecipeDir("dust", "signalum", "alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, ATORegistry.ENDERIUM.DUST.get(),4)
                .requires(ATORegistry.LEAD.DUST.get(),3)
                .requires(ATORegistry.PLATINUM.DUST_TAG)
                .requires(Items.ENDER_PEARL,2)
                .requires(TagRegistry.ORE_HAMMERS)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessIORecipeDir("dust", "enderium", "alloy_blending"));
    }
}
