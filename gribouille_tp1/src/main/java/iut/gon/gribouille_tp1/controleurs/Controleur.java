package iut.gon.gribouille_tp1.controleurs;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import iut.gon.gribouille_tp1.Dialogues;
import iut.gon.gribouille_tp1.modele.Dessin;
import iut.gon.gribouille_tp1.modele.Figure;
import iut.gon.gribouille_tp1.modele.Point;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controleur implements Initializable{
	public final Dessin dessin = new Dessin();
	public Figure figure;
	public Outil outil = new OutilCrayon(this);
	public final SimpleDoubleProperty precX = new SimpleDoubleProperty();
	public final SimpleDoubleProperty precY = new SimpleDoubleProperty();
	public final SimpleObjectProperty<Color> couleur = new SimpleObjectProperty<Color>(Color.BLACK);
	public final SimpleIntegerProperty epaisseur = new SimpleIntegerProperty(1);
	
	@FXML
	public MenuController menusController;
	@FXML
	public DessinController dessinController;
	@FXML
	public CouleursController couleursController;
	@FXML
	public StatutController statusController;

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		menusController.setController(this);
		dessinController.setController(this);
		dessinController.setDessin(dessin);
		couleursController.setController(this);
		statusController.setController(this);
		dessinController.canvas.heightProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				redessine();
				
			}
			
		});
		dessinController.canvas.widthProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				redessine();
				
			}
			
		});
		
		
	}

	public boolean onQuitter(Stage stage) {
		if (Dialogues.confirmation(stage)) {
			return true;
		}
		return false;
	}
	
	public Dessin getDessin() {
		return dessin;
		
	}
	
	public void redessine() {
		dessinController.canvas.getGraphicsContext2D().clearRect(0, 0, dessinController.canvas.getWidth(), dessinController.canvas.getHeight());
		List<Figure> figures = dessin.getFigures();
		for (int l = 0; l < figures.size(); l++) {
			List<Point> point = figures.get(l).getPoints();
			for (int c = 0; c < point.size()-1; c++) {
				Point point1 = point.get(c);
				Point point2 = point.get(c+1);
				dessinController.canvas.getGraphicsContext2D().strokeLine(point1.getX(), point1.getY(), point2.getX(), point2.getY());
			}
		}
	}

}
