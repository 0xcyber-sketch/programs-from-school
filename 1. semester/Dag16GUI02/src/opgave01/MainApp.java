package opgave01;

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
		stage.setTitle("Person administration");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();

	}

	private final ListView<Person> lvwPersons = new ListView<>();
	private final ArrayList<Person> persons = new ArrayList<>();
	private final TextField txfName = new TextField();
	private final TextField txfTitle = new TextField();
	CheckBox checkBox = new CheckBox();
	private boolean senior = false;

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

		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 0);

		// Add name field
		pane.add(txfName, 1, 0, 2, 1);

		// Add label in 0 col row 1

		Label lblTitle = new Label("Title:");
		pane.add(lblTitle, 0, 1);

		// Add title field
		pane.add(txfTitle, 1, 1, 2, 1);

		// Add Persons label
		Label lblList = new Label("Persons:");
		pane.add(lblList, 0, 3);

		// Add ListView field
		pane.add(lvwPersons, 1, 3, 1, 5);
		// Set sizes
		lvwPersons.setPrefWidth(200);
		lvwPersons.setPrefHeight(200);
		// Add data to the list view
		lvwPersons.getItems().setAll(persons);
		// Make listener that keeps track of the the selected name/item
		 ChangeListener<Person> listener = (ov, oldPerson, newPerson) ->
		 this.selectionChanged();

       lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

      lvwPersons.getSelectionModel().clearSelection();

		Button btnAdd = new Button("Add Person");
		pane.add(btnAdd, 6, 2);
		btnAdd.setOnAction(event -> addAction());

		// connect a method to the button
		// btnAdd.setOnAction(event -> this.addAction());

		
		checkBox.setText("Senior");
		pane.add(checkBox, 1, 2);

		// connect a method to the button
		// btnDelete.setOnAction(event -> this.deleteAction());

	}

	private void initPersons() {
		persons.add(new Person("Hans", "Politi", true));
		persons.add(new Person("Jez", "Hjælper", false));
		persons.add(new Person("Tobias", "Elev", false));
	}
	
	private void addAction(){
		String name = txfName.getText().trim();
		String title = txfTitle.getText().trim();
		if (name.length() > 0 && title.length() > 0) {
			if (checkBox.isSelected()){
				senior = true;
			}
			else {
				senior = false;
			}
			Person p = new Person(name, title, senior);
			persons.add(p);
			lvwPersons.getItems().setAll(persons);
		
		}		
	}

	private void selectionChanged() {
		Person newPerson = lvwPersons.getSelectionModel().getSelectedItem();
		if (newPerson != null) {
			txfName.setText(newPerson.getName());
			txfTitle.setText(newPerson.getTitle());
			if (newPerson.isSenior()) {
				checkBox.setSelected(true);
			}
			else {
				checkBox.setSelected(false);
			
			}
		} else {
			txfName.clear();
			txfTitle.clear();
		}

	}
}
