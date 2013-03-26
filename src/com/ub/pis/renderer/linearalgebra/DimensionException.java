package com.ub.pis.renderer.linearalgebra;

public class DimensionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DimensionException() {
		super("Dimension does not match");
	}
}
