package com.ub.pis.renderer.linearalgebra;

public class Vector3f extends Vectorf {

	public Vector3f() {
		super(3);
	}
	
	public Vector3f(float x, float y, float z) {
		super(3);
		setValues(x, y, z);
	}
	
	public void setValues(float x, float y, float z) {
		values[0] = x;
		values[1] = y;
		values[2] = z;
	}
}
