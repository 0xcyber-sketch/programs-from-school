package opgave05;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainApp extends Application {
	// Start Application
	@Override
	public void start(Stage stage) {
		stage.setTitle("Girls + Boys");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();

	}

	private final ListView<String> lvwPeople = new ListView<>();
	private final ArrayList<String> girls = new ArrayList<>();
	private final ArrayList<String> boys = new ArrayList<>();
	private final TextField txfName = new TextField();
	private final ToggleGroup group = new ToggleGroup();

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

		HBox box = new HBox();
		pane.add(box, 0, 0);

		String[] peopleA = { "Girls", "Boys" };

		for (int i = 0; i < peopleA.length; i++) {
			RadioButton rb = new RadioButton();
			box.getChildren().add(rb);
			rb.setText(peopleA[i]);

			if (i == 0) {
				rb.setUserData(lvwPeople.getItems().setAll(girls));
			} else {
				rb.setUserData(lvwPeople.getItems().setAll(boys));
			}
			rb.setToggleGroup(group);
			rb.setOnAction(event -> this.changeList());

		}

		Label lblNames = new Label("Names:");
		pane.add(lblNames, 0, 1);

		// Add name field
		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 7);
		pane.add(txfName, 1, 7, 2, 1);
		txfName.prefWidth(200);

		pane.add(lvwPeople, 1, 1, 1, 5);
		// Set sizes
		lvwPeople.setPrefWidth(200);
		lvwPeople.setPrefHeight(200);
		// Add data to the list view
		lvwPeople.getItems().setAll(girls);

		Button btnAdd = new Button("Add");
		pane.add(btnAdd, 6, 7);
		// connect a method to the button
		btnAdd.setOnAction(event -> this.addAction());

		RadioButton rb0 = (RadioButton) group.getToggles().get(0);
		rb0.setSelected(true);

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
		girls.add("Anne");
		girls.add("Charlotte");
		girls.add("Anna");
		girls.add("Pia");
		girls.add("Cecilie");
		girls.add("Mia");
		girls.add("Mathilde");
		girls.add("Lenora");
		girls.add("Sia");
		girls.add("Tanja");
		girls.add("Gwen");
		girls.add("Yasmin");
		girls.add("Olivia");

	}

	private void addAction() {
		String name = txfName.getText().trim();
		if (group.getToggles().get(0).isSelected()) {
			if (name.length() > 0) {
				girls.add(name);
				lvwPeople.getItems().setAll(girls);
				txfName.clear();
			}
		} else {
			if (name.length() > 0) {
				boys.add(name);
				lvwPeople.getItems().setAll(boys);
				txfName.clear();
			}
		}
	}

	private void changeList() {
		RadioButton rb = (RadioButton) group.getSelectedToggle();
		if (group.getToggles().get(0).isSelected()) {
			rb.setUserData(lvwPeople.getItems().setAll(girls));
		} else {
			rb.setUserData(lvwPeople.getItems().setAll(boys));
		}

	}

}
