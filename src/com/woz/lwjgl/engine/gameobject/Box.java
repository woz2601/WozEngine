package com.woz.lwjgl.engine.gameobject;

import com.woz.lwjgl.engine.Input;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

/*
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 3/28/13
 * Time: 1:45 AM
 */
public class Box extends GameObject {

	private float _maxSpeed = 0.01f;

	public Box() {
		this(new Vector3f(), new Vector3f());
	}

	public Box(float x, float y) {
		this(new Vector3f(x, y, 0), new Vector3f());
	}

	public Box(Vector3f position , Vector3f velocity) {
		this(position, velocity, 60, 60);
	}

	public Box(Vector3f position , Vector3f velocity, int width, int height) {
		super(position, velocity, width, height);
	}

	@Override
	public void update(long delta) {
		super.update(delta);

		_velocity.x = Input.getMouseVelX();
		_velocity.y = Input.getMouseVelY();

		if (_velocity.length() > _maxSpeed)
			_velocity.normalise().scale(_maxSpeed);
	}

	@Override
	public void draw() {
		//GL11.glColor3f(0.5f, 0.5f, 1.0f);
//
		//GL11.glBegin(GL11.GL_QUADS);
		//GL11.glVertex2f(_position.x, _position.y);
		//GL11.glVertex2f(_position.x + _width, _position.y);
		//GL11.glVertex2f(_position.x + _width, _position.y + _height);
		//GL11.glVertex2f(_position.x, _position.y + _height);
		//GL11.glEnd();
	}
}
