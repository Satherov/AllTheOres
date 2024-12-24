package net.allthemods.alltheores.content.blocks.ore;

import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviderType;
import net.minecraft.world.level.block.DropExperienceBlock;

public class OreBlock extends DropExperienceBlock {

    public OreBlock(int xpMinValue, int xpMaxValue, Properties properties) {
        super(new IntProvider() {
            @Override
            public int getMaxValue() {
                return xpMaxValue;
            }

            @Override
            public int getMinValue() {
                return xpMinValue;
            }

            @Override
            public IntProviderType<?> getType() {
                return IntProviderType.CONSTANT;
            }

            @Override
            public int sample(RandomSource random) {
                return random.nextIntBetweenInclusive(getMinValue(), getMaxValue());
            }
        }, properties);
    }
}


