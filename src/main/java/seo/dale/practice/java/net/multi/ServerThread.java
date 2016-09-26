package seo.dale.practice.java.net.multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {

	private Socket socket;

	public ServerThread(Socket socket) {
		super("ReverseServerThread");
		this.socket = socket;
	}

	@Override
	public void run() {
		try (
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
		) {

			writer.println("Welcome to my server thread!");

			String inputLine, outputLine;
			while ((inputLine = reader.readLine()) != null) {
				System.out.println("[Server] Client : " + inputLine);
				if ("exit".equalsIgnoreCase(inputLine)) {
					break;
				}
				outputLine = new StringBuilder(inputLine).reverse().toString();
				System.out.println("[Server] Server : " + outputLine);
				writer.println(outputLine);
			}

			socket.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
