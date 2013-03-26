package com.ub.pis.renderer.linearalgebra;

public class Vector4f extends Vectorf {

	public Vector4f() {
		super(4);
	}
	
	public Vector4f(float w, float x, float y, float z) {
		super(4);
		setValues(w, x, y, z);
	}
	
	public void setValues(float w, float x, float y, float z) {
		values[0] = w;
		values[1] = x;
		values[2] = y;
		values[3] = z;
	}
}
