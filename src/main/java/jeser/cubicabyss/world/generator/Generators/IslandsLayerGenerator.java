package jeser.cubicabyss.world.generator.Generators;

import FastNoise.FastNoiseLite;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

public class IslandsLayerGenerator implements IGenerationLayer {
    FastNoiseLite noise;

    public IslandsLayerGenerator(long seed) {
        noise = new FastNoiseLite();
        noise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise.SetSeed((int) seed);
    }

    @Override
    public IBlockState getState(int x, int y, int z, float distance, IBlockState state) {
        if (noise.GetNoise(x * 2, y * 3, z * 2) < distance)
            return Blocks.STONE.getDefaultState();
        else
            return null;
    }
}
