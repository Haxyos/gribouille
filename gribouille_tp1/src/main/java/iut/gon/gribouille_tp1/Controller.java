package iut.gon.gribouille_tp1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Controller implements Initializable{

	private double prevX;
	private double prevY;
	
    @FXML
    private BorderPane borderPane;

    @FXML
    private ToggleGroup Epaisseur;

    @FXML
    private ToggleGroup outil;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Rectangle carreRouge;

    @FXML
    private Rectangle carreVert;

    @FXML
    private Rectangle carreBleuFonce;

    @FXML
    private Rectangle carreCyan;

    @FXML
    private Rectangle carreMagenta;

    @FXML
    private Rectangle carreJaune;

    @FXML
    private Rectangle carreNoir;

    @FXML
    private Rectangle carreBlanc;

    @FXML
    private Label nbX;

    @FXML
    private Label nbY;

    @FXML
    private Label nbEpaisseur;

    @FXML
    private Pane interfaceCanva;

    @FXML
    private Canvas canvas;

    public void setDessin(Canvas dessin) {
    	this.canvas = dessin;
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		canvas.heightProperty().bind(interfaceCanva.heightProperty());
		canvas.widthProperty().bind(interfaceCanva.widthProperty());
		
	}
	
	public void onMousePressed(MouseEvent evt) {
		this.prevX = evt.getX();
    	this.prevY = evt.getY();
	}
	
	public void onMouseDragged(MouseEvent evt) {
		canvas.getGraphicsContext2D().strokeLine(prevX, prevY, evt.getX(), evt.getY());
    	this.prevX = evt.getX();
    	this.prevY = evt.getY();
	}

}
