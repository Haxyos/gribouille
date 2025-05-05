package iut.gon.tp4;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

public class MenusController {

	private GrilleModel modele;
	private Scores table;
	private @FXML GridPane grille;
	
	@FXML
	  public void onMenuNouvelle(ActionEvent evt) {
	    modele.nouvellePartie();
	  }

	@FXML
	  public void onMenuTable(ActionEvent evt) throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(Scores.class.getResource("table.fxml"));
		 fxmlLoader.load();
		 Parent root = fxmlLoader.getRoot();
		 TableController controller = fxmlLoader.getController();
		 controller.setScores(table);
		 grille.getScene().setRoot(root);
	  }

	@FXML
	public void onMenuQuitter(ActionEvent evt) {
		Platform.exit();
	}

	public void setParams(GrilleModel model, Scores table) {
		this.modele = model;
		this.table = table;
	}
}
