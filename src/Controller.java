//Andrew Rubesntein
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

public class Controller extends Application {
	private Model model;
	private View view;
	private Snake snake;

    public static void main(String[] args) {
    	launch(args);
    }

    //flags
    boolean left, up, down;
    boolean right = true;
    int i = 0;
    
    @Override
	public void start(Stage theStage) {
        view = new View(theStage);
        model = new Model();
        snake = new Snake(model);
        //runs repeatedly, updates model and view
        new AnimationTimer() {
            public void handle(long currentNanoTime)
            {
            	//accepts input from the keyboard to move the snake
            	View.theScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        switch (event.getCode()) {
                            case UP:    if(!down)
                            	up = true; left = false; right = false; break;
                            case DOWN:  if(!up)
                            		down = true;  left = false; right = false; break;
                            case LEFT:  if(!right)
                            	left  = true; down = false; up = false; break;
                            case RIGHT: if(!left)
                            	right  = true; down = false; up = false; break;
                        }
                    }
            	});
            	//updates x and y positions of the snake and what direction the snake is facing
                model.update(up, down, left, right);
                
                //keeps the snake the proper size
                Coords tail = snake.updatePositions();
                if(tail.getX() != -99) {
                	view.delSnake(tail.getX(), tail.getY());
                }
                
                //check if the snake has just eaten a food
                if(model.eatFoodCheck(snake.getPositions())) {
                	view.drawFood(model.getFoodX(), model.getFoodY());
                }
                
                //spawns a food. only entered on the first iteration of AnimationTimer()
                if(i == 1) {
                	model.makeFood(snake.getPositions());
                	view.drawFood(model.getFoodX(), model.getFoodY());
                }
                i++;
                
                //draws the snake, food, and background in accordance with the new data
                view.update(model.getSnakeX(), model.getSnakeY());
                //check for self collision
                model.selfHitCheck(snake.getPositions());
                
                //the Thread sleeps for 50 milliseconds in between each update. changing this number will change the speed at which the snake moves
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {}
            }
        }.start();
        theStage.show();
    }
    
    //This method prints the current length of the snake and exits the game
    //This method is called when the snake collides with a wall or itself
    public static void lose(int length) {
		System.out.println("Score: " + length);
    	System.out.println("you lose");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		System.exit(0);
    }

    
}
