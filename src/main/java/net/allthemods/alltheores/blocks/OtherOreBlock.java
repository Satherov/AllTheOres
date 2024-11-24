package net.allthemods.alltheores.blocks;

import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviderType;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;


public class OtherOreBlock extends DropExperienceBlock {
    private final static IntProvider xpRange = new IntProvider() {
        @Override
        public int getMaxValue() {
            return 256;
        }

        @Override
        public int getMinValue() {
            return 0;
        }

        @Override
        public IntProviderType<?> getType() {
            return IntProviderType.CONSTANT;

        }

        @Override
        public int sample(RandomSource arg0) {
            return arg0.nextIntBetweenInclusive(this.getMinValue(), this.getMaxValue());
        }
    };
    private static final Properties properties = BlockBehaviour.Properties.of().mapColor(MapColor.STONE);

    public OtherOreBlock() {
        super(xpRange, properties);
    }


}


