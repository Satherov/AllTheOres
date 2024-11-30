package net.allthemods.alltheores.registry;

import mekanism.api.chemical.Chemical;
import mekanism.api.chemical.ChemicalBuilder;
import net.allthemods.alltheores.blocks.BlockList;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.items.mekanism.Clump;
import net.allthemods.alltheores.items.mekanism.Crystal;
import net.allthemods.alltheores.items.mekanism.DirtyDust;
import net.allthemods.alltheores.items.mekanism.Shard;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
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

public class MaterialRegistryGroup extends AlloyRegistryGroup{

    public final int fluidColor;
    public final OreRegistryGroup ORES;

    //Item Tags
    public final TagKey<Item> CRYSTAL_TAG;
    public final TagKey<Item> SHARD_TAG;
    public final TagKey<Item> CLUMP_TAG;
    public final TagKey<Item> DIRTY_DUST_TAG;


    // Fluids
    public final Supplier<FluidType> MOLTEN_TYPE;

    public final DeferredHolder<Fluid, BaseFlowingFluid.Source> MOLTEN;
    public final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> MOLTEN_FLOWING;
    public final DeferredHolder<Item, BucketItem> MOLTEN_BUCKET;
    public final DeferredHolder<Block, LiquidBlock> MOLTEN_BLOCK;


    // Mekanism
    public final DeferredHolder<Chemical, Chemical> DIRTY_SLURRY;
    public final DeferredHolder<Chemical, Chemical> CLEAN_SLURRY;

    public final DeferredHolder<Item, Item> CRYSTAL;
    public final DeferredHolder<Item, Item> SHARD;
    public final DeferredHolder<Item, Item> CLUMP;
    public final DeferredHolder<Item, Item> DIRTY_DUST;

    public MaterialRegistryGroup(String name, int fluidColor) {
        super(name);
        this.fluidColor = fluidColor;

        ORES = new OreRegistryGroup(name, "ore");

        //Item Tags
        CRYSTAL_TAG = ItemTags.create(Reference.crystal(name));
        SHARD_TAG = ItemTags.create(Reference.shard(name));
        CLUMP_TAG = ItemTags.create(Reference.clump(name));
        DIRTY_DUST_TAG = ItemTags.create(Reference.dirty_dust(name));

        // Fluids
        MOLTEN_TYPE = BlockList.FLUID_TYPES.register(String.format("molten_%s_type", name), () -> new FluidType(FluidType.Properties.create()
                .density(3000)
                .viscosity(6000)
                .temperature(1300)));

        MOLTEN = BlockList.FLUIDS.register(String.format("molten_%s", name), () -> new BaseFlowingFluid.Source(makeMoltenProperties(name)));
        MOLTEN_FLOWING = BlockList.FLUIDS.register(String.format("flowing_molten_%s", name), () -> new BaseFlowingFluid.Flowing(makeMoltenProperties(name)));
        MOLTEN_BUCKET = BlockList.ITEMS.register(String.format("molten_%s_bucket", name), () -> new BucketItem(MOLTEN.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
        MOLTEN_BLOCK = BlockList.BLOCKS.register(String.format("molten_%s", name), () -> new LiquidBlock(MOLTEN.get(), Block.Properties.of().noCollission().strength(100.0F)));


        // Mekanism
        DIRTY_SLURRY = BlockList.SLURRYS.register(String.format("dirty_%s_slurry", name), () -> new Chemical(ChemicalBuilder.builder().ore(BLOCK.getId())));
        CLEAN_SLURRY = BlockList.SLURRYS.register(String.format("clean_%s_slurry", name), () -> new Chemical(ChemicalBuilder.builder().ore(BLOCK.getId())));

        CRYSTAL = BlockList.ITEMS.register(String.format("%s_crystal", name), () -> new Crystal(new Item.Properties()));
        SHARD = BlockList.ITEMS.register(String.format("%s_shard", name), () -> new Shard(new Item.Properties()));
        CLUMP = BlockList.ITEMS.register(String.format("%s_clump", name), () -> new Clump(new Item.Properties()));
        DIRTY_DUST = BlockList.ITEMS.register(String.format("dirty_%s_dust", name), () -> new DirtyDust(new Item.Properties()));
    }

    private BaseFlowingFluid.Properties makeMoltenProperties(String name) {
        return new BaseFlowingFluid.Properties(
                MOLTEN_TYPE,
                DeferredHolder.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(BlockList.FLUIDS.getNamespace(), String.format("molten_%s", name))),
                DeferredHolder.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(BlockList.FLUIDS.getNamespace(), String.format("flowing_molten_%s", name)))
        ).bucket(DeferredHolder.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(BlockList.FLUIDS.getNamespace(), String.format("molten_%s_bucket", name))))
                .block(DeferredHolder.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(BlockList.FLUIDS.getNamespace(), String.format("molten_%s", name))));
    }

}
