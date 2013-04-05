package com.woz.lwjgl.engine.scene;

import com.woz.lwjgl.graphics.Graphics;
import org.lwjgl.opengl.GL11;

/*
 * User: Daniel
 * Date: 4/4/13
 * Time: 12:50 AM
 */
public class CubeTest implements IScene {
	private float _posX;
	private float _posY;
	private float _posZ;
	private float _rotationAngle;
	private float _speed;

	public CubeTest() {
		_posX = 0f;
		_posY = 0f;
		_posZ = -5.0f;

		_rotationAngle = 0f;
		_speed = 10.0f;
	}

	@Override
	public void update(double deltaTime) {
		_rotationAngle += _speed * deltaTime;

		if (_rotationAngle >= 360.0f) {
			_rotationAngle -= 360.0f;
		}
	}

	@Override
	public void draw() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glLoadIdentity();

		//GL11.glRotatef(_rotationAngle, 0f, 1.0f, 0f);
		Graphics.drawCube(_posX, _posY, _posZ, _rotationAngle);
	}

	@Override
	public void destroy() {
	}
}
