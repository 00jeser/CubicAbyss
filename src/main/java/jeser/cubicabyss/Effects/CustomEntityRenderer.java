package jeser.cubicabyss.Effects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.resources.IResourceManager;

public class CustomEntityRenderer extends EntityRenderer {
    private final IResourceManager resourceManager;

    public CustomEntityRenderer(IResourceManager resourceManager) {
        super(Minecraft.getMinecraft(), resourceManager);
        this.resourceManager = resourceManager;
    }
}

