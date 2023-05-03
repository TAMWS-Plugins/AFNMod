package com.afns.tamws.mod.afn.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.ToolType;

public class BlockDirtIngotOre extends OreBlock {

    public BlockDirtIngotOre() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(3F, 3F)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool());
        this.setRegistryName("dirt_ore");
    }

    public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        int exp = 256 - pos.getY();
        return silktouch == 0 ? exp + (fortune + 1) : 0;
    }
}
