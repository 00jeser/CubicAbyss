package jeser.cubicabyss.items.ItemsClasses;

import jeser.cubicabyss.CubicAbyss;
import jeser.cubicabyss.items.Artefact;
import net.minecraft.creativetab.CreativeTabs;

public class StarCompass extends Artefact {
    public StarCompass() {
        super();
        setRegistryName("star_compass");
        this.setCreativeTab(CubicAbyss.MOD);
        this.setTranslationKey("star_compass");
    }

    @Override
    public Artefact.Elementals getElement() {
        return Artefact.Elementals.stone;
    }
}
