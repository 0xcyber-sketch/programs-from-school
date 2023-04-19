package guifx;

import application.controller.Controller;
import application.model.Område;
import application.model.Plads;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import storage.Storage;

public class MainApp extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Netcafe Administration");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private final TextField nummerTxf = new TextField();;
	private final ListView<Plads> lvwPladser = new ListView<>();
	private final ToggleGroup group = new ToggleGroup();
	
	private Label lblError;

	private void initContent(GridPane pane) {

		Controller.init();

		pane.setGridLinesVisible(false);
		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		Label lblPladser = new Label("Pladser:");
		pane.add(lblPladser, 0, 0);

		Label lblNummer = new Label("Nummer:");
		pane.add(lblNummer, 0, 5);
		pane.add(nummerTxf, 0, 6);

		pane.add(lvwPladser, 0, 1);
		lvwPladser.setPrefWidth(200);
		lvwPladser.setPrefHeight(200);
		lvwPladser.getItems().setAll(Storage.getPladser());

//		ChangeListener<Palds> listener = (ov, o, n) -> this.personsItemSelected();
//        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);
		Label lblOmråder = new Label("Områder:");
		pane.add(lblOmråder, 0, 2);

		VBox box = new VBox();
		pane.add(box, 0, 3);

		String[] områder = { "Standard", "VIP", "Børne", "Turnering" };
		Område[] område = Område.values();

		for (int i = 0; i < områder.length; i++) {
			RadioButton rb = new RadioButton();
			box.getChildren().add(rb);
			rb.setText(områder[i]);
			// make the radio button remember its own color
			rb.setUserData(område[i]);
			// ensure that only one radio button is in selected state
			rb.setToggleGroup(group);
			// set the method to execute when a radio button is selected
//            rb.setOnAction(event -> );
		}

		Button btnOpret = new Button("Opret");
		pane.add(btnOpret, 0, 7);
		btnOpret.setOnAction(event -> this.createPlads());
		
		lblError = new Label();
		pane.add(lblError, 1, 7);
		lblError.setStyle("-fx-text-fill: red");
	}

	// -------------------------------------------------------------------------
	// Button actions

	private void createPlads() {
		int nr = 0;
		RadioButton rb = (RadioButton) group.getSelectedToggle();

		
		try {
			 nr = Integer.parseInt(nummerTxf.getText().trim());
			 
		}
		catch (Exception e) {
			// TODO: handle exception
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fejl i nummeret");
			alert.setHeaderText("Tjek at nummeret er et tal");
			// wait for the modal dialog to close
			alert.showAndWait();
		}
		
		
		if (rb == null) {
			System.out.println("Yo");
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Område ikke valgt");
			alert.setHeaderText("Der er ikke valgt noget område");
			// wait for the modal dialog to close
			alert.showAndWait();
		}

		else {

			Område område = (Område) rb.getUserData();
			System.out.println(nr);
			Controller.createPlads(nr, område);
			
			nummerTxf.clear();
			group.selectToggle(null);
			lvwPladser.getItems().setAll(Storage.getPladser());
		}
	}
}
