package com.woz.lwjgl.engine.gameobject;

import com.woz.lwjgl.engine.Game;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

/*
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 3/28/13
 * Time: 1:25 AM
 */
public abstract class GameObject {
	protected Vector3f _position;
	protected Vector3f _velocity;
	protected float  _width;
	protected float  _height;
	private int _borderSize;

	protected GameObject() {
		this(new Vector3f(), new Vector3f(), 60, 60);
	}

	protected GameObject(Vector3f position, Vector3f velocity, int width, int height) {
		_position = position;
		_velocity = velocity;

		_width = width;
		_height = height;

		_borderSize = 2;
	}

	public void update(long delta) {
		_position.x += delta * _velocity.x * Game.GAME_SPEED;

		if (_position.x < 0)
			_position.x = _borderSize;
		else if (_position.x + _width > Display.getWidth())
			_position.x = Display.getWidth() - _width;

		_position.y += delta * _velocity.y * Game.GAME_SPEED;

		if (_position.y < 0)
			_position.y = 1;
		else if (_position.y + _height > Display.getHeight())
			_position.y = Display.getHeight() - _height - _borderSize;
	}

	public abstract void draw();

	public static GameObject Instantiate() {
		//TODO Implement static factory method for GameObjects
		return null;
	}

	public Vector3f getPosition() {
		return _position;
	}
}
