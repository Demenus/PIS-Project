package com.ub.pis.renderer.utils;

import com.ub.pis.renderer.renderer.Constants;


public class VertexStruct {
	public float[] vertices;
	public float[] normals;
	public float[] textures;
	public float[] color;
	public short[] indices;
	public float[] packed;
	public int numVertices;
	
	public boolean isPacked = false;
	
	public VertexStruct() {
		
	}
	
	public VertexStruct(int numVertices) {
		this.numVertices = numVertices;
		initialize();
	}
	
	private void initialize(){
		vertices = new float[Constants.VERTEX_COORDINATES * numVertices];
		color = new float[Constants.COLOR_COORDINATES * numVertices];
		normals = new float[Constants.NORMAL_COORDINATES * numVertices];
		textures = new float[Constants.VERTEX_COORDINATES * numVertices];
		indices = new short[numVertices];
		//packed = new float[vertices.length+color.length];
		packed = new float[vertices.length+normals.length+color.length];
	}
	
	
	/*
	 * TODO: Falta optimizaci�n Y en vez de esto podrias usar buffer subdata
	 * Mejor cargarlo todo con listas
	 */
	public float[] getPackedVertex() {
		if (isPacked) {
			return packed;
		}
		packed = new float[vertices.length+normals.length+textures.length];
		int i = 0;
		int vertIndex = 0;
		int norIndex = 0;
		int texIndex = 0;
		while (i < packed.length) {
			for (int j = vertIndex; j < vertIndex + Constants.VERTEX_COORDINATES; j++) {
				packed[i] = vertices[j];
				i++;
			}
			vertIndex += Constants.VERTEX_COORDINATES;
			
			for (int j = norIndex; j < norIndex + Constants.NORMAL_COORDINATES; j++) {
				packed[i] = normals[j];
				i++;
			}
			norIndex += Constants.NORMAL_COORDINATES;
			
			for (int j = texIndex; j < texIndex + Constants.TEXTURE_COORDINATES; j++) {
				packed[i] = textures[j];
				i++;
			}
			texIndex += Constants.TEXTURE_COORDINATES;
			
		}
		return packed;
		//return vertices;
	}
	
	public short[] getIndices() {
		return indices;
	}
	

	
}
