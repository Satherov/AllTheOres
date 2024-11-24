package net.allthemods.alltheores.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class ToolTipBlockItem extends BlockItem {
    public ToolTipBlockItem(Block block, Properties properties) {
        super(block, properties);
    }
    /*
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
    */

}
