package guifx;

import application.controller.Controller;
import application.model.Hotel;
import application.model.TillægsService;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdministrationTillægsServicesWindow extends Stage {

	private Hotel hotel;
	private TillægsService tillægsService;

	public AdministrationTillægsServicesWindow(String title,  Hotel hotel, TillægsService tillægsService) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);
		this.hotel = hotel;
		this.tillægsService = tillægsService;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
		
		if (tillægsService != null) {
			updateControl();
		}
	}
	
	public AdministrationTillægsServicesWindow(String title,  Hotel hotel) {
		this(title, hotel, null);
	}

	private TextField txfBeskrivelse,  txfPris;
	private Label lblError;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		int prefWidth = 200;
		Label lblBeskrivelse = new Label("Beskrivelse:");
		pane.add(lblBeskrivelse, 0, 0);
		txfBeskrivelse = new TextField();
		pane.add(txfBeskrivelse, 0, 1);
		txfBeskrivelse.setPrefWidth(prefWidth);

		Label lblPris = new Label("Pris:");
		pane.add(lblPris, 0, 2);
		txfPris = new TextField();
		pane.add(txfPris, 0, 3);
		txfPris.setPrefWidth(prefWidth);



		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 9);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 9);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());

		lblError = new Label();
		pane.add(lblError, 0, 10);
		lblError.setStyle("-fx-text-fill: red");

	}

	private void okAction() {
		String beskrivelse = txfBeskrivelse.getText().trim();
		double pris = -1;

		if (beskrivelse.length() == 0) {
			lblError.setText("Beskrivelsesfeltet er tom");
		
		} else {

			try {

				pris = Double.parseDouble(txfPris.getText().trim());
			} catch (NumberFormatException ex) {
				// do nothing
			}

			if (pris < 0 ) {
				lblError.setText("Prisen kan ikke være mindre end 0");
			} else {

					if (tillægsService != null) {
						Controller.updateTllægsService(tillægsService, beskrivelse, pris);;
					} else {
						Controller.createTillægsService(hotel, beskrivelse, pris);

					}

					this.hide();
				}
			}
		}
	

	private void cancelAction() {
		this.hide();
	}

	private void updateControl() {
		txfBeskrivelse.setText(tillægsService.getBeskrivelse());
		txfPris.setText(tillægsService.getPris() + "");
	}
}
