package classes;

public class Player {
	
	private int color;
	private int maxPieces = 16;
	private boolean turn;
	private Piece[] pieces;
	public Player(int color) {
		turn = false;
		color = 0;
		pieces = new Piece[maxPieces];
	}
	
	public Piece[] getPieces() {
		return pieces;
	}
	
	public void endTurn() {
		turn = false;
	}
	
	public void startTurn() {
		turn = true;
	}
}
