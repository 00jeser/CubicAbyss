package jeser.cubicabyss.world.biomes;

import FastNoise.FastNoiseLite;

import java.util.Random;

public class BiomeSelector {
    FastNoiseLite temperature;
    FastNoiseLite humidity;

    public BiomeSelector(long seed) {
        Random r = new Random(seed);
        temperature = new FastNoiseLite();
        temperature.SetSeed(r.nextInt());
        temperature.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
        temperature.SetFractalOctaves(1);
        humidity = new FastNoiseLite();
        humidity.SetSeed(r.nextInt());
        humidity.SetFractalOctaves(1);
        humidity.SetNoiseType(FastNoiseLite.NoiseType.Perlin);
    }

    public static final float BIOME_SIZE_DIVIDER = 5;

    public AbyssBiome getBiome(int x, int y, int z) {
        if (y <= -20000)
            y = -19999;
        AbyssBiome[][] biomes = BiomesProvider.BIOMES_LVL[y / -1000];
        double temperatureValue = (temperature.GetNoise(x / BIOME_SIZE_DIVIDER, y / BIOME_SIZE_DIVIDER, z / BIOME_SIZE_DIVIDER) + 1) / 2.01;
        double humidityValue = (humidity.GetNoise(x / BIOME_SIZE_DIVIDER, y / BIOME_SIZE_DIVIDER, z / BIOME_SIZE_DIVIDER) + 1) / 2.01;
        AbyssBiome[] tempBiomes = biomes[(int) ((temperatureValue) * biomes.length)];
        return tempBiomes[(int) ((humidityValue) * tempBiomes.length)];
    }
}
