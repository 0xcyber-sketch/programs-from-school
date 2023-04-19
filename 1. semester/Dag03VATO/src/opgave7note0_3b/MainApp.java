package opgave7note0_3b;

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
        this.bike(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    
    private void bike(Pane pane)
    {
    	Color black = Color.BLACK;
    	
    	//Front wheel closet to the house
    	double wheelRadius = 15;
    	Circle wheelOne = new Circle (300,270 - wheelRadius,wheelRadius);
    	wheelOne.setFill(null);
    	wheelOne.setStroke(black);
    	
    	//Back wheel
    	Circle wheelTwo = new Circle (340,270 - wheelRadius,wheelRadius);
    	wheelTwo.setFill(null);
    	wheelTwo.setStroke(black);
    	
    	//Bike frame                
    	Polygon frame = new Polygon(300,270 - wheelRadius, 340,270- wheelRadius, 345,270 - (wheelRadius+25),280,270 - (wheelRadius+40));
    	frame.setStroke(black);
    	frame.setFill(null);
    	Line l1 = new Line(320,225,320,190);
    	l1.setStroke(black);
    	Line l2 = new Line(302,195,330,185);
    	l2.setStroke(black);
    	
    	//Handle A lot of trail and error
    	Arc handle =  new Arc(225,267 - (wheelRadius+25),60,30,20,30); //Trail and Error
    	handle.setStroke(black);
    	Circle c0 = new Circle(262,203,3);
    	c0.setFill(black);
    	
    	
    	
    		

    	
    	
    	
    	pane.getChildren().addAll(wheelOne,wheelTwo,frame,handle,c0,l1,l2);
    	
    }
    
    
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
