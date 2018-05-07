package net.J2P.IGTM.tab;

import net.J2P.IGTM.item.GoldCoin;
import net.J2P.IGTM.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class IGTMCreativeTab extends CreativeTabs {

    public IGTMCreativeTab(int index, String label) {
        super(index, label);
    }

    // Item affiché en tant qu'icon du Creative tab
    @Override
    public ItemStack getTabIconItem() {
        ItemStack i = new ItemStack(ModItems.gold_coin);
        return i;
    }


}
