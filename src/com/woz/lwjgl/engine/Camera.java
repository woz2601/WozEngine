package com.woz.lwjgl.engine;

import com.woz.lwjgl.engine.gameobject.GameObject;
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
	private float  _speed;

	private float _xDirection;
	private float _ZDirection;

	private float _rotationAngle;
	private float _rotationSpeed;

	public Camera() {
		_position = new Vector3f(0.0f, 0.0f, 20.0f);
		_direction = new Vector3f(0.0f, 0.0f, -1.0f);
		calculateDirection();
		_up = new Vector3f(0.0f, 1.0f, 0.0f);

		_speed = 10.0f;

		_rotationAngle = -90.0f;
		_rotationSpeed = 40.0f;
	}

	private void calculateDirection() {
		double angle = Math.toRadians(_rotationAngle);
		_direction.x = (float) Math.cos(angle);
		_direction.y = 0;
		_direction.z = (float) Math.sin(angle);
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
			_position.x += _direction.x * _speed * (float)deltaTime;
			_position.z += _direction.z * _speed * (float)deltaTime;
		}
		if (Input.moveBackward) {
			_position.x -= _direction.x * _speed * (float)deltaTime;
			_position.z -= _direction.z * _speed * (float)deltaTime;
		}
		if (Input.strafeRight) {
			double angle = Math.toRadians(_rotationAngle + 90.0f);
			_position.x += Math.cos(angle) * _speed * (float)deltaTime;
			_position.z += Math.sin(angle) * _speed * (float)deltaTime;
		}
		if (Input.strafeLeft) {
			double angle = Math.toRadians(_rotationAngle - 90.0f);
			_position.x += Math.cos(angle) * _speed * (float)deltaTime;
			_position.z += Math.sin(angle) * _speed * (float)deltaTime;
		}
		if (Input.moveUp) {
			_position.y += _speed * deltaTime;
		}
		if (Input.moveDown) {
			_position.y -= _speed * deltaTime;
		}
		if (Input.rotateLeft) {
			_rotationAngle -= _rotationSpeed * deltaTime;
			calculateDirection();
		}
		if (Input.rotateRight) {
			_rotationAngle += _rotationSpeed * deltaTime;
			calculateDirection();
		}
	}

	public void lookAt(GameObject gameObject) {
		Vector3f.sub(gameObject.getPosition(), _position, _direction);
	}
}
