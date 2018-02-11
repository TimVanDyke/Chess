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
}
