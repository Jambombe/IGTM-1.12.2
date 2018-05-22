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
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = StringNames.MODID)
public class ModBlocks {

    public static Block exchanger;
    public static Block gold_coin_ore;

    static Block[] blocks;

    public static void init(){

        exchanger = new Exchanger(Material.IRON, StringNames.EXCHANGER);
        gold_coin_ore = new GoldCoinOre(Material.ROCK, StringNames.GOLD_COIN_ORE);

        blocks = new Block[]{exchanger, gold_coin_ore};

        registerBlocks();
    }

    public static void registerBlocks(){
//        registerBlock(mail_box, StringNames.MAIL_BOX);
//        blocks.forEach(block -> registerBlock(block));
        for (Block b : blocks)
            registerBlock(b);
    }

    public static void registerBlock(Block b){
        GameRegistry.findRegistry(Block.class).register(b);
//        GameRegistry.findRegistry(Block.class).register(new ItemBlock(b));
    }

    // Enregistrer les textures de TOUS les blocks
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent e){
        for (Block b : blocks)
            registerModel(b);
    }

    // Enregistrer la texture d'UN SEUL block
    public static void registerModel(Block b){

        ItemBlock ib = new ItemBlock(b);
        ib.setRegistryName(b.getRegistryName());

        GameRegistry.findRegistry(Item.class).register(ib);

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(b), 0, new ModelResourceLocation(new ResourceLocation(StringNames.MODID, b.getUnlocalizedName().substring(5)), "inventory"));
    }

    public static Block[] getBlocks(){
        return blocks;
    }

}
