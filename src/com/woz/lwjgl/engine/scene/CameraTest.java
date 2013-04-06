package com.woz.lwjgl.engine.scene;

import com.woz.lwjgl.engine.Camera;
import com.woz.lwjgl.engine.gameobject.GameObject;
import com.woz.lwjgl.graphics.Color;
import com.woz.lwjgl.graphics.Graphics;
import org.lwjgl.opengl.GL11;

import java.util.List;

/*
 * User: Daniel
 * Date: 4/4/13
 * Time: 4:55 PM
 */
public class CameraTest implements IScene {
	private Camera _camera;

	public CameraTest() {
		_camera = new Camera();
	}

	@Override
	public void update(double deltaTime) {
		_camera.update(deltaTime);
	}

	@Override
	public void draw() {
		GL11.glPushMatrix();
		GL11.glTranslatef(50.0f, -1.0f, 50.0f);
		GL11.glScalef(100.0f, 0.0f, 100.0f);
		Graphics.drawCube(0, 0, 0, Color.DGRAY);
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		Graphics.drawCube(0, 0, 0);
		GL11.glPopMatrix();
	}

	@Override
	public void destroy() {

	}

	@Override
	public List<GameObject> gameObjects() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
