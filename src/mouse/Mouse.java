package mouse;

import javax.swing.*;

public class Mouse {
	public int x, y;

	public Mouse(JFrame frame) {
		frame.addMouseListener(new MouseEvents(this));
		frame.addMouseMotionListener(new MouseMotion(this));
	}
}