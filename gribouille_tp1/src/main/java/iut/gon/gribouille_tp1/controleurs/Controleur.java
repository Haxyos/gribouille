package iut.gon.gribouille_tp1.controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import iut.gon.gribouille_tp1.Dialogues;
import iut.gon.gribouille_tp1.modele.Dessin;
import iut.gon.gribouille_tp1.modele.Figure;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controleur implements Initializable{
	public final Dessin dessin = new Dessin();
	public Figure figure;
	public final SimpleDoubleProperty precX = new SimpleDoubleProperty();
	public final SimpleDoubleProperty precY = new SimpleDoubleProperty();
	public final SimpleObjectProperty<Color> couleur = new SimpleObjectProperty<Color>(Color.BLACK);
	public final SimpleIntegerProperty epaisseur = new SimpleIntegerProperty(1);
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		MenuController menusController = new MenuController();
		StatutController statutController = new StatutController();
		DessinController dessinController = new DessinController();
		CouleursController couleursController = new CouleursController();
		menusController.setController(this);
		statutController.setController(this);
		dessinController.setController(this);
		couleursController.setController(this);
	}

	public boolean onQuitter(Stage stage) {
		boolean conf;
		stage.setOnCloseRequest(event-> {
        	conf = Dialogues.confirmation(stage);
        	if (!conf) {
        		event.consume();
        	}
        });	
		return conf;
	}
}
