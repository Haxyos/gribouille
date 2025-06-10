package iut.gon.gribouille_tp1.controleurs;

import iut.gon.gribouille_tp1.modele.Figure;
import javafx.scene.input.MouseEvent;

public abstract class Outil {
	protected Controleur controller;
	protected Figure figureCourante;
	
	public Outil(Controleur controller) {
		this.controller = controller;
	}
	
	public abstract void onMousePress(double x, double y);
	public abstract void onMouseDrag(double x, double y);
}
