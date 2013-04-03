package com.woz.lwjgl.engine;

import com.sun.javafx.geom.Vec3d;
import com.woz.lwjgl.util.Time;
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
			if (Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
				Window.close();
			}
		}
	}
}
