package net.allthemods.alltheores.blocks.ore;

import net.minecraft.world.level.block.state.BlockBehaviour;

public class EndOreBlock extends OreBlock {

    public static final Properties properties = BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 3.0F);

    public EndOreBlock() {
        super(0,7, properties);
    }
}
