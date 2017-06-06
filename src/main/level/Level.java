package main.level;


import main.entity.Entity;
import main.entity.moving.character.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Level {
	private int[][] tiles;

	private Player player;
	public ArrayList<Entity> entities = new ArrayList<>();

	private ArrayList<Entity> entityQueue = new ArrayList<>();
	private ArrayList<Integer> deletionQueue = new ArrayList<>();


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
		addEntity(player);
	}

	// TODO: Create a version that generates a level.

	public void updateEntities() {
		for (Entity entity: entities) {
			entity.update();
		}
		deQueueEntities();
		deQueueDeletion();
	}

	public void renderEntities() {
		for (Entity entity: entities) {
			entity.render();
		}
	}

	public void deQueueEntities() {
		while (entityQueue.size() > 0) {
			entities.add(entityQueue.remove(0));
		}
	}

	public void deQueueDeletion() {
		deletionQueue.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		while (deletionQueue.size() > 0) {
			entities.remove((int) deletionQueue.remove(0));
		}
	}

	public void addEntity(Entity entity) {
		entityQueue.add(entity);
	}

	public void deleteEntity(Entity entity) {
		int i = entities.indexOf(entity);
		if (i >= 0)
			deletionQueue.add(i);
	}

	public Player getPlayer() {
		return player;
	}
}
