package edu.unlam.taller.ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JABMCliente extends JDialog {

	private JTextField txtDni;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JComboBox cmbTipoDoc;
	private JButton btnSalir;
	private JDateChooser dateChooser;
	private JTextArea textArea;

	private JPrincipal principal;

	/**
	 * Create the dialog.
	 */
	public JABMCliente(JPrincipal principal) {

		this.principal = principal;

		setTitle("Alta de Clientes");
		setModal(true);
		setBounds(100, 100, 615, 301);
		getContentPane().setLayout(null);

		JLabel lblDni = new JLabel("Doc.");
		lblDni.setBounds(31, 29, 49, 14);
		getContentPane().add(lblDni);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(31, 60, 49, 14);
		getContentPane().add(lblApellido);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(31, 88, 49, 14);
		getContentPane().add(lblNombre);

		cmbTipoDoc = new JComboBox();
		cmbTipoDoc.setBounds(437, 25, 137, 22);
		getContentPane().add(cmbTipoDoc);

		txtDni = new JTextField();
		txtDni.setBounds(90, 25, 150, 20);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(90, 55, 250, 20);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(90, 85, 350, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblFechaNac = new JLabel("Fecha Nac.");
		lblFechaNac.setBounds(350, 60, 77, 14);
		getContentPane().add(lblFechaNac);

		JLabel lblTipoDoc = new JLabel("Tipo Doc.");
		lblTipoDoc.setBounds(350, 29, 77, 14);
		getContentPane().add(lblTipoDoc);

		dateChooser = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		dateChooser.setBounds(437, 60, 119, 20);
		getContentPane().add(dateChooser);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 116, 484, 101);
		getContentPane().add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JLabel lblObs = new JLabel("Obs.");
		lblObs.setBounds(31, 123, 49, 14);
		getContentPane().add(lblObs);

		btnSalir = new JButton("Aceptar");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abmCliente();
				dispose();
			}
		});

		btnSalir.setBounds(485, 228, 89, 23);
		getContentPane().add(btnSalir);

		this.setLocationRelativeTo(principal);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

		cargaComboTipoDoc();

	}

	public void cargaIconoVentana(String archivo) {
		ImageIcon ico = new ImageIcon(archivo);
		Image img = ico.getImage();
		Image imgRedimensionada = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		this.setIconImage(imgRedimensionada);
	}

	public void seteaComponentesEditables(boolean bool) {
		this.txtDni.setEditable(false);
		this.txtApellido.setEditable(bool);
		this.txtNombre.setEditable(bool);
		this.cmbTipoDoc.setEditable(bool);
		this.dateChooser.setEnabled(bool);
		this.textArea.setEditable(bool);
	}

	public void seteaComportamientoBoton(String comportamiento) {
		this.btnSalir.setText(comportamiento);
	}

	private void cargaComboTipoDoc() {
		cmbTipoDoc.addItem("DNI");
		cmbTipoDoc.addItem("CUIT");
		cmbTipoDoc.addItem("CUIL");
		cmbTipoDoc.addItem("Pasaporte");
	}

	private Cliente cargaDatosCliente() {
		return new Cliente(this.txtDni.getText().trim(), (String) this.cmbTipoDoc.getSelectedItem(),
				this.txtApellido.getText(), this.txtNombre.getText(), this.dateChooser.getDate(),
				this.textArea.getText());
	}

	public void cargaDatosDeClienteEnComponentes(Cliente cli) {
		this.txtDni.setText(cli.getDni());
		this.cmbTipoDoc.setSelectedItem(cli.getTipoDoc());
		this.dateChooser.setDate(cli.getFechaNac());
		this.txtApellido.setText(cli.getApellido());
		this.txtNombre.setText(cli.getNombre());
		this.textArea.setText(cli.getObservaciones());
	}

	private void abmCliente() {
		Cliente cli;
		try {
			if (this.btnSalir.getText().equals("Alta")) {
				cli = cargaDatosCliente();
				principal.agregarNuevoCliente(cli);
				principal.agregarNuevoClienteGrilla(cli);
			}
			
			if (this.btnSalir.getText().equals("Modificar")) {
				cli = cargaDatosCliente();
				principal.modificarCliente(cli);
				principal.modificarClienteGrilla(cli, principal.obtenerFilaSeleccionadaGrilla());
			}		
			
			if  (this.btnSalir.getText().equals("Ver")) return;
			
			if ( this.btnSalir.getText().equals("Eliminar")) {
				if(JOptionPane.showConfirmDialog(this, "Desea Eliminar el Cliente?", "Confirmar", JOptionPane.OK_OPTION) == JOptionPane.OK_OPTION) {
					cli = cargaDatosCliente();
					principal.eliminarCliente(cli);
					principal.eliminarClienteGrilla(cli, principal.obtenerFilaSeleccionadaGrilla());
				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(
					   this,
					   this.btnSalir.getText() + ": Ocurió un error.");
		}

	}
}
