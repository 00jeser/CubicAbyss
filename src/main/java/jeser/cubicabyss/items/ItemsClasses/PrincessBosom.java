package jeser.cubicabyss.items.ItemsClasses;

import baubles.api.BaubleType;
import jeser.cubicabyss.CubicAbyss;
import jeser.cubicabyss.items.Artefact;
import jeser.cubicabyss.items.WearableArtefact;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

public class PrincessBosom extends WearableArtefact {
    public PrincessBosom() {
        super();
        setRegistryName("princess_bosom");
        this.setCreativeTab(CubicAbyss.MOD);
        this.setTranslationKey("princess_bosom");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.HEAD;
    }

    @Override
    public void Action(EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 41));
    }

    @Override
    public Artefact.Elementals getElement() {
        return Elementals.stone;
    }
}
