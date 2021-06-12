package demo_ball_real_time_with_gravity;

import java.awt.Point;
import java.io.FileInputStream;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFXGame extends Application {
	private final int SECOND = 1000;
	private final int FRAMES_PER_SECOND = 60;
	private final int TICKS_PER_SECOND = 1000;
	private final int SKIP_TICKS = SECOND / TICKS_PER_SECOND;

	private final int SQUARE = 50;
	private final int WIDTH = SQUARE * 16;
	private final int HEIGHT = SQUARE * 9;

	private Player player;
	private Ball ball;

	private int loops = 0;
	private int fps = 0;
	private int frames = 0;

	private Group group;
	private Scene scene;
	private Scale scale;

	private Circle ballImage;
	private Rectangle playerDeltaImage;
	private Rectangle playerImage;
	private ImageView backgroundImage;
	private Text textTime;
	private Text textFps;
	private Text textBallX;
	private Text textBallY;

	@Override
	public void start(final Stage primaryStage) throws Exception {
		player = new Player(1, 3);
		playerDeltaImage = new Rectangle(SQUARE, SQUARE);
		playerDeltaImage.setFill(Color.BLUE);
		playerImage = new Rectangle(SQUARE, SQUARE);
		playerImage.setFill(Color.TRANSPARENT);
		playerImage.setStroke(Color.RED);

		ball = new Ball(2, 8, 2, 9, 0, 16, 0, 0.8);
		ballImage = new Circle(0, 0, (int) (SQUARE * ball.getSize() / 2));

		Image image = new Image(new FileInputStream("background.jpg"));
		backgroundImage = new ImageView(image);
		backgroundImage.setX(0);
		backgroundImage.setY(0);
		backgroundImage.setFitHeight(HEIGHT);
		backgroundImage.setFitWidth(WIDTH);
		backgroundImage.setPreserveRatio(false);

		Font font = Font.font("Consolas", FontWeight.BOLD, FontPosture.REGULAR, 24);
		textTime = new Text(20, 25, "");
		textTime.setFill(Color.WHITE);
		textTime.setFont(font);
		textFps = new Text(240, 25, "");
		textFps.setFill(Color.WHITE);
		textFps.setFont(font);
		textBallX = new Text(20, 60, "");
		textBallX.setFill(Color.WHITE);
		textBallX.setFont(font);
		textBallY = new Text(240, 60, "");
		textBallY.setFill(Color.WHITE);
		textBallY.setFont(font);

		@SuppressWarnings({ "unchecked", "rawtypes" })
		final Timeline game_timeline = new Timeline(new KeyFrame(Duration.ZERO, new EventHandler() {
			@Override
			public void handle(Event event) {
				frames++;
				display();
			}
		}), new KeyFrame(Duration.millis(SECOND / FRAMES_PER_SECOND)));
		game_timeline.setCycleCount(Timeline.INDEFINITE);

		@SuppressWarnings({ "unchecked", "rawtypes" })
		final Timeline frame_timeline = new Timeline(new KeyFrame(Duration.ZERO, new EventHandler() {
			@Override
			public void handle(Event event) {
				loops++;
				update();
			}
		}), new KeyFrame(Duration.millis(SKIP_TICKS)));
		frame_timeline.setCycleCount(Timeline.INDEFINITE);
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		final Timeline second_timeline = new Timeline(new KeyFrame(Duration.ZERO, new EventHandler() {
			@Override
			public void handle(Event event) {
				fps = frames;
				frames = 0;
			}
		}), new KeyFrame(Duration.millis(SECOND)));
		second_timeline.setCycleCount(Timeline.INDEFINITE);

		group = new Group(backgroundImage, playerDeltaImage, playerImage, ballImage, textTime, textFps, textBallX,
				textBallY);
		scene = new Scene(group, WIDTH, HEIGHT);

		scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				Point point = new Point((int) e.getX(), (int) e.getY());
				System.out.print("Click en: [" + (point.x * WIDTH / scene.getWidth()) + ", ");
				System.out.println(point.y * HEIGHT / scene.getHeight() + "]");
				if (ball.isInside((point.x * WIDTH / scene.getWidth()) / SQUARE,
						(point.y * HEIGHT / scene.getHeight()) / SQUARE)) {
					ball.setColor(new java.awt.Color((int) (Math.random() * Math.pow(2, 24))));
				}
			}
		});

		scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			@SuppressWarnings("incomplete-switch")
			@Override
			public void handle(KeyEvent e) {
				switch (e.getCode()) {

				case W:
					player.goUp();
					break;
				case A:
					player.goLeft();
					break;
				case S:
					player.goDown();
					break;
				case D:
					player.goRight();
					break;

				case UP:
					ball.pushTop(5);
					break;
				case DOWN:
					ball.pushBottom(5000);
					break;
				case LEFT:
					ball.pushLeft(2);
					break;
				case RIGHT:
					ball.pushRight(2);
					break;
				}
			}
		});

		scale = new Scale();
		scale.setX(1.5);
		scale.setY(1.5);
		group.getTransforms().add(scale);
		primaryStage.setTitle("¡JavaFX!");
		primaryStage.setScene(scene);
		primaryStage.show();

		game_timeline.play();
		frame_timeline.play();
		second_timeline.play();
	}

	private void update() {
		player.move(1.0 / TICKS_PER_SECOND);
		ball.move(1.0 / TICKS_PER_SECOND);
	}

	private void display() {
		scale.setX(scene.getWidth() / WIDTH);
		scale.setY(scene.getHeight() / HEIGHT);

		textTime.setText("Time: " + String.format("%6s", loops * SKIP_TICKS) + "ms");
		textFps.setText("FPS: " + fps + "");
		textBallX.setText("Ball X: " + String.format("%8.6s", ball.getX()));
		textBallY.setText("Ball Y: " + String.format("%8.6s", ball.getY()));

		playerDeltaImage.setX(player.getDeltaX() * SQUARE);
		playerDeltaImage.setY(player.getDeltaY() * SQUARE);
		playerImage.setX(player.getX() * SQUARE);
		playerImage.setY(player.getY() * SQUARE);

		ballImage.setCenterX((int) (ball.getX() * SQUARE));
		ballImage.setCenterY((int) (ball.getY() * SQUARE));
		java.awt.Color awtColor = ball.getColor();
		javafx.scene.paint.Color fxColor = javafx.scene.paint.Color.rgb(awtColor.getRed(), awtColor.getGreen(),
				awtColor.getBlue(), awtColor.getAlpha() / 255.0);
		ballImage.setFill(fxColor);
	}

	public static void main(String[] args) throws Exception {
		launch(args);
	}
}