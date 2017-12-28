package classes;

public class Pawn extends Piece {

	public Pawn(int move, Location loc, Board board, Player owner, String path) {
		super(move, loc, board, owner, path);
		
	}
	
	public Location[] getRange() {
		Location[] moves = new Location[4];
		Location square = getLoc();
		//Set First Move - 1 Left
		moves[0] = square.copy();
		moves[0].setX(square.getX() - 1);
		//Set Second Move - 1 Right
		moves[1] = square.copy();
		moves[1].setX(square.getX() + 1);
		//Set Third Move - 1 Up
		moves[2] = square.copy();
		moves[2].setY(square.getY() - 1);
		//Set Fourth Move - 1 Down
		moves[3] = square.copy();
		moves[3].setY(square.getY() + 1);
		return moves;
	}
	

}
