package com.woz.lwjgl.engine.controller;

import com.woz.lwjgl.engine.scene.IScene;
import com.woz.lwjgl.engine.scene.TransformingPlaneTest;
import com.woz.lwjgl.util.Direction;

/*
 * User: Daniel
 * Date: 4/3/13
 * Time: 8:52 PM
 */
public class ScalePlaneController implements IController {
	private TransformingPlaneTest _scene;
	private float _scale;
	private float _speed;
	private Direction _currentDirection;
	private float _maxScale;
	private float _minScale;

	public ScalePlaneController(TransformingPlaneTest scene) {
		_scene = scene;
		_scale = 1.0f;

		_speed = 1f;

		_maxScale = 1.0f;
		_minScale = 0.1f;
	}

	@Override
	public void update(double deltaTime) {
		if (_currentDirection == Direction.Down)
			_scale -= _speed * deltaTime;

		else
			_scale += _speed * deltaTime;

		if (_scale >= _maxScale)
			_currentDirection = Direction.Down;
		else if (_scale <= _minScale)
			_currentDirection = Direction.Up;

		_scene.setScale(_scale);
	}
}
