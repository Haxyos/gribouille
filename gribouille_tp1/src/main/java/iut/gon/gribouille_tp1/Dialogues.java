package iut.gon.gribouille_tp1;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Dialogues {
	public static boolean confirmation(Stage stage) {
			      Alert sorti = new Alert(AlertType.CONFIRMATION);
			      sorti.setContentText("Are you sure ?");
			      sorti.getButtonTypes().add(ButtonType.YES);
			      sorti.getButtonTypes().add(ButtonType.NO);
			      sorti.getButtonTypes().remove(0);
			      sorti.getButtonTypes().remove(0);
			      if (sorti.showAndWait().orElse(ButtonType.YES) == ButtonType.YES) {
			    	  return true;
			      }
		return false;
	}
}
