package classes;

public class Piece {
	//Class variables
	private int x, y; //the x y coordinates of a piece
	private int move; //movement range
	
	/*
	 * the constructor
	 */
	public Piece() {	
		move = 1;
	}
	
	/*
	 * A method to get a pieces current location
	 */
	public int[] getLoc() {
		int[] loc = new int[2];
		loc[0] = x;
		loc[1] = y;
		return loc;
	}
	
	/*
	 * A method to change a pieces location
	 */
	public void setLoc(int[] loc) {
		x = loc[0];
		y = loc[1];
	}
	
	/*
	 * A method to get the available moves for a piece
	 */
	public int[] getRange() {
		
		
		return range;
	}
	
	/*
	 * Changes the pieces current location to a new location
	 * @param x is the new x location
	 * @param y is the new y locaiton
	 */
	public void move(int x, int y) {
		int[] legalMoves = getRange();
		if 
	}
}