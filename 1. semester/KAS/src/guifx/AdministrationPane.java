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

		HBox hbxKonferenceButtons = new HBox(10);
		this.add(hbxKonferenceButtons, 0, 4, 1, 1);
		hbxKonferenceButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxKonferenceButtons.setAlignment(Pos.BASELINE_CENTER);

		Button btnCreateKonference = new Button("Opret");
		btnCreateKonference.setPrefWidth(buttonWidth);
		hbxKonferenceButtons.getChildren().add(btnCreateKonference);
		btnCreateKonference.setOnAction(event -> this.createKonference());

		Button btnUpdateKonference = new Button("Opdater");
		btnUpdateKonference.setPrefWidth(buttonWidth);
		hbxKonferenceButtons.getChildren().add(btnUpdateKonference);
		btnUpdateKonference.setOnAction(event -> this.updateKonference());

		Button btnDeleteKOnference = new Button("Slet");
		btnDeleteKOnference.setPrefWidth(buttonWidth);
		hbxKonferenceButtons.getChildren().add(btnDeleteKOnference);
		btnDeleteKOnference.setOnAction(event -> this.deleteKonference());

		// Udflugter

		Label lblUdflugt = new Label("Udflugter for den valgte konference:");
		this.add(lblUdflugt, 2, 2);

		lvwUdflugter = new ListView<>();
		this.add(lvwUdflugter, 2, 3, 1, 2);
		lvwUdflugter.setPrefSize(200, 200);

		VBox vbxUdflugterButtons = new VBox(40);
		this.add(vbxUdflugterButtons, 3, 3, 1, 2);
		vbxUdflugterButtons.setPadding(new Insets(10, 0, 0, 0));
		vbxUdflugterButtons.setAlignment(Pos.BASELINE_CENTER);

		Button btnCreateUdflugt = new Button("Opret");
		btnCreateUdflugt.setPrefWidth(buttonWidth);
		vbxUdflugterButtons.getChildren().add(btnCreateUdflugt);
		btnCreateUdflugt.setOnAction(event -> this.createUdflugt());

		Button btnUpdateUdflugt = new Button("Opdater");
		btnUpdateUdflugt.setPrefWidth(buttonWidth);
		vbxUdflugterButtons.getChildren().add(btnUpdateUdflugt);
		btnUpdateUdflugt.setOnAction(event -> this.updateUdflugt());

		Button btnDeleteUdflugt = new Button("Slet");
		btnDeleteUdflugt.setPrefWidth(buttonWidth);
		vbxUdflugterButtons.getChildren().add(btnDeleteUdflugt);
		btnDeleteUdflugt.setOnAction(event -> this.deleteUdflugt());

		// Hoteller
		Label lblHoteller = new Label("Hoteller for den valgte konference:");
		this.add(lblHoteller, 2, 0);

		lvwHoteller = new ListView<>();
		this.add(lvwHoteller, 2, 1, 1, 1);
		lvwHoteller.setPrefSize(200, 200);

		VBox vbxHotellerButtons = new VBox(40);
		this.add(vbxHotellerButtons, 3, 1, 1, 1);
		vbxHotellerButtons.setPadding(new Insets(10, 0, 0, 0));
		vbxHotellerButtons.setAlignment(Pos.BASELINE_CENTER);

		Button btnCreateHotel = new Button("Opret");
		btnCreateHotel.setPrefWidth(buttonWidth);
		vbxHotellerButtons.getChildren().add(btnCreateHotel);
		btnCreateHotel.setOnAction(event -> this.createHotel());

		Button btnUpdateHotel = new Button("Opdater");
		btnUpdateHotel.setPrefWidth(buttonWidth);
		vbxHotellerButtons.getChildren().add(btnUpdateHotel);
		btnUpdateHotel.setOnAction(event -> this.updateHotel());

		Button btnDeleteHotel = new Button("Slet");
		btnDeleteHotel.setPrefWidth(buttonWidth);
		vbxHotellerButtons.getChildren().add(btnDeleteHotel);
		btnDeleteHotel.setOnAction(event -> this.deleteHotel());

		ChangeListener<Hotel> listener2 = (ov, oldHotel, newHotel) -> this.selectedHotelChanged();
		lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listener2);

		// Tillægs Services
		Label lblTilæg = new Label("Tillægs Services:");
		this.add(lblTilæg, 4, 0);

		lvwTillægsServices = new ListView<>();
		this.add(lvwTillægsServices, 4, 1, 1, 1);
		lvwTillægsServices.setPrefSize(200, 200);

		VBox vbxTillægsServicesButtons = new VBox(40);
		this.add(vbxTillægsServicesButtons, 5, 1, 1, 1);
		vbxTillægsServicesButtons.setPadding(new Insets(10, 0, 0, 0));
		vbxTillægsServicesButtons.setAlignment(Pos.BASELINE_CENTER);

		Button btnCreateTillægsService = new Button("Opret");
		btnCreateTillægsService.setPrefWidth(buttonWidth);
		vbxTillægsServicesButtons.getChildren().add(btnCreateTillægsService);
		btnCreateTillægsService.setOnAction(event -> this.createTillægsService());

		Button btnUpdateTillægsService = new Button("Opdater");
		btnUpdateTillægsService.setPrefWidth(buttonWidth);
		vbxTillægsServicesButtons.getChildren().add(btnUpdateTillægsService);
		btnUpdateTillægsService.setOnAction(event -> this.updateTillægsService());

		Button btnDeleteTillægsService = new Button("Slet");
		btnDeleteTillægsService.setPrefWidth(buttonWidth);
		vbxTillægsServicesButtons.getChildren().add(btnDeleteTillægsService);
		btnDeleteTillægsService.setOnAction(event -> this.deleteTillægsService());

		// Foredrag
		Label lblForedrag = new Label("Foredrag:");
		this.add(lblForedrag, 4, 2);

		lvwForedrager = new ListView<>();
		this.add(lvwForedrager, 4, 3, 1, 2);
		lvwForedrager.setPrefSize(200, 200);

		VBox vbxForedragerButtons = new VBox(40);
		this.add(vbxForedragerButtons, 5, 3, 1, 2);
		vbxForedragerButtons.setPadding(new Insets(10, 0, 0, 0));
		vbxForedragerButtons.setAlignment(Pos.BASELINE_CENTER);

		Button btnCreateForedrag = new Button("Opret");
		btnCreateForedrag.setPrefWidth(buttonWidth);
		vbxForedragerButtons.getChildren().add(btnCreateForedrag);
		btnCreateForedrag.setOnAction(event -> this.createForedrag());

		Button btnUpdateForedrag = new Button("Opdater");
		btnUpdateForedrag.setPrefWidth(buttonWidth);
		vbxForedragerButtons.getChildren().add(btnUpdateForedrag);
		btnUpdateForedrag.setOnAction(event -> this.updateForedrag());

		Button btnDeleteForedrag = new Button("Slet");
		btnDeleteForedrag.setPrefWidth(buttonWidth);
		vbxForedragerButtons.getChildren().add(btnDeleteForedrag);
		btnDeleteForedrag.setOnAction(event -> this.deleteForedrag());

		// Tilmelding
		Label lblTilmelding = new Label("Tilmeldinger:");
		this.add(lblTilmelding, 6, 0);

		lvwTilmeldinger = new ListView<>();
		this.add(lvwTilmeldinger, 6, 1, 1, 4);
		lvwTilmeldinger.setPrefSize(200, 200);

		VBox vbxTilmeldingerButtons = new VBox(40);
		this.add(vbxTilmeldingerButtons, 7, 1, 1, 1);
		vbxTilmeldingerButtons.setPadding(new Insets(10, 0, 0, 0));
		vbxTilmeldingerButtons.setAlignment(Pos.BASELINE_CENTER);

		Button btnUpdateTilmelding = new Button("Opdater");
		btnUpdateTilmelding.setPrefWidth(buttonWidth);
		vbxTilmeldingerButtons.getChildren().add(btnUpdateTilmelding);
		btnUpdateTilmelding.setOnAction(event -> this.updateTilmelding());

		Button btnDeleteTilmelding = new Button("Slet");
		btnDeleteTilmelding.setPrefWidth(buttonWidth);
		vbxTilmeldingerButtons.getChildren().add(btnDeleteTilmelding);
		btnDeleteTilmelding.setOnAction(event -> this.deleteTilmelding());

		
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
		} else {
			lvwTillægsServices.getItems().clear();
		}
	}

	// --------------------------------- TillægsService

	private void createTillægsService() {
		Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
		if (hotel != null) {
			AdministrationTillægsServicesWindow window = new AdministrationTillægsServicesWindow(
					"Opret Tillægs Service", hotel);
			window.showAndWait();

			// Wait for the modal windowlog to close

			this.selectedHotelChanged();
		}
	}

	private void updateTillægsService() {
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

	private void deleteTillægsService() {
		Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
		TillægsService tillægsService = lvwTillægsServices.getSelectionModel().getSelectedItem();
		if (hotel != null && tillægsService != null) {
			Controller.deleteTillægsService(tillægsService, hotel);
			this.selectedHotelChanged();
		}
	}

	// --------------------------------- Foredrag

	private void createForedrag() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference != null) {
			AdministrationForedragWindow window = new AdministrationForedragWindow("Opret foredrag", konference);
			window.showAndWait();

			// Wait for the window to close

			lvwForedrager.getItems().setAll(konference.getForedrager());
		}
	}

	private void updateForedrag() {
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

	private void deleteForedrag() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		Foredrag foredrag = lvwForedrager.getSelectionModel().getSelectedItem();
		if (konference != null && foredrag != null) {
			Controller.deleteForedrag(konference, foredrag);

			lvwForedrager.getItems().setAll(konference.getForedrager());
		}
	}
	
	// --------------------------------- Tilmelding
	
	private void updateTilmelding() {
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
	
	private void deleteTilmelding() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		Tilmelding tilmelding = lvwTilmeldinger.getSelectionModel().getSelectedItem();
		if (konference != null && tilmelding != null) {
			Controller.deleteTilmelding(tilmelding);
		}
		updateControls();
	}
	
	// --------------------------------- Other

	public void updateControls() {
		lvwKonferencer.getItems().setAll(Controller.getKonference());
		lvwKonferencer.getSelectionModel().select(0);
	}
}
