package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application {
	private static final double NANOS_IN_SECOND_D = 1_000_000_000.0;

	Mario mario;
	Scene currentScene;
	long previousNanoFrame;

	@Override
	public void start(Stage stage) {
		Group root = new Group();
		currentScene = new Scene(root);

		Image fondo = new Image("file:src/main/resources/mario-background.png", 720, 720, false, false);
		ImageView imageView = new ImageView(fondo);
		root.getChildren().add(imageView);

		mario = new Mario(100, 624);
		root.getChildren().add(mario.getRender());

		addUpdateEachFrameTimer();

		stage.setScene(currentScene);
		stage.setTitle("FX básico | Programación Avanzada");
		stage.show();
		
		
		addInputEvents();
	}

	private void addInputEvents() {
		currentScene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				switch (e.getCode()) {
				case RIGHT:
				case D:
					mario.setDirectionRight(true);
					break;
				case LEFT:
				case A:
					mario.setDirectionLeft(true);
					break;
				case Q:
					mario.die();
					break;
				default:
					break;
				}
			}
		});

		currentScene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				switch (e.getCode()) {
				case RIGHT:
				case D:
					mario.setDirectionRight(false);
					break;
				case LEFT:
				case A:
					mario.setDirectionLeft(false);
					break;

				default:
					break;
				}
			}
		});
		
		mario.getRender().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				mario.die();
			}
		});
	}

	private void addUpdateEachFrameTimer() {
		previousNanoFrame = System.nanoTime();
		AnimationTimer gameTimer = new AnimationTimer() {
			@Override
			public void handle(long currentNano) {
				// Update tick
				update((currentNano - previousNanoFrame) / NANOS_IN_SECOND_D);
				previousNanoFrame = currentNano;
			}
		};
		gameTimer.start();
	}

	protected void update(double deltaTime) {
		mario.update(deltaTime);
	}

	public static void main(String[] args) {
		launch();
	}
}
