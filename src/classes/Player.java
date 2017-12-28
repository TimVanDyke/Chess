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