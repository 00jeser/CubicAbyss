package jeser.cubicabyss.utils;


import net.minecraft.entity.player.EntityPlayer;

public class CurseActionsHandler {
    public static void execute(EntityPlayer player) {
        System.out.println("curse for " + player.getName() + " curse: " + player.getEntityData().getInteger("curse") + "; player's y: " + player.posY);
        switch (player.getPosition().getY() / 1000) {
            case 1:
                curseLvl1();
                break;
            case 2:
                curseLvl2();
                break;
            case 3:
                curseLvl3();
                break;
            case 4:
                curseLvl4();
                break;
            case 5:
                curseLvl5();
                break;
            case 6:
                curseLvl6();
                break;
            case 7:
                curseLvl7();
                break;
            case 8:
                curseLvl8();
                break;
            case 9:
                curseLvl9();
                break;
            case 10:
                curseLvl10();
                break;
            case 11:
                curseLvl11();
                break;
            case 12:
                curseLvl12();
                break;
            case 13:
                curseLvl13();
                break;
            case 14:
                curseLvl14();
                break;
            case 15:
                curseLvl15();
                break;
            case 16:
                curseLvl16();
                break;
            case 17:
                curseLvl17();
                break;
            case 18:
                curseLvl18();
                break;
            case 19:
                curseLvl19();
                break;
            case 20:
                curseLvl20();
                break;
        }
    }

    private static void curseLvl20() {

    }

    private static void curseLvl19() {

    }

    private static void curseLvl18() {

    }

    private static void curseLvl17() {

    }

    private static void curseLvl16() {

    }

    private static void curseLvl15() {

    }

    private static void curseLvl14() {

    }

    private static void curseLvl13() {

    }

    private static void curseLvl12() {

    }

    private static void curseLvl11() {

    }

    private static void curseLvl10() {

    }

    private static void curseLvl9() {

    }

    private static void curseLvl8() {

    }

    private static void curseLvl7() {

    }

    private static void curseLvl6() {

    }

    private static void curseLvl5() {

    }

    private static void curseLvl4() {

    }

    private static void curseLvl3() {

    }

    private static void curseLvl2() {
    }

    private static void curseLvl1() {

    }
}
