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
	//data fields hold Model and View
	private Model model;
	private View view;

    public static void main(String[] args) {
    	launch(args);
    }

    boolean left, right, up, down;
    
    @Override
	public void start(Stage theStage) {
    	System.out.println("start");
        view = new View(theStage);
        model = new Model();
		//model = new Model(view.getWidth(), view.getHeight(), view.getImageWidth(), view.getImageHeight());
        new AnimationTimer() {
            public void handle(long currentNanoTime)
            {
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
                model.update(up, down, left, right);
                view.update(model.getSnakeX(), model.getSnakeY());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        theStage.show();
    }
    
    public static void lose() {
		System.out.println("you lose");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		System.exit(0);
    }

    
}
