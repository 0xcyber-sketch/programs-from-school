package guifx;

import application.controller.Controller;
import application.model.Foredrag;
import application.model.Hotel;
import application.model.Konference;
import application.model.TillægsService;
import application.model.Tilmelding;
import application.model.Udflugt;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AdministrationPane extends GridPane {
	private ListView<Konference> lvwKonferencer;
	private ListView<Hotel> lvwHoteller;
	private ListView<Udflugt> lvwUdflugter;
	private ListView<TillægsService> lvwTillægsServices;
	private ListView<Foredrag> lvwForedrager;
	private ListView<Tilmelding> lvwTilmeldinger;
	
	private TabPane tabPane;

	public AdministrationPane(TabPane tabPane) {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);
		
		this.tabPane = tabPane;

		int buttonWidth = 60;

		Label lblKonference = new Label("Konferencer:");
		this.add(lblKonference, 0, 0);

		lvwKonferencer = new ListView<>();
		this.add(lvwKonferencer, 0, 1, 1, 3);
		lvwKonferencer.setPrefSize(200, 375);
		lvwKonferencer.getItems().setAll(Controller.getKonference());

		ChangeListener<Konference> listener = (ov, oldKonference, newKonference) -> this.selectedKonferenceChanged();
		lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(listener);

		// listener
		// Listener I guess

		HBox hbxButtons1 = new HBox(10);
		this.add(hbxButtons1, 0, 4, 1, 1);
		hbxButtons1.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons1.setAlignment(Pos.BASELINE_CENTER);

		Button btnCreate1 = new Button("Opret");
		btnCreate1.setPrefWidth(buttonWidth);
		hbxButtons1.getChildren().add(btnCreate1);
		btnCreate1.setOnAction(event -> this.createKonference());

		Button btnUpdate1 = new Button("Opdater");
		btnUpdate1.setPrefWidth(buttonWidth);
		hbxButtons1.getChildren().add(btnUpdate1);
		btnUpdate1.setOnAction(event -> this.updateKonference());

		Button btnDelete1 = new Button("Slet");
		btnDelete1.setPrefWidth(buttonWidth);
		hbxButtons1.getChildren().add(btnDelete1);
		btnDelete1.setOnAction(event -> this.deleteKonference());

		// Udflugter

		Label lblUdflugt = new Label("Udflugter for den valgte konference:");
		this.add(lblUdflugt, 2, 2);

		lvwUdflugter = new ListView<>();
		this.add(lvwUdflugter, 2, 3, 1, 2);
		lvwUdflugter.setPrefSize(200, 200);
//	lvwUdflugter.getItems().setAll(Controller.getKonference());

		// listener
		// Listener I guess

		VBox vbxButtons2 = new VBox(40);
		this.add(vbxButtons2, 3, 3, 1, 2);
		vbxButtons2.setPadding(new Insets(10, 0, 0, 0));
		vbxButtons2.setAlignment(Pos.BASELINE_CENTER);

		Button btnCreate2 = new Button("Opret");
		btnCreate2.setPrefWidth(buttonWidth);
		vbxButtons2.getChildren().add(btnCreate2);
		btnCreate2.setOnAction(event -> this.createUdflugt());

		Button btnUpdate2 = new Button("Opdater");
		btnUpdate2.setPrefWidth(buttonWidth);
		vbxButtons2.getChildren().add(btnUpdate2);
		btnUpdate2.setOnAction(event -> this.updateUdflugt());

		Button btnDelete2 = new Button("Slet");
		btnDelete2.setPrefWidth(buttonWidth);
		vbxButtons2.getChildren().add(btnDelete2);
		btnDelete2.setOnAction(event -> this.deleteUdflugt());

		// Hoteller
		Label lblHoteller = new Label("Hoteller for den valgte konference:");
		this.add(lblHoteller, 2, 0);

		lvwHoteller = new ListView<>();
		this.add(lvwHoteller, 2, 1, 1, 1);
		lvwHoteller.setPrefSize(200, 200);
//	lvwKonferencer.getItems().setAll(Controller.getKonference());
//	
//	// listener
//	//Listener I guess

//	
		VBox vbxButtons3 = new VBox(40);
		this.add(vbxButtons3, 3, 1, 1, 1);
		vbxButtons3.setPadding(new Insets(10, 0, 0, 0));
		vbxButtons3.setAlignment(Pos.BASELINE_CENTER);
//	
//	
		Button btnCreate3 = new Button("Opret");
		btnCreate3.setPrefWidth(buttonWidth);
		vbxButtons3.getChildren().add(btnCreate3);
		btnCreate3.setOnAction(event -> this.createHotel());
//
		Button btnUpdate3 = new Button("Opdater");
		btnUpdate3.setPrefWidth(buttonWidth);
		vbxButtons3.getChildren().add(btnUpdate3);
		btnUpdate3.setOnAction(event -> this.updateHotel());
//
		Button btnDelete3 = new Button("Slet");
		btnDelete3.setPrefWidth(buttonWidth);
		vbxButtons3.getChildren().add(btnDelete3);
		btnDelete3.setOnAction(event -> this.deleteHotel());
//	

		ChangeListener<Hotel> listener2 = (ov, oldHotel, newHotel) -> this.selectedHotelChanged();
		lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listener2);

		// Tillægs Services
		Label lblTilæg = new Label("Tillægs Services:");
		this.add(lblTilæg, 4, 0);

		lvwTillægsServices = new ListView<>();
		this.add(lvwTillægsServices, 4, 1, 1, 1);
		lvwTillægsServices.setPrefSize(200, 200);

