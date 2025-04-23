package iut.gon.tp3;

import javafx.beans.property.SimpleStringProperty;

public class GrilleModel {
	private SimpleStringProperty tab[][];
	
	public GrilleModel() {
		this.tab = new SimpleStringProperty[3][3];
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				this.tab[l][c] = new SimpleStringProperty(String.format("L%dC%d", l, c));
			}
		}
	}
	
	public SimpleStringProperty getCase(int lg, int col) {
		return tab[lg][col];
	}
	
	public void setCase(int lg, int col, SimpleStringProperty texte) {
		this.tab[lg][col] = texte;
	}
}
