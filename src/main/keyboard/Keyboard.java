package main.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	public boolean[] key = new boolean[1000];

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyChar();
		if (code < key.length) {
			key[code] = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyChar();
		if (code < key.length) {
			key[code] = false;
		}
	}
}
