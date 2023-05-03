package com.afns.tamws.mod.afn.item.tool;

import com.afns.tamws.mod.afn.regi.AFNModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum AFNTierList implements IItemTier {

    DIRT(3, 2031, 12F, 4F, 22, () -> {return Ingredient.fromItems(AFNModItems.DIRT_INGOT);}),
    CHEAT(4, -1, 45F, 0F, 22, () -> {return Ingredient.fromItems(AFNModItems.DIRT_INGOT);});

    private final int maxUses, harvestLevel, enchantability;
    private final float efficiency, attackDamage;
    private final LazyValue<Ingredient> repairMaterial;

    private AFNTierList(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
    }

    public int getMaxUses() {
        return this.maxUses;
    }

    public float getEfficiency() {
        return this.efficiency;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}
