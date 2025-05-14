package fr.unicaen.iut.tp5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {

  private BorderPane contenu;

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("Demineur.fxml"));
    contenu = fxmlLoader.load();
    Scene scene = new Scene(contenu);
    stage.setScene(scene);
    stage.show();
  }



  public static void main(String[] args) {
    launch();
  }
}
