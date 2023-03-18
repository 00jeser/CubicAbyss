package jeser.cubicabyss.blocks.ArtefactWorkbench;

import jeser.cubicabyss.blocks.BlocksRegisterHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ArtefactWorkbenchContainer extends Container {
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 2);
    public InventoryCraftResult craftResult = new InventoryCraftResult();
    private final World world;
    /**
     * Position of the workbench
     */
    private final BlockPos pos;
    private final EntityPlayer player;

    public ArtefactWorkbenchContainer(InventoryPlayer playerInventory, World worldIn, BlockPos blockPos) {
        world = worldIn;
        this.pos = blockPos;
        this.player = playerInventory.player;
        //This is the output slot
        this.addSlotToContainer(new SlotCrafting(playerInventory.player, this.craftMatrix, this.craftResult, 0, 8 + 18 * 5, 26));
        this.addSlotToContainer(new SlotCrafting(playerInventory.player, this.craftMatrix, this.craftResult, 1, 8 + 18 * 5, 26));
        this.addSlotToContainer(new SlotCrafting(playerInventory.player, this.craftMatrix, this.craftResult, 2, 8 + 18 * 5, 26));
        this.addSlotToContainer(new SlotCrafting(playerInventory.player, this.craftMatrix, this.craftResult, 3, 8 + 18 * 5, 26));
        this.addSlotToContainer(new SlotCrafting(playerInventory.player, this.craftMatrix, this.craftResult, 4, 8 + 18 * 5, 26));
        this.addSlotToContainer(new SlotCrafting(playerInventory.player, this.craftMatrix, this.craftResult, 5, 8 + 18 * 5, 26));
        this.addSlotToContainer(new SlotCrafting(playerInventory.player, this.craftMatrix, this.craftResult, 6, 8 + 18 * 5, 26));
        this.addSlotToContainer(new SlotCrafting(playerInventory.player, this.craftMatrix, this.craftResult, 7, 8 + 18 * 5, 26));

        //These are the input slots
        this.addSlotToContainer(new ArtefactSlot(this.craftMatrix, 0, 8, 26));
        this.addSlotToContainer(new ArtefactSlot(this.craftMatrix, 1, 8 + 18, 26));
        this.addSlotToContainer(new ArtefactSlot(this.craftMatrix, 2, 8 + 18 * 2, 26));
        this.addSlotToContainer(new ArtefactSlot(this.craftMatrix, 3, 8, 26 + 18));
        this.addSlotToContainer(new ArtefactSlot(this.craftMatrix, 4, 8 + 18, 26 + 18));
        this.addSlotToContainer(new ArtefactSlot(this.craftMatrix, 5, 8 + 18 * 2, 26 + 18));

        //these are the first 3 rows of inventory
        for (int k = 0; k < 3; ++k) {
            for (int i1 = 0; i1 < 9; ++i1) {
                this.addSlotToContainer(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }
        //this is the hotbar
        for (int l = 0; l < 9; ++l) {
            this.addSlotToContainer(new Slot(playerInventory, l, 8 + l * 18, 142));
        }
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory inventoryIn) {
        //craftResult.setInventorySlotContents(0, new ItemStack(Blocks.IRON_ORE));
        //craftResult.setInventorySlotContents(0, MetalWorkbenchCraftingHandler.instance().getResult(this.craftMatrix, world));
        if (!this.world.isRemote) {
            EntityPlayerMP eplayer = (EntityPlayerMP) this.player;
            if (!inventoryIn.getStackInSlot(0).isEmpty() && inventoryIn.getStackInSlot(0).getItem() == Items.APPLE) {
                //takes the items in the crafting matrix and finds a recipe with those things
                // TODO set ItemStack to s
                ItemStack s = new ItemStack(Items.ACACIA_BOAT, 64);
                this.craftResult.setInventorySlotContents(0, s);
                eplayer.connection.sendPacket(new SPacketSetSlot(this.windowId, 0, s));
            } else {
                ItemStack s = new ItemStack(Items.AIR, 64);
                this.craftResult.setInventorySlotContents(0, s);
                eplayer.connection.sendPacket(new SPacketSetSlot(this.windowId, 0, s));
            }
        }
    }


    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);

        if (!this.world.isRemote) {
            this.clearContainer(playerIn, this.world, this.craftMatrix);
        }
    }

    /**
     * Determines whether supplied player can use this container
     */
    public boolean canInteractWith(EntityPlayer playerIn) {
        if (this.world.getBlockState(this.pos).getBlock() != BlocksRegisterHandler.ARTEFACT_WORKBENCH_BLOCK) {
            return false;
        } else {
            return playerIn.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
     * inventory and the other inventory(s).
     */
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 0) {
                itemstack1.getItem().onCreated(itemstack1, this.world, playerIn);

                if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (index >= 10 && index < 37) {
                if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 37 && index < 46) {
                if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            ItemStack itemstack2 = slot.onTake(playerIn, itemstack1);

            if (index == 0) {
                playerIn.dropItem(itemstack2, false);
            }
        }

        return itemstack;
    }

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in
     * is null for the initial slot that was double-clicked.
     */
    public boolean canMergeSlot(ItemStack stack, Slot slotIn) {
        return slotIn.inventory != this.craftResult && super.canMergeSlot(stack, slotIn);
    }
}
