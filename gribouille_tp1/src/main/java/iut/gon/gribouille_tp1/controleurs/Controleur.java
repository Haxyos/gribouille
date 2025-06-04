package iut.gon.gribouille_tp1.controleurs;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import iut.gon.gribouille_tp1.Dialogues;
import iut.gon.gribouille_tp1.modele.Dessin;
import iut.gon.gribouille_tp1.modele.Figure;
import iut.gon.gribouille_tp1.modele.Point;
import iut.gon.gribouille_tp1.modele.Trace;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import iut.gon.gribouille_tp1.modele.Etoile;

public class Controleur implements Initializable{
	public final Dessin dessin = new Dessin();
	public Figure figure;
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
	@FXML
	public RadioMenuItem Crayon;
	@FXML
	public RadioMenuItem Etoile;
	@FXML
	public ToggleGroup Epaisseur;
	@FXML
	public ToggleGroup outils;
	
	
	public Outil outil = new OutilCrayon(this);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		menusController.setController(this);
		dessinController.setController(this);
		couleursController.setController(this);
		statusController.setController(this);
		statusController.outil.setText("Crayon");
		statusController.couleur.textProperty().bind(couleur.asString());
		statusController.nbEpaisseur.textProperty().bind(epaisseur.asString());
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
		for (Figure f : dessin.getFigures()) {
			for (int c = 1; c < f.getPoints().size(); c++) {
				dessinController.canvas.getGraphicsContext2D().setLineWidth(f.getEpaisseur());
				if (f instanceof Trace) {
					dessinController.canvas.getGraphicsContext2D().strokeLine(f.getPoints().get(c-1).getX(), f.getPoints().get(c-1).getY(), f.getPoints().get(c).getX(), f.getPoints().get(c).getY());
				}
				else if(f instanceof Etoile) {
					dessinController.canvas.getGraphicsContext2D().strokeLine(f.getPoints().get(0).getX(), f.getPoints().get(0).getY(), f.getPoints().get(c).getX(), f.getPoints().get(c).getY());
				}
				
			}
		}
	}
	
	public void onCrayon() {
		statusController.outil.setText("Crayon");
		outil = new OutilCrayon(this);
	}
	
	public void onEtoile() {
		statusController.outil.setText("Etoile");
		outil = new OutilEtoile(this);
	}

	public void setEpaisseur(int epaisseur) {
		this.epaisseur.set(epaisseur);
		dessinController.setEpaisseur(epaisseur);
	}
	
}
