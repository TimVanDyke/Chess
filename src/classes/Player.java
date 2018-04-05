package classes;

import java.awt.Color;

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
		this.color = color;
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
	
	public int getColor() {
		return color;
	}
	
	public void setColor(int color) {
		this.color = color;
		updatePieces();
	}
	
	public void updatePieces() {
		for (int i = 0; i < pieces.length; i++) {
			pieces[i].setColor(color);
		}
	}	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}