package net.J2P.IGTM.gen;

import net.J2P.IGTM.block.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

// La chance correspond à la quantité de bloc par chunk (presque 100% sûr)
// blockCount = "numberOfBlocks" (nbBlocks par filon ?)

public class CoinOreGenerator implements IWorldGenerator {

    private WorldGenerator pureGoldOreGen;
    private WorldGenerator pureSilverOreGen;
    private WorldGenerator pureCopperOreGen;

    public CoinOreGenerator()
    {
        pureGoldOreGen = new WorldGenMinable(ModBlocks.pure_gold_ore.getDefaultState(), 1);
        pureSilverOreGen = new WorldGenMinable(ModBlocks.pure_silver_ore.getDefaultState(), 3);
        pureCopperOreGen = new WorldGenMinable(ModBlocks.pure_copper_ore.getDefaultState(), 9);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.getDimension())
        {
            case 0:
                runGenerator(pureCopperOreGen, world, random, chunkX, chunkZ, 10, 0, 32);
                runGenerator(pureSilverOreGen, world, random, chunkX, chunkZ, 5, 0, 16);
                runGenerator(pureGoldOreGen, world, random, chunkX, chunkZ, 1, 0, 11);
                break;
        }
    }

    private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int nbBlockByChunk, int minHeight, int maxHeight)
    {
        if (minHeight > maxHeight || minHeight < 0 || maxHeight > 256)
        {
            System.out.println("ERROR : Ore generated out of bounds");
        }
         else
        {
            int heightDiff = maxHeight - minHeight +1;

            for (int i = 0; i < nbBlockByChunk; i++)
            {
                int x = chunkX *16 + rand.nextInt(16);
                int y = minHeight + rand.nextInt(heightDiff);
                int z = chunkZ * 16 + rand.nextInt(16);

                gen.generate(world, rand, new BlockPos(x, y, z));
            }
        }
    }
}
