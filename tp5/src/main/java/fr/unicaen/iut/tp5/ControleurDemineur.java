package fr.unicaen.iut.tp5;

import java.awt.Insets;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class ControleurDemineur implements Initializable {

	private ModeleDemineur modele;

	@FXML
	private RadioMenuItem Facile;

	@FXML
	private ToggleGroup difficulter;

	@FXML
	private RadioMenuItem Moyen;

	@FXML
	private RadioMenuItem Difficile;

	@FXML
	private TextField nbInconnue;

	@FXML
	private TextField nbMarques;

	@FXML
	private GridPane gridPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.modele = new ModeleDemineur(0, 0, 0);
		nbMarques.textProperty().bind(modele.nbMarquesProperty().asString());
		nbInconnue.textProperty().bind(modele.nbInconnuesProperty().asString());
		difficulter.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (difficulter.getSelectedToggle() != null) {
					initGrille(difficulter.getSelectedToggle().getUserData());
				}

			}

		});

		
	}

	public void initGrille(Object userData) {
		gridPane.getColumnConstraints().clear();
		gridPane.getRowConstraints().clear();
		int tab[] = ModeleDemineur.parseUserData((String) userData);
		modele = new ModeleDemineur(tab[0], tab[1], tab[2]);
		nbMarques.textProperty().bind(modele.nbMarquesProperty().asString());
		nbInconnue.textProperty().bind(modele.nbInconnuesProperty().asString());
		for (int i = 0; i < tab[1]; i++) {
			gridPane.getRowConstraints().add(new RowConstraints(32));
		}
		for (int j = 0; j < tab[0]; j++) {
			gridPane.getColumnConstraints().add(new ColumnConstraints(32));
		}
		
		
		Background inconnue = new Background(new BackgroundFill(Color.AQUA, new CornerRadii(20), null));
		Background libre = new Background(new BackgroundFill(Color.LIGHTGRAY, null, null));
		Background echec = new Background(new BackgroundFill(Color.RED, null, null));
		Background marquer = new Background(new BackgroundFill(Color.LEMONCHIFFON, null, null));

		for (int l = 0; l < tab[0]; l++) {
			for (int c = 0; c < tab[1]; c++) {
				Label label = new Label();
				label.setPrefSize(31, 31);
				label.setBackground(inconnue);
				label.setText("?");
				label.setTextAlignment(TextAlignment.CENTER);
				int xi = l;
				int yi = c;
				label.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if(modele.estPerdu()) {
							event.consume();
						}
						else {
							if (event.getButton() == (MouseButton.PRIMARY)) {
								modele.revele(xi, yi);
								label.setText(modele.getText(xi, yi));
								if (modele.estPerdu() == true) {
									label.setBackground(echec);
								}
								else {
									label.setBackground(libre);
									}
								}
							else if (event.getButton() == (MouseButton.SECONDARY)) {
								if (modele.estMarquee(xi, yi)) {
									label.setBackground(inconnue);
									label.setText("?");
								}
								else {
									modele.marque(xi, yi);
									label.setBackground(marquer);
									label.setText("P");
									
								}
								
								
							}
						}

					}
				});
				gridPane.add(label, l, c);
			}
		}
		
	}

}
