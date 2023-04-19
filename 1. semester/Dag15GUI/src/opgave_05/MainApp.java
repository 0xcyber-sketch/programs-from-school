package opgave_05;

// Opgave 5
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
		stage.setTitle("Celsius to Fahrenheit");
		GridPane pane = new GridPane();
		this.initContent(pane);
		pane.setPrefSize(300, 100
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
		
		pane.add(this.txfName1, 1, 0);
		txfName1.setPrefSize(100, 10);
		
		 Label lblName1 = new Label("Celsius:");
	     pane.add(lblName1, 0, 0);
		
		// add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
		
		pane.add(this.txfName2, 1, 1);
		txfName2.setPrefSize(100, 10); //Set length and size of textfield. This shit genius.
		
		Label lblName2 = new Label("Fahrenheit:");
	     pane.add(lblName2, 0, 1);
		
		

		// add a button to the pane (at col=1, row=1)
		Button cBtn = new Button("Celsius");
		pane.add(cBtn, 0, 3);
		GridPane.setMargin(cBtn, new Insets(10, 10, 0, 10));
		
		cBtn.setOnAction(event -> this.celsiusConverter());
		
		Button fBtn = new Button("Fahrenheit");
		pane.add(fBtn, 1, 3);
		GridPane.setMargin(fBtn, new Insets(10, 10, 0, 10));
		
		fBtn.setOnAction(event -> this.fahrenheitConverter());

	
	}
	private void fahrenheitConverter(){
		String temp = txfName1.getText().trim();
		//double f  = ((1.8 * Double.parseDouble(temp)) + 32);
		double f  = (((double) 9/5 * Double.parseDouble(temp)) + 32);
		txfName2.setText("" + f);
		txfName1.clear();
		
		
	}
	private void celsiusConverter(){
		String temp = txfName2.getText().trim();
		double c  = (Double.parseDouble(temp) - 32) / 1.8;
		System.out.println(c);
		txfName1.setText("" + c);
		txfName2.clear();

		
	}
}


	