//	
		VBox vbxButtons4 = new VBox(40);
		this.add(vbxButtons4, 5, 1, 1, 1);
		vbxButtons4.setPadding(new Insets(10, 0, 0, 0));
		vbxButtons4.setAlignment(Pos.BASELINE_CENTER);
//	
//	
		Button btnCreate4 = new Button("Opret");
		btnCreate4.setPrefWidth(buttonWidth);
		vbxButtons4.getChildren().add(btnCreate4);
		btnCreate4.setOnAction(event -> this.createTillægsService());
//
		Button btnUpdate4 = new Button("Opdater");
		btnUpdate4.setPrefWidth(buttonWidth);
		vbxButtons4.getChildren().add(btnUpdate4);
		btnUpdate4.setOnAction(event -> this.updateTillægsService());
//
		Button btnDelete4 = new Button("Slet");
		btnDelete4.setPrefWidth(buttonWidth);
		vbxButtons4.getChildren().add(btnDelete4);
		btnDelete4.setOnAction(event -> this.deleteTillægsService());

		// Foredrag
		Label lblForedrag = new Label("Foredrag:");
		this.add(lblForedrag, 4, 2);

		lvwForedrager = new ListView<>();
		this.add(lvwForedrager, 4, 3, 1, 2);
		lvwForedrager.setPrefSize(200, 200);

//	
		VBox vbxButtons5 = new VBox(40);
		this.add(vbxButtons5, 5, 3, 1, 2);
		vbxButtons5.setPadding(new Insets(10, 0, 0, 0));
		vbxButtons5.setAlignment(Pos.BASELINE_CENTER);
//	
//	
		Button btnCreate5 = new Button("Opret");
		btnCreate5.setPrefWidth(buttonWidth);
		vbxButtons5.getChildren().add(btnCreate5);
		btnCreate5.setOnAction(event -> this.createForedrag());
//
		Button btnUpdate5 = new Button("Opdater");
		btnUpdate5.setPrefWidth(buttonWidth);
		vbxButtons5.getChildren().add(btnUpdate5);
		btnUpdate5.setOnAction(event -> this.updateForedrag());
