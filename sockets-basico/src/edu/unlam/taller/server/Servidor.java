package edu.unlam.taller.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private ServerSocket servidor;
	private int puerto;
	
	public Servidor(int puerto) throws IOException {
		
		this.puerto = puerto;
		servidor = new ServerSocket(this.puerto);
		
		System.out.println("Server inicializando...");
		
		for(int i = 1; i <= 3; i++) {
			Socket socket = servidor.accept();
			DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
			salida.writeUTF("Sos el cliente Nro: " + i);
			
			salida.close();
			socket.close();
		}
		
		System.out.println("Server Finalizado");
	}
	
	public static void main(String[] args) {
		
		try {
			new Servidor(20000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
