package classes;

public class Screen {

	private int width, height;
	private int[] pixels;
	public Screen(int width, int height){
		this.width = width;
		this.width = height;
		pixels = new int[width * height];
		clear();
	}
	
	public void renderBoard(Board board) {
		//Renders the board at pixel location (0, 0)
		Sprite sp = board.getSprite();
		for (int y = 0; y < sp.getHeight(); y++) {
			for (int x = 0; x < sp.getWidth(); x++) {
				pixels[x + y * width] = sp.getPixels()[x + y * sp.getWidth()];
			}
		}
	}
	
	public void renderPiece(Piece piece) {
		//Render pieces to the screen
		//x and y cycle through the piece's sprite pixels
		//xp and yp cycle through the corresponding screen pixel locations
		Sprite sp = piece.getSprite();
		Location loc = piece.getLoc();
		for (int y = 0; y < sp.getHeight(); y++) {
			//Offset to find the correct location on screen
			int yp = y + loc.getY() * 64 + 8;
			for (int x = 0; x < sp.getWidth(); x++) {
				//Offset to find the correct location on screen
				int xp = x + loc.getX() * 64 + 8;
				pixels[xp + yp * width] = sp.getPixels()[x + y * sp.getWidth()];
			}
		}
	}
	
	public void renderSquare(Board board, Location loc, Sprite sprite) {
		//Render squares to the screen
		//x and y cycle through the square's sprite pixels
		//xp and yp cycle through the corresponding screen pixel locations
		int yOffset = loc.getY() * 64;
		int xOffset = loc.getX() * 64;
		for(int y = 0; y < sprite.getHeight(); y++) {
			int yp = y + yOffset;
			for(int x = 0; x < sprite.getWidth(); x++) {
				int xp = x + xOffset;
				pixels[xp + yp * width] = sprite.getPixels()[x + y * sprite.getWidth()];
			}
		}
	}
	
	public void clear() {
		//Sets all pixels to Gray
		for(int i = 0; i < pixels.length; i++) pixels[i] = 0xAAAAAA;
	}
	
	public int[] getPixels() {
		return pixels;
	}
}