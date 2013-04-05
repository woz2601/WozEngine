package com.woz.lwjgl.engine;

import com.woz.lwjgl.engine.controller.IController;
import com.woz.lwjgl.engine.controller.MovingPlaneController;
import com.woz.lwjgl.engine.controller.RotatePlaneController;
import com.woz.lwjgl.engine.controller.ScalePlaneController;
import com.woz.lwjgl.engine.scene.*;
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
	public static final double GAME_SPEED = 10.0;
	private Window _window;
	private IScene _scene;
	private IController _controller;

	public Game() {
		_window = new Window();
		_scene = new PyramidTest();
		//_controller = new ScalePlaneController((TransformingPlaneTest) _scene);

		Input.init();
	}

	public void run() {
		while (!Display.isCloseRequested()) {
			Time.tick();

			Input.pollInput();

			if (Debug.DEBUG_MODE) {
				Debug.printFPS();
			}

			//_controller.update(Time.getDeltaTime());
			_scene.update(Time.getDeltaTime());
			_scene.draw();

			_window.update();
		}

		shutDown();
	}

	public void shutDown() {
		_scene.destroy();
		Window.destroy();
	}
}
