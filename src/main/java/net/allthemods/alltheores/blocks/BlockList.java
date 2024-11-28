package net.allthemods.alltheores.blocks;

import mekanism.api.MekanismAPI;
import mekanism.api.chemical.Chemical;
import mekanism.common.registration.impl.ChemicalDeferredRegister;
import net.allthemods.alltheores.blocks.mek_reg.SlurryRegistry;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.items.OreHammer;
import net.allthemods.alltheores.registry.*;
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
    public static final SlurryRegistry SLURRY_STILL = new SlurryRegistry(Reference.MOD_ID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reference.MOD_ID);

    // ###################### ALL THE ORES

    public static final DeferredHolder<Item, Item> COPPER_NUGGET = ITEMS.register("copper_nugget", () -> new Item(new Item.Properties()));

    public static final MaterialRegistryGroup ALUMINUM = new MaterialRegistryGroup("aluminum", 0xFFE3E3E3);
    public static final MaterialRegistryGroup LEAD = new MaterialRegistryGroup("lead", 0xFF7C8CC6);
    public static final MaterialRegistryGroup NICKEL = new MaterialRegistryGroup("nickel", 0xFFA9A984);
    public static final MaterialRegistryGroup OSMIUM = new MaterialRegistryGroup("osmium", 0xFFC0C9DD);
    public static final MaterialRegistryGroup PLATINUM = new MaterialRegistryGroup("platinum", 0xFFB5B5FF);
    public static final MaterialRegistryGroup SILVER = new MaterialRegistryGroup("silver", 0xFFA4E0E7);
    public static final MaterialRegistryGroup TIN = new MaterialRegistryGroup("tin", 0xFF787878);
    public static final MaterialRegistryGroup URANIUM = new MaterialRegistryGroup("uranium", 0xFF7EE778);
    public static final MaterialRegistryGroup ZINC = new MaterialRegistryGroup("zinc", 0xFFB5B5B5);

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

    public static final GemRegistryGroup RUBY = new GemRegistryGroup("ruby");
    public static final GemRegistryGroup PERIDOT = new GemRegistryGroup("peridot");
    public static final GemRegistryGroup SAPPHIRE = new GemRegistryGroup("sapphire");
    public static final GemRegistryGroup CINNABAR = new GemRegistryGroup("cinnabar");
    public static final GemRegistryGroup FLUORITE = new GemRegistryGroup("fluorite");

    public static final DustRegistryGroup SALT = new DustRegistryGroup("salt");
    public static final DustRegistryGroup SULFUR = new DustRegistryGroup("sulfur");

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


