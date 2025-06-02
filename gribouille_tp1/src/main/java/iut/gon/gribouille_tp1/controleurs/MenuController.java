package iut.gon.gribouille_tp1.controleurs;

import java.lang.ModuleLayer.Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class MenuController {

    @FXML
    public ToggleGroup Epaisseur;

    @FXML
    public ToggleGroup outil;
    
    private Controleur controller;

	public void setController(Controleur controleur) {
		this.controller = controleur;
	}
	
	public void onQuitte() {
		
		
		if (controller.onQuitter(null)) {
			Platform.exit();
		}
	}
}
