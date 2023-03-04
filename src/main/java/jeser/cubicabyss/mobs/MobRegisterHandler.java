package jeser.cubicabyss.mobs;

import jeser.cubicabyss.mobs.DemonFish.DemonFish;
import jeser.cubicabyss.mobs.ExampleMob.ExampleMob;
import jeser.cubicabyss.mobs.Steve.Steve;

public class MobRegisterHandler {
    public static void RegisterAll() {
        Steve.register();
        ExampleMob.register();
        DemonFish.register();
    }
}
