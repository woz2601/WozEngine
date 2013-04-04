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
	private static double  _deltaTime;
	private static final long _startTime = System.nanoTime();

	public static long getTime() {
		return System.nanoTime() - _startTime;
	}

	public static void tick() {
		_lastFrame = _currentFrame;
		_currentFrame = Time.getTime();
		calculateDeltaTime();
	}

	private static void calculateDeltaTime() {
		_deltaTime = (_currentFrame - _lastFrame) / 1000000000f;
	}

	public static double getDeltaTime() {
		return _deltaTime;
	}

	public static int getFPS() {
		int deltaTime = (int) Time.getDeltaTime();
		if (deltaTime != 0)
			return (1 / deltaTime);
		else
			return 0;
	}

	public static String printFPS() {
		if (_currentFrame - _lastFPSPrint > 500000000) {
			_FPS = "FPS: " + getFPS() + "";

			_lastFPSPrint = _currentFrame;
		}

		return _FPS;
	}
}
