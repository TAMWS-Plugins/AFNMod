package com.afns.tamws.mod.afn.item.armor;

import com.afns.tamws.mod.afn.keybind.AFNKeyBind;
import com.afns.tamws.mod.afn.main.AFNMod;
import com.afns.tamws.mod.afn.regi.AFNModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemDirtChestplate extends ArmorItem {

    public static int set;

    public ItemDirtChestplate() {
        super(AFNArmorMaterials.DIRT, EquipmentSlotType.CHEST, new Properties().group(AFNMod.AFNMODARMOR_TAB).rarity(Rarity.EPIC).isImmuneToFire());
        this.setRegistryName("dirt_chestplate");
    }

    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {

        double a[] = {-0.9,-0.6,-0.3,0.3,0.6,0.9};
        double b[] = {0.1,0.2,0.3};
        Vector3d vector3d = player.getLook(1);

        if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == AFNModItems.DIRT_HELMET
        && player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == AFNModItems.DIRT_CHESTPLATE
        && player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == AFNModItems.DIRT_LEGGINGS
        && player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == AFNModItems.DIRT_BOOTS) {
            if (player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == AFNModItems.DIRT_CHESTPLATE && AFNKeyBind.afnKey[0].isKeyDown())
                modeChange(stack);

            set = 1;
            player.fallDistance = 0;

            if (modeInt(stack) == 1) {
                world.addParticle(ParticleTypes.FLAME, player.getPosX() + a[random.nextInt(6)], player.getPosY(), player.getPosZ() + a[random.nextInt(6)], vector3d.x * -0.15, b[random.nextInt(3)], vector3d.z * -0.15);
                if (AFNKeyBind.afnKey[0].isKeyDown()) {
                    world.createExplosion(player, player.getPosX(), player.getPosY() - 1, player.getPosZ(), 3F, false, Explosion.Mode.NONE);
                    player.setMotion(vector3d.x * 3, vector3d.y * 3, vector3d.z * 3);
                }
            }

        } else {
            set = 0;
        }
    }

    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        if (set == 1 && modeInt(stack) == 1) {
            return true;
        } else {return false;}
    }

    public boolean elytraFlightTick(ItemStack stack, net.minecraft.entity.LivingEntity entity, int flightTicks) {
        if (modeInt(stack) == 1) {
            return true;
        } else {
            return false;
        }
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

    public String modeName(ItemStack stack) {
        switch (modeInt(stack)) {
            case 0: return "Normal";
            case 1: return "GOD Mode";
        }
        return null;
    }

    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent(modeName(stack)));
    }
}
