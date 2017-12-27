package classes;

public class Main {
	
	private int width, height;
	private int size = 8;
	private Board board;
	private Screen screen;
	private Player p1, p2;
	private Player turn;
	private Location mse;
	private Piece tp, jp;
	private boolean pieceChosen = false;
	public Main(int width, int height) {
		screen = new Screen(width, height);
		board = new Board(size, size);
		
		p1 = new Player("Tim");
		tp = new Piece(1, new Location(0, 1), board, p1, "res/bluePiece.png");
		
		p2 = new Player("Jason");
		jp = new Piece(1, new Location(5, 5), board, p2, "res/redPiece.png");
		
		turn = p1;
		mse = new Location(-1, -1);
		
		
	}
	
	public void update() {
		mse.setLoc(Mouse.getX()/64, Mouse.getY()/64);
		if (!pieceChosen) {
			//Listen for mouse click
			if (Mouse.getB() == 1) {
				 board.highlight(mse);
			}
		} else {
		
		}
	}
	
	public void render(int[] pixels) {
		board.render(screen);
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.getPixels()[i];
		}
	}
	
	public Player getTurn() {
		return turn;
	}
}
