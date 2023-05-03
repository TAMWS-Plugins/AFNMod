package com.afns.tamws.mod.afn.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class DirtArrowEntity extends AbstractArrowEntity {

    private ItemStack arrowStack = new ItemStack(Items.ARROW);

    public DirtArrowEntity(EntityType<? extends DirtArrowEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public DirtArrowEntity(World world, LivingEntity entity, ItemStack stack) {
        super(AFNEntityTypes.DIRT_ARROW.get(), entity, world);
        arrowStack = stack;
    }

    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public ItemStack getArrowStack() {
        return arrowStack;
    }
}
