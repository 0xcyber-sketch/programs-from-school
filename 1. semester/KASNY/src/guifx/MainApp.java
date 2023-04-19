package guifx;


import application.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	
	@Override
	public void init() {
		Controller.init();
	}

	 public void start(Stage stage) {
		 stage.setTitle("Konference administrations system");
			BorderPane pane = new BorderPane();
			this.initContent(pane);

			Scene scene = new Scene(pane);
			stage.setScene(scene);
			stage.show();
	 }
	// -------------------------------------------------------------------------
	 
	 private void initContent(BorderPane pane) {
			TabPane tabPane = new TabPane();
			this.initTabPane(tabPane);
			pane.setCenter(tabPane);
			tabPane.getSelectionModel().select(0);
		}
	 private void initTabPane(TabPane tabPane) {
			tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

			Tab tabAdministration = new Tab("Administration");
			tabPane.getTabs().add(tabAdministration);

			AdministrationPane administrationPane = new AdministrationPane(tabPane);
			tabAdministration.setContent(administrationPane);
			tabAdministration.setOnSelectionChanged(event -> administrationPane.updateControls());

			Tab tabTilmed = new Tab("Tilmelding");
			tabPane.getTabs().add(tabTilmed);
			
			TilmeldPane tilmeldPane = new TilmeldPane();
			tabTilmed.setContent(tilmeldPane);
			tabTilmed.setOnSelectionChanged(event -> tilmeldPane.updateControls());
			
			Tab tabOversigt = new Tab("Oversigter");
			tabPane.getTabs().add(tabOversigt);

			OversigtPane oversigtPane = new OversigtPane();
			tabOversigt.setContent(oversigtPane);
			tabOversigt.setOnSelectionChanged(event -> oversigtPane.updateControls());
			
			
		}
	 
	
	 
	 }


