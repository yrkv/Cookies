package main.display;


import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;

public class Sprite {
	public Image image;

	public static final Sprite mainCharacter = new Sprite("res/mainCharacter.png", 200, 200);
	public static final Sprite meleeWalkingZombie = new Sprite("res/meleeWalkingZombie.png", 100, 150);
	public static final Sprite banana = new Sprite("res/banana.png");

	public static final Sprite tile1 = new Sprite(0, 0, SpriteSheet.tiles);
	public static final Sprite tile2 = new Sprite(1, 0, SpriteSheet.tiles);
	public static final Sprite tile3 = new Sprite(2, 0, SpriteSheet.tiles);
	public static final Sprite tile4 = new Sprite(3, 0, SpriteSheet.tiles);
	public static final Sprite tile5 = new Sprite(4, 0, SpriteSheet.tiles);

	public static final Sprite tile6 = new Sprite(5, 0, SpriteSheet.tiles);

	public Sprite(int x, int y, int width, int height, SpriteSheet sheet) {
		image = sheet.sheet.getSubImage(x * 32, y * 32, width * 32, height * 32);
	}

	public Sprite(int x, int y, SpriteSheet sheet) {
		image = sheet.sheet.getSubImage(x * 32, y * 32, 32, 32);
	}

	public Sprite(String path) {
		try {
			image = new Image(path);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public Sprite(String path, int width, int height) {
		try {
			image = new Image(path).getScaledCopy(width, height);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public Image getImage() {
		return image;
	}

	public void render(int x, int y, int width, int height) {
//		texture.bind();
//
//		GL11.glBegin(GL11.GL_QUADS);
//		GL11.glTexCoord2f(0,0);
//		GL11.glVertex2d(x,y);
//		GL11.glTexCoord2f(texture.getWidth(),0);
//		GL11.glVertex2d(x+width,y);
//		GL11.glTexCoord2f(texture.getWidth(),texture.getHeight());
//		GL11.glVertex2d(x+width,y+height);
//		GL11.glTexCoord2f(0,texture.getHeight());
//		GL11.glVertex2d(x,y+height);
//		GL11.glEnd();
		image.draw(x, y, width, height);
	}
}
