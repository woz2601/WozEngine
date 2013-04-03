package com.woz.lwjgl.engine;

import com.woz.lwjgl.engine.Game;

/*
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 3/26/13
 * Time: 12:49 PM
 */
public class Main {
	public static void main(String[] args) {
		Thread game = new Game();
		game.start();

	}
}
