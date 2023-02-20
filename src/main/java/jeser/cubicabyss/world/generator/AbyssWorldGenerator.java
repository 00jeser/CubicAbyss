package jeser.cubicabyss.world.generator;

import io.github.opencubicchunks.cubicchunks.api.util.IntRange;
import io.github.opencubicchunks.cubicchunks.api.world.ICubicWorldType;
import io.github.opencubicchunks.cubicchunks.api.worldgen.ICubeGenerator;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import javax.annotation.Nullable;
import java.util.Random;

public class AbyssWorldGenerator  extends WorldType implements ICubicWorldType {

    public static AbyssWorldGenerator create ()
    {
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
