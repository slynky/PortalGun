package com.mod.portalgun;

import com.mod.portalgun.item.ModItems;
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

// O valor aqui deve corresponder a uma entrada no arquivo META-INF/mods.toml
@Mod("portalgun")
public class PortalGun {
    // Definição do ID do mod para referencia em todo o codigo
    public static final String MODID = "PortalGun";

    // Referência direta para um logger SLF4J
    private static final Logger LOGGER = LogUtils.getLogger();

    // Criando um registro diferido para armazenar blocos que serao registrados sob o namespace "PortalGun"
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);



    // Criando um registro diferido para armazenar abas do modo criativo sob o namespace "Portalgun"
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Criando um novo bloco com o ID "Portalgun:example_block"
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
            )
    );

    // Criando um novo item de bloco com o ID "PortalGun:example_block"
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ModItems.ITEMS.register("example_block",
            () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties())
    );

    // Criando um novo item alimenticio com o ID "PortalGun:example_item", com nutricao 1 e saturacao 2
    public static final RegistryObject<Item> EXAMPLE_ITEM = ModItems.ITEMS.register("example_item",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .alwaysEdible()
                            .nutrition(1)
                            .saturationModifier(2f)
                            .build()
                    )
            )
    );

    // Criando uma aba criativa com o ID "PortalGun:example_tab" para o item de exemplo, colocada apos a aba de combate
    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(EXAMPLE_ITEM.get()); // Adiciona o item de exemplo à aba
            }).build());

    public PortalGun(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // Registrar o metodo commonSetup para carregamento do mod
        modEventBus.addListener(this::commonSetup);

        // Registrar os registros diferidos no evento do mod para que os blocos sejam registrados
        BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        // Registrar para eventos do servidor e outros eventos do jogo
        MinecraftForge.EVENT_BUS.register(this);

        // Registrar o item na aba criativa
        modEventBus.addListener(this::addCreative);

        // Registrar a configuração do mod para que o Forge possa criar e carregar o arquivo de configuração
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Codigo de configuração comum
        LOGGER.info("OLA DO COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("BLOCO DE TERRA >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Adicionando o item de bloco de exemplo a aba de blocos de construcao
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(EXAMPLE_BLOCK_ITEM);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Acao ao iniciar o servidor
        LOGGER.info("OLA DO INÍCIO DO SERVIDOR");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Codigo de configuracao do cliente
            LOGGER.info("OLA DO CLIENT SETUP");
            LOGGER.info("NOME DO MINECRAFT >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
