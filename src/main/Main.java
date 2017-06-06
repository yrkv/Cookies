package main;

import main.display.Sprite;
import main.entity.moving.character.Player;
import main.entity.moving.character.enemy.meleeWalkingZombie;
import main.keyboard.Key;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

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
		glEnable (GL_BLEND); glBlendFunc (GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

		keyboard = new Key();
		player = new Player(100, 100, 0, 5, 100, keyboard);
		zombie1 = new meleeWalkingZombie(300,300,0,1.5,100,player);
		zombie2 = new meleeWalkingZombie(800,600,0,1,100,player);
		zombie3 = new meleeWalkingZombie(200,900,0,1.5,100,player);
		zombie4 = new meleeWalkingZombie(1000,-300,0,2.5,100,player);
		zombie5 = new meleeWalkingZombie(1300,-400,0,1.5,100,player);
		zombie6 = new meleeWalkingZombie(900,900,0,.5,100,player);
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

		player.render(200, 250);

        zombie1.render(100, 150);
        zombie2.render(100, 150);
        zombie3.render(100, 150);
        zombie4.render(100, 150);
        zombie5.render(100, 150);
        zombie6.render(100, 150);


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
		player.update();
		zombie1.update();
		zombie2.update();
		zombie3.update();
		zombie4.update();
		zombie5.update();
		zombie6.update();
    }
}