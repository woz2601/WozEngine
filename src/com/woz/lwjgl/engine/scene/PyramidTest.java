package com.woz.lwjgl.engine.scene;

import com.woz.lwjgl.engine.Camera;
import com.woz.lwjgl.engine.gameobject.GameObject;
import com.woz.lwjgl.engine.gameobject.Pyramid;
import com.woz.lwjgl.util.Direction;
import com.woz.lwjgl.util.Time;
import org.lwjgl.opengl.*;

import java.util.ArrayList;
import java.util.List;

/*
 * User: Daniel
 * Date: 4/2/13
 * Time: 10:56 PM
 */
public class PyramidTest implements IScene {
	private List<GameObject> _gameObjects;
	private Camera _camera;
	private Pyramid _pyramid;
	private float _posZ;
	private double _rotationAngle;
	private double _rotationSpeed;
	private float _moveSpeed;
	private float _moveBounds;
	private Direction _currentDirection;

	public PyramidTest() {
		_camera = new Camera();
		_pyramid = new Pyramid(2.0f, 1.0f);
		_posZ = 0.0f;
		_rotationAngle = 0.0;
		_rotationSpeed = 20.0;
		_moveSpeed = 10f;
		_moveBounds = 10.0f;
		_currentDirection = Direction.Forward;

		_gameObjects = new ArrayList<GameObject>();
		_gameObjects.add(_camera);
		_gameObjects.add(_pyramid);

		_camera.lookAt(_pyramid);
	}

	@Override
	public void update(double deltaTime) {
		_camera.update(deltaTime);

		move(deltaTime);
		rotate(deltaTime);
	}

	private void move(double deltaTime) {
		if (_currentDirection == Direction.Forward)
			_posZ -= _moveSpeed * deltaTime;
		else
			_posZ += _moveSpeed * deltaTime;

		if (_posZ >= _moveBounds)
			_currentDirection = Direction.Forward;
		else if (_posZ <= -_moveBounds)
			_currentDirection = Direction.Backward;
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

	@Override
	public List<GameObject> gameObjects() {
		return _gameObjects;
	}
}
