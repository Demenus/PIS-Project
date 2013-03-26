package com.ub.pis.renderer.linearalgebra;

public class Vectorf {
	protected int dim;
	protected float[] values;
	
	public Vectorf(int dim) {
		this.dim = dim;
		values = new float[dim];
	}
	
	public int getDimension() {
		return dim;
	}
	
	public float[] getValues() {
		return values;
	}
	
	public void setValues(float[] values) {
		this.values = values;
	}
	
	/*public Vector add(Vector v) throws DimensionException {
		if (this.dim != v.getDimension()) {
			throw new DimensionException();
		}
		Vector r = new Vector(this.dim);
		
		for (int i = 0; i < m_v.length; i++) {
			
		}
	}*/

}
