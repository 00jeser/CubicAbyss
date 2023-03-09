package jeser.cubicabyss.blocks.ArtefactWorkbench;

import jeser.cubicabyss.CubicAbyss;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ArtefactWorkbenchBlock extends Block {
    public ArtefactWorkbenchBlock(Material blockMaterialIn, MapColor blockMapColorIn) {
        super(blockMaterialIn, blockMapColorIn);
    }

    public ArtefactWorkbenchBlock() {
        super(Material.ANVIL);
        setRegistryName("dawdjawjkledhalwukhgdyjqawkedgjaykwdgyjawgdkjyawhgdjkyh");
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) {
            return true;
        } else {
            playerIn.openGui(CubicAbyss.INSTANCE, -1, worldIn, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }
    }
}
