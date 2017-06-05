package main.entity.moving;

import main.display.Sprite;
import main.keyboard.Key;
import org.lwjgl.input.Keyboard;

/**
 * Created by Kaleb on 6/1/2017.
 */
public class Player extends MovingEntity {
    Key keyboard;

    public Player(double x, double y, double dir, double speed) {
		super(x, y, dir, speed);
		setSprite(Sprite.mainCharacter);
    }
}
