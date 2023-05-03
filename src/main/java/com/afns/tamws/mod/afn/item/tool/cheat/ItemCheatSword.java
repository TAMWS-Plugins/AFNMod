package com.afns.tamws.mod.afn.item.tool.cheat;

import com.afns.tamws.mod.afn.item.tool.AFNTierList;
import com.afns.tamws.mod.afn.main.AFNMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class ItemCheatSword extends SwordItem {

    public ItemCheatSword() {
        super(AFNTierList.DIRT, 95, -2.4F, new Properties().group(AFNMod.AFNMODCHEAT_TAB).rarity(Rarity.RARE).isImmuneToFire());
        this.setRegistryName("cheat_sword");
    }

    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        target.setMotion(target.getMotion().add(0.0D, (double)0.6F, 0.0D));

        return true;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        ItemStack itemStack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);

        Vector3d vector3d = playerIn.getLook(1.0F);
        FireballEntity fireballentity = new FireballEntity(worldIn, playerIn, vector3d.x, vector3d.y, vector3d.z);
        fireballentity.setPosition(playerIn.getPosX() + vector3d.x, playerIn.getPosY() + 1, playerIn.getPosZ() + vector3d.z);
        fireballentity.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0F, 3F, 0F);
        worldIn.addEntity(fireballentity);

        return ActionResult.resultConsume(itemStack);
    }
}
