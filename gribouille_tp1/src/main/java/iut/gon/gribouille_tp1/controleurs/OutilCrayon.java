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
	    	this.trace = new Trace(1, "black", x, y);
	    	controller.dessin.addFigure(trace);
		
	}


	public void onMouseDrag(double x, double y) {
		canvas.getGraphicsContext2D().strokeLine(prevX.getValue(), prevY.getValue(), evt.getX(), evt.getY());
    	trace.addPoint(evt.getX(), evt.getY());
    	this.prevX.set(evt.getX());
    	this.prevY.set(evt.getY());
		
	}

}
