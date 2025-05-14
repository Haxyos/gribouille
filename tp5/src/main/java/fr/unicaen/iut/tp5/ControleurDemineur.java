package fr.unicaen.iut.tp5;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


public class ControleurDemineur implements Initializable{

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
		difficulter.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if(difficulter.getSelectedToggle() != null) {
					String[] tab = initGrille(difficulter.getSelectedToggle().getUserData());
					modele = new ModeleDemineur(Integer.parseInt(tab[0]), Integer.parseInt(tab[1]), Integer.parseInt(tab[2]));
					nbMarques.setText(String.valueOf(modele.getNbMarques()));
					nbInconnue.setText(String.valueOf(modele.getNbInconnues()));
					
					
				}
				
			}
			
		});
		nbMarques.setText(String.valueOf(modele.getNbMarques()));
		nbInconnue.setText(String.valueOf(modele.getNbInconnues()));
		
	}
	
	public String[] initGrille(Object userData) {
		gridPane.getColumnConstraints().clear();
		gridPane.getRowConstraints().clear();
		gridPane.getColumnConstraints().addAll(new ColumnConstraints(32));
		gridPane.getRowConstraints().addAll(new RowConstraints(32));
		String userDataString = (String)userData;
		String[] tab;
		tab = userDataString.split(";");
		return tab;
	}

}






