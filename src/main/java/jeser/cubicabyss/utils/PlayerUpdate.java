package jeser.cubicabyss.utils;

import jeser.cubicabyss.items.WearableArtefact;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;

public class PlayerUpdate {
    public static void Update(LivingEvent.LivingUpdateEvent event) {
        EntityPlayer player = (EntityPlayer) event.getEntity();
        if (player.getHeldItemMainhand().getItem() instanceof WearableArtefact) {
            WearableArtefact artefact = (WearableArtefact) player.getHeldItemMainhand().getItem();
            artefact.Action(player);
        }
    }
}
