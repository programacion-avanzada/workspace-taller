package demo_ball_real_time_with_gravity;

// If multiple balls are created, physics methods must run with 'synchronized'
public class Ball {
	private final double GRAVITY = 9.8;
	private final double GROUNDED_ERROR_POS = .02;
	private final double GROUNDED_ERROR_VEL = .1;

	private double x;
	private double y;
	private double floor;
	private double ceil;
	private double left;
	private double right;
	private double vy = 0;
	private double vx = 0;
	private double elastic; // [0, 1]
	private boolean grounded;

	public Ball(double x, double y, double floor, double ceil, double right, double left, double elastic) {
		this.x = x;
		this.y = y;
		this.floor = floor;
		this.ceil = ceil;
		this.right = right;
		this.left = left;
		this.elastic = elastic;
	}

	public void move(double deltaTime) {
		calcForces(deltaTime);
		y += vy * deltaTime;
		crashY();
		x += vx * deltaTime;
		crashX();
		if (x > right) {
			x = right;
			if (vx > 0) {
				vx = -vx * elastic;
			}
		}
		if (x < left) {
			x = left;
			if (vx < 0) {
				vx = -vx * elastic;
			}
		}
	}

	private void crashY() {
		while (y > floor || y < ceil) {
			if (y > floor) {
				y = floor - (y - floor);
				if (vy > 0) { // Probably not necessary
					vy = -vy * elastic;
				}
				squash();
			} else {
				y = ceil - (y - ceil);
				if (vy < 0) { // Probably not necessary
					vy = -vy * elastic;
				}
			}
		}
	}

	private void crashX() {
		while (x > right || x < left) {
			if (x > right) {
				x = right - (x - right);
				if (vx > 0) { // Probably not necessary
					vx = -vx * elastic;
				}
			} else {
				x = left - (x - left);
				if (vx < 0) { // Probably not necessary
					vx = -vx * elastic;
				}
			}
		}
	}
	
	public void squash() {
		if (floor - y < GROUNDED_ERROR_POS && Math.abs(vy) < GROUNDED_ERROR_VEL) {
			y = floor;
			vy = 0;
			grounded = true;
		}
	}

	private void calcForces(double deltaTime) {
		if (!grounded) {
			vy = vy + GRAVITY * deltaTime;
		}
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void pushTop(double force) {
		grounded = false;
		vy -= force;
	}

	public void pushBottom(double force) {
		grounded = false;
		vy += force;
	}

	public void pushLeft(double force) {
		vx -= force;
	}

	public void pushRight(double force) {
		vx += force;
	}
}
