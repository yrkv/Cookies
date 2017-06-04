package main.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.lwjgl.input.Keyboard;

public class Key {
	public boolean[] key = new boolean[1000];

	public void update() {
		while (Keyboard.next()) {
			key[Keyboard.getEventKey()] = Keyboard.getEventKeyState();
		}
	}
}
