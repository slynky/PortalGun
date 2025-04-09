package com.mod.portalgun.registry;

import com.mod.portalgun.PortalGun;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PortalGun.MODID);

    public static final RegistryObject<CreativeModeTab> PORTALGUN_TAB =
            TABS.register("portalgun_tab", () -> CreativeModeTab.builder()
                    .title(Component.literal("Portal Gun"))
                    .icon(() -> new ItemStack(ModItems.URANIUM_INGOT.get())) // ícone da aba
                    .build());

    public static final ResourceKey<CreativeModeTab> PORTALGUN_TAB_KEY =
            ResourceKey.create(Registries.CREATIVE_MODE_TAB,
                    ResourceLocation.fromNamespaceAndPath(PortalGun.MODID, "portalgun_tab"));

}
