package main.level.tile;

import main.display.Sprite;

/**
 * Created by Yegor Kuznetsov on 6/6/2017.
 */
public class EmptyTile extends Tile {
	public EmptyTile(int x, int y) {
		super(x, y, Sprite.tile6);
	}

	public boolean hasCollision() {
		return false;
	}
}
