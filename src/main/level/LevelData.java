package main.level;

public enum LevelData {
	nullTile(-1),
	full(0x000000),
	empty(0xffffff),
	player(0x0000ff),
	zombie(0xff0000);

	final int color;

	private LevelData(int color) {
		this.color = color;
	}
}
