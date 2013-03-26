package com.ub.pis.renderer.linearalgebra;

import android.opengl.Matrix;

public class Matrix4f {
	private float[] values;
	
	private final float[] rotx = new float[16];
	private final float[] roty = new float[16];
	private final float[] rotz = new float[16];
	
	public Matrix4f() {
		values = new float[16];
	}
	
	public void setValues(float[] values) {
		this.values = values;
	}
	
	public float[] getValues() {
		return values;
	}
	
	public void setIdentity() {
		Matrix.setIdentityM(values, 0);
	}
	
	public void setRotate(float a, float x, float y, float z) {
		Matrix.setRotateM(values, 0, a, x, y, z);
	}
	

	
	/*
	 * Multiply in place m * this
	 */
	public void multiplyLeft(Matrix4f m) {
		Matrix.multiplyMM(values, 0, m.getValues(), 0, values, 0);
	}
	
	/*
	 * Multiply in place this * m
	 */
	public void multiplyRight(Matrix4f m) {
		Matrix.multiplyMM(values, 0, values, 0, m.getValues(), 0);
	}
	
	/*
	 * Multiply m * this and saves the result in r
	 */
	public void multiplyLeft(Matrix4f m, Matrix4f result) {
		Matrix.multiplyMM(result.getValues(), 0, m.getValues(), 0, values, 0);
	}
	
	/*
	 * Multiply this * m and saves the result in result
	 */
	public void multiplyRight(Matrix4f m, Matrix4f result) {
		Matrix.multiplyMM(result.getValues(), 0, values, 0, m.getValues(), 0);
	}
	
	public void translate(float x, float y, float z) {
		Matrix.translateM(values, 0, x, y, z);
	}
	
	public void translate(Vector3f v) {
		float[] f = v.getValues();
		Matrix.translateM(values, 0, f[0], f[1], f[2]);
	}
	
	public void setTranslate(Vector3f v) {
		float[] f = v.getValues();
		Matrix.setIdentityM(values, 0);
		Matrix.translateM(values, 0, f[0], f[1], f[2]);
	}
	
	public void rotate(float a, float x, float y, float z) {
		Matrix.rotateM(values, 0, a, x, y, z);
	}
	
	public void rotate(float rx, float ry, float rz) {
		//Matrix.setRotateM(rotx, 0, rx, 1, 0 , 0);
		//Matrix.setRotateM(roty, 0, ry, 0, 1, 0);
		//Matrix.setRotateM(rotz, 0, rz, 0, 0, 1);
		//Matrix.multiplyMM(values, 0, rotx, 0, values, 0);
		//Matrix.multiplyMM(values, 0, roty, 0, values, 0);
		//Matrix.multiplyMM(values, 0, rotz, 0, values, 0);
		Matrix.rotateM(values, 0, rx, 1, 0, 0);
		Matrix.rotateM(values, 0, ry, 0, 1, 0);
		Matrix.rotateM(values, 0, rz, 0, 0, 1);
		
	}
	
	
	public void setRotate(float rx, float ry, float rz) {
		Matrix.setRotateM(rotx, 0, rx, 1, 0 , 0);
		Matrix.setRotateM(roty, 0, ry, 0, 1, 0);
		Matrix.setRotateM(rotz, 0, rz, 0, 0, 1);
		Matrix.multiplyMM(values, 0, roty, 0, rotx, 0);
		Matrix.multiplyMM(values, 0, rotz, 0, values, 0);
	}

}
