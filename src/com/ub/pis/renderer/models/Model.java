package com.ub.pis.renderer.models;

import com.ub.pis.renderer.linearalgebra.Matrix4f;
import com.ub.pis.renderer.linearalgebra.Vector3f;
import com.ub.pis.renderer.opengl.Mesh;
import com.ub.pis.renderer.opengl.ShaderProgram;
import com.ub.pis.renderer.opengl.Texture;
import com.ub.pis.renderer.scene.Camera;

/*
 * TODO: Hacer que se pueda rotar y trasladar independientemente?
 */
public class Model extends ModelBase implements IRendereable, IPositionable{

	private Matrix4f modelMatrix;
	private Matrix4f mvpMatrix;
	private Vector3f position;
	
	private float rotx = 0;
	private float roty = 0;
	private float rotz = 0;

	
	public Model(Mesh mesh, Texture texture, ShaderProgram program) {
		super(mesh, texture, program);
		position = new Vector3f();
	}

	
	@Override
	public void initialize() {
		super.initialize();
		modelMatrix = new Matrix4f();
		mvpMatrix = new Matrix4f();
		modelMatrix.setIdentity();

	}
	
	@Override
	public void rotateY(float a) {
		roty = a;
	}
	
	@Override
	public void rotateX(float a) {
		rotx = a;
	}
	
	@Override
	public void rotateZ(float a) {
		rotz = a;
	}
	
	public void rotate(float rotx, float roty, float rotz) {
		this.rotx = rotx;
		this.roty = roty;
		this.rotz = rotz;
	}

	@Override
	public void translate(float x, float y, float z) {
		position.setValues(x, y, z);
	}

	@Override
	public Vector3f getPosition() {
		return null;
	}
	
	@Override
	public Vector3f getRotation() {
		return new Vector3f(rotx,roty,rotz);
	}


	@Override
	public void draw(Camera camera) {
		//modelMatrix.translate(position);
		modelMatrix.setIdentity();
		modelMatrix.translate(position);
		modelMatrix.rotate(rotx, roty, rotz);
		
		camera.getViewProjectionMatrix().multiplyRight(modelMatrix, mvpMatrix);
		super.draw(mvpMatrix);
	}

}
