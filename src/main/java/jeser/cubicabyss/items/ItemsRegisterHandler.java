package jeser.cubicabyss.items;

import jeser.cubicabyss.items.ItemsClasses.PrincessBosom;
import jeser.cubicabyss.items.ItemsClasses.StarCompass;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemsRegisterHandler {
    public static Item PrincessBosom = new PrincessBosom();
    public static Item StarCompass = new StarCompass();

    public static void RegisterAll() {
        registryItem(PrincessBosom);
        registryItem(StarCompass);
    }

    public static void registryItem(Item a) {
        ForgeRegistries.ITEMS.register(a);
        registryModel(a);
    }

    @SideOnly(Side.CLIENT)
    private static void registryModel(Item item) {
        final ResourceLocation regName = item.getRegistryName();
        final ModelResourceLocation mrl = new ModelResourceLocation(regName, "inventory");
        ModelBakery.registerItemVariants(item, mrl);
        ModelLoader.setCustomModelResourceLocation(item, 0, mrl);
    }
}
