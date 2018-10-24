package com.mygdx.game;

public class CollisionData {

	private double x, y;
	private double width, height;
	private int wallType = -1;

	public CollisionData(Collider c) {
		x = c.getX();
		y = c.getY();
	}

	public CollisionData(BoxCollision c, int wall) {
		x = c.getX();
		y = c.getY();
		width = c.width;
		height = c.height;
		wallType = wall;
	}

	public int getWall() {
		return wallType;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

}
