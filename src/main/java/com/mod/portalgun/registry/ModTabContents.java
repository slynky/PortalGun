package com.mod.portalgun.registry;

import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "portalgun", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModTabContents {

    @SubscribeEvent
    public static void onBuildTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(ModCreativeModeTabs.PORTALGUN_TAB_KEY)) {
            event.accept(ModItems.URANIUM_INGOT.get());
        }
    }
}
