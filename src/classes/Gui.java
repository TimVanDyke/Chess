package classes;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui extends JFrame{
	private static final long serialVersionUID = 1L;
	
	//Window Size
	public static int width = 640;
	public static int height = 640;
	private String title = "Chess!";
	private Canvas canvas;
	private Mouse mouse;
	private boolean running = false;
	//Image Stuff for Canvas Rendering
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	private Main main;
	
	public Gui() {
		//Create Window (JFrame)
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(null);		
		
		//Put Stuff in the Window
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		add(canvas);
		JButton quit = new JButton("Quit");
		pack();
		setVisible(true);
		
		//Add Mouse
		mouse = new Mouse();
		canvas.addMouseListener(mouse);
		canvas.addMouseMotionListener(mouse);
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	System.out.println("Close!");
		    	stop();
		    }
		});
		
		//Create Main Instance
		main = new Main(width, height);
		
	}
	
	// Launcher
	public void start() {
		running = true;
		//Sets Game as Primary Window
		requestFocus();
		//Launch Game Loop
		run();
	}
	
	public void stop() {
		running = false;
		System.exit(0);
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
		g.drawString(main.getTurn().getName(), 50, 600);
		
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
		Gui gui = new Gui();
		gui.start();
	}
}