package jeser.cubicabyss.mobs;

import jeser.cubicabyss.mobs.DemonFish.DemonFish;
import jeser.cubicabyss.mobs.DemonFish.DemonFishRender;
import jeser.cubicabyss.mobs.ExampleMob.ExampleMob;
import jeser.cubicabyss.mobs.ExampleMob.ExampleMobRender;
import jeser.cubicabyss.mobs.Steve.Steve;
import jeser.cubicabyss.mobs.Steve.SteveRender;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
    public static void registerEntityRender() {
        RenderingRegistry.registerEntityRenderingHandler(ExampleMob.class, new IRenderFactory<ExampleMob>() {
            @Override
            public Render<? super ExampleMob> createRenderFor(RenderManager manager) {
                return new ExampleMobRender(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(Steve.class, new IRenderFactory<Steve>() {
            @Override
            public Render<? super Steve> createRenderFor(RenderManager manager) {
                return new SteveRender(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(DemonFish.class, new IRenderFactory<DemonFish>() {
            @Override
            public Render<? super DemonFish> createRenderFor(RenderManager manager) {
                return new DemonFishRender(manager);
            }
        });
    }
}
