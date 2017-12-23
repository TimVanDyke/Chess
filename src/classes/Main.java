package classes;

public class Main {
	
	private int width, height;
	private int size = 8;
	private Board board;
	private Screen screen;
	private Player p1, p2;
	private Player turn;
	private Piece tp, jp;
	public Main(int width, int height) {
		screen = new Screen(width, height);
		board = new Board(size, size);
		
		p1 = new Player("Tim");
		tp = new Piece(1, new Location(0, 1), board, p1, "res/bluePiece.png");
		
		p2 = new Player("Jason");
		jp = new Piece(1, new Location(5, 5), board, p2, "res/redPiece.png");
		
		turn = p1;
	}
	
	public void update() {
		//Listen for mouse click
		//Get piece under mouse
		//Check if the piece can be moved by the current player
		//show possible places to move it
		//Listen for mouse click
		//If legal move, move piece there, else set current piece to null
		
		
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
