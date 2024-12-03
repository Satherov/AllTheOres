package net.allthemods.alltheores.registry;

import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.items.OreHammer;
import net.allthemods.alltheores.registry.groups.RegistryGroupAlloy;
import net.allthemods.alltheores.registry.groups.RegistryGroupMaterial;
import net.allthemods.alltheores.registry.groups.RegistryGroupOre;
import net.allthemods.alltheores.registry.groups.RegistryGroupVanilla;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ATORegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(Reference.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, Reference.MOD_ID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, Reference.MOD_ID);

    // ###################### ALL THE ORES

    public static final RegistryGroupMaterial ALUMINUM = new RegistryGroupMaterial("aluminum", 0xFFE3E3E3, 24, -64, 320, 4);
    public static final RegistryGroupMaterial LEAD = new RegistryGroupMaterial("lead", 0xFF7C8CC6, 24, -64, 56, 3);
    public static final RegistryGroupMaterial NICKEL = new RegistryGroupMaterial("nickel", 0xFFA9A984, 24, -64, 56, 3);
    public static final RegistryGroupMaterial OSMIUM = new RegistryGroupMaterial("osmium", 0xFFC0C9DD, 24, -64, 56, 3);
    public static final RegistryGroupMaterial PLATINUM = new RegistryGroupMaterial("platinum", 0xFFB5B5FF, 24, -64, 36, 1);
    public static final RegistryGroupMaterial SILVER = new RegistryGroupMaterial("silver", 0xFFA4E0E7, 24, -64, 56, 3);
    public static final RegistryGroupMaterial TIN = new RegistryGroupMaterial("tin", 0xFF787878, 24, -64, 196, 4);
    public static final RegistryGroupMaterial URANIUM = new RegistryGroupMaterial("uranium", 0xFF7EE778, 24, -64, 16, 2);
    public static final RegistryGroupMaterial ZINC = new RegistryGroupMaterial("zinc", 0xFFB5B5B5, 24, -64, 126, 3);
    public static final RegistryGroupMaterial IRIDIUM = new RegistryGroupMaterial("iridium", 0xFFC0C0C0, 10, -64, 32, 4);

    public static final RegistryGroupAlloy STEEL = new RegistryGroupAlloy("steel");
    public static final RegistryGroupAlloy INVAR = new RegistryGroupAlloy("invar");
    public static final RegistryGroupAlloy ELECTRUM = new RegistryGroupAlloy("electrum");
    public static final RegistryGroupAlloy BRONZE = new RegistryGroupAlloy("bronze");
    public static final RegistryGroupAlloy BRASS = new RegistryGroupAlloy("brass");
    public static final RegistryGroupAlloy ENDERIUM = new RegistryGroupAlloy("enderium");
    public static final RegistryGroupAlloy LUMIUM = new RegistryGroupAlloy("lumium");
    public static final RegistryGroupAlloy SIGNALUM = new RegistryGroupAlloy("signalum");
    public static final RegistryGroupAlloy CONSTANTAN = new RegistryGroupAlloy("constantan");

    //We don't need to set anything here as it gets automatically generated, this only exists
    public static final RegistryGroupOre RUBY = new RegistryGroupOre("ruby", "gem", 7, -64, 228, 3);
    public static final RegistryGroupOre PERIDOT = new RegistryGroupOre("peridot", "gem", 7, -64, 196, 3);
    public static final RegistryGroupOre SAPPHIRE = new RegistryGroupOre("sapphire", "gem", 7, -64, 296, 3);
    public static final RegistryGroupOre CINNABAR = new RegistryGroupOre("cinnabar", "gem", 27, -64, 228, 3);
    public static final RegistryGroupOre FLUORITE = new RegistryGroupOre("fluorite", "gem", 27, -64, 228, 3);

    public static final RegistryGroupOre SALT = new RegistryGroupOre("salt", "dust", 27, -64, 228, 3);
    public static final RegistryGroupOre SULFUR = new RegistryGroupOre("sulfur", "dust", 17, -64, 25, 1);

    public static final RegistryGroupVanilla COPPER = new RegistryGroupVanilla("copper", "ingot", Tags.Items.INGOTS_COPPER, Items.COPPER_INGOT);
    public static final RegistryGroupVanilla IRON = new RegistryGroupVanilla("iron", "ingot", Tags.Items.INGOTS_IRON, Items.IRON_INGOT);
    public static final RegistryGroupVanilla GOLD = new RegistryGroupVanilla("gold", "ingot", Tags.Items.INGOTS_GOLD, Items.GOLD_INGOT);
    public static final RegistryGroupVanilla DIAMOND = new RegistryGroupVanilla("diamond", "gem", Tags.Items.GEMS_DIAMOND, Items.DIAMOND);
    //public static final RegistryGroupVanilla NETHERITE = new RegistryGroupVanilla("netherite", "ingot", Tags.Items.INGOTS_NETHERITE, Items.NETHERITE_INGOT);

    public static final DeferredHolder<Item, Item> COPPER_NUGGET = ITEMS.register("copper_nugget", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> COPPER_ORE_HAMMER = ITEMS.register("copper_ore_hammer", () -> new OreHammer(new Item.Properties(), 64));
    public static final DeferredHolder<Item, Item> IRON_ORE_HAMMER = ITEMS.register("iron_ore_hammer", () -> new OreHammer(new Item.Properties(), 96));
    public static final DeferredHolder<Item, Item> BRONZE_ORE_HAMMER = ITEMS.register("bronze_ore_hammer", () -> new OreHammer(new Item.Properties(), 128));
    public static final DeferredHolder<Item, Item> INVAR_ORE_HAMMER = ITEMS.register("invar_ore_hammer", () -> new OreHammer(new Item.Properties(), 192));
    public static final DeferredHolder<Item, Item> PLATINUM_ORE_HAMMER = ITEMS.register("platinum_ore_hammer", () -> new OreHammer(new Item.Properties(), 256));

    // ###################### HELPER METHODS

    public static DeferredHolder<Item, BlockItem> blockItem(DeferredHolder<Block, Block> block) {
        return ATORegistry.ITEMS.register(block.getId().getPath(),
                () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static DeferredHolder<Item, Item> material(String path) {
        return ATORegistry.ITEMS.register(path, () -> new Item(new Item.Properties()));
    }

}


