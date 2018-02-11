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
}