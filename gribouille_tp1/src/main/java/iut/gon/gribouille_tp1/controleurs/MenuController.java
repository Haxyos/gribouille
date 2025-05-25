package iut.gon.gribouille_tp1.controleurs;

import java.lang.ModuleLayer.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class MenuController {

    @FXML
    public ToggleGroup Epaisseur;

    @FXML
    public ToggleGroup outil;
    
    private Controller controller;

	public void setController(Controller controller) {
		this.controller = controller;
	}
}
