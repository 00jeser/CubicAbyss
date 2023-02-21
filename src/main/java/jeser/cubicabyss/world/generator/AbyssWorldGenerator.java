package jeser.cubicabyss.world.generator;

import io.github.opencubicchunks.cubicchunks.api.util.IntRange;
import io.github.opencubicchunks.cubicchunks.api.world.ICubicWorldType;
import io.github.opencubicchunks.cubicchunks.api.worldgen.ICubeGenerator;
import net.minecraft.init.Biomes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraftforge.common.DimensionManager;

public class AbyssWorldGenerator  extends WorldType implements ICubicWorldType {
    public static final float RADIUS = 100;

    public static AbyssWorldGenerator create ()
    {
        return new AbyssWorldGenerator();
    }
    public AbyssWorldGenerator() {
        super("aughauua");


    }

    @Override
    public IntRange calculateGenerationHeightRange(WorldServer worldServer) {
        return new IntRange(-1000, 200);
    }

    @Override
    public boolean hasCubicGeneratorForWorld(World world) {
        return world.provider.getClass() == DimensionManager.getProvider(0).getClass();
    }

    @Override
    public ICubeGenerator createCubeGenerator(World world) {
        return new CustomTerrainGenerator(world, world.getSeed());
    }


    @Override
    public BiomeProvider getBiomeProvider(World world) {
        return new BiomeProviderSingle(Biomes.PLAINS);
    }

    @Override
    public int getSpawnFuzz(WorldServer world, MinecraftServer server) {
        world.setSpawnPoint(new BlockPos(102, 64, 0));
        return 11;
    }


}
