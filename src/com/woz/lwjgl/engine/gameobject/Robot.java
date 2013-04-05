package com.woz.lwjgl.engine.gameobject;

import com.woz.lwjgl.graphics.Graphics;
import static org.lwjgl.opengl.GL11.*;

/*
 * User: Daniel
 * Date: 4/4/13
 * Time: 2:47 AM
 */
public class Robot {

// constants for arm and leg movement states
	private final char BACKWARD_STATE = 0;
	private final char FORWARD_STATE  = 1;

// index constants for accessing arm and leg array data
	private final char LEFT  = 0;
	private final char RIGHT = 1;

	private char[] legStates;
	private char[] armStates;
	private float[] armAngles;
	private float[] legAngles;

	public Robot() {
		legStates = new char[2];
		armStates = new char[2];
		legAngles = new float[2];
		armAngles = new float[2];

		armAngles[LEFT] = 0.0f;
		armAngles[RIGHT] = 0.0f;
		legAngles[LEFT] = 0.0f;
		legAngles[RIGHT] = 0.0f;

		armStates[LEFT] = FORWARD_STATE;
		armStates[RIGHT] = BACKWARD_STATE;

		legStates[LEFT] = FORWARD_STATE;
		legStates[RIGHT] = BACKWARD_STATE;

	}

	public void draw() {
		draw(0, 0, 0);
	}

	// draws the entire robot
	public void draw(float xPos, float yPos, float zPos) {
		glPushMatrix();
		glTranslatef(xPos, yPos, zPos);	// draw robot at desired coordinates

		// draw head and torso parts
		DrawHead(1.0f, 2.0f, 0.0f);
		DrawTorso(1.5f, 0.0f, 0.0f);

		// move the left arm away from the torso and rotate it to give "walking" effect
		glPushMatrix();
		glTranslatef(0.0f, -0.5f, 0.0f);
		glRotatef(armAngles[LEFT], 1.0f, 0.0f, 0.0f);
		DrawArm(2.5f, 0.0f, -0.5f);
		glPopMatrix();

		// move the right arm away from the torso and rotate it to give "walking" effect
		glPushMatrix();
		glTranslatef(0.0f, -0.5f, 0.0f);
		glRotatef(armAngles[RIGHT], 1.0f, 0.0f, 0.0f);
		DrawArm(-1.5f, 0.0f, -0.5f);
		glPopMatrix();

		// move the left leg away from the torso and rotate it to give "walking" effect
		glPushMatrix();
		glTranslatef(0.0f, -0.5f, 0.0f);
		glRotatef(legAngles[LEFT], 1.0f, 0.0f, 0.0f);
		DrawLeg(-0.5f, -5.0f, -0.5f);
		glPopMatrix();

		// move the right leg away from the torso and rotate it to give "walking" effect
		glPushMatrix();
		glTranslatef(0.0f, -0.5f, 0.0f);
		glRotatef(legAngles[RIGHT], 1.0f, 0.0f, 0.0f);
		DrawLeg(1.5f, -5.0f, -0.5f);
		glPopMatrix();

		glPopMatrix();	// pop back to original coordinate system
	}


	// methods to draw the parts of the robot
	private void DrawArm(float xPos, float yPos, float zPos) {
		glPushMatrix();
		glColor3f(1.0f, 0.0f, 0.0f);	// red
		glTranslatef(xPos, yPos, zPos);
		glScalef(1.0f, 4.0f, 1.0f);		// arm is a 1x4x1 cube
		Graphics.drawCube(0.0f, 0.0f, 0.0f);
		glPopMatrix();
	}

	private void DrawHead(float xPos, float yPos, float zPos) {
		glPushMatrix();
		glColor3f(1.0f, 1.0f, 1.0f);	// white
		glTranslatef(xPos, yPos, zPos);
		glScalef(2.0f, 2.0f, 2.0f);		// head is a 2x2x2 cube
		Graphics.drawCube(0.0f, 0.0f, 0.0f);
		glPopMatrix();
	}

	private void DrawTorso(float xPos, float yPos, float zPos) {
		glPushMatrix();
		glColor3f(0.0f, 0.0f, 1.0f);	// blue
		glTranslatef(xPos, yPos, zPos);
		glScalef(3.0f, 5.0f, 2.0f);		// torso is a 3x5x2 cube
		Graphics.drawCube(0.0f, 0.0f, 0.0f);
		glPopMatrix();
	}

	private void DrawLeg(float xPos, float yPos, float zPos) {
		glPushMatrix();
		glTranslatef(xPos, yPos, zPos);

		// draw the foot
		glPushMatrix();
		glTranslatef(0.0f, -0.5f, 0.0f);
		DrawFoot(0.0f, -5.0f, 0.0f);
		glPopMatrix();

		glScalef(1.0f, 5.0f, 1.0f);		// leg is a 1x5x1 cube
		glColor3f(1.0f, 1.0f, 0.0f);	// yellow
		Graphics.drawCube(0.0f, 0.0f, 0.0f);
		glPopMatrix();
	}


	private void DrawFoot(float xPos, float yPos, float zPos) {
		glPushMatrix();
		glColor3f(1.0f, 1.0f, 1.0f);
		glTranslatef(xPos, yPos, zPos);
		glScalef(1.0f, 0.5f, 3.0f);
		Graphics.drawCube(0.0f, 0.0f, 0.0f);
		glPopMatrix();
	}

	// updates the robot data
	public void update(double dt) {
		// if leg is moving forward, increase angle, else decrease angle
		for (char side = 0; side < 2; side++)
		{
			// arms
			if (armStates[side] == FORWARD_STATE)
				armAngles[side] += 20.0f * dt;
			else
				armAngles[side] -= 20.0f * dt;

			// change state if exceeding angles
			if (armAngles[side] >= 15.0f)
				armStates[side] = BACKWARD_STATE;
			else if (armAngles[side] <= -15.0f)
				armStates[side] = FORWARD_STATE;

			// legs
			if (legStates[side] == FORWARD_STATE)
				legAngles[side] += 20.0f * dt;
			else
				legAngles[side] -= 20.0f * dt;

			// change state if exceeding angles
			if (legAngles[side] >= 15.0f)
				legStates[side] = BACKWARD_STATE;
			else if (legAngles[side] <= -15.0f)
				legStates[side] = FORWARD_STATE;
		}
	}
}
