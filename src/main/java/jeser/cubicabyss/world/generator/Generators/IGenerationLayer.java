package jeser.cubicabyss.world.generator.Generators;

import net.minecraft.block.state.IBlockState;

public interface IGenerationLayer {
    public IBlockState getState(int x, int y, int z, float distance, IBlockState state);
}