package main.entity.moving;

import main.entity.Entity;
import main.entity.moving.character.Player;
import main.level.Level;
import main.level.tile.Tile;

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

	public boolean canMoveX(double dir) {
		double newX = getX() + speed * Math.cos(dir);
		return getLevel().collideTiles(newX, getY());
	}

	public boolean canMoveY(double dir) {
		double newY = getY() - speed * Math.sin(dir);
		return getLevel().collideTiles(getX(), newY);
	}

	public void move(double dir) {
		if (canMoveX(dir))
			setX(getX() + speed * Math.cos(dir));
		if (canMoveY(dir))
			setY(getY() - speed * Math.sin(dir));
	}

	public void setSpeed(double newSpeed) {
		speed = newSpeed;
	}

	public double getSpeed() {
		return speed;
	}
}
