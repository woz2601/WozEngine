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
		//GL11.glColor3f(1, 1, 1);
		//SimpleText.drawString(Time.printFPS(), 10, Display.getHeight() - 30);

		//TODO - implement FPS counter
	}

	public static void printInfo() {
		System.out.println(String.format("Vendor  : %s", GL11.glGetString(GL11.GL_VENDOR)));
		System.out.println(String.format("Device  : %s", GL11.glGetString(GL11.GL_RENDERER)));
		System.out.println(String.format("Version : %s", GL11.glGetString(GL11.GL_VERSION)));
	}
}
