package jeser.cubicabyss.world.generator.Generators;

import FastNoise.FastNoiseLite;
import jeser.cubicabyss.world.generator.AbyssWorldGenerator;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

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
        float valueForCompare = 1 - (distance * distanceModifier) / AbyssWorldGenerator.RADIUS;
        if (getNoiseValue(x, y, z) > valueForCompare)
            if (getNoiseValue(x, y + 1, z) <= valueForCompare)
                return Blocks.GRASS.getDefaultState();
            else
                return Blocks.STONE.getDefaultState();
        else if (getNoiseValue(x, y - 1, z) > valueForCompare)
            switch (r.nextInt() % 10) {
                case 0:
                case 1:
                    return Blocks.TALLGRASS.getDefaultState().withProperty(
                            BlockTallGrass.TYPE,
                            BlockTallGrass.EnumType.GRASS);
                case 2:
                    return Blocks.RED_FLOWER.getDefaultState();
                default:
                    return null;
            }
        else
            return null;
    }

    private float getNoiseValue(int x, int y, int z) {
        return
                noise1.GetNoise(x * scaleXZ1, y * scaleY1, z * scaleXZ1)
                        + noise2.GetNoise(x * scaleXZ2, y * scaleY2, z * scaleXZ2);
    }
}
