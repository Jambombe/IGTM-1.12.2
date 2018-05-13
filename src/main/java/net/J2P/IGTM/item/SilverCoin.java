package net.J2P.IGTM.item;

import net.J2P.IGTM.block.Exchanger;
import net.J2P.IGTM.core.CoinItemBase;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SilverCoin extends CoinItemBase {

    public SilverCoin(String name){
        super(name);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (! worldIn.isRemote){

            Block blockClicked = worldIn.getBlockState(pos).getBlock();

            if (blockClicked instanceof Exchanger){

                ///////////////////
                // Silver -->> Gold
                if (! player.isSneaking())
                {
                    int nbCoins = getCoinCountFromInventory(player, ModItems.silver_coin);

                    // Si le joueur a suffisement de pièce, on fait l'échange
                    if (nbCoins >= 100){

                        removeNbCoinsFromInventory(player, ModItems.silver_coin, 100);
                        player.addItemStackToInventory(new ItemStack(ModItems.gold_coin));
                    }
                    return EnumActionResult.SUCCESS;

                ////////////////////
                // Gold -->> Silver
                } else {

                    ItemStack stack = player.getHeldItem(hand);
                    player.setHeldItem(hand, new ItemStack(ModItems.silver_coin, stack.getCount()-1));

                    // Si le joueur n'a pas de place dans l'inventaire, les pièces sont perdues
//                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.silver_coin, 50));
//                    player.inventory.addItemStackToInventory(new ItemStack(ModItems.silver_coin, 50));

                    // Mieux ! :)
                    EntityItem items = new EntityItem(worldIn, pos.getX()+(facing.getFrontOffsetX()/2), pos.getY()+(facing.getFrontOffsetY()/2), pos.getZ()+(facing.getFrontOffsetZ()/2), new ItemStack(ModItems.copper_coin, 50));
                    EntityItem items2 = new EntityItem(worldIn, pos.getX()+(facing.getFrontOffsetX()/2), pos.getY()+(facing.getFrontOffsetY()/2), pos.getZ()+(facing.getFrontOffsetZ()/2), new ItemStack(ModItems.copper_coin, 50));
                    worldIn.spawnEntity(items);
                    worldIn.spawnEntity(items2);
                }
            }
        }
        return EnumActionResult.PASS;
    }

}
