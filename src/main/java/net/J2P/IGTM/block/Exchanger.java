package net.J2P.IGTM.block;

import net.J2P.IGTM.IGTM;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class Exchanger extends Block {

    public Exchanger(Material material, String name){
        super(material);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(IGTM.igtmTab);
        this.setBlockUnbreakable();
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        if (! worldIn.isRemote)
            playerIn.sendMessage(new TextComponentString("Type /igtm exchanger to get help"));
    }

    // CLIC DROIT
//    @Override
//    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
////        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
//        if (! worldIn.isRemote){
//            playerIn.sendMessage(new TextComponentString("hasItemStack : " + playerIn.inventory.hasItemStack(new ItemStack(ModItems.gold_coin))));
//            playerIn.sendMessage(new TextComponentString("item dans la main : " + playerIn.getHeldItem(hand).getUnlocalizedName()));
//            playerIn.sendMessage(new TextComponentString("item dans la main : " + playerIn.getHeldItem(hand).getUnlocalizedName()));
//            playerIn.sendMessage(new TextComponentString("new itemStack : " + new ItemStack(ModItems.gold_coin).getUnlocalizedName()));
//            playerIn.sendMessage(new TextComponentString("main click : " + hand.toString()));
//            playerIn.sendMessage(new TextComponentString("main hand : " + playerIn.getHeldItem(EnumHand.MAIN_HAND)));
//
//            if(playerIn.getHeldItem(EnumHand.MAIN_HAND).equals(new ItemStack(ModItems.gold_coin))){
//                playerIn.sendMessage(new TextComponentString("Pièce d'or"));
//            }
//            if(playerIn.getHeldItem(hand).equals(ModItems.silver_coin)){
//                playerIn.sendMessage(new TextComponentString("Pièce d'argent"));
//            }
//            if(playerIn.getHeldItem(hand).equals(ModItems.copper_coin)){
//                playerIn.sendMessage(new TextComponentString("Pièce de cuivre"));
//            }
//
//
//            playerIn.sendMessage(new TextComponentString("CLIC"));
//            return true;
//        }
//        return false;
//    }
}
