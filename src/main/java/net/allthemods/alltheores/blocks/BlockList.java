package net.allthemods.alltheores.blocks;

import mekanism.common.registration.impl.ChemicalDeferredRegister;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.items.OreHammer;
import net.allthemods.alltheores.registry.groups.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.*;
import net.neoforged.neoforge.registries.DeferredHolder;

public class BlockList {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(Reference.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, Reference.MOD_ID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, Reference.MOD_ID);
    public static final ChemicalDeferredRegister SLURRYS = new ChemicalDeferredRegister(Reference.MOD_ID);

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, Reference.MOD_ID);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registries.PLACED_FEATURE, Reference.MOD_ID);

    // ###################### ALL THE ORES

    public static final DeferredHolder<Item, Item> COPPER_NUGGET = ITEMS.register("copper_nugget", () -> new Item(new Item.Properties()));

    public static final RegistryGroupMaterial ALUMINUM = new RegistryGroupMaterial("aluminum", 0xFFE3E3E3);
    public static final RegistryGroupMaterial LEAD = new RegistryGroupMaterial("lead", 0xFF7C8CC6);
    public static final RegistryGroupMaterial NICKEL = new RegistryGroupMaterial("nickel", 0xFFA9A984);
    public static final RegistryGroupMaterial OSMIUM = new RegistryGroupMaterial("osmium", 0xFFC0C9DD);
    public static final RegistryGroupMaterial PLATINUM = new RegistryGroupMaterial("platinum", 0xFFB5B5FF);
    public static final RegistryGroupMaterial SILVER = new RegistryGroupMaterial("silver", 0xFFA4E0E7);
    public static final RegistryGroupMaterial TIN = new RegistryGroupMaterial("tin", 0xFF787878);
    public static final RegistryGroupMaterial URANIUM = new RegistryGroupMaterial("uranium", 0xFF7EE778);
    public static final RegistryGroupMaterial ZINC = new RegistryGroupMaterial("zinc", 0xFFB5B5B5);

    public static final RegistryGroupAlloy STEEL = new RegistryGroupAlloy("steel");
    public static final RegistryGroupAlloy INVAR = new RegistryGroupAlloy("invar");
    public static final RegistryGroupAlloy ELECTRUM = new RegistryGroupAlloy("electrum");
    public static final RegistryGroupAlloy BRONZE = new RegistryGroupAlloy("bronze");
    public static final RegistryGroupAlloy ENDERIUM = new RegistryGroupAlloy("enderium");
    public static final RegistryGroupAlloy LUMIUM = new RegistryGroupAlloy("lumium");
    public static final RegistryGroupAlloy SIGNALUM = new RegistryGroupAlloy("signalum");
    public static final RegistryGroupAlloy CONSTANTAN = new RegistryGroupAlloy("constantan");

    public static final RegistryGroupVanilla DIAMOND = new RegistryGroupVanilla("diamond", Tags.Items.GEMS_DIAMOND);
    public static final RegistryGroupVanilla IRON = new RegistryGroupVanilla("iron", Tags.Items.INGOTS_IRON);
    public static final RegistryGroupVanilla GOLD = new RegistryGroupVanilla("gold", Tags.Items.INGOTS_GOLD);
    public static final RegistryGroupVanilla COPPER = new RegistryGroupVanilla("copper", Tags.Items.INGOTS_COPPER);

    public static final RegistryGroupGem RUBY = new RegistryGroupGem("ruby");
    public static final RegistryGroupGem PERIDOT = new RegistryGroupGem("peridot");
    public static final RegistryGroupGem SAPPHIRE = new RegistryGroupGem("sapphire");
    public static final RegistryGroupGem CINNABAR = new RegistryGroupGem("cinnabar");
    public static final RegistryGroupGem FLUORITE = new RegistryGroupGem("fluorite");

    public static final RegistryGroupDust SALT = new RegistryGroupDust("salt");
    public static final RegistryGroupDust SULFUR = new RegistryGroupDust("sulfur");

    public static final DeferredHolder<Item, Item> COPPER_ORE_HAMMER = ITEMS.register("copper_ore_hammer", () -> new OreHammer(new Item.Properties(), 64));
    public static final DeferredHolder<Item, Item> IRON_ORE_HAMMER = ITEMS.register("iron_ore_hammer", () -> new OreHammer(new Item.Properties(), 96));
    public static final DeferredHolder<Item, Item> BRONZE_ORE_HAMMER = ITEMS.register("bronze_ore_hammer", () -> new OreHammer(new Item.Properties(), 128));
    public static final DeferredHolder<Item, Item> INVAR_ORE_HAMMER = ITEMS.register("invar_ore_hammer", () -> new OreHammer(new Item.Properties(), 192));
    public static final DeferredHolder<Item, Item> PLATINUM_ORE_HAMMER = ITEMS.register("platinum_ore_hammer", () -> new OreHammer(new Item.Properties(), 256));

    // ###################### HELPER METHODS

    public static DeferredHolder<Item, BlockItem> blockItem(DeferredHolder<Block, Block> block) {
        return BlockList.ITEMS.register(block.getId().getPath(),
                () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static DeferredHolder<Item, Item> material(String path) {
        return BlockList.ITEMS.register(path, () -> new Item(new Item.Properties()));
    }

}


