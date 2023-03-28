package jeser.cubicabyss.blocks.ArtefactWorkbench;

import jeser.cubicabyss.CubicAbyss;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ArtefactWorckbenchGUI extends GuiContainer {
    private static final ResourceLocation METAL_WORKBENCH_GUI_TEXTURE = new ResourceLocation(CubicAbyss.MOD_ID + ":textures/gui/container/artefact_workbench.png");
    private final IInventory playerInventory;

    public ArtefactWorckbenchGUI(InventoryPlayer inventory, World world, BlockPos blockPos) {
        super(new ArtefactWorkbenchContainer(inventory, world, blockPos));
        playerInventory = inventory;
        this.xSize = 176;
        this.ySize = 166;
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.fontRenderer.drawString(I18n.format("container.artefact_workbench"), 8, 6, 0xffffff);
        this.fontRenderer.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 0xffffff);
    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(METAL_WORKBENCH_GUI_TEXTURE);
        int i = this.guiLeft;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
    }
}
