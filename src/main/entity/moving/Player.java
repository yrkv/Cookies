package main.entity.moving;

import main.display.Sprite;

/**
 * Created by Kaleb on 6/1/2017.
 */
public class Player extends MovingEntity {
    public Player(double x, double y, double dir, double speed) {
		super(x, y, dir, speed);

		setSprite(Sprite.mainCharacter);
    }
}
