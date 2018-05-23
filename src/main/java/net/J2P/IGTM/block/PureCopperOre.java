package net.J2P.IGTM.block;

import net.J2P.IGTM.core.CoinOreBase;
import net.minecraft.block.material.Material;

public class PureCopperOre extends CoinOreBase {

    public PureCopperOre(Material material, String name)
    {
        super(material, name);
        this.setResistance(15F); // Resistance explosion
        this.setHardness(4F); // Dureté (impact sur la durée de minage)
        this.setHarvestLevel("pickaxe", 2); // 2 = IRON
    }
}
