package iut.gon.gribouille_tp1.controleurs;

import java.lang.ModuleLayer.Controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

public class MenuController implements Initializable{

    @FXML
    public ToggleGroup Epaisseur;

    @FXML
    public ToggleGroup outils;
    
    @FXML
    public RadioMenuItem Crayon;
    
    @FXML
    public RadioMenuItem Etoile;
    
    private Controleur controller;

	public void setController(Controleur controleur) {
		this.controller = controleur;
	}
	
	public void onQuitte() {
		if (controller.onQuitter(null)) {
			Platform.exit();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		outils.selectedToggleProperty().addListener((observableValue, oldValue, newValue) -> {
			if (newValue != null) {
				String nom = ((RadioMenuItem) newValue).getId();
				
				if(nom.equals("Etoile")) {
					controller.onEtoile();
				}
				else if(nom.equals("Crayon")) {
					controller.onCrayon();
				}
			}
		});
		
		Epaisseur.selectedToggleProperty().addListener((observableValue, oldValue, newValue) -> {
			if (newValue != null) {
				String nb = ((RadioMenuItem) newValue).getText();
				controller.epaisseur.set(Integer.parseInt(nb));
				controller.setEpaisseur(Integer.parseInt(nb));
			}
		});
	}
}
