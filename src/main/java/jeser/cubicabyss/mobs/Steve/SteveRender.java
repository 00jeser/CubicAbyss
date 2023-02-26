package jeser.cubicabyss.mobs.Steve;

import jeser.cubicabyss.CubicAbyss;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class SteveRender extends RenderLiving<Steve> {
    public SteveRender(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new SteveModel(), 0.5f);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Steve entity) {
        return new ResourceLocation(CubicAbyss.MOD_ID + ":textures/entity/steve.png");
    }

    @Override
    protected void applyRotations(Steve entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }
}
