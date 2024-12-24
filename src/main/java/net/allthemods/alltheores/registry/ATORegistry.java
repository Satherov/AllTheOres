package net.allthemods.alltheores.registry;

import net.allthemods.alltheores.content.blocks.sets.ato_sets.*;
import net.allthemods.alltheores.content.blocks.sets.vanilla_sets.VanillaDebrisSet;
import net.allthemods.alltheores.content.blocks.sets.vanilla_sets.VanillaGemSet;
import net.allthemods.alltheores.content.blocks.sets.vanilla_sets.VanillaIngotSet;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.content.items.OreHammer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ATORegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(Reference.MOD_ID);

    public static final DeferredRegister<Block> FLUID_BLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
    public static final DeferredRegister<Item> FLUID_ITEMS = DeferredRegister.createItems(Reference.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, Reference.MOD_ID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, Reference.MOD_ID);

    /*
    * Checklist for adding new Resources:
    * For all: Textures obviously :D
    * For Ingots: Go to ATOSagMillRecipeProvider and add a byproduct to the map (if not added it will datagen a recipe without byproduct)
    * For Alloys: Go to ATOAlloyRecipeProvider and add a recipe (if not added it just won't have a recipe in the alloy smelter)
    * For Gems: Nothing, a new entry does everything for you
    * For Dusts: Nothing, a new entry does everything for you
    * */

    public static final ATOIngotSet ALUMINUM = new ATOIngotSet("aluminum", 0xFFE3E3E3, "stone", 24, -64, 320, 4);
    public static final ATOIngotSet LEAD = new ATOIngotSet("lead", 0xFF7C8CC6, "stone", 24, -64, 56, 3);
    public static final ATOIngotSet NICKEL = new ATOIngotSet("nickel", 0xFFA9A984, "iron", 24, -64, 56, 3);
    public static final ATOIngotSet OSMIUM = new ATOIngotSet("osmium", 0xFFC0C9DD, "diamond", 24, -64, 56, 3);
    public static final ATOIngotSet PLATINUM = new ATOIngotSet("platinum", 0xFFB5B5FF,"diamond", 24, -64, 36, 1);
    public static final ATOIngotSet SILVER = new ATOIngotSet("silver", 0xFFA4E0E7,"stone", 24, -64, 56, 3);
    public static final ATOIngotSet TIN = new ATOIngotSet("tin", 0xFF787878,"stone", 24, -64, 196, 4);
    public static final ATOIngotSet URANIUM = new ATOIngotSet("uranium", 0xFF7EE778,"iron",24, -64, 16, 2);
    public static final ATOIngotSet ZINC = new ATOIngotSet("zinc", 0xFFB5B5B5, "stone",24, -64, 126, 3);
    public static final ATOIngotSet IRIDIUM = new ATOIngotSet("iridium", 0xFFC0C0C0,"diamond", 10, -64, 32, 4);

    public static final ATOAlloySet STEEL = new ATOAlloySet("steel");
    public static final ATOAlloySet INVAR = new ATOAlloySet("invar");
    public static final ATOAlloySet ELECTRUM = new ATOAlloySet("electrum");
    public static final ATOAlloySet BRONZE = new ATOAlloySet("bronze");
    public static final ATOAlloySet BRASS = new ATOAlloySet("brass");
    public static final ATOAlloySet ENDERIUM = new ATOAlloySet("enderium");
    public static final ATOAlloySet LUMIUM = new ATOAlloySet("lumium");
    public static final ATOAlloySet SIGNALUM = new ATOAlloySet("signalum");
    public static final ATOAlloySet CONSTANTAN = new ATOAlloySet("constantan");

    public static final ATOGemSet RUBY = new ATOGemSet("ruby",  "stone", 7, -64, 228, 3);
    public static final ATOGemSet PERIDOT = new ATOGemSet("peridot",  "stone", 7, -64, 196, 3);
    public static final ATOGemSet SAPPHIRE = new ATOGemSet("sapphire",  "stone", 7, -64, 296, 3);
    public static final ATOGemSet CINNABAR = new ATOGemSet("cinnabar",  "iron", 27, -64, 228, 3);
    public static final ATOGemSet FLUORITE = new ATOGemSet("fluorite",  "iron", 27, -64, 228, 3);

    public static final ATODustSet SALT = new ATODustSet("salt", "stone", 27, -64, 228, 3);
    public static final ATODustSet SULFUR = new ATODustSet("sulfur", "iron", 17, -64, 25, 1);

    public static final DeferredHolder<Item, Item> COPPER_NUGGET = ITEMS.register("copper_nugget", () -> new Item(new Item.Properties()));

    public static final VanillaIngotSet COPPER = new VanillaIngotSet("copper", 0xFFC66740, Items.RAW_COPPER, Items.COPPER_INGOT, Blocks.COPPER_BLOCK);
    public static final VanillaIngotSet IRON = new VanillaIngotSet("iron", 0xFFC49C6D, Items.RAW_IRON, Items.IRON_INGOT, Blocks.IRON_BLOCK);
    public static final VanillaIngotSet GOLD = new VanillaIngotSet("gold", 0xFFE2B928, Items.RAW_GOLD, Items.GOLD_INGOT, Blocks.GOLD_BLOCK);
    public static final VanillaGemSet DIAMOND = new VanillaGemSet("diamond",  Items.DIAMOND, Blocks.DIAMOND_BLOCK);
    public static final VanillaDebrisSet NETHERITE = new VanillaDebrisSet("netherite", Blocks.ANCIENT_DEBRIS, Items.NETHERITE_SCRAP, Items.NETHERITE_INGOT, Blocks.NETHERITE_BLOCK);

    public static final DeferredHolder<Item, Item> COPPER_ORE_HAMMER = ITEMS.register("copper_ore_hammer", () -> new OreHammer(new Item.Properties(), 64));
    public static final DeferredHolder<Item, Item> IRON_ORE_HAMMER = ITEMS.register("iron_ore_hammer", () -> new OreHammer(new Item.Properties(), 96));
    public static final DeferredHolder<Item, Item> BRONZE_ORE_HAMMER = ITEMS.register("bronze_ore_hammer", () -> new OreHammer(new Item.Properties(), 128));
    public static final DeferredHolder<Item, Item> INVAR_ORE_HAMMER = ITEMS.register("invar_ore_hammer", () -> new OreHammer(new Item.Properties(), 192));
    public static final DeferredHolder<Item, Item> PLATINUM_ORE_HAMMER = ITEMS.register("platinum_ore_hammer", () -> new OreHammer(new Item.Properties(), 256));

    // ###################### HELPER METHODS

    public static DeferredHolder<Item, BlockItem> blockItem(DeferredHolder<Block, Block> block) {
        return ATORegistry.ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static DeferredHolder<Item, Item> item(String path) {
        return ATORegistry.ITEMS.register(path, () -> new Item(new Item.Properties()));
    }

}


