package com.afns.tamws.mod.afn.block;

import net.minecraft.block.GlassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockDirtGlassBlock extends GlassBlock {

    public BlockDirtGlassBlock() {
        super(Properties
                .create(Material.GLASS)
                .sound(SoundType.GLASS)
                .hardnessAndResistance(0.8F, 0.8F)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(1)
                .setRequiresTool()
                .notSolid());
        this.setRegistryName("dirt_glass");
    }
}
