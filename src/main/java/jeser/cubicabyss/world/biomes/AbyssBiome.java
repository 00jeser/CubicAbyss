package jeser.cubicabyss.world.biomes;

import net.minecraft.block.state.IBlockState;

public class AbyssBiome {
    public IBlockState Ground;
    public IBlockState Basis;
    public IBlockState Grass[];
    public float GrassChance;

    public AbyssBiome(IBlockState ground, IBlockState basis, IBlockState[] grass, float grassChance) {
        Ground = ground;
        Basis = basis;
        Grass = grass;
        GrassChance = grassChance;
    }
}
