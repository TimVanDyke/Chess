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
		int sign = -1;
		return true;
	}

}
