package main;

import main.entity.moving.Player;
import main.keyboard.Key;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;
import java.nio.ByteBuffer;

public class Main {
	private Player player;
	private Key keyboard;

	private long totalFrames = 0;
	private long startTime;
	private double t;

	public void start() throws IOException {
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		init();
		loop();

		Display.destroy();
	}

	public void init() throws IOException {
		glEnable(GL_TEXTURE_2D);

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 0, 600, 1, -1);
		glMatrixMode(GL_MODELVIEW);

		keyboard = new Key();
		player = new Player(100, 100, 0);
	}

	public void loop() {
		int texID = glGenTextures();

		ByteBuffer bb = BufferUtils.createByteBuffer(Display.getWidth()*Display.getHeight()*3);

		for (int i = 0; i < Display.getWidth(); i++) {
			for (int j = 0; j < Display.getHeight(); j++) {
				bb.put((byte) 0x00);
				bb.put((byte) 0x00);
				bb.put((byte) 0x00);
//				bb.put((byte) 0x00);
			}
		}
		bb.flip();

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		t = startTime = System.currentTimeMillis();

		while (!Display.isCloseRequested()) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, Display.getWidth(), Display.getHeight(), 0, GL_RGB, GL_UNSIGNED_BYTE, bb);

			glBegin(GL_QUADS);
				glTexCoord2f(0,0);
				glVertex2f(0,0);

				glTexCoord2f(1,0);
				glVertex2f(Display.getWidth(),0);

				glTexCoord2f(1,1);
				glVertex2f(Display.getWidth(),Display.getHeight());

				glTexCoord2f(0,1);
				glVertex2f(0,Display.getHeight());
			glEnd();

			totalFrames++;
			run();
			Display.update();
		}
	}

	public static void main(String[] args) throws IOException {
		new Main().start();
	}

//	private void render(Graphics g) {
//		g.drawOval((int) player.getX() - 5, (int) player.getY() - 5, 10, 10);
//		g.drawLine((int) player.getX(),
//				(int) player.getY(),
//				(int) player.getX() + (int) (Math.cos(player.getDir()) * 100),
//				(int) player.getY() + (int) (Math.sin(player.getDir()) * 100));
//		totalFrames++;
//	}

	private void run() {
		keyboard.update();

		if (System.currentTimeMillis() - t > (double) 1000 / 60) {
			update();
			t += (double) 1000 / 60;
		}
	}

	private void update() {
		if (keyboard.key[Keyboard.KEY_W]) player.move(5, 0.5*Math.PI);
		if (keyboard.key[Keyboard.KEY_A]) player.move(5, 1.0*Math.PI);
		if (keyboard.key[Keyboard.KEY_S]) player.move(5, 1.5*Math.PI);
		if (keyboard.key[Keyboard.KEY_D]) player.move(5, 0.0*Math.PI);

		if (Mouse.getX() >= player.getX())
			player.setDir(Math.atan((Mouse.getY() - player.getY()) / (Mouse.getX() - player.getX())));
		else
			player.setDir(Math.atan((Mouse.getY() - player.getY()) / (Mouse.getX() - player.getX())) + Math.PI);
	}
}