package jeser.cubicabyss.Mobs.Steve;

import jeser.cubicabyss.CubicAbyss;
import jeser.cubicabyss.Mobs.ExampleMob.ExampleMob;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class Steve extends EntityCreature {
    public Steve(World worldIn) {
        super(worldIn);
        setSize(1.0f, 2.0f);
    }

    public static void register() {
        EntityRegistry.registerModEntity(
                new ResourceLocation(CubicAbyss.MOD_ID + ":steve"),
                Steve.class,
                "steve",
                1234567,
                CubicAbyss.INSTANCE,
                50,
                1,
                true,
                0xFFAA00, 0x55FFFF
        );
    }
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1,new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(2,new EntityAIPanic(this, 0.5D));
        this.tasks.addTask(3, new EntityAIWanderAvoidWater(this, 1.0D));
    }
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }
}
