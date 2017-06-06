package main.level.tile;

import main.display.Sprite;

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
		sprite.image.draw(x - xScroll, y - yScroll, 32, 32);
	}

	protected boolean hasCollision() {
		return false;
	}

	public boolean collide(double x, double y) {
		if (hasCollision()) {
			return (x >= this.x && x <= this.x + 32 && y >= this.y && y <= this.y + 32);
		} else {
			return false;
		}
	}
}
