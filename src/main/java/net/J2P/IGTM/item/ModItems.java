package net.J2P.IGTM.item;

import net.J2P.IGTM.utils.StringNames;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = StringNames.MODID)
public class ModItems {

    ///// DECLARATION ITEMS
    public static Item gold_coin;
    public static Item silver_coin;
    public static Item copper_coin;

    static Item[] items;

    ///////////////////////////////

    public static void init(){

        gold_coin = new GoldCoin(StringNames.GOLD_COIN);
        silver_coin = new SilverCoin(StringNames.SILVER_COIN);
        copper_coin = new CopperCoin(StringNames.COPPER_COIN);

        items = new Item[]{gold_coin, silver_coin, copper_coin};
    }

    // Enregistrer les textures de TOUS les items
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent e){

        for (Item i : items)
            registerModel(i);
    }

    // Enregistrer la texture d'UN SEUL item
    public static void registerModel(Item i){

        ModelLoader.setCustomModelResourceLocation(i, 0, new ModelResourceLocation(new ResourceLocation(StringNames.MODID, i.getUnlocalizedName().substring(5)), "inventory"));
    }

    public static Item[] getItems()
    {
        return items;
    }

}
