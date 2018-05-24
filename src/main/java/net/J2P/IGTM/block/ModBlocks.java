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

    public static Block pure_gold_ore;
    public static Block pure_silver_ore;
    public static Block pure_copper_ore;

    static Block[] blocks;

    public static void init(){

        exchanger = new Exchanger(Material.IRON, StringNames.EXCHANGER);

        pure_gold_ore = new PureGoldOre(Material.ROCK, StringNames.PURE_GOLD_ORE);
        pure_silver_ore = new PureSilverOre(Material.ROCK, StringNames.PURE_SILVER_ORE);
        pure_copper_ore = new PureCopperOre(Material.ROCK, StringNames.PURE_COPPER_ORE);


        blocks = new Block[]{exchanger,
                                pure_gold_ore,
                                pure_silver_ore,
                                pure_copper_ore};

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

//        ItemBlock ib = new ItemBlock(b);
//        ib.setRegistryName(b.getRegistryName());
//
//        GameRegistry.findRegistry(Item.class).register(ib);

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(b), 0, new ModelResourceLocation(new ResourceLocation(StringNames.MODID, b.getUnlocalizedName().substring(5)), "inventory"));
    }

    // Return le tableau de block
    public static Block[] getBlocks(){
        return blocks;
    }

    // Return le tableau d'ItemBlock à partir des Blocks
    public static ItemBlock[] getItemBlocks()
    {
        ItemBlock[] ib = new ItemBlock[blocks.length];
        for (int i = 0; i<blocks.length; i++)
        {
            Block b = blocks[i];
            ItemBlock item = new ItemBlock(b);
            item.setRegistryName(b.getRegistryName());
            ib[i] = item;
        }

        return ib;
    }

}
