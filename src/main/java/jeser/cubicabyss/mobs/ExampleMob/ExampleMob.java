package jeser.cubicabyss.mobs.ExampleMob;

import jeser.cubicabyss.CubicAbyss;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
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

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.WHEAT, false));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));

    }
}
