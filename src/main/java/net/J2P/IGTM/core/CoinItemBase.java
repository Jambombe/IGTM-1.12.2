package net.J2P.IGTM.core;

import net.J2P.IGTM.IGTM;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public abstract class CoinItemBase extends Item {

    public CoinItemBase(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(IGTM.igtmTab);
        this.setMaxStackSize(50);

    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public int getCoinCountFromInventory(EntityPlayer player, Item coinType) {

        int nbCoins = 0;

        for (int slot = 0; slot < player.inventory.getSizeInventory(); slot++) {
            ItemStack stack = player.inventory.getStackInSlot(slot);

            if (stack != null && ((stack.getUnlocalizedName()).equals(new ItemStack(coinType).getUnlocalizedName()))) {
                nbCoins += stack.getCount();
            }
        }
        System.out.println(nbCoins);
        return nbCoins;
    }

    // Tant qu'il rest des pièce à supprimer

    /**
     * Supprime nbCoinsToRemove pièces de type coinsType de l'inventaire du joueur player
     * @param player Player auquel supprimer les pièces
     * @param coinsType Type de pièces à supprimer
     * @param nbCoinsToRemove Nombre de pièces à supprimer
     */
    public void removeNbCoinsFromInventory(EntityPlayer player, Item coinsType, int nbCoinsToRemove) {
        int numSlot = 0;

        while (nbCoinsToRemove > 0 && numSlot <= player.inventory.getSizeInventory()){

            ItemStack stack = player.inventory.getStackInSlot(numSlot);

            if (stack != null && ((stack.getUnlocalizedName()).equals(new ItemStack(coinsType).getUnlocalizedName()))) {

                if (stack.getCount() <= nbCoinsToRemove) {
                    player.inventory.setInventorySlotContents(numSlot, new ItemStack(Item.getItemById(0)));
                    nbCoinsToRemove -= stack.getCount();
                } else {
                    player.inventory.setInventorySlotContents(numSlot, new ItemStack(coinsType, stack.getCount() - nbCoinsToRemove));
                    nbCoinsToRemove -= stack.getCount(); // coinsToRemainingToRemove FORCEMENT = 0
                }
            }
            numSlot++;
        }
    }

//    @Override
//    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
//
//        if (! worldIn.isRemote){
//
//            player.sendMessage(new TextComponentString("onItemUse : "+player.getHeldItem(EnumHand.MAIN_HAND)));
//            Block blockClicked = worldIn.getBlockState(pos).getBlock();
//
//            if (blockClicked instanceof Exchanger){
//                player.sendMessage(new TextComponentString("onItemUse : " + player.getHeldItem(hand)));
//
//
//            }
//
//
//        }
//
//
//
//        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
//    }
}
