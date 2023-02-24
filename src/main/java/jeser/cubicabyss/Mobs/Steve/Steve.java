package jeser.cubicabyss.Mobs.Steve;

import jeser.cubicabyss.CubicAbyss;
import jeser.cubicabyss.Mobs.ExampleMob.ExampleMob;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class Steve extends EntityMob {
    public Steve(World worldIn) {
        super(worldIn);
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
    //@Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.3D, 5F));
        this.tasks.addTask(4, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 10F));
    }
    protected void applyEntityAI() {
        this.tasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.1D);
    }
    protected SoundEvent getAmbientSound() {return SoundEvents.ENTITY_GHAST_AMBIENT;}
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {return SoundEvents.ENTITY_GHAST_HURT;}
}
