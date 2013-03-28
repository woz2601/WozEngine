package com.woz.lwjgl.util;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import java.awt.*;
import java.nio.FloatBuffer;

/*
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 3/26/13
 * Time: 3:43 PM
 */
public class Text {
	private static UnicodeFont _font;

	private static FloatBuffer perspectiveProjectionMatrix;
	private static FloatBuffer orthographicProjectionMatrix = BufferUtils.createFloatBuffer(16);

	public static void setup() {
		GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, orthographicProjectionMatrix);

		Font awtFont = new Font("Times New Roman", Font.BOLD, 18);
		_font = new UnicodeFont(awtFont);
		_font.getEffects().add(new ColorEffect(Color.white));
		_font.addAsciiGlyphs();

		try {
			_font.loadGlyphs();
		} catch (SlickException e) {
			e.printStackTrace();
		}

		System.out.println("Text fonts loaded!");
	}

	public static void drawText(String string, float x, float y) {
		_font.drawString(x, y, string);
		//System.out.println(String.format("drawText took : %s ns", delta));
	}
}
