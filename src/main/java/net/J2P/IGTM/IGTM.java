package net.J2P.IGTM;

import net.J2P.IGTM.block.ModBlocks;
import net.J2P.IGTM.event.FirstJoinEvent;
import net.J2P.IGTM.event.MobDropEvent;
import net.J2P.IGTM.event.RegisteringEvent;
import net.J2P.IGTM.gen.CoinOreGenerator;
import net.J2P.IGTM.item.ModItems;
import net.J2P.IGTM.proxy.CommonProxy;
import net.J2P.IGTM.recipes.ModRecipes;
import net.J2P.IGTM.tab.IGTMCreativeTab;
import net.J2P.IGTM.utils.StringNames;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = StringNames.MODID, version = StringNames.VERSION, name = StringNames.NAME)
public class IGTM
{
    @SidedProxy(clientSide = StringNames.CLIENT_PROXY, serverSide = StringNames.SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.Instance(StringNames.MODID)
    public static IGTM instance;

    public IGTM()
    {
        MinecraftForge.EVENT_BUS.register(new RegisteringEvent());
    }

    public static IGTMCreativeTab igtmTab;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        igtmTab = new IGTMCreativeTab(CreativeTabs.getNextID(), "tab_igtm");

        proxy.preInit();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){

        proxy.init();

        // Enregistrement des event
        MinecraftForge.EVENT_BUS.register(new MobDropEvent());
        MinecraftForge.EVENT_BUS.register(new FirstJoinEvent());

        GameRegistry.registerWorldGenerator(new CoinOreGenerator(), 0);
        ModRecipes.registerAllRecipes();

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

        proxy.postInit();
    }
}
