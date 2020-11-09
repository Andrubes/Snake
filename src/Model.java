import java.util.ArrayList;

public class Model{
	private int snakeX = 15;
	private int snakeY = 15;
	private int foodX;
	private int foodY;
	private int length = 3;
	
	//returns snakeX
	public int getSnakeX() {
		if(snakeX < 0) {
			Controller.lose(length);
		}
		if(snakeX > 39) {
			Controller.lose(length);
		}
		return snakeX;
	}
	
	//return snakeY
	public int getSnakeY() {
		if(snakeY < 0) {
			Controller.lose(length);
		}
		if(snakeY > 29) {
			Controller.lose(length);
		}
		return snakeY;
	}
	
	//returns foodX
	public int getFoodX() {
		return foodX;
	}
	
	//returns foodY
	public int getFoodY() {
		return foodY;
	}
	
	//returns length
	public int getLength() {
		return length;
	}
	
	//adds 5 to the length of the snake
	public void incLength() {
		length+=5;
	}
	
	//Moves the snake forward in the direction it is currently facing
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
	
	//generates a set of Coordinates for a food to be spawned at
	public void makeFood(ArrayList<Coords> arr) {
		foodX = (int)(Math.random()*40);
		foodY = (int)(Math.random()*30);
		Coords foodCoords = new Coords(foodX, foodY);
		for(Coords c : arr) {
			if(c.getX() == foodCoords.getX() && c.getY() == foodCoords.getY()) {
				makeFood(arr);
			}
		}
	}

	//Checks if the snake is currently eating a food
	public boolean eatFoodCheck(ArrayList<Coords> arr) {
		if(snakeX == foodX && snakeY == foodY) {
			makeFood(arr);
			incLength();
			return true;
		}
		return false;
	}
	
	//checks for self collisions
	public void selfHitCheck(ArrayList<Coords> arr) {
		Coords curPos = new Coords(snakeX, snakeY);
		int hits = 0;
		for(Coords c : arr) {
			if(c.getX() == curPos.getX() && c.getY() == curPos.getY()) {
				hits++;
			}
			if(hits == 2) {
				Controller.lose(length);
			}
		}
	}
}






