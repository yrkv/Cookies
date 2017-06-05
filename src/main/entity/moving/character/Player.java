package main.entity.moving.character;

import main.display.Sprite;

/**
 * Created by Kaleb on 6/1/2017.
 */
public class Player extends Actor {
    public Player(double x, double y, double dir, double speed, double hp) {
		super(x, y, dir, speed, hp);

		setSprite(Sprite.mainCharacter);
    }
}
