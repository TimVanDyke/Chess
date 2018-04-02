package classes;

public class Player {
	
	private int color;
	private int maxPieces = 16;
	private String name;
	private Piece[] pieces;
	
	public Player(String name) {
		//List of pieces owned by the player
		pieces = new Piece[maxPieces];
		this.name  = name;
	}
	
	//Alternate Constructor
	public Player(int color) {
		
		pieces = new Piece[maxPieces];
		name = "PlayerZero";
	}
	
	public Piece[] getPieces() {
		return pieces;
	}
	
	public void addPiece(Piece piece) {
		for (int i = 0; i < pieces.length; i++) {
			if (pieces[i] == null) {
				pieces[i] = piece;
			}
		}
		System.out.println("There is a maximum of 16 pieces per player.");
	}
	
	public boolean hasPieces() {
		//Check if the player has any pieces still on the board
		for (int i = 0; i < pieces.length; i++) {
			if (pieces[i] != null) {
				if (pieces[i].isAlive()) return true;
			}
		}
		return false;
	}
	
	public void setColor(int color) {
		//Set color to either 0x0 (Black) or 0xFFFFFF (White)
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}