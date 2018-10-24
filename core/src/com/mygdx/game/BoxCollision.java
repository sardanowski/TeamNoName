package com.mygdx.game;

public abstract class BoxCollision extends Collider {

	double x, y;
	double width, height;

	public BoxCollision(double x, double y, double width, double height, CollisionType type) {
		super(type);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public BoxCollision(double x, double y, double width, double height, CollisionType... type) {
		super(type);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	@Override
	boolean collides(Collider c) {
		if (c instanceof BoxCollision) {
			BoxCollision b = (BoxCollision) c;
			double x1, x2, x3, x4, y1, y2, y3, y4;
			x1 = x;
			x2 = b.getX();
			x3 = x + width;
			x4 = b.getX() + b.getWidth();
			y1 = y;
			y2 = b.getY();
			y3 = y + height;
			y4 = b.getY() + b.getHeight();

			if (x1 < x4 && x1 > x2) {
				if (y1 < y4 && y1 > y2) {
					return true;
				}
				if (y3 < y4 && y1 > y2) {
					return true;
				}
			}

			if (x3 < x4 && x3 > x2) {
				if (y1 < y4 && y1 > y2) {
					return true;
				}
				if (y3 < y4 && y3 > y2) {
					return true;
				}
			}

			if (x2 < x3 && x2 > x1) {
				if (y2 < y3 && y2 > y1) {
					return true;
				}
				if (y4 < y3 && y2 > y1) {
					return true;
				}
			}

			if (x4 < x3 && x4 > x1) {
				if (y2 < y3 && y2 > y1) {
					return true;
				}
				if (y4 < y3 && y4 > y1) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	double getX() {
		return x;
	}

	@Override
	double getY() {
		return y;
	}

}
