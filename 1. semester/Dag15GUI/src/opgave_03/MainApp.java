package opgave_03;

//Opgave 1S
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
	private TextField txfName3 = new TextField();
	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Split Names");
		GridPane pane = new GridPane();
		this.initContent(pane);
		pane.setPrefSize(440, 100
				);
	

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		
		// set horizontal gap between components 
		pane.setHgap(10);
		// set vertical gap between components 
		pane.setVgap(10);


		// add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
		
		pane.add(this.txfName1, 0, 2, 2,1);
		txfName1.setPrefSize(200, 10);
		
		// add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
		
		pane.add(this.txfName2, 2, 2, 2, 1);
		txfName2.setPrefSize(200, 10); //Set length and size of textfield. This shit genius.
		
		pane.add(this.txfName3, 0, 0, 4, 1);
		txfName3.setPrefSize(400, 10);
		
		
		

		// add a button to the pane (at col=1, row=1)
		Button splitBtn = new Button("Split words");
		pane.add(splitBtn, 1, 3);
		GridPane.setMargin(splitBtn, new Insets(10, 10, 0, 10));
		
		splitBtn.setOnAction(event -> this.splitWords());

	
	}
	private void splitWords(){
		String[] temp = txfName3.getText().trim().split(" ");
		txfName1.setText(temp[0]);
		txfName2.setText(temp[1]);
	}
}


	

