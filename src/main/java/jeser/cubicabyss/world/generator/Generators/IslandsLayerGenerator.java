package jeser.cubicabyss.world.generator.Generators;

import FastNoise.FastNoiseLite;
import jeser.cubicabyss.world.biomes.AbyssBiome;
import jeser.cubicabyss.world.biomes.BiomeSelector;
import jeser.cubicabyss.world.generator.AbyssWorldGenerator;
import net.minecraft.block.state.IBlockState;

import java.util.Random;

public class IslandsLayerGenerator implements IGenerationLayer {
    private static final float scaleXZ1 = 3;
    private static final float scaleY1 = 6;
    private static final float scaleXZ2 = 3;
    private static final float scaleY2 = 7;
    private static final float distanceModifier = 1.2f;
    private final FastNoiseLite noise1;
    private final FastNoiseLite noise2;
    Random r;
    private BiomeSelector biomeSelector;

    public IslandsLayerGenerator(long seed) {
        noise1 = new FastNoiseLite();
        noise1.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise1.SetSeed((int) seed);
        noise2 = new FastNoiseLite();
        noise2.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        noise2.SetSeed((int) (seed + 1));
        r = new Random();
        biomeSelector = new BiomeSelector(seed);
    }

    @Override
    public IBlockState getState(int x, int y, int z, float distance, IBlockState state) {
        AbyssBiome biome = biomeSelector.getBiome(x, y, z);
        float valueForCompare = getValueForCompare(distance);
        if (getNoiseValue(x, y, z) > valueForCompare)
            if (getNoiseValue(x, y + 1, z) <= valueForCompare)
                return biome.Ground;
            else
                return biome.Basis;
        else if (getNoiseValue(x, y - 1, z) > valueForCompare)
            if (r.nextDouble() < biome.GrassChance)
                return biome.Grass[r.nextInt(biome.Grass.length)];
            else
                return null;
        else
            return null;
    }

    public float getNoiseValue(int x, int y, int z) {
        return
                noise1.GetNoise(x * scaleXZ1, y * scaleY1, z * scaleXZ1)
                        + noise2.GetNoise(x * scaleXZ2, y * scaleY2, z * scaleXZ2);
    }

    public float getValueForCompare(float distance) {
        return 1 - (distance * distanceModifier) / AbyssWorldGenerator.RADIUS;
    }
}
