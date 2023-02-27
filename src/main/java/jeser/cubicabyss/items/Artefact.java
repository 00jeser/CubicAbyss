package jeser.cubicabyss.items;

import net.minecraft.item.Item;

public class Artefact extends Item {
    public enum Elementals {
        none,
        stone,
        air,
        water,
        natural,
        fire
    }

    public Elementals getElement() {
        return Elementals.none;
    }
}
