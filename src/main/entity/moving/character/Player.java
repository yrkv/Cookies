package main.entity.moving.character;

import main.display.Sprite;
import main.items.ItemBase;
import main.items.weapons.DopeySword;
import main.items.weapons.WeaponBase;
import main.keyboard.Key;
import main.level.Level;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Kaleb on 6/1/2017.
 */
public class Player extends Actor {

    public Player(double x, double y, Level level) {
		super(x, y, 0, 5, 100, level, 28);

		setSprite(Sprite.mainCharacter);
    }

    public void update() {
        if(isAlive()) {
            double d = (Keyboard.getKeyCount() % 2 == 0) ? Math.sqrt(2.0) : 1;
            double speed = 5.0 / d;

            setSpeed(speed);
            if (Keyboard.isKeyDown(Keyboard.KEY_W)) move(0.5 * Math.PI);
            if (Keyboard.isKeyDown(Keyboard.KEY_A)) move(1.0 * Math.PI);
            if (Keyboard.isKeyDown(Keyboard.KEY_S)) move(1.5 * Math.PI);
            if (Keyboard.isKeyDown(Keyboard.KEY_D)) move(0);
            if (Mouse.isButtonDown(1)) {
                for(ItemBase item : getInventory()) {
                    if(item.isWeapon() && item.isEquipped()) {
                        item.onUse();
                    }
                }
            }

            setDir(Math.atan((Mouse.getY() - Display.getHeight() / 2.0) / (Mouse.getX() - Display.getWidth() / 2.0)));
            if (Mouse.getX() < Display.getWidth() / 2.0)
                setDir(getDir() + Math.PI);
        }
    }
}
