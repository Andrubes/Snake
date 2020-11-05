public class Model{
	
	private int snakeSize = 1;
	private int snakeX = 15;
	private int snakeY = 15;
	
	
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
}