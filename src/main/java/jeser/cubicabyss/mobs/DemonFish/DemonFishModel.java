package jeser.cubicabyss.mobs.DemonFish;

import jeser.cubicabyss.CubicAbyss;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DemonFishModel extends AnimatedGeoModel<DemonFish> {
    @Override
    public ResourceLocation getModelLocation(DemonFish demonFish) {
        return new ResourceLocation(CubicAbyss.MOD_ID, "geo/demon_fish.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(DemonFish demonFish) {
        return new ResourceLocation(CubicAbyss.MOD_ID, "textures/entity/demon_fish.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(DemonFish demonFish) {
        return new ResourceLocation(CubicAbyss.MOD_ID, "animations/demon_fish.animation.json");
    }
}
