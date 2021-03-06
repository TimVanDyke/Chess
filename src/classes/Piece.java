package classes;

import java.awt.Color;
import java.util.List;

public class Piece {
	//Class variables
	protected Location currentLoc; //the x y coordinates of a piece
	private int move; //all the ints
	protected int bWidth;
	protected int bHeight;
	private int size;
	private int color;
	private Player owner;
	private Boolean alive;
	private Sprite sprite;
	protected Board board;
	/*
	 * the constructor
	 */
	public Piece(int move, Location loc, Board board, Player owner, String path) {	
		this.move = move;
		currentLoc = loc;
		this.board = board;
		bWidth = board.getWidth();
		bHeight = board.getHeight();
		this.owner = owner;
		owner.addPiece(this);
		color = owner.getColor();
		alive = true;
		sprite = new Sprite(path);
		size = 48;
	}
	
	public Piece(int move, Location loc, Board board, Player owner, int color) {	
		this.move = move;
		currentLoc = loc;
		this.board = board;
		bWidth = board.getWidth();
		bHeight = board.getHeight();
		this.owner = owner;
		owner.addPiece(this);
		color = owner.getColor();
		alive = true;
		sprite = new Sprite(color);
		size = 48;
	}
	
	/*
	 * A method to get a pieces current location
	 */
	public Location getLoc() {
		return currentLoc;
	}
	
	/*
	 * A method to change a pieces location
	 */
	public void setLoc(int x, int y) {
		currentLoc.setX(x);
		currentLoc.setY(y);
	}
	
	/*
	 * A method to get the available moves for a piece
	 */
	public Location[] getRange() {
		Location dummy = currentLoc;
		Location[] tempLoc = new Location[4];
		dummy.setX(-move);
		tempLoc[0] = dummy;
		dummy.setX(+move);
		dummy.setY(-move);
		tempLoc[0] = dummy;
		dummy.setY(+move);
		dummy.setX(+move);
		tempLoc[0] = dummy;
		dummy.setX(-move);
		dummy.setY(+move);
		tempLoc[0] = dummy;
		dummy.setY(-move);
		return tempLoc;
	}
	
	/*
	 * Changes the pieces current location to a new location
	 * @param newLoc is the new location
	 */
	public boolean legalMove(Location newLoc) {
		boolean legal = false;
		Location[] legalMoves = getRange();
		for (int i = 0; i < legalMoves.length; i++) {
			Piece pieceAtMove = board.getPieceAt(legalMoves[i]);
			if (pieceAtMove != null && pieceAtMove.getOwner() == this.getOwner()) continue;
			if (legalMoves[i].getX() == newLoc.getX() && legalMoves[i].getY() == newLoc.getY() && newLoc.getX() >= 0 && newLoc.getY() >= 0 && newLoc.getX() < bWidth && newLoc.getY() < bHeight) {
				if (isClearPath(legalMoves[i])) { 
					legal = true;
				}
			}
		}
		return legal;
	}
	
	public boolean isClearPath(Location move) {
		// Impletement this method in subclasses - Template Pattern
		return true;
	}
	/*
	 * Changes the pieces current location to a new location
	 * @param x is the new x location
	 * @param y is the new y location
	 */
	public boolean legalMove(int x, int y) {
		Location[] legalMoves = getRange();
		for (int i = 0; i < 4; i++) {
			if (legalMoves[i].getX() == x && legalMoves[i].getY() == y && x >= 0 && y >= 0 && x < bWidth && y < bHeight) {
				return true;
			}
		}
		return false;
	}
	
	public Location[] locationListToArray(List<Location> moves) {
		Location[] moveArray = new Location[moves.size()];
		//Convert moves array list into an array
		for (int i = 0; i < moves.size(); i++) {
			moveArray[i] = moves.get(i);
		}
		return moveArray;
	}
	
	/*
	 * changes the pieces location
	 * @param newLoc the new location
	 */
	public void move(Location newLoc) {
		if (legalMove(newLoc)) {
			board.setEmpty(currentLoc);
			board.setFull(newLoc);
			currentLoc.setLoc(newLoc);
		}
		else
			System.out.print("You have seriously messed up your error catching on this one Tim");
	}
	
	/*
	 * changes the pieces location
	 * @param x the new x
	 * @param y the new y
	 */
	public void move(int x, int y) {
		if (legalMove(x, y)) {
			board.setEmpty(currentLoc.getX(), currentLoc.getY());
			board.setFull(x, y);
			currentLoc.setX(x);
			currentLoc.setY(y);
		} else
			System.out.print("You have seriously messed up your error catching on this one Tim");
	}
	
	/*
	 * tells the piece to kill itself when it dies. This is to be called by the board
	 */
	public void kill() {
		System.out.println("" + owner.getName() + "'s " + this.getClass().getSimpleName() +" was captured!");
		alive = false;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public int getSize() {
		return size;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setColor(int color) {
		this.color = color;
		this.sprite = new Sprite(color);
	}
	
	public void render(Screen screen) {
		screen.renderPiece(this);
	}
}