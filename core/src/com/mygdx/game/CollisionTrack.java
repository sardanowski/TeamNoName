package com.mygdx.game;

import java.util.ArrayList;

public class CollisionTrack {

	private static ArrayList<Collider> enemyHurtBoxes = new ArrayList<Collider>();
	private static ArrayList<Collider> enemyHitBoxes = new ArrayList<Collider>();
	private static ArrayList<Collider> playerHurtBoxes = new ArrayList<Collider>();
	private static ArrayList<Collider> playerHitBoxes = new ArrayList<Collider>();
	private static ArrayList<Collider> generalHurtBoxes = new ArrayList<Collider>();
	private static ArrayList<Wall> walls = new ArrayList<Wall>();

	public static void addCollider(Collider c, CollisionType type) {
		switch (type) {
		case ENEMYHURTBOX:
			enemyHurtBoxes.add(c);
			break;
		case ENEMYHITBOX:
			enemyHitBoxes.add(c);
			break;
		case PLAYERHURTBOX:
			playerHurtBoxes.add(c);
			break;
		case PLAYERHITBOX:
			playerHitBoxes.add(c);
			break;
		case HURTBOXGENERAL:
			generalHurtBoxes.add(c);
			break;
		case WALLCOLLISION:
			if (c instanceof Wall) {
				walls.add((Wall) c);
			}
			break;
		default:
			break;
		}
	}

	public static void Collisions() {

		for (Collider c : enemyHurtBoxes) {
			for (Collider co : playerHitBoxes) {
				if (c.collides(co)) {
					c.onCollision(CollisionType.WALLCOLLISION, co.getCollisionData());
					co.onCollision(CollisionType.ENEMYHURTBOX, c.getCollisionData());
				}
			}
		}

		for (Wall w : walls) {
			for (Collider co : playerHitBoxes) {
				if (w.collides(co)) {
					co.onCollision(CollisionType.WALLCOLLISION, w.getCollisionData());
					w.onCollision(CollisionType.PLAYERHITBOX, co.getCollisionData());
				}
			}

			for (Collider eh : enemyHitBoxes) {
				if (w.collides(eh)) {
					eh.onCollision(CollisionType.WALLCOLLISION, w.getCollisionData());
					w.onCollision(CollisionType.ENEMYHITBOX, eh.getCollisionData());
				}
			}
		}

		for (Collider c : playerHurtBoxes) {
			for (Collider e : enemyHitBoxes) {
				if (c.collides(e)) {
					c.onCollision(CollisionType.ENEMYHITBOX, e.getCollisionData());
					e.onCollision(CollisionType.PLAYERHURTBOX, c.getCollisionData());
				}
			}
		}
	}

	public static void removeCollision(Collider c, CollisionType type) {
		switch (type) {
		case ENEMYHITBOX:
			enemyHitBoxes.remove(c);
			break;
		case ENEMYHURTBOX:
			enemyHurtBoxes.remove(c);
			break;
		case HURTBOXGENERAL:
			generalHurtBoxes.remove(c);
			break;
		case PLAYERHITBOX:
			playerHitBoxes.remove(c);
			break;
		case PLAYERHURTBOX:
			playerHurtBoxes.remove(c);
			break;
		case WALLCOLLISION:
			if (c instanceof Wall) {
				walls.remove(c);
			}
			break;
		default:
			break;
		}
	}
}
