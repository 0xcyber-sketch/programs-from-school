package guifx;


import application.controller.Controller;
import application.model.Konference;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdministrationKonferenceWindow extends Stage {
	private Konference konference;

	public AdministrationKonferenceWindow(String title, Konference konference) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);
		this.konference = konference;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);

		if (konference != null) {
			updateControl();
		}
	}

	public AdministrationKonferenceWindow(String title) {
		this(title, null);
	}

	private TextField txfName, txfAdresse, txfPris, txfTimeStart, txfMinutStart, txfTimeSlut, txfMinutSlut;
	private TextArea txaBeskrivelse;
	private Label lblError;
	private DatePicker dpStartDato, dpSlutDato;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		int prefWidth = 160;
		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 0);
		txfName = new TextField();
		pane.add(txfName, 0, 1);
		txfName.setPrefWidth(prefWidth);

		Label lblBeskrivelse = new Label("Beskrivelse:");
		pane.add(lblBeskrivelse, 0, 2);
		txaBeskrivelse = new TextArea();
		pane.add(txaBeskrivelse, 0, 3);
		txaBeskrivelse.setPrefSize(prefWidth, 80);

		Label lblAdresse = new Label("Adresse:");
		pane.add(lblAdresse, 0, 4);
		txfAdresse = new TextField();
		pane.add(txfAdresse, 0, 5);
		txfAdresse.setPrefWidth(prefWidth);

		Label lblAnkomst = new Label("Ankomstdato:");
		pane.add(lblAnkomst, 0, 6);

		dpStartDato = new DatePicker();
		pane.add(dpStartDato, 0, 7);
		dpStartDato.setPrefWidth(prefWidth);

		Label lblTid = new Label(" Timer:                     Minutter:");
		pane.add(lblTid, 0, 8);

		HBox hbxTid = new HBox(10);
		pane.add(hbxTid, 0, 9, 1, 1);
		hbxTid.setPadding(new Insets(10, 0, 0, 0));
		hbxTid.setAlignment(Pos.BASELINE_CENTER);

		txfTimeStart = new TextField();
		hbxTid.getChildren().add(txfTimeStart);
		txfTimeStart.setPrefWidth(95);

		txfMinutStart = new TextField();
		hbxTid.getChildren().add(txfMinutStart);
		txfMinutStart.setPrefWidth(95);

		Label lblSlut = new Label("Slut dato:");
		pane.add(lblSlut, 0, 10);

		dpSlutDato = new DatePicker();
		pane.add(dpSlutDato, 0, 11);
		dpSlutDato.setPrefWidth(prefWidth);

		Label lblTid2 = new Label(" Timer:                     Minutter:");
		pane.add(lblTid2, 0, 12);

		HBox hbxTid2 = new HBox(10);
		pane.add(hbxTid2, 0, 13, 1, 1);
		hbxTid2.setPadding(new Insets(10, 0, 0, 0));
		hbxTid2.setAlignment(Pos.BASELINE_CENTER);

		txfTimeSlut = new TextField();
		hbxTid2.getChildren().add(txfTimeSlut);
		txfTimeSlut.setPrefWidth(95);

		txfMinutSlut = new TextField();
		hbxTid2.getChildren().add(txfMinutSlut);
		txfMinutSlut.setPrefWidth(95);

		Label lblPris = new Label("Pris:");
		pane.add(lblPris, 0, 14);
		txfPris = new TextField();
		pane.add(txfPris, 0, 15);
		txfPris.setPrefWidth(prefWidth);

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 16);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 16);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());

		lblError = new Label();
		pane.add(lblError, 0, 17);
		lblError.setStyle("-fx-text-fill: red");
	}

	private void okAction() {
		String navn = txfName.getText().trim();
		String beskrivelse = txaBeskrivelse.getText();
		String adresse = txfAdresse.getText().trim();
		int time1 = -1;
		int minut1 = -1;
		int time2 = -1;
		int minut2 = -1;
		double pris = -1;
		if (navn.length() == 0) {
			lblError.setText("Navnefeltet er tom");
		} else if (adresse.length() == 0) {
			lblError.setText("Adressefeltet er tom");
			
		} else if (dpSlutDato.getValue() == null || dpStartDato.getValue() == null) {
			lblError.setText("En dato er tom");
		}
		else if (dpSlutDato.getValue().isBefore(dpStartDato.getValue())) {
			lblError.setText("Start dato skal være før slut dato");
		} else {
			try {
				time1 = Integer.parseInt(txfTimeStart.getText().trim());
				minut1 = Integer.parseInt(txfMinutStart.getText().trim());
				time2 = Integer.parseInt(txfTimeSlut.getText().trim());
				minut2 = Integer.parseInt(txfMinutSlut.getText().trim());
				pris = Double.parseDouble(txfPris.getText().trim());
			} catch (NumberFormatException ex) {
				// do nothing
			}
			if (time1 > 23 || time1 < 0 || time2 > 23 || time2 < 0) {
				lblError.setText("Timetallet er udenfor tidszonen");
			} else if (minut1 > 60 || minut1 < 0 || minut2 > 60 || minut2 < 0) {
				lblError.setText("Minuttallet er udenfor tidszonen");
			} else if (pris < 0) {
				lblError.setText("Prisen kan ikke være mindre end 0");
			} else {
				if (konference != null) {
					Controller.updateKonference(konference, navn, beskrivelse, Controller.calcDateTime(time1, minut1, dpStartDato),
							adresse, pris, Controller.calcDateTime(time2, minut2, dpSlutDato));
				} else {
					Controller.createKonference(navn, beskrivelse, Controller.calcDateTime(time1, minut1, dpStartDato), adresse,
							pris, Controller.calcDateTime(time2, minut2, dpSlutDato));
				}		
			this.hide();
			}
		}
	}

	private void cancelAction() {
		this.hide();
	}

	private void updateControl() {
		txfName.setText(konference.getNavn());
		txaBeskrivelse.setText(konference.getBeskrivelse());
		txfAdresse.setText(konference.getAdresse());
		dpStartDato.setValue(konference.getStartDato().toLocalDate());
		txfTimeStart.setText(konference.getStartDato().getHour() + "");
		txfMinutStart.setText(konference.getStartDato().getMinute() + "");
		dpSlutDato.setValue(konference.getSlutDato().toLocalDate());
		txfTimeSlut.setText(konference.getSlutDato().getHour() + "");
		txfMinutSlut.setText(konference.getSlutDato().getMinute() + "");
		txfPris.setText(konference.getPris() + "");
	}
}
