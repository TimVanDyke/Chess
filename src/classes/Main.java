package classes;

public class Main {
	
	private int width, height;
	private int size = 2;
	private Board board;
	private Screen screen;
	private Player p1, p2;
	public Main(int width, int height) {
		screen = new Screen(width, height);
		screen.
		board = new Board(size, size);
	}
	
	public void update() {
		//board.update();
		
	}
	
	public void render(int[] pixels) {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.getPixels()[i];
		}
	}
}
