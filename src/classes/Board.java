package classes;

public class Board {
	private int board[][]; //the board
	private int height;
	private int width;
	private Sprite sprite;
	public Piece piece;
	
	/*
	 * the constructor
	 * @param width is the width of the board
	 * @param height is the height of the board
	 */
	public Board(int width, int height) {
		this.height = height - 1; 
		this.width = width - 1;
		board = new int[width][height];
		sprite = new Sprite("res/checkerboard.png");
		piece = new Piece(1, new Location(0, 1), width, height, 48, new Player(0), "res/bluePiece.png");
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public boolean isFull(int x, int y) {
		boolean isFull;
		if (board[x][y] != 0) {
			isFull = true;
		} else {
			isFull = false;
		}
		return isFull;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void render(Screen screen) {
		screen.renderBoard(this);
		piece.render(screen);
	}
	
} 
