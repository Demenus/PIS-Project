package com.ub.pis.app;

import com.ub.pis.renderer.scene.Camera;

public class FixedCamera extends Camera{

	@Override
	public void initialize(int width, int height) {
		float ratio = (float)width/height;
		//setProjectionMatrix(-ratio, ratio, -1, 1, 1, 100);
		setProjectionMatrix(45.0f, ratio, 1, 100.0f);
		//first
		//setViewMatrix(0, 0, -5, 0, 0, 0, 0, 1, 0);
		//second en picado
		//setViewMatrix(0,20,20,0,0,0,0,0,1);
		setViewMatrix(0,20,20,0,0,0,0,0,1);
		setViewProjectionMatrix();
		
		
		
		//rotate(-90,1,0,0);
		//translate(0, 0, -2);
		//rotate(-20, 1, 0, 0);
	}

}
