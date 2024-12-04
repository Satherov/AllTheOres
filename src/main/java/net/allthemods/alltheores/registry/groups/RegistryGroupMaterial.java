package net.allthemods.alltheores.registry.groups;

import net.allthemods.alltheores.fluids.MoltenBlock;
import net.allthemods.alltheores.registry.ATORegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
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

public class RegistryGroupMaterial extends RegistryGroupAlloy {

    private static final List<RegistryGroupMaterial> instances = new ArrayList<>();

    public final int fluidColor;
    public final RegistryGroupOre ORES;
    public final RegistryGroupMekanism MEK;

    // Fluids
    public final Supplier<FluidType> MOLTEN_TYPE;

    public final DeferredHolder<Fluid, BaseFlowingFluid.Source> MOLTEN;
    public final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> MOLTEN_FLOWING;
    public final DeferredHolder<Item, BucketItem> MOLTEN_BUCKET;
    public final DeferredHolder<Block, LiquidBlock> MOLTEN_BLOCK;

    public RegistryGroupMaterial(String name, int fluidColor, int veinSize, int minY, int maxY, int count) {
        super(name);

        instances.add(this);

        this.fluidColor = fluidColor;

        ORES = new RegistryGroupOre(name, "ingot", INGOT, INGOT_TAG, DUST, DUST_TAG, veinSize, minY, maxY, count);

        if (ModList.get().isLoaded("mekanism")) {
            MEK = new RegistryGroupMekanism(name, fluidColor, BLOCK);
        } else {
            MEK = null;
        }

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

    public static List<RegistryGroupMaterial> getMaterialInstances() {
        return instances;
    }
}
