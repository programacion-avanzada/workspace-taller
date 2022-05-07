package main;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class Mario {
	private final int imageSpacing = 6;
	private final int width = 48;
	private final int height = 48;
	private final int speed = 300;
	private ImageView render;

	private double x = 0;
	private double y = 0;
	private boolean directionRight = false;
	private boolean directionLeft = false;
	private boolean dead = false;

	private SpriteAnimation runningAnimation;

	public Mario(int x, int y) {
		Image spriteImages = new Image("file:src/main/resources/mario-sprites.png", 136 * 3, 90 * 3, false, false);

		render = new ImageView(spriteImages);
		resetViewport();
		// Seteo ancla en la mitad del eje X y en el pie del eje Y
		render.relocate(-width / 2, -height);

		setX(x);
		setY(y);

		runningAnimation = new SpriteAnimation(render, Duration.millis(200), 3, 3, 63, imageSpacing, imageSpacing,
				width, height);
		runningAnimation.setCycleCount(Animation.INDEFINITE);
	}

	private void resetViewport() {
		render.setViewport(new Rectangle2D(imageSpacing, imageSpacing, width, height));
	}

	private void setX(double x) {
		if (x < width / 2) {
			x = width / 2;
		} else if (x > 720 - width / 2) {
			x = 720 - width / 2;
		}
		this.x = x;
		render.setX(x);
	}

	private void setY(double y) {
		this.y = y;
		render.setY(y);
	}

	private void checkHorizontal() {
		if (!dead) {
			if (directionLeft) {
				render.setScaleX(-1);
				runningAnimation.play();
			} else if (directionRight) {
				render.setScaleX(1);
				runningAnimation.play();
			} else {
				runningAnimation.stop();
				resetViewport();
			}
		}
	}

	public Node getRender() {
		return render;
	}

	public void update(double deltaTime) {
		if (!dead) {
			int direction = directionLeft ? -1 : (directionRight ? 1 : 0);
			setX(x + direction * speed * deltaTime);
		}
	}

	public void setDirectionRight(boolean b) {
		this.directionRight = b;
		checkHorizontal();
	}

	public void setDirectionLeft(boolean b) {
		this.directionLeft = b;
		checkHorizontal();
	}

	public void die() {
		if (!dead) {
			dead = true;
			
			AudioClip audioDie = new AudioClip("file:src/main/resources/die.wav");
			audioDie.play();

			runningAnimation.stop();

			render.setViewport(new Rectangle2D(118 * 3, imageSpacing, width, height));

			Interpolator gravityInterpolator = new Interpolator() {
				@Override
				protected double curve(double t) {
					return t * t;
				}
			};

			Interpolator inverseGravityInterpolator = new Interpolator() {
				@Override
				protected double curve(double t) {
					return 1 - Math.pow(1 - t, 2);
				}
			};

			TranslateTransition noTranslate = new TranslateTransition(Duration.millis(500));

			TranslateTransition translateUp = new TranslateTransition(Duration.millis(500));
			translateUp.setToY(-200);
			translateUp.setInterpolator(inverseGravityInterpolator);

			TranslateTransition translateDown = new TranslateTransition(Duration.millis(1500));
			translateDown.setToY(800);
			translateUp.setInterpolator(gravityInterpolator);

			SequentialTransition sq = new SequentialTransition(render, noTranslate, translateUp, translateDown);

			sq.play();
		}

	}
}
