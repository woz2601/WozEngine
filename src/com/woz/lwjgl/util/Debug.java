package com.woz.lwjgl.util;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

/*
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 3/26/13
 * Time: 2:38 PM
 */
public class Debug {
	public static final boolean DEBUG_MODE = true;
	private static Text _text = new Text();

	public static void printFPS() {
		GL11.glColor3f(1, 1, 1);
		SimpleText.drawString(Time.printFPS(), 10, Display.getHeight() - 30);
	}
}
