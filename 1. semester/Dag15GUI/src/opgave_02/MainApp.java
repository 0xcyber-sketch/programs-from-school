package opgave_02;

// Opgave 2
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	private TextField txfName1 = new TextField();
	private TextField txfName2 = new TextField();
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Swap Words");
		GridPane pane = new GridPane();
		this.initContent(pane);
		pane.setPrefSize(240, 100
				);
	

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(true);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		
		// set horizontal gap between components 
		pane.setHgap(10);
		// set vertical gap between components 
		pane.setVgap(10);


		// add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
		
		pane.add(this.txfName1, 0, 0);
		txfName1.setPrefSize(200, 10);
		
		// add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
		
		pane.add(this.txfName2, 0, 1);
		txfName2.setPrefSize(200, 10); //Set length and size of textfield. This shit genius.
		
		
		

		// add a button to the pane (at col=1, row=1)
		Button swapBtn = new Button("Combine words");
		pane.add(swapBtn, 0, 3);
		GridPane.setMargin(swapBtn, new Insets(10, 10, 0, 10));
		
		swapBtn.setOnAction(event -> this.swapWords());

	
	}
	private void swapWords(){
		String temp1 = txfName1.getText().trim();
		String temp2 = txfName2.getText().trim();
		txfName2.setText(temp1);
		txfName1.setText(temp2);
		
	}
}


	

