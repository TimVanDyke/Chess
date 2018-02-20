package classes;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{
	
	public Bishop(int move, Location loc, Board board, Player owner, String path) {
		super(move, loc, board, owner, path);
		
	}
	
	public Location[] getRange() {
		List<Location> moves = new ArrayList<Location>();
		Location square = getLoc();
		//Get Forward Diagonal Moves - \
		for (int x = 0; x < board.getWidth(); x++) {
			Location newMove = square.copy();
			int offset = newMove.getX() - x;
			newMove.setX(x);
			newMove.setY(newMove.getY() - offset);
			//Ignore current square
			if (newMove.equals(square)) continue;
			moves.add(newMove);
		}
		// Get Backward Diagonal Moves - /
		for (int x = 0; x < board.getWidth(); x++) {
			Location newMove = square.copy();
			int offset = newMove.getX() - x;
			newMove.setX(x);
			newMove.setY(newMove.getY() + offset);
			//Ignore current square
			if (newMove.equals(square)) continue;
			moves.add(newMove);
		}
		return locationListToArray(moves);
	}
	
	public boolean isClearPath(Location move) {
		return isClearPathDiagonally(move);
	}
	
	public boolean isClearPathDiagonally(Location move) {
		//I'm stuck, look at the rook's code for reference
		int xdist = currentLoc.distanceToX(move);
		int ydist = currentLoc.distanceToY(move);
		int signx = 1, signy = 1;
		if (xdist < 0) signx = -1;
		if (ydist < 0) signy = -1;
		System.out.println(currentLoc + " ==" + move);
		Location start = move.copy();
		start.setX(start.getX() - signx);
		start.setY(start.getY() - signy);
		for (Location next = start; !next.equals(currentLoc); next.setX(next.getX() - signx), next.setY(next.getY() - signy)) {
			System.out.println("Checking Location " + next.toString());
			Piece piece = board.getPieceAt(next);
			if (piece != null) {
				return false;
			}
		}
		return true;
	}

}
