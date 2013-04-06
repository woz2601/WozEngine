package com.woz.lwjgl.engine.gameobject;

import org.lwjgl.opengl.GL11;

/*
 * User: Daniel
 * Date: 4/5/13
 * Time: 3:16 PM
 */
public class Pyramid extends GameObject {

	public Pyramid(float baseWidth, float height) {
		super();
		_width = baseWidth;
		_height = height;

		_name = "Pyramid";
	}

	@Override
	public void draw() {
		float halfWidth = _width / 2.0f;
		GL11.glBegin(GL11.GL_TRIANGLE_FAN);
		GL11.glVertex3f(0, _height, 0);
		GL11.glVertex3f(-halfWidth, 0,  halfWidth);
		GL11.glVertex3f( halfWidth, 0,  halfWidth);
		GL11.glVertex3f( halfWidth, 0, -halfWidth);
		GL11.glVertex3f(-halfWidth, 0, -halfWidth);
		GL11.glEnd();

		GL11.glBegin(GL11.GL_TRIANGLES);
		GL11.glVertex3f(-halfWidth, 0,  halfWidth);
		GL11.glVertex3f(-halfWidth, 0, -halfWidth);
		GL11.glVertex3f( halfWidth, 0, -halfWidth);
		GL11.glVertex3f( halfWidth, 0, -halfWidth);
		GL11.glVertex3f( halfWidth, 0,  halfWidth);
		GL11.glVertex3f(-halfWidth, 0,  halfWidth);
		GL11.glEnd();



	}
}
