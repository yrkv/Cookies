package main.entity.moving;

import main.entity.Entity;

/**
 * Created by USER on 6/1/2017.
 * Contains a move function along with a move check.
 */
public class MovingEntity extends Entity {
	public MovingEntity(double x, double y, double dir) {
		super(x, y, dir);
	}

	// TODO: implement checking if a moving main.entity can move in a direction
	public boolean canMove(double speed, double dir) {
		return true;
	}

	public void move(double speed, double dir) {
		dir *= Math.PI;
		setX(getX() + speed * Math.cos(dir));
		setY(getY() + speed * Math.sin(dir));
	}
}
