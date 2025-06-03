package iut.gon.gribouille_tp1.controleurs;

import javafx.scene.input.MouseEvent;

public abstract class Outil {
	protected Controleur controller;
	
	public Outil(Controleur controller) {
		this.controller = controller;
	}
	
	public abstract void onMousePress(MouseEvent evt);
	public abstract void onMouseDrag(MouseEvent evt);
}
