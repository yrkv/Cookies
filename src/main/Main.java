package main;

import main.display.Sprite;
import main.entity.moving.Player;
import main.entity.moving.enemy.meleeWalkingZombie;
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
	private meleeWalkingZombie zombie1;
	private Key keyboard;

	private long totalFrames = 0;
	private long startTime;
	private double t;
	private int w, h;

	public void start() throws IOException {
		try {
			w = 800; h = 600;
			Display.setDisplayMode(new DisplayMode(w,h));
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
		glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);

		keyboard = new Key();
		player = new Player(100, 100, 0, 5);
		zombie1 = new meleeWalkingZombie(800,800,0,1.5,player);
	}

	public void loop() {
		int texID = glGenTextures();
//		ByteBuffer bb = BufferUtils.createByteBuffer(Display.getWidth()*Display.getHeight()*3);
//
//		for (int i = 0; i < Display.getWidth(); i++) {
//			for (int j = 0; j < Display.getHeight(); j++) {
//				bb.put((byte) 0xff);
//				bb.put((byte) 0xff);
//				bb.put((byte) 0xff);
////				bb.put((byte) 0x00);
//			}
//		}
//		bb.flip();
//
//		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
//		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		t = startTime = System.currentTimeMillis();

		while (!Display.isCloseRequested()) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

//			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, Display.getWidth(), Display.getHeight(), 0, GL_RGB, GL_UNSIGNED_BYTE, bb);

//			glBegin(GL_QUADS);
//				glTexCoord2f(0,0);
//				glVertex2f(0,0);
//
//				glTexCoord2f(1,0);
//				glVertex2f(Display.getWidth(),0);
//
//				glTexCoord2f(1,1);
//				glVertex2f(Display.getWidth(),Display.getHeight());
//
//				glTexCoord2f(0,1);
//				glVertex2f(0,Display.getHeight());
//			glEnd();

			render();

			totalFrames++;
			run();
			Display.update();
		}
	}

	public static void main(String[] args) throws IOException {
		new Main().start();
	}

	private void render() {
		//Char 1 begin
	    glLineWidth(2.5f);
		glColor3f(1f, 1f, 0f);
		glBegin(GL_LINES);
		glVertex2d(player.getX(), player.getY());
		glVertex2d(player.getX() + (Math.cos(player.getDir()) * 100),
				player.getY() + (Math.sin(player.getDir()) * 100));
		glEnd();
		glLineWidth(0.5f);
		glBegin(GL_POLYGON);
		for(double i = 0; i < 2 * Math.PI; i += Math.PI / 12)
			glVertex2d(Math.cos(i) * 5 + player.getX(), Math.sin(i) * 5 + player.getY());
		glEnd();
		glColor3f(0f, 0f, 0f);
		//Char 1 end

        //Char 2 begin
        glLineWidth(2.5f);
        glColor3f(1f, 0, 0f);
        glBegin(GL_LINES);
        glVertex2d(zombie1.getX(), zombie1.getY());
        glVertex2d(zombie1.getX() + (Math.cos(zombie1.getDir()) * 100),
                zombie1.getY() + (Math.sin(zombie1.getDir()) * 100));
        glEnd();
        glLineWidth(0.5f);
        glBegin(GL_POLYGON);
        for(double i = 0; i < 2 * Math.PI; i += Math.PI / 12)
            glVertex2d(Math.cos(i) * 5 + zombie1.getX(), Math.sin(i) * 5 + zombie1.getY());
        glEnd();
        glColor3f(1f, 1f, 1f);
        //Char 2 end

//		Sprite.zombie.render(0, 0, 200, 200);
//		Sprite.mainCharacter.render(300, 300, 200, 200);
//		Sprite.tile1.render(0, 0, 32, 32);
//		Sprite.tile2.render(0, 32, 32, 32);
//		Sprite.tile3.render(0, 64, 32, 32);
//		Sprite.tile4.render(0, 96, 32, 32);
//		Sprite.tile5.render(0, 128, 32, 32);
//		Sprite.tile6.render(0, 160, 32, 32);

		totalFrames++;
	}

	private void run() {
		keyboard.update();

		if (System.currentTimeMillis() - t > (double) 1000 / 60) {
			update();
			t += (double) 1000 / 60;
		}
	}

	private void update() {
		double d = (keyboard.getKeysPressed() % 2 == 0) ? Math.sqrt(2.0) : 1;
		double speed = 5.0 / d;

		player.setSpeed(speed);
		if (keyboard.key[Keyboard.KEY_W]) player.move(0.5);
		if (keyboard.key[Keyboard.KEY_A]) player.move(1.0);
		if (keyboard.key[Keyboard.KEY_S]) player.move(1.5);
		if (keyboard.key[Keyboard.KEY_D]) player.move(0.0);

		zombie1.chooseDirection();
		zombie1.move(zombie1.getDir());


		if (Mouse.getX() >= player.getX())
			player.setDir(Math.atan((h - Mouse.getY() - player.getY()) / (Mouse.getX() - player.getX())));
		else
			player.setDir(Math.atan((h - Mouse.getY() - player.getY()) / (Mouse.getX() - player.getX())) + Math.PI);

//		System.out.println("player x: " + player.getX() + " player y: " + player.getY() + " player dir: " + player.getDir() + "zombie1 x: " + zombie1.getX() + " zombie1 y: " + zombie1.getY()
//            + " zombie dir: " + zombie1.getDir());
	}
}