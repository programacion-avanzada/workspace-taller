package edu.unlam.taller.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JPrincipal extends JFrame {

	private JPanel contentPane;
	private JButton btnAlta;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnVer;
	private JTable tblClientes;
	
	private HashMap<String, Cliente> clientes;

	/**
	 * Create the frame.
	 */
	public JPrincipal() {
		super("Clientes");
		
		clientes = new HashMap<String, Cliente>();
				
		this.setBounds(50, 50, 1024, 600);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		ImageIcon icoPrincipal = new ImageIcon(".\\clientes.png");
		this.setIconImage(icoPrincipal.getImage());		

		ImageIcon icoAlta = new ImageIcon(".\\agregar.png");
		Image imgAlta = icoAlta.getImage();
		Image imagAltaRed = imgAlta.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon icoAltaRed = new ImageIcon(imagAltaRed);
		
		btnAlta = new JButton(icoAltaRed);
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirVentanaModoAltaDeCliente();
			}
		});
		btnAlta.setToolTipText("Alta de Nuevo Cliente");
		btnAlta.setBounds(5, 5, 40, 40);
		
		getContentPane().add(btnAlta);
		
		ImageIcon icoEditar = new ImageIcon(".\\editar.png");
		Image imgEditar = icoEditar.getImage();
		Image imagEditarRed = imgEditar.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon icoEditarRed = new ImageIcon(imagEditarRed);
		
		JButton btnEditar = new JButton(icoEditarRed);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirVentanaModoEdicionDeCliente();
			}
		});
		btnEditar.setToolTipText("Editar datos del Cliente");
		btnEditar.setBounds(50, 5, 40, 40);
		getContentPane().add(btnEditar);
		
		ImageIcon icoEliminar = new ImageIcon(".\\eliminar.png");
		Image imgEliminar = icoEliminar.getImage();
		Image imagEliminarRed = imgEliminar.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon icoEliminarRed = new ImageIcon(imagEliminarRed);
		
		JButton btnEliminar = new JButton(icoEliminarRed);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirVentanaModoBajaDeCliente();
			}
		});
		btnEliminar.setToolTipText("Eliminar datos del Cliente seleccionado");
		btnEliminar.setBounds(95, 5, 40, 40);
		getContentPane().add(btnEliminar);
		
		ImageIcon icoVer = new ImageIcon(".\\ver.png");
		Image imgVer = icoVer.getImage();
		Image imgVerRed = imgVer.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon icoVerRed = new ImageIcon(imgVerRed);
		
		JButton btnVer = new JButton(icoVerRed);
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirVentanaModoVisualizarCliente();
			}
		});
		btnVer.setToolTipText("Mostrar datos del Cliente seleccionado");
		btnVer.setBounds(140, 5, 40, 40);
		getContentPane().add(btnVer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 50, 1005, 516);
		getContentPane().add(scrollPane);
		
		tblClientes = new JTable();
		DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
		modelo.addColumn("Documento");
		modelo.addColumn("Tipo Doc.");
		modelo.addColumn("Apellido/s");
		modelo.addColumn("Nombre/s");

		scrollPane.setViewportView(tblClientes);
		
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void agregarNuevoCliente(Cliente cli)throws Exception{
		if(clientes.containsKey(cli.getDni()))
			throw new Exception();
		clientes.put(cli.getDni(), cli);		
	}
		
	public void agregarNuevoClienteGrilla(Cliente cli) {
		int filas = clientes.size() - 1;
		DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
		modelo.addRow(new Object[filas]);
		
		tblClientes.setValueAt(cli.getDni(), filas, 0);
		tblClientes.setValueAt(cli.getTipoDoc(), filas, 1);
		tblClientes.setValueAt(cli.getApellido(), filas, 2);
		tblClientes.setValueAt(cli.getNombre(), filas, 3);
		
	}
	
	public void modificarCliente(Cliente cli) {
		Cliente modi = clientes.get(cli.getDni());
		clientes.put(modi.getDni(), cli);
	}
	
	public void modificarClienteGrilla(Cliente cli, int fila) {		
		tblClientes.setValueAt(cli.getDni(), fila, 0);
		tblClientes.setValueAt(cli.getTipoDoc(), fila, 1);
		tblClientes.setValueAt(cli.getApellido(), fila, 2);
		tblClientes.setValueAt(cli.getNombre(), fila, 3);
	}
	
	public void eliminarCliente(Cliente cli) {
		clientes.remove(cli.getDni());
	}
	
	public void eliminarClienteGrilla(Cliente cli, int fila) {
		DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
		modelo.removeRow(fila);
	}
	
	public void abrirVentanaModoAltaDeCliente() {
		JABMCliente jCliente = new JABMCliente(this);
		jCliente.cargaIconoVentana(".\\agregar.png");
		jCliente.seteaComportamientoBoton("Alta");
		jCliente.setVisible(true);
	}
	
	public void abrirVentanaModoEdicionDeCliente() {
		Cliente cli = this.obtenerDatosDelCliente(this.obtenerFilaSeleccionadaGrilla());
		if(cli == null) return;
		JABMCliente jCliente = new JABMCliente(this);
		jCliente.setTitle("Modificar Datos del Cliente");
		jCliente.cargaIconoVentana(".\\editar.png");
		jCliente.seteaComportamientoBoton("Modificar");
		jCliente.cargaDatosDeClienteEnComponentes(cli);	
		jCliente.seteaComponentesEditables(true);
		jCliente.setVisible(true);
	}
	
	public void abrirVentanaModoBajaDeCliente() {
		Cliente cli = this.obtenerDatosDelCliente(this.obtenerFilaSeleccionadaGrilla());
		if(cli == null) return;
		JABMCliente jCliente = new JABMCliente(this);
		jCliente.setTitle("Eliminar Datos del Cliente");
		jCliente.cargaIconoVentana(".\\eliminar.png");
		jCliente.seteaComportamientoBoton("Eliminar");
		jCliente.cargaDatosDeClienteEnComponentes(cli);	
		jCliente.seteaComponentesEditables(false);		
		jCliente.setVisible(true);
	}
	
	public void abrirVentanaModoVisualizarCliente() {
		Cliente cli = this.obtenerDatosDelCliente(this.obtenerFilaSeleccionadaGrilla());
		if(cli == null) return;
		
		JABMCliente jCliente = new JABMCliente(this);
		jCliente.setTitle("Visualizar Datos del Cliente");
		jCliente.cargaIconoVentana(".\\ver.png");
		jCliente.seteaComportamientoBoton("Salir");
		jCliente.seteaComponentesEditables(false);
		jCliente.cargaDatosDeClienteEnComponentes(cli);		
		jCliente.setVisible(true);
	}
	
	public int obtenerFilaSeleccionadaGrilla() {
		int filaSeleccionada = tblClientes.getSelectedRow();
		if(filaSeleccionada >= 0) return filaSeleccionada;
		return -1;
	}
	
	private Cliente obtenerDatosDelCliente(int fila) {
		if(fila >=0) return clientes.get(tblClientes.getValueAt(fila, 0));
		return null;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new JPrincipal().setVisible(true);
	}
}
