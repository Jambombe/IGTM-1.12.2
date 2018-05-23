package net.J2P.IGTM.block;

import net.J2P.IGTM.core.CoinOreBase;
import net.minecraft.block.material.Material;

public class PureSilverOre extends CoinOreBase {

    public PureSilverOre(Material material, String name)
    {
        super(material, name);
        this.setResistance(15F);
        this.setHardness(6F);
        this.setHarvestLevel("pickaxe", 2); // 2 = IRON
    }


}
