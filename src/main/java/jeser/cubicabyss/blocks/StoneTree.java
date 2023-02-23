package jeser.cubicabyss.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class StoneTree extends Block {
    public StoneTree() {
        super(Material.ROCK);
        setRegistryName("stone_tree");
        setHardness(1.0f);
        setHarvestLevel("pickaxe", 0);
        setResistance(1.0f);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setSoundType(SoundType.STONE);
    }
}
