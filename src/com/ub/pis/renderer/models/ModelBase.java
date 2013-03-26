package com.ub.pis.renderer.models;

import com.ub.pis.renderer.linearalgebra.Matrix4f;
import com.ub.pis.renderer.opengl.Mesh;
import com.ub.pis.renderer.opengl.ShaderProgram;
import com.ub.pis.renderer.opengl.Texture;

public abstract class ModelBase {
	
	protected ShaderProgram program;
	protected Mesh mesh;
	protected Texture texture;
	protected int cameraHandle;
	protected int textureHandle;
	
	protected boolean initialized;
	
	public ModelBase(Mesh mesh, Texture texture, ShaderProgram program) {
		this.mesh = mesh;
		this.program = program;
		this.texture = texture;
		initialized = false;
	}
	
	public void initialize() {
		if (initialized) return;
		this.mesh.initialize();
		this.program.initialize();
		this.texture.initialize();
		getShaderLocations();
		initialized = true;
	}
	
	
	protected void getShaderLocations() {
		cameraHandle = program.getUniformLocation("camera");
		textureHandle = program.getUniformLocation("texture");
		mesh.setPositionLocation(program.getAttribLocation("position"));
		mesh.setNormalLocation(program.getAttribLocation("normal"));
		mesh.setTextureLocation(program.getAttribLocation("textureCoords"));
	}
	
	
	public void draw(Matrix4f m) {
		this.program.useProgram();
		texture.bind();
		
		program.setUniformValue(cameraHandle, m);
		mesh.draw();
		
		texture.unbind();
		this.program.unbindProgram();
	}
	

}
