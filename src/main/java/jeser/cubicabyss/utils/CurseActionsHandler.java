package jeser.cubicabyss.utils;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;

public class CurseActionsHandler {
    public static void execute(EntityPlayer player) {
        System.out.println("curse for " + player.getName() + " curse: " + player.getEntityData().getInteger("curse")
                + "; player's y: " + player.posY + "; curse level " + (player.getPosition().getY() / -1000));
        switch (player.getPosition().getY() / -1000) {
            case 1:
                curseLvl1(player);
                break;
            case 2:
                curseLvl2(player);
                break;
            case 3:
                curseLvl3(player);
                break;
            case 4:
                curseLvl4(player);
                break;
            case 5:
                curseLvl5(player);
                break;
            case 6:
                curseLvl6(player);
                break;
            case 7:
                curseLvl7(player);
                break;
            case 8:
                curseLvl8(player);
                break;
            case 9:
                curseLvl9(player);
                break;
            case 10:
                curseLvl10(player);
                break;
            case 11:
                curseLvl11(player);
                break;
            case 12:
                curseLvl12(player);
                break;
            case 13:
                curseLvl13(player);
                break;
            case 14:
                curseLvl14(player);
                break;
            case 15:
                curseLvl15(player);
                break;
            case 16:
                curseLvl16(player);
                break;
            case 17:
                curseLvl17(player);
                break;
            case 18:
                curseLvl18(player);
                break;
            case 19:
                curseLvl19(player);
                break;
            case 20:
                curseLvl20(player);
                break;
        }
    }

    private static void curseLvl20(EntityPlayer player) {

    }

    private static void curseLvl19(EntityPlayer player) {

    }

    private static void curseLvl18(EntityPlayer player) {

    }

    private static void curseLvl17(EntityPlayer player) {

    }

    private static void curseLvl16(EntityPlayer player) {

    }

    private static void curseLvl15(EntityPlayer player) {

    }

    private static void curseLvl14(EntityPlayer player) {

    }

    private static void curseLvl13(EntityPlayer player) {

    }

    private static void curseLvl12(EntityPlayer player) {

    }

    private static void curseLvl11(EntityPlayer player) {

    }

    private static void curseLvl10(EntityPlayer player) {

    }

    private static void curseLvl9(EntityPlayer player) {

    }

    private static void curseLvl8(EntityPlayer player) {

    }

    private static void curseLvl7(EntityPlayer player) {

    }

    private static void curseLvl6(EntityPlayer player) {

    }

    private static void curseLvl5(EntityPlayer player) {

    }

    private static void curseLvl4(EntityPlayer player) {

    }

    private static void curseLvl3(EntityPlayer player) {

    }

    private static void curseLvl2(EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 200, 10));
        player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 200, 10));
    }

    private static void curseLvl1(EntityPlayer player) {
        player.attackEntityFrom(DamageSource.MAGIC, 0.5f);
    }
}
