package main.display;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

class SpriteSheet {
	private int width, height;
	org.newdawn.slick.SpriteSheet sheet;

	public SpriteSheet(String path) throws SlickException {
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
		} else
			throw new SlickException("fuck"); // TODO: change this.
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
