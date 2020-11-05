public class Coords{
	
	private int x;
	private int y;
	
	public Coords(int xPos, int yPos) {
		x = xPos;
		y = yPos;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}