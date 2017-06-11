package main.level;


import main.entity.Entity;
import main.entity.moving.character.Player;
import main.entity.moving.character.enemy.meleeWalkingZombie;
import main.level.tile.EmptyTile;
import main.level.tile.FullTile;
import main.level.tile.Tile;
import org.lwjgl.opengl.Display;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Level {
	private Tile[][] tiles;

	private Player player;
	public ArrayList<Entity> entities = new ArrayList<>();

	private ArrayList<Entity> entityQueue = new ArrayList<>();


	// this is for custom levels and making our own to test shit
	public Level(String path) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
//			e.printStackTrace();
		}

		if (img != null) { // image properly read
			tiles = new Tile[img.getHeight(null)][img.getWidth(null)];


			for (int i = 0; i < tiles.length; i++) {
				for (int j = 0; j < tiles[i].length; j++) {
					genTile(img.getRGB(j, i), j, i);
				}
			}
		} else { // image reading failed
			System.out.println("Fuck this, I'm out! (failed to read level image)");
		}
	}

	private void genTile(int color, int x, int y) {
		color &= 0xffffff;
		switch (LevelData.values()[color]) {
			case empty:
				tiles[y][x] = new EmptyTile(x * 32, y * 32);
				break;
			case  full:
				tiles[y][x] = new FullTile(x * 32, y * 32);
				break;
			case  player:
				genTile(LevelData.empty.ordinal(), x, y);
				addEntity(player = new Player(x, y, this));
				break;
			case  zombie:
				genTile(LevelData.empty.ordinal(), x, y);
				addEntity(new meleeWalkingZombie(x, y, 0, 1.5, 100, this));
				break;
		}
	}

	// TODO: Create a version that generates a level.

	public void updateEntities() {
		for (int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			if (entity.isAlive())
				entity.update();
			else {
				entities.remove(i);
				i--;
			}
		}
		deQueueEntities();
	}

	public void render() {
		renderTiles((int)player.getX(), (int)player.getY());
		renderEntities();
	}

	public void renderEntities() {
		for (Entity entity: entities) {
			entity.render();
		}
	}

	public void renderTiles(int xScroll, int yScroll) {
		for (int x = xScroll / 32; x <= (xScroll + Display.getWidth()) / 32; x++) {
			for (int y = yScroll / 32; y <= (yScroll + Display.getHeight()) / 32; y++) {
				if (y > 0 && y < tiles.length && x > 0 && x < tiles[y].length)
					tiles[y][x].render(xScroll, yScroll);
			}
		}
	}

	public void deQueueEntities() {
		while (entityQueue.size() > 0) {
			entities.add(entityQueue.remove(0));
		}
	}

	public void addEntity(Entity entity) {
		entityQueue.add(entity);
	}

	public Player getPlayer() {
		return player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}
}
