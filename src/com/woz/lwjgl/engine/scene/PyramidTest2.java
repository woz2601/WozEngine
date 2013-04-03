package com.woz.lwjgl.engine.scene;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.*;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/*
 * User: Daniel
 * Date: 4/2/13
 * Time: 10:56 PM
 */
public class PyramidTest2 implements IScene {
	private int _vaoId;
	private int _vboId;
	private int _vboiId;
	private int _cboId;

	private int _vertexCount;
	private int _indexCount;

	public PyramidTest2() {
		float[] vertices = {
				0.0f,  0.5f, -3.0f,
				-0.5f, -0.5f, -2.0f,
				0.5f, -0.5f, -2.0f,
				0.5f,  -0.5f, -4.0f,
		};

		_vertexCount = 6;

		FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(vertices.length);
		vertexBuffer.put(vertices);
		vertexBuffer.flip();

		float[] colors = {
				1.0f,  0.0f, 0.0f,
				0.0f, 1.0f, 0.0f,
				0.0f, 0.0f, 1.0f,
				0.0f, 1.0f, 1.0f,
		};

		//_colorCount = 6;

		FloatBuffer colorBuffer = BufferUtils.createFloatBuffer(colors.length);
		colorBuffer.put(colors);
		colorBuffer.flip();

		byte[] indices = {
				0, 1, 2,
				0, 2, 3
		};

		_indexCount = indices.length;
		ByteBuffer indexBuffer = BufferUtils.createByteBuffer(_indexCount);
		indexBuffer.put(indices);
		indexBuffer.flip();

		_vaoId = GL30.glGenVertexArrays();
		GL30.glBindVertexArray(_vaoId);

		_vboId = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, _vboId);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vertexBuffer, GL15.GL_STATIC_DRAW);

		GL20.glVertexAttribPointer(0, 3, GL11.GL_FLOAT, false, 0, 0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		GL30.glBindVertexArray(0);

		_vboiId = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, _vboiId);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, indexBuffer, GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);

		_cboId = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, _cboId);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, colorBuffer, GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

	}

	@Override
	public void update(double deltaTime) {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glLoadIdentity();

		GL30.glBindVertexArray(_vaoId);
		GL20.glEnableVertexAttribArray(0);

		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, _vboiId);

		GL11.glEnableClientState(GL11.GL_COLOR_ARRAY);
		GL11.glColorPointer(4, GL11.GL_FLOAT, 0, 0);

		GL11.glDrawElements(GL11.GL_TRIANGLES, _indexCount, GL11.GL_UNSIGNED_BYTE, 0);

		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);

		GL20.glDisableVertexAttribArray(0);
		GL30.glBindVertexArray(0);

		GL11.glDisableClientState(GL11.GL_COLOR_ARRAY);
	}

	@Override
	public void draw() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void destroy() {
		GL20.glDisableVertexAttribArray(0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		GL15.glDeleteBuffers(_vboId);
		GL15.glDeleteBuffers(_cboId);

		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
		GL15.glDeleteBuffers(_vboiId);

		GL30.glBindVertexArray(0);
		GL30.glDeleteVertexArrays(_vaoId);
	}
}
