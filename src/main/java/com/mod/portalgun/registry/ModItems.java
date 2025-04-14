package com.mod.portalgun.registry;

import com.mod.portalgun.PortalGun;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final RegistryObject<Item> URANIUM_ITEM = PortalGun.ITEMS.register("uranium_ingot",
            () -> new Item(new Item.Properties()
                    .setId(PortalGun.ITEMS.key("uranium_ingot")))
    );



    public static void registrar(IEventBus bus) {
        PortalGun.ITEMS.register(bus);
    }

}
