package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;

public class App extends Application {
	double posX;
	double posY;
	@Override
	public void start(Stage stage) {
		Rectangle cuadrado = new Rectangle(100, 100);
		cuadrado.setFill(Color.RED);
		Translate translate = new Translate();
		posX = cuadrado.getLayoutX();
		posY = cuadrado.getLayoutY();
		cuadrado.setOnMouseClicked(event -> {
			cuadrado.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		});
		cuadrado.getTransforms().add(translate);
		StackPane stackPane = new StackPane(cuadrado);
		Scene scene = new Scene(stackPane, 640, 480);
		scene.setOnKeyPressed(event -> {
			if(event.getCode() == KeyCode.RIGHT){
				
				translate.setX(posX+10);
				posX = posX +10;
		    }
		    else if(event.getCode() == KeyCode.LEFT){
		    	
		    	translate.setX(posX-10);
		    	posX = posX -10;
		    }
		    else if(event.getCode() == KeyCode.UP){
		    	translate.setY(posY-10);
		    	posY = posY -10;
		    }
		    else if(event.getCode() == KeyCode.DOWN){
		    	translate.setY(posY+10);
		    	posY = posY +10;
		    }
		});
		stage.setScene(scene);
		stage.show();
	}
	

	public static void main(String[] args) {
		// ,javafx.media
		launch();
	}
}
