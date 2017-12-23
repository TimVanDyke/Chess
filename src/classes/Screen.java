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
		int xOffset = sp.getWidth()/2;
		for (int y = loc.getY() - yOffset; y < sp.getHeight(); y++) {
			for (int x = loc.getX() - xOffset; x < sp.getWidth(); x++) {
				pixels[x + y * width] = sp.getPixels()[x + y * sp.getWidth()];
			}
		}
	}
	
	public void clear() {
		for(int i = 0; i < pixels.length; i++) pixels[i] = 0x5500FF;
	}
	
	public int[] getPixels() {
		return pixels;
	}
}
