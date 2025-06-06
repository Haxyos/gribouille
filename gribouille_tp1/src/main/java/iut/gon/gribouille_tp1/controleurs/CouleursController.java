package iut.gon.gribouille_tp1.controleurs;

import java.lang.ModuleLayer.Controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CouleursController implements Initializable{
    
	@FXML 
	public VBox Vbox;
	
    @FXML
    public ColorPicker colorPicker;

    @FXML
    public TilePane tilePane;
    
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
		Vbox.setOnMouseClicked(event ->{
					for(Node n : tilePane.getChildren()) {
						if (n instanceof Rectangle) {
							Rectangle r = (Rectangle) n;
							r.setArcHeight(5);
							r.setArcWidth(5);
							r.setStrokeWidth(1);
						}
						
					}
					if (event.getTarget() instanceof Rectangle) {
						Rectangle rectangleChoisi = (Rectangle) event.getTarget();
						controller.setCouleur((Color) rectangleChoisi.getFill());
						rectangleChoisi.setArcWidth(10);
						rectangleChoisi.setArcHeight(10);
						rectangleChoisi.setStrokeWidth(5);
					}
		});

	}
}
