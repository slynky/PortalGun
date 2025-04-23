package com.mod.portalgun.block;

import com.mod.portalgun.PortalGun;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    // REGISTROS
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PortalGun.MODID);

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
}
