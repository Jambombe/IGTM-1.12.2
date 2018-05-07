package net.J2P.IGTM.item;

import net.J2P.IGTM.block.Exchanger;
import net.J2P.IGTM.core.CoinItemBase;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CopperCoin extends CoinItemBase {

    public CopperCoin(String name){
        super(name);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (! worldIn.isRemote){

            Block blockClicked = worldIn.getBlockState(pos).getBlock();

            if (blockClicked instanceof Exchanger){

                if (! player.isSneaking())
                {
                    int nbCoins = getCoinCountFromInventory(player, ModItems.copper_coin);

                    // Si le joueur a suffisement de pièce, on fait l'échange
                    if (nbCoins >= 100){

                        removeNboinsFromInventory(player, ModItems.copper_coin, 100);
                        player.addItemStackToInventory(new ItemStack(ModItems.silver_coin));
                    }
                    return EnumActionResult.SUCCESS;
                }
            }
        }
        return EnumActionResult.PASS;
    }

}
