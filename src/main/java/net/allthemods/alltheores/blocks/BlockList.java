package net.allthemods.alltheores.blocks;

import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.items.OreHammer;
import net.allthemods.alltheores.registry.AlloyRegistryGroup;
import net.allthemods.alltheores.registry.OreRegistryGroup;
import net.allthemods.alltheores.registry.VanillaRegistryGroup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.*;
import net.neoforged.neoforge.registries.DeferredHolder;

public class BlockList {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
    public static final DeferredRegister<Block> ORE = DeferredRegister.createBlocks(Reference.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(Reference.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, Reference.MOD_ID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reference.MOD_ID);

    // ###################### ALL THE ORES

    public static final OreRegistryGroup ALUMINUM = new OreRegistryGroup("aluminum", 0xFFE3E3E3);
    public static final OreRegistryGroup LEAD = new OreRegistryGroup("lead", 0xFF7C8CC6);
    public static final OreRegistryGroup NICKEL = new OreRegistryGroup("nickel", 0xFFA9A984);
    public static final OreRegistryGroup OSMIUM = new OreRegistryGroup("osmium", 0xFFC0C9DD);
    public static final OreRegistryGroup PLATINUM = new OreRegistryGroup("platinum", 0xFFB5B5FF);
    public static final OreRegistryGroup SILVER = new OreRegistryGroup("silver", 0xFFA4E0E7);
    public static final OreRegistryGroup TIN = new OreRegistryGroup("tin", 0xFF787878);
    public static final OreRegistryGroup URANIUM = new OreRegistryGroup("uranium", 0xFF7EE778);
    public static final OreRegistryGroup ZINC = new OreRegistryGroup("zinc", 0xFFB5B5B5);

    public static final AlloyRegistryGroup STEEL = new AlloyRegistryGroup("steel");
    public static final AlloyRegistryGroup INVAR = new AlloyRegistryGroup("invar");
    public static final AlloyRegistryGroup ELECTRUM = new AlloyRegistryGroup("electrum");
    public static final AlloyRegistryGroup BRONZE = new AlloyRegistryGroup("bronze");
    public static final AlloyRegistryGroup ENDERIUM = new AlloyRegistryGroup("enderium");
    public static final AlloyRegistryGroup LUMIUM = new AlloyRegistryGroup("lumium");
    public static final AlloyRegistryGroup SIGNALUM = new AlloyRegistryGroup("signalum");
    public static final AlloyRegistryGroup CONSTANTAN = new AlloyRegistryGroup("constantan");

    public static final VanillaRegistryGroup DIAMOND = new VanillaRegistryGroup("diamond", Tags.Items.GEMS_DIAMOND);
    public static final VanillaRegistryGroup IRON = new VanillaRegistryGroup("iron", Tags.Items.INGOTS_IRON);
    public static final VanillaRegistryGroup GOLD = new VanillaRegistryGroup("gold", Tags.Items.INGOTS_GOLD);
    public static final VanillaRegistryGroup COPPER = new VanillaRegistryGroup("copper", Tags.Items.INGOTS_COPPER);

    public static final DeferredHolder<Item, Item> COPPER_ORE_HAMMER = ITEMS.register("copper_ore_hammer", () -> new OreHammer(new Item.Properties(), 64));
    public static final DeferredHolder<Item, Item> IRON_ORE_HAMMER = ITEMS.register("iron_ore_hammer", () -> new OreHammer(new Item.Properties(), 96));
    public static final DeferredHolder<Item, Item> BRONZE_ORE_HAMMER = ITEMS.register("bronze_ore_hammer", () -> new OreHammer(new Item.Properties(), 128));
    public static final DeferredHolder<Item, Item> INVAR_ORE_HAMMER = ITEMS.register("invar_ore_hammer", () -> new OreHammer(new Item.Properties(), 192));
    public static final DeferredHolder<Item, Item> PLATINUM_ORE_HAMMER = ITEMS.register("platinum_ore_hammer", () -> new OreHammer(new Item.Properties(), 256));

    // ###################### HELPER METHODS

    public static DeferredHolder<Item, BlockItem> blockItem(DeferredHolder<Block, Block> registryObject) {
        return BlockList.ITEMS.register(registryObject.getId().getPath(),
                () -> new BlockItem(registryObject.get(), new Item.Properties()));
    }

    public static DeferredHolder<Item, Item> material(String path) {
        return BlockList.ITEMS.register(path, () -> new Item(new Item.Properties()));
    }

}


