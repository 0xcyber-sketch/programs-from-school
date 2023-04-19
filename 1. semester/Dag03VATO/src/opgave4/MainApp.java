package opgave4;

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
    	
 
    	double startY = 400/2;
        double startX = 400/2;
        double width = 5;
        Color black = Color.BLACK;
        
        Circle biggest = new Circle(startX, startY, 30);
        pane.getChildren().add(biggest);
        biggest.setFill(null);
        biggest.setStroke(black);
        biggest.setStrokeWidth(width);
        
        Circle medium = new Circle(startX, startY, 20);
        pane.getChildren().add(medium);
        medium.setFill(null);
        medium.setStroke(black);
        medium.setStrokeWidth(width);
        
        Circle small = new Circle(startX, startY, 10);
        pane.getChildren().add(small);
        small.setFill(null);
        small.setStroke(black);
        small.setStrokeWidth(width);
        
        Circle smallest = new Circle(startX, startY, 0);
        pane.getChildren().add(smallest);
        smallest.setFill(black);
        smallest.setStroke(black);
        smallest.setStrokeWidth(width);
   
        
        
        
        
        
    	
    	
    	
        
        
        
    }
}
