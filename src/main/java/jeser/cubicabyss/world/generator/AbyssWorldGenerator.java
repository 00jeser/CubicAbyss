package jeser.cubicabyss.world.generator;

import io.github.opencubicchunks.cubicchunks.api.util.IntRange;
import io.github.opencubicchunks.cubicchunks.api.world.ICubicWorldType;
import io.github.opencubicchunks.cubicchunks.api.worldgen.ICubeGenerator;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;

public class AbyssWorldGenerator extends WorldType implements ICubicWorldType {

    public static final float RADIUS = 100;

    public static AbyssWorldGenerator create() {
        return new AbyssWorldGenerator();
    }

    public AbyssWorldGenerator() {
        super("aughauua");
    }

    @Override
    public IntRange calculateGenerationHeightRange(WorldServer worldServer) {
        return null;
    }

    @Override
    public boolean hasCubicGeneratorForWorld(World world) {
        return false;
    }

    @Override
    public ICubeGenerator createCubeGenerator(World world) {
        return new CustomTerrainGenerator(world, world.getSeed());
    }
}
