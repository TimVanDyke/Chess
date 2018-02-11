package classes;

public class Knight extends Piece{
	
	public Knight(int move, Location loc, Board board, Player owner, String path) {
		super(move, loc, board, owner, path);
	}
	
	public Location[] getRange() {
		Location[] moves = new Location[8];
		Location square = getLoc();
		//Set First Move - 1 Left, 2 Up
		moves[0] = square.copy();
		moves[0].setX(square.getX() - 1);
		moves[0].setY(square.getY() - 2);
		//Set Second Move - 1 Right, 2 Up
		moves[1] = square.copy();
		moves[1].setX(square.getX() + 1);
		moves[1].setY(square.getY() - 2);
		//Set Third Move - 1 Up, Two Right
		moves[2] = square.copy();
		moves[2].setY(square.getY() - 1);
		moves[2].setX(square.getX() + 2);
		//Set Fourth Move - 1 Down, Two Right
		moves[3] = square.copy();
		moves[3].setY(square.getY() + 1);
		moves[3].setX(square.getX() + 2);
		//Set First Move - 1 Left, 2 Down
		moves[4] = square.copy();
		moves[4].setX(square.getX() - 1);
		moves[4].setY(square.getY() + 2);
		//Set Second Move - 1 Right, 2 Down
		moves[5] = square.copy();
		moves[5].setX(square.getX() + 1);
		moves[5].setY(square.getY() + 2);
		//Set Third Move - 1 Up, Two Left
		moves[6] = square.copy();
		moves[6].setY(square.getY() - 1);
		moves[6].setX(square.getX() - 2);
		//Set Fourth Move - 1 Down, Two Left
		moves[7] = square.copy();
		moves[7].setY(square.getY() + 1);
		moves[7].setX(square.getX() - 2);
		return moves;
	}
	
	public boolean legalMove(Location newLoc) {
		Location[] legalMoves = getRange();
		for (int i = 0; i < legalMoves.length; i++) {
			Piece pieceAtMove = board.getPieceAt(legalMoves[i]);
			if (pieceAtMove != null && pieceAtMove.getOwner() == this.getOwner()) continue;
			if (legalMoves[i].getX() == newLoc.getX() && legalMoves[i].getY() == newLoc.getY() && newLoc.getX() >= 0 && newLoc.getY() >= 0 && newLoc.getX() < bWidth && newLoc.getY() < bHeight) {
				return true;
			}
		}
		return false;
	}

}
