package com.woz.lwjgl.math;

/*
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 3/28/13
 * Time: 1:09 AM
 */
public class Vector2d {
	public double X;
	public double Y;

	public Vector2d() {
		this(0.0, 0.0);
	}

	public Vector2d(Vector2d other) {
		this(other.X, other.Y);
	}

	public Vector2d(double x, double y) {
		X = x;
		Y = y;
	}
}
