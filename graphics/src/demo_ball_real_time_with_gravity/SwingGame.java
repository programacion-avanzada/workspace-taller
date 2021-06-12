package demo_ball_real_time_with_gravity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingGame extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;

	// OJO: Los valores de SKIP son un resultado de una división entera!
	private final int SECOND = 1000;
	private final int FRAMES_PER_SECOND = 60;
	private final int SKIP_FRAMES = SECOND / FRAMES_PER_SECOND;
	private final int TICKS_PER_SECOND = 60;
	private final int SKIP_TICKS = SECOND / TICKS_PER_SECOND;

	private final int SQUARES_X = 16;
	private final int SQUARES_Y = 9;

	private boolean isRunning = true;

	private Player player;
	private Ball ball;
	private DrawPanel drawPanel;
	private BufferedImage background;

	private int loops = 0;
	private int fps = 0;

	public SwingGame() {
	}

	public void init() {
		try {
			background = ImageIO.read(new File("background.jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		player = new Player(1, 3);

		ball = new Ball(2, 8, 2, SQUARES_Y, 0, SQUARES_X, 0, 0.8);

		drawPanel = new DrawPanel();
		add(drawPanel);

		addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {

				case KeyEvent.VK_W:
					player.goUp();
					break;
				case KeyEvent.VK_A:
					player.goLeft();
					break;
				case KeyEvent.VK_S:
					player.goDown();
					break;
				case KeyEvent.VK_D:
					player.goRight();
					break;

				case KeyEvent.VK_UP:
					ball.pushTop(5);
					break;
				case KeyEvent.VK_DOWN:
					ball.pushBottom(5000);
					break;
				case KeyEvent.VK_LEFT:
					ball.pushLeft(2);
					break;
				case KeyEvent.VK_RIGHT:
					ball.pushRight(2);
					break;
				case KeyEvent.VK_ESCAPE:
					isRunning = false;
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setFocusable(true);
		requestFocusInWindow();
	}

	@Override
	public void run() {
		// System.nanoTime no es seguro entre distintos Threads
		// En caso de querer utilizarse igual para aumentar la precision en
		// valores altos de fps o de ticks se debe aumentar también el valor
		// de las constantes, para que esten en ns y no en ms

		long next_game_tick = System.currentTimeMillis();
		long next_game_frame = System.currentTimeMillis();
		long next_frame_calc = System.currentTimeMillis();
		int frames = 0;

		while (isRunning) {
			if (System.currentTimeMillis() > next_game_tick) {
				loops++;
				next_game_tick += SKIP_TICKS;
				update();
			}
			if (System.currentTimeMillis() > next_game_frame) {
				frames++;
				next_game_frame += SKIP_FRAMES;
				display();
			}
			if (System.currentTimeMillis() > next_frame_calc) {
				fps = frames;
				next_frame_calc += SECOND;
				frames = 0;
			}
		}
	}

	public void update() {
		player.move(1.0 / TICKS_PER_SECOND);
		ball.move(1.0 / TICKS_PER_SECOND);
	}

	public void display() {
		drawPanel.repaint();
	}

	private class DrawPanel extends JPanel {
		private static final long serialVersionUID = 91574813372177663L;

		private final int SQUARE = 120;
		private final int WIDTH = SQUARE * SQUARES_X;
		private final int HEIGHT = SQUARE * SQUARES_Y;

		public DrawPanel() {
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent me) {
					super.mouseClicked(me);
					Point point = me.getPoint();
					Dimension currentDimension = getContentPane().getSize();
					System.out.print("Click en: [" + (point.x * WIDTH / currentDimension.getWidth()) + ", ");
					System.out.println(point.y * HEIGHT / currentDimension.getHeight() + "]");

					if (ball.isInside((point.x * WIDTH / currentDimension.getWidth()) / SQUARE,
							(point.y * HEIGHT / currentDimension.getHeight()) / SQUARE)) {
						ball.setColor(new Color((int) (Math.random() * Math.pow(2, 24))));
					}
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;

			Dimension currentDimension = getContentPane().getSize();
			g2d.scale(currentDimension.getWidth() / WIDTH, currentDimension.getHeight() / HEIGHT);

			g2d.drawImage(background, 0, 0, WIDTH, HEIGHT, null);

			g2d.setColor(Color.WHITE);
			g2d.setFont(new Font("Consolas", Font.BOLD, 24));
			g2d.drawString("Time: " + String.format("%6s", loops * SKIP_TICKS) + "ms", 20, 25);
			g2d.drawString("FPS: " + fps + "", 240, 25);

			g2d.drawString("Ball X: " + String.format("%8.6s", ball.getX()), 20, 60);
			g2d.drawString("Ball Y: " + String.format("%8.6s", ball.getY()), 240, 60);

			g2d.setColor(Color.BLUE);
			g2d.fillRect((int) (player.getDeltaX() * SQUARE), (int) (player.getDeltaY() * SQUARE), SQUARE, SQUARE);
			g2d.setColor(Color.RED);
			g2d.drawRect((int) (player.getX() * SQUARE), (int) (player.getY() * SQUARE), SQUARE - 1, SQUARE - 1);

			g2d.setColor(ball.getColor());
			g2d.fillOval((int) (ball.getX() * SQUARE - SQUARE * ball.getSize() / 2),
					(int) (ball.getY() * SQUARE - SQUARE * ball.getSize() / 2), (int) (SQUARE * ball.getSize()),
					(int) (SQUARE * ball.getSize()));
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(WIDTH, HEIGHT);
		}
	}

	public static void main(String[] args) throws Exception {
		SwingGame game = new SwingGame();
		game.init();
		game.run();
	}
}
