package com.ub.pis.renderer.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class BufferUtils {
	
	public static FloatBuffer getFloatBuffer(float[] list) {
		ByteBuffer bb = ByteBuffer.allocateDirect(list.length * Float.SIZE/8);
		bb.order(ByteOrder.nativeOrder());
		FloatBuffer fb = bb.asFloatBuffer();
		
        fb.put(list);
        fb.position(0);
        return fb;
	}
	
	public static IntBuffer getIntegerBuffer(int[] list) {
		ByteBuffer bb = ByteBuffer.allocateDirect(list.length * Integer.SIZE/8);
		bb.order(ByteOrder.nativeOrder());
		IntBuffer ib = bb.asIntBuffer();
		
		ib.put(list);
		ib.position(0);
		return ib;
	}
	
	public static ShortBuffer getShortBuffer(short[] list) {
		ByteBuffer bb = ByteBuffer.allocateDirect(list.length * Short.SIZE/8);
		bb.order(ByteOrder.nativeOrder());
		ShortBuffer sb = bb.asShortBuffer();
		
		sb.put(list);
		sb.position(0);
		return sb;
	}
	
}