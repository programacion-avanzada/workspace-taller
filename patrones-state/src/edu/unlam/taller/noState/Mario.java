package edu.unlam.taller.noState;

public class Mario {

	String estado = "MarioChiquito";

	public void comerHongo() {
		if (estado == "Muerto")
			estado = "Muerto";
		if (estado == "MarioChiquito")
			estado = "SuperMario";
		if (estado == "SuperMario")
			estado = "SuperMario";
		if (estado == "MarioFuego")
			estado = "MarioFuego";
	}
	
	public void hit() {
		if (estado == "Muerto")
			estado = "Muerto";
		if (estado == "MarioChiquito")
			estado = "Muerto";
		if (estado == "SuperMario")
			estado = "MarioChiquito";
		if (estado == "MarioFuego")
			estado = "SuperMario";
	}
	
	public void tocarFlor() {
		if (estado == "Muerto")
			estado = "Muerto";
		if (estado == "MarioChiquito")
			estado = "MarioFuego";
		if (estado == "SuperMario")
			estado = "MarioFuego";
		if (estado == "MarioFuego")
			estado = "MarioFuego";
	}	
	
	@Override
	public String toString() {
		return estado;
	}
}
