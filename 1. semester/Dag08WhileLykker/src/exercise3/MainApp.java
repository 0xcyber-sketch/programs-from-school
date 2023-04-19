package exercise3;

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
	{/*
		// Replace the statement here with your code.
		// a
		int x = 100;
		int y = 100;
		
		//x - r finder topen af venstre. 
		int r = 20;		
		while (r <= 100) {
			gc.strokeOval(x - r, y - r, r  *2, r* 2 );
			r += 20;
			
	
		}
		*/
		/* b
		int x = 10;
		int y = 100;
		
		int r = 10;
		
		while (r <= 80) {
			gc.strokeOval(x, y - r, r  *2, r* 2 );
			r += 10;
		}*/
		//C
		int x = 100;
		int y = 40;
		
		//x - r  finder toppen af venstrehjørne. 
		int r = 10;		
		while (r <= 80) {
			gc.strokeOval(x - r, y, r  *2, 60 );
			r += 10;
		}
		

	}

}
