package main.entity.moving.character;

import main.display.Sprite;
import main.keyboard.Key;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

/**
 * Created by Kaleb on 6/1/2017.
 */
public class Player extends Actor{
    Key keyboard;

    public Player(double x, double y, double dir, double speed, double hp, Key kboard) {
		super(x, y, dir, speed, hp);
		keyboard = kboard;

		setSprite(Sprite.mainCharacter);
    }

    public void update() {
        if(isAlive()) {
            double d = (keyboard.getKeysPressed() % 2 == 0) ? Math.sqrt(2.0) : 1;
            double speed = 5.0 / d;

            setSpeed(speed);
            if (keyboard.key[Keyboard.KEY_W]) move(0.5 * Math.PI);
            if (keyboard.key[Keyboard.KEY_A]) move(1.0 * Math.PI);
            if (keyboard.key[Keyboard.KEY_S]) move(1.5 * Math.PI);
            if (keyboard.key[Keyboard.KEY_D]) move(0);

            setDir(Math.atan((getY() - (Display.getHeight() - Mouse.getY())) / (Mouse.getX() - getX())));
            if (Mouse.getX() < getX())
                setDir(getDir() + Math.PI);
        }
    }
}
