package com.afns.tamws.mod.afn.item.tool;

import com.afns.tamws.mod.afn.keybind.AFNKeyBind;
import com.afns.tamws.mod.afn.main.AFNMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemDirtAxe extends AxeItem {

    public ItemDirtAxe() {
        super(AFNTierList.DIRT, 5F, -2.9F, new Properties().group(AFNMod.AFNModTab.AFNMODTOOLS_TAB).rarity(Rarity.RARE).isImmuneToFire());
        this.setRegistryName("dirt_axe");
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        if (AFNKeyBind.afnKey[1].isKeyDown()) {
            playerIn.setActiveHand(handIn);
            modeChange(stack);
            playerIn.sendStatusMessage(new StringTextComponent(modeName(stack)), true);
            return ActionResult.resultConsume(stack);
        }
        return ActionResult.resultPass(stack);
    }

    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        Block block = state.getBlock();
        int a[] = {-3,-2,-1,0,1,2,3};
        if (block.getBlock() == Blocks.ACACIA_LOG) {
            for (int ax = 0; ax < 7; ax++) {
                for (int az = 0; az < 7; az++) {
                    for (int y = 0; y < 50; y++) {
                        BlockPos aPos = new BlockPos(pos.getX() + a[ax], pos.getY() + y, pos.getZ() + a[az]);
                        if (worldIn.getBlockState(aPos).getBlock() == block && modeInt(stack) == 1) {
                            worldIn.destroyBlock(aPos, true);
                        }
                    }
                }
            }
        }
        if (block.getBlock() == Blocks.BIRCH_LOG) {
            for (int ax = 0; ax < 7; ax++) {
                for (int az = 0; az < 7; az++) {
                    for (int y = 0; y < 50; y++) {
                        BlockPos aPos = new BlockPos(pos.getX() + a[ax], pos.getY() + y, pos.getZ() + a[az]);
                        if (worldIn.getBlockState(aPos).getBlock() == block && modeInt(stack) == 1) {
                            worldIn.destroyBlock(aPos, true);
                        }
                    }
                }
            }
        }
        if (block.getBlock() == Blocks.OAK_LOG) {
            for (int ax = 0; ax < 7; ax++) {
                for (int az = 0; az < 7; az++) {
                    for (int y = 0; y < 50; y++) {
                        BlockPos aPos = new BlockPos(pos.getX() + a[ax], pos.getY() + y, pos.getZ() + a[az]);
                        if (worldIn.getBlockState(aPos).getBlock() == block && modeInt(stack) == 1) {
                            worldIn.destroyBlock(aPos, true);
                        }
                    }
                }
            }
        }
        if (block.getBlock() == Blocks.SPRUCE_LOG) {
            for (int ax = 0; ax < 7; ax++) {
                for (int az = 0; az < 7; az++) {
                    for (int y = 0; y < 50; y++) {
                        BlockPos aPos = new BlockPos(pos.getX() + a[ax], pos.getY() + y, pos.getZ() + a[az]);
                        if (worldIn.getBlockState(aPos).getBlock() == block && modeInt(stack) == 1) {
                            worldIn.destroyBlock(aPos, true);
                        }
                    }
                }
            }
        }
        if (block.getBlock() == Blocks.JUNGLE_LOG) {
            for (int ax = 0; ax < 7; ax++) {
                for (int az = 0; az < 7; az++) {
                    for (int y = 0; y < 50; y++) {
                        BlockPos aPos = new BlockPos(pos.getX() + a[ax], pos.getY() + y, pos.getZ() + a[az]);
                        if (worldIn.getBlockState(aPos).getBlock() == block && modeInt(stack) == 1) {
                            worldIn.destroyBlock(aPos, true);
                        }
                    }
                }
            }
        }
        if (block.getBlock() == Blocks.DARK_OAK_LOG) {
            for (int ax = 0; ax < 7; ax++) {
                for (int az = 0; az < 7; az++) {
                    for (int y = 0; y < 50; y++) {
                        BlockPos aPos = new BlockPos(pos.getX() + a[ax], pos.getY() + y, pos.getZ() + a[az]);
                        if (worldIn.getBlockState(aPos).getBlock() == block && modeInt(stack) == 1) {
                            worldIn.destroyBlock(aPos, true);
                        }
                    }
                }
            }
        }
        stack.damageItem(1, entityLiving, (entity) -> {
            entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    public float getDestroySpeed(ItemStack stack, BlockState state) {

        switch (modeInt(stack)) {
            case 0: return 12F;
            case 1: return 36F;
        }
        return 0;
    }

    public void modeChange(ItemStack stack) {
        if (stack.getTag() == null) {
            stack.setTag(new CompoundNBT());
        }

        stack.getTag().putInt("mode", modeInt(stack) < 1 ? modeInt(stack) + 1 : 0 );
    }

    public int modeInt(ItemStack stack) {
        if (stack.getTag() == null) {
            return 0;
        }
        return stack.getTag().getInt("mode");
    }

    public String modeName(ItemStack stack) {
        switch (modeInt(stack)) {
            case 0: return "Normal";
            case 1: return "Efficient Mining Mode";
        }
        return null;
    }

    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(modeName(stack)));
    }
}
