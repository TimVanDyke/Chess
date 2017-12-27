package classes;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprite {
	
	private String path;
	private int[] pixels;
	private int width, height;
	
	//Created static Sprites to be used anywhere
	public static Sprite checkerboard = new Sprite("res/checkerboard.png");
	public static Sprite highlight = new Sprite("res/highlight.png");
	
	//Sprite filepath Constructor
	public Sprite(String filename) {
		path = filename;
		load();
	}
	
	private void load()  {
		try {
			//Load in image
			BufferedImage image = ImageIO.read(new FileInputStream(path));
			width = image.getWidth();
			height = image.getHeight();
			//Set Image Size
			pixels = new int[width *height];
			//Set pixels
			image.getRGB(0, 0, width, height, pixels, 0, width);
		}catch(IOException q) {
			q.printStackTrace();
			System.out.println("Oi! File not found! Fix it!");
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int[] getPixels() {
		return pixels;
	}
}
