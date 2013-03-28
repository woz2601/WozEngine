package com.woz.lwjgl.util;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

/*
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 3/26/13
 * Time: 2:34 PM
 */
public class VersionTest {
	public static String getVersion() {
		return GL11.glGetString(GL11.GL_VERSION);
	}

	public static void setVersion(int majorVersion, int minorVersion) {
		PixelFormat pixelFormat = new PixelFormat();
		ContextAttribs contextAttribs = new ContextAttribs(majorVersion, minorVersion);
		contextAttribs.withForwardCompatible(true);
		contextAttribs.withProfileCore(true);

		try {
			Display.create(pixelFormat, contextAttribs);
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public static void printVersion() {
		System.out.println(String.format("Your version is %s", VersionTest.getVersion()));
	}
}
