package jeser.cubicabyss;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DebugScreenEventHandler {

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent.Text event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.DEBUG) {
            Minecraft mc = Minecraft.getMinecraft();
            ScaledResolution scaledResolution = new ScaledResolution(mc);
            Gui.drawRect(0, 0, scaledResolution.getScaledWidth(), 20, 0x80000000); // Draw a transparent black rectangle at the top of the debug screen
            mc.fontRenderer.drawString("My mod info:", 5, 5, 0xFFFFFF); // Draw some text at (5,5) with white color
            mc.fontRenderer.drawString("Some info here", 5, 15, 0xFFFFFF); // Draw some more text at (5,15) with white color
        }
    }
}