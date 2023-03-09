package jeser.cubicabyss.blocks.ArtefactWorkbench;

import jeser.cubicabyss.blocks.BlocksRegisterHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ArtefactWorkbenchGuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        IBlockState iblockstate = world.getBlockState(new BlockPos(x, y, z));
        if (/*ID == GuiIDs.METAL_WORKBENCH && */(iblockstate.getBlock() == BlocksRegisterHandler.ARTEFACT_WORKBENCH_BLOCK))
            return new ArtefactWorkbenchContainer(player.inventory, world, new BlockPos(x, y, z));
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        IBlockState iblockstate = world.getBlockState(new BlockPos(x, y, z));
        if (/*ID == GuiIDs.METAL_WORKBENCH && */(iblockstate.getBlock() == BlocksRegisterHandler.ARTEFACT_WORKBENCH_BLOCK))
            return new ArtefactWorckbenchGUI(player.inventory, world, new BlockPos(x, y, z));
        return null;
    }
}
