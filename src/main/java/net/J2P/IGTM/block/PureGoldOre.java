package net.J2P.IGTM.block;

import net.J2P.IGTM.core.CoinOreBase;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PureGoldOre extends CoinOreBase {

    public PureGoldOre(Material material, String name)
    {
        super(material, name);
        this.setResistance(15F);
        this.setHardness(15F);
        this.setHarvestLevel("pickaxe", 3); // 3 = DIAMOND

    }

//    @Override
//    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
//        super.onBlockClicked(worldIn, pos, playerIn);
//
//        worldIn.spawnParticle(EnumParticleTypes.CRIT, pos.getX(), pos.getY(), pos.getZ(), 1, 1, 1);
//
//    }
}
