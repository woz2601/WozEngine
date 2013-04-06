package com.woz.lwjgl.engine.scene;

import com.woz.lwjgl.engine.Game;
import com.woz.lwjgl.engine.gameobject.*;
import com.woz.lwjgl.util.Debug;
import com.woz.lwjgl.util.Time;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.glu.GLU;
import sun.font.BidiUtils;
import sun.nio.ByteBuffered;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/*
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 3/26/13
 * Time: 1:20 PM
 */
public class TestScene implements IScene {
	private List<GameObject> _gameObjects;

	private static final double SPEED = 50.0;
	private float _rotationAngle;

	private FloatBuffer _vertices;
	private ByteBuffer _indices;
	private int _indicesCount;
	private int _vaoId;
	private int _vboiId;
	private int _vboId;


	public TestScene() {
		_gameObjects = new ArrayList<GameObject>();
		_gameObjects.add(new Box(20, 20));

		_rotationAngle = 0.0f;

		init();
	}

	private void init() {
		float[] vertices = {
				-0.5f, 0.5f, 0f,
				-.5f, -0.5f, 0f,
				0.5f, -0.5f, 0f,
				0.5f, 0.5f, 0f
		};

		_vertices = BufferUtils.createFloatBuffer(vertices.length);
		_vertices.put(vertices);
		_vertices.flip();

		byte[] indices = {
				0, 1, 2,
				2, 3, 0
		};
		_indicesCount = indices.length;
		_indices = BufferUtils.createByteBuffer(_indicesCount);
		_indices.put(indices);
		_indices.flip();

		_vaoId = GL30.glGenVertexArrays();
		GL30.glBindVertexArray(_vaoId);
		GL30.glBindVertexArray(0);

		_vboId = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, _vboId);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, _vertices, GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);

		GL30.glBindVertexArray(0);

		_vboiId = GL15.glGenBuffers();
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, _vboiId);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, _indices, GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
	}

	public void update(double deltaTime) {
		_rotationAngle += SPEED * deltaTime * Game.GAME_SPEED;

		if (_rotationAngle > 360.0f) {
			_rotationAngle -= 360.0f;
		}
	}

	public void draw() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT  | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glLoadIdentity();

		//GL11.glRotatef(_rotationAngle, 0.0f, 0.0f, 1.0f);

		drawTestPolygons();

		Debug.printFPS();
	}

	@Override
	public void destroy() {
		GL20.glDisableVertexAttribArray(0);

		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		GL15.glDeleteBuffers(_vboiId);

		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
		GL15.glDeleteBuffers(_vboiId);

		GL30.glBindVertexArray(0);
		GL30.glDeleteVertexArrays(_vaoId);
	}

	@Override
	public List<GameObject> gameObjects() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	private void drawTestPolygons() {
		GL30.glBindVertexArray(_vaoId);
		GL20.glEnableVertexAttribArray(0);

		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, _vboiId);

		GL11.glDrawElements(GL11.GL_TRIANGLES, _indicesCount, GL11.GL_UNSIGNED_INT, _indicesCount);

		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
		GL20.glDisableVertexAttribArray(0);
		GL30.glBindVertexArray(0);
	}
}
