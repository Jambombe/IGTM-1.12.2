package net.J2P.IGTM.core;

import net.J2P.IGTM.IGTM;
import net.minecraft.item.Item;

public abstract class CoinItemBase extends Item {

    public CoinItemBase(String name){
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(IGTM.igtmTab);
        this.setMaxStackSize(50);
    }

}
