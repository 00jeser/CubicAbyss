package jeser.cubicabyss.world.generator;

import jeser.cubicabyss.CubicAbyss;
import net.minecraft.util.ResourceLocation;

public class Structures {
    public static final Structure[] UPSTRUCTURES = new Structure[]{
            new Structure(
                    new ResourceLocation(CubicAbyss.MOD_ID, "smallruines"),
                    -10000, 0,
                    1000
            )
    };
    public static final Structure[] DOWNSTRUCTURES = new Structure[]{
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

        public Structure(ResourceLocation location,
                         int minHeight, int maxHeight,
                         int rare,
                         boolean rotate /*todo biomes*/) {
            this.location = location;
            this.minHeight = minHeight;
            this.maxHeight = maxHeight;
            this.rare = rare;
            this.rotate = rotate;
        }

        public Structure(ResourceLocation location, int minHeight, int maxHeight, int rare) {
            this(location, minHeight, maxHeight, rare, true);
        }
    }
}
