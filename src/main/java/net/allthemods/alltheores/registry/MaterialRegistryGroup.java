package net.allthemods.alltheores.registry;

import mekanism.api.chemical.Chemical;
import mekanism.api.chemical.ChemicalBuilder;
import net.allthemods.alltheores.blocks.BlockList;
import net.allthemods.alltheores.blocks.ore.*;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.items.mekanism.Clump;
import net.allthemods.alltheores.items.mekanism.Crystal;
import net.allthemods.alltheores.items.mekanism.DirtyDust;
import net.allthemods.alltheores.items.mekanism.Shard;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

import static net.allthemods.alltheores.blocks.BlockList.material;

public class MaterialRegistryGroup extends AlloyRegistryGroup{

    public final OreRegistryGroup ORE_REGISTRY_GROUP;

    public final int fluidColor;

    //Tags
    public final TagKey<Item> RAW_TAG;

    public final TagKey<Block> RAW_BLOCK_TAG;
    public final TagKey<Item> RAW_BLOCK_ITEM_TAG;

    public final TagKey<Item> CRYSTAL_TAG;
    public final TagKey<Item> SHARD_TAG;
    public final TagKey<Item> CLUMP_TAG;
    public final TagKey<Item> DIRTY_DUST_TAG;

    // Items
    public final DeferredHolder<Item, Item> RAW;

    // Fluid Registry
    public final DeferredHolder<Fluid, BaseFlowingFluid.Source> MOLTEN;
    public final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> MOLTEN_FLOWING;
    public final DeferredHolder<Block, LiquidBlock> MOLTEN_BLOCK;
    public final Supplier<FluidType> MOLTEN_TYPE;
    public final DeferredHolder<Item, BucketItem> MOLTEN_BUCKET;

    // Mekanism Ore Processing
    public final DeferredHolder<Chemical, Chemical> DIRTY_SLURRY;
    public final DeferredHolder<Chemical, Chemical> CLEAN_SLURRY;

    public final DeferredHolder<Item, Item> CRYSTAL;
    public final DeferredHolder<Item, Item> SHARD;
    public final DeferredHolder<Item, Item> CLUMP;
    public final DeferredHolder<Item, Item> DIRTY_DUST;

    public MaterialRegistryGroup (String name, int fluidColor) {
        super(name);

        ORE_REGISTRY_GROUP = new OreRegistryGroup(name);

        this.fluidColor = fluidColor;

        RAW_TAG = ItemTags.create(Reference.raw_materials(name));

        RAW_BLOCK_TAG = BlockTags.create(Reference.block("raw_" + name));
        RAW_BLOCK_ITEM_TAG = ItemTags.create(Reference.block("raw_" + name));

        CRYSTAL_TAG = ItemTags.create(Reference.crystal(name));
        SHARD_TAG = ItemTags.create(Reference.shard(name));
        CLUMP_TAG = ItemTags.create(Reference.clump(name));
        DIRTY_DUST_TAG = ItemTags.create(Reference.dirty_dust(name));

        RAW = material(String.format("raw_%s", name));

        MOLTEN = BlockList.FLUIDS.register(String.format("molten_%s", name), () -> new BaseFlowingFluid.Source(makeMoltenProperties()));
        MOLTEN_FLOWING = BlockList.FLUIDS.register(String.format("flowing_molten_%s", name), () -> new BaseFlowingFluid.Flowing(makeMoltenProperties()));
        MOLTEN_BLOCK = BlockList.BLOCKS.register(String.format("molten_%s", name), () -> new LiquidBlock(MOLTEN.get(), Block.Properties.of().noCollission().strength(100.0F)));
        MOLTEN_BUCKET = BlockList.ITEMS.register(String.format("molten_%s_bucket", name), () -> new BucketItem(MOLTEN.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

        MOLTEN_TYPE = () -> new FluidType(FluidType.Properties.create()
                .density(3000)
                .viscosity(6000)
                .temperature(1300));

        DIRTY_SLURRY = BlockList.SLURRY_STILL.register(String.format("dirty_%s_slurry", name), () -> new Chemical(ChemicalBuilder.builder().ore(BLOCK.getId())));
        CLEAN_SLURRY = BlockList.SLURRY_STILL.register(String.format("clean_%s_slurry", name), () -> new Chemical(ChemicalBuilder.builder().ore(BLOCK.getId())));

        CRYSTAL = BlockList.ITEMS.register(String.format("%s_crystal", name), () -> new Crystal(new Item.Properties()));
        SHARD = BlockList.ITEMS.register(String.format("%s_shard", name), () -> new Shard(new Item.Properties()));
        CLUMP = BlockList.ITEMS.register(String.format("%s_clump", name), () -> new Clump(new Item.Properties()));
        DIRTY_DUST = BlockList.ITEMS.register(String.format("dirty_%s_dust", name), () -> new DirtyDust(new Item.Properties()));
    }

    private BaseFlowingFluid.Properties makeMoltenProperties() {
        return new BaseFlowingFluid.Properties(MOLTEN_TYPE, MOLTEN, MOLTEN_FLOWING).bucket(MOLTEN_BUCKET).block(MOLTEN_BLOCK);
    }
}
