package seo.dale.practice.java.net.multi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer {

	public static void main(String[] args) {
		int port = 4444;
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("# Server Socket : " + socket);
				new ServerThread(socket).start();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
