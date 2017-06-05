package main.display;


import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;

public class Sprite {
	private Image image;

	public static final Sprite mainCharacter = new Sprite("res/mainCharacter.jpg");
//	public static final Sprite zombie = new Sprite("res/zombie.jpg");

//	public static final Sprite tile1 = new Sprite(0, 0, 32, 32, SpriteSheet.tiles);
//	public static final Sprite tile2 = new Sprite(1, 0, 32, 32, SpriteSheet.tiles);
//	public static final Sprite tile3 = new Sprite(2, 0, 32, 32, SpriteSheet.tiles);
//	public static final Sprite tile4 = new Sprite(3, 0, 32, 32, SpriteSheet.tiles);
//	public static final Sprite tile5 = new Sprite(4, 0, 32, 32, SpriteSheet.tiles);
//	public static final Sprite tile6 = new Sprite(5, 0, 32, 32, SpriteSheet.tiles);


	/**
	 *
	 * @param x
	 * @param y
	 * @param width Number of tiles the sprite is wide
	 * @param height Number of tiles the sprite is high
	 * @param sheet
	 */
	public Sprite(int x, int y, int width, int height,  SpriteSheet sheet) {
		image = sheet.sheet.getSprite(x, y);
		System.out.println(image.getWidth());
	}

	//
	public Sprite(String path) {
		try {
			image = new Image(path);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public Image getImage() {
		return image;
	}

	public void render(double x, double y, int width, int height) {
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
		image.draw((float) x, (float) y, width, height);
	}
}
