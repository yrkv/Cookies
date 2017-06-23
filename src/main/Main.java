package main;

import main.items.weapons.dopeysword.DopeySword;
import main.items.weapons.sonicgun.SonicGun;
import main.level.Level;
import org.lwjgl.LWJGLException;
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

		level = new Level("res/level.png");

//		level.addEntity(new meleeWalkingZombie(300,300,0,1,100,level));
//		level.addEntity(new meleeWalkingZombie(800,600,0,1.1,100,level));
//		level.addEntity(new meleeWalkingZombie(200,900,0,1.2,100,level));
//		level.addEntity(new meleeWalkingZombie(1000,-300,0,1.3,100,level));
//		level.addEntity(new meleeWalkingZombie(1300,-400,0,1.4,100,level));
//		level.addEntity(new meleeWalkingZombie(900,900,0,1.5,100,level));
//		level.addEntity(new radiatedGunner(600,600,0,2,100,5000, 300,level));

//		DopeySword PoS = new DopeySword(level);
//		level.getPlayer().addItem(PoS);
//		level.getPlayer().equipItem(0);

		SonicGun pow = new SonicGun(level);
		level.getPlayer().addItem(pow);
		level.getPlayer().equipItem(0);

		level.deQueueEntities();
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

		level.render();

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