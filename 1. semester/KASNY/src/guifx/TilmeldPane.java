package guifx;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import application.controller.Controller;
import application.model.Deltager;
import application.model.Foredrag;
import application.model.Foredragsholder;
import application.model.Hotel;
import application.model.Konference;
import application.model.Ledsager;
import application.model.TillægsService;
import application.model.Tilmelding;
import application.model.Udflugt;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class TilmeldPane extends GridPane {
	private ListView<Konference> lvwKonferencer;
	private ListView<Foredrag> lvwForedrag;
	private ListView<Udflugt> lvwUdflugter;
	private ListView<Hotel> lvwHoteller;
	private ListView<TillægsService> lvwTillægsServices;
	private TextField txfNavn, txfAdresse, txfBy_Land, txfTlfNr, txfFirmaNavn, txfFirmaTlfNr, txfSpeciale,
			txfLedsagerNavn, txfPris;
	private CheckBox chbForedragsholder, chbLedsager;
	private DatePicker dpAnkomstDato, dpAfrejseDato;
	private Label lblError;
	private Button btnTilmeld;
	
	private LocalDate minDate;
	private LocalDate maxDate;
	
	private Tilmelding preTilmelding;
	private TabPane tabPane;
	
	public TilmeldPane() {
		this(null, null);
	}

	public TilmeldPane(Tilmelding tilmelding, TabPane tabPane) {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);
		
		this.preTilmelding = tilmelding;
		this.tabPane = tabPane;

		Label lblKonference = new Label("Konferencer:");
		this.add(lblKonference, 0, 0);

		lvwKonferencer = new ListView<>();
		this.add(lvwKonferencer, 0, 1, 1, 8);
		lvwKonferencer.setPrefSize(200, 200);
		
		
		ChangeListener<Konference> konferenceListener = (ov, oldKonference, newKonference) -> this.selectedKonferenceChanged();
		lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(konferenceListener);
		
		Label lblDeltagerNavn = new Label("Deltager navn:");
		this.add(lblDeltagerNavn, 1, 0);

		txfNavn = new TextField();
		this.add(txfNavn, 2, 0);

		Label lblAdresse = new Label("Adresse:");
		this.add(lblAdresse, 1, 1);

		txfAdresse = new TextField();
		this.add(txfAdresse, 2, 1);

		Label lblBy_Land = new Label("By/Land:");
		this.add(lblBy_Land, 1, 2);

		txfBy_Land = new TextField();
		this.add(txfBy_Land, 2, 2);

		Label lblTlfnr = new Label("Tlf.nr:");
		this.add(lblTlfnr, 1, 3);

		txfTlfNr = new TextField();
		this.add(txfTlfNr, 2, 3);
		
		Label lblAnkomstdato = new Label("Ankomstdato:");
		this.add(lblAnkomstdato, 3, 0);

		dpAnkomstDato = new DatePicker();
		this.add(dpAnkomstDato, 4, 0);
		dpAnkomstDato.setDayCellFactory(d ->
        new DateCell() {
            @Override public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                setDisable(item.isAfter(maxDate) || item.isBefore(minDate));
            }});
		dpAnkomstDato.setOnAction(event -> this.displayPris());

		Label lblAfrejsedato = new Label("Afrejsedato:");
		this.add(lblAfrejsedato, 3, 1);

		dpAfrejseDato = new DatePicker();
		this.add(dpAfrejseDato, 4, 1);
		dpAfrejseDato.setDayCellFactory(d ->
        new DateCell() {
            @Override public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                setDisable(item.isAfter(maxDate) || item.isBefore(minDate));
            }});
		dpAfrejseDato.setOnAction(event -> this.displayPris());

		Label lblFirmanavn = new Label("Firma navn:");
		this.add(lblFirmanavn, 3, 2);

		txfFirmaNavn = new TextField();
		this.add(txfFirmaNavn, 4, 2);

		Label lblFirmaTlfnr = new Label("Firma tlf nr:");
		this.add(lblFirmaTlfnr, 3, 3);

		txfFirmaTlfNr = new TextField();
		this.add(txfFirmaTlfNr, 4, 3);

		Label lblForedragsholder = new Label("Foredragsholder:");
		this.add(lblForedragsholder, 1, 4);

		chbForedragsholder = new CheckBox();
		this.add(chbForedragsholder, 2, 4);
		chbForedragsholder.setOnAction(event -> this.foredragsholderSelectionChanged());

		Label lblLedsager = new Label("Ledsager:");
		this.add(lblLedsager, 3, 4);

		chbLedsager = new CheckBox();
		this.add(chbLedsager, 4, 4);
		chbLedsager.setOnAction(event -> this.ledsagerSelectionChanged());

		Label lblSpeciale = new Label("Speciale:");
		this.add(lblSpeciale, 1, 5);

		txfSpeciale = new TextField();
		this.add(txfSpeciale, 2, 5);

		Label lblLedsagerNavn = new Label("Ledsager navn:");
		this.add(lblLedsagerNavn, 3, 5);

		txfLedsagerNavn = new TextField();
		this.add(txfLedsagerNavn, 4, 5);
		
		Label lblForedrag = new Label("Foredrag til konference:");
		this.add(lblForedrag, 1, 6);
		GridPane.setValignment(lblForedrag, VPos.TOP);
		
		lvwForedrag = new ListView<>();
		this.add(lvwForedrag, 2, 6, 1, 3);
		lvwForedrag.setPrefSize(200, 200);
		lvwForedrag.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		Label lblUdflugter = new Label("Udflugter til konference:");
		this.add(lblUdflugter, 3, 6);
		GridPane.setValignment(lblUdflugter, VPos.TOP);
		
		lvwUdflugter = new ListView<>();
		this.add(lvwUdflugter, 4, 6, 1, 3);
		lvwUdflugter.setPrefSize(200, 200);
		lvwUdflugter.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		ChangeListener<Udflugt> udflugtListener = (ov, oldUdflugt, newUdflugt) -> this.displayPris();
		lvwUdflugter.getSelectionModel().selectedItemProperty().addListener(udflugtListener);
		
		Label lblHoteller = new Label("Hoteller til konference:");
		this.add(lblHoteller, 5, 0, 2, 1);
		GridPane.setValignment(lblHoteller, VPos.TOP);
		
		lvwHoteller = new ListView<Hotel>();
		this.add(lvwHoteller, 5, 1, 2, 4);
		lvwHoteller.setPrefSize(200, 100);
		
		ChangeListener<Hotel> hotelListener = (ov, oldHotel, newHotel) -> this.selectedHotelChanged();
		lvwHoteller.getSelectionModel().selectedItemProperty().addListener(hotelListener);
		
		Label lblTillægsServices = new Label("Tillægs service til hotel");
		this.add(lblTillægsServices, 5, 5, 2, 1);
		GridPane.setValignment(lblTillægsServices, VPos.TOP);
		
		lvwTillægsServices = new ListView<TillægsService>();
		this.add(lvwTillægsServices, 5, 6, 2, 1);
		lvwTillægsServices.setPrefSize(200, 150);
		lvwTillægsServices.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		ChangeListener<TillægsService> tillægsServiceListener = (ov, oldTillægsService, newTillægsService) -> this.displayPris();
		lvwTillægsServices.getSelectionModel().selectedItemProperty().addListener(tillægsServiceListener);
		
		txfPris = new TextField("Pris");
		this.add(txfPris, 5, 7, 2, 1);
		txfPris.setEditable(false);
		
		btnTilmeld = new Button("Tilmeld");
		this.add(btnTilmeld, 5, 8);
		btnTilmeld.setOnAction(event -> this.tilmeldAction());
		
		lblError = new Label("Error");
		this.add(lblError, 6, 8);
		lblError.setStyle("-fx-text-fill: red");
		lblError.setVisible(false);
		
		//lvwKonferencer.getSelectionModel().select(0);
		disableTilmelding(true);
	}

	// -----------------------------------------------------------------------------

	private void foredragsholderSelectionChanged() {
		if (chbForedragsholder.isSelected()) {
			disableForedrag(false);
		} else {
			txfSpeciale.clear();
			disableForedrag(true);
		}
		displayPris();
	}

	private void ledsagerSelectionChanged() {
		if (chbLedsager.isSelected()) {
			disableLedsager(false);
		} else {
			txfLedsagerNavn.clear();
			disableLedsager(true);
		}
		displayPris();
	}
	
	private void selectedKonferenceChanged() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference != null) {
			lvwUdflugter.getItems().setAll(konference.getUdflugter());
			lvwForedrag.getItems().setAll(konference.getForedrager());
			lvwHoteller.getItems().setAll(konference.getHoteller());
			minDate = konference.getStartDato().toLocalDate();
			maxDate = konference.getSlutDato().toLocalDate();
			disableTilmelding(false);			
		} else {
			lvwUdflugter.getItems().clear();
			lvwForedrag.getItems().clear();
			lvwHoteller.getItems().clear();
			txfPris.setText("Pris");
			disableTilmelding(true);
		}
		
		dpAnkomstDato.setValue(null);
		dpAfrejseDato.setValue(null);
		lvwTillægsServices.getItems().clear();
		displayPris();
	}
	
	private void selectedHotelChanged() {
		Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
		if (hotel != null) {
			lvwTillægsServices.getItems().setAll(hotel.getTillægsServices());
		}
		displayPris();
	}
	
	private void tilmeldAction() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference != null) {
			if (dpAnkomstDato.getValue() != null && dpAfrejseDato.getValue() != null) {
				String deltagerNavn = txfNavn.getText().trim();
				if (!deltagerNavn.isEmpty()) {
					String adresse = txfAdresse.getText().trim();
					if (!adresse.isEmpty()) {
						String by_Land = txfBy_Land.getText().trim();
						if (!by_Land.isEmpty()) {
							String tlfNr = txfTlfNr.getText().trim();
							if (!tlfNr.isEmpty()) {
								Deltager deltager = null;
								String firmaNavn = txfFirmaNavn.getText().trim();
								String firmaTlfNr = txfFirmaTlfNr.getText().trim();
								ArrayList<Foredrag> foredrager = new ArrayList<Foredrag>(lvwForedrag.getSelectionModel().getSelectedItems());
								if (!firmaNavn.isEmpty() && !firmaTlfNr.isEmpty()) {
									if (chbForedragsholder.isSelected()) {
										if (preTilmelding != null) {
											Controller.updateForedragsholder((Foredragsholder)preTilmelding.getDeltager(), deltagerNavn, adresse, by_Land, tlfNr, firmaNavn, firmaTlfNr, txfSpeciale.getText().trim());
											Controller.updateForedragerOnForedragsholder(foredrager, (Foredragsholder)preTilmelding.getDeltager());
										} else {
											System.out.println("Yikes");
											deltager = Controller.createForedragsholder(deltagerNavn, adresse, by_Land, tlfNr, firmaNavn, firmaTlfNr, txfSpeciale.getText().trim());
											Controller.addForedragerToForedragsholder(foredrager, (Foredragsholder)deltager);
										}
									} else {
										if (preTilmelding != null) {
											Controller.updateDeltager(preTilmelding.getDeltager(), deltagerNavn, adresse, by_Land, tlfNr, firmaNavn, firmaTlfNr);
										} else {
											deltager = Controller.createDeltager(deltagerNavn, adresse, by_Land, tlfNr, firmaNavn, firmaTlfNr);
										}
									}
								} else {
									if (chbForedragsholder.isSelected()) {
										if (preTilmelding != null) {
											Controller.updateForedragsholder((Foredragsholder)preTilmelding.getDeltager(), deltagerNavn, adresse, by_Land, tlfNr, txfSpeciale.getText().trim());
											Controller.updateForedragerOnForedragsholder(foredrager, (Foredragsholder)preTilmelding.getDeltager());
										} else {
											deltager = Controller.createForedragsholder(deltagerNavn, adresse, by_Land, tlfNr, txfSpeciale.getText().trim());	
											Controller.addForedragerToForedragsholder(foredrager, (Foredragsholder)deltager);
										}
									} else {
										if (preTilmelding != null) {
											Controller.updateDeltager(preTilmelding.getDeltager(), deltagerNavn, adresse, by_Land, tlfNr);
										} else {
											deltager = Controller.createDeltager(deltagerNavn, adresse, by_Land, tlfNr);
										}
									}
								}
								Tilmelding tilmelding = preTilmelding;
								if (preTilmelding != null) {
									Controller.updateTilmelding(preTilmelding, konference, dpAnkomstDato.getValue(), dpAfrejseDato.getValue());
								} else {
									tilmelding = Controller.createTilmelding(dpAnkomstDato.getValue(), dpAfrejseDato.getValue(), deltager, konference);
								}
								if (chbLedsager.isSelected() && !txfLedsagerNavn.getText().trim().isEmpty()) {
									Ledsager ledsager = Controller.createLedsager(txfLedsagerNavn.getText().trim(), tilmelding);
									ArrayList<Udflugt> udflugter = new ArrayList<>(lvwUdflugter.getSelectionModel().getSelectedItems());
				
									Controller.updateUdflugterOnLedsager(udflugter, ledsager);
								}
								
								Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
								Controller.addHotelToTilmelding(hotel, tilmelding);
								if (hotel != null) {
									ArrayList<TillægsService> tillægsServices = new ArrayList<>(lvwTillægsServices.getSelectionModel().getSelectedItems());
									Controller.updateTillægsServicesOnTilmelding(tillægsServices, tilmelding);
								}
								
								if (preTilmelding != null) {
									for (Tab tab : new ArrayList<Tab>(tabPane.getTabs())) {
										if (tab.getContent() == this) {
											tabPane.getTabs().remove(tab);
										}
									}
								}
							this.restFields();
							} else {
								setError("Intet tlf nr indtastet");
							}
						} else {
							setError("Ingen by og land indtastet");
						}
						
					} else {
						setError("Ingen adresse indtastet");
					}
				} else {
					setError("Intet navn indtastet");
				}
			} else {
				setError("Ingen ankomst eller afrejsedato valgt");
			}
		} else {
			setError("Ingen konference valgt");
		}
	}
	
	private void setError(String error) {
		lblError.setText(error);
		lblError.setVisible(true);
	}
	
	private void disableTilmelding(boolean disable) {
		//lvwUdflugter.getItems().clear();
		txfNavn.setDisable(disable);
		txfAdresse.setDisable(disable);
		txfBy_Land.setDisable(disable);
		txfTlfNr.setDisable(disable);
		txfFirmaNavn.setDisable(disable);
		txfFirmaTlfNr.setDisable(disable);
		chbForedragsholder.setDisable(disable);
		chbLedsager.setDisable(disable);
		dpAnkomstDato.setDisable(disable);
		dpAfrejseDato.setDisable(disable);
		lvwHoteller.setDisable(disable);
		lvwTillægsServices.setDisable(disable);
		if (disable) {
			disableForedrag(disable);
			disableLedsager(disable);
		}
	}
	
	private void disableForedrag(boolean disable) {
		lvwForedrag.setDisable(disable);
		txfSpeciale.setDisable(disable);
	}
	
	private void disableLedsager(boolean disable) {
		lvwUdflugter.setDisable(disable);
		txfLedsagerNavn.setDisable(disable);
	}
	
	private void displayPris() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference != null) {
			if (dpAnkomstDato.getValue() != null && dpAfrejseDato.getValue() != null) {
				long dage = ChronoUnit.DAYS.between(dpAnkomstDato.getValue(), dpAfrejseDato.getValue());
				ArrayList<Udflugt> udflugter = new ArrayList<>(lvwUdflugter.getSelectionModel().getSelectedItems());
				Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
				ArrayList<TillægsService> tillægsServices = new ArrayList<>(lvwTillægsServices.getSelectionModel().getSelectedItems());
				double pris = Controller.beregnSamletPris(konference, dage, chbForedragsholder.isSelected(), chbLedsager.isSelected(),
						udflugter, hotel, tillægsServices);
				
				txfPris.setText(pris + "");
			}
		}
	}
	
	public void restFields() {
		txfNavn.clear();
		txfAdresse.clear();
		txfBy_Land.clear();
		txfTlfNr.clear();
		chbForedragsholder.setSelected(false);
		txfSpeciale.clear();
		txfFirmaNavn.clear();
		txfFirmaTlfNr.clear();
		chbLedsager.setSelected(false);
		txfLedsagerNavn.clear();
		dpAfrejseDato.setValue(null);
		dpAnkomstDato.setValue(null);
		
	}
	
	public void updateControls(){
		lvwKonferencer.getItems().setAll(Controller.getKonference());
		if (preTilmelding != null) {
			lvwKonferencer.getSelectionModel().select(preTilmelding.getKonference());
			Deltager deltager = preTilmelding.getDeltager();
			txfNavn.setText(deltager.getNavn());
			txfAdresse.setText(deltager.getAdresse());
			txfBy_Land.setText(deltager.getBy_Land());
			txfTlfNr.setText(deltager.getTlfNr());
			if (deltager.getClass() == Foredragsholder.class) {
				chbForedragsholder.setSelected(true);
				disableForedrag(false);
				Foredragsholder foredragsholder = (Foredragsholder)deltager;
				txfSpeciale.setText(foredragsholder.getSpeciale());
				for (Foredrag foredrag : foredragsholder.getForedrager()) {
					lvwForedrag.getSelectionModel().select(foredrag);
				}
			}
			dpAnkomstDato.setValue(preTilmelding.getAnkomstDato());
			dpAfrejseDato.setValue(preTilmelding.getAfrejseDato());
			txfFirmaNavn.setText(deltager.getFirmaNavn());
			txfFirmaTlfNr.setText(deltager.getFirmaTlfNr());
			if (preTilmelding.getLedsager() != null) {
				chbLedsager.setSelected(true);
				disableLedsager(false);
				txfLedsagerNavn.setText(preTilmelding.getLedsager().getNavn());
				for (Udflugt udflugt : preTilmelding.getLedsager().getUdlugter()) {
					lvwUdflugter.getSelectionModel().select(udflugt);
				}
			}
			lvwHoteller.getSelectionModel().select(preTilmelding.getHotel());
			for (TillægsService tillægsService : preTilmelding.getTillægsServices()) {
				lvwTillægsServices.getSelectionModel().select(tillægsService);
			}
			Button btnUpdate = new Button("Opdater");
			this.add(btnUpdate, 5, 8);
			btnUpdate.setOnAction(event -> this.tilmeldAction());
			
			btnTilmeld.setVisible(false);
		}
	}
}