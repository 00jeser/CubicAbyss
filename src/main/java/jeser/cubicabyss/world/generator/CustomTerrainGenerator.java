package jeser.cubicabyss.world.generator;

import io.github.opencubicchunks.cubicchunks.api.util.Box;
import io.github.opencubicchunks.cubicchunks.api.util.Coords;
import io.github.opencubicchunks.cubicchunks.api.world.ICube;
import io.github.opencubicchunks.cubicchunks.api.worldgen.CubeGeneratorsRegistry;
import io.github.opencubicchunks.cubicchunks.api.worldgen.CubePrimer;
import io.github.opencubicchunks.cubicchunks.api.worldgen.populator.CubePopulatorEvent;
import jeser.cubicabyss.world.generator.Generators.IGenerationLayer;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import javax.annotation.ParametersAreNonnullByDefault;


@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CustomTerrainGenerator extends BasicCubeGenerator {

    public CustomTerrainGenerator(World world, long seed) {
        super(world);
    }

    @Override
    public CubePrimer generateCube(int cubeX, int cubeY, int cubeZ) { // legacy method
        return this.generateCube(cubeX, cubeY, cubeZ, new CubePrimer());
    }


    private IGenerationLayer[] generationLayers = new IGenerationLayer[]{
    };

    @Override
    public CubePrimer generateCube(int cubeX, int cubeY, int cubeZ, CubePrimer primer) {

        for (int y = 0; y < ICube.SIZE; y++)
            for (int x = 0; x < ICube.SIZE; x++)
                for (int z = 0; z < ICube.SIZE; z++) {
                    int globalX = ICube.SIZE * cubeX + x;
                    int globalY = ICube.SIZE * cubeY + y;
                    int globalZ = ICube.SIZE * cubeZ + z;
                    float distance = (float) Math.sqrt(globalX * globalX + globalZ * globalZ);
                    if (globalY > 64) {
                        // Todo: terrain generation
                    } else {
                        if (distance < AbyssWorldGenerator.RADIUS) {
                            IBlockState state = null;
                            for (IGenerationLayer layer : generationLayers) {
                                state = layer.getState(
                                        x, y, z,
                                        distance,
                                        state
                                );
                            }
                            primer.setBlockState(x, y, z, state == null ? Blocks.AIR.getDefaultState() : state);
                        } else if (distance < AbyssWorldGenerator.RADIUS * 1.5) {
                            primer.setBlockState(x, y, z, Blocks.STONE.getDefaultState());
                        } else {
                            primer.setBlockState(x, y, z, Blocks.BEDROCK.getDefaultState());
                        }
                    }
                }
        return primer;
    }


    @Override
    public void populate(ICube cube) {
        /**
         * If event is not canceled we will use cube populators from registry.
         **/
        if (!MinecraftForge.EVENT_BUS.post(new CubePopulatorEvent(world, cube))) {
            CubeGeneratorsRegistry.generateWorld(cube.getWorld(),
                    Coords.coordsSeedRandom(cube.getWorld().getSeed(), cube.getX(), cube.getY(), cube.getZ()),
                    cube.getCoords(), world.getBiome(cube.getCoords().getCenterBlockPos()));
        }
    }

    @Override
    public Box getFullPopulationRequirements(ICube cube) {
        return NO_REQUIREMENT;
    }

    @Override
    public Box getPopulationPregenerationRequirements(ICube cube) {
        return NO_REQUIREMENT;
    }

    @Override
    public BlockPos getClosestStructure(String name, BlockPos pos, boolean findUnexplored) {
        // eyes of ender are the new F3 for finding the origin :P
        return name.equals("Stronghold") ? new BlockPos(0, 0, 0) : null;
    }
}
