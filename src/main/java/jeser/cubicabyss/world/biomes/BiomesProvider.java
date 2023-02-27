package jeser.cubicabyss.world.biomes;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import static net.minecraft.block.BlockDirt.DirtType.PODZOL;
import static net.minecraft.block.BlockStone.EnumType.DIORITE;
import static net.minecraft.block.BlockTallGrass.EnumType.FERN;

public class BiomesProvider {
    public static final AbyssBiome ABYSS_PLANTS = new AbyssBiome(
            Blocks.GRASS.getDefaultState(),
            Blocks.STONE.getDefaultState(),
            new IBlockState[]{Blocks.TALLGRASS.getDefaultState()},
            0.2f
    );
    public static final AbyssBiome ABYSS_DESERT = new AbyssBiome(
            Blocks.SAND.getDefaultState(),
            Blocks.SANDSTONE.getDefaultState(),
            new IBlockState[]{},
            0f
    );
    public static final AbyssBiome ABYSS_TAIGA = new AbyssBiome(
            Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, PODZOL),
            Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, DIORITE),
            new IBlockState[]{
                    Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, FERN),
                    Blocks.RED_FLOWER.getDefaultState()
            },
            0.1f
    );
    // по горизонтали - температура →
    // по вертикали - влажность ↓
    public static final AbyssBiome[][][] BIOMES_LVL = new AbyssBiome[][][]{
            //1 уровень
            {
                    {ABYSS_PLANTS, ABYSS_DESERT},
                    {ABYSS_TAIGA, ABYSS_PLANTS}
            },
            //2 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            },
            //3 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            },
            //4 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            },
            //5 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            },
            //6 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            },
            //7 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            },
            //8 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            },
            //9 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            },
            //10 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            },
            //11 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            },
            //12 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            },
            //13 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            },
            //14 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            },
            //15 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            },
            //16 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            },
            //17 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            },
            //18 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            },
            //19 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            },
            //20 уровень
            {
                    {ABYSS_PLANTS, ABYSS_PLANTS},
                    {ABYSS_PLANTS, ABYSS_PLANTS}
            }
    };
}
