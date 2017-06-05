package main.display;


import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;

public class Sprite {
	private Texture texture;

	public static final Sprite mainCharacter = new Sprite("res/mainCharacter.jpg");
	public static final Sprite zombie = new Sprite("res/zombie.jpg");


	/**
	 *
	 * @param x
	 * @param y
	 * @param width Number of tiles the sprite is wide
	 * @param height Number of tiles the sprite is high
	 * @param sheet
	 */
	public Sprite(int x, int y, int width, int height,  SpriteSheet sheet) {
		texture = sheet.sheet.getSubImage(x, y, width, height).getTexture();
	}

	//
	public Sprite(String path) {
		try {
			texture = new Image(path).getTexture();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public Texture getTexture() {
		return texture;
	}

	public void render(double x, double y, int width, int height) {
		texture.bind();

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0,0);
		GL11.glVertex2d(x,y);
		GL11.glTexCoord2f(texture.getWidth(),0);
		GL11.glVertex2d(x+width,y);
		GL11.glTexCoord2f(texture.getWidth(),texture.getHeight());
		GL11.glVertex2d(x+width,y+height);
		GL11.glTexCoord2f(0,texture.getHeight());
		GL11.glVertex2d(x,y+height);
		GL11.glEnd();
	}
}
