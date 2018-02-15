package classes;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{
	
	public Rook(int move, Location loc, Board board, Player owner, String path) {
		super(move, loc, board, owner, path);
	}
	
	public Location[] getRange() {
		List<Location> moves = new ArrayList<Location>();
		Location square = getLoc();
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
		return isClearPathStraight(move);
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
}
