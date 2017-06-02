package main.level;

public enum Tile {
	full(0xff000000),
	empty(0xff000001);

	int color;
	Tile(int color) {
		this.color = color;
	}
}
