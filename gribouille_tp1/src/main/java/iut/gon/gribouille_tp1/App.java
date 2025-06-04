package iut.gon.gribouille_tp1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
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
    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("CadreGribouille.fxml"));
        Parent loader = fxmlLoader.load();
    	Controleur controleur = fxmlLoader.getController();
    	Dessin dessin = controleur.getDessin();
    	stage.setTitle(dessin.getNomDuFichier());
        scene = new Scene(loader, 640, 480);
        stage.setScene(scene);
        stage.show();
        stage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
        
			@Override
			public void handle(KeyEvent event) {
				controleur.onKeyPressed(event.getText());
				
			}
        	
        });
        this.onFerme(stage, controleur);
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