package classes;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Gui extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static int width = 800;
	public static int height = 640;
	private String title = "Chess!";
	private Canvas canvas;
	private boolean running = false;
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	private Main main;
	
	public Gui() {
		//Create Window (JFrame)
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(null);		
		
		//Put Stuff in the Window
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		add(canvas);
		pack();
		setVisible(true);
		
		main = new Main();
		
	}
	
	// Launcher
	public void start() {
		running = true;
		requestFocus();
		run();
	}
	
	// Update All Objects
	public void update() {
		main.update();
	}
	
	//Render the Image to the Canvas
	public void render() {
		// If no BufferStrategy exists, make it a 3 length buffer
		BufferStrategy bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		//Clear the screen to all black
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
		
		//Set pixels
		main.render(pixels);
		
		// Draw Graphics
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		g.setColor(Color.orange);
		g.drawLine(1, 0, width-1, height-1);
		
		// Dispose Graphics
		g.dispose();
		//Show BufferedImage
		bs.show();
	}
	
	// Main Program Loop
	public void run() {
		while (running){
			update();
			render();
		}
	}
	
	public static void main(String[] args) {
		Gui frame = new Gui();
		frame.start();
	}

}
