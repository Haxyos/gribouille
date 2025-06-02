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

public class DessinController {

	private SimpleDoubleProperty prevX;
	private SimpleDoubleProperty prevY;
	private Trace trace;
	private Dessin dessin;
	
    @FXML
    public Pane interfaceCanva;

    @FXML
    public Canvas canvas;
    
    private Controleur controller;

	public void setController(Controleur controleur) {
		this.controller = controleur;
	}
	
	public void setDessin(Dessin dessin) {
    	this.dessin = dessin;
    }

	
	
	
	public void redessine() {
		canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		List<Figure> figures = dessin.getFigures();
		for (int l = 0; l < figures.size(); l++) {
			List<Point> point = figures.get(l).getPoints();
			for (int c = 0; c < point.size()-1; c++) {
				Point point1 = point.get(c);
				Point point2 = point.get(c+1);
				canvas.getGraphicsContext2D().strokeLine(point1.getX(), point1.getY(), point2.getX(), point2.getY());
			}
		}
	}
	
	public void efface() {
		canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	public void trace(double x1, double y1, double x2, double y2) {
		canvas.getGraphicsContext2D().strokeLine(x1, y1, x2, y2);
	}


	public DessinController(){
		this.prevX = new SimpleDoubleProperty();
		this.prevY = new SimpleDoubleProperty();
		canvas.heightProperty().bind(interfaceCanva.heightProperty());
		canvas.widthProperty().bind(interfaceCanva.widthProperty());
		canvas.heightProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				redessine();
				
			}
			
		});
		canvas.widthProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				redessine();
				
			}
			
		});
		canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				prevX.set(event.getSceneX());
				prevY.set(event.getSceneY());				
			}
		
			
		});
		
	}
}
