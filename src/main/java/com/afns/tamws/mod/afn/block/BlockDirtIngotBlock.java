package com.afns.tamws.mod.afn.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockDirtIngotBlock extends Block {

    public BlockDirtIngotBlock() {
        super(Properties
                .create(Material.IRON)
                .hardnessAndResistance(5.5F, 6.5F)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(2)
                .setRequiresTool()
                .sound(SoundType.STONE)
        );

        this.setRegistryName("dirtingot_block");

    }
}
