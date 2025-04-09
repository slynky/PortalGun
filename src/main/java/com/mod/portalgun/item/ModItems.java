package com.mod.portalgun.item;

import com.mod.portalgun.PortalGun;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PortalGun.MODID);

    public static final RegistryObject<Item> URANIUM = ITEMS.register("uranium",
            () -> new Item(new Item.Properties()));

    public static void registrar(IEventBus bus) {
        ITEMS.register(bus);
    }
}
