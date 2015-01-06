/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2015
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
// Date: 13-03-2014 09:44:42
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package Reika.ElectriCraft.Renders;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import Reika.DragonAPI.Instantiable.Rendering.LODModelPart;
import Reika.DragonAPI.Libraries.Registry.ReikaDyeHelper;
import Reika.RotaryCraft.Base.RotaryModelBase;

public class ModelResistor extends RotaryModelBase
{
	//fields
	LODModelPart Shape1;
	LODModelPart Shape2a;
	LODModelPart Shape2;
	LODModelPart Shape3a;
	LODModelPart Shape3;
	LODModelPart Shape3b;
	LODModelPart Shape3c;
	LODModelPart band3b;
	LODModelPart band2a;
	LODModelPart band3a;
	LODModelPart band1a;
	LODModelPart band1b;
	LODModelPart band2b;

	public ModelResistor()
	{
		textureWidth = 128;
		textureHeight = 128;

		Shape1 = new LODModelPart(this, 63, 0);
		Shape1.addBox(0F, 0F, 0F, 12, 5, 16);
		Shape1.setRotationPoint(-6F, 19F, -8F);
		Shape1.setTextureSize(128, 128);
		Shape1.mirror = true;
		this.setRotation(Shape1, 0F, 0F, 0F);
		Shape2a = new LODModelPart(this, 63, 23);
		Shape2a.addBox(0F, 0F, 0F, 6, 2, 16);
		Shape2a.setRotationPoint(-3F, 12F, -8F);
		Shape2a.setTextureSize(128, 128);
		Shape2a.mirror = true;
		this.setRotation(Shape2a, 0F, 0F, 0F);
		Shape2 = new LODModelPart(this, 0, 18);
		Shape2.addBox(0F, 0F, 0F, 8, 5, 16);
		Shape2.setRotationPoint(-4F, 14F, -8F);
		Shape2.setTextureSize(128, 128);
		Shape2.mirror = true;
		this.setRotation(Shape2, 0F, 0F, 0F);
		Shape3a = new LODModelPart(this, 0, 41);
		Shape3a.addBox(0F, 0F, 0F, 8, 1, 15);
		Shape3a.setRotationPoint(-4F, 12.5F, -7.5F);
		Shape3a.setTextureSize(128, 128);
		Shape3a.mirror = true;
		this.setRotation(Shape3a, 0F, 0F, 0F);
		Shape3 = new LODModelPart(this, 0, 0);
		Shape3.addBox(0F, 0F, 0F, 10, 1, 15);
		Shape3.setRotationPoint(-5F, 16F, -7.5F);
		Shape3.setTextureSize(128, 128);
		Shape3.mirror = true;
		this.setRotation(Shape3, 0F, 0F, 0F);
		Shape3b = new LODModelPart(this, 0, 0);
		Shape3b.addBox(0F, 0F, 0F, 10, 1, 15);
		Shape3b.setRotationPoint(-5F, 14.5F, -7.5F);
		Shape3b.setTextureSize(128, 128);
		Shape3b.mirror = true;
		this.setRotation(Shape3b, 0F, 0F, 0F);
		Shape3c = new LODModelPart(this, 0, 0);
		Shape3c.addBox(0F, 0F, 0F, 10, 1, 15);
		Shape3c.setRotationPoint(-5F, 17.5F, -7.5F);
		Shape3c.setTextureSize(128, 128);
		Shape3c.mirror = true;
		this.setRotation(Shape3c, 0F, 0F, 0F);
		band3b = new LODModelPart(this, 22, 63);
		band3b.addBox(0F, 0F, 0F, 9, 6, 2);
		band3b.setRotationPoint(-4.5F, 13.5F, 0F);
		band3b.setTextureSize(128, 128);
		band3b.mirror = true;
		this.setRotation(band3b, 0F, 0F, 0F);
		band2a = new LODModelPart(this, 0, 63);
		band2a.addBox(0F, 0F, 0F, 7, 6, 2);
		band2a.setRotationPoint(-3.5F, 11.5F, -3F);
		band2a.setTextureSize(128, 128);
		band2a.mirror = true;
		this.setRotation(band2a, 0F, 0F, 0F);
		band3a = new LODModelPart(this, 0, 63);
		band3a.addBox(0F, 0F, 0F, 7, 6, 2);
		band3a.setRotationPoint(-3.5F, 11.5F, 0F);
		band3a.setTextureSize(128, 128);
		band3a.mirror = true;
		this.setRotation(band3a, 0F, 0F, 0F);
		band1a = new LODModelPart(this, 0, 63);
		band1a.addBox(0F, 0F, 0F, 7, 6, 2);
		band1a.setRotationPoint(-3.5F, 11.5F, -6F);
		band1a.setTextureSize(128, 128);
		band1a.mirror = true;
		this.setRotation(band1a, 0F, 0F, 0F);
		band1b = new LODModelPart(this, 22, 63);
		band1b.addBox(0F, 0F, 0F, 9, 6, 2);
		band1b.setRotationPoint(-4.5F, 13.5F, -6F);
		band1b.setTextureSize(128, 128);
		band1b.mirror = true;
		this.setRotation(band1b, 0F, 0F, 0F);
		band2b = new LODModelPart(this, 22, 63);
		band2b.addBox(0F, 0F, 0F, 9, 6, 2);
		band2b.setRotationPoint(-4.5F, 13.5F, -3F);
		band2b.setTextureSize(128, 128);
		band2b.mirror = true;
		this.setRotation(band2b, 0F, 0F, 0F);
	}

	@Override
	public void renderAll(TileEntity te, ArrayList li, float phi, float theta)
	{
		ReikaDyeHelper color1 = (ReikaDyeHelper) li.get(0);
		ReikaDyeHelper color2 = (ReikaDyeHelper) li.get(1);
		ReikaDyeHelper color3 = (ReikaDyeHelper) li.get(2);
		Shape1.render(te, f5);
		Shape2a.render(te, f5);
		Shape2.render(te, f5);
		Shape3a.render(te, f5);
		Shape3.render(te, f5);
		Shape3b.render(te, f5);
		Shape3c.render(te, f5);

		color1.setGLColorBlend();
		band1a.render(te, f5);
		band1b.render(te, f5);

		color2.setGLColorBlend();
		band2a.render(te, f5);
		band2b.render(te, f5);

		color3.setGLColorBlend();
		band3a.render(te, f5);
		band3b.render(te, f5);

		GL11.glColor3f(1, 1, 1);
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5);
	}

}
