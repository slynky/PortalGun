package com.mod.portalgun.registry;

import com.mod.portalgun.PortalGun;
import com.mod.portalgun.item.UraniumIngotItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PortalGun.MODID);

    public static final RegistryObject<Item> URANIUM_INGOT =
            ITEMS.register("uranium_ingot", UraniumIngotItem::new);
}
