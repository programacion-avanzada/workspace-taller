package basics.swing;

import javax.swing.JFrame;

public class Frame extends JFrame {
	private static final long serialVersionUID = 5313051202295035309L;

	Panel panel;

	public Frame() {
		panel = new Panel();
		getContentPane().add(panel);

		// Esconde los bordes de ventana. Solo se puede hacer mientras no sea visible
		// setUndecorated(true);

		// Setteo el tamaño segun el tamaño de los hijos
		pack();
		// setSize(640, 480);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// public void paint(Graphics g) {
	// 	g.drawString("Hola mundo", 50, 50);
	// }
}
