package com.afns.tamws.mod.afn.regi;

import com.afns.tamws.mod.afn.block.BlockDirtGlassBlock;
import com.afns.tamws.mod.afn.block.BlockDirtIngotBlock;
import com.afns.tamws.mod.afn.block.BlockDirtIngotOre;
import com.afns.tamws.mod.afn.main.AFNMod;
import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("afnmod")
public class AFNModBlocks {

    public static final BlockDirtIngotBlock DIRTINGOT_BLOCK = null;
    public static final BlockDirtGlassBlock DIRT_GLASS = null;
    public static final BlockDirtIngotOre DIRT_ORE = null;

    @Mod.EventBusSubscriber(modid = "afnmod", bus = Bus.MOD)
    public static class Register {

        @SubscribeEvent
        public static void registerBlock(final RegistryEvent.Register<Block> event) {

            final Block[] blocks = {
                    new BlockDirtIngotBlock(),
                    new BlockDirtGlassBlock(),
                    new BlockDirtIngotOre()
            };
            event.getRegistry().registerAll(blocks);

            for (Block block : blocks) {
                if (block instanceof BlockDirtGlassBlock) {
                    RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
                }
            }

        }

        @SubscribeEvent
        public static void registerBlockItem(final RegistryEvent.Register<Item> event) {

            final BlockItem[] items = {

                new BlockItem(DIRTINGOT_BLOCK, new Item.Properties().group(AFNMod.AFNModTab.AFNMODBLOCK_TAB).isImmuneToFire()),
                new BlockItem(DIRT_GLASS, new Item.Properties().group(AFNMod.AFNModTab.AFNMODBLOCK_TAB)),
                new BlockItem(DIRT_ORE, new Item.Properties().group(AFNMod.AFNModTab.AFNMODBLOCK_TAB).isImmuneToFire())

            };
            for (BlockItem item : items) {
                final Block block = item.getBlock();
                final ResourceLocation location = Preconditions.checkNotNull(block.getRegistryName(), "Registry Name Not Found");
                event.getRegistry().register(item.setRegistryName(location)
                );
            }

        }
    }

}