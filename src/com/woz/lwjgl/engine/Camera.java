package com.woz.lwjgl.engine;

import com.woz.lwjgl.math.Vector3d;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Vector3f;
import sun.security.x509.IPAddressName;

/*
 * User: Daniel
 * Date: 4/4/13
 * Time: 4:12 PM
 */
public class Camera {
	private Vector3f _position;
	private Vector3f _direction;
	private Vector3f _up;
	private double _speed;

	public Camera() {
		_position = new Vector3f(0.0f, 0.0f, 20.0f);
		_direction = new Vector3f(0.0f, 0.0f, -1.0f);
		_up = new Vector3f(0.0f, 1.0f, 0.0f);

		_speed = 10.0;
	}

	public void update(double deltaTime) {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glLoadIdentity();

		checkInput(deltaTime);

		GLU.gluLookAt(_position.x, _position.y, _position.z,
					  _position.x + _direction.x, _position.y + _direction.y, _position.z + _direction.z,
					  _up.x, _up.y, _up.z);
	}

	private void checkInput(double deltaTime) {
		if (Input.moveForward) {
			_position.z -= _speed * deltaTime;
		}
		if (Input.moveBackward) {
			_position.z += _speed * deltaTime;
		}
		if (Input.strafeRight) {
			_position.x += _speed * deltaTime;
		}
		if (Input.strafeLeft) {
			_position.x -= _speed * deltaTime;
		}
		if (Input.moveUp) {
			_position.y += _speed * deltaTime;
		}
		if (Input.moveDown) {
			_position.y -= _speed * deltaTime;
		}
	}
}
