package jeser.cubicabyss.Mobs.ExampleMob;

import jeser.cubicabyss.CubicAbyss;
import net.minecraft.entity.EntityCreature;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ExampleMob extends EntityCreature {
    public ExampleMob(World worldIn) {
        super(worldIn);

    }

    public static void register() {
        EntityRegistry.registerModEntity(
                new ResourceLocation(CubicAbyss.MOD_ID + ":examplemob"),
                ExampleMob.class,
                "examplemob",
                12345,
                CubicAbyss.INSTANCE,
                50,
                1,
                true,
                0, 5
        );
    }
}
