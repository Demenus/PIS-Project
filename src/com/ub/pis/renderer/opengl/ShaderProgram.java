package com.ub.pis.renderer.opengl;

import com.ub.pis.renderer.linearalgebra.Matrix4f;
import com.ub.pis.renderer.linearalgebra.Vector3f;
import com.ub.pis.renderer.linearalgebra.Vector4f;
import android.opengl.GLES20;


public class ShaderProgram {
	private String vs;
	private String fs;
	
	private int vertexShader;
	private int fragmentShader;
	private int program;
	
	public ShaderProgram(String vertexShaderSource, String fragmenShaderSource) {
		this.vs = vertexShaderSource;
		this.fs = fragmenShaderSource;
	}
	
	public void initialize() {
		vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vs);
		fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fs);
		
	    program = GLES20.glCreateProgram();
	    GLES20.glAttachShader(program, vertexShader);
	    GLES20.glAttachShader(program, fragmentShader);
	    GLES20.glLinkProgram(program); 
	    
	    vs = null;
	    fs = null;
	}
	
	public void useProgram() {
		GLES20.glUseProgram(program);
	}
	
	/*
	 * TODO: Revisar si se usa as� o no
	 */
	public void unbindProgram() {
		GLES20.glUseProgram(0);
	}
	
	public int getAttribLocation(String name) {
		return GLES20.glGetAttribLocation(program, name);
	}
	
	public int getUniformLocation(String name) {
		return GLES20.glGetUniformLocation(program, name);
	}
	
	public void setUniformValue(int location, float[] m) {
		GLES20.glUniformMatrix4fv(location, 1, false, m, 0);
	}
	
	public void setUniformValue(int location, Matrix4f m) {
		GLES20.glUniformMatrix4fv(location, 1, false, m.getValues(), 0);
	}
	
	public void setUniformValue(int location, float f) {
		GLES20.glUniform1f(location, f);
	}
	
	public void setUniformValue(int location, Vector3f v) {
		GLES20.glUniform3fv(location, 1, v.getValues(), 0);
	}
	
	public void setUniformValue(int location, Vector4f v) {
		GLES20.glUniform4fv(location, 1, v.getValues(), 0);
	}
	
	private int loadShader(int type, String source) {
	    int shader = GLES20.glCreateShader(type);

	    GLES20.glShaderSource(shader, source);
	    GLES20.glCompileShader(shader);

	    final int[] compileStatus = new int[1];
	    GLES20.glGetShaderiv(shader, GLES20.GL_COMPILE_STATUS, compileStatus, 0);
	 
	    // If the compilation failed, delete the shader.
	    if (compileStatus[0] == 0)
	    {
	    	String error = GLES20.glGetShaderInfoLog(shader);
	        GLES20.glDeleteShader(shader);
	        throw new RuntimeException("Error creating vertex shader. "+error);
	    }
	    return shader;
	}

}
