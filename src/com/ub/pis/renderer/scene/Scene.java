package com.ub.pis.renderer.scene;

import java.util.ArrayList;
import com.ub.pis.renderer.models.IRendereable;
import com.ub.pis.app.GameObject;

public class Scene {
	private ArrayList<IRendereable> rendereables;
	private Camera camera;
	
	public Scene(Camera camera) {
		this.camera = camera;
		rendereables = new ArrayList<IRendereable>();
	}
	
	public void add(IRendereable r) {
		rendereables.add(r);
	}
	
	public void add(GameObject o) {
		rendereables.add(o.getModel());
	}
	
	public void initialize(int width, int height) {
		for (IRendereable r : rendereables){
			r.initialize();
		}
		camera.initialize(width, height);
	}
	
	public void draw() {
		for (IRendereable r : rendereables) {
			r.draw(camera);
		}
		camera.update();
	}

}
