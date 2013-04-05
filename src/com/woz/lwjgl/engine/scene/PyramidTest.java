package com.woz.lwjgl.engine.scene;

import com.woz.lwjgl.engine.Camera;
import com.woz.lwjgl.engine.gameobject.Pyramid;
import org.lwjgl.opengl.*;

/*
 * User: Daniel
 * Date: 4/2/13
 * Time: 10:56 PM
 */
public class PyramidTest implements IScene {
	private Camera _camera;
	private Pyramid _pyramid;
	private float _posZ;
	private double _rotationAngle;
	private double _rotationSpeed;
	private double _moveSpeed;

	public PyramidTest() {
		_camera = new Camera();
		_pyramid = new Pyramid(2.0f, 1.0f);
		_posZ = 0.0f;
		_rotationAngle = 0.0;
		_rotationSpeed = 20.0;
		_moveSpeed = 10.0;
	}

	@Override
	public void update(double deltaTime) {
		_camera.lookAt(_pyramid);
		_camera.update(deltaTime);

		move(deltaTime);
		rotate(deltaTime);
	}

	private void move(double deltaTime) {
		_posZ = (float) Math.sin(deltaTime * _moveSpeed);
	}

	private void rotate(double deltaTime) {
		_rotationAngle += _rotationSpeed * deltaTime;

		if (_rotationAngle >= 360.0) {
			_rotationAngle -= 360.0;
		}
	}

	@Override
	public void draw() {
		GL11.glPushMatrix();
		GL11.glTranslatef(0f, 0f, _posZ);
		GL11.glRotatef((float) _rotationAngle, 0f, 1.0f, 0.0f);
		_pyramid.draw();
		GL11.glPopMatrix();
	}

	@Override
	public void destroy() {

	}
}
