package com.mod.portalgun.creative;

import com.mod.portalgun.PortalGun;
import com.mod.portalgun.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PortalGun.MODID);


    // -------------------------
    // ABA CRIATIVA PERSONALIZADA
    // -------------------------
    public static final RegistryObject<CreativeModeTab> PORTALGUN_TAB = CREATIVE_MODE_TABS.register("portal_gun", () ->
            CreativeModeTab.builder()
                    .withTabsBefore(CreativeModeTabs.INVENTORY)
                    .icon(() -> ModItems.PORTALGUN_ITEM.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.PORTALGUN_ITEM.get());
                        output.accept(ModItems.PORTALGUNCORE_ITEM.get());
                        output.accept(ModItems.PORTALGUNSHELL_ITEM.get());
                        output.accept(ModItems.MAGNETICFIELDGEN_ITEM.get());
                        output.accept(ModItems.GRAPHENECOIL_ITEM.get());

                        output.accept(ModItems.URANIUM_INGOT_ITEM.get());
                        output.accept(ModItems.URANIUM_ORE_ITEM.get());
                        output.accept(ModItems.URANIUM_ORE_BLOCK_ITEM.get());
                        output.accept(ModItems.URANIUM_BLOCK_ITEM.get());

                        output.accept(ModItems.COPPER_INGOT_ITEM.get());
                        output.accept(ModItems.COPPERWIRE_BLOCK_ITEM.get());

                        output.accept(ModItems.TUNGESTEN_INGOT_ITEM.get());
                        output.accept(ModItems.TUNGESTEN_ORE_ITEM.get());
                        output.accept(ModItems.TUNGESTENCOATING_ITEM.get());

                        output.accept(ModItems.POLYMERSUBSTRATE_ITEM.get());
                        output.accept(ModItems.POLYMERSUBSTRATE_BLOCK_ITEM.get());

                        output.accept(ModItems.RADIATIVEFUEL_ITEM.get());
                        output.accept(ModItems.RADIATIVEFUEL_BLOCK_ITEM.get());

                        output.accept(ModItems.HAMMER_ITEM.get());
                        output.accept(ModItems.COMPRESSIONMACHINE_ITEM.get());
                    })
                    .build()
    );
}
