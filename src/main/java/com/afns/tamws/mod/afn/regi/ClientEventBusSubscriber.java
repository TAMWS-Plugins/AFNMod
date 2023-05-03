package com.afns.tamws.mod.afn.regi;

import com.afns.tamws.mod.afn.entity.AFNEntityTypes;
import com.afns.tamws.mod.afn.entity.render.DirtArrowRenderer;
import com.afns.tamws.mod.afn.keybind.AFNKeyBind;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = "afnmod", bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        AFNKeyBind.register(event);

        ItemModelsProperties.registerProperty(AFNModItems.DIRT_BOW, new ResourceLocation("pulling"),
                (itemstack, world, entity) -> entity != null && entity.isHandActive() && entity.getActiveItemStack() == itemstack ? 1.0F : 0.0F);

        itemModelsProperties();
        renderRegister();
    }

    private static void itemModelsProperties() {
        ItemModelsProperties.registerProperty(AFNModItems.DIRT_BOW, new ResourceLocation("pull"), (itemstack, world, entity) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItemStack() != itemstack ? 0.0F : (float) (itemstack.getUseDuration()-entity.getItemInUseCount()) / 20F;
            }
        });
    }

    private static void renderRegister() {
        RenderingRegistry.registerEntityRenderingHandler(AFNEntityTypes.DIRT_ARROW.get(), DirtArrowRenderer::new);
    }
}
