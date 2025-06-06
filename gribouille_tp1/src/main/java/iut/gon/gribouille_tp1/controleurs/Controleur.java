package iut.gon.gribouille_tp1.controleurs;

import java.io.File;
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
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
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

	public boolean onQuitter(Controleur controller) {
		if (Dialogues.confirmation(controller)) {
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
				dessinController.canvas.getGraphicsContext2D().setStroke(Color.web(f.getCouleur()));
				if (f instanceof Trace) {
					dessinController.canvas.getGraphicsContext2D().strokeLine(f.getPoints().get(c-1).getX(), f.getPoints().get(c-1).getY(), f.getPoints().get(c).getX(), f.getPoints().get(c).getY());
				}
				else if(f instanceof Etoile) {
					Etoile e = (Etoile)f;
					dessinController.canvas.getGraphicsContext2D().strokeLine(e.getCentre().getX(),e.getCentre().getY(), f.getPoints().get(c).getX(), f.getPoints().get(c).getY());
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
	
	public void setCouleur(Color color) {
		this.couleur.set(color);
		dessinController.setCouleur(color);
	}
	
	public void onKeyPressed(String cle) {
    	switch (cle.toLowerCase()) {
    	case "r":
    		this.setCouleur(Color.RED);
    		figure = figure.changeCouleur(couleur.get().toString());
    		dessin.addFigure(figure);
    		break;
    	case "v":
    		this.setCouleur(Color.GREEN);
    		figure = figure.changeCouleur(couleur.get().toString());
    		dessin.addFigure(figure);
    		break;
    	case "b":
    		this.setCouleur(Color.BLUE);
    		figure = figure.changeCouleur(couleur.get().toString());
    		dessin.addFigure(figure);
    		break;
    	case "j":
    		this.setCouleur(Color.YELLOW);
    		figure = figure.changeCouleur(couleur.get().toString());
    		dessin.addFigure(figure);
    		break;
    	case "o":
    		this.setCouleur(Color.PINK);
    		figure = figure.changeCouleur(couleur.get().toString());
    		dessin.addFigure(figure);
    		break;
    	case "n":
    		this.setCouleur(Color.BLACK);
    		figure = figure.changeCouleur(couleur.get().toString());
    		dessin.addFigure(figure);
    		break;
    	case "w":
    		this.setCouleur(Color.WHITE);
    		figure = figure.changeCouleur(couleur.get().toString());
    		dessin.addFigure(figure);
    		break;
    	case "c":
    		this.onCrayon();
    		break;
    	case "e":
    		
    		this.onEtoile();
    		break;
    	case "+":
    		this.setEpaisseur(this.epaisseur.getValue() + 1);
    		figure = figure.changeEpaisseur(epaisseur.getValue());
    		dessin.addFigure(figure);
    		break;
    	case "-":
    		if(this.epaisseur.getValue() > 1) {
    			this.setEpaisseur(this.epaisseur.getValue() - 1);
    			figure = figure.changeEpaisseur(epaisseur.getValue());
    			dessin.addFigure(figure);
        		break;
    		}
    		else {
    			break;
    		}
    		
    	}
    	
    		
    	
    }

	public boolean sauvegarde() {
		FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sauvegarder le dessin");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Dessin", "*.grb")
        );
        Stage stage = (Stage) dessinController.canvas.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            dessin.sauveSous(file.getAbsolutePath());
            dessin.setNomDuFichier("Gribouille - " + file.getName());
            return true;
        }
        return false;
		
	}

	public void charge() {
		FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Charger un dessin");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("dessin", "*.grb")
        );
        Stage stage = (Stage) dessinController.canvas.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            dessin.charge(file.getAbsolutePath());
            dessin.setNomDuFichier(file.getName());
            redessine();
        }
		
	}
	
}
