package net.J2P.IGTM.core;

import net.J2P.IGTM.IGTM;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public abstract class CoinOreBase extends Block {

    public CoinOreBase(Material material, String name){
        super(material);

        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(IGTM.igtmTab);

    }

}
