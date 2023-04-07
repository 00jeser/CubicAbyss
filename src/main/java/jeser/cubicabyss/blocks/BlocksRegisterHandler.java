package jeser.cubicabyss.blocks;

import jeser.cubicabyss.blocks.ArtefactWorkbench.ArtefactWorkbenchBlock;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlocksRegisterHandler {
    public static final ArtefactWorkbenchBlock ARTEFACT_WORKBENCH_BLOCK = new ArtefactWorkbenchBlock();
    public static final Block[] blocks = new Block[]{
            new StoneTree(),
            new GlowGrass(),
            ARTEFACT_WORKBENCH_BLOCK
    };

    public static void registerBlocks() {
        for (Block b : blocks)
            BlocksRegister.register(b);

    }

    public static void registerBlocksRender() {
        for (Block b : blocks)
            BlocksRegister.registerRender(b);
    }

    public static class BlocksRegister {

        public static void register(Block block) {
            setRegister(block);
        }

        @SideOnly(Side.CLIENT)
        public static void registerRender(Block block) {
            setRender(block);
        }

        private static void setRegister(Block block) {
            ForgeRegistries.BLOCKS.register(block);
            ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        }

        @SideOnly(Side.CLIENT)
        private static void setRender(Block block) {
            ItemModelMesher mm = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
            Item i = Item.getItemFromBlock(block);
            ModelResourceLocation rl = new ModelResourceLocation(block.getRegistryName(), "inventory");
            mm.register(i, 0, rl);
        }
    }
}
