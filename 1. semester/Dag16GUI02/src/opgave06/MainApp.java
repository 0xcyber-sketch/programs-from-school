package opgave06;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	// Start Application
	@Override
	public void start(Stage stage) {
		stage.setTitle("Student Quiz Scores");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		

	}

	private final ListView<String> lvwQuestions = new ListView<>();
	private final ListView<String> lvwAnswers = new ListView<>();
	private final ArrayList<String> answers = new ArrayList<>();
	private final ArrayList<String> questions = new ArrayList<>();

	private void initContent(GridPane pane) {
		this.arrayToList();
		// show or hide grid lines
		pane.setGridLinesVisible(false);
		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);
		
		// Add listView Students
		pane.add(lvwQuestions, 0, 1);
		lvwQuestions.setPrefWidth(200);
		lvwQuestions.setPrefHeight(200);
		lvwQuestions.getItems().setAll(questions);
		
		// Add listView answers
		pane.add(lvwAnswers, 1, 1);
		lvwAnswers.setPrefWidth(200);
		lvwAnswers.setPrefHeight(200);
		lvwAnswers.getItems().setAll(answers);
		
		// Student label
		Label lblStudent = new Label();
		lblStudent.setText("Students");
		pane.add(lblStudent, 0, 0);
		
		Label lblAnswers = new Label();
		lblAnswers.setText("Answers");
		pane.add(lblAnswers, 1, 0);
		
		
		

	}
	// Pane.setStyle("-fx-background-color: #ffffff;")
	private void arrayToList(){
		MultipleChoice mc = new MultipleChoice(10);
		
		for (int i = 0; i < mc.correctAnswersPrStudent().length; i++) {
			
			questions.add("Student " + (i + 1) + ": " + mc.correctAnswersPrStudent()[i] + " points");
		}
		for (int i = 0; i < mc.correctAnswerPrQuestion().length; i++) {
			
			answers.add("Answer " + (i + 1) + ": " + mc.correctAnswerPrQuestion()[i] + " Correct");
		}
		

		
	}
}
