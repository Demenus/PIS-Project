package com.ub.pis.renderer.opengl;

import java.nio.IntBuffer;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;

public class Texture {
	private int textureHandle;
	
	private Bitmap bitmap;
	
	public Texture(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
	
	public void initialize() {
		IntBuffer buf = IntBuffer.allocate(1);
		
		GLES20.glGenTextures(1, buf);
		GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, buf.get(0));
		
		GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_NEAREST);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_NEAREST);
        
        GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bitmap, 0);
        
        bitmap.recycle();
        
        if (buf.get(0) == 0) {
        	throw new RuntimeException("Error loading texture.");
        } 
        
        textureHandle = buf.get(0);
	}
	
	public void bind() {
	    GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
	    GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureHandle);
	}
	
	public void unbind() {
		//GLES20.glActiveTexture(0);
		GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, 0);
	}

}
