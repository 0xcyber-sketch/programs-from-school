package guifx;

import application.controller.Controller;
import application.model.Festival;
import application.model.Frivillig;
import application.model.Job;
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
import javafx.stage.Stage;


public class MainApp extends Application {

	@Override
	public void init() {
		Controller.init();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("FAS");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------
	private TextField txfTimer;
	private ListView<Festival> lvwFestivaler;
	private ListView<Job> lvwJobs;
	private ListView<Frivillig> lvwFrivillige;
	private TextArea txaTildelteJobs; 
	private Label lblError;
	
	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);
		
		Label lblFestivaler = new Label("Festivaler");
		pane.add(lblFestivaler, 0, 0);
		
		lvwFestivaler = new ListView<>();
		pane.add(lvwFestivaler, 0, 1);
		lvwFestivaler.setPrefSize(200, 200);
		lvwFestivaler.getItems().setAll(storage.Storage.getFestivaler());
		
		ChangeListener<Festival> listener = (ov, o, n) -> this.FestivalItemSelected();
		lvwFestivaler.getSelectionModel().selectedItemProperty().addListener(listener);
		
		Label lblJobs = new Label("Jobs");
		
		pane.add(lblJobs, 1, 0);
		lvwJobs = new ListView<>();
		pane.add(lvwJobs, 1, 1);
		lvwJobs.setPrefSize(200, 200);
		
		Label lblFrivillige = new Label("Frivillige");
		pane.add(lblFrivillige, 2, 0);
		lvwFrivillige = new ListView<>();
		pane.add(lvwFrivillige, 2, 1);
		lvwFrivillige.setPrefSize(200, 200);
		
		Label lblUddelteJobs = new Label("Tildelte jobs ");
		pane.add(lblUddelteJobs, 3, 0);
		
		txaTildelteJobs = new TextArea();
		pane.add(txaTildelteJobs, 3, 1);
		
		Label lblTimer = new Label("Timer");
		pane.add(lblTimer, 0, 2);
		txfTimer = new TextField();
		txfTimer.setPrefWidth(80);
		pane.add(txfTimer, 1, 2);
		
		Button btnTagVagt = new Button("Tag vagt");
		pane.add(btnTagVagt, 2, 2);
		btnTagVagt.setOnAction(event -> this.tagVagt());
		
		lblError = new Label();
		pane.add(lblError, 2, 3);
		lblError.setStyle("-fx-text-fill: red");
		
		
	}
	
	private void FestivalItemSelected() {
		Festival selected = lvwFestivaler.getSelectionModel().getSelectedItem();
		
//		lvwFrivillige.getItems().
		
	}
	
	private void tagVagt() {
		try {
		int temp = Integer.parseInt(txfTimer.getText().trim());
		
//		Controller.tagVagt(job, frivillig, temp);
		
		}
		catch (Exception e) {
			lblError.setText("Timer er ikke et tal");
			System.out.println("Timer er ikke et tal");
		}
		
	}

}
