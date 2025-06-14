package iut.gon.gribouille_tp1.controleurs;

import java.lang.ModuleLayer.Controller;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import iut.gon.gribouille_tp1.modele.Dessin;
import iut.gon.gribouille_tp1.modele.Figure;
import iut.gon.gribouille_tp1.modele.Point;
import iut.gon.gribouille_tp1.modele.Trace;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class DessinController implements Initializable{

	
    @FXML
    public Pane interfaceCanva;

    @FXML
    public Canvas canvas;
    
    private Controleur controller;

	public void setController(Controleur controleur) {
		this.controller = controleur;
	}
	
	public void setCouleur(Color color) {
		canvas.getGraphicsContext2D().setStroke(color);
	}
	
	
	
	public void efface() {
		canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	public void trace(double x1, double y1, double x2, double y2) {
		canvas.getGraphicsContext2D().strokeLine(x1, y1, x2, y2);
	}

	
	public void onMousePressed(MouseEvent evt) {
		controller.outil.onMousePress(evt.getX(), evt.getY());
	}
	
	public void onMouseDragged(MouseEvent evt) {
		controller.outil.onMouseDrag(evt.getX(), evt.getY());
	}

	public void onMouseMoved(MouseEvent evt) {
		controller.statusController.nbX.setText(evt.getX()+"");
		controller.statusController.nbY.setText(evt.getY()+"");
	}
	
	public void setEpaisseur(int epaisseur) {
		canvas.getGraphicsContext2D().setLineWidth(epaisseur);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		canvas.widthProperty().bind(interfaceCanva.widthProperty());
		canvas.heightProperty().bind(interfaceCanva.heightProperty());
		
	}
}
