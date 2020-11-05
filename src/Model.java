import java.util.ArrayList;

public class Model{
	
	private int snakeSize = 1;
	private int snakeX = 15;
	private int snakeY = 15;
	private int foodX;
	private int foodY;
	private int length = 3;
	
	
	public int getSnakeX() {
		if(snakeX < 0) {
			Controller.lose();
		}
		if(snakeX > 40) {
			Controller.lose();
		}
		return snakeX;
	}
	
	public int getSnakeY() {
		if(snakeY < 0) {
			Controller.lose();
		}
		if(snakeY > 30) {
			Controller.lose();
		}
		return snakeY;
	}
	
	public void update(boolean up, boolean down, boolean left, boolean right) {
		if(up) {
			snakeY--;
		}
		else if(down) {
			snakeY++;
		}
		else if(left) {
			snakeX--;
		}
		else if(right) {
			snakeX++;
		}

	}
	
	public void makeFood(ArrayList<Coords> arr) {
		foodX = (int)(Math.random()*41);
		foodY = (int)(Math.random()*31);
		Coords foodCoords = new Coords(foodX, foodY);
		for(Coords c : arr) {
			if(c.getX() == foodCoords.getX() && c.getY() == foodCoords.getY()) {
				System.out.println("oops, making new food");
				makeFood(arr);
			}
		}
		System.out.println("food is at: (" + foodX + ", " + foodY + ")");
	}
	
	public int getFoodX() {
		return foodX;
	}
	
	public int getFoodY() {
		return foodY;
	}
	
	public boolean eatFoodCheck(ArrayList<Coords> arr) {
		if(snakeX == foodX && snakeY == foodY) {
			makeFood(arr);
			incLength();
			return true;
		}
		return false;
	}
	
	public void selfHitCheck(ArrayList<Coords> arr) {
		Coords curPos = new Coords(snakeX, snakeY);
		int hits = 0;
		for(Coords c : arr) {
			if(c.getX() == curPos.getX() && c.getY() == curPos.getY()) {
				hits++;
			}
			if(hits == 2) {
				System.out.println("self collision");
				Controller.lose();
			}
		}
	}
	
	public int getLength() {
		return length;
	}
	
	public void incLength() {
		length+=4;
	}
}






