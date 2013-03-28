package com.woz.lwjgl.engine;

import com.woz.lwjgl.engine.scene.IScene;
import com.woz.lwjgl.util.Text;
import com.woz.lwjgl.util.Time;
import com.woz.lwjgl.util.VersionTest;
import com.woz.lwjgl.util.Debug;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

/*
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 3/26/13
 * Time: 12:51 PM
 */
public class Window {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	public Window() {
		initDisplay();
		initGL();
		initComponents();

		if (Debug.DEBUG_MODE)
			VersionTest.printVersion();
	}

	private void initComponents() {
	}

	private void initDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle("LWJGL Engine");
			Display.create();


		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	private void initGL() {
		//GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		// Black Background
		//GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		//GL11.glEnable(GL11.GL_BLEND);
		//GL11.glEnable(GL11.GL_TEXTURE_2D); // Enable Texture Mapping
		GL11.glEnable(GL11.GL_DEPTH_TEST);

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		// Select The Projection Matrix
		GL11.glLoadIdentity(); // Reset The Projection Matrix

		GLU.gluPerspective(60.0f, Display.getWidth() / Display.getHeight(), 1.0f, 100.0f);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
	}

	public void update() {
		Display.update();
		Display.sync(120);
	}

	public static void close() {
		Display.destroy();
		System.exit(0);
	}
}