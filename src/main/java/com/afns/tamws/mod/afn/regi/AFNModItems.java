package com.afns.tamws.mod.afn.regi;

import com.afns.tamws.mod.afn.item.DirtBow;
import com.afns.tamws.mod.afn.item.ItemDirtIngot;
import com.afns.tamws.mod.afn.item.ItemDirtMeat;
import com.afns.tamws.mod.afn.item.armor.ItemDirtBoots;
import com.afns.tamws.mod.afn.item.armor.ItemDirtChestplate;
import com.afns.tamws.mod.afn.item.armor.ItemDirtHelmet;
import com.afns.tamws.mod.afn.item.armor.ItemDirtLeggings;
import com.afns.tamws.mod.afn.item.tool.ItemDirtAxe;
import com.afns.tamws.mod.afn.item.tool.ItemDirtPickaxe;
import com.afns.tamws.mod.afn.item.tool.ItemDirtShovel;
import com.afns.tamws.mod.afn.item.tool.ItemDirtSword;
import com.afns.tamws.mod.afn.item.tool.cheat.ItemCheatSword;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("afnmod")
public class AFNModItems {

    public static final ItemDirtIngot DIRT_INGOT = new ItemDirtIngot();
    public static final ItemDirtSword DIRT_SWORD = new ItemDirtSword();
    public static final DirtBow DIRT_BOW = new DirtBow();

    /** Armors **/
    public static final ItemDirtHelmet DIRT_HELMET = new ItemDirtHelmet();
    public static final ItemDirtChestplate DIRT_CHESTPLATE = new ItemDirtChestplate();
    public static final ItemDirtLeggings DIRT_LEGGINGS = new ItemDirtLeggings();
    public static final ItemDirtBoots DIRT_BOOTS = new ItemDirtBoots();


    @Mod.EventBusSubscriber(modid = "afnmod", bus = Bus.MOD)
    public static class Register {

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {

            final Item[] item = {
                    DIRT_INGOT,
                    DIRT_SWORD,
                    DIRT_HELMET,
                    DIRT_CHESTPLATE,
                    DIRT_LEGGINGS,
                    DIRT_BOOTS,
                    DIRT_BOW,
                    new ItemDirtMeat(),
                    new ItemCheatSword(),
                    new ItemDirtPickaxe(),
                    new ItemDirtAxe(),
                    new ItemDirtShovel()
            };

            event.getRegistry().registerAll(item);
        }
    }
}
