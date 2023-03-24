package jeser.cubicabyss.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

import java.util.Random;

public class RiverMovingAI extends EntityAIBase {
    private EntityLiving mob;
    private Random rand;
    private int swimTimer;
    public RiverMovingAI(EntityLiving mob) {
        this.mob = mob;
        this.rand = new Random();
    }
    @Override
    public boolean shouldExecute() {
        // определяем, должен ли моб выполнять эту AI
        // в данном случае, моб будет выполнять AI, если находится в воде
        return mob.isInWater();
    }

    @Override
    public void startExecuting() {
        // выполняем действия при начале выполнения AI
        // здесь вы можете произвести какие-либо инициализации
        swimTimer = 0;
    }

    @Override
    public void updateTask() {
        // выполняем действия при обновлении AI
        // здесь мы будем случайным образом изменять направление движения моба в реке

        // шанс изменения направления движения
        double chance = 0.05;

        // проверяем, случайно ли нужно изменить направление движения
        if (rand.nextDouble() < chance) {
            // выбираем случайный угол поворота и расстояние для передвижения
            double angle = rand.nextDouble() * Math.PI * 2;
            double distance = rand.nextDouble() * 8 + 8;

            // вычисляем новые координаты места назначения
            double destX = mob.posX + distance * Math.sin(angle);
            double destZ = mob.posZ + distance * Math.cos(angle);

            // устанавливаем новое направление движения
            mob.getNavigator().tryMoveToXYZ(destX, mob.posY, destZ, 0.3);
        }

        // изменяем вертикальное положение моба
        if (rand.nextDouble() < 0.3) {
            // случайным образом меняем высоту моба
            double deltaY = rand.nextDouble() * 0.4 - 0.2;
            mob.motionY += deltaY;
        }

        // изменяем таймер плавания
        swimTimer++;
        if (swimTimer >= 40) {
            // когда таймер достигнет определенной отметки,
            // меняем направление плавания на противоположное
            mob.motionX = -mob.motionX;
            mob.motionZ = -mob.motionZ;
            swimTimer = 0;
        }
    }

    @Override
    public void resetTask() {
        // выполняем действия при сбросе AI
        // здесь мы можем производить какие-либо действия при завершении выполнения AI
    }
}
