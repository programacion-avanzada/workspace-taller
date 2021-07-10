package edu.unlam.taller.multiventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class JConfig extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboBox;
	private JCheckBox checkBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JConfig frame = new JConfig();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JConfig() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(getForeground());
		textPane.setEditable(false);
		textPane.setText("App launcher v0.1");
		textPane.setFont(new Font("Arial",Font.BOLD,22));
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridheight = 2;
		gbc_textPane.gridwidth = 6;
		gbc_textPane.insets = new Insets(0, 0, 5, 5);
		//gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 0;
		gbc_textPane.gridy = 0;
		contentPane.add(textPane, gbc_textPane);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1920x1080", "1280x720", "800x600"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		contentPane.add(comboBox, gbc_comboBox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Sonido");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 2;
		gbc_chckbxNewCheckBox.gridy = 4;
		contentPane.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Lanzar app");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 7;
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviarDatosApp();
			}
		});
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		this.comboBox = comboBox;
		this.checkBox = chckbxNewCheckBox;
	}

	protected void enviarDatosApp() {
		Thread thread =new Thread(new Runnable() {
			@Override
			public void run() {
				int[][] resoluciones = { {1920,1080}, {1280,720}, {800,600}};
				try {
					JApp otraVentana = new JApp(resoluciones[comboBox.getSelectedIndex()][0],resoluciones[comboBox.getSelectedIndex()][1],checkBox.isSelected());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		thread.start();
		this.dispose();
		
	}

}
