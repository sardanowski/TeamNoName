package com.mygdx.game;

public abstract class Collider {

	CollisionType[] type;

	public Collider(CollisionType types) {
		this.type = new CollisionType[1];
		this.type[0] = types;
		CollisionTrack.addCollider(this, types);
	}

	public Collider(CollisionType... type) {
		this.type = type;
		for (CollisionType ct : type) {
			CollisionTrack.addCollider(this, ct);
		}
	}

	abstract boolean collides(Collider c);

	abstract void setPosition(double x, double y);

	abstract double getX();

	abstract double getY();

	abstract CollisionData getCollisionData();

	abstract void onCollision(CollisionType ct, CollisionData extra);

	void destruct() {
		for (int i = 0; i < type.length; i++) {
			CollisionTrack.removeCollision(this, type[i]);
		}

	}
}
