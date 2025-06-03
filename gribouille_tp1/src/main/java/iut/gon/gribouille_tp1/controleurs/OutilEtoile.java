package iut.gon.gribouille_tp1.controleurs;

import iut.gon.gribouille_tp1.modele.Trace;
import javafx.scene.input.MouseEvent;

public class OutilEtoile extends Outil{

	private double x1;
	private double y1;
	
	public OutilEtoile(Controleur controller) {
		super(controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onMousePress(double x, double y) {
		x1 = x;
		y1 = y;
    	controller.precY.set(y);
    	controller.figure = new Trace(1, "black", x, y);
    	controller.dessin.addFigure(controller.figure);
		
	}

	@Override
	public void onMouseDrag(double x, double y) {
		controller.dessinController.trace(x1,y1, x, y);
    	controller.figure.addPoint(x, y);
    	controller.precX.set(x);
    	controller.precY.set(y);
    	controller.statusController.nbX.setText(controller.precX.getValue()+"");
    	controller.statusController.nbY.setText(controller.precY.getValue()+"");
		
	}

}
