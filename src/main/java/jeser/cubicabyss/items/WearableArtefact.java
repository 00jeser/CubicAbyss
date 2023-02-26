package jeser.cubicabyss.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public abstract class WearableArtefact extends Artefact implements IBauble {
    public abstract void Action(EntityPlayer player);

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return null;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        Action((EntityPlayer) player);
    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }
}
