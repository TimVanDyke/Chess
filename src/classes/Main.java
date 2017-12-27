package classes;

public class Main {
	
	// Window Size Variables from GUI
	private int width, height;
	//Number of Squares per side of Board
	private int size = 8;
	private Board board;
	private Screen screen;
	private Player p1, p2;
	private Player turn;
	private Location mse;
	private Piece tp, jp;
	private boolean pieceChosen = false;
	public Main(int width, int height) {
		//Create Screen with Window width and height
		screen = new Screen(width, height);
		//Create 8x8 Board
		board = new Board(size, size);
		
		//Create Player Tim with his pieces
		p1 = new Player("Tim");
		tp = new Piece(1, new Location(0, 1), board, p1, "res/bluePiece.png");
		
		
		//Create Player Jason with his pieces
		p2 = new Player("Jason");
		jp = new Piece(1, new Location(5, 5), board, p2, "res/redPiece.png");
		
		
		//Place Pieces
		board.placePiece(tp);
		board.placePiece(jp);
		
		
		//Set Turn to first Player
		turn = p1;
		//Initialize Mouse Location
		mse = new Location(-1, -1);
	}
	
	public void update() {
		//Set New Mouse Location
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
		//Render Checkerboard
		board.render(screen);
		
		
		//Render the new pixels from Screen to the GUI pixels
		//This must be last
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.getPixels()[i];
		}
	}
	
	public Player getTurn() {
		return turn;
	}
}
