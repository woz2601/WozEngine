package com.woz.lwjgl.engine.controller;

import com.woz.lwjgl.engine.scene.TransformingPlaneTest;
import com.woz.lwjgl.util.Direction;
import com.woz.lwjgl.util.Time;

/*
 * User: Daniel
 * Date: 4/3/13
 * Time: 2:59 AM
 */
public class MovingPlaneController implements IController {
	private TransformingPlaneTest _scene;
	private float _posZ;
	private float _speed;
	private float _nearBound;
	private float _farBound;
	private Direction _currentDirection;

	public MovingPlaneController(TransformingPlaneTest scene) {
		_scene = scene;
		_posZ = 0.0f;
		_speed = 0.02f;
		_currentDirection = Direction.Forward;

		_nearBound = -1.0f;
		_farBound = -10.0f;

	}

	@Override
	public void update(double deltaTime) {
		if (_currentDirection == Direction.Backward) {
			_posZ += _speed * deltaTime;
		}
		else {
			_posZ -= _speed * deltaTime;
		}

		if (_posZ >= _nearBound) {
			_currentDirection = Direction.Forward;
			_posZ = _nearBound;
		}
		else if (_posZ <= _farBound){
			_currentDirection = Direction.Backward;
			_posZ = _farBound;
		}

		//try {
		//	//Thread.sleep(500);
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//}

		_posZ = (float)Math.sin(Time.getTime()) * 10f - 15f;

		_scene.setPosZ(_posZ);
	}
}
