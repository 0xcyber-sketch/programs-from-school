package opgave04;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	// Start Application
	@Override
	public void start(Stage stage) {
		stage.setTitle("Boys");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();

	}

	private final ListView<String> lvwBoys = new ListView<>();
	private final ArrayList<String> boys = new ArrayList<>();
	private final TextField txfName = new TextField();


	private void initContent(GridPane pane) {
		initPersons();
		// show or hide grid lines
		pane.setGridLinesVisible(false);
		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		// Add Label name in 0 col and 0 row

		Label lblNames = new Label("Names:");
		pane.add(lblNames, 0, 0);

		// Add name field
		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 6);
		pane.add(txfName, 1, 6, 2, 1);
		txfName.prefWidth(200);

		// Add label in 0 col row 1


		// Add Persons label


		// Add ListView field
		pane.add(lvwBoys, 1, 0, 1, 5);
		// Set sizes
		lvwBoys.setPrefWidth(200);
		lvwBoys.setPrefHeight(200);
		// Add data to the list view
		lvwBoys.getItems().setAll(boys);
		

		Button btnAdd = new Button("Add");
		pane.add(btnAdd, 6, 6);
		// connect a method to the button
		btnAdd.setOnAction(event -> this.addAction());

		
		

	}

	private void initPersons() {
		boys.add("Hans");
		boys.add("Tobias");
		boys.add("Emil");
		boys.add("Dennis");
		boys.add("John");
		boys.add("Carl");
		boys.add("Magnus");
		boys.add("Mads");
		boys.add("Mikkel");
		boys.add("Trevor");
		boys.add("Gustav");
		boys.add("Jørgen");
		boys.add("Ben");
		boys.add("Charlie");
		
	}
	
	private void addAction(){
		String name = txfName.getText().trim();
		if (name.length() > 0) {
			boys.add(name);
			lvwBoys.getItems().setAll(boys);
			txfName.clear();
		
		}		
	}


	
}
