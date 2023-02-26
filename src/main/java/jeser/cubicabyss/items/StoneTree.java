package jeser.cubicabyss.items;

import jeser.cubicabyss.CubicAbyss;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class StoneTree extends Item {
    public StoneTree() {
        super();
        setRegistryName("stone_tree");
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }


}
