package classes;

public class Location {
	private int x, y;
	
	public Location() {
		x = -1;
		y = -1;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int newX) {
		this.x = newX;
	}
	
	public void setY(int newY) {
		this.y = newY;
	}
	public void setLoc(Location loc) {
		x = loc.getX();
		y = loc.getY();
	}
}
