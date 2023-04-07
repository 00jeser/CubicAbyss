package jeser.cubicabyss.blocks;

import jeser.cubicabyss.CubicAbyss;
import jeser.cubicabyss.misc.CubicAbyssCT;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class GlowGrass extends Block {
    public GlowGrass() {
        super(Material.GRASS);
        this.setCreativeTab(CubicAbyss.MOD);
        this.setSoundType(SoundType.PLANT);
        this.setLightLevel(5.0f);
        this.setRegistryName("glow_grass");
        //this.setTranslationKey("glow_grass");
    }

}
