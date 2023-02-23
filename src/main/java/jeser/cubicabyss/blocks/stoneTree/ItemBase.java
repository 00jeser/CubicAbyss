package jeser.cubicabyss.blocks.stoneTree;

import jeser.cubicabyss.StoneTree;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
    public ItemBase(String name){
        //setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);

        ItemInit.ITEMS.add(this);
    }
    @Override
    public void registerModels(){
        StoneTree.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
