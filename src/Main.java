

import mouse.Mouse;
import javax.swing.*;

public class Main {
	private JFrame frame;
	private Mouse mouse;

	public static void main(String[] args)  {
		new Main();
	}

	public Main() {
		frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(frame.getWidth(), frame.getHeight());
		frame.setUndecorated(true);
		frame.setVisible(true);

		mouse = new Mouse(frame);
	}
}