package com.afns.tamws.mod.afn.item.armor;

import com.afns.tamws.mod.afn.main.AFNMod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Rarity;

public class ItemDirtLeggings extends ArmorItem {

    public ItemDirtLeggings() {
        super(AFNArmorMaterials.DIRT, EquipmentSlotType.LEGS, new Properties().group(AFNMod.AFNMODARMOR_TAB).rarity(Rarity.EPIC).isImmuneToFire());
        this.setRegistryName("dirt_leggings");
    }
}
