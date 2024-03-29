package com.woz.lwjgl.graphics;

import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex3f;

/*
 * User: Daniel
 * Date: 4/4/13
 * Time: 12:45 AM
 */
public class Graphics {
	private static Color _defaultColor = Color.WHITE;
	private static Color _color = _defaultColor;

	public static void drawCube(float x, float y, float z) {
		GL11.glPushMatrix();
		glTranslatef(x, y, z);
		drawCube();
		glPopMatrix();
	}

	public static void drawCube(float x, float y, float z, float angle) {
		glPushMatrix();
		glTranslatef(x, y, z);
		glRotatef(angle, 0f, 1.0f, 0f);
		drawCube();
		glPopMatrix();
	}

	public static void drawCube(float x, float y, float z, Color color) {
		_color = color;
		glPushMatrix();
		glTranslatef(x, y, z);
		drawCube();
		glPopMatrix();
		_color = _defaultColor;
	}

	private static void drawCube() {
		glBegin(GL_QUADS);
		glColor3f(_color.getRed(), _color.getGreen(), _color.getBlue());
		glVertex3f(0.0f, 0.0f, 0.0f);	// top face
		glVertex3f(0.0f, 0.0f, -1.0f);
		glVertex3f(-1.0f, 0.0f, -1.0f);
		glVertex3f(-1.0f, 0.0f, 0.0f);
		glVertex3f(0.0f, 0.0f, 0.0f);	// front face
		glVertex3f(-1.0f, 0.0f, 0.0f);
		glVertex3f(-1.0f, -1.0f, 0.0f);
		glVertex3f(0.0f, -1.0f, 0.0f);
		glVertex3f(0.0f, 0.0f, 0.0f);	// right face
		glVertex3f(0.0f, -1.0f, 0.0f);
		glVertex3f(0.0f, -1.0f, -1.0f);
		glVertex3f(0.0f, 0.0f, -1.0f);
		glVertex3f(-1.0f, 0.0f, 0.0f);	// left face
		glVertex3f(-1.0f, 0.0f, -1.0f);
		glVertex3f(-1.0f, -1.0f, -1.0f);
		glVertex3f(-1.0f, -1.0f, 0.0f);
		glVertex3f(0.0f, -1.0f, 0.0f);	// bottom face
		glVertex3f(0.0f, -1.0f, -1.0f);
		glVertex3f(-1.0f, -1.0f, -1.0f);
		glVertex3f(-1.0f, -1.0f, 0.0f);
		glVertex3f(0.0f, 0.0f, -1.0f);	// back face
		glVertex3f(0.0f, -1.0f, -1.0f);
		glVertex3f(-1.0f, -1.0f, -1.0f);
		glVertex3f(-1.0f, 0.0f, -1.0f);
		glEnd();
	}
}
