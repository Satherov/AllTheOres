package net.allthemods.alltheores.blocks.ore;

import net.minecraft.world.level.block.state.BlockBehaviour;

public class StoneOreBlock extends OreBlock {

    public static final Properties properties = BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 3.0F);

    public StoneOreBlock() {
        super(0,7, properties);
    }
}
