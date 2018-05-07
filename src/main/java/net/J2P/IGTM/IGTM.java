package net.J2P.IGTM;

import net.J2P.IGTM.block.ModBlocks;
import net.J2P.IGTM.item.ModItems;
import net.J2P.IGTM.proxy.CommonProxy;
import net.J2P.IGTM.tab.IGTMCreativeTab;
import net.J2P.IGTM.utils.StringNames;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = StringNames.MODID, version = StringNames.VERSION, name = StringNames.NAME)
public class IGTM
{
    @SidedProxy(clientSide = "net.J2P.IGTM.proxy.ClientProxy", serverSide = "net.J2P.IGTM.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static IGTM instance;

    public static IGTMCreativeTab igtmTab;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        igtmTab = new IGTMCreativeTab(CreativeTabs.getNextID(), "tab_mailbox");

        ModItems.preInit();
        ModBlocks.preInit();

        proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){

        proxy.init(event);

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

        proxy.postInit(event);
    }
}
