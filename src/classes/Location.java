package classes;

public class Location {
	private int x, y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Location copy() {
		return new Location(x, y);
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
	
	public void setLoc(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setLoc(Location loc) {
		x = loc.getX();
		y = loc.getY();
	}
	
	public boolean equals(Location loc) {
		if( this.x == loc.getX() && this.y == loc.getY())
			return true;
		else
			return false;
	}
	
	public String toString() {
		return "- " + getX() + " | " + getY() + " -";
	}
	
	public int distanceToX(Location loc) {
		return loc.getX() - x;
	}
	
	public int distanceToY(Location loc) {
		return loc.getY() - y;
	}
}
