package edu.unlam.taller.ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MiPrimerVentana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1779064557725749287L;
	private JPanel panel;
	private JLabel etiqueta;
	private JButton boton;
	private int contador;

	public MiPrimerVentana() {

		contador = 0;
		setResizable(false);
		setTitle("Mi primer Ventana");

		panel = new JPanel();
		panel.setLayout(null);

		etiqueta = new JLabel();
		etiqueta.setText("Hola");
		etiqueta.setBounds(180, 50, 40, 15);

		boton = new JButton();
		boton.setText("Contar");
		boton.setBounds(160, 90, 80, 30);

		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				etiqueta.setText(++contador + "");

			}

		});
		;

		panel.add(etiqueta);
		panel.add(boton);

		add(panel);

		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		new MiPrimerVentana().setVisible(true);

	}

}
