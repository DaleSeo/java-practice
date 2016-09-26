package seo.dale.practice.java.net.multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try (
				Scanner scanner = new Scanner(System.in);
				Socket socket = new Socket("localhost", 4444);
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
				) {
			String inputLine, outputLine;
			while ((inputLine = reader.readLine()) != null) {
				System.out.println("# Client Socket : " + socket);
				System.out.println("[Client] Server : " + inputLine);
				outputLine = scanner.nextLine();
				System.out.println("[Client] Client : " + outputLine);
				writer.println(outputLine);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
