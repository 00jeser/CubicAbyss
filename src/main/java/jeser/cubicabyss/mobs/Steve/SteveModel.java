package jeser.cubicabyss.mobs.Steve;// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class SteveModel extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer head_r1;
	private final ModelRenderer chest;
	private final ModelRenderer chest_r1;
	private final ModelRenderer arms;
	private final ModelRenderer legs;
	private final ModelRenderer rightleg_r1;
	private final ModelRenderer leftleg_r1;

	public SteveModel() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 4.0F, 0.0F);
		

		head_r1 = new ModelRenderer(this);
		head_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(head_r1);
		setRotationAngle(head_r1, 0.0F, 3.1416F, 0.0F);
		head_r1.cubeList.add(new ModelBox(head_r1, 0, 1, -4.0F, -7.0F, -5.0F, 8, 7, 8, 0.0F, false));

		chest = new ModelRenderer(this);
		chest.setRotationPoint(0.0F, 9.0F, 0.0F);
		

		chest_r1 = new ModelRenderer(this);
		chest_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		chest.addChild(chest_r1);
		setRotationAngle(chest_r1, 0.0F, 1.5708F, 0.0F);
		chest_r1.cubeList.add(new ModelBox(chest_r1, 0, 16, -3.0F, -5.0F, -4.0F, 4, 10, 8, 0.0F, false));

		arms = new ModelRenderer(this);
		arms.setRotationPoint(0.0F, 5.0F, -4.0F);
		arms.cubeList.add(new ModelBox(arms, 24, 16, -8.0F, -1.0F, 3.0F, 4, 10, 4, 0.0F, false));
		arms.cubeList.add(new ModelBox(arms, 20, 30, 4.0F, -1.0F, 3.0F, 4, 10, 4, 0.0F, false));

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, 14.0F, 2.0F);
		

		rightleg_r1 = new ModelRenderer(this);
		rightleg_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		legs.addChild(rightleg_r1);
		setRotationAngle(rightleg_r1, 0.0F, 3.1416F, 0.0F);
		rightleg_r1.cubeList.add(new ModelBox(rightleg_r1, 32, 0, 0.0F, 0.0F, -1.0F, 4, 10, 4, 0.0F, false));

		leftleg_r1 = new ModelRenderer(this);
		leftleg_r1.setRotationPoint(0.0F, 0.0F, -4.0F);
		legs.addChild(leftleg_r1);
		setRotationAngle(leftleg_r1, 0.0F, 3.1416F, 0.0F);
		leftleg_r1.cubeList.add(new ModelBox(leftleg_r1, 0, 34, -4.0F, 0.0F, -5.0F, 4, 10, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		chest.render(f5);
		arms.render(f5);
		legs.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.leftleg_r1.rotateAngleX = MathHelper.sin(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.rightleg_r1.rotateAngleX = MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

		this.head.rotateAngleY = netHeadYaw / (180F / (float)Math.PI);
		this.head.rotateAngleX = headPitch / (180F / (float)Math.PI);


	}
}