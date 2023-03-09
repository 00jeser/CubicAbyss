package jeser.cubicabyss.blocks.ArtefactWorkbench;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class ArtefactWorkbenchTileEntity extends TileEntity {
    private ItemStack[] leftSlots = new ItemStack[3];
    private ItemStack[] rightSlots = new ItemStack[3];

    public ArtefactWorkbenchTileEntity() {
        super();
    }

    public ItemStack[] getLeftSlots() {
        return leftSlots;
    }

    public ItemStack[] getRightSlots() {
        return rightSlots;
    }
}
