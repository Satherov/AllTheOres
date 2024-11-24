package net.allthemods.alltheores.blocks.ore;

import net.minecraft.world.level.block.state.BlockBehaviour;

public class SlateOreBlock extends OreBlock {

    public static final Properties properties = BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 3.0F);

    public SlateOreBlock() {
        super(0,7, properties);
    }
}
