package jeser.cubicabyss;

import jeser.cubicabyss.blocks.BlocksRegisterHandler;
import jeser.cubicabyss.items.ItemsRegisterHandler;
import jeser.cubicabyss.misc.CubicAbyssCT;
import jeser.cubicabyss.mobs.MobRegisterHandler;
import jeser.cubicabyss.mobs.RenderHandler;
import jeser.cubicabyss.utils.PlayerUpdate;
import jeser.cubicabyss.world.generator.AbyssWorldGenerator;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import software.bernie.geckolib3.GeckoLib;

@Mod(
        modid = CubicAbyss.MOD_ID,
        name = CubicAbyss.MOD_NAME,
        version = CubicAbyss.VERSION
)
public class CubicAbyss {

    public static final String MOD_ID = "cubicabyss";
    public static final String MOD_NAME = "Cubic Abyss";
    public static final String VERSION = "1.0-SNAPSHOT";
    public static final CreativeTabs MOD = new CubicAbyssCT("Mod");

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static CubicAbyss INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        AbyssWorldGenerator.create();
        BlocksRegisterHandler.registerBlocks();
        RenderHandler.registerEntityRender();
        MobRegisterHandler.RegisterAll();
        ItemsRegisterHandler.RegisterAll();
    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        BlocksRegisterHandler.registerBlocksRender();
        GeckoLib.initialize();
    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    @Mod.EventBusSubscriber
    public static class EventHandler {
        @SubscribeEvent
        public static void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
            if (event.getEntityLiving() instanceof EntityPlayer) {
                PlayerUpdate.Update(event);
            }
        }
    }
}
