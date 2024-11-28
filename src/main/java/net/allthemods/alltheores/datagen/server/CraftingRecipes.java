package net.allthemods.alltheores.datagen.server;

import net.allthemods.alltheores.blocks.BlockList;
import net.allthemods.alltheores.blocks.ore.OreBlock;
import net.allthemods.alltheores.infos.ItemTagRegistry;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.registry.OreRegistryGroup;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class CraftingRecipes extends RecipeProvider {

    final String hasCondition = "has_item";

    public CraftingRecipes(PackOutput packOutput, CompletableFuture<Provider> provider) {
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
                .define('h', ItemTagRegistry.ORE_HAMMERS);
    }
    private ShapedRecipeBuilder plate(Item provider, TagKey<Item> tag) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, provider)
                .pattern("   ")
                .pattern("ha ")
                .pattern("a  ")
                .define('a', tag)
                .define('h', ItemTagRegistry.ORE_HAMMERS);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {

        GroupHelper.applyToAlloy(group -> {

            // Ingot -> 9x Nugget
            ShapelessRecipeBuilder
                    .shapeless(RecipeCategory.MISC, group.NUGGET.get(), 9)
                    .requires(group.INGOT_TAG)
                    .unlockedBy(hasCondition, RecipeProvider.has(group.INGOT_TAG))
                    .save(consumer, shapelessRecipeDir(String.format("%s_ingot", group.name), "block"));

            // 9x Nugget -> Ingot
            block(group.INGOT.get(), group.NUGGET_TAG)
                    .unlockedBy(String.format("has_%s_nugget", group.name), has(group.NUGGET_TAG))
                    .save(consumer);

            // Block -> 9x Ingot
            ShapelessRecipeBuilder
                    .shapeless(RecipeCategory.MISC, group.INGOT.get(), 9)
                    .requires(group.BLOCK_ITEM_TAG)
                    .unlockedBy(hasCondition, RecipeProvider.has(group.BLOCK_ITEM_TAG))
                    .save(consumer, shapelessRecipeDir(String.format("%s_ingot", group.name), "block"));

            // 9x Ingot -> Block
            block(group.BLOCK_ITEM.get(), group.INGOT_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.INGOT_TAG))
                    .save(consumer);

            // Dust -> Ingot
            SimpleCookingRecipeBuilder
                    .blasting(Ingredient.of(group.DUST_TAG), RecipeCategory.MISC, group.INGOT.get(), 0.15f, 100)
                    .unlockedBy(hasCondition, RecipeProvider.has(group.DUST_TAG))
                    .save(consumer, smeltingRecipeDir(String.format("%s_ingot", group.name), "dust"));

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

        GroupHelper.applyToMaterial(group -> {

            // Ore -> Ingot
            SimpleCookingRecipeBuilder
                    .blasting(Ingredient.of(group.ORE_REGISTRY_GROUP.ORE_ITEM_TAG), RecipeCategory.MISC, group.INGOT.get(), 0.15f, 200)
                    .unlockedBy(hasCondition, RecipeProvider.has(group.ORE_REGISTRY_GROUP.ORE.get()))
                    .save(consumer, smeltingRecipeDir(String.format("%s_ingot", group.name), "ore"));

            // Raw -> Ingot
            SimpleCookingRecipeBuilder
                    .blasting(Ingredient.of(group.RAW_TAG), RecipeCategory.MISC, group.INGOT.get(), 0.15f, 200)
                    .unlockedBy(hasCondition, RecipeProvider.has(group.ORE_REGISTRY_GROUP.ORE.get()))
                    .save(consumer, blastingRecipeDir(String.format("%s_ingot", group.name), "ore"));

            // Raw Block -> 9x Raw
            ShapelessRecipeBuilder
                    .shapeless(RecipeCategory.MISC, group.RAW.get(), 9)
                    .requires(group.RAW_BLOCK_ITEM_TAG)
                    .unlockedBy(hasCondition, RecipeProvider.has(group.RAW_TAG))
                    .save(consumer, shapelessRecipeDir(String.format("raw_%s", group.name), "block"));

            // 9x Raw -> Raw Block
            block(group.ORE_REGISTRY_GROUP.RAW_BLOCK_ITEM.get(), group.RAW_TAG)
                    .define('#', group.RAW_TAG)
                    .unlockedBy(String.format("has_raw_%s", group.name), has(group.RAW_TAG))
                    .save(consumer);

            // Hammer + Ore -> Dust
            ShapelessRecipeBuilder
                    .shapeless(RecipeCategory.MISC, group.DUST.get(), 2)
                    .requires(ItemTagRegistry.ORE_HAMMERS)
                    .requires(group.RAW_TAG)
                    .unlockedBy(hasCondition, RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(ItemTagRegistry.ORE_HAMMERS).build()))
                    .save(consumer, shapelessRecipeDir(group.name, "hammer_crushing"));
        });

        GroupHelper.applyToGem(group -> {
            // Block -> 9x Ingot
            ShapelessRecipeBuilder
                    .shapeless(RecipeCategory.MISC, group.GEM.get(), 9)
                    .requires(group.BLOCK_ITEM_TAG)
                    .unlockedBy(hasCondition, RecipeProvider.has(group.BLOCK_ITEM_TAG))
                    .save(consumer, shapelessRecipeDir(String.format("%s_ingot", group.name), "block"));

            // 9x Ingot -> Block
            block(group.BLOCK_ITEM.get(), group.GEM_TAG)
                    .unlockedBy(String.format("has_%s_ingot", group.name), has(group.GEM_TAG))
                    .save(consumer);

            // Hammer + Ore -> Dust
            ShapelessRecipeBuilder
                    .shapeless(RecipeCategory.MISC, group.DUST.get(), 2)
                    .requires(ItemTagRegistry.ORE_HAMMERS)
                    .requires(group.GEM_TAG)
                    .unlockedBy("has_hammer", has(ItemTagRegistry.ORE_HAMMERS))
                    .save(consumer, shapelessRecipeDir(group.name, "hammer_crushing"));
        });

        GroupHelper.applyToDust(group -> {
            // Block -> 9x Ingot
            ShapelessRecipeBuilder
                    .shapeless(RecipeCategory.MISC, group.DUST.get(), 9)
                    .requires(group.BLOCK_ITEM_TAG)
                    .unlockedBy(String.format("has_%s", group.name), has(group.BLOCK_ITEM_TAG))
                    .save(consumer, shapelessRecipeDir(String.format("%s_ingot", group.name), "block"));

            // 9x Ingot -> Block
            block(group.BLOCK_ITEM.get(), group.DUST_TAG)
                    .unlockedBy(String.format("has_%s", group.name), has(group.DUST_TAG))
                    .save(consumer);

            // Hammer + Ore -> Dust
            ShapelessRecipeBuilder
                    .shapeless(RecipeCategory.MISC, group.DUST.get(), 2)
                    .requires(ItemTagRegistry.ORE_HAMMERS)
                    .requires(group.ORE_REGISTRY_GROUP.ORE_ITEM_TAG)
                    .unlockedBy("has_hammer", has(ItemTagRegistry.ORE_HAMMERS))
                    .save(consumer, shapelessRecipeDir(group.name, "hammer_crushing"));
        });
    }
}
