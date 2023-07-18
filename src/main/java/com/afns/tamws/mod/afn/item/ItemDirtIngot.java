package com.afns.tamws.mod.afn.item;

import com.afns.tamws.mod.afn.main.AFNMod;
import net.minecraft.item.Item;

public class ItemDirtIngot extends Item {

    public ItemDirtIngot() {
        super(new Properties().group(AFNMod.AFNModTab.AFNMOD_TAB).isImmuneToFire());
        this.setRegistryName("dirt_ingot");
    }
}
