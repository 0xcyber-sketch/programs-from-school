package exercise7for.copy;

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

		/*
		// Replace the statement here with your code.
		//Draw x-axis
		int x1 = 20;
		int x2 = 180;
		int y = 180;
		int y2; 

		gc.strokeLine(x1, y, x2, y);


    	//Arrow
    	gc.strokeLine(x2, y, x2-10, y-4);
    	gc.strokeLine(x2, y, x2-10, y+4);

    	//ticks
    	int x = 180;
    	int height = 10;
    	double length = 12;
    	for (int i = 1; i <= 11; i++) {
    		// Draws 
    		gc.strokeLine(x1 + (length*i), x-height, x1 + (length*i), x+height);

    	}*/
		// Replace the statement here with your code.
		//Draw x-axis
		int x1 = 20;
		int x2 = 180;
		int y = 180;
		int y2; 

		gc.strokeLine(x1, y, x2, y);


		//Arrow
		gc.strokeLine(x2, y, x2-10, y-4);
		gc.strokeLine(x2, y, x2-10, y+4);

		//ticks
		int x = 180;
		int height = 5;
		double length = 12;
		for (int i = 0; i <= 10; i++) {
			// Draws 
			if (i % 5 == 0) {
				height = height * 2;
				//gc.fillText("" + i, x, 180);
			}
			gc.strokeLine(x1 + (length*i), x-height, x1 + (length*i), x+height);
			height = 5; 
		}

	}
}


