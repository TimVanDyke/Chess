package classes;

import java.util.List;
import java.util.ArrayList;

public class Board {
	private int board[][]; //the board
	private int height;
	private int width;
	private Sprite sprite;
	List<Piece> pieces = new ArrayList<Piece>();
	List<Location> highlights = new ArrayList<Location>();
	
	/*
	 * the constructor
	 * @param width is the width of the board
	 * @param height is the height of the board
	 */
	public Board(int width, int height) {
		this.height = height - 1; 
		this.width = width - 1;
		board = new int[width][height];
		sprite = Sprite.checkerboard;
		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y ++) {
				board[x][y] = 0;
			}
		}
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void highlight(Location square) {
		System.out.println(square.getX() + "  " + square.getY() +  "  " + getWidth() + "   " + getHeight());
		if(square.getX() < getWidth() && square.getY() < getHeight() ) {
			highlights.add(square);
		}
	}
	
	public void placePiece(Piece piece) {
		int x = piece.getLoc().getX();
		int y = piece.getLoc().getX();
		//Check if the board location is full or not
		if (board[x][y]== 0) {
			pieces.add(piece);
		}
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
	
	public boolean isFull(Location loc) {
		boolean isFull;
		int x = loc.getX();
		int y = loc.getY();
		if (board[x][y] != 0) {
			isFull = true;
		} else {
			isFull = false;
		}
		return isFull;
	}
	
	public void setFull(Location loc) {
		int x = loc.getX(), y = loc.getY();
		board[x][y] = 1;
	}
	
	public void setFull(int x, int y) {
		board[x][y] = 1;
	}
	
	public void setEmpty(Location loc) {
		int x = loc.getX(), y = loc.getY();
		board[x][y] = 0;
	}
	
	public void setEmpty(int x, int y) {
		board[x][y] = 0;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void render(Screen screen) {
		//Render Board
		screen.renderBoard(this);
		//Render every Highlighted Square
		for(int i = 0; i < highlights.size(); i++) screen.renderSquare(this, highlights.get(i), Sprite.highlight);
		//Render every Piece
		for(int i = 0; i < pieces.size(); i++) screen.renderPiece(pieces.get(i));
	}
	
} 
