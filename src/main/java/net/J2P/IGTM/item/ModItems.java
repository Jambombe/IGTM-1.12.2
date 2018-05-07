package net.J2P.IGTM.item;

import net.J2P.IGTM.utils.StringNames;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;
import java.util.List;

public class ModItems {

    public static Item gold_coin;
    public static Item silver_coin;
    public static Item copper_coin;

    static List<Item> items;

    public static void preInit(){

        gold_coin = new GoldCoin(StringNames.GOLD_COIN);
        silver_coin = new SilverCoin(StringNames.SILVER_COIN);
        copper_coin = new CopperCoin(StringNames.COPPER_COIN);

        items = Arrays.asList(gold_coin, silver_coin, copper_coin);
        registerItems();
    }

    public static void registerItems(){

        items.forEach(item->registerItem(item));

    }

    static void registerItem(Item item){

        GameRegistry.findRegistry(Item.class).register(item);
    }

    // Enregistrer les textures de TOUS les items
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerRenders(){
        items.forEach(item->registerRender(item));
    }

    // Enregistrer la texture d'UN SEUL item
    public static void registerRender(Item i){
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(i, 0, new ModelResourceLocation(StringNames.MODID+":"+i.getUnlocalizedName().substring(5), "inventory"));
    }

}
