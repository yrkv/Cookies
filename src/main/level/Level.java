package main.level;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Level {
	private int[][] tiles;

	// this is for custom levels and making our own to test shit
	public Level(String path) {
		Image img = null;
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (img != null) { // image properly read
			tiles = new int[img.getWidth(null)][img.getHeight(null)];
		} else { // image reading failed
			System.out.println("Fuck this, I'm out! (failed to read level image)");
		}
	}

	// TODO: Create a version that generates a level.
}
