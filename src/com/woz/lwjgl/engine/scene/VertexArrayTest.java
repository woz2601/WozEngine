package com.woz.lwjgl.engine.scene;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.*;

import java.nio.FloatBuffer;

/*
 * User: Daniel
 * Date: 4/2/13
 * Time: 10:56 PM
 */
public class VertexArrayTest implements IScene {
	private int _vertexCount;
	private int _vaoId;
	private int _vboId;

	public VertexArrayTest() {
		float[] vertices = {
				-0.5f,  0.5f, -2.0f,
				-0.5f, -0.5f, -2.0f,
				0.5f, -0.5f, -2.0f,
				0.5f, -0.5f, -2.0f,
				0.5f,  0.5f, -2.0f,
				-0.5f,  0.5f, -2.0f,
		};

		FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(vertices.length);
		vertexBuffer.put(vertices);
		vertexBuffer.flip();

		_vertexCount = 6;

		_vaoId = GL30.glGenVertexArrays();
		GL30.glBindVertexArray(_vaoId);

		_vboId = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, _vboId);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertexBuffer, GL15.GL_STATIC_DRAW);

		GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		GL30.glBindVertexArray(0);
	}

	@Override
	public void update(double deltaTime) {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

		GL11.glLoadIdentity();

		GL30.glBindVertexArray(_vaoId);
		GL20.glEnableVertexAttribArray(0);

		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, _vertexCount);

		GL20.glDisableVertexAttribArray(0);
		GL30.glBindVertexArray(0);

	}

	@Override
	public void draw() {

	}

	@Override
	public void destroy() {
		GL20.glDisableVertexAttribArray(0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		GL15.glDeleteBuffers(_vboId);

		GL30.glBindVertexArray(0);
		GL30.glDeleteVertexArrays(_vaoId);
	}
}
