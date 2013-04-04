package com.woz.lwjgl.engine.controller;

import com.woz.lwjgl.engine.scene.TransformingPlaneTest;
import com.woz.lwjgl.util.Direction;
import com.woz.lwjgl.util.Time;

/*
 * User: Daniel
 * Date: 4/3/13
 * Time: 2:59 AM
 */
public class RotatePlaneController implements IController {
	private TransformingPlaneTest _scene;
	private float _posZ;
	private float _speed;
	private float _nearBound;
	private float _farBound;
	private Direction _currentDirection;
	private float _rotationAngle;

	public RotatePlaneController(TransformingPlaneTest scene) {
		_scene = scene;
		_posZ = 0.0f;
		_speed = 200f;
		_currentDirection = Direction.Forward;
		_rotationAngle = 0f;

		_nearBound = -1.0f;
		_farBound = -10.0f;

	}

	@Override
	public void update(double deltaTime) {

		_rotationAngle += _speed * deltaTime;

		if (_rotationAngle > 360f)
			_rotationAngle -= 360f;

		//try {
		//	//Thread.sleep(500);
		//} catch (InterruptedException e) {
		//	e.printStackTrace();
		//}

		_posZ = (float)Math.sin(Time.getTime()) * 10f - 15f;

		_scene.setRotationAngle(_rotationAngle);
	}
}
