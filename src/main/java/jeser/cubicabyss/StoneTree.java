package jeser.cubicabyss;

import jeser.cubicabyss.blocks.stoneTree.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = StoneTree.MODID, name = StoneTree.NAME, version = StoneTree.VERSION)

public class StoneTree {
    public static final String MODID = "stonetree";
    public static final String NAME = "Stone Tree";
    public static final String VERSION = "1.0";
    public static final String CLIENT = "jeser.cubicabyss.blocks.stoneTree.ClientProxy";
    public static final String COMMON = "jeser.cubicabyss.blocks.stoneTree.CommonProxy";

    @Mod.Instance
    public static StoneTree instance;
    @SidedProxy(clientSide = StoneTree.CLIENT, serverSide = StoneTree.COMMON)
    public static CommonProxy proxy;
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {}
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {}
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {}
}
