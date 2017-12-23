package classes;

public class Board {
	private int board[][]; //the board
	private int height;
	private int width;
	
	
	/*
	 * the constructor
	 * @param width is the width of the board
	 * @param height is the height of the board
	 */
	public Board(int width, int height) {
		this.height = height - 1; 
		this.width = width - 1;
		board = new int[width][height];
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
	
	public void renderBoard() {
		
	}
	
} 
