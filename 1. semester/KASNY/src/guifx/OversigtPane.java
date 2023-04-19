package guifx;

import application.controller.Controller;
import application.model.Konference;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class OversigtPane extends GridPane {
	private ListView<Konference> lvwKonferencer;
	private TextArea txaDeltagere, txaUdflugter, txaHoteller;
	private Konference selected;

	public OversigtPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblKonference = new Label("Konferencer:");
		this.add(lblKonference, 0, 0);

		lvwKonferencer = new ListView<>();
		this.add(lvwKonferencer, 0, 1, 1, 3);
		lvwKonferencer.setPrefSize(200, 200);

		ChangeListener<Konference> listener = (ov, oldKonference, newKonference) -> this.selectedKonferenceChanged();
		lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblDeltagere = new Label("Deltagere:");
		this.add(lblDeltagere, 1, 0);

		txaDeltagere = new TextArea();
		this.add(txaDeltagere, 1, 1, 1, 1);
		txaDeltagere.setPrefSize(400, 200);
		txaDeltagere.setEditable(false);

		Label lblUdflugter = new Label("Udflugter:");
		this.add(lblUdflugter, 1, 2);

		txaUdflugter = new TextArea();
		this.add(txaUdflugter, 1, 3, 1, 1);
		txaUdflugter.setPrefSize(400, 200);
		txaUdflugter.setEditable(false);

		Label lblHoteller = new Label("Hoteller:");
		this.add(lblHoteller, 3, 0);

		txaHoteller = new TextArea();
		this.add(txaHoteller, 3, 1, 1, 3);
		txaHoteller.setPrefSize(400, 200);
		txaHoteller.setEditable(false);

	}

	private void selectedKonferenceChanged() {
		Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
		if (konference != null) {
			selected = konference;

			txaDeltagere.setText(Controller.deltagerOversigt(konference));
			txaUdflugter.setText(Controller.udflugtOversigt(konference));
			txaHoteller.setText(Controller.hotelOversigt(konference));

		}
	}

	public void updateControls() {
		lvwKonferencer.getItems().setAll(Controller.getKonference());
		txaDeltagere.clear();
		txaHoteller.clear();
		txaUdflugter.clear();
		if (lvwKonferencer.getItems().contains(selected)) {
			lvwKonferencer.getSelectionModel().select(selected);
		}

	}

}
