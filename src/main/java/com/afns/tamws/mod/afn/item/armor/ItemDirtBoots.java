package com.afns.tamws.mod.afn.item.armor;

import com.afns.tamws.mod.afn.main.AFNMod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Rarity;

public class ItemDirtBoots extends ArmorItem {

    public ItemDirtBoots() {
        super(AFNArmorMaterials.DIRT, EquipmentSlotType.FEET, new Properties().group(AFNMod.AFNModTab.AFNMODARMOR_TAB).rarity(Rarity.EPIC).isImmuneToFire());
        this.setRegistryName("dirt_boots");
    }
}
