package opgave7note0_3a;

import javafx.scene.shape.*;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainApp extends Application
{
   
    @Override
    public void start(Stage stage)
    {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent()
    {
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane)
    {
    	Color black = Color.BLACK;
    	Color green = Color.GREEN;
    	Color red = Color.RED;
    	Color yellow = Color.YELLOW;
    	
    	//Roof 
    	Polygon roof = new Polygon(5,150,85,75,165,150);
    	roof.setFill(green);
    	
    	
    	
    	//House
    	
    	Rectangle house = new Rectangle(25,150,120,120);
    	house.setFill(red);
    	// Window 
    	
    	
    	Rectangle window = new Rectangle(40,180,25,30);
    	window.setFill(black);
    	
    	//Sun
    	
    	Circle sun = new Circle(250, 70, 50);
    	sun.setFill(yellow);
    	
    	// Walk
    	Line walk = new Line(0,270,400,270);
    	walk.setFill(black);
    	
    	pane.getChildren().addAll(roof, house, walk, window, sun);
        
        
    }
}
