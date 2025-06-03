package iut.gon.gribouille_tp1.controleurs;

import java.lang.ModuleLayer.Controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Rectangle;

public class CouleursController implements Initializable{
    
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
