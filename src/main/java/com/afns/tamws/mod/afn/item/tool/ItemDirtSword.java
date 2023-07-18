package com.afns.tamws.mod.afn.item.tool;

import com.afns.tamws.mod.afn.main.AFNMod;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemDirtSword extends SwordItem {

    public ItemDirtSword() {
        super(AFNTierList.DIRT, 5, -2.4F, new Properties().group(AFNMod.AFNModTab.AFNMODTOOLS_TAB).rarity(Rarity.RARE).isImmuneToFire());
        this.setRegistryName("dirt_sword");
    }

    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        target.setMotion(target.getMotion().add(0.0D, (double)0.6F, 0.0D));

        stack.damageItem(1, attacker, (entity) -> {
            entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent(this.getTranslationKey() + ".desc").mergeStyle(TextFormatting.GRAY));
    }
}
