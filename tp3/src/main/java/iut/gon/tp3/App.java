package iut.gon.tp3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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