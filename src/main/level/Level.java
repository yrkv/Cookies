package main.level;


import main.entity.Entity;
import main.entity.moving.character.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Level {
	private int[][] tiles;

	private Player player;
	public ArrayList<Entity> entities = new ArrayList<>();


	// this is for custom levels and making our own to test shit
	public Level(String path) {
		Image img = null;
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
//			e.printStackTrace();
		}

		if (img != null) { // image properly read
			tiles = new int[img.getWidth(null)][img.getHeight(null)];
		} else { // image reading failed
			System.out.println("Fuck this, I'm out! (failed to read level image)");
		}

		player = new Player(100, 100, this);
	}

	// TODO: Create a version that generates a level.

	public void updateEntities() {
		for (Entity entity: entities) {
			entity.update();
		}
	}

	public void renderEntities() {
		for (Entity entity: entities) {
			entity.render();
		}
	}

	public void addEntity(Entity entity) {
		entities.add(entity);
	}

	public Player getPlayer() {
		return player;
	}
}
