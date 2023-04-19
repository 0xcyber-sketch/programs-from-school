package opgave03;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonInformationWindow extends Stage {

    public PersonInformationWindow( Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle("Add Person");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final CheckBox checkBox = new CheckBox();
    

    private Person actualPerson = null;

    private void initContent(GridPane pane) {
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        
        Label lblName = new Label("Name:");
		pane.add(lblName, 0, 0);

		// Add name field
		pane.add(txfName, 1, 0, 2, 1);

		// Add label in 0 col row 1

		Label lblTitle = new Label("Title:");
		pane.add(lblTitle, 0, 1);

		// Add title field
		pane.add(txfTitle, 1, 1, 2, 1);
		
		checkBox.setText("Senior");
		pane.add(checkBox, 0, 2);
		
		


        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 3);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.TOP_RIGHT);

        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());
    }

    // -------------------------------------------------------------------------
    // Button actions
    /*
    private void addAction(){
		String name = txfName.getText().trim();
		
		String title = txfTitle.getText().trim();
		
		if (name.length() > 0 && title.length() > 0) {
			if (checkBox.isSelected()){
				senior = true;
			}
			else {
				senior = false;
			}
			Person p = new Person(name, title, senior);
			persons.add(p);
			lvwPersons.getItems().setAll(persons);
		
		}*/		

    private void cancelAction() {
        txfTitle.clear();
        txfTitle.requestFocus();
        txfName.clear();
        actualPerson = null;
        PersonInformationWindow.this.hide();
    }

    private void okAction() {
        String title = txfTitle.getText().trim();
        String name = txfName.getText().trim();
        boolean senior = checkBox.isSelected();

        if (title.length() > 0 && name.length() > 0) {
        	
        	 
            actualPerson = new Person(name, title, senior);
            txfTitle.clear();
            txfName.clear();
            txfTitle.requestFocus();
            PersonInformationWindow.this.hide();
            checkBox.setSelected(false);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
//            alert.setTitle("Create movie");
            alert.setHeaderText("Information missing");
            alert.setContentText("Type title and name");
            alert.show();
        }
    }

    // -------------------------------------------------------------------------

    
    public Person getActualPerson() {
        return actualPerson;
    }

    public void clearActualPerson() {
        actualPerson = null;
    }
    
}
