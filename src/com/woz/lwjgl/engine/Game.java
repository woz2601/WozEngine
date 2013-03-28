package com.woz.lwjgl.engine;

import com.woz.lwjgl.engine.scene.TestScene;
import com.woz.lwjgl.engine.scene.IScene;
import com.woz.lwjgl.util.Debug;
import com.woz.lwjgl.util.Time;
import org.lwjgl.opengl.Display;

/*
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 3/26/13
 * Time: 12:50 PM
 */
public class Game {
	public static final double GAME_SPEED = 0.0001;
	private Window _window;
	private IScene _scene;

	public Game() {
		_scene = new TestScene();
		_window = new Window();

		Input.init();
	}

	public void run() {
		while (!Display.isCloseRequested()) {
			_window.update();

			Time.tick();

			Input.pollInput();

			if (Debug.DEBUG_MODE) {
				Debug.printFPS();
			}

			_scene.draw();
		}

		Window.close();
	}
}
