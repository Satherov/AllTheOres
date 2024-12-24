package net.allthemods.alltheores.content.blocks.sets.ato_sets;

import net.allthemods.alltheores.content.blocks.sets.ESetTypes;
import net.allthemods.alltheores.content.fluids.MoltenBlock;
import net.allthemods.alltheores.infos.Reference;
import net.allthemods.alltheores.registry.ATORegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static net.allthemods.alltheores.registry.ATORegistry.*;

public class ATOIngotSet extends ATOAlloySet {

    private static final List<ATOIngotSet> instances = new ArrayList<>();
    public static List<ATOIngotSet> getIngotSets() {
        return instances;
    }

    public final int fluidColor;
    public final ATOOreSet ORES;
    public final MekanismSet MEK;

    // Item Tags
    public final TagKey<Item> RAW_TAG;

    // Block Tags
    public final TagKey<Block> RAW_BLOCK_TAG;

    // Block Item Tags
    public final TagKey<Item> RAW_BLOCK_ITEM_TAG;

    // Items
    public final DeferredHolder<Item, Item> RAW;

    // Blocks
    public final DeferredHolder<Block, Block>  RAW_BLOCK;

    // Block Items
    public final DeferredHolder<Item, BlockItem>  RAW_BLOCK_ITEM;

    // Fluids
    public final Supplier<FluidType> MOLTEN_TYPE;

    public final DeferredHolder<Fluid, BaseFlowingFluid.Source> MOLTEN;
    public final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> MOLTEN_FLOWING;
    public final DeferredHolder<Item, BucketItem> MOLTEN_BUCKET;
    public final DeferredHolder<Block, LiquidBlock> MOLTEN_BLOCK;

    public ATOIngotSet(String name, int fluidColor, String hardness, int veinSize, int minY, int maxY, int count) {
        super(name);
        instances.add(this);

        this.fluidColor = fluidColor;

        // Item Tags
        RAW_TAG = ItemTags.create(Reference.raw_materials(name));

        // Block Tags
        RAW_BLOCK_TAG = BlockTags.create(Reference.block(String.format("raw_%s", name)));

        // Block Item Tags
        RAW_BLOCK_ITEM_TAG = ItemTags.create(Reference.block(String.format("raw_%s", name)));

        // Items
        RAW = item(String.format("raw_%s", name));

        // Blocks
        RAW_BLOCK = ATORegistry.BLOCKS.register(String.format("raw_%s_block", name), () -> new Block(Blocks.STONE.properties().strength(3.0f, 3.0f)));

        // Block Items
        RAW_BLOCK_ITEM = blockItem(RAW_BLOCK);

        // Fluids
        MOLTEN_TYPE = ATORegistry.FLUID_TYPES.register(String.format("molten_%s_type", name), () -> new FluidType(FluidType.Properties.create()
                .canSwim(false)
                .canDrown(false)
                .canConvertToSource(false)
                .lightLevel(15)
                .density(3000)
                .viscosity(6000)
                .temperature(1300)
                .motionScale(0.0023333333333333335)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.LAVA_EXTINGUISH)
        ));

        MOLTEN = ATORegistry.FLUIDS.register(String.format("molten_%s", name), () -> new BaseFlowingFluid.Source(makeMoltenProperties(name)));
        MOLTEN_FLOWING = ATORegistry.FLUIDS.register(String.format("flowing_molten_%s", name), () -> new BaseFlowingFluid.Flowing(makeMoltenProperties(name)));
        MOLTEN_BUCKET = ATORegistry.FLUID_ITEMS.register(String.format("molten_%s_bucket", name), () -> new BucketItem(MOLTEN.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
        MOLTEN_BLOCK = ATORegistry.FLUID_BLOCKS.register(String.format("molten_%s", name), () -> new MoltenBlock(MOLTEN.get(), Block.Properties.of()
                .strength(100.0F)
                .speedFactor(0.7F)
                .noCollission()
                .liquid()
                .replaceable()
        ));

        ORES = new ATOOreSet(name, ESetTypes.INGOT, hardness, RAW, RAW_BLOCK, veinSize, minY, maxY, count);
        MEK =  ModList.get().isLoaded("mekanism") ? new MekanismSet(name, fluidColor, BLOCK) : null;
    }

    private BaseFlowingFluid.Properties makeMoltenProperties(String name) {
        return new BaseFlowingFluid.Properties(
                MOLTEN_TYPE,
                DeferredHolder.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(ATORegistry.FLUIDS.getNamespace(), String.format("molten_%s", name))),
                DeferredHolder.create(Registries.FLUID, ResourceLocation.fromNamespaceAndPath(ATORegistry.FLUIDS.getNamespace(), String.format("flowing_molten_%s", name)))
        ).bucket(DeferredHolder.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ATORegistry.FLUIDS.getNamespace(), String.format("molten_%s_bucket", name))))
                .block(DeferredHolder.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ATORegistry.FLUIDS.getNamespace(), String.format("molten_%s", name))))
                .tickRate(30)
                .slopeFindDistance(4)
                .levelDecreasePerBlock(2);
    }
}
