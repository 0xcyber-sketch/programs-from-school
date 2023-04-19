package exercise9;

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
		

		double x = 180; 
		double y1 = 0;
		double y2 = (x/5 + x/2);
		
		//New offset
		double offset1 = 0;
		double offset2 = 0;
		
		//Old height/length to get new offset 
		double top = x/5;
		double bot = x/2;
		
		
		
		
		
		while (x > 5) {
			gc.strokeLine(x, y1 + offset1, x, y2 - offset2);
			x = x*0.75;
			offset1 = top - x/5;
			offset2 = bot - x/2;
			System.out.println(x);
			
			
		}
		

	}
}


