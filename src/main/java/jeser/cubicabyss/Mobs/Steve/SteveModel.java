package jeser.cubicabyss.Mobs.Steve;

// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SteveModel extends ModelBase {
    private final ModelRenderer legs;
    private final ModelRenderer leftleg;
    private final ModelRenderer rightleg;
    private final ModelRenderer arms;
    private final ModelRenderer leftarm;
    private final ModelRenderer rightarm;
    private final ModelRenderer chest;
    private final ModelRenderer head;

    public SteveModel() {
        textureWidth = 64;
        textureHeight = 64;

        legs = new ModelRenderer(this);
        legs.setRotationPoint(0.0F, 24.0F, 0.0F);


        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(0.0F, 0.0F, 0.0F);
        legs.addChild(leftleg);
        leftleg.cubeList.add(new ModelBox(leftleg, 40, 37, -6.0F, -14.0F, -4.0F, 5, 14, 5, 0.0F, false));

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(0.0F, 0.0F, 0.0F);
        legs.addChild(rightleg);
        rightleg.cubeList.add(new ModelBox(rightleg, 20, 37, -1.0F, -14.0F, -4.0F, 5, 14, 5, 0.0F, false));

        arms = new ModelRenderer(this);
        arms.setRotationPoint(0.0F, 24.0F, 0.0F);


        leftarm = new ModelRenderer(this);
        leftarm.setRotationPoint(0.0F, 0.0F, 0.0F);
        arms.addChild(leftarm);
        leftarm.cubeList.add(new ModelBox(leftarm, 0, 37, -11.0F, -28.0F, -4.0F, 5, 14, 5, 0.0F, false));

        rightarm = new ModelRenderer(this);
        rightarm.setRotationPoint(0.0F, 0.0F, 0.0F);
        arms.addChild(rightarm);
        rightarm.cubeList.add(new ModelBox(rightarm, 30, 18, 4.0F, -28.0F, -4.0F, 5, 14, 5, 0.0F, false));

        chest = new ModelRenderer(this);
        chest.setRotationPoint(0.0F, 24.0F, 0.0F);
        chest.cubeList.add(new ModelBox(chest, 0, 18, -6.0F, -28.0F, -4.0F, 10, 14, 5, 0.0F, false));

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 24.0F, 0.0F);
        head.cubeList.add(new ModelBox(head, 0, 0, -6.0F, -37.0F, -6.0F, 10, 9, 9, 0.0F, false));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        legs.render(f5);
        arms.render(f5);
        chest.render(f5);
        head.render(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}