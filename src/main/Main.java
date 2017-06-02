package main;

import main.entity.moving.CookieMan;
import main.keyboard.Keyboard;
import main.mouse.Mouse;
import javax.swing.*;
import java.awt.*;

public class Main {
	private JFrame frame;
	private Mouse mouse;
	private Keyboard keyboard;

	private CookieMan player;

	private boolean running = true;
	private int totalFrames = 0;

	public static void main(String[] args)  {
		new Main();
	}

	public Main() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(frame.getWidth(), frame.getHeight());
		frame.setUndecorated(true);

		mouse = new Mouse(frame);
		keyboard = new Keyboard();
		frame.addKeyListener(keyboard);
		player = new CookieMan(300, 300, 0);

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				render(g);
			}
		};

		frame.add(panel);
		frame.setVisible(true);

		run();
	}

	private void render(Graphics g) {
		g.drawOval((int) player.getX() - 5, (int) player.getY() - 5, 10, 10);
		g.drawLine((int) player.getX(),
				(int) player.getY(),
				(int) player.getX() + (int) (Math.cos(player.getDir()) * 100),
				(int) player.getY() + (int) (Math.sin(player.getDir()) * 100));
		totalFrames++;
	}

	private void update() {
		if (keyboard.key['w']) player.move(5, 0.5*Math.PI);
		if (keyboard.key['a']) player.move(5, 1.0*Math.PI);
		if (keyboard.key['s']) player.move(5, 1.5*Math.PI);
		if (keyboard.key['d']) player.move(5, 0.0*Math.PI);

		if (mouse.x >= player.getX())
			player.setDir(Math.atan((mouse.y - player.getY()) / (mouse.x - player.getX())));
		else
			player.setDir(Math.atan((mouse.y - player.getY()) / (mouse.x - player.getX())) + Math.PI);
	}

	private void run() {
		long s = System.currentTimeMillis();
		double t = System.currentTimeMillis();
		while (running) {
			double dt = System.currentTimeMillis() - t;
			int ds = (int) (System.currentTimeMillis() - s);
			if (dt >= 1000 / 60.0) {
				t += 1000 / 60.0;
				update();
			}
			if (ds >= 1000) {
				s += 1000;
			}
			frame.repaint();
		}
	}
}