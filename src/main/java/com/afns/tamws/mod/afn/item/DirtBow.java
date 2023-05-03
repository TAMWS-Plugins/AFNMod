package com.afns.tamws.mod.afn.item;

import com.afns.tamws.mod.afn.entity.DirtArrowEntity;
import com.afns.tamws.mod.afn.main.AFNMod;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;

import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class DirtBow extends BowItem {

    public DirtBow() {
        super(new Properties().group(AFNMod.AFNMODTOOLS_TAB).rarity(Rarity.EPIC).maxDamage(2031).isImmuneToFire());
        this.setRegistryName("dirt_bow");
    }

    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity)entityLiving;
            ItemStack itemstack = Items.AIR.getDefaultInstance();

            int i = this.getUseDuration(stack) - timeLeft;
            if (i < 0) return;

            float f = getArrowVelocity(i);
            if (!((double)f < 0.1D)) {
                if (!worldIn.isRemote) {
                    AbstractArrowEntity abstractarrowentity = new DirtArrowEntity(worldIn, entityLiving, itemstack);
                    abstractarrowentity = customArrow(abstractarrowentity);
                    abstractarrowentity.func_234612_a_(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, f * 3.5F, 0.0F);
                    if (f == 1.0F) {
                        abstractarrowentity.setIsCritical(true);
                    }

                    int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
                    if (j > 0) {
                        abstractarrowentity.setDamage(abstractarrowentity.getDamage() + (double) j * 0.5D + 0.5D);
                    }

                    int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
                    if (k > 0) {
                        abstractarrowentity.setKnockbackStrength(k);
                    }

                    if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
                        abstractarrowentity.setFire(100);
                    }

                    stack.damageItem(1, playerentity, (p_220009_1_) -> {
                        p_220009_1_.sendBreakAnimation(playerentity.getActiveHand());
                    });

                    worldIn.addEntity(abstractarrowentity);
                }

                worldIn.playSound(null, playerentity.getPosX(), playerentity.getPosY(), playerentity.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                playerentity.addStat(Stats.ITEM_USED.get(this));
            }
        }
    }

    public static float getArrowVelocity(int charge) {
        float f = (float)charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    public int getUseDuration(ItemStack stack) {
        return 72000;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        return ActionResult.resultConsume(itemstack);

    }

    public boolean hasEffect(ItemStack stack) {
        return stack.isEnchanted();
    }

    public int func_230305_d_() {
        return 15;
    }
}