package iut.gon.gribouille_tp1;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import iut.gon.gribouille_tp1.modele.Dessin;
import iut.gon.gribouille_tp1.modele.Figure;
import iut.gon.gribouille_tp1.modele.Point;
import iut.gon.gribouille_tp1.modele.Trace;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
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

	private SimpleDoubleProperty prevX;
	private SimpleDoubleProperty prevY;
	private Trace trace;
	private Dessin dessin;
	
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

    public void setDessin(Dessin dessin) {
    	this.dessin = dessin;
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
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
				nbX.setText(prevX.getValue()+"");
				nbY.setText(prevY.getValue()+"");
				
			}
		
			
		});
	}
	
	public void onMousePressed(MouseEvent evt) {
		this.prevX.set(evt.getX()); 
    	this.prevY.set(evt.getY());
    	this.trace = new Trace(1, "black", prevX.getValue(), prevY.getValue());
    	dessin.addFigure(trace);
	}
	
	public void onMouseDragged(MouseEvent evt) {
		canvas.getGraphicsContext2D().strokeLine(prevX.getValue(), prevY.getValue(), evt.getX(), evt.getY());
    	trace.addPoint(evt.getX(), evt.getY());
    	this.prevX.set(evt.getX());
    	this.prevY.set(evt.getY());
    	nbX.setText(prevX.getValue()+"");
		nbY.setText(prevY.getValue()+"");
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
	

}
