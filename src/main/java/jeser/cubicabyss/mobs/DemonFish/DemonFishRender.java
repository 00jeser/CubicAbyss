package jeser.cubicabyss.mobs.DemonFish;

import baubles.api.render.IRenderBauble;
import jeser.cubicabyss.CubicAbyss;
import jeser.cubicabyss.mobs.Steve.SteveModel;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DemonFishRender extends GeoEntityRenderer<DemonFish> {
    public DemonFishRender(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new DemonFishModel());
    }
    @Override
    public ResourceLocation getTextureLocation(DemonFish instance) {
        return new ResourceLocation(CubicAbyss.MOD_ID, "textures/entity/demon_fish.png");
    }
}
