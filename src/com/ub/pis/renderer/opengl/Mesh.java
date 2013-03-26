package com.ub.pis.renderer.opengl;

import com.ub.pis.renderer.renderer.Constants;
import com.ub.pis.renderer.utils.VertexStruct;
import android.opengl.GLES20;

public class Mesh {
	private int numVertices;
	
	private int positionHandle;
	private static int positionInit = 0;
	
	private int normalHandle;
	private static int normalInit = Constants.FLOAT_SIZE * Constants.VERTEX_COORDINATES;
	
	private int textureHandle;
	private static int textureInit = Constants.FLOAT_SIZE * (Constants.VERTEX_COORDINATES + Constants.NORMAL_COORDINATES);
	

	
	private static final int Stride = Constants.FLOAT_SIZE * (Constants.VERTEX_COORDINATES + Constants.NORMAL_COORDINATES + Constants.TEXTURE_COORDINATES);
	private VertexBufferObject vbo;
	//private BufferObject ibo;
	
	private VertexStruct vStruct;
	
	public Mesh(VertexStruct vStruct) {
		this.vStruct = vStruct;
	}
	
	public void initialize() {
		this.vbo = new VertexBufferObject(vStruct.getPackedVertex());
		//this.ibo = new BufferObject(vStruct.getIndices());
		numVertices = vStruct.numVertices;
		vStruct = null;
	}
	
	public void setPositionLocation(int location) {
		this.positionHandle = location;
	}
	
	public void setNormalLocation(int location) {
		this.normalHandle = location;
	}
	
	public void setTextureLocation(int location) {
		this.textureHandle = location;
	}
	

	
	public void draw() {
		this.vbo.bind();
		
		GLES20.glEnableVertexAttribArray(positionHandle);
		GLES20.glVertexAttribPointer(positionHandle, Constants.VERTEX_COORDINATES, GLES20.GL_FLOAT, false, Stride, positionInit);
		
		GLES20.glEnableVertexAttribArray(normalHandle);
		GLES20.glVertexAttribPointer(normalHandle, Constants.NORMAL_COORDINATES, GLES20.GL_FLOAT, false, Stride, normalInit);
		
		GLES20.glEnableVertexAttribArray(textureHandle);
		GLES20.glVertexAttribPointer(textureHandle, Constants.TEXTURE_COORDINATES, GLES20.GL_FLOAT, false, Stride, textureInit);
		
		//this.ibo.bind();
		//GLES20.glDrawElements(GLES20.GL_TRIANGLES, ibo.getLength(), GLES20.GL_UNSIGNED_SHORT, 0);
		GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, numVertices);
		
		GLES20.glDisableVertexAttribArray(positionHandle);
		GLES20.glDisableVertexAttribArray(normalHandle);
		GLES20.glDisableVertexAttribArray(textureHandle);
		this.vbo.unbind();
		//this.ibo.unbind();
	}

}
