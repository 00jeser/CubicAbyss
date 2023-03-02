package jeser.cubicabyss.world.generator.Generators;

import FastNoise.FastNoiseLite;
import jeser.cubicabyss.world.biomes.AbyssBiome;
import jeser.cubicabyss.world.biomes.BiomeSelector;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import java.util.Random;

public class LightStoneLayerGenerator implements IGenerationLayer {
    private static final float scale = 20;
    private final FastNoiseLite noise1;
    Random r;
    BiomeSelector biomes;

    public LightStoneLayerGenerator(long seed) {
        noise1 = new FastNoiseLite();
        noise1.SetNoiseType(FastNoiseLite.NoiseType.Value);
        noise1.SetFractalType(FastNoiseLite.FractalType.FBm);
        noise1.SetFractalOctaves(2);
        noise1.SetSeed((int) seed);
        r = new Random();
        biomes = new BiomeSelector(seed);
    }

    @Override
    public IBlockState getState(int x, int y, int z, float distance, IBlockState state) {
        AbyssBiome b = biomes.getBiome(x, y, z);
        if (state != null && state == b.Basis && noise1.GetNoise(x * scale, y * scale, z * scale) < -0.5f)
            return Blocks.GLOWSTONE.getDefaultState();
        return state;
    }
}
