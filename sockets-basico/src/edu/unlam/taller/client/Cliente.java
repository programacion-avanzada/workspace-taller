package edu.unlam.taller.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	
	private Socket socket;
	private String ip;
	private int puerto;
	
	public Cliente(String ip, int puerto) throws UnknownHostException, IOException {
		this.ip = ip;
		this.puerto = puerto;
		socket = new Socket(this.ip, this.puerto);
		
		DataInputStream entrada = new DataInputStream(socket.getInputStream());
		System.out.println(entrada.readUTF()); 
		
		entrada.close();
		socket.close();
		
	}

	public static void main(String[] args) {
		try {
			new Cliente("localhost", 20000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
