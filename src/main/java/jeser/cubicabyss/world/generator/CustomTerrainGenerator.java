package jeser.cubicabyss.world.generator;

import io.github.opencubicchunks.cubicchunks.api.util.Box;
import io.github.opencubicchunks.cubicchunks.api.world.ICube;
import io.github.opencubicchunks.cubicchunks.api.worldgen.CubePrimer;
import jeser.cubicabyss.world.generator.Generators.IGenerationLayer;
import jeser.cubicabyss.world.generator.Generators.IslandsLayerGenerator;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;


@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CustomTerrainGenerator extends BasicCubeGenerator {

    public CustomTerrainGenerator(World world) {
        super(world);
    }

    @Override
    public CubePrimer generateCube(int cubeX, int cubeY, int cubeZ) { // legacy method
        return this.generateCube(cubeX, cubeY, cubeZ, new CubePrimer());
    }


    private final IslandsLayerGenerator coreGenerator = new IslandsLayerGenerator(world.getSeed());
    private final IGenerationLayer[] generationLayers = new IGenerationLayer[]{
            coreGenerator
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
                                        globalX, globalY, globalZ,
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


    Random r = new Random();

    @Override
    public void populate(ICube cube) {
        for (int y = 0; y < ICube.SIZE; y += 2)
            for (int x = 0; x < ICube.SIZE; x += 2)
                for (int z = 0; z < ICube.SIZE; z += 2) {
                    int globalX = ICube.SIZE * cube.getX() + x;
                    int globalY = ICube.SIZE * cube.getY() + y;
                    int globalZ = ICube.SIZE * cube.getZ() + z;
                    float distance = (float) Math.sqrt(globalX * globalX + globalZ * globalZ);
                    float valueForCompare = coreGenerator.getValueForCompare(distance);

                    Structures.Structure[] structures;
                    if (coreGenerator.getNoiseValue(globalX, globalY, globalZ) > valueForCompare) {
                        if (coreGenerator.getNoiseValue(globalX, globalY + 1, globalZ) <= valueForCompare) {
                            // up
                            structures = Structures.UPSTRUCTURES;
                        } else if (coreGenerator.getNoiseValue(globalX, globalY - 1, globalZ) <= valueForCompare) {
                            // down
                            structures = Structures.DOWNSTRUCTURES;
                        } else {
                            // inside
                            structures = Structures.INSIDESTRUCTURES;
                        }
                    } else {
                        // air
                        structures = Structures.AIRSTRUCTURES;
                    }

                    for (Structures.Structure s : structures) {
                        if (r.nextInt() % s.rare == 0 && globalY > s.minHeight && globalY < s.maxHeight)
                            generateStrucure(s.location, new BlockPos(globalX, globalY, globalZ), s.rotate);
                    }
                }
    }

    private void generateStrucure(ResourceLocation location, BlockPos pos, boolean randomRotation) {
        TemplateManager templateManager = world.getSaveHandler().getStructureTemplateManager();
        Template template = templateManager.getTemplate(world.getMinecraftServer(), location);

// create the placement settings
        PlacementSettings placementSettings = new PlacementSettings();
        if (randomRotation) {
            switch (r.nextInt() % 4) {
                case 0:
                    placementSettings.setRotation(Rotation.NONE);
                    break;
                case 1:
                    placementSettings.setRotation(Rotation.CLOCKWISE_90);
                    break;
                case 2:
                    placementSettings.setRotation(Rotation.CLOCKWISE_180);
                    break;
                default:
                    placementSettings.setRotation(Rotation.COUNTERCLOCKWISE_90);
                    break;
            }
        } else
            placementSettings.setRotation(Rotation.NONE);
        placementSettings.setMirror(Mirror.NONE);

// generate the structure in the world
        template.addBlocksToWorld(world, pos, placementSettings);
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
