package guifx;

import java.time.LocalDate;

import application.controller.Controller;
import application.model.Konference;
import application.model.Udflugt;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdministrationUdflugtWindow extends Stage {
	private Konference konference;
	private Udflugt udflugt;

	public AdministrationUdflugtWindow(String title, Konference konference, Udflugt udflugt) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);
		this.konference = konference;
		this.udflugt = udflugt;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
		
		if (udflugt != null) {
			updateControl();
		}
	}
	
	public AdministrationUdflugtWindow(String title, Konference konference) {
		this(title, konference, null);
	}

	private TextField txfSted, txfPris, txfTime, txfMinut;
	private TextArea txaBeskrivelse;
	private Label lblError;
	private DatePicker dpStartDato;

	private LocalDate minDate;
	private LocalDate maxDate;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		minDate = konference.getStartDato().toLocalDate();
		maxDate = konference.getSlutDato().toLocalDate();

		int prefWidth = 160;
		Label lblName = new Label("Sted:");
		pane.add(lblName, 0, 0);
		txfSted = new TextField();
		pane.add(txfSted, 0, 1);
		txfSted.setPrefWidth(prefWidth);

		Label lblBeskrivelse = new Label("Beskrivelse:");
		pane.add(lblBeskrivelse, 0, 2);
		txaBeskrivelse = new TextArea();
		pane.add(txaBeskrivelse, 0, 3);
		txaBeskrivelse.setPrefSize(prefWidth, 80);

		Label lblAnkomst = new Label("Ankomstdato:");
		pane.add(lblAnkomst, 0, 4);

		dpStartDato = new DatePicker();
		pane.add(dpStartDato, 0, 5);
		dpStartDato.setPrefWidth(prefWidth);
		dpStartDato.setDayCellFactory(d -> new DateCell() {
			@Override
			public void updateItem(LocalDate item, boolean empty) {
				super.updateItem(item, empty);
				setDisable(item.isAfter(maxDate) || item.isBefore(minDate));
			}
		});

		Label lblTid = new Label(" Timer:                     Minutter:");
		pane.add(lblTid, 0, 6);

		HBox hbxTid = new HBox(10);
		pane.add(hbxTid, 0, 7, 1, 1);
		hbxTid.setPadding(new Insets(10, 0, 0, 0));
		hbxTid.setAlignment(Pos.BASELINE_CENTER);

		txfTime = new TextField();
		hbxTid.getChildren().add(txfTime);
		txfTime.setPrefWidth(95);

		txfMinut = new TextField();
		hbxTid.getChildren().add(txfMinut);
		txfMinut.setPrefWidth(95);

		Label lblPris = new Label("Pris:");
		pane.add(lblPris, 0, 8);
		txfPris = new TextField();
		pane.add(txfPris, 0, 9);
		txfPris.setPrefWidth(prefWidth);

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 10);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 10);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());

		lblError = new Label();
		pane.add(lblError, 0, 11);
		lblError.setStyle("-fx-text-fill: red");
	}

	private void okAction() {
		String sted = txfSted.getText().trim();
		String beskrivelse = txaBeskrivelse.getText();
		int time = -1;
		int minut = -1;
		double pris = -1;

		if (sted.length() == 0) {
			lblError.setText("Stedfeltet er tom");
		} else {
			if (dpStartDato.getValue() == null) {
				lblError.setText("Datoen er tom");
			} else {
				try {
					time = Integer.parseInt(txfTime.getText().trim());
					minut = Integer.parseInt(txfMinut.getText().trim());
					pris = Double.parseDouble(txfPris.getText().trim());
				} catch (NumberFormatException ex) {
					// do nothing
				}
				if (time > 23 || time < 0) {
					lblError.setText("Timetallet er udenfor tidszonen");
				} else if (minut > 60 || minut < 0) {
					lblError.setText("Minuttallet er udenfor tidszonen");
				} else if (pris < 0) {
					lblError.setText("Prisen kan ikke være mindre end 0");
				} else {
					if (udflugt != null) {
						Controller.updateUdflug(udflugt, sted, Controller.calcDateTime(time, minut, dpStartDato), pris,
								beskrivelse);
					} else {
						Controller.createUdflugt(konference, sted, Controller.calcDateTime(time, minut, dpStartDato), pris,
								beskrivelse);
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
		txfSted.setText(udflugt.getSted());
		txaBeskrivelse.setText(udflugt.getBeskrivelse());
		dpStartDato.setValue(udflugt.getStartTid().toLocalDate());
		txfTime.setText(udflugt.getStartTid().getHour() + "");
		txfMinut.setText(udflugt.getStartTid().getMinute() + "");
		txfPris.setText(udflugt.getPris() + "");
	}
}
