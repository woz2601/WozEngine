package com.woz.lwjgl.graphics;

/*
 * User: Daniel
 * Date: 4/5/13
 * Time: 12:55 AM
 */
public class Color {
	private float _red;
	private float _green;
	private float _blue;

	public static final Color WHITE  = new Color(1.0f, 1.0f, 1.0f);
	public static final Color BLACK  = new Color(0.0f, 0.0f, 0.0f);
	public static final Color RED    = new Color(1.0f, 0.0f, 0.0f);
	public static final Color GREEN  = new Color(0.0f, 1.0f, 0.0f);
	public static final Color BLUE   = new Color(0.0f, 0.0f, 1.0f);
	public static final Color DGRAY  = new Color(0.2f, 0.2f, 0.2f);
	public static final Color LGRAY  = new Color(0.8f, 0.8f, 0.8f);
	public static final Color YELLOW = new Color(1.0f, 1.0f, 0.0f);

	public Color() {
		this(0f, 0f, 0f);
	}

	public Color(Color other) {
		this(other.getRed(), other.getGreen(), other.getBlue());
	}

	public Color(float red, float green, float blue) {
		_red = red;
		_green = green;
		_blue = blue;
	}

	public float getRed() {
		return _red;
	}

	public float getGreen() {
		return _green;
	}

	public float getBlue() {
		return _blue;
	}
}
