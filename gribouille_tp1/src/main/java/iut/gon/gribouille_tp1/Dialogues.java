package iut.gon.gribouille_tp1;

import java.util.Optional;

import iut.gon.gribouille_tp1.controleurs.Controleur;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Dialogues {
	public static boolean confirmation(Controleur controller) {
			      Alert sorti = new Alert(Alert.AlertType.CONFIRMATION);
			      sorti.setContentText("Do you want to leave without saving ?");
			      
			      ButtonType annuler = new ButtonType("Annuler", ButtonType.CANCEL.getButtonData());
			      ButtonType quitter = new ButtonType("Quitter", ButtonType.NO.getButtonData());
			      ButtonType sauvegardeQuitte = new ButtonType("Sauvegarder et quitter", ButtonType.OK.getButtonData());

			        
			      sorti.getButtonTypes().addAll(annuler, quitter, sauvegardeQuitte);
			      sorti.getButtonTypes().remove(0);
			      sorti.getButtonTypes().remove(0);
			      
			      Optional<ButtonType> resultat = sorti.showAndWait();
			      
			      if (resultat.orElse(annuler) == sauvegardeQuitte) {
			    	  return controller.sauvegarde();
			      }
			      else if(resultat.orElse(annuler) == quitter) {
			    	  return true;
			      }
		return false;
	}
}
