package edu.unlam.taller.ventanas;

import java.util.Date;

public class Cliente {
	private String dni;
	private String tipoDoc;
	private String apellido;
	private String nombre;
	private Date fechaNac;
	private String observaciones;

	public Cliente(String dni, String tipoDoc, String apellido, String nombre, Date fechaNac, String observaciones) {
		this.dni = dni;
		this.tipoDoc = tipoDoc;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.observaciones = observaciones;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
