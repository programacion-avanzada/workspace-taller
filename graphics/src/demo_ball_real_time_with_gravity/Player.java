package demo_ball_real_time_with_gravity;

public class Player {
	private double x;
	private double y;
	private double deltaX;
	private double deltaY;
	private boolean move = true;

	public Player(double x, double y) {
		this.x = x;
		this.y = y;
		this.deltaX = x;
		this.deltaY = y;
	}

	public Player() {
		this(0.0, 0.0);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getDeltaY() {
		return deltaY;
	}

	public double getDeltaX() {
		return deltaX;
	}

	public void move(double delta) {
		if (x > deltaX) {
			deltaX = Math.min(x, deltaX + delta);
		} else if (x < deltaX) {
			deltaX = Math.max(x, deltaX - delta);
		}

		if (y > deltaY) {
			deltaY = Math.min(y, deltaY + delta);
		} else if (y < deltaY) {
			deltaY = Math.max(y, deltaY - delta);
		}

		if (x == deltaX && y == deltaY) {
			newMovement();
		}
	}

	public void goUp() {
		if (move) {
			this.y--;
			move = false;
		}
	}

	public void goDown() {
		if (move) {
			this.y++;
			move = false;
		}
	}

	public void goLeft() {
		if (move) {
			this.x--;
			move = false;
		}
	}

	public void goRight() {
		if (move) {
			this.x++;
			move = false;
		}
	}

	public void newMovement() {
		move = true;
	}
}
