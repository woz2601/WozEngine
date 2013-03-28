package com.woz.lwjgl.util;

/*
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 3/26/13
 * Time: 2:49 PM
 */
public class Time {
	private static long _lastFrame = Time.getTime();
	private static long _lastFPSPrint = 0;
	private static long _currentFrame;
	private static String _FPS = "";

	public static long getTime() {
		return System.nanoTime();
	}

	public static void tick() {
		_lastFrame = _currentFrame;
		_currentFrame = Time.getTime();
	}

	public static long getDeltaTime() {
		return _currentFrame - _lastFrame;
	}

	public static int getFPS() {
		int deltaTime = (int) Time.getDeltaTime();
		if (deltaTime != 0)
			return (1000000000 / deltaTime);
		else
			return deltaTime;
	}

	public static String printFPS() {
		if (_currentFrame - _lastFPSPrint > 500000000) {
			_FPS = "FPS: " + getFPS() + "";

			_lastFPSPrint = _currentFrame;
		}

		return _FPS;
	}
}
