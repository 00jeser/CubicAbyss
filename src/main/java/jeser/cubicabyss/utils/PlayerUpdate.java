package jeser.cubicabyss.utils;

import jeser.cubicabyss.items.WearableArtefact;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;

public class PlayerUpdate {
    public static void Update(LivingEvent.LivingUpdateEvent event) {
        EntityPlayer player = (EntityPlayer) event.getEntity();
        ArtefactUpdate(player);
        CurseUpdate(player);
    }

    private static void ArtefactUpdate(EntityPlayer player) {
        if (player.getHeldItemMainhand().getItem() instanceof WearableArtefact) {
            WearableArtefact artefact = (WearableArtefact) player.getHeldItemMainhand().getItem();
            artefact.Action(player);
        }
    }

    private static void CurseUpdate(EntityPlayer player) {
        if (player.getEntityData().getFloat("curse") > player.getPosition().getY()) {
            player.getEntityData().setFloat("curse", player.getPosition().getY());
        } else if (player.getEntityData().getFloat("curse") + 5 < player.getPosition().getY()) {
            CurseActionsHandler.execute(player);
            player.getEntityData().setFloat("curse", player.getPosition().getY());
        } else if (player.getEntityData().getFloat("curse") < player.getPosition().getY()) {
            player.getEntityData().setFloat("curse", player.getEntityData().getFloat("curse") + 0.02f);
        }
    }
}
