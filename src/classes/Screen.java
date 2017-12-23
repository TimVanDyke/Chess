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
		for (int y = 0; y < board.getHeight(); y++) {
			for (int x = 0; x < board.getWidth(); x++) {
				pixels[x + y * width] = board.getPixels[i];
			}
		}
	}
	
	public void renderPiece(Piece piece) {
		int xp = piece.getX();
		int yp = piece.getY();
		for (int y = yp; y < piece.getHeight(); y++) {
			for (int x = xp; x < piece.getWidth(); x++) {
				pixels[x + y * width] = piece.getColor();
			}
		}
	}
	
	public void clear() {
		for(int i = 0; i < pixels.length; i++) pixels[i] = 0;
	}
	
	public int[] getPixels() {
		return pixels;
	}
}
