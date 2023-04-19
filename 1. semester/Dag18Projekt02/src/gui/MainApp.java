package gui;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Yatzy;

public class MainApp extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Yatzy");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

	}

	// -------------------------------------------------------------------------

	// Shows the face values of the 5 dice.
	private TextField[] txfValues;
	// Shows the hold status of the 5 dice.
	private CheckBox[] chbHolds;
	// Shows the results previously selected .
	// For free results (results not set yet), the results
	// corresponding to the actual face values of the 5 dice are shown.
	private TextField[] txfResults;
	// Shows points in sums, bonus and total.
	private TextField txfSumSame, txfBonus, txfSumOther, txfTotal;
	// Shows the number of times the dice has been rolled.
	private Label lblRolled;

	private Label[] lblResults;

	private Button btnRoll;

	private boolean[] hold = { false, false, false, false, false };
	
	private int counter = 0;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);

		// ---------------------------------------------------------------------

		GridPane dicePane = new GridPane();
		pane.add(dicePane, 0, 0);
		dicePane.setGridLinesVisible(false);
		dicePane.setPadding(new Insets(10));
		dicePane.setHgap(10);
		dicePane.setVgap(10);
		dicePane.setStyle("-fx-border-color: black");

		// initialize txfValues, chbHolds, btnRoll and lblRolled
		// TODO
		txfValues = new TextField[5];
		chbHolds = new CheckBox[5];
		initValuesBox(dicePane);

		// ---------------------------------------------------------------------

		GridPane scorePane = new GridPane();
		pane.add(scorePane, 0, 1);
		scorePane.setGridLinesVisible(false);
		scorePane.setPadding(new Insets(10));
		scorePane.setVgap(5);
		scorePane.setHgap(10);
		scorePane.setStyle("-fx-border-color: black");
		int w = 50; // width of the text fields

		// Initialize labels for results, txfResults,
		// labels and text fields for sums, bonus and total.
		// TODO
		txfResults = new TextField[15];
		lblResults = new Label[15];
		initScoreBoxes(scorePane, w);

		btnRoll.setOnAction(event -> this.throwDice());
	}

	// -------------------------------------------------------------------------

	private Yatzy dice = new Yatzy();

	// Create a method for btnRoll's action.
	// Hint: Create small helper methods to be used in the action method.
	// TODO

	// -------------------------------------------------------------------------

	// Create a method for mouse click on one of the text fields in txfResults.
	// Hint: Create small helper methods to be used in the mouse click method.
	// TODO

	public void chooseFieldAction(Event event) {
		if (dice.getThrowCount() > 0) {
		TextField txt = (TextField) event.getSource(); 
		counter++;
		int temp = 0;
		for (int i = 0; i < txfResults.length; i++) {
			if ( txt.equals(txfResults[i])) {
				temp = i;
				txfResults[i].setDisable(true);
				
			}
			
		}
		if (temp < 6) {
			txfSumSame.setText("" + (Integer.parseInt(txfSumSame.getText()) + Integer.parseInt(txt.getText())));
		}
		else {
			txfSumOther.setText("" + (Integer.parseInt(txfSumOther.getText()) + Integer.parseInt(txt.getText())));
		}
		
		for (int i = 0; i < txfResults.length; i++) {
			if (!txfResults[i].isDisabled()) {
				txfResults[i].setText("0");
			}
		}
		
		dice.resetThrowCount();
		lblRolled.setText("Rolled: " + dice.getThrowCount());
		
		if (dice.getThrowCount() == 0) {
			btnRoll.setDisable(false);
			for (int i = 0; i < chbHolds.length; i++) {
				chbHolds[i].setDisable(true);
				chbHolds[i].setSelected(false);
				txfValues[i].setText("");
			}

		}
		if (Integer.parseInt(txfSumSame.getText()) >= 63){
			txfBonus.setText("50");
		}
		
		txfTotal.setText("" + (Integer.parseInt(txfSumSame.getText())
				+ Integer.parseInt(txfSumOther.getText())
				+ Integer.parseInt(txfBonus.getText())));
		
		if (counter == 15) {
			int score = Integer.parseInt(txfTotal.getText());
//			TimeUnit.SECONDS.sleep(2);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Game Over!");
            alert.setHeaderText("The Game is over, thanks for playing");
            alert.setContentText("Your score was: " + score);
            alert.showAndWait(); // most important part
            this.endProgram();

			
			
		}
		}
		
		
		
		
	}
	// Initialize Dice value box.
	private void initValuesBox(GridPane pane) {

		for (int i = 0; i < 5; i++) {
			txfValues[i] = new TextField();
			txfValues[i].setPrefSize(80, 80);
			txfValues[i].setAlignment(Pos.CENTER);
			txfValues[i].setStyle("-fx-font-size: 25");
			txfValues[i].setEditable(false);

			chbHolds[i] = new CheckBox();
			chbHolds[i].setText("Hold");
			chbHolds[i].setPadding(new Insets(0, 20, 20, 20));
			chbHolds[i].setDisable(true);
			pane.add(txfValues[i], i, 0);
			pane.add(chbHolds[i], i, 1);
		}
		this.btnRoll = new Button();
		this.btnRoll.setText("Roll");
		this.btnRoll.setPrefSize(80, 60);
		this.btnRoll.setStyle("-fx-font-size: 25");
		pane.add(btnRoll, 3, 3);
		lblRolled = new Label("Rolled: " + dice.getThrowCount());
		pane.add(lblRolled, 4, 3);
	}

	// Initialize score box
	private void initScoreBoxes(GridPane pane, int width) {
		String[] lblNames = { "1-s", "2-s", "3-s", "4-s", "5-s", "6-s", "One Pair", "Two Pairs", "Three-Of-A-Kind",
				"Four-Of-A-Kind", "Full House", "Small Straight", "Large Straight", "Chance", "Yatzy" };

		for (int i = 0; i < lblNames.length; i++) {
			lblResults[i] = new Label(lblNames[i]);

			txfResults[i] = new TextField();
			txfResults[i].setPrefWidth(width);
			txfResults[i].setOnMouseClicked(event -> this.chooseFieldAction(event));
			txfResults[i].setEditable(false);
			pane.add(lblResults[i], 0, i);
			pane.add(txfResults[i], 1, i);
		}

		Label sumSame = new Label("Sum:");
		Label sumOther = new Label("Sum:");
		Label bonus = new Label("Bonus");
		Label total = new Label("Total");

		txfSumSame = new TextField();
		txfBonus = new TextField();
		txfSumOther = new TextField();
		txfTotal = new TextField();

		txfSumOther.setPrefWidth(width);
		txfSumSame.setPrefWidth(width);
		txfTotal.setPrefWidth(width);
		txfBonus.setPrefWidth(width);
		
		txfSumOther.setEditable(false);
		txfSumSame.setEditable(false);
		txfTotal.setEditable(false);
		txfBonus.setEditable(false);

		txfSumOther.setText("0");
		txfSumSame.setText("0");
		txfTotal.setText("0");
		txfBonus.setText("0");

		pane.add(sumSame, 2, 5);
		pane.add(txfSumSame, 3, 5);
		pane.add(bonus, 4, 5);
		pane.add(txfBonus, 5, 5);
		pane.add(sumOther, 2, 14);
		pane.add(txfSumOther, 3, 14);
		pane.add(total, 4, 14);
		pane.add(txfTotal, 5, 14);
	}

	private void throwDice() {
		
		this.isSelected();
		dice.throwDice(hold);
		int[] tempValues = dice.getValues();
		for (int i = 0; i < txfValues.length; i++) {
			txfValues[i].setText("" + tempValues[i]);
			lblRolled.setText("Rolled: " + dice.getThrowCount());

		}
		if (dice.getThrowCount() == 3) {
			btnRoll.setDisable(true);
		}
		
		int[] tempResults = dice.getResults();
		
		for (int i = 0; i < txfResults.length; i++) {
			if (!txfResults[i].isDisable()) {
			txfResults[i].setText("" + tempResults[i]);}
		}
		
		if (dice.getThrowCount() != 0) {
			for (int i = 0; i < chbHolds.length; i++) {
					chbHolds[i].setDisable(false);
				}
		}
		this.isSelected();

	}

	private void isSelected() {
		if ( dice.getThrowCount() == 0) {
			for (int i = 0; i < txfValues.length; i++) {
				hold[i] = false;
			}
		}
		for (int i = 0; i < txfValues.length; i++) {
			if (chbHolds[i].isSelected()) {
				hold[i] = true;
				chbHolds[i].setDisable(true);
			}
		}
	}
	
	private void endProgram() {
	
    Platform.exit();
	}
}
