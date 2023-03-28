package jeser.cubicabyss.utils;

import com.google.common.collect.ImmutableMap;
import jeser.cubicabyss.items.ItemsRegisterHandler;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.Arrays;
import java.util.HashSet;

public class ArtefactCraftTable {
    public static ImmutableMap<HashSet<Item>, Item> recipes = ImmutableMap.of(
            new HashSet<>(Arrays.asList(ItemsRegisterHandler.PrincessBosom, ItemsRegisterHandler.StarCompass)), Items.APPLE
    );
    ;

}
