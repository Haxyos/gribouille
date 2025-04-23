package iut.gon.tp3;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private GrilleModel model;
    private static GrilleController controlleur;
    
    @Override
    public void start(Stage stage) throws IOException {
    	model = new GrilleModel();
        controlleur = new GrilleController(model);
        scene = new Scene(loadFXML("sceneTp3"), 640, 480);
        stage.setScene(scene);
        stage.show();
        stage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
        	switch (event.getText()) {
        	case "1" : model.setCase(2,0, new SimpleStringProperty("Touche")); break;
        	case "2" : model.setCase(2,1, new SimpleStringProperty("Touche")); break;
        	case "3" : model.setCase(2,2, new SimpleStringProperty("Touche")); break;
        	case "4" : model.setCase(1,0, new SimpleStringProperty("Touche")); break;
        	case "5" : model.setCase(1,1, new SimpleStringProperty("Touche")); break;
        	case "6" : model.setCase(1,2, new SimpleStringProperty("Touche")); break;
        	case "7" : model.setCase(0,0, new SimpleStringProperty("Touche")); break;
        	case "8" : model.setCase(0,1, new SimpleStringProperty("Touche")); break;
        	case "9" : model.setCase(0,2, new SimpleStringProperty("Touche")); break;
        	}
        	});
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        fxmlLoader.setController(controlleur);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}