package jeser.cubicabyss.mobs.DemonFish;

import jeser.cubicabyss.CubicAbyss;
import jeser.cubicabyss.ai.RiverMovingAI;
import jeser.cubicabyss.mobs.Steve.Steve;
import net.minecraft.block.material.Material;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.model.animation.Animation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class DemonFish extends EntityCreature implements IAnimatable {
    private static final DataParameter<Boolean> MOVING = EntityDataManager.<Boolean>createKey(DemonFish.class, DataSerializers.BOOLEAN);
    public float lastHp = this.getHealth();
    private AnimationFactory factory = new AnimationFactory(this);
    public DemonFish(World worldIn) {
        super(worldIn);
        //this.moveHelper = new DemonFish.DemonFishMoveHelper(this);
        this.setSize(0.6F, 0.5F);
    }
    protected void initEntityAI() {
        tasks.addTask(0, new EntityAIPanic(this, 0.6D));
        tasks.addTask(1, new RiverMovingAI(this));
        tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F));
        //tasks.addTask(3, new EntityAIWander(this, 0.3D));
        tasks.addTask(4, new EntityAILookIdle(this));
    }
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(5D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
    }
    public static void register() {
        EntityRegistry.registerModEntity(
                new ResourceLocation(CubicAbyss.MOD_ID + ":demon_fish"),
                DemonFish.class,
                "demon_fish",
                7654331,
                CubicAbyss.INSTANCE,
                50,
                1,
                true,
                0xA4CBDB, 0x5DACCF
        );
    }

    private <E extends IAnimatable>PlayState predicate(AnimationEvent<E> event) {
        if (lastHp > this.getHealth()){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.hurt", false));
            lastHp = this.getHealth();
            return PlayState.CONTINUE;
        }
        if (event.getController().getAnimationState() == AnimationState.Running)
            return PlayState.CONTINUE;
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.move", false));
            return PlayState.CONTINUE;
        }
        lastHp = this.getHealth();
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.idle", false));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
    protected PathNavigate createNavigator(World worldIn)
    {
        return new PathNavigateSwimmer(this, worldIn);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(MOVING, Boolean.valueOf(false));
    }
    public boolean isMoving()
    {
        return ((Boolean)this.dataManager.get(MOVING)).booleanValue();
    }
    private void setMoving(boolean moving)
    {
        this.dataManager.set(MOVING, Boolean.valueOf(moving));
    }
    public int getTalkInterval()
    {
        return 160;
    }

    protected SoundEvent getAmbientSound()
    {
        return this.isInWater() ? SoundEvents.ENTITY_GUARDIAN_AMBIENT : SoundEvents.ENTITY_GUARDIAN_AMBIENT_LAND;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return this.isInWater() ? SoundEvents.ENTITY_GUARDIAN_HURT : SoundEvents.ENTITY_GUARDIAN_HURT_LAND;
    }

    protected SoundEvent getDeathSound()
    {
        return this.isInWater() ? SoundEvents.ENTITY_GUARDIAN_DEATH : SoundEvents.ENTITY_GUARDIAN_DEATH_LAND;
    }

    public float getBlockPathWeight(BlockPos pos)
    {
        return this.world.getBlockState(pos).getMaterial() == Material.WATER ? 10.0F + this.world.getLightBrightness(pos) - 0.5F : super.getBlockPathWeight(pos);
    }
    public void onLivingUpdate() {
        if (this.isInWater()) {setAir(300);}
        else if (this.onGround)
        {
            this.motionY += 0.5D;
            this.motionX += (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F);
            this.motionZ += (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F);
            this.rotationYaw = this.rand.nextFloat() * 360.0F;
            this.onGround = false;
            this.isAirBorne = true;
        }
        super.onLivingUpdate();
    }
    protected SoundEvent getFlopSound()
    {
        return SoundEvents.ENTITY_GUARDIAN_FLOP;
    }
}
