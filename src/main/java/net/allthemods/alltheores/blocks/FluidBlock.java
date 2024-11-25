package net.allthemods.alltheores.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FluidBlock extends FlowingFluid {

    public static Fluid FLOWING;
    public static Fluid SOURCE;
    public static Block BLOCK;
    public static ParticleOptions PARTICLE;

    public FluidBlock (Fluid flowing, Fluid source, Block block, ParticleOptions particle) {
        FLOWING = flowing;
        SOURCE = source;
        BLOCK = block;
    }

    @Override
    public @NotNull Fluid getFlowing() {
        return FLOWING;
    }

    @Override
    public @NotNull Fluid getSource() {
        return SOURCE;
    }

    @Override
    public @NotNull Item getBucket() {
        return new BucketItem(this, new Item.Properties());
    }

    @Override
    protected @NotNull BlockState createLegacyBlock(FluidState fluidState) {
        return BLOCK.defaultBlockState().setValue(LEVEL, getLegacyLevel(fluidState));
    }

    @Override
    protected void animateTick(Level level, BlockPos blockPos, FluidState fluidState, RandomSource randomSource) {
        super.animateTick(level, blockPos, fluidState, randomSource);
        if (!fluidState.isSource() && !fluidState.getValue(FALLING)) {
            if (randomSource.nextInt(64) == 0) {
                level.playLocalSound((double)blockPos.getX() + 0.5D, (double)blockPos.getY() + 0.5D, (double)blockPos.getZ() + 0.5D, SoundEvents.WATER_AMBIENT, SoundSource.BLOCKS, randomSource.nextFloat() * 0.25F + 0.75F, randomSource.nextFloat() + 0.5F, false);
            }
        } else if (randomSource.nextInt(10) == 0) {
            level.addParticle(ParticleTypes.UNDERWATER, (double)blockPos.getX() + randomSource.nextDouble(), (double)blockPos.getY() + randomSource.nextDouble(), (double)blockPos.getZ() + randomSource.nextDouble(), 0.0D, 0.0D, 0.0D);
        }
    }

    @Nullable
    @Override
    protected ParticleOptions getDripParticle() {
        return PARTICLE;
    }

    @Override
    protected boolean canConvertToSource(Level level) {
        return false;
    }

    @Override
    protected void beforeDestroyingBlock(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState) {
        BlockEntity blockEntity = blockState.hasBlockEntity() ? levelAccessor.getBlockEntity(blockPos) : null;
        Block.dropResources(blockState, levelAccessor, blockPos, blockEntity);
    }

    @Override
    protected int getSlopeFindDistance(LevelReader levelReader) {
        return 4;
    }


    @Override
    protected boolean canBeReplacedWith(FluidState fluidState, BlockGetter blockGetter, BlockPos blockPos, Fluid fluid, Direction direction) {
        return true;
    }

    @Override
    public int getTickDelay(LevelReader levelReader) {
        return 8;
    }

    @Override
    protected int getDropOff(LevelReader levelReader) {
        return 1;
    }

    @Override
    protected float getExplosionResistance() {
        return 100;
    }

    @Override
    public boolean isSource(FluidState fluidState) {
        return false;
    }

    @Override
    public int getAmount(FluidState fluidState) {
        return 0;
    }

    public static class Flowing extends FluidBlock {
        public Flowing(Fluid flowing, Fluid source, Block block, ParticleOptions particle) {
            super(flowing, source, block, particle);
        }

        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> fluidState) {
            super.createFluidStateDefinition(fluidState);
            fluidState.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState p_164509_) {
            return p_164509_.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }
    }

    public static class Source extends FluidBlock {
        public Source(Fluid flowing, Fluid source, Block block, ParticleOptions particle) {
            super(flowing, source, block, particle);
        }

        @Override
        public int getAmount(FluidState p_164509_) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState state) {
            return true;
        }
    }
}
