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
		Sprite sp = board.getSprite();
		for (int y = 0; y < sp.getHeight(); y++) {
			for (int x = 0; x < sp.getWidth(); x++) {
				pixels[x + y * width] = sp.getPixels()[x + y * sp.getWidth()];
			}
		}
	}
	
	public void renderPiece(Piece piece) {
		
		Sprite sp = piece.getSprite();
		Location loc = piece.getLoc();
		int yOffset = sp.getHeight()/2;
		int xOffset = sp.getHeight()/2;
		for (int y = 0; y < sp.getHeight(); y++) {
			int yp = y + loc.getY() * 64 + 8;
			for (int x = 0; x < sp.getWidth(); x++) {
				int xp = x + loc.getX() * 64 + 8;
				pixels[xp + yp * width] = sp.getPixels()[x + y * sp.getWidth()];
			}
		}
	}
	
	public void renderSquare(Board board, Location loc, Sprite sprite) {
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
		for(int i = 0; i < pixels.length; i++) pixels[i] = 0xAAAAAA;
	}
	
	public int[] getPixels() {
		return pixels;
	}
}
