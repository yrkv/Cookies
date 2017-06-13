package main.level.tile;

import main.display.Sprite;
import org.lwjgl.opengl.Display;

/**
 * Created by Yegor Kuznetsov on 6/6/2017.
 */
public abstract class Tile {
	private int x, y;
	private Sprite sprite;

	public Tile(int x, int y, Sprite sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}

	public void render(int xScroll, int yScroll) {
		sprite.image.draw(x - xScroll + Display.getWidth() / 2, y - yScroll + Display.getHeight() / 2, 32, 32);
	}

	public boolean hasCollision() {
		return false;
	}

	public boolean collide(double x, double y) {
		x %= 32;
		y %= 32;
		if (hasCollision()) {
			return (x >= 0 && x <= 32 && y >= 0 && y <= 32);
		} else {
			return false;
		}
	}
}
