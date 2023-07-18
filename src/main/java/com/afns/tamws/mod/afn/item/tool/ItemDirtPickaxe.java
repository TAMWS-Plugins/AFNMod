package com.afns.tamws.mod.afn.item.tool;

import com.afns.tamws.mod.afn.keybind.AFNKeyBind;
import com.afns.tamws.mod.afn.main.AFNMod;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemDirtPickaxe extends PickaxeItem {

    public ItemDirtPickaxe() {
        super(AFNTierList.DIRT, 1, -2.8F, new Properties().group(AFNMod.AFNModTab.AFNMODTOOLS_TAB).rarity(Rarity.RARE).isImmuneToFire());
        this.setRegistryName("dirt_pickaxe");
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

    public float getDestroySpeed(ItemStack stack, BlockState state) {

        switch (modeInt(stack)) {
            case 0: return 12F;
            case 1: return 45F;
        }
        return 0;
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
