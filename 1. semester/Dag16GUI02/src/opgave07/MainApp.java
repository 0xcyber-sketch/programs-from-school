package opgave07;

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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
		stage.setHeight(300);
		stage.setWidth(300);
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
		
		
		TabPane tabPane = new TabPane();
		Tab tab = new Tab();
		tab.setText("Students");
		//tab.setContent(new Rectangle(200,200, Color.LIGHTSTEELBLUE));
		tabPane.getTabs().add(tab);
		
		
		Tab tab2 = new Tab();
		tab2.setText("Answers");
		//tab2.setContent(new Rectangle(200,200, Color.RED));
		tabPane.getTabs().add(tab2);
		
		pane.add(tabPane, 1, 0);
		
		// Add listView Students
		tab.setContent(lvwQuestions);
		lvwQuestions.setPrefWidth(200);
		lvwQuestions.setPrefHeight(200);
		lvwQuestions.getItems().setAll(questions);
		
		
		
		
		
		// Add listView answers
		tab2.setContent(lvwAnswers);
		lvwAnswers.setPrefWidth(200);
		lvwAnswers.setPrefHeight(200);
		lvwAnswers.getItems().setAll(answers);
		
		// Student label
//		Label lblStudent = new Label();
//		lblStudent.setText("Students");
//		pane.add(lblStudent, 0, 0);
//		
//		Label lblAnswers = new Label();
//		lblAnswers.setText("Answers");
//		pane.add(lblAnswers, 1, 0);
//		
//		
		

	}
	
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
