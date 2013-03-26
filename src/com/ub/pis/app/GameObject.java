package com.ub.pis.app;

import com.ub.pis.renderer.models.Model;

public class GameObject{
	
	private Model model;
	private float speed;
	private float x,y;
	
	public GameObject(Model model) {
		this.model = model;
	}
	
	public Model getModel() {
		return model;
	}
	
	public void moveTo(float x, float y) {
		model.translate(x, 0, y);
	}
	
	public void rotate(float a) {
		model.rotateZ(a);
	}
}
