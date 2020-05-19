package edu.unlam.taller.ventana;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaChat extends JFrame {

	private JPanel contentPane;
	private JPanel panelMensajeAEnviar;
	private JTextField textField;
	private JButton btnEnviar;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public VentanaChat() {

		setTitle("Ventana de Chat");
		setResizable(false);
		setBounds(100, 100, 450, 300);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				textField.requestFocus();
			}
		});

		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(1, 1));
		setContentPane(contentPane);

		panelMensajeAEnviar = new JPanel();
		contentPane.add(panelMensajeAEnviar, BorderLayout.SOUTH);
		panelMensajeAEnviar.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {

				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					agregarTextoTextArea(textField.getText() + "\n");
					selectAllTextoTextField(textField);
				}

			}
		});

		textField.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {

				Object obj = e.getSource();
				if (obj instanceof JTextField) {
					selectAllTextoTextField((JTextField) obj);
				}

			}
		});

		textField.setToolTipText("Escriba su mensaje para enviar");
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(30);
		panelMensajeAEnviar.add(textField);

		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				agregarTextoTextArea(textField.getText() + "\n");
				selectAllTextoTextField(textField);
			}
		});

		btnEnviar.setToolTipText("Click para enviar mensaje");
		panelMensajeAEnviar.add(btnEnviar);

		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	private void agregarTextoTextArea(String texto) {
		textArea.append(texto);
		textArea.setCaretPosition(textArea.getText().length());
	}

	private void selectAllTextoTextField(JTextField textField) {
		textField.requestFocus();
		textField.setSelectionStart(0);
		textField.setSelectionEnd(textField.getText().length());
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaChat frame = new VentanaChat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
