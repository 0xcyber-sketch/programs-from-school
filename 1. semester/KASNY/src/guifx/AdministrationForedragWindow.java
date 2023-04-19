package guifx;

import java.time.LocalDate;
import java.time.LocalDateTime;

import application.controller.Controller;
import application.model.Foredrag;
import application.model.Konference;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdministrationForedragWindow extends Stage {
	private Konference konference;
	private Foredrag foredrag;

	public AdministrationForedragWindow(String title, Konference konference, Foredrag foredrag) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);
		this.konference = konference;
		this.foredrag = foredrag;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
		
		if (foredrag != null) {
			updateControl();
		}
	}
	
	public AdministrationForedragWindow(String title, Konference konference) {
		this(title, konference, null);
	}

	private TextField txfEmne, txfVarighed, txfTime, txfMinut;
	private Label lblError;
	private DatePicker dpStartTid;

	private LocalDate minDate;
	private LocalDate maxDate;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		minDate = konference.getStartDato().toLocalDate();
		maxDate = konference.getSlutDato().toLocalDate();

		int prefWidth = 200;
		Label lblName = new Label("Emne:");
		pane.add(lblName, 0, 0);
		txfEmne = new TextField();
		pane.add(txfEmne, 0, 1);
		txfEmne.setPrefWidth(prefWidth);

		Label lblStartTid = new Label("Starts tidspunkt:");
		pane.add(lblStartTid, 0, 2);

		dpStartTid = new DatePicker();
		pane.add(dpStartTid, 0, 3);
		dpStartTid.setPrefWidth(prefWidth);
		dpStartTid.setDayCellFactory(d -> new DateCell() {
			@Override
			public void updateItem(LocalDate item, boolean empty) {
				super.updateItem(item, empty);
				setDisable(item.isAfter(maxDate) || item.isBefore(minDate));
			}
		});

		Label lblTid = new Label(" Timer:                     Minutter:");
		pane.add(lblTid, 0, 4);

		HBox hbxTid = new HBox(10);
		pane.add(hbxTid, 0, 5, 1, 1);
		hbxTid.setPadding(new Insets(10, 0, 0, 0));
		hbxTid.setAlignment(Pos.BASELINE_CENTER);

		txfTime = new TextField();
		hbxTid.getChildren().add(txfTime);
		txfTime.setPrefWidth(95);

		txfMinut = new TextField();
		hbxTid.getChildren().add(txfMinut);
		txfMinut.setPrefWidth(95);

		Label lblVarighed = new Label("Varighed i timer:");
		pane.add(lblVarighed, 0, 6);
		txfVarighed = new TextField();
		pane.add(txfVarighed, 0, 7);
		txfVarighed.setPrefWidth(prefWidth);

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 9);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 9);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());

		lblError = new Label();
		pane.add(lblError, 0, 11);
		lblError.setStyle("-fx-text-fill: red");

	}

	private void okAction() {
		String emne = txfEmne.getText().trim();
		int time = -1;
		int minut = -1;
		double varighed = -1;

		if (emne.length() == 0) {
			lblError.setText("Emnefeltet er tomt");
		} else {
			if (dpStartTid.getValue() == null) {
				lblError.setText("Datoen er tom");
			} else {

				try {
					time = Integer.parseInt(txfTime.getText().trim());
					minut = Integer.parseInt(txfMinut.getText().trim());
					varighed = Double.parseDouble(txfVarighed.getText().trim());
				} catch (NumberFormatException ex) {
					// do nothing
				}
				if (time > 23 || time < 0) {
					lblError.setText("Timetallet er udenfor tidszonen");
				} else if (minut > 60 || minut < 0) {
					lblError.setText("Minuttallet er udenfor tidszonen");
				} else if (varighed < 0) {
					lblError.setText("Varigheden kan ikke være mindre end 0");
				} else {
					LocalDateTime startTid = Controller.calcDateTime(time, minut, dpStartTid);
					if (foredrag != null) {
						Controller.updateForedrag(foredrag, emne, startTid, varighed, foredrag.getForedragsholder());
					} else {
						Controller.createForedrag(konference, emne, startTid, varighed);

					}

					this.hide();
				}
			}
		}
	}

	private void cancelAction() {
		this.hide();
	}
	
	private void updateControl() {
		txfEmne.setText(foredrag.getEmne());
		dpStartTid.setValue(foredrag.getStartTid().toLocalDate());
		txfTime.setText(foredrag.getStartTid().getHour() + "");
		txfMinut.setText(foredrag.getStartTid().getMinute() + "");
		txfVarighed.setText(foredrag.getVarighed() + "");
	}


}
