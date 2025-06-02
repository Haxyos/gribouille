package iut.gon.gribouille_tp1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

import iut.gon.gribouille_tp1.controleurs.Controleur;
import iut.gon.gribouille_tp1.modele.Dessin;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private double prevX;
    private double prevY;
    @Override
    public void start(Stage stage) throws IOException {
    	Dessin dessin = new Dessin();
    	Controleur controleur = new Controleur();
    	stage.setTitle(dessin.getNomDuFichier());
        scene = new Scene(loadFXML("CadreGribouille", dessin), 640, 480);
        stage.setScene(scene);
        stage.show();
        this.onFerme(stage, controleur);
    }

    static void setRoot(String fxml, Dessin dessin) throws IOException {
        scene.setRoot(loadFXML(fxml, dessin));
    }

    private static Parent loadFXML(String fxml, Dessin dessin) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent loader = fxmlLoader.load();
        Controller c = fxmlLoader.getController();
        c.setDessin(dessin);
        return loader;
    }

    public void onFerme(Stage stage, Controleur controleur) {
    	stage.setOnCloseRequest(event-> {
        	boolean conf = controleur.onQuitter(stage);
        	if (!conf) {
        		event.consume();
        	}
        });	
    }
    
    public static void main(String[] args) {
        launch();
    }

}