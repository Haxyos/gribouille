package iut.gon.tp3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class GrilleController implements Initializable{
	private @FXML GridPane grille;
	private Label label[][];
	public static int max = 1000;
	
	public void initialize(URL url, ResourceBundle resource){
		this.label = new Label[3][3];
		grille.setStyle("-fx-background-color: seashell");
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				label[l][c] = new Label(String.format("L%dC%d", l, c));
				label[l][c].setMaxSize(max, max);
				label[l][c].setAlignment(Pos.CENTER);
				grille.add(label[l][c], c, l);
				label[l][c].addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						((Label)event.getSource()).setText("Bonjour");;
						
						
					}
					
				});;
			}
		}
	}
}
