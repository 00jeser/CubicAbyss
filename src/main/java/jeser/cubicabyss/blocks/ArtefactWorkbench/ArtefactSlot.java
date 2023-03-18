package jeser.cubicabyss.blocks.ArtefactWorkbench;

import jeser.cubicabyss.items.Artefact;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ArtefactSlot extends Slot {


    public ArtefactSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() instanceof Artefact;
    }
}
