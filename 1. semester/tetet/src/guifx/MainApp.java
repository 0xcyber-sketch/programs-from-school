package guifx;

import application.controller.Controller;
import application.model.Deltagelse;
import application.model.DeltagerStatus;
import application.model.Fag;
import application.model.Lektion;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void init() {
		Controller.init();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Fraværs Registrerings System");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private ListView<Fag> lvwFag;
	private ListView<Lektion> lvwLektion;
	private ListView<Deltagelse> lvwDeltagelse;
	private ToggleGroup group = new ToggleGroup();
	private Label lblError;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblFag = new Label("Fag");
		pane.add(lblFag, 0, 0);

		lvwFag = new ListView<>();
		pane.add(lvwFag, 0, 1);
		lvwFag.setPrefSize(200, 200);
		lvwFag.getItems().setAll(storage.Storage.getFag());

		// Listener
		ChangeListener<Fag> listener = (ov, o, n) -> this.FagItemSelected();
		lvwFag.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblLektion = new Label("Lektion");

		pane.add(lblLektion, 1, 0);
		lvwLektion = new ListView<>();
		pane.add(lvwLektion, 1, 1);
		lvwLektion.setPrefSize(200, 200);

//		Listener
		ChangeListener<Lektion> listener2 = (ov, o, n) -> this.LektionItemSelected();
		lvwLektion.getSelectionModel().selectedItemProperty().addListener(listener2);

		Label lblDeltagelse = new Label("Deltagelse");
		pane.add(lblDeltagelse, 2, 0);
		lvwDeltagelse = new ListView<>();
		pane.add(lvwDeltagelse, 2, 1);
		lvwDeltagelse.setPrefSize(200, 200);

		Label lblFravær = new Label("Fraværsårsager");
		pane.add(lblFravær, 3, 0);

		VBox box = new VBox();
		pane.add(box, 3, 1);

		String[] statusString = { "Tilstede", "Fravær", "Syg", "Afbud" };
		DeltagerStatus[] deltagerStatus = { DeltagerStatus.TILSTEDE, DeltagerStatus.FRAVÆR, DeltagerStatus.SYG,
				DeltagerStatus.AFBUD };

		for (int i = 0; i < statusString.length; i++) {
			RadioButton rb = new RadioButton();
			box.getChildren().add(rb);
			rb.setText(statusString[i]);
			rb.setUserData(deltagerStatus[i]);
			rb.setToggleGroup(group);
//            rb.setOnAction(event -> this.setLabelColor());
		}

		Button btnFravær = new Button("Fravær");
		box.getChildren().add(btnFravær);
		btnFravær.setOnAction(event -> this.tagFravær());

		lblError = new Label();
		pane.add(lblError, 2, 3);
		lblError.setStyle("-fx-text-fill: red");

	}

	private void FagItemSelected() {
		Fag fag = lvwFag.getSelectionModel().getSelectedItem();
		if (fag != null) {
			lvwLektion.getItems().setAll(fag.getLektioner());
		}
	}

	private void LektionItemSelected() {
		Lektion lektion = lvwLektion.getSelectionModel().getSelectedItem();
		if (lektion != null) {
			lvwDeltagelse.getItems().setAll(lektion.getDeltagelser());
		}
	}

	private void tagFravær() {
		Lektion lektion = lvwLektion.getSelectionModel().getSelectedItem();
		Deltagelse deltagelse = lvwDeltagelse.getSelectionModel().getSelectedItem();
		RadioButton rb = (RadioButton) group.getSelectedToggle();
		if (deltagelse != null) {
			try {
				DeltagerStatus status = (DeltagerStatus) rb.getUserData();
				if (status != deltagelse.getStatus()) {
				Controller.updateDeltagelse(deltagelse, status, true);} 
			}
			catch (Exception e) {
				lblError.setText("Kunne ikke opdatere fraværet");
			}
			
		}
		lvwDeltagelse.getItems().setAll(lektion.getDeltagelser());
		update();
	}

	private void update() {
		RadioButton rb0 = (RadioButton) group.getToggles().get(0);
		rb0.setSelected(true);

	}

}
