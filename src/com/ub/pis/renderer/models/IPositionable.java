package com.ub.pis.renderer.models;

import com.ub.pis.renderer.linearalgebra.Vector3f;

public interface IPositionable {
	public void rotateX(float a);
	public void rotateY(float a);
	public void rotateZ(float a);
	public void rotate(float rotx, float roty, float rotz);
	public void translate(float x, float y, float z);
	public Vector3f getPosition();
	public Vector3f getRotation();
}
