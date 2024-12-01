package net.allthemods.alltheores.datagen.data.recipe;

import net.allthemods.alltheores.blocks.BlockList;
import net.allthemods.alltheores.registry.GroupHelper;
import net.allthemods.alltheores.registry.TagRegistry;
import net.allthemods.alltheores.infos.Reference;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class VanillaRecipeProvider extends RecipeProvider {

    public VanillaRecipeProvider(PackOutput packOutput, CompletableFuture<Provider> provider) {
        super(packOutput, provider);
    }

    private ShapedRecipeBuilder shaped(ItemLike provider) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, provider)
                .group(Reference.MOD_ID);
    }

    private ResourceLocation blastingRecipeDir(String typeIn, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, typeIn + "_from_" + typeOut + "_blasting");
    }

    private ResourceLocation shapelessRecipeDir(String typeIn, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, typeIn + "_from_" + typeOut);
    }

    private ResourceLocation smeltingRecipeDir(String typeIn, String typeOut) {
        return ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, typeIn + "_from_" + typeOut + "smelting");
    }


    private ShapedRecipeBuilder block(Item provider, TagKey<Item> tag) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, provider)
                .pattern("aaa")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', tag);
    }

    private ShapedRecipeBuilder gear(Item provider, TagKey<Item> tag) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, provider)
                .pattern("aaa")
                .pattern("ana")
                .pattern("aaa")
                .define('a', tag)
                .define('n', Tags.Items.NUGGETS_IRON);
    }
    private ShapedRecipeBuilder rod(Item provider, TagKey<Item> tag) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, provider)
                .pattern("   ")
                .pattern("  a")
                .pattern("ha ")
                .define('a', tag)
                .define('h', TagRegistry.ORE_HAMMERS);
    }
    private ShapedRecipeBuilder plate(Item provider, TagKey<Item> tag) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, provider)
                .pattern("   ")
                .pattern("ha ")
                .pattern("a  ")
                .define('a', tag)
                .define('h', TagRegistry.ORE_HAMMERS);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {

        GroupHelper.applyToOre(group -> {
            // Raw Block -> 9x Raw
            ShapelessRecipeBuilder
                    .shapeless(RecipeCategory.MISC, group.DROP.get(), 9)
                    .requires(group.DROP_BLOCK_ITEM_TAG)
                    .unlockedBy(String.format("has_raw_%s", group.name), has(group.DROP_TAG))
                    .save(consumer, shapelessRecipeDir(String.format("raw_%s", group.name), "raw"));

            // 9x Raw -> Raw Block
            block(group.DROP_BLOCK_ITEM.get(), group.DROP_TAG)
                    .unlockedBy(String.format("has_raw_%s", group.name), has(group.DROP_TAG))
                    .save(consumer);

            // Hammer + Ore -> Drop
            ShapelessRecipeBuilder
                    .shapeless(RecipeCategory.MISC, group.DROP.get(), 2)
                    .requires(TagRegistry.ORE_HAMMERS)
                    .requires(group.ORE_BLOCK_ITEM_TAG)
                    .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                    .save(consumer, shapelessRecipeDir(String.format("%s_ore", group.name), "hammer_crushing"));


        });

        GroupHelper.applyToAlloy(group -> {

            // Ingot -> 9x Nugget
            ShapelessRecipeBuilder
                    .shapeless(RecipeCategory.MISC, group.NUGGET.get(), 9)
                    .requires(group.INGOT_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.INGOT_TAG))
                    .save(consumer, shapelessRecipeDir(String.format("%s_ingot", group.name), "nugget"));

            // 9x Nugget -> Ingot
            block(group.INGOT.get(), group.NUGGET_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.INGOT_TAG))
                    .save(consumer);


            // Block -> 9x Ingot
            ShapelessRecipeBuilder
                    .shapeless(RecipeCategory.MISC, group.INGOT.get(), 9)
                    .requires(group.BLOCK_ITEM_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.INGOT_TAG))
                    .save(consumer, shapelessRecipeDir(String.format("%s_block", group.name), "ingot"));

            // 9x Ingot -> Block
            block(group.BLOCK_ITEM.get(), group.INGOT_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.INGOT_TAG))
                    .save(consumer);


            // Dust -> Ingot
            SimpleCookingRecipeBuilder
                    .blasting(Ingredient.of(group.DUST_TAG), RecipeCategory.MISC, group.INGOT.get(), 0.15f, 100)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.DUST_TAG))
                    .save(consumer, smeltingRecipeDir(String.format("%s_dust", group.name), "ingot"));

            // Gear
            gear(group.GEAR.get(), group.INGOT_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.INGOT_TAG))
                    .save(consumer);

            // Rod
            rod(group.ROD.get(), group.INGOT_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.INGOT_TAG))
                    .save(consumer);

            // Plate
            plate(group.PLATE.get(), group.INGOT_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.INGOT_TAG))
                    .save(consumer);

        });

        GroupHelper.applyToVanilla( group -> {

            // Dust -> Ingot
            SimpleCookingRecipeBuilder
                    .blasting(Ingredient.of(group.DUST_TAG), RecipeCategory.MISC, group.MATERIAL, 0.15f, 100)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.DUST_TAG))
                    .save(consumer, smeltingRecipeDir(String.format("%s_dust", group.name), "ingot"));

            // Gear
            gear(group.GEAR.get(), group.MATERIAL_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.MATERIAL_TAG))
                    .save(consumer);

            // Rod
            rod(group.ROD.get(), group.MATERIAL_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.MATERIAL_TAG))
                    .save(consumer);

            // Plate
            plate(group.PLATE.get(), group.MATERIAL_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.MATERIAL_TAG))
                    .save(consumer);
        });

        GroupHelper.applyToMaterial(group -> {
            // Ore -> Ingot
            SimpleCookingRecipeBuilder
                    .blasting(Ingredient.of(group.ORES.ORE_BLOCK_ITEM_TAG), RecipeCategory.MISC, group.INGOT.get(), 0.15f, 200)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.ORES.ORE_BLOCK_ITEM_TAG))
                    .save(consumer, smeltingRecipeDir(String.format("%s_ore", group.name), "ingot"));

            // Raw -> Ingot
            SimpleCookingRecipeBuilder
                    .blasting(Ingredient.of(group.ORES.DROP_TAG), RecipeCategory.MISC, group.INGOT.get(), 0.15f, 200)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.ORES.ORE_BLOCK_ITEM_TAG))
                    .save(consumer, blastingRecipeDir(String.format("raw_%s", group.name), "ingot"));

            // Hammer + Ore -> Dust
            ShapelessRecipeBuilder
                    .shapeless(RecipeCategory.MISC, group.DUST.get(), 2)
                    .requires(TagRegistry.ORE_HAMMERS)
                    .requires(group.ORES.DROP_TAG)
                    .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                    .save(consumer, shapelessRecipeDir(String.format("raw_%s", group.name), "hammer_crushing"));
        });


        GroupHelper.applyToGem( group -> {

            // Hammer + Ore -> Dust
            ShapelessRecipeBuilder
                    .shapeless(RecipeCategory.MISC, group.DUST.get(), 1)
                    .requires(TagRegistry.ORE_HAMMERS)
                    .requires(group.ORES.DROP_TAG)
                    .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                    .save(consumer, shapelessRecipeDir(group.name, "hammer_crushing"));
        });

        // ALLOY BLENDING

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, BlockList.INVAR.DUST.get(),3)
                .requires(BlockList.IRON.DUST.get(),2)
                .requires(BlockList.NICKEL.DUST_TAG)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessRecipeDir("invar_dust","alloy_blending"));


        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,BlockList.STEEL.DUST.get(),1)
                .requires(BlockList.IRON.DUST.get(),1)
                .requires(Items.COAL,4)
                .requires(TagRegistry.ORE_HAMMERS)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessRecipeDir("steel_dust","alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,BlockList.ELECTRUM.DUST.get(),2)
                .requires(BlockList.GOLD.DUST.get())
                .requires(BlockList.SILVER.DUST_TAG)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessRecipeDir("electrum_dust","alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,BlockList.BRONZE.DUST.get(),4)
                .requires(BlockList.COPPER.DUST.get(),3)
                .requires(BlockList.TIN.DUST_TAG)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessRecipeDir("bronze_dust","alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,BlockList.BRASS.DUST.get(),4)
                .requires(BlockList.COPPER.DUST.get(),3)
                .requires(BlockList.ZINC.DUST_TAG)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessRecipeDir("brass_dust","alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,BlockList.LUMIUM.DUST.get(),4)
                .requires(Items.GLOWSTONE_DUST,4)
                .requires(BlockList.SILVER.DUST_TAG)
                .requires(BlockList.TIN.DUST.get(),3)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessRecipeDir("lumium_dust","alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,BlockList.CONSTANTAN.DUST.get(),2)
                .requires(BlockList.COPPER.DUST.get())
                .requires(BlockList.NICKEL.DUST_TAG)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessRecipeDir("constantan_dust","alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,BlockList.SIGNALUM.DUST.get(),4)
                .requires(BlockList.COPPER.DUST.get(),3)
                .requires(BlockList.SILVER.DUST_TAG)
                .requires(Items.REDSTONE,4)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessRecipeDir("signalum_dust","alloy_blending"));

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC,BlockList.ENDERIUM.DUST.get(),4)
                .requires(BlockList.LEAD.DUST.get(),3)
                .requires(BlockList.PLATINUM.DUST_TAG)
                .requires(Items.ENDER_PEARL,2)
                .requires(TagRegistry.ORE_HAMMERS)
                .unlockedBy("has_hammer", has(TagRegistry.ORE_HAMMERS))
                .save(consumer, shapelessRecipeDir("enderium_dust","alloy_blending"));
    }
}
