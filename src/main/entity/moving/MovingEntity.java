package main.entity.moving;

import main.entity.Entity;
import main.entity.moving.character.Player;
import main.level.Level;

/**
 * Created by USER on 6/1/2017.
 * Contains a move function along with a move check.
 * Contains a speed variable with accessor/setter methods.
 */
public abstract class MovingEntity extends Entity {
	private double speed;

	public MovingEntity(double x, double y, double dir, double spd, Level level) {
		super(x, y, dir, level);
		speed = spd;
	}

	// TODO: implement checking if a moving main.entity can move in a direction
	public boolean canMove(double dir) {
		return true;
	}

	public void move(double dir) {
		if(canMove(dir)) {
			setX(getX() + speed * Math.cos(dir));
			setY(getY() - speed * Math.sin(dir));
		}
	}

	protected Player getPlayer() {
		return getLevel().getPlayer();
	}

	public void setSpeed(double newSpeed) {
		speed = newSpeed;
	}

	public double getSpeed() {
		return speed;
	}
}
