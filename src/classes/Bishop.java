package classes;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{
	
	public Bishop(int move, Location loc, Board board, Player owner, String path) {
		super(move, loc, board, owner, path);
		
	}
	
	public Location[] getRange() {
		List<Location> moves = new ArrayList<Location>();
		int m = board.getWidth() + board.getHeight() - 2;
		Location[] moveArray = new Location[14];
		Location square = getLoc();
		//Get Forward Diagonal Moves
		for (int x = 0; x < board.getWidth(); x++) {
			Location newMove = square.copy();
			int offset = newMove.getX() - x;
			newMove.setX(x);
			newMove.setY(newMove.getY() - offset);
			if (newMove.equals(square)) continue;
			moves.add(newMove);
		}
		// Get Backward Diagonal Moves
		for (int x = 0; x < board.getWidth(); x++) {
			Location newMove = square.copy();
			int offset = newMove.getX() - x;
			newMove.setX(x);
			newMove.setY(newMove.getY() + offset);
			if (newMove.equals(square)) continue;
			moves.add(newMove);
		}
		//Convert moves array list into an array
		for (int i = 0; i < moves.size(); i++) {
			moveArray[i] = moves.get(i);
		}
		return moveArray;
	}

}
