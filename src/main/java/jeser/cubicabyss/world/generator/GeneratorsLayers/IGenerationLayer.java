package jeser.cubicabyss.world.generator.GeneratorsLayers;

import net.minecraft.block.state.IBlockState;

public interface IGenerationLayer {
    public IBlockState getBlock(int x, int y, int z, float distanse, IBlockState block);
}