//
		Button btnDelete5 = new Button("Slet");
		btnDelete5.setPrefWidth(buttonWidth);
		vbxButtons5.getChildren().add(btnDelete5);
		btnDelete5.setOnAction(event -> this.deleteForedrag());

		// Tilmelding
		Label lblTilmelding = new Label("Tilmeldinger:");
		this.add(lblTilmelding, 6, 0);

		lvwTilmeldinger = new ListView<>();
		this.add(lvwTilmeldinger, 6, 1, 1, 1);
		lvwTilmeldinger.setPrefSize(200, 200);

		//
		VBox vbxButtons6 = new VBox(40);
		this.add(vbxButtons6, 7, 1, 1, 1);
		vbxButtons6.setPadding(new Insets(10, 0, 0, 0));
		vbxButtons6.setAlignment(Pos.BASELINE_CENTER);
		//
		Button btnUpdate6 = new Button("Opdater");
		btnUpdate6.setPrefWidth(buttonWidth);
		vbxButtons6.getChildren().add(btnUpdate6);
		btnUpdate6.setOnAction(event -> this.updateTilmelding());
		//
		Button btnDelete6 = new Button("Slet");
		btnDelete6.setPrefWidth(buttonWidth);
		vbxButtons6.getChildren().add(btnDelete6);
		btnDelete6.setOnAction(event -> this.deleteForedrag());

		
		lvwKonferencer.getSelectionModel().select(0);

	}

	// --------------------------------- Konference

	private void selectedKonferenceChanged() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference != null) {
			lvwUdflugter.getItems().setAll(konference.getUdflugter());
			lvwHoteller.getItems().setAll(konference.getHoteller());
			lvwTilmeldinger.getItems().setAll(konference.getTilmeldinger());
		}
	}

	private void createKonference() {
		AdministrationKonferenceWindow window = new AdministrationKonferenceWindow("Opret Konference");
		window.showAndWait();

		// Wait for the window to close

		lvwKonferencer.getItems().setAll(Controller.getKonference());
	}

	private void deleteKonference() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference != null) {
			Controller.removeKonference(konference);

		}
		lvwKonferencer.getItems().setAll(Controller.getKonference());
		lvwHoteller.getItems().clear();
		lvwUdflugter.getItems().clear();
	}

	private void updateKonference() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		AdministrationKonferenceWindow window = new AdministrationKonferenceWindow("Opret Konference", konference);
		window.showAndWait();

		// Wait for the window to close

		lvwKonferencer.getItems().setAll(Controller.getKonference());
	}

	// --------------------------------- Udflugt

	private void createUdflugt() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference != null) {
			AdministrationUdflugtWindow window = new AdministrationUdflugtWindow("Opret Udflugt", konference);
			window.showAndWait();

			// Wait for the window to close
		}
		lvwUdflugter.getItems().setAll(konference.getUdflugter());
	}

	private void updateUdflugt() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		Udflugt udflugt = lvwUdflugter.getSelectionModel().getSelectedItem();
		AdministrationUdflugtWindow window = new AdministrationUdflugtWindow("Opret Udflugt", konference, udflugt);
		window.showAndWait();

		// Wait for the modal windowlog to close

		lvwUdflugter.getItems().setAll(konference.getUdflugter());
	}

	private void deleteUdflugt() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		Udflugt udflugt = lvwUdflugter.getSelectionModel().getSelectedItem();
		if (udflugt != null) {
			Controller.deleteUdflugt(konference, udflugt);
		}
		lvwUdflugter.getItems().setAll(konference.getUdflugter());
	}

	// --------------------------------- Hotel

	private void createHotel() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference != null) {
			AministrationHotelWindow window = new AministrationHotelWindow("Opret Hotel", konference, null);
			window.showAndWait();

			// Wait for the modal windowlog to close
		}
		lvwHoteller.getItems().setAll(konference.getHoteller());
	}

	private void updateHotel() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
		AministrationHotelWindow window = new AministrationHotelWindow("Update Hotel", konference, hotel);
		window.showAndWait();

		// Wait for the modal windowlog to close

		lvwHoteller.getItems().setAll(konference.getHoteller());
	}

	private void deleteHotel() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
		if (hotel != null) {
			Controller.removeHotelFromKonference(hotel, konference);
			Controller.removeHoteller(hotel);
		}
		lvwHoteller.getItems().setAll(konference.getHoteller());
	}

	private void selectedHotelChanged() {
		Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
		if (hotel != null) {
			lvwTillægsServices.getItems().setAll(hotel.getTillægsServices());
		}
	}

	// --------------------------------- TillægsService

	public void createTillægsService() {
		Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
		if (hotel != null) {
			AdministrationTillægsServicesWindow window = new AdministrationTillægsServicesWindow(
					"Opret Tillægs Service", hotel);
			window.showAndWait();

			// Wait for the modal windowlog to close

			this.selectedHotelChanged();
		}

	}

	public void updateTillægsService() {
		Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
		TillægsService tillægsService = lvwTillægsServices.getSelectionModel().getSelectedItem();
		if (hotel != null && tillægsService != null) {
			AdministrationTillægsServicesWindow window = new AdministrationTillægsServicesWindow(
					"Opret Tillægs Service", hotel, tillægsService);
			window.showAndWait();

			// Wait for the window to close

			this.selectedHotelChanged();
		}

	}

	public void deleteTillægsService() {
		Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
		TillægsService tillægsService = lvwTillægsServices.getSelectionModel().getSelectedItem();
		if (hotel != null && tillægsService != null) {
			Controller.deleteTillægsService(tillægsService, hotel);
			this.selectedHotelChanged();
		}
	}

	// --------------------------------- Foredrag

	public void createForedrag() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference != null) {
			AdministrationForedragWindow window = new AdministrationForedragWindow("Opret foredrag", konference);
			window.showAndWait();

			// Wait for the window to close

			lvwForedrager.getItems().setAll(konference.getForedrager());
		}
	}

	public void updateForedrag() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		Foredrag foredrag = lvwForedrager.getSelectionModel().getSelectedItem();
		if (konference != null && foredrag != null) {
			AdministrationForedragWindow window = new AdministrationForedragWindow("Opret foredrag", konference,
					foredrag);
			window.showAndWait();

			// Wait for the window to close

			lvwForedrager.getItems().setAll(konference.getForedrager());
		}
	}

	public void deleteForedrag() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		Foredrag foredrag = lvwForedrager.getSelectionModel().getSelectedItem();
		if (konference != null && foredrag != null) {
			Controller.deleteForedrag(konference, foredrag);

			lvwForedrager.getItems().setAll(konference.getForedrager());
		}
	}
	
	// --------------------------------- Tilmelding
	
	public void updateTilmelding() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		Tilmelding tilmelding = lvwTilmeldinger.getSelectionModel().getSelectedItem();
		if (konference != null && tilmelding != null) {
			
			Tab tabUpdateTilmelding = new Tab("Opdater tilmelding");
			tabPane.getTabs().add(tabUpdateTilmelding);
			
			TilmeldPane tilmeldPane = new TilmeldPane(tilmelding, tabPane);
			tabUpdateTilmelding.setContent(tilmeldPane);
			tabUpdateTilmelding.setOnSelectionChanged(event -> tilmeldPane.updateControls());
			
			tabPane.getSelectionModel().select(tabUpdateTilmelding);
			
			// Wait for the window to close

			//lvwTilmeldinger.getItems().setAll(konference.getTilmeldinger());
		}
	}
	// --------------------------------- Other

	public void updateControls() {
		lvwKonferencer.getItems().setAll(Controller.getKonference());
		lvwKonferencer.getSelectionModel().select(0);
	}

}
