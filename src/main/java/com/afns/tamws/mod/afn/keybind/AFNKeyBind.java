package com.afns.tamws.mod.afn.keybind;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.awt.event.KeyEvent;

@OnlyIn(Dist.CLIENT)
public class AFNKeyBind {

    public static KeyBinding[] afnKey;

    public static void register(final FMLClientSetupEvent event) {
        afnKey = new KeyBinding[2];

        afnKey[0] = crate("boost", KeyEvent.VK_B);
        afnKey[1] = crate("mode", KeyEvent.VK_M);

        for (int a = 0; a < afnKey.length; a++) {
            ClientRegistry.registerKeyBinding(afnKey[a]);
        }
    }

    private static KeyBinding crate(String name, int key) {
        return new KeyBinding("key.afnmod." + name, key, "key.category.afnmod");
    }
}
