package edu.unlam.taller.state;

import edu.unlam.taller.state.estados.Chiquito;
import edu.unlam.taller.state.estados.Estado;

public class Mario {

	private Estado estado = new Chiquito();
	
	public Estado getEstado() {
		return estado;
	}

	public void comerHongo() {
		estado = estado.comerHongo();
	}
	
	public void recibirDaño() {
		estado = estado.recibirDaño();
	}
	
	public void tocarFlor() {
		estado = estado.tocarFlor();
	}
	
	public static void main(String[] args) {
		Mario mario = new Mario();
		System.out.println(mario.estado); // chiquito
		mario.comerHongo();
		System.out.println(mario.estado); // grande
		mario.comerHongo();
		System.out.println(mario.estado); // grande
		mario.recibirDaño();
		System.out.println(mario.estado); // chiquito
		mario.tocarFlor();
		System.out.println(mario.estado); // piromaniaco
		mario.recibirDaño();
		System.out.println(mario.estado); // grande
		mario.recibirDaño();
		System.out.println(mario.estado); // chiquito
		mario.recibirDaño();
		System.out.println(mario.estado); // muerto
		
	}
	
}
