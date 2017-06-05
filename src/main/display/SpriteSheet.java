package main.display;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

class SpriteSheet {
	private int width, height;
	org.newdawn.slick.SpriteSheet sheet;

	public static final SpriteSheet tiles = new SpriteSheet("res/tiles.jpg");

	public SpriteSheet(String path)  {
		Image image = null;
		try {
			image = new Image(path);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		if (image != null) {
			width = image.getWidth();
			height = image.getHeight();
			sheet = new org.newdawn.slick.SpriteSheet(image, 32, 32);
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
