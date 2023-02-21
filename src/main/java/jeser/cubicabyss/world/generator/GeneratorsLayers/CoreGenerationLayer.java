package jeser.cubicabyss.world.generator.GeneratorsLayers;

import FastNoise.FastNoiseLite;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

public class CoreGenerationLayer implements IGenerationLayer {
    private FastNoiseLite noise;

    public CoreGenerationLayer(long seed) {
        noise = new FastNoiseLite();
        noise.SetSeed((int) seed);
        noise.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise.SetFractalOctaves(1);
    }

    @Override
    public IBlockState getBlock(int x, int y, int z, float distanse, IBlockState block) {
        if (noise.GetNoise(x * 3, y * 2, z * 3) > distanse)
            return Blocks.STONE.getDefaultState();
        return null;
    }
}
