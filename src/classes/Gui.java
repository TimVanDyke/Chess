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
	private JPanel contentPane;
	private Canvas canvas;
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Gui() {
		//Create Window
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		setSize(800, 640);
		setLocationRelativeTo(null);		
		
		//Put Stuff in the Window
		//Master JPanel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		contentPane.add(canvas);
		setVisible(true);
		
	}
	
	public void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		g.setColor(Color.orange);
		g.drawLine(0, 0, width-1, height-1);
		
		g.dispose();
		bs.show();
		
		
	}
	
	public void run() {
		while (true){
			render();
		}
	}
	
	public static void main(String[] args) {
		Gui frame = new Gui();
			
	}

}
