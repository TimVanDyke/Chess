package classes;

public class Location {
	private int x, y;
	private Location myLoc = new Location (x, y);
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Location getLoc() {
		Location rLoc = new Location (x, y);
		return rLoc;
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
