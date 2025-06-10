package iut.gon.gribouille_tp1.controleurs;

import iut.gon.gribouille_tp1.modele.Trace;
import javafx.scene.input.MouseEvent;

public class OutilCrayon extends Outil{

	public OutilCrayon(Controleur controller) {
		super(controller);
	}
	
	public void onMousePress(double x, double y) {
		
			controller.precX.set(x); 
	    	controller.precY.set(y);
	    	controller.figure = new Trace(controller.epaisseur.getValue(), controller.couleur.get()+"", x, y);
	    	controller.dessin.addFigure(controller.figure);
		
	}


	public void onMouseDrag(double x, double y) {
		controller.dessinController.trace(controller.precX.getValue(),controller.precY.getValue(), x, y);
    	controller.figure.addPoint(x, y);
    	controller.precX.set(x);
    	controller.precY.set(y);
    	controller.statusController.nbX.setText(controller.precX.getValue()+"");
    	controller.statusController.nbY.setText(controller.precY.getValue()+"");
		
	}

}
