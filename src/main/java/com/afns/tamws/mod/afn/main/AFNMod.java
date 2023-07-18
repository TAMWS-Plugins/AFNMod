package com.afns.tamws.mod.afn.main;

import com.afns.tamws.mod.afn.entity.AFNEntityTypes;
import com.afns.tamws.mod.afn.regi.*;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("afnmod")
public class AFNMod {

    public static class AFNModTab {
        public static final ItemGroup AFNMOD_TAB = new AFNModTabs.AFNModTab();
        public static final ItemGroup AFNMODBLOCK_TAB = new AFNModTabs.AFNModBlockTab();
        public static final ItemGroup AFNMODTOOLS_TAB = new AFNModTabs.AFNModToolsTab();
        public static final ItemGroup AFNMODCHEAT_TAB = new AFNModTabs.AFNModCheatTab();
        public static final ItemGroup AFNMODARMOR_TAB = new AFNModTabs.AFNModArmorTab();
    }

    public AFNMod() {
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, AFNModOreGeneration::oreGen);
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        AFNEntityTypes.REGISTER.register(bus);
    }
}
