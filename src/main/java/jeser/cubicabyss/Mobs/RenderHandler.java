package jeser.cubicabyss.Mobs;

import jeser.cubicabyss.Mobs.ExampleMob.ExampleMob;
import jeser.cubicabyss.Mobs.ExampleMob.ExampleMobRender;
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
    }
}
