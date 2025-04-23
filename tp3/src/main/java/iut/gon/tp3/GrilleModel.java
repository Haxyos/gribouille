package iut.gon.tp3;

public class GrilleModel {
	private String tab[][];
	
	public GrilleModel() {
		this.tab = new String[3][3];
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				this.tab[l][c] = String.format("L%dC%d", l, c);
			}
		}
	}
	
	public String getCase(int lg, int col) {
		return tab[lg][col];
	}
	
	public void setCase(int lg, int col, String texte) {
		this.tab[lg][col] = texte;
	}
}
