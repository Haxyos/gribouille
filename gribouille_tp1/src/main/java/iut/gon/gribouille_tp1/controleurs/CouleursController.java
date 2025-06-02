package iut.gon.gribouille_tp1.controleurs;

import java.lang.ModuleLayer.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Rectangle;

public class CouleursController {
    
    @FXML
    public ColorPicker colorPicker;

    @FXML
    public Rectangle carreRouge;

    @FXML
    public Rectangle carreVert;

    @FXML
    public Rectangle carreBleuFonce;

    @FXML
    public Rectangle carreCyan;

    @FXML
    public Rectangle carreMagenta;

    @FXML
    public Rectangle carreJaune;

    @FXML
    public Rectangle carreNoir;

    @FXML
    public Rectangle carreBlanc;

    private Controleur controller;

	public void setController(Controleur controleur) {
		this.controller = controleur;
	}
}
