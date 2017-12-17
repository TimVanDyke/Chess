package classes;

public class Piece {
	//Class variables
	private Location currentLoc; //the x y coordinates of a piece
	private int move; //movement range
	
	/*
	 * the constructor
	 */
	public Piece() {	
		move = 1;
		currentLoc = new Location();
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
		Location[] legalMoves = getRange();
		for (int i = 0; i < 4; i++) {
			if (legalMoves[i].getX() == newLoc.getX() && legalMoves[i].getY() == newLoc.getY()) {
				return true;
			}
		}
		return false;
	}
	/*
	 * Changes the pieces current location to a new location
	 * @param x is the new x location
	 * @param y is the new y location
	 */
	public boolean legalMove(int x, int y) {
		Location[] legalMoves = getRange();
		for (int i = 0; i < 4; i++) {
			if (legalMoves[i].getX() == x && legalMoves[i].getY() == y) {
				return true;
			}
		}
		return false;
	}
	/*
	 * changes the pieces location
	 * @param newLoc the new location
	 */
	public void move(Location newLoc) {
		if (legalMove(newLoc))
			currentLoc.setLoc(newLoc);
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
			currentLoc.setX(x);
			currentLoc.setX(x);
		} else
			System.out.print("You have seriously messed up your error catching on this one Tim");
	}
}