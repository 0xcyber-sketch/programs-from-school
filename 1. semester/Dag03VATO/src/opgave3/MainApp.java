package opgave3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.*;
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
    	
 
    	
    	double headY = 400/2;
        double headX = 400/2;
        double headRadius = 75;
        double eyeRadius = 10;
        double ex = 30;
        double ey = 20;

    	
    	Circle head = new Circle(headX,headY, headRadius);
    	pane.getChildren().add(head);
    	head.setStroke(Color.BLACK);
    	head.setFill(null);
    	head.setStrokeWidth(5);
    	
    	
    	Circle e1 = new Circle(headX + ex,headY - ey, eyeRadius);
    	pane.getChildren().add(e1);
    	e1.setFill(Color.BLACK);
    	
    	
    	Circle e2 = new Circle(headX - ex,headY - ey, eyeRadius);
    	pane.getChildren().add(e2);
    	e2.setFill(Color.BLACK);
    	
    	Line mouth = new Line (160,230,235,230);
    	pane.getChildren().add(mouth);
    	mouth.setFill(Color.BLACK);
    	
    	

    	
    	
    	
        
        
        
    }
}
