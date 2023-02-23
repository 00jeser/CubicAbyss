package jeser.cubicabyss.Mobs.ExampleMob;// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ExampleMobModel extends ModelBase {
    private final ModelRenderer body;
    private final ModelRenderer booty2_r1;
    private final ModelRenderer booty1_r1;
    private final ModelRenderer body35_r1;
    private final ModelRenderer body3_r1;
    private final ModelRenderer body2_r1;
    private final ModelRenderer head;
    private final ModelRenderer lfang2_r1;
    private final ModelRenderer lfang_r1;
    private final ModelRenderer rfang2_r1;
    private final ModelRenderer rfang_r1;
    private final ModelRenderer head_r1;
    private final ModelRenderer legs;
    private final ModelRenderer rleg1;
    private final ModelRenderer bone2;
    private final ModelRenderer rleg13_r1;
    private final ModelRenderer rleg11_r1;
    private final ModelRenderer rleg1_r1;
    private final ModelRenderer rleg14_r1;
    private final ModelRenderer rleg2;
    private final ModelRenderer bone;
    private final ModelRenderer rleg14_r2;
    private final ModelRenderer rleg22_r1;
    private final ModelRenderer rleg2_r1;
    private final ModelRenderer rleg15_r1;
    private final ModelRenderer lleg1;
    private final ModelRenderer bone3;
    private final ModelRenderer rleg14_r3;
    private final ModelRenderer rleg22_r2;
    private final ModelRenderer rleg2_r2;
    private final ModelRenderer rleg15_r2;
    private final ModelRenderer lleg2;
    private final ModelRenderer bone4;
    private final ModelRenderer rleg15_r3;
    private final ModelRenderer rleg33_r1;
    private final ModelRenderer rleg3_r1;
    private final ModelRenderer rleg16_r1;
    private final ModelRenderer bone5;
    private final ModelRenderer arms;
    private final ModelRenderer rarm;
    private final ModelRenderer bone6;
    private final ModelRenderer rleg14_r4;
    private final ModelRenderer rleg22_r3;
    private final ModelRenderer rleg2_r3;
    private final ModelRenderer rleg15_r4;
    private final ModelRenderer larm;
    private final ModelRenderer bone7;
    private final ModelRenderer rleg15_r5;
    private final ModelRenderer rleg33_r2;
    private final ModelRenderer rleg3_r2;
    private final ModelRenderer rleg16_r2;

    public ExampleMobModel() {
        textureWidth = 128;
        textureHeight = 128;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.cubeList.add(new ModelBox(body, 52, 0, -4.0F, -19.0F, -5.0F, 8, 7, 9, 0.0F, false));

        booty2_r1 = new ModelRenderer(this);
        booty2_r1.setRotationPoint(0.0F, -26.0F, 20.0F);
        body.addChild(booty2_r1);
        setRotationAngle(booty2_r1, -0.5672F, 0.0F, 0.0F);
        booty2_r1.cubeList.add(new ModelBox(booty2_r1, 0, 0, -8.0F, -11.0F, -5.0F, 16, 12, 20, 0.0F, false));

        booty1_r1 = new ModelRenderer(this);
        booty1_r1.setRotationPoint(0.0F, -24.0F, 8.0F);
        body.addChild(booty1_r1);
        setRotationAngle(booty1_r1, 0.0873F, 0.0F, 0.0F);
        booty1_r1.cubeList.add(new ModelBox(booty1_r1, 0, 32, -7.0F, -13.0F, 0.0F, 14, 11, 14, 0.0F, false));

        body35_r1 = new ModelRenderer(this);
        body35_r1.setRotationPoint(0.0F, -23.0F, 9.0F);
        body.addChild(body35_r1);
        setRotationAngle(body35_r1, 1.0908F, 0.0F, 0.0F);
        body35_r1.cubeList.add(new ModelBox(body35_r1, 0, 0, -2.0F, -1.0F, 3.0F, 4, 5, 6, 0.0F, false));

        body3_r1 = new ModelRenderer(this);
        body3_r1.setRotationPoint(0.0F, -23.0F, 9.0F);
        body.addChild(body3_r1);
        setRotationAngle(body3_r1, 0.9163F, 0.0F, 0.0F);
        body3_r1.cubeList.add(new ModelBox(body3_r1, 42, 32, -3.0F, -2.0F, -2.0F, 6, 6, 6, 0.0F, false));

        body2_r1 = new ModelRenderer(this);
        body2_r1.setRotationPoint(0.0F, -19.0F, 4.0F);
        body.addChild(body2_r1);
        setRotationAngle(body2_r1, 0.48F, 0.0F, 0.0F);
        body2_r1.cubeList.add(new ModelBox(body2_r1, 47, 48, -5.0F, -2.0F, -3.0F, 10, 8, 9, 0.0F, false));

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 24.0F, 0.0F);


        lfang2_r1 = new ModelRenderer(this);
        lfang2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(lfang2_r1);
        setRotationAngle(lfang2_r1, 0.7956F, -0.2791F, -0.4019F);
        lfang2_r1.cubeList.add(new ModelBox(lfang2_r1, 76, 48, -2.5F, -16.2F, -0.5F, 2, 2, 3, 0.0F, false));

        lfang_r1 = new ModelRenderer(this);
        lfang_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(lfang_r1);
        setRotationAngle(lfang_r1, 0.8452F, 0.3326F, 0.3527F);
        lfang_r1.cubeList.add(new ModelBox(lfang_r1, 0, 32, -5.0F, -16.0F, -1.0F, 2, 2, 4, 0.0F, false));

        rfang2_r1 = new ModelRenderer(this);
        rfang2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(rfang2_r1);
        setRotationAngle(rfang2_r1, 0.807F, 0.3151F, 0.1852F);
        rfang2_r1.cubeList.add(new ModelBox(rfang2_r1, 77, 0, 3.5F, -15.5F, 0.0F, 2, 2, 3, 0.0F, false));

        rfang_r1 = new ModelRenderer(this);
        rfang_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(rfang_r1);
        setRotationAngle(rfang_r1, 0.8452F, -0.3326F, -0.3527F);
        rfang_r1.cubeList.add(new ModelBox(rfang_r1, 0, 38, 3.0F, -16.0F, -1.0F, 2, 2, 4, 0.0F, false));

        head_r1 = new ModelRenderer(this);
        head_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(head_r1);
        setRotationAngle(head_r1, 0.2618F, 0.0F, 0.0F);
        head_r1.cubeList.add(new ModelBox(head_r1, 0, 57, -3.0F, -19.0F, -6.0F, 6, 5, 6, 0.0F, false));

        legs = new ModelRenderer(this);
        legs.setRotationPoint(0.0F, -2.0F, 20.0F);


        rleg1 = new ModelRenderer(this);
        rleg1.setRotationPoint(0.0F, 0.0F, 0.0F);
        legs.addChild(rleg1);


        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(14.0F, 12.0F, -20.0F);
        rleg1.addChild(bone2);
        setRotationAngle(bone2, 0.0F, 0.1745F, 0.0F);


        rleg13_r1 = new ModelRenderer(this);
        rleg13_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone2.addChild(rleg13_r1);
        setRotationAngle(rleg13_r1, 0.0F, 0.0F, 1.1345F);
        rleg13_r1.cubeList.add(new ModelBox(rleg13_r1, 66, 36, -0.0939F, -0.1457F, -1.0F, 13, 2, 2, 0.0F, false));

        rleg11_r1 = new ModelRenderer(this);
        rleg11_r1.setRotationPoint(-6.0F, 9.0F, 0.0F);
        bone2.addChild(rleg11_r1);
        setRotationAngle(rleg11_r1, 0.0F, 0.0F, 2.0508F);
        rleg11_r1.cubeList.add(new ModelBox(rleg11_r1, 24, 73, -10.8475F, -1.312F, -1.0F, 10, 2, 2, 0.0F, false));

        rleg1_r1 = new ModelRenderer(this);
        rleg1_r1.setRotationPoint(-10.0F, 1.0F, 0.0F);
        bone2.addChild(rleg1_r1);
        setRotationAngle(rleg1_r1, 0.0F, 0.0F, 0.9599F);
        rleg1_r1.cubeList.add(new ModelBox(rleg1_r1, 48, 73, -1.0F, -1.0F, -1.0F, 10, 2, 2, 0.0F, false));

        rleg14_r1 = new ModelRenderer(this);
        rleg14_r1.setRotationPoint(6.0F, 12.0F, 0.0F);
        bone2.addChild(rleg14_r1);
        setRotationAngle(rleg14_r1, 0.0F, 0.0F, 0.5236F);
        rleg14_r1.cubeList.add(new ModelBox(rleg14_r1, 12, 76, -1.5053F, -0.7792F, -1.0F, 4, 2, 2, 0.0F, false));

        rleg2 = new ModelRenderer(this);
        rleg2.setRotationPoint(0.0F, 0.0F, 0.0F);
        legs.addChild(rleg2);


        bone = new ModelRenderer(this);
        bone.setRotationPoint(14.0F, 11.0F, -9.0F);
        rleg2.addChild(bone);
        setRotationAngle(bone, 0.0F, -0.48F, 0.0F);


        rleg14_r2 = new ModelRenderer(this);
        rleg14_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone.addChild(rleg14_r2);
        setRotationAngle(rleg14_r2, 0.0F, 0.0F, 1.1345F);
        rleg14_r2.cubeList.add(new ModelBox(rleg14_r2, 54, 65, -0.0939F, -0.1457F, -1.0F, 13, 2, 2, 0.0F, false));

        rleg22_r1 = new ModelRenderer(this);
        rleg22_r1.setRotationPoint(-6.0F, 9.0F, 0.0F);
        bone.addChild(rleg22_r1);
        setRotationAngle(rleg22_r1, 0.0F, 0.0F, 2.0508F);
        rleg22_r1.cubeList.add(new ModelBox(rleg22_r1, 72, 28, -10.8475F, -1.312F, -1.0F, 10, 2, 2, 0.0F, false));

        rleg2_r1 = new ModelRenderer(this);
        rleg2_r1.setRotationPoint(-10.0F, 1.0F, 0.0F);
        bone.addChild(rleg2_r1);
        setRotationAngle(rleg2_r1, 0.0F, 0.0F, 0.9599F);
        rleg2_r1.cubeList.add(new ModelBox(rleg2_r1, 72, 24, -1.0F, -1.0F, -1.0F, 10, 2, 2, 0.0F, false));

        rleg15_r1 = new ModelRenderer(this);
        rleg15_r1.setRotationPoint(6.0F, 12.0F, 0.0F);
        bone.addChild(rleg15_r1);
        setRotationAngle(rleg15_r1, 0.0F, 0.0F, 0.7418F);
        rleg15_r1.cubeList.add(new ModelBox(rleg15_r1, 0, 76, -1.5053F, -0.2792F, -1.0F, 4, 2, 2, 0.0F, false));

        lleg1 = new ModelRenderer(this);
        lleg1.setRotationPoint(0.0F, 0.0F, 0.0F);
        legs.addChild(lleg1);


        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(-14.0F, 12.0F, -20.0F);
        lleg1.addChild(bone3);
        setRotationAngle(bone3, 0.0F, -0.1745F, 0.0F);


        rleg14_r3 = new ModelRenderer(this);
        rleg14_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone3.addChild(rleg14_r3);
        setRotationAngle(rleg14_r3, 0.0F, 0.0F, -1.1345F);
        rleg14_r3.cubeList.add(new ModelBox(rleg14_r3, 24, 65, -12.9061F, -0.1457F, -1.0F, 13, 2, 2, 0.0F, false));

        rleg22_r2 = new ModelRenderer(this);
        rleg22_r2.setRotationPoint(6.0F, 9.0F, 0.0F);
        bone3.addChild(rleg22_r2);
        setRotationAngle(rleg22_r2, 0.0F, 0.0F, -2.0508F);
        rleg22_r2.cubeList.add(new ModelBox(rleg22_r2, 0, 72, 0.8475F, -1.312F, -1.0F, 10, 2, 2, 0.0F, false));

        rleg2_r2 = new ModelRenderer(this);
        rleg2_r2.setRotationPoint(10.0F, 1.0F, 0.0F);
        bone3.addChild(rleg2_r2);
        setRotationAngle(rleg2_r2, 0.0F, 0.0F, -0.9599F);
        rleg2_r2.cubeList.add(new ModelBox(rleg2_r2, 72, 20, -9.0F, -1.0F, -1.0F, 10, 2, 2, 0.0F, false));

        rleg15_r2 = new ModelRenderer(this);
        rleg15_r2.setRotationPoint(-6.0F, 12.0F, 0.0F);
        bone3.addChild(rleg15_r2);
        setRotationAngle(rleg15_r2, 0.0F, 0.0F, -0.5236F);
        rleg15_r2.cubeList.add(new ModelBox(rleg15_r2, 70, 75, -2.4947F, -0.7792F, -1.0F, 4, 2, 2, 0.0F, false));

        lleg2 = new ModelRenderer(this);
        lleg2.setRotationPoint(0.0F, 0.0F, 0.0F);
        legs.addChild(lleg2);


        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(-14.0F, 11.0F, -9.0F);
        lleg2.addChild(bone4);
        setRotationAngle(bone4, 0.0F, 0.48F, 0.0F);


        rleg15_r3 = new ModelRenderer(this);
        rleg15_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone4.addChild(rleg15_r3);
        setRotationAngle(rleg15_r3, 0.0F, 0.0F, -1.1345F);
        rleg15_r3.cubeList.add(new ModelBox(rleg15_r3, 60, 32, -12.9061F, -0.1457F, -1.0F, 13, 2, 2, 0.0F, false));

        rleg33_r1 = new ModelRenderer(this);
        rleg33_r1.setRotationPoint(6.0F, 9.0F, 0.0F);
        bone4.addChild(rleg33_r1);
        setRotationAngle(rleg33_r1, 0.0F, 0.0F, -2.0508F);
        rleg33_r1.cubeList.add(new ModelBox(rleg33_r1, 48, 69, 0.8475F, -1.312F, -1.0F, 10, 2, 2, 0.0F, false));

        rleg3_r1 = new ModelRenderer(this);
        rleg3_r1.setRotationPoint(10.0F, 1.0F, 0.0F);
        bone4.addChild(rleg3_r1);
        setRotationAngle(rleg3_r1, 0.0F, 0.0F, -0.9599F);
        rleg3_r1.cubeList.add(new ModelBox(rleg3_r1, 70, 71, -9.0F, -1.0F, -1.0F, 10, 2, 2, 0.0F, false));

        rleg16_r1 = new ModelRenderer(this);
        rleg16_r1.setRotationPoint(-6.0F, 12.0F, 0.0F);
        bone4.addChild(rleg16_r1);
        setRotationAngle(rleg16_r1, 0.0F, 0.0F, -0.7418F);
        rleg16_r1.cubeList.add(new ModelBox(rleg16_r1, 24, 61, -2.4947F, -0.2792F, -1.0F, 4, 2, 2, 0.0F, false));

        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone4.addChild(bone5);


        arms = new ModelRenderer(this);
        arms.setRotationPoint(0.0F, 24.0F, 0.0F);


        rarm = new ModelRenderer(this);
        rarm.setRotationPoint(0.0F, 0.0F, 0.0F);
        arms.addChild(rarm);


        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(14.0F, -16.0F, -6.0F);
        rarm.addChild(bone6);
        setRotationAngle(bone6, -0.2618F, 0.3491F, 0.0F);


        rleg14_r4 = new ModelRenderer(this);
        rleg14_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone6.addChild(rleg14_r4);
        setRotationAngle(rleg14_r4, 0.0F, 0.0F, 1.4399F);
        rleg14_r4.cubeList.add(new ModelBox(rleg14_r4, 56, 44, -1.0939F, -1.1457F, -1.0F, 13, 2, 2, 0.0F, false));

        rleg22_r3 = new ModelRenderer(this);
        rleg22_r3.setRotationPoint(-6.0F, 9.0F, 0.0F);
        bone6.addChild(rleg22_r3);
        setRotationAngle(rleg22_r3, 0.0F, 0.0F, 2.0508F);
        rleg22_r3.cubeList.add(new ModelBox(rleg22_r3, 0, 68, -11.8475F, -1.312F, -1.0F, 10, 2, 2, 0.0F, false));

        rleg2_r3 = new ModelRenderer(this);
        rleg2_r3.setRotationPoint(-10.0F, 1.0F, 0.0F);
        bone6.addChild(rleg2_r3);
        setRotationAngle(rleg2_r3, 0.0F, 0.0F, 0.6981F);
        rleg2_r3.cubeList.add(new ModelBox(rleg2_r3, 24, 69, -1.0F, 0.0F, -1.0F, 10, 2, 2, 0.0F, false));

        rleg15_r4 = new ModelRenderer(this);
        rleg15_r4.setRotationPoint(6.0F, 12.0F, 0.0F);
        bone6.addChild(rleg15_r4);
        setRotationAngle(rleg15_r4, 0.0F, 0.0F, 2.5307F);
        rleg15_r4.cubeList.add(new ModelBox(rleg15_r4, 0, 15, 2.4947F, 2.2208F, -1.0F, 6, 2, 2, 0.0F, false));

        larm = new ModelRenderer(this);
        larm.setRotationPoint(0.0F, 0.0F, 0.0F);
        arms.addChild(larm);


        bone7 = new ModelRenderer(this);
        bone7.setRotationPoint(-14.0F, -16.0F, -6.0F);
        larm.addChild(bone7);
        setRotationAngle(bone7, -0.2618F, -0.3491F, 0.0F);


        rleg15_r5 = new ModelRenderer(this);
        rleg15_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone7.addChild(rleg15_r5);
        setRotationAngle(rleg15_r5, 0.0F, 0.0F, -1.4399F);
        rleg15_r5.cubeList.add(new ModelBox(rleg15_r5, 52, 16, -11.9061F, -1.1457F, -1.0F, 13, 2, 2, 0.0F, false));

        rleg33_r2 = new ModelRenderer(this);
        rleg33_r2.setRotationPoint(6.0F, 9.0F, 0.0F);
        bone7.addChild(rleg33_r2);
        setRotationAngle(rleg33_r2, 0.0F, 0.0F, -2.0508F);
        rleg33_r2.cubeList.add(new ModelBox(rleg33_r2, 18, 57, 1.8475F, -1.312F, -1.0F, 10, 2, 2, 0.0F, false));

        rleg3_r2 = new ModelRenderer(this);
        rleg3_r2.setRotationPoint(10.0F, 1.0F, 0.0F);
        bone7.addChild(rleg3_r2);
        setRotationAngle(rleg3_r2, 0.0F, 0.0F, -0.6981F);
        rleg3_r2.cubeList.add(new ModelBox(rleg3_r2, 66, 40, -9.0F, 0.0F, -1.0F, 10, 2, 2, 0.0F, false));

        rleg16_r2 = new ModelRenderer(this);
        rleg16_r2.setRotationPoint(-6.0F, 12.0F, 0.0F);
        bone7.addChild(rleg16_r2);
        setRotationAngle(rleg16_r2, 0.0F, 0.0F, -2.5307F);
        rleg16_r2.cubeList.add(new ModelBox(rleg16_r2, 0, 11, -8.4947F, 2.2208F, -1.0F, 6, 2, 2, 0.0F, false));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        body.render(f5);
        head.render(f5);
        legs.render(f5);
        arms.render(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}