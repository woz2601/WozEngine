package com.woz.lwjgl.engine.scene;

import com.woz.lwjgl.engine.gameobject.Robot;
import org.lwjgl.opengl.GL11;

/*
 * User: Daniel
 * Date: 4/4/13
 * Time: 2:44 AM
 */
public class RobotTest implements IScene {
	private Robot robot;
	private float _rotationAngle;

	public RobotTest() {
		robot = new Robot();

		_rotationAngle = 0;
	}
	@Override
	public void update(double deltaTime) {
		_rotationAngle += 45.0f * deltaTime;					// increase our rotation angle counter
		if (_rotationAngle >= 360.0f)					// if we've gone in a circle, reset counter
			_rotationAngle = 0.0f;

		robot.update(deltaTime);
	}

	@Override
	public void draw() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glLoadIdentity();

		GL11.glPushMatrix();							// put current matrix on stack
		GL11.glLoadIdentity();					// reset matrix
		GL11.glTranslatef(0.0f, 0.0f, -30.0f);	// move to (0, 0, -30)
		GL11.glRotatef(_rotationAngle, 0.0f, 1.0f, 0.0f);	// rotate the robot on its y-axis
		robot.draw();
		GL11.glPopMatrix();

	}

	@Override
	public void destroy() {
	}
}
