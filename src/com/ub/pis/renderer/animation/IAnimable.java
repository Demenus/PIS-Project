package com.ub.pis.renderer.animation;

public interface IAnimable {
	public String getName();
	public void play();
	public void play(boolean continously);
	public void stop();
}
