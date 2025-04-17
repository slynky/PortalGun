package com.mod.portalgun;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
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

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<Block> URANIUM_BLOCK = BLOCKS.register("uranium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("uranium_block"))
                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
            )
    );

    public static final RegistryObject<Block> URANIUMORE_BLOCK = BLOCKS.register("uraniumore_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("uraniumore_block"))
                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
            )
    );

    public static final RegistryObject<Block> COPPERWIRE_BLOCK = BLOCKS.register("copperwire_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("copperwire_block"))
                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
            )
    );

    public static final RegistryObject<Item> URANIUM_BLOCK_ITEM = ITEMS.register("uranium_block",
            () -> new BlockItem(URANIUM_BLOCK.get(), new Item.Properties().setId(ITEMS.key("uranium_block")))
    );

    public static final RegistryObject<Item> URANIUMORE_BLOCK_ITEM = ITEMS.register("uraniumore_block",
            () -> new BlockItem(URANIUM_BLOCK.get(), new Item.Properties().setId(ITEMS.key("uraniumore_block")))
    );

    public static final RegistryObject<Item> COPPERWIRE_BLOCK_ITEM = ITEMS.register("copperwire_block",
            () -> new BlockItem(URANIUM_BLOCK.get(), new Item.Properties().setId(ITEMS.key("copperwire_block")))
    );

    public static final RegistryObject<Item>URANIUM_ITEM = ITEMS.register("uranium_item",
            () -> new Item(new Item.Properties()
                    .setId(ITEMS.key("uranium_item"))
            )
    );

    public static final RegistryObject<Item>URANIUMORE_ITEM = ITEMS.register("uraniumore_item",
            () -> new Item(new Item.Properties()
                    .setId(ITEMS.key("uraniumore_item"))
            )
    );

    public static final RegistryObject<CreativeModeTab> PORTALGUN_TAB = CREATIVE_MODE_TABS.register("Portal_Gun", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.INVENTORY)
            .icon(() -> URANIUM_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(URANIUM_ITEM.get());
            }).build());

    public PortalGun(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(URANIUM_BLOCK_ITEM);
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
