package jeser.cubicabyss.misc;

import jeser.cubicabyss.blocks.BlocksRegisterHandler;
import jeser.cubicabyss.blocks.StoneTree;
import jeser.cubicabyss.items.ItemsRegisterHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CubicAbyssCT extends CreativeTabs {
    public CubicAbyssCT(String label) {
        super(label);
    }
    @Override
    public ItemStack createIcon() {
        return new ItemStack(Item.getItemFromBlock(Blocks.OBSIDIAN));
    }
}
