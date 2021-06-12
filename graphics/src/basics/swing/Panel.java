package basics.swing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel extends JPanel {
	private static final long serialVersionUID = -6313969776795988484L;

	public Panel() {
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setFont(new Font("Consolas", Font.BOLD, 24));
		g2d.drawString("¡Hola mundo!", 30, 50);

		g2d.setColor(Color.WHITE);
		g2d.setStroke(new BasicStroke(50));
		g2d.drawRect(300, 100, 200, 100);

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("background.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g2d.drawImage(img, 300, 300, 200, 100, null);

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(960, 540);
	}
}
