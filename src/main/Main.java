package main;

import main.display.Sprite;
import main.entity.moving.Player;
import main.entity.moving.enemy.meleeWalkingZombie;
import main.keyboard.Key;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;

public class Main {
	private Player player;
	private meleeWalkingZombie zombie1;
	private meleeWalkingZombie zombie2;
	private meleeWalkingZombie zombie3;
	private meleeWalkingZombie zombie4;
	private meleeWalkingZombie zombie5;
	private meleeWalkingZombie zombie6;
	private Key keyboard;

	private long totalFrames = 0;
	private long startTime;
	private double t;
	private int w, h;

	public void start() throws IOException {
		try {
			Display.setDisplayMode(Display.getDesktopDisplayMode());
			Display.setFullscreen(true);
			Display.create();
			w = Display.getWidth(); h = Display.getHeight();
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
		zombie1 = new meleeWalkingZombie(300,300,0,1.5,player);
		zombie2 = new meleeWalkingZombie(800,600,0,1,player);
		zombie3 = new meleeWalkingZombie(200,900,0,1.5,player);
		zombie4 = new meleeWalkingZombie(1000,-300,0,2.5,player);
		zombie5 = new meleeWalkingZombie(1300,-400,0,1.5,player);
		zombie6 = new meleeWalkingZombie(900,900,0,.5,player);
	}

	public void loop() {
		t = startTime = System.currentTimeMillis();

		while (!Display.isCloseRequested()) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

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
//		Sprite.zombie.render(0, 0, 200, 200);

		player.render();

        zombie1.render(100, 100);
        zombie2.render(100, 100);
        zombie3.render(100, 100);
        zombie4.render(100, 100);
        zombie5.render(100, 100);
        zombie6.render(100, 100);


        Sprite.tile1.render(0, 0, 32, 32);
        Sprite.tile2.render(0, 32, 32, 32);
		Sprite.tile3.render(0, 64, 32, 32);
		Sprite.tile4.render(0, 96, 32, 32);
		Sprite.tile5.render(0, 128, 32, 32);
		Sprite.tile6.render(0, 160, 32, 32);


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
		if (keyboard.key[Keyboard.KEY_W]) player.move(0.5 * Math.PI);
		if (keyboard.key[Keyboard.KEY_A]) player.move(1.0 * Math.PI);
		if (keyboard.key[Keyboard.KEY_S]) player.move(1.5 * Math.PI);
		if (keyboard.key[Keyboard.KEY_D]) player.move(0);

		zombie1.selectMove();
		zombie1.move(zombie1.getDir());
		zombie2.selectMove();
		zombie2.move(zombie2.getDir());
		zombie3.selectMove();
		zombie3.move(zombie3.getDir());
		zombie4.selectMove();
		zombie4.move(zombie4.getDir());
		zombie5.selectMove();
		zombie5.move(zombie5.getDir());
		zombie6.selectMove();
		zombie6.move(zombie6.getDir());

		player.setDir(Math.atan((player.getY() - (h - Mouse.getY())) / (Mouse.getX() - player.getX())));
		if (Mouse.getX() < player.getX())
			player.setDir(player.getDir() + Math.PI);
	}
}