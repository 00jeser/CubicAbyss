package jeser.cubicabyss.Mobs;

import jeser.cubicabyss.Mobs.ExampleMob.ExampleMob;
import jeser.cubicabyss.Mobs.Steve.Steve;

public class MobRegisterHandler {
    public static void RegisterAll() {
        Steve.register();
        ExampleMob.register();
    }
}
