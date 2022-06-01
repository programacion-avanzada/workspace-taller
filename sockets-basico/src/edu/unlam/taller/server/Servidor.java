package edu.unlam.taller.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public Servidor(int puerto) throws IOException {
		ServerSocket servidor = new ServerSocket(puerto);

		System.out.println("Server inicializando...");

		for (int numeroCliente = 1; numeroCliente <= 3; numeroCliente++) {
			// Se "congela" en la siguiente linea, hasta que llegue un pedido
			Socket socket = servidor.accept();

			// Flujos de información
			DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
			DataInputStream entrada = new DataInputStream(socket.getInputStream());

			System.out.println("Conectado cliente: " + numeroCliente);
			salida.writeUTF("" + numeroCliente);

			// El read también es bloqueante, como el accept
			System.out.println("Cliente \"" + numeroCliente + "\" dice: \"" + entrada.readUTF() + "\"");

			// Se cierran recursos
			entrada.close();
			salida.close();
			socket.close();
		}

		System.out.println("Server Finalizado");
		servidor.close();
	}

	public static void main(String[] args) {
		try {
			new Servidor(20000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
