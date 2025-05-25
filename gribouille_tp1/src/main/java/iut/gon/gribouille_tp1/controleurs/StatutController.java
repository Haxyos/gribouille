package iut.gon.gribouille_tp1.controleurs;

import java.lang.ModuleLayer.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class StatutController {

    @FXML
    public BorderPane borderPane;

    @FXML
    public Label nbX;

    @FXML
    public Label nbY;

    @FXML
    public Label nbEpaisseur;

    private Controller controller;

	public void setController(Controller controller) {
		this.controller = controller;
	}
}
