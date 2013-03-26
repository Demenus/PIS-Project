package com.ub.pis.renderer.models;

import com.ub.pis.renderer.scene.Camera;

public interface IRendereable {
	public void initialize();
	public void draw(Camera camera);
}
