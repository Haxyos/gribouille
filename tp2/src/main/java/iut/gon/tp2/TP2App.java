package iut.gon.tp2;

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

public class TP2App extends Application {

  private BorderPane contenu;
  private ListView<String> gauche;
  private ListView<String> droite;
  private Button versGauche;
  private Button versDroite;
  private Button retireTout;
  private Button ajouteTout;

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(TP2App.class.getResource("Tp2.fxml"));
    contenu = fxmlLoader.load();
    Scene scene = new Scene(contenu);
    extraitIds(scene);

    prepareMenus((MenuBar) scene.lookup("#menus"));
    prepareListe();
    prepareBoutons();
    prepareFermeture(stage);

    stage.setTitle("Gestion de groupe");
    stage.setScene(scene);
    stage.show();
  }

  /** Prépare la fenêtre pour demander confirmation avant fermeture */
  private void prepareFermeture(Stage stage) {
    stage.setOnCloseRequest(event -> {
      //TODO confirmer ou consommer l'événement
    });
  }

  /** Prépare les actions des boutons */
  private void prepareBoutons() {
    ajouteTout.setOnAction(this::onAjouteTout);
    retireTout.setOnAction(this::onRetireTout);
    ajouteTout.setDisable(false);
    versDroite.setOnAction(this::onAjouteUn);
    versGauche.setOnAction(this::onRetireUn);
    // TODO actions des deux boutons centraux
    
  }

  private void onAjouteUn(ActionEvent actionEvent) {
				int index = gauche.getSelectionModel().getSelectedIndex();
				if (index != -1) {
					droite.getItems().add(gauche.getItems().get(index));
					gauche.getItems().remove(index);
					droite.getSelectionModel().clearSelection();
				}
  }
  
  private void onRetireUn(ActionEvent actionEvent) {
				int index = droite.getSelectionModel().getSelectedIndex();
				if (index != -1) {
					gauche.getItems().add(droite.getItems().get(index));
					droite.getItems().remove(index);
					gauche.getSelectionModel().clearSelection();
				}
			}
  /** Ajoute tous les éléments de gauche dans la liste de droite
   Active le bouton "Retirer tout" et désactive le bouton "Ajouter tout" */
  private void onAjouteTout(ActionEvent actionEvent) {
    droite.getItems().addAll(gauche.getItems());
    gauche.getItems().clear();
    ajouteTout.setDisable(true);
    retireTout.setDisable(false);
  }

  /** Ajoute tous les éléments de droite dans la liste de gauche
   Active le bouton "Ajouter tout" et désactive le bouton "Retirer tout" */
  private void onRetireTout(ActionEvent actionEvent) {
    gauche.getItems().addAll(droite.getItems());
    droite.getItems().clear();
    retireTout.setDisable(true);
    ajouteTout.setDisable(false);
  }

  /** Prépare les menus et leurs événements */
  private void prepareMenus(MenuBar menus) {
	  Menu menu_Fichiers = new Menu("_Fichiers");
	  Menu menu_Aide = new Menu("_Aide");
	  menus.getMenus().addAll(menu_Fichiers);
	  menus.getMenus().addAll(menu_Aide);
	  MenuItem menuItem_Quitter = new MenuItem("Quitter");
	  MenuItem menuItem_Apropos = new MenuItem("A propos");
	  menu_Fichiers.getItems().add(menuItem_Quitter);
	  menu_Aide.getItems().add(menuItem_Apropos);
	  menuItem_Quitter.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {
			Platform.exit();
			
		}
		  
	  });
	  menuItem_Apropos.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			Alert apropos = new Alert(AlertType.NONE, "Bonjour", ButtonType.CLOSE);
			apropos.setTitle(STYLESHEET_CASPIAN);
			apropos.show();
			
		}
		  
	  });
  }

  /**
   Remplit la liste de gauche avec des valeurs
   Active le bouton "Ajouter tout"
   */
  private void prepareListe() {
	String e1 = new String("Lukas");
	String e2 = new String("pue");
    gauche.getItems().add(e1);
    gauche.getItems().add(e2);
  }

  private void extraitIds(Scene scene) {
    gauche = (ListView<String>) scene.lookup("#gauche");
    droite = (ListView<String>) scene.lookup("#droite");
    versGauche = (Button) scene.lookup("#versGauche");
    versDroite = (Button) scene.lookup("#versDroite");
    retireTout = (Button) scene.lookup("#retireTout");
    ajouteTout = (Button) scene.lookup("#ajouteTout");
  }

  public static void main(String[] args) {
    launch();
  }
}
