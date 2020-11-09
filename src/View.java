import java.awt.Button;
import java.awt.Insets;
import java.util.Collection;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class View{
	public static Scene theScene;
	GridPane root = new GridPane();
	private int xSize = 40;
	private int ySize = 30;
	Color bgColor = Color.BLACK;
	
	public View(Stage theStage) {
		makeBoard();  
    	theScene = new Scene(root);
        theStage.setScene(theScene);
        theStage.show();
	}
	
	//Draws the board and colors it black
	public void makeBoard() {
        for (int row = 0; row < ySize; row++) {
            for (int col = 0; col < xSize; col++) {
                makeRec(bgColor, col, row);
            }
        }
	}
	
	//updates according to the snakes position
	public void update(int x, int y) {
		makeRec(Color.PALEGREEN, x, y);
	}
	
	//makes the square at the end of the snakes tail black
	public void delSnake(int x, int y) {
        makeRec(bgColor, x, y);
	}
	
	//places the food on the board
	public void drawFood(int x, int y) {
		makeRec(Color.RED, x, y);
	}
	
	//draws a rectangle the size of one cell of the grid. used for multiple purposes
	public void makeRec(Color c, int x, int y) {
		Rectangle rec = new Rectangle();
        rec.setWidth(20);
        rec.setHeight(20);
        rec.setFill(c);
        GridPane.setRowIndex(rec, y);
        GridPane.setColumnIndex(rec, x);
        root.getChildren().add(rec);
	}
	
}













