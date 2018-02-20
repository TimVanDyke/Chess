package classes;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{
	
	public Queen(int move, Location loc, Board board, Player owner, String path) {
		super(move, loc, board, owner, path);
		
	}
	
	public Location[] getRange() {
		//This can be made more efficient
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
		//Get Horizontal Moves
		for (int i = 0; i < board.getWidth(); i++) {
			//Ignore current square
			if(i == square.getX()) continue;
			Location move = square.copy();
			move.setX(i);
			moves.add(move);
		}
		//Get Vertical Moves
		for (int i = 0; i < board.getHeight(); i++) {
			//Ignore current square
			if(i == square.getY()) continue;
			Location move = square.copy();
			move.setY(i);
			moves.add(move);
		}
		return locationListToArray(moves);
	}
	
	public boolean isClearPath(Location move) {
		if (move.getX() == currentLoc.getX() || move.getY() == currentLoc.getY()) {
			return isClearPathStraight(move);
		} else {
			 return isClearPathDiagonally(move); 
		}
	}
	
	public boolean isClearPathStraight(Location move) {
		int xdist = currentLoc.distanceToX(move);
		int ydist = currentLoc.distanceToY(move);
		int sign = -1;
		if (ydist == 0) {
			if (xdist < 0) sign = 1;
			for (int x = xdist + sign; x != 0; x += sign) {
				Location next = move.copy();
				next.setX(currentLoc.getX() + x);
				if (board.getPieceAt(next) != null) return false;
			}
			return true;
		} else if(xdist == 0) {
			if (ydist < 0) sign = 1;
			for (int y = ydist + sign; y != 0; y += sign) {
				Location next = move.copy();
				next.setY(currentLoc.getY() + y);
				if (board.getPieceAt(next) != null) return false;
			}
			return true;
		}
		return false;
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