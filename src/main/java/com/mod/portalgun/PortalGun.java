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

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    // REGISTROS DE BLOCOS
    public static final RegistryObject<Block> URANIUM_BLOCK = BLOCKS.register("uranium_block", () ->
            new Block(BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("uranium_block"))
                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
            )
    );

    public static final RegistryObject<Block> URANIUM_ORE_BLOCK = BLOCKS.register("uranium_ore_block", () ->
            new Block(BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("uranium_ore_block"))
                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
            )
    );

    public static final RegistryObject<Block> POLYMERSUBSTRATE_BLOCK = BLOCKS.register("polymersubstrate_block", () ->
            new Block(BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("polymersubstrate_block"))
                    .mapColor(MapColor.COLOR_LIGHT_GRAY)
            )
    );

    public static final RegistryObject<Block> COPPERWIRE_BLOCK = BLOCKS.register("copperwire_block", () ->
            new Block(BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("copperwire_block"))
                    .mapColor(MapColor.COLOR_ORANGE)
            )
    );

    public static final RegistryObject<Block> RADIATIVEFUEL_BLOCK = BLOCKS.register("radiativefuel_block", () ->
            new Block(BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("radiativefuel_block"))
                    .mapColor(MapColor.COLOR_RED)
            )
    );

    // REGISTROS DE BLOCOS ITEMS
    public static final RegistryObject<Item> URANIUM_BLOCK_ITEM = ITEMS.register("uranium_block",
            () -> new BlockItem(URANIUM_BLOCK.get(), new Item.Properties().setId(ITEMS.key("uranium_block")))
    );

    public static final RegistryObject<Item> URANIUM_ORE_BLOCK_ITEM = ITEMS.register("uranium_ore_block",
            () -> new BlockItem(URANIUM_ORE_BLOCK.get(), new Item.Properties().setId(ITEMS.key("uranium_ore_block")))
    );

    public static final RegistryObject<Item> POLYMERSUBSTRATE_BLOCK_ITEM = ITEMS.register("polymersubstrate_block",
            () -> new BlockItem(POLYMERSUBSTRATE_BLOCK.get(), new Item.Properties().setId(ITEMS.key("polymersubstrate_block")))
    );

    public static final RegistryObject<Item> COPPERWIRE_BLOCK_ITEM = ITEMS.register("copperwire_block",
            () -> new BlockItem(COPPERWIRE_BLOCK.get(), new Item.Properties().setId(ITEMS.key("copperwire_block")))
    );

    public static final RegistryObject<Item> RADIATIVEFUEL_BLOCK_ITEM = ITEMS.register("radiativefuel_block",
            () -> new BlockItem(COPPERWIRE_BLOCK.get(), new Item.Properties().setId(ITEMS.key("radiativefuel_block")))
    );


    //REGISTROS DE ITEMS

    public static final RegistryObject<Item> POLYMERSUBSTRATE_ITEM = ITEMS.register("polymersubstrate_item",
            () -> new Item(new Item.Properties().setId(ITEMS.key("polymersubstrate_item")))
    );

    public static final RegistryObject<Item> PORTALGUN_ITEM = ITEMS.register("portalgun_item",
            () -> new Item(new Item.Properties().setId(ITEMS.key("portalgun_item")))
    );

    public static final RegistryObject<Item> COPPER_INGOT_ITEM = ITEMS.register("copper_ingot_block",
            () -> new Item( new Item.Properties().setId(ITEMS.key("copper_ingot_block")))
    );


    public static final RegistryObject<Item> URANIUM_INGOT_ITEM = ITEMS.register("uranium_ingot_item",
            () -> new Item(new Item.Properties().setId(ITEMS.key("uranium_ingot_item")))
    );

    public static final RegistryObject<Item> URANIUM_ORE_ITEM = ITEMS.register("uranium_ore_item",
            () -> new Item(new Item.Properties().setId(ITEMS.key("uranium_ore_item")))
    );

    public static final RegistryObject<Item> PORTALGUNCORE_ITEM = ITEMS.register("portalguncore_item",
            () -> new Item(new Item.Properties().setId(ITEMS.key("portalguncore_item")))
    );

    public static final RegistryObject<Item> PORTALGUNSHELL_ITEM = ITEMS.register("portalgunshell_item",
            () -> new Item(new Item.Properties().setId(ITEMS.key("portalgunshell_item")))
    );

    public static final RegistryObject<Item> MAGNETICFIELDGEN_ITEM = ITEMS.register("magneticfieldgen_item",
            () -> new Item(new Item.Properties().setId(ITEMS.key("magneticfieldgen_item")))
    );

    public static final RegistryObject<Item> GRAPHENECOIL_ITEM = ITEMS.register("graphenecoil_item",
            () -> new Item(new Item.Properties().setId(ITEMS.key("graphenecoil_item")))
    );

    public static final RegistryObject<Item> TUNGESTEN_INGOT_ITEM = ITEMS.register("tungesten_ingot_item",
            () -> new Item(new Item.Properties().setId(ITEMS.key("tungesten_ingot_item")))
    );

    public static final RegistryObject<Item> TUNGESTEN_ORE_ITEM = ITEMS.register("tungesten_ore_item",
            () -> new Item(new Item.Properties().setId(ITEMS.key("tungesten_ore_item")))
    );

    public static final RegistryObject<Item> TUNGESTENCOATING_ITEM = ITEMS.register("tungestencoating_item",
            () -> new Item(new Item.Properties().setId(ITEMS.key("tungestencoating_item")))
    );

    public static final RegistryObject<Item> RADIATIVEFUEL_ITEM = ITEMS.register("radiativefuel_item",
            () -> new Item(new Item.Properties().setId(ITEMS.key("radiativefuel_item")))
    );

    public static final RegistryObject<Item> HAMMER_ITEM = ITEMS.register("hammer_item",
            () -> new Item(new Item.Properties().setId(ITEMS.key("hammer_item")))
    );

    public static final RegistryObject<Item> COMPRESSIONMACHINE_ITEM = ITEMS.register("compressionmachine_item",
            () -> new Item(new Item.Properties().setId(ITEMS.key("compressionmachine_item")))
    );






    // REGISTROS DE ABAS DO CREATIVO
    public static final RegistryObject<CreativeModeTab> PORTALGUN_TAB = CREATIVE_MODE_TABS.register("portal_gun", () ->
            CreativeModeTab.builder()
                    .withTabsBefore(CreativeModeTabs.INVENTORY)
                    .icon(() -> PORTALGUN_ITEM.get().getDefaultInstance()) // ícone da aba
                    .displayItems((parameters, output) -> {
                        //relacionados portalgun
                        output.accept(PORTALGUN_ITEM.get());
                        output.accept(PORTALGUNCORE_ITEM.get());
                        output.accept(PORTALGUNSHELL_ITEM.get());
                        output.accept(MAGNETICFIELDGEN_ITEM.get());
                        output.accept(GRAPHENECOIL_ITEM.get());
                        //relacionados uranio
                        output.accept(URANIUM_INGOT_ITEM.get());
                        output.accept(URANIUM_ORE_ITEM.get());
                        output.accept(URANIUM_ORE_BLOCK_ITEM.get()); // cuidado: esse item precisa estar registrado, senão dá erro
                        output.accept(URANIUM_BLOCK_ITEM.get());     // idem acima
                        //relacionados cobre
                        output.accept(COPPER_INGOT_ITEM.get());
                        output.accept(COPPERWIRE_BLOCK_ITEM.get());
                        //relacionados tungestenio
                        output.accept(TUNGESTEN_INGOT_ITEM.get());
                        output.accept(TUNGESTEN_ORE_ITEM.get());
                        output.accept(TUNGESTENCOATING_ITEM.get());
                        //relacionados substrato de polimero
                        output.accept(POLYMERSUBSTRATE_BLOCK_ITEM.get());
                        output.accept(POLYMERSUBSTRATE_ITEM.get());
                        //relacionados combustivel radioativo
                        output.accept(RADIATIVEFUEL_BLOCK_ITEM.get());
                        output.accept(RADIATIVEFUEL_ITEM.get());
                        //martelo
                        output.accept(HAMMER_ITEM.get());
                        //Maquinas
                        output.accept(COMPRESSIONMACHINE_ITEM.get());
                    })
                    .build()
    );




    //Construtor do MOD
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
