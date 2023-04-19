package gui;


import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
	private TextField[] txfValues = new TextField[5];
	// Shows the hold status of the 5 dice.
	private CheckBox[] chbHolds = new CheckBox[5];
	// Shows the results previously selected .
	// For free results (results not set yet), the results
	// corresponding to the actual face values of the 5 dice are shown.
	private TextField[] txfResults = new TextField[15];
	// Shows points in sums, bonus and total.
	private TextField txfSumSame, txfBonus, txfSumOther, txfTotal;
	// Shows the number of times the dice has been rolled.
	private Label lblRolled;

	private Button btnRoll = new Button("Roll");

	private Label[] lblResults = new Label[15];

	private String[] lblStringName = { "1-s", "2-s", "3-s", "4-s", "5-s", "6-s", "One Pair", "Two Pairs",
			"Three-Of-A-Kind", "Four-Of-A-Kind", "Full House", "Small Straight", "Large Straight", "Chance", "Yatzy" };

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
		for (int i = 0; i < 5; i++) { // Loop that runs 5 times and creates chbHolds + txfValues.
			chbHolds[i] = new CheckBox(); // Creates new chbHolds[i] CheckBox.
			chbHolds[i].setText("Hold"); // Sets chbHolds[i] text to "Hold".
			txfValues[i] = new TextField(); // Creates new txfValues[i] TextField.
			txfValues[i].setPrefSize(80, 80); // Sets txfValues[i] size to 80x80.
			txfValues[i].setStyle("-fx-font-size: 25"); // Sets txfValues[i] font size to 25.
			dicePane.add(txfValues[i], i, 0); // Adds txfValues[i] to dicePane at (col: i, row: 0)
			dicePane.add(chbHolds[i], i, 1); // Adds chbHolds[i] to dicePane at (col: i, row: 1)
			chbHolds[i].setDisable(true); // Disables chbHolds[i]
			txfValues[i].setEditable(false); // Disables the ability to edit txfValues[i].
		}
		dicePane.add(btnRoll, 3, 2);
		btnRoll.setPrefSize(50, 40);
		btnRoll.setStyle("-fx-font-size: 15");

		lblRolled = new Label("Rolled " + dice.getThrowCount());
		dicePane.add(lblRolled, 4, 2);
		
		btnRoll.setOnAction(event -> this.throwDice());

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
		for (int i = 0; i < lblResults.length; i++) { // Runs trough the length of lblNames and creates txfResults & lblResults.
			lblResults[i] = new Label(); // Makes new lblResults[i] Label.
			scorePane.add(lblResults[i], 0, i); // Adds lblResults[i] to scorePane at (col: 0 row: i).
			lblResults[i].setText(lblStringName[i]); // Sets text of lblResults[i] to lblStringName[i].
			txfResults[i] = new TextField(); 
			scorePane.add(txfResults[i], 1, i);
			txfResults[i].setPrefWidth(w);
			txfResults[i].setOnMouseClicked(event -> this.chooseFieldAction(event)); // Sets setOnMouseClicked action to this.chooseFieldAction.
			txfResults[i].setEditable(false); // Disables the ability to edit txfResults.
		}
		// Label & TextField for Sum.
		Label lblSum = new Label("Sum"); // Sets lblSum Text to "Sum".
		scorePane.add(lblSum, 2, 5); // Adds lblSum to scorePane at (col: 2, row: 5).
		txfSumSame = new TextField(); // Makes new TextField txfSumSame.
		scorePane.add(txfSumSame, 3, 5); // Adds txfSumSame to scorePane at (col: 3, row: 5)
		txfSumSame.setPrefWidth(w); // Sets txfSumSame with to variable w.
		txfSumSame.setText("0"); // Sets txfSumSame text to "0".
		txfSumSame.setEditable(false); // Disables the ability to edit txfSumSame.
		// Label & TextField for Bonus
		Label lblBonus = new Label("Bonus");
		scorePane.add(lblBonus, 4, 5);
		txfBonus = new TextField();
		scorePane.add(txfBonus, 5, 5);
		txfBonus.setPrefWidth(w);
		txfBonus.setText("0");
		txfBonus.setEditable(false);
		// Label & TextField for SumOther
		Label lblSumOther = new Label("Sum");
		scorePane.add(lblSumOther, 2, 14);
		txfSumOther = new TextField();
		scorePane.add(txfSumOther, 3, 14);
		txfSumOther.setPrefWidth(w);
		txfSumOther.setText("0");
		txfSumOther.setEditable(false);
		// Label & TextField for Total
		Label lblTotal = new Label("Total");
		scorePane.add(lblTotal, 4, 14);
		txfTotal = new TextField();
		scorePane.add(txfTotal, 5, 14);
		txfTotal.setPrefWidth(w);
		txfTotal.setText("0");
		txfTotal.setEditable(false);

	}

	// -------------------------------------------------------------------------

	private Yatzy dice = new Yatzy();
	private boolean[] holds = { false, false, false, false, false };
	private int count; //counter to keep track of how many txfResults that have been chosen.

	/*
	 * Method to throwDice. 
	 */
	private void throwDice() {
		this.isSelected();
		dice.throwDice(holds);
		this.updateThrowCount();
		this.disableRollBtn();
		this.fillTxfValues();
		this.fillTxfResults();
		this.enableChbBoxes();
		this.isSelected();
	}

	/*
	 * Method that checks if a chbHolds is selected.
	 */
	private void isSelected() {
		for (int i = 0; i < chbHolds.length; i++) { // runs trough chbHolds array
			if (chbHolds[i].isSelected()) { // checks if chbHolds[i] is selected. If true, updates holds[] array at [i] position to true and disables checkBox.
				holds[i] = true;
				chbHolds[i].setDisable(true);
			}
		}
	}

	/*
	 * Method that updates lblRolled.
	 */
	private void updateThrowCount() {
		lblRolled.setText("Rolled " + dice.getThrowCount());
	}

	/*
	 * Method that enables chbBoxes.
	 * Condition: throwCount != 0
	 */
	private void enableChbBoxes() {
		if (dice.getThrowCount() != 0) {
			for (int i = 0; i < chbHolds.length; i++) {
				chbHolds[i].setDisable(false);
			}
		}
	}

	/*
	 * Method that fills txfValues with dice.getValues().
	 */
	private void fillTxfValues() {
		int[] values = dice.getValues();
		for (int i = 0; i < txfValues.length; i++) {
			txfValues[i].setText("" + values[i]);
		}
	}
	
	/*
	 * Method that disables the roll button.
	 * Condition: dice.ThrowCount == 3
	 */
	private void disableRollBtn() {
		if (dice.getThrowCount() == 3) {
			btnRoll.setDisable(true);
		}
	}

	/*
	 * Method that fills txfResults with dice.getResults().
	 */
	private void fillTxfResults() {
		this.enableTxfResultsAction(); 
		int[] results = dice.getResults();
		for (int i = 0; i < txfResults.length; i++) {
			if (!txfResults[i].isDisabled()) {
				txfResults[i].setText("" + results[i]);
			}	
		}
	}
	
	/**
	 * Method to enable setOnMouseClicked on txfResults when a new round starts. Doesn't enable on txfResults that already have been chosen.
	 */
	private void enableTxfResultsAction() {
		for (int i = 0; i < txfResults.length; i++) { // Runs trough txfResults[].  
			if (!txfResults[i].isDisabled()) { // If txfResults[i] hasen't been disabled, sets onMouseClickedAction.
				txfResults[i].setOnMouseClicked(event -> this.chooseFieldAction(event));
			}
		}
	}

	/*
	 * Method that resets round.
	 */
	private void resetRound() {
		for (int i = 0; i < txfValues.length; i++) {
			txfValues[i].setText("0");
			chbHolds[i].setSelected(false);
			chbHolds[i].setDisable(true);
			holds[i] = false;
		}
	}
	/*
	 * Method to alert player that the game has ended.
	 */
	private void alertGameOver() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Game is over");
		alert.setHeaderText("The game has ended");
		alert.setContentText("You scored: " + txfTotal.getText()+ "." + " If you want to play agian press OK");
		alert.show();
	}
	
	/*
	 * Method to reset the game.
	 */
	private void resetGame() {
		for (int i = 0; i < txfResults.length; i++) {
			txfResults[i].setDisable(false);
			txfResults[i].setText("0");
			txfResults[i].setStyle("-fx-text-fill: black");
		}
		for (int j = 0; j < txfValues.length; j++) {
			txfValues[j].setText("0");
		}
		txfBonus.setText("0");
		txfTotal.setText("0");
		txfSumOther.setText("0");
		txfSumSame.setText("0");
		dice.resetThrowCount();
		count = 0;
	}

	// -------------------------------------------------------------------------

	/*
	 * Method to choose given txfResults point.
	 */
	public void chooseFieldAction(Event event) {
		TextField txt = (TextField) event.getSource();
		count++; 
		int temp = 0;
		for (int i = 0; i < txfResults.length; i++) { // Runs trough length of txfResults[]
			if (txt.equals(txfResults[i])) { // If txt equals txfResults[i] set temp = i, disable txfResults[i] and run disableRemainingTxfResults.
				temp = i;
				txfResults[i].setDisable(true);
				txfResults[i].setStyle("-fx-text-fill: blue");;
				this.disableRemainingTxfResults();
			}
		}
		if (temp < 6) { 
			txfSumSame.setText("" + (Integer.parseInt(txfSumSame.getText()) + Integer.parseInt(txt.getText()))); // setsctxfSumSame to txfSumSame+txt.
			txfTotal.setText("" + (Integer.parseInt(txfSumSame.getText()) + Integer.parseInt(txfSumOther.getText()))); // sets txfTotal to txfSumSame + txfSumOther
		} else {
			txfSumOther.setText("" + (Integer.parseInt(txfSumOther.getText()) + Integer.parseInt(txt.getText()))); // sets txfSumOther to txfSumOther+txt
			txfTotal.setText("" + (Integer.parseInt(txfSumSame.getText()) + Integer.parseInt(txfSumOther.getText()))); // sets txfTotal to txfSumSame + txfSumOther

		}
		dice.resetThrowCount();
		this.updateThrowCount();
		if (dice.getThrowCount() == 0) { // if throwCount == 0 enable btnRoll and reset round.
			btnRoll.setDisable(false);
			this.resetRound();
		}
		this.checkBonus();
		if (count == 15) { // if count == 15 then all txfResults has been chosen and the game is over. Runs alertGameOver and resetGame.
			this.alertGameOver();
			this.resetGame();
		}
	}
	
	/**
	 * Method to disable setOnMouseClicked on txfResults after player has chosen which results he wants to add to his score.
	 */
	private void disableRemainingTxfResults() {
		for (int i = 0; i < txfResults.length; i ++) {
			if (!txfResults[i].isDisabled()) {
				txfResults[i].setOnMouseClicked(null);
			}
		}
	}
	
	/*
	 * Method that checks if txfSumSame is higher or equal to 63.
	 */
	private void checkBonus() {
		if (Integer.parseInt(txfSumSame.getText()) >= 63) {
			txfBonus.setText("50");
		}
		txfTotal.setText("" + (Integer.parseInt(txfSumSame.getText()) + Integer.parseInt(txfSumOther.getText())
		+ Integer.parseInt(txfBonus.getText())));
	}

}
