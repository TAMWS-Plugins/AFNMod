package com.afns.tamws.mod.afn.item;

import com.afns.tamws.mod.afn.main.AFNMod;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemDirtMeat extends Item {

    public ItemDirtMeat() {
        super(new Properties().group(AFNMod.AFNModTab.AFNMOD_TAB)
                .food(new Food.Builder()
                        .hunger(36)
                        .saturation(1.6F)
                        .meat()
                        .effect(new EffectInstance(Effects.BLINDNESS, 200, 4), 1F)
                        .effect(new EffectInstance(Effects.INSTANT_HEALTH, 200, 36), 1F)
                        .build()));
        this.setRegistryName("dirt_meat");
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent(this.getTranslationKey() + ".desc").mergeStyle(TextFormatting.GRAY));
    }
}
