package jeser.cubicabyss;

import jeser.cubicabyss.blocks.BlocksRegisterHandler;
import jeser.cubicabyss.items.PrincessBosom;
import jeser.cubicabyss.items.StarCompass;
import jeser.cubicabyss.world.generator.AbyssWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(
        modid = CubicAbyss.MOD_ID,
        name = CubicAbyss.MOD_NAME,
        version = CubicAbyss.VERSION
)
public class CubicAbyss {

    public static final String MOD_ID = "cubicabyss";
    public static final String MOD_NAME = "Cubic Abyss";
    public static final String VERSION = "1.0-SNAPSHOT";

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
    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        BlocksRegisterHandler.registerBlocksRender();
    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    /**
     * Forge will automatically look up and bind blocks to the fields in this class
     * based on their registry name.
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Blocks {
      /*
          public static final MySpecialBlock mySpecialBlock = null; // placeholder for special block below
      */
    }

    /**
     * Forge will automatically look up and bind items to the fields in this class
     * based on their registry name.
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Items {
      /*
          public static final ItemBlock mySpecialBlock = null; // itemblock for the block above
          public static final MySpecialItem mySpecialItem = null; // placeholder for special item below
      */
    }

    /**
     * This is a special class that listens to registry events, to allow creation of mod blocks and items at the proper time.
     */
    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {
        /**
         * Listen for the register event for creating custom items
         */
        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
            //registryItem(new StoneTree(), event);
            //registryItem(new ItemBlock(new StoneTree()), event);
            registryItem(new PrincessBosom(), event);
            registryItem(new StarCompass(), event);
        }

        @SideOnly(Side.CLIENT)
        private static void registryModel(Item item) {
            final ResourceLocation regName = item.getRegistryName();
            final ModelResourceLocation mrl = new ModelResourceLocation(regName, "inventory");
            ModelBakery.registerItemVariants(item, mrl);
            ModelLoader.setCustomModelResourceLocation(item, 0, mrl);
        }
        /**
         * Listen for the register event for creating custom blocks
         */
        @SubscribeEvent
        public static void addBlocks(RegistryEvent.Register<Block> event) {
            /*
             event.getRegistry().register(new MySpecialBlock().setRegistryName(MOD_ID, "mySpecialBlock"));
            */
        }
        public static void registryItem(Item a, RegistryEvent.Register<Item> event) {
            event.getRegistry().register(a);
            registryModel(a);
        }
        public static void registryBlock(Block block, RegistryEvent.Register<Block> event) {
            ItemBlock ib = new ItemBlock(block);
            event.getRegistry().register(block);
            //registryModel(block);
        }
        @SubscribeEvent
        public static void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {}
    }
    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        //event.getRegistry().register(new StoneTree());
        event.getRegistry().register(new PrincessBosom());
        event.getRegistry().register(new StarCompass());
    }
    /*
    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new jeser.cubicabyss.blocks.StoneTree());
    }
     */



    /* EXAMPLE ITEM AND BLOCK - you probably want these in separate files
    public static class MySpecialItem extends Item {

    }

    public static class MySpecialBlock extends Block {

    }
    */
}
