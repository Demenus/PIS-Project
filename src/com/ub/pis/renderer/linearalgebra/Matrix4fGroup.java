package com.ub.pis.renderer.linearalgebra;

public class Matrix4fGroup {
	private float[] values;
	private int numMatrices;
	
	public Matrix4fGroup(Matrix4f[] matrices) {
		numMatrices = matrices.length;
		values = new float[numMatrices*16];
		int i = 0;
		for (Matrix4f m : matrices) {
			float[] v = m.getValues();
			for (int j = 0; j < 16; j++) {
				values[i] = v[j];
				i++;
			}
		}
	}
	
	public Matrix4fGroup(int n) {
		numMatrices = n;
		values = new float[n*16];
	}
	
	
	public float[] getValues() {
		return values;
	}
	
	public void setValues(float[] values) {
		this.values = values;
	}
	
	public static Matrix4fGroup linearInterp(float t, Matrix4fGroup m1, Matrix4fGroup m2) {
		float[] v1 = m1.getValues();
		float[] v2 = m2.getValues();
		Matrix4fGroup m = new Matrix4fGroup(v1.length);
		float[] v = m.getValues();
		for (int i = 0; i < v.length; i++) {
			v[i] = t*v1[i] + (1-t)*v2[i];
		}
		return m;
	}

}
