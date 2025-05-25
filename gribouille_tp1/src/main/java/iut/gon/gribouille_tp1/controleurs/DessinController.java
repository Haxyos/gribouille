package iut.gon.gribouille_tp1.controleurs;

import java.lang.ModuleLayer.Controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

public class DessinController {

    @FXML
    public Pane interfaceCanva;

    @FXML
    public Canvas canvas;
    
    private Controller controller;

	public void setController(Controller controller) {
		this.controller = controller;
	}
}
