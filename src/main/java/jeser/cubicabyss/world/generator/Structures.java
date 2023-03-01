package jeser.cubicabyss.world.generator;

import jeser.cubicabyss.CubicAbyss;
import jeser.cubicabyss.world.biomes.AbyssBiome;
import net.minecraft.util.ResourceLocation;

import static jeser.cubicabyss.world.biomes.BiomesProvider.ABYSS_PLANTS;

public class Structures {
    public static final Structure[] UPSTRUCTURES = new Structure[]{
            new Structure(
                    new ResourceLocation(CubicAbyss.MOD_ID, "smallruines"),
                    -10000, 0,
                    1000
            ),
            new Structure(
                    new ResourceLocation(CubicAbyss.MOD_ID, "stonetree1"),
                    -2000, 0,
                    100, true,
                    new AbyssBiome[]{ABYSS_PLANTS}
            )
    };
    public static final Structure[] DOWNSTRUCTURES = new Structure[]{
            new Structure(
                    new ResourceLocation(CubicAbyss.MOD_ID, "glowstones/glowstone1"),
                    -20000, 0,
                    1000
            ),
            new Structure(
                    new ResourceLocation(CubicAbyss.MOD_ID, "glowstones/glowstone2"),
                    -20000, 0,
                    1000
            ),
            new Structure(
                    new ResourceLocation(CubicAbyss.MOD_ID, "glowstones/glowstone3"),
                    -20000, 0,
                    1000
            )
    };
    public static final Structure[] AIRSTRUCTURES = new Structure[]{
    };
    public static final Structure[] INSIDESTRUCTURES = new Structure[]{
    };

    public static class Structure {
        public ResourceLocation location;
        public int minHeight, maxHeight;
        // шанс появления структуры в каждом втором блоке равен 1/rare
        public int rare;
        public boolean rotate;
        public AbyssBiome[] availableBiomes;

        public Structure(ResourceLocation location,
                         int minHeight, int maxHeight,
                         int rare,
                         boolean rotate,
                         AbyssBiome[] availableBiomes) {
            this.location = location;
            this.minHeight = minHeight;
            this.maxHeight = maxHeight;
            this.rare = rare;
            this.rotate = rotate;
            this.availableBiomes = availableBiomes;
        }

        public Structure(ResourceLocation location, int minHeight, int maxHeight, int rare) {
            this(location, minHeight, maxHeight, rare, true, new AbyssBiome[]{});
        }
    }
}
