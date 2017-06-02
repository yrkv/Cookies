package main.mouse;

import javax.swing.*;

public class Mouse {
	public int x = 0, y = 0;

	public Mouse(JFrame frame) {
		frame.addMouseListener(new MouseEvents(this));
		frame.addMouseMotionListener(new MouseMotion(this));
	}
}