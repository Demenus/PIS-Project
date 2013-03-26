package com.ub.pis.renderer.renderer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import com.ub.pis.renderer.scene.Scene;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

public class Renderer implements GLSurfaceView.Renderer {
	
	private Scene scene;
	
	public Renderer(Scene scene) {
		this.scene = scene;
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
		scene.draw();
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		GLES20.glViewport(0, 0, width, height);
		scene.initialize(width, height);
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
		GLES20.glClearDepthf(1.0f);
		//GLES20.glEnable(GLES20.GL_CULL_FACE);
		GLES20.glEnable(GLES20.GL_DEPTH_TEST);
	}

}
