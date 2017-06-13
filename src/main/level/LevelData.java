package main.level;

//TODO: change level data to be more readable
//TODO: red   : enemy entity
//TODO: green : ally entity
//TODO: black : wall/colision tile
//TODO: white : open space/no colision tile
//TODO: blue  : items
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
