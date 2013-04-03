package com.woz.lwjgl.engine.scene;

import org.lwjgl.opengl.GL11;

/*
 * User: Daniel
 * Date: 4/2/13
 * Time: 11:47 PM
 */
public class BasicTriangleTest implements IScene{
	@Override
	public void update(double deltaTime) {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glLoadIdentity();

// set the color of the quad (R,G,B,A)
		GL11.glColor3f(1.0f, 1.0f, 1.0f);

// draw quad
		GL11.glBegin(GL11.GL_TRIANGLES);
		GL11.glVertex3f(-0.5f, -0.5f, -2.0f);
		GL11.glVertex3f(0.5f, -0.5f, -2.0f);
		GL11.glVertex3f(0.0f,  0.5f, -2.0f);
		GL11.glEnd();
	}

	@Override
	public void draw() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void destroy() {

	}
}
