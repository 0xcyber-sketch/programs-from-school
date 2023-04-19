package opgave5;

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
    	
 
    	double startY = 60;
        double startX = 60;
        double radius = 50;
        double strokeWidth = 5;
        
        
        Circle blue = new Circle(startX, startY, radius);
        pane.getChildren().add(blue);
        blue.setFill(null);
        blue.setStroke(Color.BLUE);
        blue.setStrokeWidth(strokeWidth);
        
        Circle black = new Circle(startX + radius *2, startY , radius);
        pane.getChildren().add(black);
        black.setFill(null);
        black.setStroke(Color.BLACK);
        black.setStrokeWidth(strokeWidth);
        
        Circle red = new Circle(startX + radius *4, startY , radius);
        pane.getChildren().add(red);
        red.setFill(null);
        red.setStroke(Color.RED);
        red.setStrokeWidth(strokeWidth);
        
        Circle yellow = new Circle(startX + radius, startY + radius, radius);
        pane.getChildren().add(yellow);
        yellow.setFill(null);
        yellow.setStroke(Color.YELLOW);
        yellow.setStrokeWidth(strokeWidth);
        
        Circle green = new Circle(startX + radius *3, startY + radius, radius);
        pane.getChildren().add(green);
        green.setFill(null);
        green.setStroke(Color.GREEN);
        green.setStrokeWidth(strokeWidth);
        
        

       
        
        
        
        
        
        
        
    	
    	
    	
        
        
        
    }
}
