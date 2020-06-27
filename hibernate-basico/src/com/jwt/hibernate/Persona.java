package com.jwt.hibernate;

public class Persona {

	private int dni;
	private String apellido;
	private String nombre;
	private char sexo;
	private int codigo_depto; 
	
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public int getCodigo_depto() {
		return codigo_depto;
	}

	public void setCodigo_depto(int codigo_depto) {
		this.codigo_depto = codigo_depto;
	}

	public String toString() {
		return dni + " " + apellido + ", " + nombre + " (" + sexo + ") Dpto[" + codigo_depto + "]";
	}
	
}
