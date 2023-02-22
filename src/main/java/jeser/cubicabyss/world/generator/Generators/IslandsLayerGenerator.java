package jeser.cubicabyss.world.generator.Generators;

import FastNoise.FastNoiseLite;
import jeser.cubicabyss.world.generator.AbyssWorldGenerator;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import java.util.Random;

public class IslandsLayerGenerator implements IGenerationLayer {
    FastNoiseLite noise1;
    FastNoiseLite noise2;
    Random r;

    public IslandsLayerGenerator(long seed) {
        noise1 = new FastNoiseLite();
        noise1.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise1.SetSeed((int) seed);
        noise2 = new FastNoiseLite();
        noise2.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise2.SetSeed((int) (seed + 1));
        r = new Random();
    }

    @Override
    public IBlockState getState(int x, int y, int z, float distance, IBlockState state) {
        float valueForCompare = 1 - (distance * 1.2f) / AbyssWorldGenerator.RADIUS;
        if (getNoiseValue(x, y, z) > valueForCompare)
            if (getNoiseValue(x, y + 1, z) <= valueForCompare)
                return Blocks.GRASS.getDefaultState();
            else
                return Blocks.STONE.getDefaultState();
        else if (getNoiseValue(x, y - 1, z) > valueForCompare)
            switch (r.nextInt() % 10) {
                case 0:
                case 1:
                    return Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS);
                case 2:
                    return Blocks.RED_FLOWER.getDefaultState();
                default:
                    return null;
            }
        else
            return null;
    }

    private float getNoiseValue(int x, int y, int z) {
        return noise1.GetNoise(x * 3, y * 6, z * 3) + noise2.GetNoise(x * 3, y * 7, z * 3);
    }
}
