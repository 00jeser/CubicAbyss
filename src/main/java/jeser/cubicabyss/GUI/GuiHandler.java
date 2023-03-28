package jeser.cubicabyss.GUI;

import jeser.cubicabyss.CubicAbyss;
import jeser.cubicabyss.blocks.ArtefactWorkbench.ArtefactWorkbenchGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GuiHandler {
    public static void RegisterAll() {
        NetworkRegistry.INSTANCE.registerGuiHandler(CubicAbyss.INSTANCE, new ArtefactWorkbenchGuiHandler());
    }
}
