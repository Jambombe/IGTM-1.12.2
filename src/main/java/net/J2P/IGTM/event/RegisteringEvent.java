package net.J2P.IGTM.event;

import net.J2P.IGTM.block.ModBlocks;
import net.J2P.IGTM.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RegisteringEvent
{
    @SubscribeEvent
    public void onItemRegister(RegistryEvent.Register<Item> e)
    {
        ModItems.init();
        e.getRegistry().registerAll(ModItems.getItems());
    }

    @SubscribeEvent
    public void onBlockRegister(RegistryEvent.Register<Block> e)
    {
        ModBlocks.init();
        e.getRegistry().registerAll(ModBlocks.getBlocks());
    }

}
