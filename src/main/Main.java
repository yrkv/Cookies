package main;

import main.display.Sprite;
import main.entity.moving.character.Player;
import main.entity.moving.character.enemy.meleeWalkingZombie;
import main.entity.moving.character.enemy.radiatedGunner;
import main.keyboard.Key;
import main.level.Level;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;

public class Main {
	private Level level;

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

		level = new Level("haha who needs levels");

		level.addEntity(new meleeWalkingZombie(300,300,0,1,100,level));
		level.addEntity(new meleeWalkingZombie(800,600,0,1.1,100,level));
		level.addEntity(new meleeWalkingZombie(200,900,0,1.2,100,level));
		level.addEntity(new meleeWalkingZombie(1000,-300,0,1.3,100,level));
		level.addEntity(new meleeWalkingZombie(1300,-400,0,1.4,100,level));
		level.addEntity(new meleeWalkingZombie(900,900,0,1.5,100,level));
		level.addEntity(new radiatedGunner(1200,1200,0,2,100,5000,level));
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

        Sprite.tile1.render(0, 0, 32, 32);
        Sprite.tile2.render(0, 32, 32, 32);
		Sprite.tile3.render(0, 64, 32, 32);
		Sprite.tile4.render(0, 96, 32, 32);
		Sprite.tile5.render(0, 128, 32, 32);
		Sprite.tile6.render(0, 160, 32, 32);

		level.renderEntities();

		totalFrames++;
	}

	private void run() {
		if (System.currentTimeMillis() - t > (double) 1000 / 60) {
			update();
			t += (double) 1000 / 60;
		}
	}

	private void update() {
		level.updateEntities();
    }
}