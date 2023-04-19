package guifx;

import application.controller.Controller;
import application.model.Hotel;
import application.model.Konference;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AministrationHotelWindow extends Stage {

	private Hotel hotel;
	private Konference konference;

	public AministrationHotelWindow(String title, Konference konference, Hotel hotel) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);
		this.hotel = hotel;
		this.konference = konference;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);

		if (hotel != null) {
			updateControl();
		}
	}

	private TextField txfNavn, txfAdresse, txfPrisEnkeltVærelse, txfPrisDobbeltVærelse;
	private Label lblError;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		int prefWidth = 100;
		Label lblName = new Label("Navn:");
		pane.add(lblName, 0, 0);
		txfNavn = new TextField();
		pane.add(txfNavn, 0, 1);
		txfNavn.setPrefWidth(prefWidth);

		Label lblAdresse = new Label("Adresse:");
		pane.add(lblAdresse, 0, 2);
		txfAdresse = new TextField();
		pane.add(txfAdresse, 0, 3);
		txfAdresse.setPrefWidth(prefWidth);

		Label lblpris = new Label("Priser");
		pane.add(lblpris, 0, 4);

		Label lblpris2 = new Label("Enkeltværelse:\t\t  Dobbeltværelse:");
		pane.add(lblpris2, 0, 5);

		HBox hbxpriser = new HBox(10);
		pane.add(hbxpriser, 0, 6, 1, 1);
		hbxpriser.setPadding(new Insets(10, 0, 0, 0));
		hbxpriser.setAlignment(Pos.BASELINE_CENTER);

		txfPrisEnkeltVærelse = new TextField();
		txfPrisEnkeltVærelse.setPrefWidth(prefWidth);
		hbxpriser.getChildren().add(txfPrisEnkeltVærelse);

		txfPrisDobbeltVærelse = new TextField();
		txfPrisDobbeltVærelse.setPrefWidth(prefWidth);
		hbxpriser.getChildren().add(txfPrisDobbeltVærelse);


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
		String navn = txfNavn.getText().trim();
		String adresse = txfAdresse.getText().trim();
		double prisEnkeltsVærelse = -1;
		double prisDobbeltVærelse = -1;

		if (navn.length() == 0) {
			lblError.setText("Navnefeltet er tom");
		} else if (adresse.length() == 0) {
			lblError.setText("Adressefeltet er tom");
		} else {
			try {
				prisEnkeltsVærelse = Double.parseDouble(txfPrisEnkeltVærelse.getText().trim());
				prisDobbeltVærelse = Double.parseDouble(txfPrisDobbeltVærelse.getText().trim());
			} catch (NumberFormatException ex) {
				// do nothing
			}
			if (prisEnkeltsVærelse < 0 || prisDobbeltVærelse < 0) {
				lblError.setText("Prisen kan ikke være mindre end 0");
			} else {

				if (prisEnkeltsVærelse > prisDobbeltVærelse) {
					lblError.setText("Dobbelt værelse skal være dyrest");
				} else {
					if (hotel != null) {
						Controller.updateHotel(hotel, prisEnkeltsVærelse, navn, adresse, prisDobbeltVærelse);
					} else {
						Hotel h1 = Controller.createHotel(prisEnkeltsVærelse, navn, adresse, prisDobbeltVærelse);
						Controller.addHotelToKonference(h1, konference);
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
		txfNavn.setText(hotel.getNavn());
		txfAdresse.setText(hotel.getAdresse());
		txfPrisEnkeltVærelse.setText(hotel.getPrisEnkeltVærelse() + "");
		txfPrisDobbeltVærelse.setText(hotel.getPrisDobbeltVærelse() + "");
	}
}
