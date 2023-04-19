package opgave_04;

//Opgave 4
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

	
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Counter");
		GridPane pane = new GridPane();
		this.initContent(pane);
		pane.setPrefSize(360, 100
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
		
		pane.add(this.txfName1, 1, 1 );
		txfName1.setPrefSize(200, 10);
		txfName1.setText("0");
		
		// add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
		
		Label lblName = new Label("Number:");
		pane.add(lblName, 0, 1);
		
		

		// add a button to the pane (at col=1, row=1)
		Button lowerBtn = new Button(" -");
		pane.add(lowerBtn, 2, 2);
		GridPane.setMargin(lowerBtn, new Insets(10, 10, 0, 10));
		
		lowerBtn.setOnAction(event -> this.subtract());
		
		Button upperBtn = new Button("+");
		pane.add(upperBtn, 2, 0);
		GridPane.setMargin(upperBtn, new Insets(10, 10, 0, 10));
		
		upperBtn.setOnAction(event -> this.add());

	
	}
	private void add(){
		String temp = txfName1.getText();
		txfName1.setText("" + (Integer.parseInt(temp)+ 1));
		
	}
	private void subtract(){
		String temp = txfName1.getText();
		txfName1.setText("" + (Integer.parseInt(temp) - 1));
		
	}
}


	

