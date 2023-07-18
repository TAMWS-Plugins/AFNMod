package com.afns.tamws.mod.afn.regi;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class AFNModTabs {

    public static class AFNModTab extends ItemGroup {

        public AFNModTab() {
            super("afnmod");
        }

        @Override
        public ItemStack createIcon() {

            ItemStack itemStack = new ItemStack(AFNModItems.DIRT_INGOT);
            return itemStack;
        }
    }

    public static class AFNModCheatTab extends ItemGroup {

        public AFNModCheatTab() {
            super("afnmodcheat");
        }

        @Override
        public ItemStack createIcon() {
            ItemStack itemStack = new ItemStack(Blocks.BARRIER);
            return itemStack;
        }
    }

    public static class AFNModBlockTab extends ItemGroup {

        public AFNModBlockTab() {
            super("afnmodblock");
        }

        @Override
        public ItemStack createIcon() {

            ItemStack itemStack = new ItemStack(AFNModBlocks.DIRTINGOT_BLOCK);
            return itemStack;
        }
    }

    public static class AFNModArmorTab extends ItemGroup {

        public AFNModArmorTab() {
            super("afnmodarmor");
        }

        @Override
        public ItemStack createIcon() {
            ItemStack itemStack = new ItemStack(AFNModItems.DIRT_CHESTPLATE);
            return itemStack;
        }
    }

    public static class AFNModToolsTab extends ItemGroup {

        public AFNModToolsTab() {
            super("afnmodtools");
        }

        @Override
        public ItemStack createIcon() {

            ItemStack itemStack = new ItemStack(AFNModItems.DIRT_SWORD);
            return itemStack;
        }
    }


}
