package jeser.cubicabyss.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class StoneTree extends Block {
    public StoneTree() {
        super(Material.ROCK);
        this.setHardness(1.5f);
        this.setHarvestLevel("pickaxe", 0);
        this.setResistance(1.0f);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setSoundType(SoundType.STONE);
        this.setRegistryName("stone_tree");
    }
}
