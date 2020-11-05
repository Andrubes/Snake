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
	
	public void makeBoard() {
		//makes the squares and colors them in to the bacground color
        for (int row = 0; row < ySize; row++) {
            for (int col = 0; col < xSize; col++) {
                Rectangle rec = new Rectangle();
                rec.setWidth(20);
                rec.setHeight(20);
                rec.setFill(bgColor);
                GridPane.setRowIndex(rec, row);
                GridPane.setColumnIndex(rec, col);
                root.getChildren().addAll(rec);
            }
        }
        root.setGridLinesVisible(true);
        
	}
	
	public void update(int x, int y) {
		Rectangle rec = new Rectangle();
        rec.setWidth(20);
        rec.setHeight(20);
        rec.setFill(Color.PALEGREEN);
        GridPane.setRowIndex(rec, y);
        GridPane.setColumnIndex(rec, x);
        root.getChildren().add(rec);
        root.setGridLinesVisible(true);
	}
	
}













