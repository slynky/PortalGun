package com.mod.portalgun.registry;

import net.minecraftforge.eventbus.api.IEventBus;

public class ModRegistries {

    public static void registrarTudo(IEventBus bus) {
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModCreativeModeTabs.TABS.register(bus);
    }
}
