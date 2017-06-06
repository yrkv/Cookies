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

	public boolean render() {
		return render(sprite.getImage().getWidth(), sprite.getImage().getHeight());
	}

	public boolean render(int width, int height) {
		if (sprite != null) {
			sprite.image.setCenterOfRotation(width / 2f, height / 2f);
			sprite.image.setRotation((float) (-dir * 180 / Math.PI) - 90);
			sprite.render(x - width / 2.0, y - height / 2.0, width, height);
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

	// TODO: Add a "width" and a "height" property to entities and use that for colision detection.
	public boolean colidesWith(Entity other) {
		double dx = getX() - other.getX();
		double dy = getY() - other.getY();

		if(dx < 15 && dy < 15 && dx > -15 && dy > -15) {
			return true;
		}
		return false;
	}

	public double setDirTowards(Entity to) {
		double direction;

		double fx = getX();
		double fy = getY();
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

		setDir(direction);
		return direction;
	}
	//TODO: use tile coords for directioning
	public double setDirTowardsTile(int x, int y) {
		double direction = 0;
		return direction;
	}
}
