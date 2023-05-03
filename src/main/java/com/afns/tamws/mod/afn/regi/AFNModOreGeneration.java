package com.afns.tamws.mod.afn.regi;

import com.afns.tamws.mod.afn.main.AFNMod;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class AFNModOreGeneration {

    public static void oreGen(final BiomeLoadingEvent event) {
        if (event.getCategory().equals(Biome.Category.THEEND)) {
        } else {
            if (event.getCategory().equals(Biome.Category.NETHER)) {
            } else {
                generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, AFNModBlocks.DIRT_ORE.getDefaultState(), 8, 16, 3);
            }
        }
    }

    public static void generateOre(BiomeGenerationSettingsBuilder builder, RuleTest test, BlockState state, int size, int range, int amount) {
        builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.withConfiguration(new OreFeatureConfig(test,state,size)).range(range).square().func_242731_b(amount));
    }
}
