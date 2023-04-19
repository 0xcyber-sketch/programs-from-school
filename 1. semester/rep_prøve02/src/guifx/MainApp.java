package guifx;



import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Forestilling;
import model.Kunde;
import model.Plads;
import storage.Storage;


public class MainApp extends Application {

	@Override
	public void init() {
		Controller.init();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("FPS");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------
	private ListView<Forestilling> lvwForestillinger;
	private ListView<Kunde> lvwKunder;
	private TextArea txaPladser; 
	private TextField txfDato;
	private TextField txfKundeNavn;
	private TextField txfKundeMobil;
	private Label lblError;
	
	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);
		
		VBox box1 = new VBox();
		pane.add(box1, 0, 0);
		VBox box2 = new VBox();
		pane.add(box2, 1, 0);


		
		Label lblForestillinger = new Label("Forestillinger");
		box1.getChildren().add(lblForestillinger);
		
		lvwForestillinger = new ListView<>();
		box1.getChildren().add(lvwForestillinger);
		lvwForestillinger.setPrefSize(200, 200);
		lvwForestillinger.getItems().setAll(storage.Storage.getForstilllinger());
		
		

//		
		Label lblkunder = new Label("Kunder");
		box2.getChildren().add(lblkunder);
		lvwKunder = new ListView<>();
		box2.getChildren().add(lvwKunder);
		lvwKunder.setPrefSize(200, 200);
		ChangeListener<Kunde> listener = (ov, o, n) -> this.kunderItemSelected();
		lvwKunder.getSelectionModel().selectedItemProperty().addListener(listener);
		lvwKunder.getItems().setAll(storage.Storage.getKunder());
		
//		Listener
		
		
		
		Label lbldato = new Label("Dato");
		VBox box3 = new VBox();
		TextField txfDato = new TextField();
		pane.add(box3,2, 0);
		box3.getChildren().add(lbldato);
		Button btnPladser = new Button("Vis bestilte pladser");
//		btnCancel.setOnAction(event -> this.cancelAction());
		box3.getChildren().add(txfDato);
		box3.getChildren().add(btnPladser);
		Label lblPladser = new Label("Bestilte pladser");
		box3.getChildren().add(lblPladser);
		txaPladser = new TextArea();
		txaPladser.setEditable(false);
		box3.getChildren().add(txaPladser);
		box3.setPrefWidth(200);
		
		Label lblKundeNavn = new Label ("Kunde navn:");
		box2.getChildren().add(lblKundeNavn);
		txfKundeNavn = new TextField();
		box2.getChildren().add(txfKundeNavn);
		Label lblKundeMobil = new Label ("Kunde mobil");
		box2.getChildren().add(lblKundeMobil);
		txfKundeMobil = new TextField();
		box2.getChildren().add(txfKundeMobil);
		
		Button btnOpret = new Button("Opret Kunde");
		btnOpret.setOnAction(event -> this.createKunde());
		box2.getChildren().add(btnOpret);
		
	
	}
	
	
	private void kunderItemSelected() {
		this.updateControls();
	}
	
	private void updateControls() {
		Kunde kunde = lvwKunder.getSelectionModel().getSelectedItem();
		
		if (kunde != null) {
			StringBuilder sb1 = new StringBuilder();
			
			for (Plads p : Controller.getKundesPladser(kunde)) {
				sb1.append("" + p + "\n");
			}
			
			txaPladser.setText(sb1.toString());
			
		}
	}
	
	private void createKunde() {
		String navn = txfKundeNavn.getText().trim();
		String mobil = txfKundeMobil.getText().trim();
		Controller.createKunde(navn, mobil);
		txfKundeNavn.clear();
		txfKundeMobil.clear();
		lvwKunder.getItems().setAll(Storage.getKunder());

		
		
		
		
	}
	
	
		
	}

//}
