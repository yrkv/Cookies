package main.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.lwjgl.input.Keyboard;

public class Key {
	private int keysPressed = 0;
	public boolean[] key = new boolean[1000];

	public void update() {
		while (Keyboard.next()) {
			key[Keyboard.getEventKey()] = Keyboard.getEventKeyState();
			if (Keyboard.getEventKeyState()) keysPressed++;
			else keysPressed--;
		}
	}

	public int getKeysPressed() {
		return keysPressed;
	}
}
