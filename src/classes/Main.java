package classes;

import java.awt.Color;

public class Main {
	
	// Window Size Variables from GUI
	
	//Number of Squares per side of Board
	private int size = 8;
	private Board board;
	private Screen screen;
	private Player p1, p2;
	private Player turn;
	private Location mse;
	private Piece chosen = null;
	private boolean movesShown = false;
	private Location[] squares;
	private boolean gameOver = false;
	
	public Main(int width, int height) {
		//Create Screen with Window width and height
		screen = new Screen(width, height);
		//Create 8x8 Board
		board = new Board(size, size, p1, p2);
		
		//Create Player Tim with his pieces
		p1 = new Player("Tim");
		//board.placePiece(new King(1, new Location(3, 0), board, p1, "res/bluePiece.png"));
		board.placePiece(new Queen(1, new Location(4, 0), board, p1, "res/bluePiece.png"));
		//board.placePiece(new Bishop(1, new Location(2, 0), board, p1, "res/bluePiece.png"));
		//board.placePiece(new Rook(1, new Location(5, 0), board, p1, "res/bluePiece.png"));
		//board.placePiece(new Knight(1, new Location(6, 0), board, p1, "res/bluePiece.png"));
		//board.placePiece(new Pawn(1, new Location(1, 0), board, p1, "res/bluePiece.png"));
		
		//Create Player Jason with his pieces
		p2 = new Player("Jason");
		//board.placePiece(new King(1, new Location(3, 7), board, p2, "res/redPiece.png"));
		board.placePiece(new Queen(1, new Location(4, 7), board, p2, "res/redPiece.png"));
//		board.placePiece(new Bishop(1, new Location(2, 7), board, p2, "res/redPiece.png"));
//		board.placePiece(new Rook(1, new Location(5, 7), board, p2, "res/redPiece.png"));
//		board.placePiece(new Knight(1, new Location(6, 7), board, p2, "res/redPiece.png"));
//		board.placePiece(new Pawn(1, new Location(1, 7), board, p2, "res/redPiece.png"));
		
		//Set Turn to first Player
		turn = p1;
		//Initialize Mouse Location
		mse = new Location(-1, -1);
	}
	
	public void update() {
		if(Mouse.getB() == 4) System.exit(0);
		if (!gameOver) {
			checkIfGameOver();
			handlePieces();
		}
	}
	
	public void checkIfGameOver() {
		if (!getTurn().hasPieces()) {
			System.out.println("Game Over!");
			switchTurn();
			System.out.println(turn.getName() + " Wins!");
			gameOver = true;
		}
	}
	
	public void handlePieces() {
		//Set New Mouse Location
		mse.setLoc(Mouse.getX()/64, Mouse.getY()/64);
		executeUserActions();
		resetHighlights();
	}
	
	public void executeUserActions() {
		if (chosen == null) {
			selectPiece();
		} else if (!movesShown){
			showMoves();
		} else {
			waitForClick();
		}
	}
	
	public void waitForClick() {
		if (Mouse.getB() == 1) {
			makeMove();
			deselectPiece();
		}
	}
	
	public void makeMove() {
		//Check if any of the available spaces have been clicked
		for (int i = 0; i < squares.length; i++) {
			if(mse.equals(squares[i])) {
				//If an ally piece is there, skip
				if (isAlly(mse, turn)) continue;
				// Move into new space
				moveToSpace();
				//End the Turn
				switchTurn();
			}
		}
	}
	
	public void moveToSpace() {
		//If an enemy piece was captured, take care of it
		Piece capture = board.getPieceAt(mse);
		if (capture != null) board.capture(capture);
		//Move piece
		chosen.setLoc(mse.getX(), mse.getY());
		//Reset Highlighting
		movesShown = false;
		chosen = null;
	}
	
	public void resetHighlights() {
		if (chosen == null) {
			board.highlights.clear();
			board.mouse.setLoc(-1, -1);
		}
	}
	
	public void selectPiece() {
		//Listen for mouse click
		if (Mouse.getB() == 1) {
			//Check for a piece at that position
			chosen = board.getPieceAt(mse);
			//If there is a piece and it belongs to the player whose turn it is
			if(chosen != null && chosen.getOwner() == turn) {
				//Highlight the piece in Gold coloring
				board.highlight(mse, "Select");
			} else {
				//If the piece is an opponents piece, don't highlight
				chosen = null;
			}
		}
	}
	
	public void deselectPiece() {
		//If the player clicks away from the spaces,
		//Allow the player to choose a different piece
		if (chosen != null && !mse.equals(chosen.getLoc())) {
			movesShown = false;
			chosen = null;
		}
	}
	
	public void showMoves() {
		//Get range of selected piece
		squares = chosen.getRange();
		//Highlight all available spaces in Blue coloring
		for(int i = 0; i < squares.length; i++) {
			if (chosen.legalMove(squares[i])) {
				board.highlight(squares[i], "Move");
			}
		}
		//Move on to next part
		movesShown = true;
	}
	
	public boolean isAlly(Location square, Player player) {
		boolean pieceExists = board.getPieceAt(square) != null;
		if (!pieceExists) return false;
		boolean pieceIsAlly = board.getPieceAt(square).getOwner() == player;
		return pieceExists && pieceIsAlly;
	}
	
	public void render(int[] pixels) {
		//Render Checkerboard
		board.render(screen);
		if (gameOver) displayEndScreen();
		//Render the new pixels from Screen to the GUI pixels
		//This must be last
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.getPixels()[i];
		}
		
	}
	
	public Player getTurn() {
		return turn;
	}
	
	public void switchTurn() {
		if(turn == p1) turn = p2; else turn = p1;
	}
	
	public void displayEndScreen() {
		System.out.println("" + screen.getWidth()/2 + " | " + screen.getHeight()/2);
		screen.renderSpriteCentered(Sprite.gameOver, screen.getWidth()/2, screen.getHeight()/2);
	}
	//Accessed by Gui by JColorChooser
	public void setPlayerOneColor(int hexInt) {
		p1.setColor(hexInt);
	}
	
	public void setPlayerTwoColor(int hexInt) {
		p2.setColor(hexInt);
	}
}