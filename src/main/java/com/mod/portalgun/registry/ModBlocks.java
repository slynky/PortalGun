package com.mod.portalgun.registry;

import com.mod.portalgun.PortalGun;
import com.mod.portalgun.block.UraniumBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PortalGun.MODID);

    public static final RegistryObject<Block> URANIUM_BLOCK =
            BLOCKS.register("uranium_block", UraniumBlock::new);
}
