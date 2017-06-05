package main.entity;

import main.display.Sprite;

/**
 * Created by Yegor Kuznetsov on 6/1/2017.
 * Contains positions and a direction
 */
public class Entity {
	private double x = 0;
	private double y = 0;
	private double dir = 0;
	private Sprite sprite = null;

	public Entity(double x, double y, double dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public boolean render(double x, double y) {
		return render(x, y, (int) sprite.getImage().getWidth(), (int) sprite.getImage().getHeight());
	}

	public boolean render(double x, double y, int width, int height) {
		if (sprite != null) {
			sprite.render(x, y, width, height);
		}
		return sprite != null;
	}

	protected void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	public double getX() {
		return x;
	}

	protected void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	protected void setY(double y) {
		this.y = y;
	}

	public double getDir() {
		return dir;
	}

	public void setDir(double dir) {
		this.dir = dir;
	}

	public double setDirFromTo(Entity from, Entity to) {
		double direction;

		double fx = from.getX();
		double fy = from.getY();
		double tx = to.getX();
		double ty = to.getY();

		double dy = ty - fy;
		double dx = tx - fx;

		double slope = -dy/dx;

		if(dx > 0) {
			direction = Math.atan(slope);
		} else {
			direction = Math.PI + Math.atan(slope);
		}

		from.setDir(direction);
		return direction;
	}
}
