package guifx;


import application.controller.Controller;
import application.model.Company;
import application.model.Customer;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import storage.Storage;

public class CustomerViewWindow extends Stage {
	private Company company;
	private ListView<Customer> lvwCustomers;

	public CustomerViewWindow(String title, Company company) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.company = company;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public CustomerViewWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private Label lblError;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblName = new Label("Customers");
		pane.add(lblName, 0, 0);
		

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 4);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 4);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());

		lblError = new Label();
		pane.add(lblError, 0, 5);
		lblError.setStyle("-fx-text-fill: red");
		
		lvwCustomers = new ListView<>();
		pane.add(lvwCustomers, 0, 0);
		lvwCustomers.setPrefSize(200, 200);
		lvwCustomers.getItems().setAll(Storage.getCustomers());
		
		//To select multiple elements in a list
		lvwCustomers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
	}



	// -------------------------------------------------------------------------

	private void cancelAction() {
		this.hide();
		 

	}

	private void okAction() {
		//To capture the elements selected
		ObservableList<Customer> selectedIndices = lvwCustomers.getSelectionModel().getSelectedItems();
		
		for (Company c : Controller.getCompanies()) {
			for (Customer cos: selectedIndices) {
				if (c.getCustomers().contains(cos)) {
					Controller.removeCustomerFromCompany(cos, c);
					Controller.addCustomerToCompany(cos, company);
				}
			}
			
		}
		
		

		
	
		
			
			
 
			this.hide();
		}

		
	}


