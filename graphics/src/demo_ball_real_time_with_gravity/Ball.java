package demo_ball_real_time_with_gravity;

import java.awt.Color;

// If multiple balls are created, physics methods must run with 'synchronized'
public class Ball {
	final double GRAVITY = 9.8;
	final double GROUNDED_ERROR_POS = .02;
	final double GROUNDED_ERROR_VEL = .1;

	private double x;
	private double y;
	private double size;
	private double floor;
	private double ceil;
	private double left;
	private double right;
	private double vy = 0;
	private double vx = 0;
	private double elasticity; // [0, 1]
	private boolean grounded;
	//private Sound2Channels sound;
	private Sound2ChannelsFX sound;
	private Color color = Color.YELLOW;

	public Ball(double size, double x, double y, double floor, double ceil, double right, double left,
			double elasticity) {
		this.size = size;
		this.x = x;
		this.y = y;
		this.floor = floor - size / 2;
		this.ceil = ceil + size / 2;
		this.right = right - size / 2;
		this.left = left + size / 2;
		this.elasticity = elasticity;
		this.sound = new Sound2ChannelsFX("hit.wav");
		
		//try {
		//	this.sound = new Sound2Channels("./left.wav", "./right.wav");
		//} catch (Exception e) {
		//	e.printStackTrace();
		//}
		
	}

	public void move(double deltaTime) {
		calcForces(deltaTime);
		y += vy * deltaTime; // TODO change to MRUV
		crashY();
		x += vx * deltaTime;
		crashX();
	}

	private void crashY() {
		double vaux = 0;
		while (y > floor || y < ceil) {
			vaux = vy;
			if (y > floor) {
				y = floor - (y - floor);
				if (vy > 0) { // Necessary if ball is out of bounds at the start
					vy = -vy * elasticity;
				}
				squash();
			} else {
				y = ceil - (y - ceil);
				if (vy < 0) {
					vy = -vy * elasticity;
				}
			}
		}
		if (vaux != 0) {
			onCrash(vaux);
		}
	}

	private void crashX() {
		double vaux = 0;
		while (x > right || x < left) {
			vaux = vx;
			if (x > right) {
				x = right - (x - right);
				if (vx > 0) {
					vx = -vx * elasticity;
				}
			} else {
				x = left - (x - left);
				if (vx < 0) {
					vx = -vx * elasticity;
				}
			}
		}
		if (vaux != 0) {
			onCrash(vaux);
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

	private void onCrash(double v) {
		float volumeStrength = (float) Math.min(Math.abs(v) / 20, 1f);
		double halfRange = (this.right - this.left) / 2;
		double position = this.right - this.x;
		sound.setBalance((halfRange - position) / halfRange);
		sound.setVolume(volumeStrength);
		sound.play();
	}

	public boolean isInside(double x, double y) {
		return Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2) < Math.pow(size / 2, 2);
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

	public double getSize() {
		return size;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
