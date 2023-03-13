package jeser.cubicabyss.mobs.DemonFish;

import jeser.cubicabyss.CubicAbyss;
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
        this.moveHelper = new DemonFish.DemonFishMoveHelper(this);
    }
    protected void initEntityAI() {
        tasks.addTask(0, new EntityAIPanic(this, 0.6D));
        tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F));
        tasks.addTask(2, new EntityAIWander(this, 0.3D));
        tasks.addTask(3, new EntityAILookIdle(this));
    }
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
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
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.move", true));
            return PlayState.CONTINUE;
        }
        lastHp = this.getHealth();
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.idle", true));
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

    public void travel(float strafe, float vertical, float forward)
    {
        if (this.isServerWorld() && this.isInWater())
        {
            this.moveRelative(strafe, vertical, forward, 0.1F);
            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.8999999761581421D;
            this.motionY *= 0.8999999761581421D;
            this.motionZ *= 0.8999999761581421D;

            if (!this.isMoving() && this.getAttackTarget() == null)
            {
                this.motionY -= 0.005D;
            }
        }
        else
        {
            super.travel(strafe, vertical, forward);
        }
    }

    static class DemonFishMoveHelper extends EntityMoveHelper
    {
        private final DemonFish demonFish;

        public DemonFishMoveHelper(DemonFish fish)
        {
            super(fish);
            this.demonFish = fish;
        }

        public void onUpdateMoveHelper()
        {
            if (this.action == EntityMoveHelper.Action.MOVE_TO && !this.demonFish.getNavigator().noPath())
            {
                double d0 = this.posX - this.demonFish.posX;
                double d1 = this.posY - this.demonFish.posY;
                double d2 = this.posZ - this.demonFish.posZ;
                double d3 = (double) MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                d1 = d1 / d3;
                float f = (float)(MathHelper.atan2(d2, d0) * (180D / Math.PI)) - 90.0F;
                this.demonFish.rotationYaw = this.limitAngle(this.demonFish.rotationYaw, f, 90.0F);
                this.demonFish.renderYawOffset = this.demonFish.rotationYaw;
                float f1 = (float)(this.speed * this.demonFish.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
                this.demonFish.setAIMoveSpeed(this.demonFish.getAIMoveSpeed() + (f1 - this.demonFish.getAIMoveSpeed()) * 0.125F);
                double d4 = Math.sin((double)(this.demonFish.ticksExisted + this.demonFish.getEntityId()) * 0.5D) * 0.05D;
                double d5 = Math.cos((double)(this.demonFish.rotationYaw * 0.017453292F));
                double d6 = Math.sin((double)(this.demonFish.rotationYaw * 0.017453292F));
                this.demonFish.motionX += d4 * d5;
                this.demonFish.motionZ += d4 * d6;
                d4 = Math.sin((double)(this.demonFish.ticksExisted + this.demonFish.getEntityId()) * 0.75D) * 0.05D;
                this.demonFish.motionY += d4 * (d6 + d5) * 0.25D;
                this.demonFish.motionY += (double)this.demonFish.getAIMoveSpeed() * d1 * 0.1D;
                EntityLookHelper entitylookhelper = this.demonFish.getLookHelper();
                double d7 = this.demonFish.posX + d0 / d3 * 2.0D;
                double d8 = (double)this.demonFish.getEyeHeight() + this.demonFish.posY + d1 / d3;
                double d9 = this.demonFish.posZ + d2 / d3 * 2.0D;
                double d10 = entitylookhelper.getLookPosX();
                double d11 = entitylookhelper.getLookPosY();
                double d12 = entitylookhelper.getLookPosZ();

                if (!entitylookhelper.getIsLooking())
                {
                    d10 = d7;
                    d11 = d8;
                    d12 = d9;
                }

                this.demonFish.getLookHelper().setLookPosition(d10 + (d7 - d10) * 0.125D, d11 + (d8 - d11) * 0.125D, d12 + (d9 - d12) * 0.125D, 10.0F, 40.0F);
                this.demonFish.setMoving(true);
            }
            else
            {
                this.demonFish.setAIMoveSpeed(0.0F);
                this.demonFish.setMoving(false);
            }
        }
    }
}
