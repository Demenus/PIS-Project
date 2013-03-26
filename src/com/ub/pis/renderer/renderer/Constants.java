package com.ub.pis.renderer.renderer;

public class Constants {
	public static final int FLOAT_SIZE = Float.SIZE/8;
	public static final int SHORT_SIZE = Short.SIZE/8;
	
	public static final int VERTEX_PER_FACE = 3;
	public static final int VERTEX_COORDINATES = 3;
	public static final int NORMAL_COORDINATES = 3;
	public static final int TEXTURE_COORDINATES = 2;
	public static final int COLOR_COORDINATES = 4;
	public static final int STRIDE = (VERTEX_COORDINATES + COLOR_COORDINATES) * FLOAT_SIZE;
}
