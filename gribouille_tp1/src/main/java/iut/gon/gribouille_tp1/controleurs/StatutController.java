package iut.gon.gribouille_tp1.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class StatutController implements Initializable{


    @FXML
    public Label nbX;

    @FXML
    public Label nbY;

    @FXML
    public Label nbEpaisseur;

    private Controleur controller;

	public void setController(Controleur controleur) {
		this.controller = controleur;
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	



}
