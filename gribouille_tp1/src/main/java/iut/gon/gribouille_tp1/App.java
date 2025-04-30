package iut.gon.gribouille_tp1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;
	private double prevX;
	private double prevY;

	@Override
	public void start(Stage stage) throws IOException {
		scene = new Scene(loadFXML("CadreGribouille"), 640, 480);
		Canvas dessin = (Canvas) scene.lookup("Canvas");
		Pane pane = (Pane) dessin.getParent();
		stage.setScene(scene);
		stage.show();
		stage.setOnCloseRequest(event -> {
			boolean conf = Dialogues.confirmation(stage);
			if (!conf) {
				event.consume();
			}
		});
		dessin.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			this.prevX = event.getX();
			this.prevY = event.getY();
		});
		dessin.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
			dessin.getGraphicsContext2D().strokeLine(prevX, prevY, event.getX(), event.getY());
			this.prevX = event.getX();
			this.prevY = event.getY();
		});
		pane.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
			this.prevX = event.getX();
			this.prevY = event.getY();
			if (event.getButton() == MouseButton.SECONDARY) {
				Circle cercle = new Circle(event.getX(), event.getY(), 5);
				cercle.setMouseTransparent(true);
				pane.getChildren().add(cercle);
				event.consume();
			}
		});

	}

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void main(String[] args) {
		launch();
	}

}