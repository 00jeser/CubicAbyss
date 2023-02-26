package jeser.cubicabyss.Mobs;

import jeser.cubicabyss.Mobs.ExampleMob.ExampleMob;
import jeser.cubicabyss.Mobs.ExampleMob.ExampleMobRender;
import jeser.cubicabyss.Mobs.Steve.Steve;
import jeser.cubicabyss.Mobs.Steve.SteveRender;
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
    }
}
