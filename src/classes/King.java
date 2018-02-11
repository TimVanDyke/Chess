package classes;

public class King extends Piece{
	
	public King(int move, Location loc, Board board, Player owner, String path) {
		super(move, loc, board, owner, path);
	}

	public Location[] getRange() {
		Location[] moves = new Location[8];
		Location square = getLoc();
		//Nested For loop cycles through all adjacent and diagonally
		//adjacent squares and adds them to the range
		//while ignoring the square it is currently on
		int iterator = 0;
		for (int x = -1; x < 2; x++) {
			for (int y = -1; y < 2; y++) {
				//Ignore current square
				if (x == 0 && y == 0) continue;
				Location newMove = square.copy();
				newMove.setX(newMove.getX() + x);
				newMove.setY(newMove.getY() + y);
				moves[iterator] = newMove;
				iterator++;
			}
		}
		return moves;
	}
	
}
