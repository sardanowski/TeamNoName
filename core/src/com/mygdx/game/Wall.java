package com.mygdx.game;

public class Wall extends BoxCollision {

	private int wall = 0;

	public Wall(double x, double y, double width, double height, int wall) {
		super(x, y, width, height, CollisionType.WALLCOLLISION);
		this.wall = wall;
	}

	public int getWall() {
		return wall;
	}

	@Override
	CollisionData getCollisionData() {
		return new CollisionData(this, wall);
	}

	@Override
	void onCollision(CollisionType ct, CollisionData extra) {

	}

}
