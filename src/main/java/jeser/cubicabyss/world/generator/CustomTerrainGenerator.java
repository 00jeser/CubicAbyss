package jeser.cubicabyss.world.generator;

import io.github.opencubicchunks.cubicchunks.api.world.ICube;
import io.github.opencubicchunks.cubicchunks.api.worldgen.CubePrimer;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;


@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CustomTerrainGenerator extends BasicCubeGenerator{
    public CustomTerrainGenerator(World world, long seed) {
        super(world);
    }

    @Override
    public CubePrimer generateCube(int i, int i1, int i2) {
        CubePrimer p = new CubePrimer();
        p.setBlockState(i, i1, i2, Blocks.STONE.getDefaultState());
        return p;
    }

    @Override
    public void populate(ICube iCube) {

    }
}
