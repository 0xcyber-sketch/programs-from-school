package opgave03;

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
		
		personInfo = new PersonInformationWindow(stage);

	}

	private final ListView<Person> lvwPersons = new ListView<>();
	private final ArrayList<Person> persons = new ArrayList<>();
	private final TextField txfName = new TextField();
	private final TextField txfTitle = new TextField();
	private PersonInformationWindow personInfo;
	

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

		

		// Add ListView field
		pane.add(lvwPersons, 1, 2, 1, 5);
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

	}
	
	private void addAction(){
		personInfo.showAndWait();
		
		if (personInfo.getActualPerson() != null) {
			Person p = personInfo.getActualPerson();
			persons.add(p);
			lvwPersons.getItems().setAll(persons);
			personInfo.clearActualPerson(); // Bug fix
		}
		
		
		
	}

	private void initPersons() {
		persons.add(new Person("Hans", "Politi", true));
		persons.add(new Person("Jez", "Hjælper", false));
		persons.add(new Person("Tobias", "Elev", false));
	}
	
	
	

	private void selectionChanged() {
		Person newPerson = lvwPersons.getSelectionModel().getSelectedItem();
		if (newPerson != null) {

		} else {
			txfName.clear();
			txfTitle.clear();
		}

	}
}
