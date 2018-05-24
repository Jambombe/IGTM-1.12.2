package net.J2P.IGTM.block;

import net.J2P.IGTM.core.CoinOreBase;
import net.minecraft.block.material.Material;

public class PureGoldOre extends CoinOreBase {

    public PureGoldOre(Material material, String name)
    {
        super(material, name);
        this.setResistance(15F);
        this.setHardness(15F);
        this.setHarvestLevel("pickaxe", 3); // 3 = DIAMOND

    }

}
