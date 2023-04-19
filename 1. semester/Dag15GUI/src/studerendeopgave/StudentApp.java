package studerendeopgave;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StudentApp extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Administrer studerende");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final TextField txfName1 = new TextField();
	private final CheckBox chkActive = new CheckBox();
	private final TextArea txAInf = new TextArea();
	private final TextField txfName2 = new TextField();

	private final Button btnAdd = new Button("Opret");
	private final Button btnSave = new Button("Gem");
	private final Button btnGet = new Button("Hent");
	private final Button btnDelete = new Button("Slet");
	private final Button btnBirthday = new Button("Fødselsdag");
	

	private Student studerende = null;

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		txAInf.setEditable(false);
		txAInf.setPrefWidth(220);
		txAInf.setPrefHeight(60);
		pane.add(txAInf, 0, 0, 8, 1);

		Label lblName = new Label("Navn");
		pane.add(lblName, 0, 1);
		Label lblActive = new Label("Aktiv");
		pane.add(lblActive, 0, 3);
		Label lblAge = new Label("Alder");
		pane.add(lblAge, 0, 2);
		
		// Text field name
		pane.add(txfName1, 1, 1, 7, 1);
		
		// text field age
		pane.add(txfName2, 1, 2, 2, 1);

		// check active
		pane.add(chkActive, 1, 3);

		// add a buttons to the pane

		// add button
		pane.add(btnAdd, 0, 5);
		
		// save button
		btnSave.setDisable(true);
		pane.add(btnSave, 1, 5);
		
		// get button
		btnGet.setDisable(true);
		pane.add(btnGet, 2, 5);
		
		// delete button 
		pane.add(btnDelete, 3, 5);
		btnDelete.setDisable(true);

		
		// increase age button 
		
		pane.add(btnBirthday, 3,2,5,1);
		btnBirthday.setDisable(true);
		//btnBirthday.prefWidth(200);
		
		// connect a method to the button

		btnAdd.setOnAction(event -> this.addAction());
		btnSave.setOnAction(event -> this.saveAction());
		btnGet.setOnAction(event -> this.getAction());
		btnDelete.setOnAction(event -> this.deleteAction());
		btnBirthday.setOnAction(event -> this.increaseAge());

	}

	private void addAction() {
		if (studerende == null) {
			studerende = new Student(txfName1.getText().trim(), Integer.parseInt(txfName2.getText().trim()), chkActive.isSelected());
			clearFields();
			txAInf.setText(getDescription());
			btnGet.setDisable(false);
			btnAdd.setDisable(true);

		}

	}

	private void saveAction() {
		if (studerende != null) {
			studerende.setName(txfName1.getText().trim());
			studerende.setActive(chkActive.isSelected());
			studerende.setAge(studerende.getAge());
			clearFields();
			txAInf.setText(getDescription());
			btnSave.setDisable(true);
			btnDelete.setDisable(true);
			btnGet.setDisable(false);
			btnBirthday.setDisable(true);


		}

	}

	private void getAction() {
		if (studerende != null) {
			txfName1.setText(studerende.getName());
			txfName2.setText(""+ studerende.getAge());
			chkActive.setSelected(studerende.isActive());
			txAInf.setText(getDescription());
			btnSave.setDisable(false);
			btnDelete.setDisable(false);
			btnGet.setDisable(true);
			btnBirthday.setDisable(false);


		}

	}

	private void deleteAction() {
		if (studerende != null) {
			studerende = null;
			clearFields();
			txAInf.clear();
			btnDelete.setDisable(true);
			btnSave.setDisable(true);
			btnGet.setDisable(true);
			btnAdd.setDisable(false);
			btnBirthday.setDisable(true);

		}

	}

	private void clearFields() {
		txfName1.clear();
		txfName2.clear();
		chkActive.setSelected(false);
	}

	private String getDescription() {
		String result = "Ingen studerende gemt";
		if (studerende != null) {
			result = studerende.toString();
		}
		return result;
	}
	
	private void increaseAge() {
		studerende.increaseAge();
		
	}

}
