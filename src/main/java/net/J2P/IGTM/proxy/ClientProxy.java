package net.J2P.IGTM.proxy;

import net.J2P.IGTM.block.ModBlocks;
import net.J2P.IGTM.item.ModItems;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{

    @Override
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Override
    public void init(FMLInitializationEvent event) {
        ModItems.registerRenders();

        ModelRegistryEvent e = new ModelRegistryEvent();
        ModBlocks.registerRenders(e);

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
