package main.level.tile;

import main.display.Sprite;

/**
 * Created by Yegor Kuznetsov on 6/6/2017.
 */
public class FullTile extends Tile {
	public FullTile(int x, int y) {
		super(x, y, Sprite.tile5);
	}

	public boolean hasCollision() {
		return true;
	}
}
