package classes;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Launcher extends JFrame {
	
	private int width = 150;
	private int height = 400;
	private int buttonWidth = 100;
	private int buttonHeight = 67;
	private String title = "Chess!";
	private JButton play, options, quit;
	private JPanel panel;
	public Launcher() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(null);
		setVisible(true);
		//Create Panel
		panel = new JPanel();
		add(panel);
		
		//Add Buttons
		play = new JButton("Play");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
								Gui gui = new Gui();
								gui.start();
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		play.setSize(buttonWidth, buttonHeight);
		add(play);
	}
	
//	public static void main(String[] args) {
//		new Launcher();
//	}
}
