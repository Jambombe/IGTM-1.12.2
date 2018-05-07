package net.J2P.IGTM.block;

import net.J2P.IGTM.utils.StringNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Arrays;
import java.util.List;

//@Mod.EventBusSubscriber(modid = StringNames.MODID)
public class ModBlocks {

    public static Block exchanger;

    static List<Block> blocks;

    public static void preInit(){

        exchanger = new Exchanger(Material.IRON, StringNames.EXCHANGER);

        blocks = Arrays.asList(exchanger);

        registerBlocks();
    }

    public static void registerBlocks(){
//        registerBlock(mail_box, StringNames.MAIL_BOX);
        blocks.forEach(block -> registerBlock(block));
    }

    public static void registerBlock(Block b){
        GameRegistry.findRegistry(Block.class).register(b);
//        GameRegistry.findRegistry(Block.class).register(new ItemBlock(b));
    }

    // Enregistrer les textures de TOUS les blocks
//    @SubscribeEvent
//    @SideOnly(Side.CLIENT)
    public static void registerRenders(ModelRegistryEvent e){
        blocks.forEach(block -> registerRender(block));
    }

    // Enregistrer la texture d'UN SEUL block
    public static void registerRender(Block b){

        ItemBlock ib = new ItemBlock(b);
        ib.setRegistryName(b.getRegistryName());

        GameRegistry.findRegistry(Item.class).register(ib);

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(b), 0, new ModelResourceLocation(new ResourceLocation(StringNames.MODID, b.getUnlocalizedName().substring(5)), "inventory"));



//        Item i = Item.getItemFromBlock(b);
//
//        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(i, 0, new ModelResourceLocation(StringNames.MODID+":"+i.getUnlocalizedName().substring(5), "inventory"));
//        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(i, 0, new ModelResourceLocation(b.getRegistryName(), "inventory"));
    }

}
