package com.mod.portalgun;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
@Mod("portalgun")
public class PortalGun {
    public static final String MODID = "portalgun";
    private static final Logger LOGGER = LogUtils.getLogger();

    // REGISTROS
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // -------------------------
    // BLOCOS
    // -------------------------
    public static final RegistryObject<Block> URANIUM_BLOCK = registerBlock("uranium_block", MapColor.COLOR_LIGHT_GREEN);
    public static final RegistryObject<Block> URANIUM_ORE_BLOCK = registerBlock("uranium_ore_block", MapColor.COLOR_LIGHT_GREEN);
    public static final RegistryObject<Block> POLYMERSUBSTRATE_BLOCK = registerBlock("polymersubstrate_block", MapColor.COLOR_LIGHT_GRAY);
    public static final RegistryObject<Block> COPPERWIRE_BLOCK = registerBlock("copperwire_block", MapColor.COLOR_ORANGE);
    public static final RegistryObject<Block> RADIATIVEFUEL_BLOCK = registerBlock("radiativefuel_block", MapColor.COLOR_RED);

    private static RegistryObject<Block> registerBlock(String name, MapColor color) {
        return BLOCKS.register(name, () ->
                new Block(BlockBehaviour.Properties.of().setId(BLOCKS.key(name)).mapColor(color)));
    }

    // -------------------------
    // ITENS DE BLOCO
    // -------------------------
    public static final RegistryObject<Item> URANIUM_BLOCK_ITEM = registerBlockItem("uranium_block", URANIUM_BLOCK);
    public static final RegistryObject<Item> URANIUM_ORE_BLOCK_ITEM = registerBlockItem("uranium_ore_block", URANIUM_ORE_BLOCK);
    public static final RegistryObject<Item> POLYMERSUBSTRATE_BLOCK_ITEM = registerBlockItem("polymersubstrate_block", POLYMERSUBSTRATE_BLOCK);
    public static final RegistryObject<Item> COPPERWIRE_BLOCK_ITEM = registerBlockItem("copperwire_block", COPPERWIRE_BLOCK);
    public static final RegistryObject<Item> RADIATIVEFUEL_BLOCK_ITEM = registerBlockItem("radiativefuel_block", RADIATIVEFUEL_BLOCK);

    private static RegistryObject<Item> registerBlockItem(String name, RegistryObject<Block> bloco) {
        return ITEMS.register(name, () -> new BlockItem(bloco.get(), new Item.Properties().setId(ITEMS.key(name))));
    }

    // -------------------------
    // ITENS SIMPLES
    // -------------------------
    public static final RegistryObject<Item> POLYMERSUBSTRATE_ITEM = registerItem("polymersubstrate_item");
    public static final RegistryObject<Item> PORTALGUN_ITEM = registerItem("portalgun_item");
    public static final RegistryObject<Item> COPPER_INGOT_ITEM = registerItem("copper_ingot_item");
    public static final RegistryObject<Item> URANIUM_INGOT_ITEM = registerItem("uranium_ingot_item");
    public static final RegistryObject<Item> URANIUM_ORE_ITEM = registerItem("uranium_ore_item");
    public static final RegistryObject<Item> PORTALGUNCORE_ITEM = registerItem("portalguncore_item");
    public static final RegistryObject<Item> PORTALGUNSHELL_ITEM = registerItem("portalgunshell_item");
    public static final RegistryObject<Item> MAGNETICFIELDGEN_ITEM = registerItem("magneticfieldgen_item");
    public static final RegistryObject<Item> GRAPHENECOIL_ITEM = registerItem("graphenecoil_item");
    public static final RegistryObject<Item> TUNGESTEN_INGOT_ITEM = registerItem("tungesten_ingot_item");
    public static final RegistryObject<Item> TUNGESTEN_ORE_ITEM = registerItem("tungesten_ore_item");
    public static final RegistryObject<Item> TUNGESTENCOATING_ITEM = registerItem("tungestencoating_item");
    public static final RegistryObject<Item> RADIATIVEFUEL_ITEM = registerItem("radiativefuel_item");

    private static RegistryObject<Item> registerItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().setId(ITEMS.key(name))));
    }

    // -------------------------
    // FERRAMENTAS E MÁQUINAS
    // -------------------------
    public static final RegistryObject<Item> HAMMER_ITEM = registerItem("hammer_item");
    public static final RegistryObject<Item> COMPRESSIONMACHINE_ITEM = registerItem("compressionmachine_item");

    // -------------------------
    // ABA CRIATIVA PERSONALIZADA
    // -------------------------
    public static final RegistryObject<CreativeModeTab> PORTALGUN_TAB = CREATIVE_MODE_TABS.register("portal_gun", () ->
            CreativeModeTab.builder()
                    .withTabsBefore(CreativeModeTabs.INVENTORY)
                    .icon(() -> PORTALGUN_ITEM.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(PORTALGUN_ITEM.get());
                        output.accept(PORTALGUNCORE_ITEM.get());
                        output.accept(PORTALGUNSHELL_ITEM.get());
                        output.accept(MAGNETICFIELDGEN_ITEM.get());
                        output.accept(GRAPHENECOIL_ITEM.get());

                        output.accept(URANIUM_INGOT_ITEM.get());
                        output.accept(URANIUM_ORE_ITEM.get());
                        output.accept(URANIUM_ORE_BLOCK_ITEM.get());
                        output.accept(URANIUM_BLOCK_ITEM.get());

                        output.accept(COPPER_INGOT_ITEM.get());
                        output.accept(COPPERWIRE_BLOCK_ITEM.get());

                        output.accept(TUNGESTEN_INGOT_ITEM.get());
                        output.accept(TUNGESTEN_ORE_ITEM.get());
                        output.accept(TUNGESTENCOATING_ITEM.get());

                        output.accept(POLYMERSUBSTRATE_ITEM.get());
                        output.accept(POLYMERSUBSTRATE_BLOCK_ITEM.get());

                        output.accept(RADIATIVEFUEL_ITEM.get());
                        output.accept(RADIATIVEFUEL_BLOCK_ITEM.get());

                        output.accept(HAMMER_ITEM.get());
                        output.accept(COMPRESSIONMACHINE_ITEM.get());
                    })
                    .build()
    );

    // -------------------------
    // CONSTRUTOR DO MOD
    // -------------------------
    public PortalGun(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    // -------------------------
    // EVENTOS
    // -------------------------
    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);
        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(URANIUM_BLOCK_ITEM);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
