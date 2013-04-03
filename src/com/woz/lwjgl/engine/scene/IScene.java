package com.woz.lwjgl.engine.scene;

/*
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 3/26/13
 * Time: 2:41 PM
 */
public interface IScene {
	public void update(double deltaTime);
	public void draw();
	public void destroy();
}
