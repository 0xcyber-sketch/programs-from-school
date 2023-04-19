package exercise1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application
{
    

    @Override
    public void start(Stage stage)
    {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent()
    {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(GraphicsContext gc)
    {
        // Replace the statement here with your code.
    	int x;
    	int y;
    	int length = 2;
    	
    	
    	
        
        //a
    	x = 100;
    	y = 75;
    	
    	gc.strokeLine(x, y, x+10*length, y-4);
    	gc.strokeLine(x, y, x+10*length, y+4);
    	
        x = 100;
    	y = 125;
    	
    	gc.strokeLine(x, y, x+10*length, y-4);
        gc.strokeLine(x, y, x+10*length, y+4);
        
        //b
        x = 20;
    	y = 50;
    	
    	gc.strokeLine(x, y, x+10*length, y-4);
        gc.strokeLine(x, y, x+10*length, y+4);
        
        //c add length = 20
        
        /*How could you use variables to make it easy to change the size
         *  (both horizontally and vertically) of all arrowheads?
         *   (You can assume that all arrowheads have the same size.)
         *   d)
         *   make x1, y1 and x2 and y2 Multiply line 2 by -1
         */
        x = 10;
    	y = 10;
        
        int x2 = x + 10;
    	int y2 = y + 4;
        
    	gc.strokeLine(x, y, x2*length,y2*length );
        gc.strokeLine(x, y, x2*length, (-1*y2)*length);
        
        
        
    }

}
