package com.woz.lwjgl.engine;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;

/*
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 3/26/13
 * Time: 1:08 PM
 */
public class Input {
	private static Vector2f _mousePos = new Vector2f();
	private static Vector2f _mouseVel = new Vector2f();
	private static Vector2f _lastMousePos = new Vector2f();

	public static boolean moveForward = false;
	public static boolean moveBackward = false;
	public static boolean strafeRight = false;
	public static boolean strafeLeft = false;
	public static boolean moveUp = false;
	public static boolean moveDown = false;

	public static boolean rotateLeft = false;
	public static boolean rotateRight = false;
	public static boolean printGameObjectInfo = false;

	private Input() {
	}

	public static void init() {
		//Mouse.setGrabbed(true);
	}

	public static int getMouseX() {
		return (int) _mousePos.x;
	}

	public static int getMouseY() {
		return (int) _mousePos.y;
	}

	public static float getMouseVelX() {
		return _mouseVel.x;
	}

	public static float getMouseVelY() {
		return _mouseVel.y;
	}

	public static Vector2f getMouseVelocity() {
		return _mouseVel;
	}

	public static void pollInput() {
		_mousePos.x = Mouse.getX();
		_mousePos.y = Mouse.getY();

		_mouseVel = Vector2f.sub(_mousePos, _lastMousePos, _mouseVel);//.scale(1 / Time.getDeltaTime());

		if (Mouse.isButtonDown(0)) {

			System.out.println("********************************");
			System.out.println(String.format("Mouse down @: (%s, %s)", _mousePos.x, _mousePos.y));
			System.out.println(String.format("Velocity: (%s, %s)", _mouseVel.x, _mouseVel.y));
			System.out.println(String.format("Last Mouse: (%s, %s)", _lastMousePos.x, _lastMousePos.y));
		}

		_lastMousePos.x = _mousePos.x;
		_lastMousePos.y = _mousePos.y;

		while (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				if (Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
					Window.destroy();
				}

				if (Keyboard.getEventKey() == Keyboard.KEY_W) {
					moveForward = true;
					System.out.println("Moving Forward");
				}

				if (Keyboard.getEventKey() == Keyboard.KEY_S) {
					moveBackward = true;
					System.out.println("Moving Backward");
				}

				if (Keyboard.getEventKey() == Keyboard.KEY_A) {
					strafeLeft = true;
					System.out.println("Strafing Left");
				}

				if (Keyboard.getEventKey() == Keyboard.KEY_D) {
					strafeRight = true;
					System.out.println("Strafing Right");
				}

				if (Keyboard.getEventKey() == Keyboard.KEY_E) {
					moveUp = true;
					System.out.println("Moving Up");
				}

				if (Keyboard.getEventKey() == Keyboard.KEY_Q) {
					moveDown = true;
					System.out.println("Moving Down");
				}

				if (Keyboard.getEventKey() == Keyboard.KEY_LEFT) {
					rotateLeft = true;
					System.out.println("Rotating Left");
				}

				if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT) {
					rotateRight = true;
					System.out.println("Rotating Right");
				}

				if (Keyboard.getEventKey() == Keyboard.KEY_I) {
					printGameObjectInfo = true;
					System.out.println("Rotating Right");
				}
			}
			else {
				if (Keyboard.getEventKey() == Keyboard.KEY_W) {
					moveForward = false;
					System.out.println("Stopped Moving Forward");
				}

				if (Keyboard.getEventKey() == Keyboard.KEY_S) {
					moveBackward = false;
					System.out.println("Stopped Moving Backward");
				}

				if (Keyboard.getEventKey() == Keyboard.KEY_A) {
					strafeLeft = false;
					System.out.println("Stopped Strafing Left");
				}

				if (Keyboard.getEventKey() == Keyboard.KEY_D) {
					strafeRight = false;
					System.out.println("Stopped Strafing Right");
				}

				if (Keyboard.getEventKey() == Keyboard.KEY_E) {
					moveUp = false;
					System.out.println("Stopped Moving Up");
				}

				if (Keyboard.getEventKey() == Keyboard.KEY_Q) {
					moveDown = false;
					System.out.println("Stoppd Moving Down");
				}

				if (Keyboard.getEventKey() == Keyboard.KEY_LEFT) {
					rotateLeft = false;
					System.out.println("Stopped Rotating Left");
				}

				if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT) {
					rotateRight = false;
					System.out.println("Stopped Rotating Right");
				}
			}
		}
	}
}
