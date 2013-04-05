package com.woz.lwjgl.math;

/*
 * User: Daniel
 * Date: 4/4/13
 * Time: 4:22 PM
 */
public class Vector3d {
	public double X;
	public double Y;
	public double Z;

	public Vector3d() {
		this(0.0, 0.0, 0.0);
	}

	public Vector3d(Vector2d other) {
		this(other.X, other.Y, 0.0);
	}

	public Vector3d(Vector3d other) {
		this(other.X, other.Y, other.Z);
	}

	public Vector3d(double x, double y) {
		this(x, y, 0.0);
	}

	public Vector3d(double x, double y, double z) {
		X = x;
		Y = y;
		Z = 0;
	}
}
