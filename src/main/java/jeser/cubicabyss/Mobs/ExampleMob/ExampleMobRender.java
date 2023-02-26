package jeser.cubicabyss.Mobs.ExampleMob;

import jeser.cubicabyss.CubicAbyss;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class ExampleMobRender extends RenderLiving<ExampleMob> {
    public ExampleMobRender(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ExampleMobModel(), 0.5f);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(ExampleMob entity) {
        return new ResourceLocation(CubicAbyss.MOD_ID + ":textures/entity/examplemob.png");
    }

    @Override
    protected void applyRotations(ExampleMob entityLiving, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, ageInTicks, rotationYaw, partialTicks);
    }
}
