package com.woz.lwjgl.engine.scene;

import com.woz.lwjgl.engine.gameobject.*;
import com.woz.lwjgl.util.Debug;
import com.woz.lwjgl.util.Time;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import java.util.ArrayList;
import java.util.List;

/*
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 3/26/13
 * Time: 1:20 PM
 */
public class TestScene implements IScene {
	private List<GameObject> _gameObjects;

	private Box _ground;

	public TestScene() {
		_gameObjects = new ArrayList<GameObject>();
		_gameObjects.add(new Box(20, 20));
	}

	public void draw() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT  | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glLoadIdentity();

		GLU.gluLookAt(0.0f, 1.0f, 0.6f,
					  0.0f, 0.0f, 0.0f,
					  0.0f, 1.0f, 0.6f);

		drawTestPolygons();

		for (GameObject gameObject : _gameObjects) {
			gameObject.update(Time.getDeltaTime());
		}

		for (GameObject gameObject : _gameObjects) {
			gameObject.draw();
		}

		Debug.printFPS();
	}

	private void drawTestPolygons() {
		GL11.glBegin(GL11.GL_TRIANGLES);
		GL11.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
		GL11.glVertex3f(2.0f, 2.5f, -1.0f);
		GL11.glColor4f(0.0f, 1.0f, 0.0f, 1.0f);
		GL11.glVertex3f(-3.50f, -2.5f, -1.0f);
		GL11.glColor4f(0.0f, 0.0f, 1.0f, 1.0f);
		GL11.glVertex3f(2.0f, 2.5f, -1.0f);

		GL11.glEnd();
	}
}
