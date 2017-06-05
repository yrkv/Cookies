package main.entity;

/**
 * Created by USER on 6/1/2017.
 * Contains positions and a direction
 */
public class Entity {
	private double x = 0;
	private double y = 0;
	private double dir = 0;

	public Entity(double x, double y, double dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
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
}
