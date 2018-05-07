package net.J2P.IGTM.block;

import net.J2P.IGTM.IGTM;
import net.J2P.IGTM.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;

public class Exchanger extends Block {

    public Exchanger(Material material, String name){
        super(material);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(IGTM.igtmTab);
        this.setBlockUnbreakable();
    }

    // CLIC DROIT
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
//        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
        if (! worldIn.isRemote){
            playerIn.sendMessage(new TextComponentString("hasItemStack : " + playerIn.inventory.hasItemStack(new ItemStack(ModItems.gold_coin))));
            playerIn.sendMessage(new TextComponentString("item dans la main : " + playerIn.getHeldItem(hand).getUnlocalizedName()));


            if(playerIn.getHeldItem(hand).equals(new ItemStack(ModItems.gold_coin))){
                playerIn.sendMessage(new TextComponentString("Pièce d'or"));
            }
            if(playerIn.getHeldItem(hand).equals(ModItems.silver_coin)){
                playerIn.sendMessage(new TextComponentString("Pièce d'argent"));
            }
            if(playerIn.getHeldItem(hand).equals(ModItems.copper_coin)){
                playerIn.sendMessage(new TextComponentString("Pièce de cuivre"));
            }


            playerIn.sendMessage(new TextComponentString("CLIC"));
            return true;
        }
        return false;
    }
}
