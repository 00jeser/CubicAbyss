package jeser.cubicabyss.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

public class PrincessBosom extends Item implements IBauble {
    public PrincessBosom() {
        super();
        setRegistryName("princess_bosom");
        this.setCreativeTab(CreativeTabs.TOOLS);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.HEAD;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        //player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 40));
    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
        IBauble.super.onEquipped(itemstack, player);
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
        IBauble.super.onUnequipped(itemstack, player);
    }

    @Override
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    @Override
    public boolean willAutoSync(ItemStack itemstack, EntityLivingBase player) {
        return IBauble.super.willAutoSync(itemstack, player);
    }
}
