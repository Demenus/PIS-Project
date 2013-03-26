package com.ub.pis.renderer.utils;

import java.io.IOException;
import java.io.InputStream;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.ub.pis.renderer.models.Model;
import com.ub.pis.renderer.opengl.Mesh;
import com.ub.pis.renderer.opengl.ShaderProgram;
import com.ub.pis.renderer.opengl.Texture;
import com.ub.pis.renderer.renderer.Constants;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;



public class ModelUtils {
	private String model;
	private JSONObject root;
	private VertexStruct struct;
	private Bitmap textureBitmap;
	private String vertexShader;
	private String fragmentShader;
	
	public ModelUtils(InputStream modelStream, InputStream textureStream) throws JSONException, IOException {
		struct = new VertexStruct();
		
		model = ReadFile.read(modelStream);
		root = (JSONObject) new JSONTokener(model).nextValue();
		tokenize();
		
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inScaled = false;
		
		textureBitmap = BitmapFactory.decodeStream(textureStream);
	}
	
	public void setShaders(InputStream vertexShaderStream, InputStream fragmentShaderStream) throws IOException {
		vertexShader = ReadFile.read(vertexShaderStream);
		fragmentShader = ReadFile.read(fragmentShaderStream);
	}
	
	public Model loadModel() {
		Mesh mesh = new Mesh(struct);
		Texture texture = new Texture(textureBitmap);
		ShaderProgram program = new ShaderProgram(vertexShader, fragmentShader);
		//return new Model(struct, textureBitmap, vertexShader, fragmentShader);
		return new Model(mesh, texture, program);
	}
	
	
	private void tokenize() throws JSONException {
		loadVertices();
		loadNormals();
		//loadColors();
		loadTextures();
		//loadIndices();
	}
	

	
	private void loadVertices() throws JSONException {
		JSONObject vertObj = root.getJSONObject("Vertices");
		int n = vertObj.getInt("num")*Constants.VERTEX_COORDINATES;
		float[] v = new float[n];
		JSONArray values = vertObj.getJSONArray("co");
		for (int i = 0; i < n; i++) {
			v[i] = (float) values.getDouble(i);
		}
		struct.numVertices = vertObj.getInt("num");
		struct.vertices = v;
	}
	
	private void loadNormals() throws JSONException {
		JSONObject normObj = root.getJSONObject("Normals");
		int n = normObj.getInt("num")*Constants.NORMAL_COORDINATES;
		float[] v = new float[n];
		JSONArray values = normObj.getJSONArray("co");
		for (int i = 0; i < n; i++) {
			v[i] = (float) values.getDouble(i);
		}
		struct.normals = v;
	}
	
	private void loadIndices() throws JSONException {
		JSONObject facesObj = root.getJSONObject("Faces");
		int n = facesObj.getInt("num") * Constants.VERTEX_PER_FACE;
		short[] v = new short[n];
		JSONArray values = facesObj.getJSONArray("indices");
		for (int i = 0; i < n; i++) {
			v[i] = (short) values.getInt(i);
		}
		struct.indices = v;
	}
	
	private void loadTextures() throws JSONException {
		JSONObject texObj = root.getJSONObject("Textures");
		int n = texObj.getInt("num") * Constants.TEXTURE_COORDINATES;
		float[] v = new float[n];
		JSONArray values = texObj.getJSONArray("co");
		for (int i = 0; i < n; i++) {
			v[i] = (float) values.getDouble(i);
		}
		struct.textures = v;
	}
	
	private void loadColors() {
		int n = struct.vertices.length/3 * 4;
		float[] colors = new float[n];
		for (int i = 0; i < n; i++) {
			if (i % 4 == 0) {
				colors[i] = 1.0f;
			} else {
				colors[i] = (float) Math.random();
			}
		}
		struct.color = colors;
	}

}
