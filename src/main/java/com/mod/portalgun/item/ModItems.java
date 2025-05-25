package com.mod.portalgun.item;

import com.mod.portalgun.block.ModBlocks;
import com.mod.portalgun.PortalGun;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PortalGun.MODID);




    private static RegistryObject<Item> registerBlockItem(String name, RegistryObject<Block> bloco) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(bloco.get(), new Item.Properties().setId(ModItems.ITEMS.key(name))));
    }

    private static RegistryObject<Item> registerItem(String name) {
        return ModItems.ITEMS.register(name, () -> new Item(new Item.Properties().setId(ModItems.ITEMS.key(name))));
    }

    // -------------------------
    // ITENS SIMPLES
    // -------------------------
    public static final RegistryObject<Item> POLYMERSUBSTRATE_ITEM = registerItem("polymersubstrate");
    public static final RegistryObject<Item> PORTALGUN_ITEM = registerItem("portalgun");
    public static final RegistryObject<Item> COPPER_INGOT_ITEM = registerItem("copper_ingot");
    public static final RegistryObject<Item> URANIUM_INGOT_ITEM = registerItem("uranium_ingot");
    public static final RegistryObject<Item> URANIUM_ORE_ITEM = registerItem("uranium_ore");
    public static final RegistryObject<Item> PORTALGUNCORE_ITEM = registerItem("portalguncore");
    public static final RegistryObject<Item> PORTALGUNSHELL_ITEM = registerItem("portalgunshell");
    public static final RegistryObject<Item> MAGNETICFIELDGEN_ITEM = registerItem("magneticfieldgen");
    public static final RegistryObject<Item> GRAPHENECOIL_ITEM = registerItem("graphenecoil");
    public static final RegistryObject<Item> TUNGESTEN_INGOT_ITEM = registerItem("tungesten_ingot");
    public static final RegistryObject<Item> TUNGESTEN_ORE_ITEM = registerItem("tungesten_ore");
    public static final RegistryObject<Item> TUNGESTENCOATING_ITEM = registerItem("tungestencoating");
    public static final RegistryObject<Item> RADIATIVEFUEL_ITEM = registerItem("radiativefuel");



    // -------------------------
    // FERRAMENTAS E MÁQUINAS
    // -------------------------
    public static final RegistryObject<Item> HAMMER_ITEM = registerItem("hammer");
    public static final RegistryObject<Item> COMPRESSIONMACHINE_ITEM = registerItem("compressionmachine");
}
